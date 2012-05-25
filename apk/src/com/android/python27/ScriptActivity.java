package com.android.python27;

import com.android.python27.config.GlobalConstants;
import com.android.python27.support.Utils;
import com.googlecode.android_scripting.FileUtils;

import java.io.File;
import java.io.InputStream;

import android.util.Log;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ScriptActivity extends Activity {
	Button buttonInstall;
	ProgressDialog myProgressDialog; 
	  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// mounted sdcard ?
		if (!Environment.getExternalStorageState().equals("mounted")) {
		  Log.e(GlobalConstants.LOG_TAG, "External storage is not mounted");
		  
		  Toast toast = Toast.makeText( getApplicationContext(), "External storage not mounted", Toast.LENGTH_LONG);
		  toast.show();
		  return;
		}
	  
		// install needed ?
    	boolean installNeeded = isInstallNeeded();
		
    	if(installNeeded) {
    		setContentView(R.layout.install);
    	     
    		buttonInstall = (Button)findViewById(R.id.startinstall);
    		buttonInstall.setOnClickListener(new Button.OnClickListener(){

    		@Override
    		public void onClick(View v) {
    		  new InstallAsyncTask().execute();
    		  buttonInstall.setClickable(false);
    		}});
    	}
    	else {
    	    runScriptService();
    	    finish();
    	}

		//onStart();
  }

	private void sendmsg(String key, String value) {
	      Message message = installerHandler.obtainMessage();
	      Bundle bundle = new Bundle();
	      bundle.putString(key, value);
	      message.setData(bundle);
	      installerHandler.sendMessage(message);
	   }
	    
	   final Handler installerHandler = new Handler() {
	   @Override
	   public void handleMessage(Message message) {
		        Bundle bundle = message.getData();
		        
		        if (bundle.containsKey("showProgressDialog")) {
		 	       myProgressDialog = ProgressDialog.show(ScriptActivity.this, "Installing", "Loading", true); 
		        }
		        else if (bundle.containsKey("setMessageProgressDialog")) {
		        	if (myProgressDialog.isShowing()) {
			        	myProgressDialog.setMessage(bundle.getString("setMessageProgressDialog"));
		        	}
		        }
		        else if (bundle.containsKey("dismissProgressDialog")) {
		        	if (myProgressDialog.isShowing()) {
			        	myProgressDialog.dismiss();
		        	}
		        }
		        else if (bundle.containsKey("installSucceed")) {
		  		  Toast toast = Toast.makeText( getApplicationContext(), "Install Succeed", Toast.LENGTH_LONG);
				  toast.show();
		        }
		        else if (bundle.containsKey("installFailed")) {
			  		  Toast toast = Toast.makeText( getApplicationContext(), "Install Failed. Please check logs.", Toast.LENGTH_LONG);
					  toast.show();
			    }
	       }
	   };
	   
	  public class InstallAsyncTask extends AsyncTask<Void, Integer, Boolean> {
		   @Override
		   protected void onPreExecute() {
		   }
	
		   @Override
		   protected Boolean doInBackground(Void... params) {	    
	    	Log.i(GlobalConstants.LOG_TAG, "Installing...");

	    	// show progress dialog
	    	sendmsg("showProgressDialog", "");

	    	sendmsg("setMessageProgressDialog", "Please wait...");
	    	createOurExternalStorageRootDir();
	
			// Copy all resources
			copyResourcesToLocal();
	
			// TODO
		    return true;
		   }
	
		   @Override
		   protected void onProgressUpdate(Integer... values) {
		   }
	
		   @Override
		   protected void onPostExecute(Boolean installStatus) {
	    	sendmsg("dismissProgressDialog", "");
	    	
	    	if(installStatus) {
		    	sendmsg("installSucceed", "");
	    	}
	    	else {
		    	sendmsg("installFailed", "");
	    	}
	    	
		    runScriptService();
		    finish();
		   }
	   
	  }
	
  private void runScriptService() {
	  startService(new Intent(this, ScriptService.class));
  }
  
	private void createOurExternalStorageRootDir() {
		Utils.createDirectoryOnExternalStorage( this.getPackageName() );
	}
	
	// quick and dirty: only test a file
	private boolean isInstallNeeded() {
		File testedFile = new File(this.getFilesDir().getAbsolutePath()+ "/" + GlobalConstants.PYTHON_MAIN_SCRIPT_NAME);
		if(!testedFile.exists()) {
			return true;
		}
		return false;
	}
	
	
	 private void copyResourcesToLocal() {
			String name, sFileName;
			InputStream content;
			
			R.raw a = new R.raw();
			java.lang.reflect.Field[] t = R.raw.class.getFields();
			Resources resources = getResources();
			
			boolean succeed = true;
			
			for (int i = 0; i < t.length; i++) {
				try {
					name = resources.getText(t[i].getInt(a)).toString();
					sFileName = name.substring(name.lastIndexOf('/') + 1, name.length());
					content = getResources().openRawResource(t[i].getInt(a));
					content.reset();

					// python project
					if(sFileName.endsWith(GlobalConstants.PYTHON_PROJECT_ZIP_NAME)) {
						succeed &= Utils.unzip(content, this.getFilesDir().getAbsolutePath()+ "/", true);
					}
					// python -> /data/data/com.android.python27/files/python
					else if (sFileName.endsWith(GlobalConstants.PYTHON_ZIP_NAME)) {
						succeed &= Utils.unzip(content, this.getFilesDir().getAbsolutePath()+ "/", true);
						FileUtils.chmod(new File(this.getFilesDir().getAbsolutePath()+ "/python/bin/python" ), 755);
					}
					// python extras -> /sdcard/com.android.python27/extras/python
					else if (sFileName.endsWith(GlobalConstants.PYTHON_EXTRAS_ZIP_NAME)) {
						Utils.createDirectoryOnExternalStorage( this.getPackageName() + "/" + "extras");
						Utils.createDirectoryOnExternalStorage( this.getPackageName() + "/" + "extras" + "/" + "tmp");
						succeed &= Utils.unzip(content, Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + this.getPackageName() + "/extras/", true);
					}
					
				} catch (Exception e) {
					Log.e(GlobalConstants.LOG_TAG, "Failed to copyResourcesToLocal", e);
					succeed = false;
				}
			} // end for all files in res/raw
			
	 }

  @Override
  protected void onStart() {
	  super.onStart();
	
	  String s = "System infos:";
	  s += " OS Version: " + System.getProperty("os.version") + "(" + android.os.Build.VERSION.INCREMENTAL + ")";
	  s += " | OS API Level: " + android.os.Build.VERSION.SDK;
	  s += " | Device: " + android.os.Build.DEVICE;
	  s += " | Model (and Product): " + android.os.Build.MODEL + " ("+ android.os.Build.PRODUCT + ")";
	  
	  Log.i(GlobalConstants.LOG_TAG, s);

	  //finish();
  }
  
}

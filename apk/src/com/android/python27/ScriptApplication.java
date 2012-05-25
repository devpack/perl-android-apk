package com.android.python27;

import com.android.python27.support.Utils;
import com.googlecode.android_scripting.BaseApplication;
import com.googlecode.android_scripting.interpreter.InterpreterConfiguration;
import com.googlecode.android_scripting.interpreter.InterpreterConfiguration.ConfigurationObserver;
import com.googlecode.android_scripting.interpreter.InterpreterConstants;

import java.util.concurrent.CountDownLatch;

public class ScriptApplication extends BaseApplication implements ConfigurationObserver {

//  private volatile boolean receivedConfigUpdate = false;
//  private final CountDownLatch mLatch = new CountDownLatch(1);

  @Override
  public void onCreate() {
//    mConfiguration = new InterpreterConfiguration(this);
//    mConfiguration.registerObserver(this);
//    mConfiguration.startDiscovering(InterpreterConstants.MIME + Utils.getFileExtension("foo.py"));
  } 

@Override
  public void onConfigurationChanged() {
//	receivedConfigUpdate = true;
//	mLatch.countDown();
  }

//  public boolean readyToStart() {
//
//    try {
//      mLatch.await();
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//
//    return receivedConfigUpdate;
//  }

}

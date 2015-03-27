## Tutorial on how to install the Android SDK and Eclipse ##

1. Download and install the JDK from Oracle's website: http://www.oracle.com/technetwork/java/javase/downloads/index.html

_If you already have the JDK installed, make sure you have the latest stable release and that it's updated._

2. Download and install Eclipse from Helios:
http://www.eclipse.org/downloads/

_If you already have Eclipse installed make sure you have the latest updates._

3. Download and install the Android SDK from Google's Android developer website: http://developer.android.com/sdk/index.html

_If you already have the Android SDK installed, make sure you have the latest updates._

4. Launch Eclipse. On startup it will ask you to create a working directory. Select a directory where to store your project files in.

5. Next install the ADT plugin for Eclipse as follows:
> a. Select `Help->Install New Software`. Click `Add` in the top-right corner.

> b. In the `Add Repository` dialog that appears, enter "ADT Plugin" for the Name and the following URL for the Location: https://dl-ssl.google.com/android/eclipse

> _If you have trouble acquiring the plugin, try using "http" in the Location URL, instead of "https" (https is preferred for security reasons)._

> c. In the `Available Software` dialog, select the checkbox next to `Developer Tools` and click `Next`. In the next window, you'll see a list of the tools to be downloaded. Click` Next`. Read and accept the license agreements, then click `Finish`. When the installation completes, restart Eclipse.

6. In Eclipse click `Window->Preferences->Android `and set the SDK location to where the SDK was installed (e.g., `C:\Program Files\Android\android-sdk-windows`).

7. Download and install Hg from Mercurial's website:
http://mercurial.selenic.com/wiki/Download

8. Now create a clone of the latest "perl-android-apk" repository:
> a. Use windows explorer to create a directory where you will store the clone files in.

> b. Hold down the shift key and right click on the directory, then open a command window. If that doesn't work, then go to your Start bar, select `Run`, and type `cmd`, and `cd` to the directory you created.

> c. In the command window type: `hg clone https://code.google.com/p/perl-android-apk` and wait for the files to be downloaded.

_Note: The repository may be updated regularly, so use `hg pull -u` to get updates from the repository periodically._

9. Finally, open Eclipse and click on `File->Import->General->Existing Projects into Workspace->Next` and browse to the cloned directory. Click on `apk->OK` then select all and click `Finish`.

Next, read the tutorial on how to use the APK template.
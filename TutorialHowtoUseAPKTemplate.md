## Tutorial: How to use the APK template ##

_Note: Please refer to the wiki tutorial on installing the Android SDK and Eclipse if you're not familiar with those._

The source code for embedding Python scripts and the Python interpreter are provided in the form of a template project that can be opened with Eclipse.

To get started, first download the "apk" template source code files from the Source tab. Then launch Eclipse and run `File->Import`. Browse to and select the "apk" folder on your system.

To run the demo example script (`hello.pl`), open the PerlAPK template, run `Project->clean` to generate `R.java` and delete any temporary build files, then select `Run` and chose your emulator or device to install the APK on.

In some versions of Eclipse, there might be a bug indicating that there's an error in the project. If you receive this, then:

Right click on the PerlAPK project and select `Build Path->Configure Build Path`, then under `Java Compiler->Building` make sure `Enable Project Specific Settings` is checked. Under `Build Path Problems` uncheck `Abort build when build path errors occur` or change `Incomplete build path` from Error to Warning. Click Apply and OK.

The red `X` icon appearing on the project in the Project Explorer window should have changed to a yellow `!` icon for a warning instead of an error. If it didn't, close and reopen the project (or restart Eclipse). On Windows, if you have a thumbnail file inside a build directory, you'll also see a red X over that directory which will prevent the build from occurring - just right click and delete the thumbnail file in that case.

After the APK is transferred to your emulator or device, you should see a `Install` button on it, if not check your applications and double click on `PerlAPK`. After you click "Install", the app will run and display a "Hello..." message.

To uninstall the demo app, just go to your device's `Settings->Applications->Manage Applications` and select `Forceclose` and `Uninstall`. Alternatively, from `adb` in your terminal, you can issue the command: `adb uninstall package_name` where `package_name` is found in the `GlobalConstants.java` file located in the `src/` directory.

Next, read the tutorial on how to add your Perl scripts to the template project.
**Embed a Perl for Android Interpreter into an APK:**

The objective of this project is to help people embed a custom Perl for Android interpreter along with their Perl scripts into a single APK that will not require the interpreter to be downloaded separately. It is forked from the [android-python27](http://code.google.com/p/android-python27/) project.

News:

6/20/12 - Perl 5.16 has recently been compiled for Android and will be hosted on the
[PerlDroid](http://code.google.com/p/perldroid/) project. The current working Perl build is 5.10, however this will be updated to Perl 5.16 once that is ready.


---

_Current status: Beta_

**Overview:**
_(Check the Wiki tutorials for more detailed instructions)_

The source code is separated in two parts:

**apk**: A Perl project template that will embed a Perl interpreter and your Perl scripts into an APK.

  * To use this template project in Eclipse, just go to `File->Import` and select the apk template folder. It's recommended that you then run `Project->clean` to generate `R.java`

  * Your Perl scripts should be collected and zipped into an archive, and then placed inside the `res/raw` directory. An example zip archive containing a main Perl script (`hello.pl`) is already in the `res/raw` directory, which can be replaced with a zip archive with the same name, or a different name (see the second to last bullet point below about naming).

  * The Perl interpreter, including all binaries and modules, should be zipped into an archive and also placed inside the `res/raw` directory. The template already has a zip archive containing the Perl interpreter in this directory, so you don't need to change this if your APK runs fine. You can add modules that are needed for your scripts or remove them just by editing the files in this zip archive, or you can use your own Perl build by replacing this zip archive with one containing your Perl build (see the last bullet point below about naming).

  * If you change the name of the main Perl script (`hello.pl`) or the name of the zip archive containing your Perl scripts, then in `src/GlobalConstants.java` change the values for: `Perl_MAIN_SCRIPT_NAME` and `PERL_PROJECT_ZIP_NAME` respectively.

  * If you change the name of the zip archive containing the Perl interpreter and the Perl extras, then in `src/GlobalConstants.java` change the values for: `PERL_NICE_NAME`, `PERL_ZIP_NAME`, and `PERL_EXTRAS_ZIP_NAME` respectively.

**perl-build**: (This is only needed if you want to compile the Perl for Android interpreter yourself - Perl is already compiled and will be installed with the `apk` source above)

  * This builds Perl for Android and creates `perl_r9.zip` and `perl_extras_r7.zip` archives to replace the ones located inside the `res/raw` directory. During the APK installation, these zip archives are unpacked into: `/data/data/your_package_name`, which is specified in `src/GlobalConstants.java` under `PACKAGE_NAME`
## Overview: How Perl scripts and the interpreter are embedded ##

Perl scripts and the Perl interpreter are zipped into archives and packaged in the APK. Upon installation, these archives are unpacked into a path on the Android device. The Perl interpreter is then exec'd to run the main Perl script, which can import other Perl scripts.

There is no need for the app to download a separate Perl interpreter since it's already packaged into the APK. The Perl scripts and the interpreter can also easily be modified by editing the zip archives, or upgraded by replacing the archives with different ones.
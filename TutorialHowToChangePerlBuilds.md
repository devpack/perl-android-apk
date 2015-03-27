## Tutorial: How to change Perl builds that are embedded into the APK ##

**Overview:**

Currently Perl 5.10 is supplied with the template project and embedded into the APK. This is located in the `res/raw` directory, which by default contains `perl_r9.zip` and `perl_extras_r7.zip`. During the installation of the APK, these archives are unpacked and used by the app to execute your scripts.

Modules can be added or removed from this archive, or the Perl build can be changed to update or revert to another Perl version. This is done by replacing the `perl_r9.zip` and `perl_extras_r7.zip` archives located in the `res/raw` directory.

**Naming:**

The default archive names for Perl 5.10 are: `perl_r9.zip` and `perl_extras_r7.zip`. If your zip archives are named differently, then you'll need to change the variables inside the `GlobalConstants.java` file located in `src/` respectively.

**Example:**

The default values in `GlobalConstants.java` are:
```
public static final String PERL_NICE_NAME = "Perl 5.10";
public static final String PERL_ZIP_NAME = "perl_r9.zip";
public static final String PERL_EXTRAS_ZIP_NAME = "perl_extras_r7.zip";
```

To change these to a new version, like Perl 5.15, change the values to:

```
public static final String PERL_NICE_NAME = "Perl 5.15;
public static final String PERL_ZIP_NAME = "perl_r15.zip";
public static final String PERL_EXTRAS_ZIP_NAME = "perl_extras_r15.zip";
```
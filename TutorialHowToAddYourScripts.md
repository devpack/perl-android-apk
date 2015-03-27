## Tutorial: How to add your Perl scripts: ##

**Overview:**
To embed your scripts, zip all your Perl script files into a single archive and place it in the `res/raw` directory.

**Naming:**
There is a demo archive provided with the template named `my_perl_project.zip` which contains a main Perl script named `hello.pl`. If you use a different name for your main Perl script, then in the `GlobalConstants.java` file located in `src/` change the value of the variable `PERL_MAIN_SCRIPT_NAME`. If you use a different name for your script archive, then change the value in the variable `PERL_PROJECT_ZIP_NAME`

**Example:**
The default values in the `GlobalConstants.java` file are:
```
public static final String PERL_MAIN_SCRIPT_NAME = "hello.pl";
public static final String PERL_PROJECT_ZIP_NAME = "my_perl_project.zip";
```

If the name of your main script is "my\_script.pl" and its archive zip name is "my\_script.zip", then the values in the `GlobalConstants.java` file should be changed to:
```
public static final String PERL_MAIN_SCRIPT_NAME = "my_script.pl";
public static final String PERL_PROJECT_ZIP_NAME = "my_script.zip";
```
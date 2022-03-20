/*

 This file is part of XleTView
 Copyright (C) 2003 Martin Sveden

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/
package xjava.lang;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Properties;

/**
 * Replaces java.lang.System for the Xlet
 * @author Martin Sveden
 */
public class System {

    /** Don't let anyone instantiate this class */
    private System() {
    }

    /*
     * Has to be public like in java.lang.System
     */
    public static Properties props;

    /**
     */
    public static InputStream in = null;

    /**
     */
    public static PrintStream out = null;

    /**
     */
    public static PrintStream err = null;

    static{
        initSystem();
    }

    /**
     * Initialize the system class.
     */
    private static void initSystem() {
        props = new Properties();
        initProperties(props);
        setIn(java.lang.System.in);


        /*try {
            OutputRedirector or = new OutputRedirector(new OutputServer(9999, System.out));
            PrintStream ps = new PrintStream(or);
            //setOut(ps);
            //setErr(ps);
        }
        catch (IOException e) {

            e.printStackTrace();
        }*/

        setOut(java.lang.System.out);
        setErr(java.lang.System.err);

        /*
         Uncomment to send the Xlet's output to a file
        try {
            File logFile = new File("application_out.txt");
            logFile.createNewFile();
            Log log = new Log(new File("application_out.txt"));
            PrintStream out = new PrintStream(log);
            setOut(out);
            setErr(out);
        }
        catch (IOException e) {
          setOut(java.lang.System.out);
          setErr(java.lang.System.err);
            e.printStackTrace();
        }
        */



    }

    /**
     * Reassigns the "standard" input stream.
     */
    public static void setIn(InputStream in) {
        System.in = in;
    }

    /**
     * Reassigns the "standard" output stream.
     */
    public static void setOut(PrintStream out) {
        System.out = out;
    }

    /**
     * Reassigns the "standard" error output stream.
     */
    public static void setErr(PrintStream err) {
        System.err = err;
    }

    public static void setSecurityManager(final SecurityManager s) {
        // fix
    }

    public static SecurityManager getSecurityManager() {
        // fix
        return null;
    }

    public static long currentTimeMillis() {
        return java.lang.System.currentTimeMillis();
    }

    public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length) {
        java.lang.System.arraycopy(src, srcPos, dest, destPos, length);
    }

    /**
     *
     */
    public static int identityHashCode(Object x) {
        return java.lang.System.identityHashCode(x);
    }

    /**
     * System properties. The following properties are guaranteed to be defined:
     * <dl>
     * <dt>java.version     <dd>Java version number
     * <dt>java.vendor      <dd>Java vendor specific string
     * <dt>java.vendor.url  <dd>Java vendor URL
     * <dt>java.home        <dd>Java installation directory
     * <dt>java.class.version   <dd>Java class version number
     * <dt>java.class.path  <dd>Java classpath
     * <dt>os.name      <dd>Operating System Name
     * <dt>os.arch      <dd>Operating System Architecture
     * <dt>os.version       <dd>Operating System Version
     * <dt>file.separator   <dd>File separator ("/" on Unix)
     * <dt>path.separator   <dd>Path separator (":" on Unix)
     * <dt>line.separator   <dd>Line separator ("\n" on Unix)
     * <dt>user.name        <dd>User account name
     * <dt>user.home        <dd>User home directory
     * <dt>user.dir     <dd>User's current working directory
     * </dl>
     */


    private static Properties initProperties(Properties props) {
        Properties real = java.lang.System.getProperties();
        props.setProperty("java.version", real.getProperty("java.version"));
        props.setProperty("java.vendor", real.getProperty("java.vendor"));

        /*
         * this one is not guaranteed to exist but I put it
         * here because there was applications at a broadcaster that use
         * it.
         */
        props.setProperty("java.vm.vendor", real.getProperty("java.vm.vendor"));

        props.setProperty("java.vendor.url", real.getProperty("java.vendor.url"));
        props.setProperty("java.home", real.getProperty("java.home"));
        props.setProperty("java.class.version", real.getProperty("java.class.version"));
        props.setProperty("java.class.path", real.getProperty("java.class.path"));
        props.setProperty("os.name", real.getProperty("os.name"));
        props.setProperty("os.arch", real.getProperty("os.arch"));
        props.setProperty("os.version", real.getProperty("os.version"));
        props.setProperty("file.separator", real.getProperty("file.separator"));
        props.setProperty("path.separator", real.getProperty("path.separator"));
        props.setProperty("line.separator", real.getProperty("line.separator"));
        props.setProperty("user.name", real.getProperty("user.name"));
        props.setProperty("user.home", real.getProperty("user.home"));
        props.setProperty("user.dir", real.getProperty("user.dir"));
        //props.list(java.lang.System.out);
        return props;
    }

    public static Properties getProperties() {
        return props;
    }

    public static void setProperties(Properties props) {
        if (props == null) {
            props = new Properties();
            initProperties(props);
        }
        System.props = props;
    }

    public static String getProperty(String key) {
        if (key == null) {
            throw new NullPointerException("key can't be null");
        }
        if (key.equals("")) {
            throw new IllegalArgumentException("key can't be empty");
        }
        return props.getProperty(key);
    }

    public static String getProperty(String key, String def) {
        if (key == null) {
            throw new NullPointerException("key can't be null");
        }
        if (key.equals("")) {
            throw new IllegalArgumentException("key can't be empty");
        }
        return props.getProperty(key, def);
    }

    public static String setProperty(String key, String value) {
        if (key == null) {
            throw new NullPointerException("key can't be null");
        }
        if (key.equals("")) {
            throw new IllegalArgumentException("key can't be empty");
        }
        return (String) props.setProperty(key, value);
    }

    public static String getenv(String name) {
        throw new Error("getenv no longer supported, use properties and -D instead: " + name);
    }

    /*
     11.3.1.1 java.lang package
     The java.lang package is supported with the following modi?cations.
     a) The following methods shall always throw a SecurityException when called by inter-operable applications:
     Runtime.exec,
     Runtime.load,
     Runtime.loadLibrary,
     System.exit,
     System.load,
     System.loadLibrary,
     */
    public static void exit(int status) {
        throw new SecurityException("see spec 11.3.1.1");
    }

    public static void gc() {
        // check the MHP spec
        Runtime.getRuntime().gc();
    }

    public static void runFinalization() {
        // check the MHP spec
        //Runtime.getRuntime().runFinalization();
    }

    public static void runFinalizersOnExit(boolean value) {
        //Runtime.getRuntime().runFinalizersOnExit(value);
    }

    /*
    11.3.1.1 java.lang package
    The java.lang package is supported with the following modi?cations.
    a) The following methods shall always throw a SecurityException when called by inter-operable applications:
       Runtime.exec,
       Runtime.load,
       Runtime.loadLibrary,
       System.exit,
       System.load,
       System.loadLibrary,
    */
    public static void load(String filename) {
        throw new SecurityException("see spec 11.3.1.1");
    }

    /*
     11.3.1.1 java.lang package
     The java.lang package is supported with the following modi?cations.
     a) The following methods shall always throw a SecurityException when called by inter-operable applications:
     Runtime.exec,
     Runtime.load,
     Runtime.loadLibrary,
     System.exit,
     System.load,
     System.loadLibrary,
     */
    public static void loadLibrary(String libname) {
        throw new SecurityException("see spec 11.3.1.1");
    }

    public static String mapLibraryName(String libname) {
        // check MHP spec
        return java.lang.System.mapLibraryName(libname);
    }

}

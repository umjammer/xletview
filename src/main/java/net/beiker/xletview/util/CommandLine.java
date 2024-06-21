package net.beiker.xletview.util;

import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.List;
import java.lang.System.Logger;

import static java.lang.System.getLogger;


/**
 * @author Martin Sveden
 */
public class CommandLine {

    /** Debugging facility. */
    private final static Logger logger = getLogger(CommandLine.class.getName());

    public static final int EXIT = -1;
    public static final int XLET_IS_SET = 1;
    public static final String EOL = System.lineSeparator();
    private static String xPath;
    private static final List<String> xExtraPaths = new ArrayList<>();
    private static String xName;

    public static int check(String[] args) {
        int result = 0;
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
//            System.out.println("-----------");
//            System.out.println(arg);
            if (arg.trim().indexOf("-") == 0) {
//                if (i == args.length - 1) {
//                    System.out.println("Error on command line!");
//                    break;
//                }
                if (arg.contains("-h") || arg.contains("-help") || arg.contains("-?")) {
                    String help = "Command line options:" + EOL +
                            "-h, -?, -help" + EOL +
                            "Shows this message" + EOL +
                            EOL +
                            "-xletPath <PATH> [-xletExtraPath <PATH>] -xletClass <XLET>" + EOL +
                            "Starts XleTView with an Xlet with the specified path and name." + EOL +
                            "PATH can also be an URL. PATH does not end in a trailing slash or backslash." + EOL +
                            "Multiple -xletExtraPath options can be given.";

                    System.out.println(help);
                    result = EXIT;
                } else if (arg.contains("-version")) {
                    String version = "XleTView, version" + Constants.VERSION;
                    System.out.println(version);
                    System.exit(0);
                } else if (arg.contains("xletPath")) {
                    xPath = args[++i].trim();
                } else if (arg.contains("xletExtraPath")) {
                    String xExPath = args[++i].trim();
                    CommandLine.xExtraPaths.add(xExPath);
                    logger.log(Level.DEBUG, "Added extra path '" + xExPath + "'.");
                } else if (arg.contains("xletClass")) {
                    xName = args[++i].trim();
                }
            }
        }
        if (xPath != null && xName != null) {
            result = XLET_IS_SET;
        }
        return result;
    }

    public static String getXletPath() {
        return xPath;
    }

    public static String[] getXletExtraPaths() {
        String[] paths = new String[CommandLine.xExtraPaths.size()];
        xExtraPaths.toArray(paths);
        return paths;
    }

    public static String getXletName() {
        return xName;
    }
}

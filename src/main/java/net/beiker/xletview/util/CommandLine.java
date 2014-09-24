package net.beiker.xletview.util;

import java.util.Vector;

import net.beiker.cake.Log;
import net.beiker.cake.Logger;

/**
 *
 * @author Martin Sveden
 */
public class CommandLine {

	/** Debugging facility. */
	private final static Logger logger = Log.getLogger(CommandLine.class);
	
	public static final int EXIT = -1;
	public static final int XLET_IS_SET = 1;
	private static String xPath;
	private static final Vector xExtraPaths = new Vector();
	private static String xName;

	public static int check(String[] args){
		int result = 0;
		for (int i = 0; i < args.length; i++) {
			String arg = args[i];
			//System.out.println("-----------");
			//System.out.println(arg);
			if (arg.trim().indexOf("-") == 0) {
				/*if (i == args.length - 1) {
				 System.out.println("Error on command line!");
				 break;
				 }*/
				if(arg.indexOf("-h") != -1 || arg.indexOf("-help") != -1 || arg.indexOf("-?") != -1){
					String help = "Command line options:" + System.getProperty("line.separator") +
					"-h, -?, -help" + System.getProperty("line.separator") +
					"Shows this message" + System.getProperty("line.separator") +
					System.getProperty("line.separator") +
					"-xletPath <PATH> [-xletExtraPath <PATH>] -xletClass <XLET>" + System.getProperty("line.separator") +
					"Starts XleTView with an Xlet with the specified path and name." + System.getProperty("line.separator") +
					"PATH can also be an URL. PATH does not end in a trailing slash or backslash." + System.getProperty("line.separator") +
					"Multiple -xletExtraPath options can be given.";

					System.out.println(help);
					result = EXIT;
				}
				else if(arg.indexOf("-version") != -1){
					String version = "XleTView, version" + Constants.VERSION;
					System.out.println(version);
					System.exit(0);
				}
				else if (arg.indexOf("xletPath") != -1) {
					xPath = args[++i].trim();
				}
				else if (arg.indexOf("xletExtraPath") != -1) {
					String xExPath = args[++i].trim();
					CommandLine.xExtraPaths.add(xExPath);
					logger.debug("Added extra path '"+xExPath+"'.");
				}
				else if (arg.indexOf("xletClass") != -1) {
					xName = args[++i].trim();
				}

			}
		}
		if(xPath != null && xName != null){
			result = XLET_IS_SET;
		}
		return result;
	}
	


	public static String getXletPath(){
		return xPath;
	}

	public static String[] getXletExtraPaths(){
		String[] paths = new String[CommandLine.xExtraPaths.size()];
		xExtraPaths.toArray(paths);		
		return paths;
	}
	
	public static String getXletName(){
		return xName;
	}

	
}

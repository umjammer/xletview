package xjava.io;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Hashtable;
import java.util.Vector;


/**
 * 
 * @author Martin Sveden
 */
public class FileSystem {

	private static final net.beiker.cake.Logger log = net.beiker.cake.Log.getLogger(FileSystem.class);
	
		
	static final char separatorChar = '/';
	
	static final char pathSeparatorChar = java.io.File.pathSeparatorChar;
	
	private static EmulatorFile[] roots;
	
	private static EmulatorFile mpDsmcc;
	
	/*
	 * The the current MountPoint
	 */
	private static EmulatorFile currentMountPoint;
	private static EmulatorFile previousMountPoint;
	
	private static final Hashtable files = new Hashtable();
		
	static{
		roots = new EmulatorFile[1];
		//roots[0] = new MountPoint("", new java.io.File("filesystem"));
		roots[0] = EmulatorFile.getRoot();

//		currentMountPoint = mpDsmcc;
		
	}
	
	
	private FileSystem(){		
	}
	

//	/**
//	 * Mounts a MountPoint to the carousel mount point.
//	 * @param mp The MountPoint to be mounted
//	 */
//	public synchronized static void mountCarousel(CarouselMountPoint mp){		
//		
//		currentMountPoint = mp;
//		
//		// mount the mount point
//		mpDsmcc.mount(mp);
//	}
	public synchronized static EmulatorFile mountCarousel(String name, java.io.File dir){		
		roots[0].removeAllChildren();
		currentMountPoint = new EmulatorFile(name, dir);
//		
		return currentMountPoint;
	}
		
	
	char getSeparatorChar() {		
		return separatorChar;
	}

	char getPathSeparatorChar() {
		return pathSeparatorChar;
	}

	static String fixPath(String path) {		
		
		String result = "";
		
		// remove initial "./"
		if(path.startsWith("./")){
			path = path.substring(2);
		}
		
		
		log.debug("fixPath incoming=" + path);
		
		result = path.replaceAll("\\\\", "\\/");
		result = result.replaceAll("\\//", "\\/");
		
		log.debug("fixPath outgoing=" + result);
		
		return result;
		
	}


	int prefixLength(String path) {
		// TODO Auto-generated method stub
		log.todo("prefixLength");
		return 0;
	}

	/**
	 * Returns the path which is the added path from mount point + parent + child
	 * @param mp
	 * @param parent
	 * @param child
	 * @return
	 */
	static String resolvePath(String parent, String child) {
		log.debug("resolvePath(" + parent + ", " + child + ")");
		String result = parent + separatorChar + child;
		result = fixPath(result);
		return result;
	}


	/**
	 * Resolves the absolute path, returns null if it turns
	 * out that the path is above root level
	 * @return 
	 */
	static String resolveAbsolutePath(String parent, String child) {
		log.debug("resolveAbsolutePath(" + parent + ", " + child + ")");
		String fullPath = "";

		if(parent == null){
			if(child.startsWith("" + separatorChar)){
				fullPath = child;	
			}
			else if(currentMountPoint != null){
				fullPath = currentMountPoint.getAbsolutePath() + separatorChar + child;	
			}			
			else{
				fullPath = separatorChar + child;
			}
		}
		else{
			if(parent.startsWith("" + separatorChar)){
				fullPath = parent + separatorChar + child;
			}
			else{
				fullPath = currentMountPoint.getAbsolutePath() + separatorChar + parent + separatorChar + child;	
			}
			
		}
		
		fullPath = fixPath(fullPath);
		String result = fullPath;
		log.debug("absolute path resolved");
		return result;
	}
//	
//	static String resolveParent(String path){
//		log.debug("resolveParent(" + path + ")");
//		String result = "";
//		
//		if(currentMountPoint != null){
//			String mpPath = currentMountPoint.getAbsolutePath();
//			String tmp = fixPath(mpPath + separatorChar + path);
//			
//			int index = tmp.lastIndexOf(separatorChar);
//			
//			if (index > 1) {
//				result = tmp.substring(0, index);
//			}
//			
//		}
//		
//		return result;
//	}
	

	String fromURIPath(String path) {
		// TODO Auto-generated method stub
		log.debug("fromURIPath");
		return null;
	}


	static boolean isAbsolute(File f) {		
		return (f.getPath().startsWith(separatorChar + ""));
	}
	
	static boolean isDirectory(java.io.File file){
		java.io.File f = null;
		try {
			f = getFile(file);
		} catch (FileNotFoundException e) {
		}
		return f != null && f.isDirectory();		
	}

	static boolean isFile(java.io.File file){
		java.io.File f = null;
		try {
			f = getFile(file);
		} catch (FileNotFoundException e) {
		}
		return f != null && f.isFile();		
	}
	
	static boolean isHidden(java.io.File file){
		java.io.File f = null;
		try {
			f = getFile(file);
		} catch (FileNotFoundException e) {
		}
		return f != null && f.isHidden();		
	}
	
	static long lastModified(java.io.File file){
		long result = 0;
		java.io.File f = null;
		try {
			f = getFile(file);
		} catch (FileNotFoundException e) {
		}
		if(f != null){
			result = f.lastModified();
		}
		return result;		
	}	

	static String getCanonicalPath(java.io.File file) throws IOException{
		String result = "";
		java.io.File f = getFile(file);
		if(f != null){
			result = f.getCanonicalPath();
		}
		return result;		
	}

	static java.io.File getCanonicalFile(java.io.File file) throws IOException{
		java.io.File result = null;
		java.io.File f = getFile(file);
		if(f != null){
			result = f.getCanonicalFile();
		}
		return result;		
	}
	
	static URL toURL(java.io.File file) throws MalformedURLException {
		URL result = null;
		java.io.File f = null;
		try {
			f = getFile(file);			
		} catch (FileNotFoundException e) {			
		}
		if(f != null){
			result = f.toURL();
		}
		
		log.debug("f=" + f);
		
		return result;		
	}
	
	static URI toURI(java.io.File file) {
		URI result = null;
		java.io.File f = null;
		try {
			f = getFile(file);
		} catch (FileNotFoundException e) {
		}
		if(f != null){
			result = f.toURI();
		}
		return result;		
	}
	
	static boolean canRead(java.io.File file){
		java.io.File f = null;
		try {
			f = getFile(file);
		} catch (FileNotFoundException e) {
		}
		return f != null && f.canRead();		
	}
	
	static boolean canWrite(java.io.File file){
		java.io.File f = null;
		try {
			f = getFile(file);
		} catch (FileNotFoundException e) {
		}
		return f != null && f.canWrite();		
	}
	

	int getBooleanAttributes(File f) {
		// TODO Auto-generated method stub
		log.debug("getBooleanAttributes");
		return 0;
	}


	boolean checkAccess(File f, boolean write) {
		// TODO Auto-generated method stub
		log.debug("checkAccess");
		return false;
	}


	long getLastModifiedTime(File f) {
		// TODO Auto-generated method stub
		log.debug("getLastModifiedTime");
		return 0;
	}

	
	static long getLength(java.io.File file) {
		long result = 0;
		java.io.File f = null;
		try {
			f = getFile(file);
		} catch (FileNotFoundException e) {
		}
		if(f != null){
			result = f.length();
		}
		return result;
	}


	boolean createFileExclusively(String pathname) throws IOException {
		// TODO Auto-generated method stub
		log.debug("createFileExclusively");
		return false;
	}


	boolean delete(File f) {
		// TODO Auto-generated method stub
		log.debug("delete");
		return false;
	}


	boolean deleteOnExit(File f) {
		// TODO Auto-generated method stub
		log.debug("deleteOnExit");
		return false;
	}


	static String[] list(java.io.File f) {
		
		String[] result = new String[0];
		
		EmulatorFile fp = getEmulatorFile(f);
		
		if(fp != null && fp.getRealFile().isDirectory()){
			
			Vector v = fp.getChildren();
			result   = new String[v.size()];
			for (int i = 0; i < result.length; i++) {
				EmulatorFile p = (EmulatorFile) v.get(i);
				result[i]   = p.getName();
			}
		
		}
		else{
			result = null;
		}
		
		return result;
	}


	boolean createDirectory(File f) {
		// TODO Auto-generated method stub
		log.debug("createDirectory");
		return false;
	}


	boolean rename(File f1, File f2) {
		// TODO Auto-generated method stub
		log.debug("rename");
		return false;
	}


	boolean setLastModifiedTime(File f, long time) {
		// TODO Auto-generated method stub
		log.debug("setLastModifiedTime");
		return false;
	}


	boolean setReadOnly(File f) {
		// TODO Auto-generated method stub
		log.debug("setReadOnly");
		return false;
	}


	static  java.io.File[] listRoots() {
		java.io.File[] result = new java.io.File[roots.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = new File(roots[i].getAbsolutePath());
		}
		return result;
	}


	int compare(File f1, File f2) {
		// TODO Auto-generated method stub
		log.debug("compare");
		return 0;
	}


	int hashCode(java.io.File f) {
		// TODO Auto-generated method stub
		log.debug("hashCode");
		return 0;
	}
	
	static boolean exists(java.io.File file){		
		java.io.File f = null;
		try {
			f = getFile(file);
		} catch (FileNotFoundException e) {
		}
		return f != null;
	}

	static EmulatorFile getEmulatorFile(java.io.File file){
		
		// start from the root
		EmulatorFile currentFile = roots[0];
		
		String absolutePath = file.getAbsolutePath();
		log.debug("checking if the file " + absolutePath + " exists...");
		String[] names = absolutePath.split("\\" + separatorChar);
		
		if(currentMountPoint != null){
			log.debug("currentMountPoint.getName()=" + currentMountPoint.getName());
		}
		
		
		
		// do the loop starting from index 1 because the first
		// position should always be empty when splitting like that
		
		for (int i = 0; i < names.length; i++) {
			if(i < 1){
				log.debug("skipping names[" + i + "] = _" + names[i] + "_");
				continue;
			}
			log.debug("names[" + i + "] = _" + names[i] + "_");
			currentFile = currentFile.getChild(names[i]);
			

			if(currentFile != null){
				log.debug(names[i] + " did exist");
			}
			else{
				log.debug(names[i] + " did NOT exist");
				break;
			}
			
		}
		
		return currentFile;
	}
	
	
	public static java.io.File getFile(String path) throws FileNotFoundException {
		return getFile(new XFile(path));
	}
	
	public static java.io.File getFile(java.io.File file) throws FileNotFoundException {
		java.io.File result = null;
		
		EmulatorFile fp = getEmulatorFile(file);
		
		log.debug("fp=" + fp);
		
		if(fp != null){
			result = fp.getRealFile();
		}
		
		if(result == null){
			throw new FileNotFoundException(file.getPath() + " (The system cannot find the file specified)");
		}
		
		return result;
		
	}
	
	public static java.io.File getFile(FileDescriptor fd){
		log.info("not implemented");
		return null;
	}
	
	
	public static void main(String[] args) {
		new FileSystem();
	}
	
	
	
}

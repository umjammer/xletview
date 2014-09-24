package xjava.io;

import java.io.IOException;
import java.util.Vector;

/**
 * 
 * @author Martin Sveden
 */
public class EmulatorFile {

	private static final net.beiker.cake.Logger log = net.beiker.cake.Log.getLogger(EmulatorFile.class);
	
	private static EmulatorFile ROOT = getRoot();
	
	private Vector children;
	
	private EmulatorFile parent;
	
	/*
	 * The name of this file
	 */
	private String name;
	
	/*
	 * The virtual absolute path
	 */
	private String absolutePath;
	
	/*
	 * The physical file we map to
	 */
	private java.io.File realFile;
	
	
	private EmulatorFile(){
		children = new Vector();
	}
	
	static EmulatorFile getRoot(){
		if(ROOT == null){
			ROOT = new EmulatorFile();
			ROOT.name = "";
			ROOT.absolutePath = "/";
		}
		return ROOT;
	}
	
	EmulatorFile(String name, java.io.File realFile){
		this();
		this.parent = ROOT;		
		this.name = name;
		this.realFile = realFile;
		
		this.absolutePath = FileSystem.separatorChar + name;
		
		java.io.File[] files = realFile.listFiles();
		if(files != null){
			for(int i = 0; i < files.length; i++){
//				addChild(new EmulatorFile(this, files[i]));
				new EmulatorFile(this, files[i]);
			}
		}
		parent.addChild(this);
	}
	
	EmulatorFile(EmulatorFile parent, java.io.File realFile) throws IllegalArgumentException {	
		this();
		if(parent == null || realFile == null || realFile.exists() == false){
			throw new IllegalArgumentException("the file did not exist");
		}
		
		this.parent = parent;		
		
		this.name = realFile.getName();
		this.realFile = realFile;						
		this.absolutePath = parent.getAbsolutePath() + FileSystem.separatorChar + realFile.getName();
		
		java.io.File[] files = realFile.listFiles();
		if(files != null){
			for(int i = 0; i < files.length; i++){
//				addChild(new EmulatorFile(this, files[i]));
				new EmulatorFile(this, files[i]);
			}
		}
		parent.addChild(this);
	}
	

	/**
	 * One file can only be added one time.
	 * @param file
	 */
	void addChild(EmulatorFile file){
		log.debug("addChild(" + file.getAbsolutePath() + ")");
		if(children.contains(file)){
			//log.debug("child already exist");
			try {
				throw new IOException("child already exist");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		children.add(file);

	}
	
	void removeChild(EmulatorFile file){
		children.remove(file);
	}
	
	void removeAllChildren(){
		children.setSize(0);
	}
	
//	void setParent(EmulatorFile parent){
//		this.parent = parent;
//	}
	
	EmulatorFile getParent(){
		return parent;
	}
	
	Vector getChildren(){
		return children;
	}
	
	EmulatorFile getChild(String name){
		EmulatorFile result = null;
		log.debug(this.name + ", children.size() = " + children.size());
		for(int i = 0; i < children.size(); i++){
			EmulatorFile ef = (EmulatorFile) children.get(i);
			String s = ef.getName();
			log.debug("checking in " + getName() + " if there is a child with the name " + name + ", child has name " + s);
			if(s.equals(name)){
				result = ef;
				break;
			}
		}
		
		return result;
	}
	
	public String getAbsolutePath(){
		return absolutePath;
	}
	
	public String getName(){
		return name;
	}
	
//	void setRealFile(java.io.File file){
//		realFile = file;
//	}
	
	java.io.File getRealFile(){
		return realFile;
	}
	
	
	
}

	


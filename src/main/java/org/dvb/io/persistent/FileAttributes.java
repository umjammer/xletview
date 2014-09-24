/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.io.persistent;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileAttributes {

	public static final int PRIORITY_LOW=1;

	public static final int PRIORITY_MEDIUM=2;

	public static final int PRIORITY_HIGH=3;
	
	FileAttributes(Date expiration_date, FileAccessPermissions p, int priority) {}

	public Date getExpirationDate() { return null; }
	
	public void setExpirationDate(Date d) { }
	
	public FileAccessPermissions getPermissions() { return null;}
	
	public void setPermissions(FileAccessPermissions p) {}

	public int getPriority() { return 0; }
	
	public void setPriority(int priority) {}

	public static void setFileAttributes(FileAttributes p, File f) throws IOException{
	}

	public static FileAttributes getFileAttributes(File f) throws IOException{
		return null;
	}
}

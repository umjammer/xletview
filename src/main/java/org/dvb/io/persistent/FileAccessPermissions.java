/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.io.persistent;


/**
 * 
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class FileAccessPermissions {
	
	private boolean readWorldAccessRight;
	private boolean writeWorldAccessRight;
	private boolean readOrganisationAccessRight;
	private boolean writeOrganisationAccessRight;
	private boolean readApplicationAccessRight;
	private boolean writeApplicationAccessRight;
	
	public FileAccessPermissions(boolean readWorldAccessRight, boolean writeWorldAccessRight, 
		boolean readOrganisationAccessRight, boolean writeOrganisationAccessRight,
		boolean readApplicationAccessRight, boolean writeApplicationAccessRight){ 
		
		this.readWorldAccessRight = readWorldAccessRight;
		this.writeWorldAccessRight = writeWorldAccessRight;
		this.readOrganisationAccessRight = readOrganisationAccessRight;
		this.writeOrganisationAccessRight = writeOrganisationAccessRight;
		this.readApplicationAccessRight = readApplicationAccessRight;
		this.writeApplicationAccessRight = writeApplicationAccessRight;
		
	}
	
	public boolean hasReadWorldAccessRight() { 
		return readWorldAccessRight;
	}
	
	public boolean hasWriteWorldAccessRight() {
		return writeWorldAccessRight;
	}
	
	public boolean hasReadOrganisationAccessRight() {
		return readOrganisationAccessRight;
	}
	
	public boolean hasWriteOrganisationAccessRight() {
		return writeOrganisationAccessRight;
	}
	
	public boolean hasReadApplicationAccessRight() {
		return readApplicationAccessRight;
	}
	
	public boolean hasWriteApplicationAccessRight() {
		return writeApplicationAccessRight;
	}
	
	public void setPermissions(boolean readWorldAccessRight, 
		boolean writeWorldAccessRight, boolean readOrganisationAccessRight, 
		boolean writeOrganisationAccessRight, boolean readApplicationAccessRight, 
		boolean writeApplicationAccessRight) {
		
		this.readWorldAccessRight = readWorldAccessRight;
		this.writeWorldAccessRight = writeWorldAccessRight;
		this.readOrganisationAccessRight = readOrganisationAccessRight;
		this.writeOrganisationAccessRight = writeOrganisationAccessRight;
		this.readApplicationAccessRight = readApplicationAccessRight;
		this.writeApplicationAccessRight = writeApplicationAccessRight;
	}
}

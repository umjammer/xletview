/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.mpeg.sections;

public class SectionFilterGroup implements 	org.davic.resources.ResourceProxy, org.davic.resources.ResourceServer{
 
	public SectionFilterGroup(int numberOfFilters){
	}
	
	public SectionFilterGroup(int numberOfFilters, boolean resourcePriority){
	}
 
	public SimpleSectionFilter newSimpleSectionFilter(){
		return null;
	}
 
	public SimpleSectionFilter newSimpleSectionFilter(int sectionSize){
		return null;
	}
 
	public RingSectionFilter newRingSectionFilter(int ringSize){
		return null;
	}
 
	public RingSectionFilter newRingSectionFilter(int ringSize, int  sectionSize){
		return null;
	}
 
	public TableSectionFilter newTableSectionFilter(){
		return null;
	}
 
	public TableSectionFilter newTableSectionFilter(int sectionSize){
		return null;
	}
 
	public void attach(org.davic.mpeg.TransportStream stream, org.davic.resources.ResourceClient client, Object requestData) throws FilterResourceException, InvalidSourceException, org.davic.mpeg.TuningException,org.davic.mpeg.NotAuthorizedException {
	}
 
	public void detach(){
	}
 
	public org.davic.mpeg.TransportStream getSource(){
		return null;
	}
 
	public org.davic.resources.ResourceClient getClient(){
		return null;
	}
 
	public void addResourceStatusEventListener (org.davic.resources.ResourceStatusListener listener){
	}
 
	public void removeResourceStatusEventListener (org.davic.resources.ResourceStatusListener listener){
	}

}

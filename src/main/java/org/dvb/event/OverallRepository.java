/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Sveden
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.event ;

/**
 * 
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class OverallRepository extends UserEventRepository {
    
    public OverallRepository(){
        this("OverallRepository"); 
    }
    
    public OverallRepository(String name){
        super(name); 
        this.addAllArrowKeys();
        this.addAllColourKeys();
        this.addAllNumericKeys();
    }

}

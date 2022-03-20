/*

 This file is part of XleTView
 Copyright (C) 2003 Martin Sveden

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.event ;

import org.davic.resources.ResourceClient;
import org.davic.resources.ResourceProxy;

/**
 *
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class RepositoryDescriptor implements ResourceProxy {

    private String repositoryName;
    private ResourceClient client;

   /*
    * There are no public constructors in the API
    */
    public RepositoryDescriptor (String repositoryName, ResourceClient client) {
        this.repositoryName = repositoryName;
        this.client = client;
    }

    public String getName () {
        return repositoryName;
    }

    public ResourceClient getClient() {
        return client;
    }

}




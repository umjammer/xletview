package org.dvb.lang;

import java.net.URL;


/**
 * @author Martin Sveden
 * @statuscode 4
 */
public class DVBClassLoaderImpl extends DVBClassLoader {

    /**
     * @param urls
     * @param parent
     */
    public DVBClassLoaderImpl(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    /**
     * @param urls
     */
    public DVBClassLoaderImpl(URL[] urls) {
        super(urls);
    }

}

/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.carousel;

import xjavax.tv.locator.InvalidLocatorException;
import xjavax.tv.locator.Locator;

/**
 * The <code>CarouselFile</code> class represents
 * file or directory data obtained from broadcast file systems.  An
 * instance of <code>CarouselFile</code> may be constructed from a
 * <code>Locator</code> instance or via constructors similar to those
 * of <code>java.io.File</code>.<p>
 *
 * Application classes implementing the
 * <code>CarouselFileListener</code> interface may subscribe with the
 * <code>CarouselFile</code> to receive notification of changes to the
 * file in the broadcast.  Upon the occurrence of a change, the
 * <code>CarouselFile</code> notifies subscribed
 * <code>CarouselFileListener</code> instances via
 * <code>CarouselFileChangeEvent</code> objects.<p>
 *
 * Successful instantiation of a <code>CarouselFile</code> object
 * causes its broadcast filesystem to be dynamically "mounted" in the
 * local filesystem.  The precise mount point can be determined by
 * calling <code>getCanonicalPath()</code> on the
 * <code>CarouselFile</code> instance representing the top-level
 * directory of the carousel.<p>
 *
 * Construction of a <code>CarouselFile</code> object causes its
 * contents to be loaded asynchronously from the broadcast stream.
 * Subsequent attempts to read the data of a <code>CarouselFile</code>
 * object will block until its contents are loaded.<p>
 *
 * Broadcast file data for which there are no remaining
 * <code>CarouselFile</code> instances or open file descriptors are
 * eligible for unloading from the cache.  Broadcast carousels for
 * which there are no remaining <code>CarouselFile</code> instances or
 * open file descriptors are eligible for unmounting from the local
 * filesystem.<p>
 *
 * Java TV API implementations that do not support broadcast
 * filesystem access will throw <code>IOException</code> upon any attempt
 * to construct a <code>CarouselFile</code> object.
 * <HR>
 *
 *
 */
public class CarouselFile extends java.io.File
{
    //following variables are implicitely defined by getter- or setter-methods:
    private Locator locator;

    /**
     * Creates a <code>CarouselFile</code> instance that represents the
     * file referenced by the given <code>Locator</code>.  Successful
     * construction of the <code>CarouselFile</code> instance causes the
     * referenced broadcast filesystem to be dynamically mounted in the
     * local filesystem.<p>
     *
     * This constructor throws <code>java.io.IOException</code> if it
     * determines immediately that the requested carousel file cannot
     * be accessed.  Since this constructor may complete its work
     * asynchronously, absence of an <code>IOException</code> is not a
     * guarantee that the requested carousel file is accessible.
     *
     * @param locator - A Locator referencing the source of the CarouselFile.
     * @throws InvalidLocatorException - If locator does not refer to a carousel file.
     * @throws java.io.IOException - If the requested carousel file cannot be accessed.
     */
    public CarouselFile( Locator locator) throws InvalidLocatorException, java.io.IOException
    {
        //TODO implement CarouselFile
        super("");
    }

    /**
     * Creates a <code>CarouselFile</code> instance that represents the
     * file whose absolute path name is the given path argument.
     * <p>
     *
     * This constructor throws <code>java.io.IOException</code> if it
     * determines immediately that the requested carousel file cannot
     * be accessed.  Since this constructor may complete its work
     * asynchronously, absence of an <code>IOException</code> is not a
     * guarantee that the requested carousel file is accessible.
     *
     * @param path - The absolute path name of the file.
     * @throws java.io.IOException - If the requested carousel file cannot be accessed.
     */
    public CarouselFile(java.lang.String path) throws java.io.IOException
    {
        //TODO implement CarouselFile
        super(path);
    }

    /**
     * Creates a <code>CarouselFile</code> instance that represents the
     * file with the specified name relative to the specified carousel
     * directory.  <p>
     *
     * This constructor throws <code>java.io.IOException</code> if it
     * determines immediately that the requested carousel file cannot
     * be accessed.  Since this constructor may complete its work
     * asynchronously, absence of an <code>IOException</code> is not a
     * guarantee that the requested carousel file is accessible.
     *
     * @param dir - The directory.
     * @param name - The name of the file, relative to dir.
     * @throws java.io.IOException - If the requested carousel file cannot be accessed.
     */
    public CarouselFile( CarouselFile dir, java.lang.String name) throws java.io.IOException
    {
        //TODO implement CarouselFile
        super(dir, name);
    }

    /**
     * Creates a <code>CarouselFile</code> instance that represents the
     * file with the specified name relative to the specified carousel
     * directory.  <p>
     *
     * This constructor throws <code>java.io.IOException</code> if it
     * determines immediately that the requested carousel file cannot
     * be accessed.  Since this constructor may complete its work
     * asynchronously, absence of an <code>IOException</code> is not a
     * guarantee that the requested carousel file is accessible.
     *
     * @param path - The absolute directory path name.
     * @param name - The name of the file, relative to path.
     * @throws java.io.IOException - If the requested carousel file cannot be accessed.
     */
    public CarouselFile(java.lang.String path, java.lang.String name) throws java.io.IOException
    {
        //TODO implement CarouselFile
        super("");
    }

    /**
     * Lists the directory contents of this <code>CarouselFile</code> object.
     * This list does not include the current or parent directories.
     *
     * @return An array of file names contained in the directory specified by this CarouselFile object.  If this CarouselFile object does not refer to a directory, this method returns null.
     * @throws java.io.IOException - If the directory cannot be accessed.
     * @throws java.lang.SecurityException - If a security manager exists and its java.lang.SecurityManager.checkRead(String) method denies read access to the file.
     */
    public java.lang.String[] listDirectoryContents() throws java.io.IOException, java.lang.SecurityException
    {
        return null;
        //TODO implement listDirectoryContents
    }

    /**
     * Subscribes a <code>CarouselFileListener</code> to receive
     * notifications of changes to this <code>CarouselFile</code>.  If
     * the specified listener is currently subscribed then no action is
     * performed.
     *
     * @param listener - The CarouselFileListener to be notified.
     * @throws java.io.IOException - If there are insufficient resources to support this listener.
     * @throws java.lang.SecurityException - If a security manager exists and its java.lang.SecurityManager.checkRead(String) method denies read access to the file.
     */
    public void addListener( CarouselFileListener listener) throws java.io.IOException, java.lang.SecurityException
    {
        //TODO implement addListener
    }

    /**
     * Unsubscribes a <code>CarouselFileListener</code> from receiving
     * notifications of changes to this <code>CarouselFile</code>.  If
     * the given <code>CarouselFileListener</code> is not currently
     * subscribed for notification then no action is performed.
     *
     * @param listener - A currently registered CarouselFileListener.
     */
    public void removeListener( CarouselFileListener listener)
    {
        //TODO implement removeListener
    }

    /**
     * Returns a <code>Locator</code> identifying this
     * <code>CarouselFile</code>.
     *
     * @return A Locator identifying this CarouselFile.
     */
    public Locator getLocator()
    {
        return this.locator;
    }

    /**
     * Requests that the cached contents of this <code>CarouselFile</code> be
     * updated with the version currently in the broadcast stream.  If the
     * <code>CarouselFile</code> data does not currently reside in the broadcast
     * stream, subsequent attempts to access its contents will fail.
     *
     * @throws java.lang.SecurityException - If a security manager exists and its java.lang.SecurityManager.checkRead(java.lang.String) method denies read access to the file.
     */
    public void refreshCache() throws java.lang.SecurityException
    {
        //TODO implement refreshCache
    }

}

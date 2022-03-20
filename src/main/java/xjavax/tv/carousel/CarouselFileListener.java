/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.carousel;

/**
 * The <code>CarouselFileListener</code> interface is implemented by
 * application classes which require notification of changes to
 * <code>CarouselFile</code> data.
 * <HR>
 *
 *
 */
public interface CarouselFileListener extends java.util.EventListener
{
    /**
     * Notifies the <code>CarouselFileListener</code> that the
     * <code>CarouselFile</code> has changed in the broadcast.
     *
     * If the contents of a <code>CarouselFile</code> change while an
     * application is reading its data from the local cache, the
     * cached data shall either (a) remain entirely unchanged or (b)
     * be flushed from the cache.  If the data is flushed from the
     * cache, attempts to read from this <code>CarouselFile</code>
     * using pre-existing file reading objects
     * (e.g. <code>FileInputStream</code>, <code>FileReader</code>, or
     * <code>RandomAccessFile</code>) will fail.
     *
     * <p> To read the new data, the application must create a new
     * file reading object.  To ensure that this data is the most recent
     * version from the broadcast, the application should first invoke
     * the <code>CarouselFile.refreshCache()</code> method.
     *
     * <p> No guarantees are provided concerning the ability of the
     * receiver to detect changes to the broadcast
     * <code>CarouselFile</code> or the latency of event notification
     * if a change is detected.
     *
     * @param event - Event indicating CarouselFile that has changed.
     * @see CarouselFile.refreshCache()
     */
    public void carouselFileChanged( CarouselFileChangeEvent event);

}

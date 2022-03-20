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
 * The <code>CarouselFileChangeEvent</code> provides notification of
 * a change to <code>CarouselFile</code> data.
 * <HR>
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class CarouselFileChangeEvent extends java.util.EventObject
{
    private CarouselFile carouselFile;

    /**
     * Creates a <code>CarouselFileChangeEvent</code> indicating that
     * the specified <code>CarouselFile</code> has changed.
     *
     * @param source - The CarouselFile whose contents have changed.
     */
    public CarouselFileChangeEvent( CarouselFile source){
        super(source);
    }

    /**
     * Reports the <code>CarouselFile</code> whose contents have changed.
     *
     * @return The CarouselFile whose contents have changed.
     */
    public CarouselFile getCarouselFile(){
        return this.carouselFile;
    }

}

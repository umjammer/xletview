/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.media;

/**
 * <code>AWTVideoSize</code> is a data holder that represents the position,
 * scaling, and clipping of a JMF Player, as controlled via an
 * AWTVideoSizeControl. All coordinates are expressed in the same coordinate
 * space as AWT components. Because background video might be larger than the
 * addressable AWT area, some of the positions might be negative.
 *
 * <p>
 * An AWTVideoSize represents a transformation of video where the video is
 * first positioned, then scaled, and then clipped. A rectangle (in the
 * screen's coordinate system) of the source video is translated, scaled and
 * clipped to fit within a rectangle specified in the screen's coordinate
 * system.
 * <HR>
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class AWTVideoSize {
    private java.awt.Rectangle source;
    private java.awt.Rectangle destination;
    private float xScale;
    private float yScale;

    /**
     * Constructs a new <code>AWTVideoSize</code> instance. This <code>AWTVideoSize</code>
     * represents a transformation where the rectangle <code>source</code> in
     * the source video is scaled and clipped to be within the rectangle <code>dest</code>.
     *
     * <p>
     * The instance of AWTVideoSize created with this constructor will not
     * maintain a reference to either of the constructor's parameters.
     *
     * @param source -
     *            The rectangle representing the portion of the source video to
     *            display, in the coordinate system of the screen.
     * @param dest -
     *            The rectangle representing where the video is to be
     *            displayed, in the coordinate system of the screen.
     */
    public AWTVideoSize(java.awt.Rectangle source, java.awt.Rectangle dest) {
        this.source = source;
        this.destination = dest;
        try{
            xScale = destination.width / source.width;
            yScale = destination.height / source.height;
        }
        catch(ArithmeticException e){
            e.printStackTrace();
        }

    }

    /**
     * Return a copy of the rectangle representing the portion of the source
     * video to display, in the coordinate system of the screen.
     *
     * @return The source Rectangle.
     */
    public java.awt.Rectangle getSource() {
        return this.source;
    }

    /**
     * Return a copy of the rectangle representing where the video is to be
     * displayed, in the coordinate system of the screen.
     *
     * @return The destination Rectangle.
     */
    public java.awt.Rectangle getDestination() {
        return this.destination;
    }

    /**
     * Give the scaling factor applied to the video in the horizontal
     * dimension, i.e., <code>getDestination().width / getSource().width</code>.
     *
     * @return The horizontal scaling factor applied to the video.
     */
    public float getXScale() {
        return this.xScale;
    }

    /**
     * Give the scaling factor applied to the video in the vertical dimension,
     * i.e., <code>getDestination().height / getSource().height</code>.
     *
     * @return The vertical scaling factor applied to the video.
     */
    public float getYScale() {
        return this.yScale;
    }

    /**
     * Generates a hash code value for this <code>AWTVideoSize</code>. Two
     * <code>AWTVideoSize</code> instances for which <code>AWTVideoSize.equals()</code>
     * is <code>true</code> will have identical hash code values.
     *
     * @return The hashcode value for this AWTVideoSize.
     * @see hashCode in class java.lang.Object
     */
    public int hashCode() {
        return toString().hashCode();
    }

    /**
     * Compares this <code>AWTVideoSize</code> with the given object for
     * equality. Returns <code>true</code> if and only if the given object is
     * also of type <code>AWTVideoSize</code> and contains data members equal
     * to those of this <code>AWTVideoSize</code>.
     *
     * @param other -
     *            The object with which to test for equality.
     * @return true if the two AWTVideoSize instances are equal; false
     *         otherwise.
     * @see equals in class java.lang.Object
     */
    public boolean equals(java.lang.Object other) {
        boolean result = false;

        if(other instanceof AWTVideoSize){
            if(this.hashCode() == other.hashCode()){
                result = true;
            }
        }

        return result;
    }

    /**
     * Returns a string representation of this <code>AWTVideoSize</code> and
     * its values.
     *
     * @return A string representation of this object.
     * @see toString in class java.lang.Object
     */
    public java.lang.String toString() {
        String theSource = "source[x=" + source.x + ", y=" + source.y + ", width=" + source.width + ", height=" + source.height + "]";
        String theDestination = "destination[x=" + destination.x + ", y=" + destination.y + ", width=" + destination.width + ", height=" + destination.height + "]";
        String theXScale = "xScale=" + xScale;
        String theYScale = "yScale=" + yScale;
        String result = theSource + ", " + theDestination + ", " + theXScale + ", " + theYScale;
        return result;
    }

}

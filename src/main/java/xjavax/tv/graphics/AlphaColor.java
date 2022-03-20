/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.graphics;

/**
 * A class that allows a very simple, interoperable form of compositing. This
 * is achieved by setting an alpha value for alpha blending on a color. Higher
 * alpha values indicate greater opacity of the color; lower values indicate
 * greater transparency. The alpha value will be respected by all instances of
 * java.awt.Graphics given to applications.
 * <p>
 *
 * In the final composition between the graphics and video, the underlying
 * video stream will be alpha-blended with the AWT graphics plane using that
 * pixel's alpha value by default, i.e. <em>source
 * over</em> compositing will
 * be used between the video plane and the AWT graphics plane by default. This
 * behavior can be changed using other APIs, possibly APIs defined outside of
 * Java TV.
 * <p>
 *
 * This API supports up to 256 levels of alpha blending. However, an individual
 * graphics system may support fewer levels. Such systems will round the alpha
 * value specified in an <code>AlphaColor</code> constructor to some nearest
 * value when the <code>AlphaColor</code> instance is used, e.g. rounding to
 * the nearest implemented alpha value.
 * <p>
 *
 * Systems on which alpha blending is not supported will interpret alpha values
 * other than 255 as if they were 255 (opaque) instead.
 * <p>
 *
 * The actual color used in rendering will depend on finding the best match
 * given the color space available for a given output device.
 * <p>
 *
 * Within the AWT graphics plane, the actual compositing done will be
 * platform-dependent.
 * <HR>
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class AlphaColor extends java.awt.Color {


    /**
     * Creates an sRGB color with the specified red, green, blue, and alpha
     * values in the range [0.0 - 1.0].
     *
     * @param r -
     *            The red component.
     * @param g -
     *            The green component.
     * @param b -
     *            The blue component.
     * @param a -
     *            The alpha component.
     * @throws java.lang.IllegalArgumentException -
     *             If any of the input parameters are outside the range [0.0 -
     *             1.0].
     * @see Color.getRed(), Color.getGreen(), Color.getBlue(), getAlpha(),
     *      getRGB()
     */
    public AlphaColor(float r, float g, float b, float a) {
        super(r, g, b, a);
    }

    /**
     * Creates an sRGB color with the specified red, green, blue, and alpha
     * values in the range 0-255, inclusive.
     *
     * @param r -
     *            The red component.
     * @param g -
     *            The green component.
     * @param b -
     *            The blue component.
     * @param a -
     *            The alpha component.
     * @throws java.lang.IllegalArgumentException -
     *             If any of the input parameters are outside the range [0 -
     *             255].
     * @see Color.getRed(), Color.getGreen(), Color.getBlue(), getAlpha(),
     *      getRGB()
     */
    public AlphaColor(int r, int g, int b, int a) {
        super(r, g, b, a);
    }

    /**
     * Creates an sRGB color with the specified combined RGBA value consisting
     * of the alpha component in bits 24-31, the red component in bits 16-23,
     * the green component in bits 8-15, and the blue component in bits 0-7. If
     * the <code>hasAlpha</code> argument is <code>false</code>, alpha is
     * set to 255.
     *
     * @param argb -
     *            The combined ARGB components
     * @param hasAlpha -
     *            true if the alpha bits are to be used, false otherwise.
     * @see Color.getRed(), Color.getGreen(), Color.getBlue(), getAlpha(),
     *      getRGB()
     */
    public AlphaColor(int argb, boolean hasAlpha) {
        super(argb, hasAlpha);
    }

    /**
     * Constructs a new <code>AlphaColor</code> using the specified
     * java.awt.Color. If this color has no alpha value, alpha will be set to
     * 255 (opaque).
     *
     * @param c -
     *            the color
     */
    public AlphaColor(java.awt.Color c) {
        super(c.getRGB());
    }

    /**
     * Creates a brighter version of this color.
     * <p>
     *
     * Although brighter and darker are inverse operations, the results of a
     * series of invocations of these two methods may be inconsistent because
     * of rounding errors.
     *
     * @return A new AlphaColor object
     * @see brighter in class java.awt.Color
     * @see darker()
     */
    public java.awt.Color brighter() {
        return super.brighter();
    }

    /**
     * Creates a darker version of this color.
     * <p>
     *
     * Although brighter and darker are inverse operations, the results of a
     * series of invocations of these two methods may be inconsistent because
     * of rounding errors.
     *
     * @return A new AlphaColor object
     * @see darker in class java.awt.Color
     * @see brighter()
     */
    public java.awt.Color darker() {
        return super.darker();
    }

    /**
     * Determines whether another object is equal to this <code>AlphaColor</code>.
     * <p>
     *
     * The result is <code>true</code> if and only if the argument is not
     * <code>null</code> and is a <code>AlphaColor</code> object that has
     * the same red, green, blue and alpha values as this object.
     *
     * @param obj -
     *            The object to test for equality with this AlphaColor
     * @return true if the objects are the same; false otherwise.
     * @see equals in class java.awt.Color
     */
    public boolean equals(java.lang.Object obj) {
        boolean same = false;
        if (obj != null && obj instanceof AlphaColor) {
            AlphaColor alphaColor = (AlphaColor) obj;
            if (alphaColor.getRed() == this.getRed()) {
                if (alphaColor.getBlue() == this.getBlue()) {
                    if (alphaColor.getGreen() == this.getGreen()) {
                        if (alphaColor.getAlpha() == this.getAlpha()) {
                            same = true;
                        }
                    }
                }
            }
        }
        return same;
    }

    /**
     * Computes the hash code for this color.
     *
     * @return a hash code for this object.
     * @see hashCode in class java.awt.Color
     */
    public int hashCode() {
        return toString().hashCode();
    }

    /**
     * Reports the alpha value of this <code>AlphaColor</code> instance.
     *
     * @return The alpha value, in the range 0-255 inclusive.
     * @see getAlpha in class java.awt.Color
     * @see getRGB()
     */
    public int getAlpha() {
        return super.getAlpha();
    }

    /**
     * Returns the RGB value representing the color in the default sRGB
     * ColorModel. (Bits 24-31 are alpha, 16-23 are red, 8-15 are green, 0-7
     * are blue).
     *
     * @return The RGB value as an int.
     * @see getRGB in class java.awt.Color
     * @see ColorModel.getRGBdefault(), Color.getRed(), Color.getGreen(),
     *      Color.getBlue()
     */
    public int getRGB() {
        return super.getRGB();
    }

    /**
     * Creates a string that represents this <code>AlphaColor</code>.
     *
     * @return a representation of this color as a String object.
     * @see toString in class java.awt.Color
     */
    public java.lang.String toString() {
        return super.toString();
    }

}

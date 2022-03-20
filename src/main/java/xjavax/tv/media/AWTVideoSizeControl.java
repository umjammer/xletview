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
 * <code>AWTVideoSizeControl</code> allows setting clipping, scaling, and
 * translation of a video stream in a simple, interoperable way.  Not
 * all possible combinations of positioning will be supported, so this
 * interface provides a mechanism to discover how closely the
 * underlying platform will approximate a request for positioning.
 *
 * <p> All interactions via AWTVideoSizeControl happen in the
 * coordinate space of the screen.  For example, successfully setting
 * the video's position to the location reported by
 * <code>Component.getLocationOnScreen()</code> on the
 * <code>Xlet</code>'s root container will cause the upper left-hand
 * corner of the video and the root container to coincide.  <p> The
 * screen, in the context of AWT, is the area into which graphics
 * drawing operations are done.  Its size is given by
 * java.awt.Toolkit.getScreenSize(), and locations reported by
 * Component.getLocationOnScreen() are given in the screen's
 * coordinate system.<p>
 *
 * Instances of <code>AWTVideoSizeControl</code> may be obtained from
 * a JMF <code>Player</code> via the methods
 * <code>getControl(String)</code> and <code>getControls()</code>.
 * Note that a Java TV API implementation may not always or ever
 * support <code>AWTVideoSizeControl</code> for a given Player; in
 * such a case, the failure modes specified by the two aforementioned
 * methods will apply.
 * <CODE>java.awt.Component.getLocationOnScreen()</CODE>,
 * <CODE>Player</CODE></DL>
 * <HR>
 *
 *
 */
public interface AWTVideoSizeControl extends javax.media.Control
{
    /**
     * Reports the <code>AWTVideoSize</code> at which the Player is
     * currently operating.
     *
     * @return A copy of the JMF Player's current video size, in the AWT coordinate space.
     */
    public AWTVideoSize getSize();

    /**
     * Reports the default <code>AWTVideoSize</code> for this control.
     * For the background video plane, this will be the size that the
     * video would be presented at if no program had manipulated the
     * video size.
     *
     * @return The default AWTVideoSize.
     */
    public AWTVideoSize getDefaultSize();

    /**
     * Reports the size of the source video, in the screen's
     * coordinate system.
     *
     * @return The size of the source video.
     */
    public java.awt.Dimension getSourceVideoSize();

    /**
     * Sets the video size.  If the size provided cannot be supported
     * by the underlying platform, this method does nothing and
     * returns <code>false</code>.
     *
     * @param sz - The desired video size, in the AWT coordinate space.
     * @return true if the size was successfully changed; false if the platform is incapable of supporting the given size.
     * @see checkSize(AWTVideoSize)
     */
    public boolean setSize( AWTVideoSize sz);

    /**
     * Reports how closely the underlying platform can approximate a
     * desired video size.  If the underlying platform cannot support
     * the given size, this method gives the closest approximation
     * that the platform is capable of.
     *
     * @param sz - The desired video size.
     * @return The actual size that the platform would be able to set.
     */
    public AWTVideoSize checkSize( AWTVideoSize sz);

}

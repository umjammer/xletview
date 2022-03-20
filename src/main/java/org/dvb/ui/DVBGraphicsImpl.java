/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.ui;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

/**
 * An implementation of the abstract <code>DVBGraphics</code> class using
 * delegates to <code>Graphics2D</code>.
 * @see java.awt.Graphics2D
 *
 * @author Christian K&ouml;berl
 * @version $Revision: 1.6 $
 * @statuscode 4
 */
class DVBGraphicsImpl extends DVBGraphics
{
    private Graphics2D graphics2d;
    private DVBAlphaComposite dvbAlphaComposite;
    private static int[] availableCompositeRules = new int[] {
        DVBAlphaComposite.CLEAR,
        DVBAlphaComposite.DST_IN,
        DVBAlphaComposite.DST_OUT,
        DVBAlphaComposite.DST_OVER,
        DVBAlphaComposite.SRC,
        DVBAlphaComposite.SRC_IN,
        DVBAlphaComposite.SRC_OUT,
        DVBAlphaComposite.SRC_OVER
    };

    public DVBGraphicsImpl(Graphics2D graphics2d)
    {
        this.graphics2d = graphics2d;
        this.graphics2d.setComposite(AlphaComposite.SrcOver);
        dvbAlphaComposite = DVBAlphaComposite.getInstance(DVBAlphaComposite.SRC_OVER);
    }

    public DVBGraphicsImpl(Graphics graphics)
    {
        ClassLoader c1 = graphics.getClass().getClassLoader();
        ClassLoader c2 = Graphics2D.class.getClassLoader();
        this.graphics2d = (Graphics2D) graphics;
    }

    /**
     * @see org.dvb.ui.DVBGraphics#getAvailableCompositeRules()
     */
    public int[] getAvailableCompositeRules()
    {
        return availableCompositeRules;
    }

    /**
     * @see org.dvb.ui.DVBGraphics#getDVBComposite()
     */
    public DVBAlphaComposite getDVBComposite()
    {
        return dvbAlphaComposite;
    }

    /**
     * @see org.dvb.ui.DVBGraphics#setDVBComposite(org.dvb.ui.DVBAlphaComposite)
     */
    public void setDVBComposite(DVBAlphaComposite comp) throws UnsupportedDrawingOperationException
    {
        this.dvbAlphaComposite = comp;
        switch(comp.getRule())
        {
            case DVBAlphaComposite.CLEAR: graphics2d.setComposite(AlphaComposite.Clear); break;
            case DVBAlphaComposite.DST_IN: graphics2d.setComposite(AlphaComposite.DstIn); break;
            case DVBAlphaComposite.DST_OUT: graphics2d.setComposite(AlphaComposite.DstOut); break;
            case DVBAlphaComposite.DST_OVER: graphics2d.setComposite(AlphaComposite.DstOver); break;
            case DVBAlphaComposite.SRC: graphics2d.setComposite(AlphaComposite.Src); break;
            case DVBAlphaComposite.SRC_IN: graphics2d.setComposite(AlphaComposite.SrcIn); break;
            case DVBAlphaComposite.SRC_OUT: graphics2d.setComposite(AlphaComposite.SrcOut); break;
            case DVBAlphaComposite.SRC_OVER: graphics2d.setComposite(AlphaComposite.SrcOver); break;
            default: throw new UnsupportedDrawingOperationException(comp.toString());
        }
    }

    /**
     * @see java.awt.Graphics#getColor()
     */
    public Color getColor()
    {
        return graphics2d.getColor();
    }

    /**
     * @see java.awt.Graphics#setColor(java.awt.Color)
     */
    public void setColor(Color c)
    {
        graphics2d.setColor(c);
    }

    /**
     * @see java.awt.Graphics#dispose()
     */
    public void dispose()
    {
        graphics2d.dispose();
    }

    /**
     * @see java.awt.Graphics#setPaintMode()
     */
    public void setPaintMode()
    {
        try
        {
            this.setDVBComposite(DVBAlphaComposite.SrcOver);
        }
        catch (UnsupportedDrawingOperationException e)
        {
        }
    }

    /**
     * @see java.awt.Graphics#translate(int, int)
     */
    public void translate(int x, int y)
    {
        graphics2d.translate(x, y);
    }

    /**
     * @see java.awt.Graphics#clearRect(int, int, int, int)
     */
    public void clearRect(int x, int y, int width, int height)
    {
        graphics2d.clearRect(x, y, width, height);

    }

    /**
     * @see java.awt.Graphics#clipRect(int, int, int, int)
     */
    public void clipRect(int x, int y, int width, int height)
    {
        graphics2d.clipRect(x, y, width, height);
    }

    /**
     * @see java.awt.Graphics#drawLine(int, int, int, int)
     */
    public void drawLine(int x1, int y1, int x2, int y2)
    {
        graphics2d.drawLine(x1, y1, x2, y2);
    }

    /**
     * @see java.awt.Graphics#drawOval(int, int, int, int)
     */
    public void drawOval(int x, int y, int width, int height)
    {
        graphics2d.drawOval(x, y, width, height);
    }

    /**
     * @see java.awt.Graphics#fillOval(int, int, int, int)
     */
    public void fillOval(int x, int y, int width, int height)
    {
        graphics2d.fillOval(x, y, width, height);
    }

    /**
     * @see java.awt.Graphics#fillRect(int, int, int, int)
     */
    public void fillRect(int x, int y, int width, int height)
    {
        graphics2d.fillRect(x, y, width, height);
    }

    /**
     * @see java.awt.Graphics#setClip(int, int, int, int)
     */
    public void setClip(int x, int y, int width, int height)
    {
        graphics2d.setClip(x, y, width, height);
    }

    /**
     * @see java.awt.Graphics#copyArea(int, int, int, int, int, int)
     */
    public void copyArea(int x, int y, int width, int height, int dx, int dy)
    {
        graphics2d.copyArea(x, y, width, height, dx, dy);
    }

    /**
     * @see java.awt.Graphics#drawArc(int, int, int, int, int, int)
     */
    public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle)
    {
        graphics2d.drawArc(x, y, width, height, startAngle, arcAngle);
    }

    /**
     * @see java.awt.Graphics#drawRoundRect(int, int, int, int, int, int)
     */
    public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight)
    {
        graphics2d.drawRoundRect(x, y, width, height, arcWidth, arcHeight);
    }

    /**
     * @see java.awt.Graphics#fillArc(int, int, int, int, int, int)
     */
    public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle)
    {
        graphics2d.fillArc(x, y, width, height, startAngle, arcAngle);
    }

    /**
     * @see java.awt.Graphics#fillRoundRect(int, int, int, int, int, int)
     */
    public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight)
    {
        graphics2d.fillRoundRect(x, y, width, height, arcWidth, arcHeight);

    }

    /**
     * @see java.awt.Graphics#drawPolygon(int[], int[], int)
     */
    public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints)
    {
        graphics2d.drawPolygon(xPoints, yPoints, nPoints);
    }

    /**
     * @see java.awt.Graphics#drawPolyline(int[], int[], int)
     */
    public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints)
    {
        graphics2d.drawPolyline(xPoints, yPoints, nPoints);

    }

    /**
     * @see java.awt.Graphics#fillPolygon(int[], int[], int)
     */
    public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints)
    {
        graphics2d.fillPolygon(xPoints, yPoints, nPoints);
    }

    /**
     * @see java.awt.Graphics#setXORMode(java.awt.Color)
     */
    public void setXORMode(Color c1)
    {
        graphics2d.setXORMode(c1);
    }

    /**
     * @see java.awt.Graphics#getFont()
     */
    public Font getFont()
    {
        return graphics2d.getFont();
    }

    /**
     * @see java.awt.Graphics#setFont(java.awt.Font)
     */
    public void setFont(Font font)
    {
        graphics2d.setFont(font);
    }

    /**
     * @see java.awt.Graphics#create()
     */
    public Graphics create()
    {
        return DVBGraphics.getDVBGraphics(graphics2d.create());
    }

    /**
     * @see java.awt.Graphics#getClipBounds()
     */
    public Rectangle getClipBounds()
    {
        return graphics2d.getClipBounds();
    }

    /**
     * @see java.awt.Graphics#getClip()
     */
    public Shape getClip()
    {
        return graphics2d.getClip();
    }

    /**
     * @see java.awt.Graphics#setClip(java.awt.Shape)
     */
    public void setClip(Shape clip)
    {
        graphics2d.setClip(clip);
    }

    /**
     * @see java.awt.Graphics#drawString(java.lang.String, int, int)
     */
    public void drawString(String str, int x, int y)
    {
        graphics2d.drawString(str, x, y);
    }

    /**
     * @see java.awt.Graphics#drawString(java.text.AttributedCharacterIterator, int, int)
     */
    public void drawString(AttributedCharacterIterator iterator, int x, int y)
    {
        graphics2d.drawString(iterator, x, y);
    }

    /**
     * @see java.awt.Graphics#getFontMetrics(java.awt.Font)
     */
    public FontMetrics getFontMetrics(Font f)
    {
        return graphics2d.getFontMetrics(f);
    }

    /**
     * @see java.awt.Graphics#drawImage(java.awt.Image, int, int, int, int, int, int, int, int, java.awt.image.ImageObserver)
     */
    public boolean drawImage(
        Image img,
        int dx1,
        int dy1,
        int dx2,
        int dy2,
        int sx1,
        int sy1,
        int sx2,
        int sy2,
        ImageObserver observer)
    {
        if(img instanceof DVBBufferedImage)
            img = ((DVBBufferedImage) img).getImage();

        return graphics2d.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, observer);
    }

    /**
     * @see java.awt.Graphics#drawImage(java.awt.Image, int, int, int, int, java.awt.image.ImageObserver)
     */
    public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer)
    {
        if(img instanceof DVBBufferedImage)
            img = ((DVBBufferedImage) img).getImage();

        return graphics2d.drawImage(img, x, y, width, height, observer);
    }

    /**
     * @see java.awt.Graphics#drawImage(java.awt.Image, int, int, java.awt.image.ImageObserver)
     */
    public boolean drawImage(Image img, int x, int y, ImageObserver observer)
    {
        if(img instanceof DVBBufferedImage)
            img = ((DVBBufferedImage) img).getImage();

        return graphics2d.drawImage(img, x, y, observer);
    }

    /**
     * @see java.awt.Graphics#drawImage(java.awt.Image, int, int, int, int, int, int, int, int, java.awt.Color, java.awt.image.ImageObserver)
     */
    public boolean drawImage(
        Image img,
        int dx1,
        int dy1,
        int dx2,
        int dy2,
        int sx1,
        int sy1,
        int sx2,
        int sy2,
        Color bgcolor,
        ImageObserver observer)
    {
        if(img instanceof DVBBufferedImage)
            img = ((DVBBufferedImage) img).getImage();

        return graphics2d.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, bgcolor, observer);
    }

    /**
     * @see java.awt.Graphics#drawImage(java.awt.Image, int, int, int, int, java.awt.Color, java.awt.image.ImageObserver)
     */
    public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer)
    {
        if(img instanceof DVBBufferedImage)
            img = ((DVBBufferedImage) img).getImage();

        return graphics2d.drawImage(img, x, y, width, height, bgcolor, observer);
    }

    /**
     * @see java.awt.Graphics#drawImage(java.awt.Image, int, int, java.awt.Color, java.awt.image.ImageObserver)
     */
    public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer)
    {
        if(img instanceof DVBBufferedImage)
            img = ((DVBBufferedImage) img).getImage();
        return graphics2d.drawImage(img, x, y, bgcolor, observer);
    }

}

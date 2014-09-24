/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service.selection;

/**
 * <code>ServiceMediaHandler</code> represents an handler of service
 * components that are real time media sharing the same clock.  A
 * <code>ServiceMediaHandler</code> is associated with the
 * <code>Service</code> currently selected in the
 * <code>ServiceContext</code> from which it was obtained.
 * <A HREF="../../../../javax/tv/media/MediaSelectControl.html"><CODE>MediaSelectControl</CODE></A></DL>
 * <HR>
 * 
 * 
 */
public interface ServiceMediaHandler extends javax.media.Player, ServiceContentHandler
{
}

/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.EventListener;

import org.davic.resources.ResourceStatusEvent;
import org.davic.resources.ResourceStatusListener;
import org.havi.ui.event.HActionListener;
import org.havi.ui.event.HAdjustmentEvent;
import org.havi.ui.event.HAdjustmentListener;
import org.havi.ui.event.HBackgroundImageEvent;
import org.havi.ui.event.HBackgroundImageListener;
import org.havi.ui.event.HFocusListener;
import org.havi.ui.event.HItemEvent;
import org.havi.ui.event.HItemListener;
import org.havi.ui.event.HKeyListener;
import org.havi.ui.event.HScreenConfigurationEvent;
import org.havi.ui.event.HScreenConfigurationListener;
import org.havi.ui.event.HScreenLocationModifiedEvent;
import org.havi.ui.event.HScreenLocationModifiedListener;
import org.havi.ui.event.HTextEvent;
import org.havi.ui.event.HTextListener;

/**
 * 
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class HEventMulticaster implements
HBackgroundImageListener, HScreenConfigurationListener, HScreenLocationModifiedListener,
 java.awt.event.WindowListener, HActionListener, HAdjustmentListener, HFocusListener, HItemListener,
HTextListener, HKeyListener, ResourceStatusListener{
	
    protected final EventListener a, b;

    protected HEventMulticaster(EventListener a, EventListener b){
        this.a = a; this.b = b;
    }

    protected EventListener remove(EventListener oldl) {
        if (oldl == a)  return b;
        if (oldl == b)  return a;
        EventListener a2 = removeInternal(a, oldl);
        EventListener b2 = removeInternal(b, oldl);
        if (a2 == a && b2 == b) {
            return this;    // it's not here
        }
        return addInternal(a2, b2);
    }


    protected static EventListener addInternal(EventListener a, EventListener b) {
        if (a == null)  return b;
        if (b == null)  return a;
        return new HEventMulticaster(a, b);
    }

    protected static EventListener removeInternal(EventListener l, EventListener oldl) {
        if (l == oldl || l == null) {
            return null;
        } else if (l instanceof HEventMulticaster) {
            return ((HEventMulticaster)l).remove(oldl);
        } else {
            return l;        // it's not here
        }
    }

    public static HBackgroundImageListener add(HBackgroundImageListener a, HBackgroundImageListener b){
        return (HBackgroundImageListener)addInternal(a, b);
    }

    public static HBackgroundImageListener remove(HBackgroundImageListener l, HBackgroundImageListener oldl) {
        return (HBackgroundImageListener) removeInternal(l, oldl);
    }

    public static WindowListener add(WindowListener a, WindowListener b){
        return (WindowListener)addInternal(a, b);
    }

    public static WindowListener remove(WindowListener l, WindowListener oldl){
        return (WindowListener) removeInternal(l, oldl);
    }

    public static HScreenConfigurationListener add(HScreenConfigurationListener a, HScreenConfigurationListener b){
        return (HScreenConfigurationListener)addInternal(a, b);
    }

    //?
    public static HScreenConfigurationListener add(HScreenConfigurationListener a, HScreenConfigurationListener b, HScreenConfigTemplate tb){
        HScreenConfigurationListener cl = (HScreenConfigurationListener)addInternal(a, b);
        return cl;
    }

    public static HScreenConfigurationListener remove(HScreenConfigurationListener l, HScreenConfigurationListener oldl){
        return (HScreenConfigurationListener) removeInternal(l, oldl);
    }

    public static HScreenLocationModifiedListener add(HScreenLocationModifiedListener a, HScreenLocationModifiedListener b){
        return (HScreenLocationModifiedListener)addInternal(a, b);
    }

    public static HScreenLocationModifiedListener remove(HScreenLocationModifiedListener l, HScreenLocationModifiedListener oldl) {
        return (HScreenLocationModifiedListener) removeInternal(l, oldl);
    }

    public void imageLoaded(HBackgroundImageEvent  e){
        ((HBackgroundImageListener)a).imageLoaded(e);
        ((HBackgroundImageListener)b).imageLoaded(e);
    }

    public void imageLoadFailed(HBackgroundImageEvent  e){
        ((HBackgroundImageListener)a).imageLoadFailed(e);
        ((HBackgroundImageListener)b).imageLoadFailed(e);
    }

    public void report(HScreenConfigurationEvent  e){
        ((HScreenConfigurationListener)a).report(e);
        ((HScreenConfigurationListener)b).report(e);
    }

    public void report(HScreenLocationModifiedEvent   e){
        ((HScreenLocationModifiedListener)a).report(e);
        ((HScreenLocationModifiedListener)b).report(e);
    }

    public void windowOpened(WindowEvent e) {
        ((WindowListener)a).windowOpened(e);
        ((WindowListener)b).windowOpened(e);
    }

    public void windowClosing(WindowEvent e) {
        ((WindowListener)a).windowClosing(e);
        ((WindowListener)b).windowClosing(e);
    }

    public void windowClosed(WindowEvent e) {
        ((WindowListener)a).windowClosed(e);
        ((WindowListener)b).windowClosed(e);
    }

    public void windowIconified(WindowEvent e) {
        ((WindowListener)a).windowIconified(e);
        ((WindowListener)b).windowIconified(e);
    }

    public void windowDeiconified(WindowEvent e) {
        ((WindowListener)a).windowDeiconified(e);
        ((WindowListener)b).windowDeiconified(e);
    }

    public void windowActivated(WindowEvent e) {
        ((WindowListener)a).windowActivated(e);
        ((WindowListener)b).windowActivated(e);
    }

    public void windowDeactivated(WindowEvent e) {
        ((WindowListener)a).windowDeactivated(e);
        ((WindowListener)b).windowDeactivated(e);
    }

    public void actionPerformed(ActionEvent e) {
        ((ActionListener)a).actionPerformed(e);
        ((ActionListener)b).actionPerformed(e);
    }

    public void focusLost(FocusEvent e){
    	((FocusListener)a).focusLost(e);
        ((FocusListener)b).focusLost(e);
    }

    public void focusGained(FocusEvent e)  {
    	((FocusListener)a).focusGained(e);
        ((FocusListener)b).focusGained(e);
    }

    public void valueChanged(HAdjustmentEvent e){
        ((HAdjustmentListener)a).valueChanged(e);
        ((HAdjustmentListener)b).valueChanged(e);
    }

    public void selectionChanged(HItemEvent e){
        ((HItemListener)a).selectionChanged(e);
        ((HItemListener)b).selectionChanged(e);
    }

    public  void currentItemChanged(HItemEvent e) {
        ((HItemListener)a).currentItemChanged(e);
        ((HItemListener)b).currentItemChanged(e);
    }

    public void textChanged(HTextEvent e){
        ((HTextListener)a).textChanged(e);
        ((HTextListener)b).textChanged(e);
    }

    public void caretMoved(HTextEvent e){
        ((HTextListener)a).caretMoved(e);
        ((HTextListener)b).caretMoved(e);
    }

    public void keyTyped(KeyEvent e){
        ((KeyListener)a).keyTyped(e);
        ((KeyListener)b).keyTyped(e);
    }

    public void keyPressed(KeyEvent e){
        ((KeyListener)a).keyPressed(e);
        ((KeyListener)b).keyPressed(e);
    }

    public void keyReleased(KeyEvent e){
        ((KeyListener)a).keyReleased(e);
        ((KeyListener)b).keyReleased(e);
    }

    public static HTextListener add(HTextListener a, HTextListener b){
        return (HTextListener)addInternal(a, b);
    }

    public static HTextListener remove(HTextListener l, HTextListener oldl){
        return (HTextListener) removeInternal(l, oldl);
    }

    public static HItemListener add(HItemListener a, HItemListener b){
        return (HItemListener)addInternal(a, b);
    }

    public static HItemListener remove(HItemListener l, HItemListener oldl){
        return (HItemListener) removeInternal(l, oldl);
    }

    public static HFocusListener add(HFocusListener a, HFocusListener b){
        return (HFocusListener)addInternal(a, b);
    }

    public static HFocusListener remove(HFocusListener l, HFocusListener oldl){
        return (HFocusListener) removeInternal(l, oldl);
    }

    public static HAdjustmentListener add(HAdjustmentListener a, HAdjustmentListener b){
        return (HAdjustmentListener)addInternal(a, b);
    }

    public static HAdjustmentListener remove(HAdjustmentListener l, HAdjustmentListener oldl){
        return (HAdjustmentListener) removeInternal(l, oldl);
    }

    public static HActionListener add(HActionListener a, HActionListener b){
        return (HActionListener)addInternal(a, b);
    }

    public static HActionListener remove(HActionListener l, HActionListener oldl){
        return (HActionListener) removeInternal(l, oldl);
    }

    public static HKeyListener add(HKeyListener a, HKeyListener b){
        return (HKeyListener)addInternal(a, b);
    }

    public static HKeyListener remove(HKeyListener l, HKeyListener oldl){
        return (HKeyListener) removeInternal(l, oldl);
    }

    public void statusChanged(ResourceStatusEvent e) {
        ((ResourceStatusListener)a).statusChanged(e);
        ((ResourceStatusListener)b).statusChanged(e);
    }

    public static ResourceStatusListener add(ResourceStatusListener a, ResourceStatusListener b) {
        return (ResourceStatusListener)addInternal(a, b);
    }

    public static ResourceStatusListener remove(ResourceStatusListener l, ResourceStatusListener oldl){
        return (ResourceStatusListener) removeInternal(l, oldl);
    }
}






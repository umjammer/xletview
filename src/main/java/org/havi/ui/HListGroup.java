/*

This file is part of XleTView 
Copyright (C) 2003 Martin Sved?

This is free software, and you are 
welcome to redistribute it under 
certain conditions;

See LICENSE document for details.

*/


package org.havi.ui;

import java.awt.Dimension;
import java.util.Vector;

import org.havi.ui.event.HItemEvent;
import org.havi.ui.event.HItemListener;

import net.beiker.xletview.helper.HNavigableHelper;

/**
* 
* @author Cristian Suazo, Martin Sveden
* @statuscode 1
* 
*/
public class HListGroup extends HVisible implements HItemValue{
   
   public static final int ITEM_NOT_FOUND       = -1;
   public static final int ADD_INDEX_END        = -1;
   public static final int DEFAULT_LABEL_WIDTH  = -1;    
   public static final int DEFAULT_LABEL_HEIGHT = -2;    
   public static final int DEFAULT_ICON_WIDTH   = -3;    
   public static final int DEFAULT_ICON_HEIGHT  = -4;
           
   private HNavigableHelper helper;
   private HSound sound;
   private static HListGroupLook defaultLook = new HListGroupLook();
   private boolean multiSelection;
   private boolean selectionMode;
   
   // holds all HListElements
   private Vector items;
   
   private Dimension iconSize;
   private Dimension labelSize;
   private int orientation;
   
   // holds the HListElements that are selected
   private Vector selectedIndexes;
   
   // holds the index of the current item
   private int currentItemIndex;
   
   private Vector itemListeners;
   
   /**
    * The scroll position determines the first HListElement to be drawn when the HListGroupLook lays out the list.
    */
   private int scrollPosition;
   
   public HListGroup(){
   	this(null);
   }

   public HListGroup(HListElement[] items){
   	this(items,0,0,0,0);
   }

   public HListGroup(HListElement[] items, int x, int y, int width, int height){
       super(new  HListGroupLook(),x,y,width,height);
       
       this.items = new Vector();
       
       this.selectedIndexes = new Vector();
       
       this.setListContent(items);
       if (items != null){
       	currentItemIndex = 0;
       }
       else{
       	currentItemIndex = HListGroup.ITEM_NOT_FOUND;
       }       
       multiSelection = false;     
       selectionMode = false;
       
       itemListeners = new Vector();
         
       helper = new HNavigableHelper(this);
       helper.setGainFocusSound(null);
       helper.setLoseFocusSound(null);
       
       iconSize = new Dimension(DEFAULT_ICON_WIDTH, DEFAULT_ICON_HEIGHT);
       labelSize = new Dimension(DEFAULT_LABEL_WIDTH, DEFAULT_LABEL_HEIGHT);
       
       orientation = ORIENT_TOP_TO_BOTTOM;
       
       // selectionSound = null        
   }

   public void setLook(HLook hlook) throws HInvalidLookException{
   	if(hlook instanceof HListGroupLook){
   		super.setLook(hlook);
   	}
   	else{
   		throw new HInvalidLookException("HLook was not a org.havi.ui.HListGroupLook");
   	}
   }

   public static void setDefaultLook(HListGroupLook look){
   	HListGroup.defaultLook = look; 
   }

   public static HListGroupLook getDefaultLook(){
       return HListGroup.defaultLook;
   }

   public HListElement[] getListContent(){
       return (HListElement[]) this.items.toArray();
   }

   public void setListContent(HListElement[] elements){
   	
   	// check if any elements are selected
   	HListElement[] elms = getListContent();
   	for(int i=0; i < elms.length; i++){
   		 
   		// check if item is selected
   		if(selectedIndexes.contains(elms[i])){
   			
   			// create event
   		 	HItemEvent evt = new HItemEvent(this, HItemEvent.ITEM_SELECTION_CLEARED, null);
   		 	
   		 	// notify listeners
   		 	notifySelectionChanged(evt);
   		 	
   		 	break;
   		 }
   	}
   	
   	// remove previous
   	this.items.clear();
   	
   	// set the new elements
   	if(elements != null){
   		for (int i = 0; i < elements.length; i++) {
				
   			// make sure it's previously not selected
   			selectedIndexes.remove(elements[i]);
   			
   			// add it
   			items.add(elements[i]);
   			
			}
   	}
   }

   public void addItem(HListElement item, int index){
   	HListElement[] arr = {item};
   	addItems(arr, index);	    	
   }

   public void addItems(HListElement[] elements, int index){

   	// check if the given index is within the bounds
   	if(index < 0 || index >= items.size()){
   		throw new IndexOutOfBoundsException();
   	}
   	
   	for (int i = elements.length - 1; i >= 0  ; i--) {
   		items.add(index, elements[i]);
		}
   	
   	// check if current item has changed position.
   	if(currentItemIndex >= index){
   		currentItemIndex++;
   		
   		// create event and notify listeners about the change of current item. 
   		HItemEvent evt = new HItemEvent(this,HItemEvent.ITEM_SET_CURRENT, (HListElement) items.get(currentItemIndex));
   		notifyItemChangedEvent(evt);
   	}    	
   	
   }

   
   public HListElement getItem(int index){
   	
   	if(index < 0){
   		throw new IllegalArgumentException("index less than zero");
   	}
   	
       return (HListElement) this.items.get(index);
   }

   public int getIndex (HListElement item){
   	int index;
   	index = this.items.indexOf(item);
   	if (index < 0){
   		return HListGroup.ITEM_NOT_FOUND;
   	}
       return index;
   }

   public int getNumItems(){
       return this.items.size();
   }

   public HListElement removeItem(int index){
   	HListElement element = (HListElement) this.items.get(index);
   	
   	// check if element was in the list
   	if(element != null){
   		
   		// remove the element
   		boolean selectionChanged = selectedIndexes.remove(element);
   		
   		// notify if selection changed
   		if(selectionChanged){
   			HItemEvent evt = new HItemEvent(this, HItemEvent.ITEM_CLEARED, element);
   			notifySelectionChanged(evt);
   		}
   		
   		items.remove(index);

   	
       	// check if current index changed
       	if(index <= currentItemIndex){
       		
       		// check if the item removed was the 
       		// current item
       		if(index == currentItemIndex){
       			currentItemIndex = -1;
       		}
       		// the current index decrease
       		else{
       			currentItemIndex--;
       		}
       		
       		// tell the listeners that the current item is reset
       		HItemEvent evt = new HItemEvent(this, HItemEvent.ITEM_SET_CURRENT, getCurrentItem());
       		notifyItemChangedEvent(evt);
       	}
       	
   	}    	
   	
   	return element;
   }
   
   public void removeAllItems(){
   	this.items.clear();
   	this.selectedIndexes.clear();
   	currentItemIndex = -1;
   }

   public int getCurrentIndex(){
   	if(currentItemIndex > -1){
   		return currentItemIndex;
   	}
   	else{
   		return ITEM_NOT_FOUND;
   	}
   }

   
   public HListElement getCurrentItem(){
   	
   	return (HListElement) items.get(currentItemIndex);
   	
   }

   public boolean setCurrentItem(int index){    	
   
   	boolean result = true;
   	
   	if(index == currentItemIndex || (index < 0 || index >= items.size()  )  ){
   		result = false;
   	}
   	else{
   		currentItemIndex = index;
   	}
   	
   	return result;
   }

   public int[] getSelectionIndices(){
   	
   	// TODO: fix sorting
   	
       int[] result = new int[0];
   	for(int i = 0; i < selectedIndexes.size(); i++){
   		
   		int index = items.indexOf(selectedIndexes.get(i));
   		
   		if(index > -1){
   			int[] tmp = new int[result.length + 1];
   			System.arraycopy(result, 0, tmp, 0, result.length);
   			tmp[result.length] = index;
   			result = tmp;
   		}
   		
   	}
   	
   	
   	return result;
   }

   public HListElement[] getSelection(){    	
   	return (HListElement[]) selectedIndexes.toArray() ;
   }

   public void clearSelection(){
   	selectedIndexes.clear();
   }

   public int getNumSelected(){
       return selectedIndexes.size();
   }

   public boolean getMultiSelection(){
       return multiSelection;
   }

   public void setMultiSelection(boolean multi){
   	multiSelection = multi;
   }
   
   public void setItemSelected(int index, boolean sel){
   	
   	if(index < 0 || index >= items.size()){
   		throw new IllegalArgumentException("index " + index + " not valid");
   	}
   	
	    if (selectionMode){   	
	    	
	    	HListElement element = (HListElement) items.get(index);
	    	
	    	boolean alreadySelected = selectedIndexes.contains(element);
	    	
	    	if(sel && !alreadySelected){
	    		// only 1 element can be selected multiselection is false.
	    		if(!multiSelection){
	    			selectedIndexes.clear();
	    		}
	    		selectedIndexes.add(element);
	    		notifySelectionChanged(new HItemEvent(this, HItemEvent.ITEM_SELECTED, element));
	    		
	    	}
	    	else if(!sel && alreadySelected){
	    		
	    		selectedIndexes.remove(element);
	    		notifySelectionChanged(new HItemEvent(this, HItemEvent.ITEM_CLEARED, element));
	    		
	    	}
   	}
   
   }

   public boolean isItemSelected(int index){
   	
   	HListElement element = (HListElement) items.get(index);
   	
   	return selectedIndexes.contains(element);
   }

   public int getScrollPosition(){
   	
   	if(items.size() <= 0 || scrollPosition >= items.size()){
   		return ITEM_NOT_FOUND;
   	}
   	else{
   		return scrollPosition;	
   	}
   	
   }

   public void setScrollPosition(int index){
   	
   	if(index < 0 || index >= items.size()){
   		throw new IllegalArgumentException("index " + index + " not valid");
   	}
   	
   	scrollPosition = index;
   	
   } 
   public Dimension getIconSize(){    	
       return iconSize;
   }

   public void setIconSize(Dimension size){
   	iconSize = size;
   }

   public Dimension getLabelSize(){    	
       return labelSize;
   }

   public void setLabelSize(Dimension size){
   	labelSize = size;
   }

   public void setMove(int keyCode, HNavigable target){
       helper.setMove(keyCode, target);
   }

   public HNavigable getMove(int keyCode){
       return helper.getMove(keyCode);
   }

   public void setFocusTraversal(HNavigable up, HNavigable down, HNavigable left, HNavigable right){
       helper.setFocusTraversal(up, down, left, right);
   }

   public boolean isSelected(){
       return helper.isSelected();
   }

   public void setGainFocusSound(HSound sound){
       helper.setGainFocusSound(sound);
   }

   public void setLoseFocusSound(HSound sound){
       helper.setLoseFocusSound(sound);
   }

   public HSound getGainFocusSound(){
       return helper.getGainFocusSound();
   }

   public HSound getLoseFocusSound(){
       return helper.getLoseFocusSound();
   }

   public void addHFocusListener(org.havi.ui.event.HFocusListener l){
   	helper.addHFocusListener(l);
   }

   public void removeHFocusListener(org.havi.ui.event.HFocusListener l){
   	helper.removeHFocusListener(l);
   }

   public int[] getNavigationKeys(){
       return helper.getNavigationKeys();
   }
    
   public void processHFocusEvent(org.havi.ui.event.HFocusEvent evt){
       int state = getInteractionState();
   	int newState = helper.getHFocusEventResult(evt);
   	
   	if(state != newState){
   		setInteractionState(newState);
   	}
   }

   public int getOrientation(){
       return orientation;
   }

   public void setOrientation(int orient){
       orientation = orient;
   }

   public void addItemListener(org.havi.ui.event.HItemListener listener){
       itemListeners.add(listener);
   }

   public void removeItemListener(org.havi.ui.event.HItemListener listener){
       itemListeners.remove(listener);
   }
   
   public void setSelectionSound(HSound sound){
   	this.sound = sound;
   }
       
   public HSound getSelectionSound(){
       return sound;
   }

   public boolean getSelectionMode(){
       return selectionMode;
   }

   public void setSelectionMode(boolean edit){    	
   	if(isEnabled()){
   		selectionMode = edit;
   	}
   }

   public void processHItemEvent(org.havi.ui.event.HItemEvent evt){
   	
   	if(hasFocus()){
	    	
   		boolean oldMode = selectionMode;
       	
   		switch (evt.getID()) {
				case HItemEvent.ITEM_START_CHANGE :
					
						setSelectionMode(true);
			
					break;
				case HItemEvent.ITEM_END_CHANGE :
			
						setSelectionMode(false);
			
					break;
				default :
					break;
			}
   		
   		if(oldMode != getSelectionMode()){
   		
   			// send event if the selectionMode has changed
   			HItemEvent selectionChangedEvent = new HItemEvent(this, evt.getID(), evt.getSource());
   			notifySelectionChanged(selectionChangedEvent);
   		}
   		
   		if(selectionMode){
   			
   			// the item that might be changed
   			HListElement oldItem = getCurrentItem();
   			
   			switch (evt.getID()) {
					/*case HItemEvent.ITEM_SET_CURRENT :
						
						break;*/
					case HItemEvent.ITEM_SET_PREVIOUS :
						
						// 1. set the previous
						
						setCurrentItem(getCurrentIndex() - 1);
						
						
						break;
					case HItemEvent.ITEM_SET_NEXT :
						
						setCurrentItem(getCurrentIndex() + 1);
						
						break;					
				}
   			
   			// check if the current item is changed
   			if(oldItem != getCurrentItem()){
   				// event?

   				HItemEvent previousOrNextEvent = new HItemEvent(this, evt.getID(), oldItem);
   				
   				notifyItemChangedEvent(previousOrNextEvent);
   				
   				HItemEvent changedEvent = new HItemEvent(this, HItemEvent.ITEM_SET_CURRENT, evt.getSource());
   				
   				notifyItemChangedEvent(changedEvent);
   			}
   			
   		}
	    	
   	}
   	
   	
   }
   
   /**
    * Notifies the HItemListeners that the selection has changed.
    * @param event The event to send to the listeners.
    */
   private void notifySelectionChanged(HItemEvent event){
   	        
   	HItemListener[] arrListeners = new HItemListener[itemListeners.size()];
   	itemListeners.copyInto(arrListeners);
   	
   	
   	for(int i = 0; i < arrListeners.length; i++){
   		
   		arrListeners[i].selectionChanged(event);
   	
   	}
   
   }
   
   /**
    * Notifies the HItemListeners that the current item has changed.
    * @param event The event to send to the listeners.
    */
   private void notifyItemChangedEvent(HItemEvent event){
   	
   	HItemListener[] arrListeners = new HItemListener[itemListeners.size()];
   	itemListeners.copyInto(arrListeners);
   	
   	for(int i = 0; i < arrListeners.length; i++){
			
			arrListeners[i].currentItemChanged(event);
		
		}

   }
   
   
   public boolean isFocusTraversable(){    
   	/*
   	 * "Note that the java.awt.Component method isFocusTraversable 
   	 * shall always return true for a java.awt.Component implementing 
   	 * this interface."
   	 */
       return true;
   }
   
}

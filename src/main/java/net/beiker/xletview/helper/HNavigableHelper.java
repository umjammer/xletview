package net.beiker.xletview.helper;

import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.util.Enumeration;
import java.util.Hashtable;


import org.havi.ui.HEventMulticaster;
import org.havi.ui.HNavigable;
import org.havi.ui.HSound;
import org.havi.ui.HState;
import org.havi.ui.HVisible;
import org.havi.ui.event.HFocusEvent;
import org.havi.ui.event.HFocusListener;

import net.beiker.cake.Log;
import net.beiker.cake.Logger;

/**
 * 
 * @author Martin Sveden
 */
//public final class HNavigableHelper implements HNavigable{
public final class HNavigableHelper {
	
	private static final Logger log = Log.getLogger(HNavigableHelper.class);
		
	private Hashtable navTargets;
	private HSound gainFocusSound;
	private HSound loseFocusSound;
	transient HFocusListener hFocusListener;
	transient FocusListener focusListener;
	
	private HVisible hVisible;
	
	public HNavigableHelper(HVisible hVisible){
		this.hVisible = hVisible;
		
		/*
		 * Since the Component will not get focus unless there is
		 * a FocusListener registered we "secretly" add one.
		 * For keeping this a secret the HVisible needs to
		 * use our special getFocusListeners, that returns
		 * all FocusListener objects except this one.
		 * 
		 * make sure it is not registered before, like
		 * in subclasses that calls this constructor 
		 */		
		hVisible.addFocusListener(net.beiker.xletview.event.FocusListenerDummy.getInstance());
	}	
	
	/* (non-Javadoc)
	 * @see org.havi.ui.HNavigable#setMove(int, org.havi.ui.HNavigable)
	 */
	public void setMove(int keyCode, HNavigable target){
		if(navTargets == null){
			// create it
			navTargets = new Hashtable();
		}
		Integer code = new Integer(keyCode);
		// check if key already exist, if so, remove it
		if(navTargets.containsKey(code)){
			navTargets.remove(code);
		}
		// put the target, but only if target != null
		if(target != null){
			navTargets.put(code, target);
		}
	}

	/* (non-Javadoc)
	 * @see org.havi.ui.HNavigable#getMove(int)
	 */
	public HNavigable getMove(int keyCode){
		if(navTargets == null){
			return null;
		}
		else{
			Integer code = new Integer(keyCode);
			HNavigable nav = (HNavigable) navTargets.get(code);
			return nav;
		}
	}

	/* (non-Javadoc)
	 * @see org.havi.ui.HNavigable#setFocusTraversal(org.havi.ui.HNavigable, org.havi.ui.HNavigable, org.havi.ui.HNavigable, org.havi.ui.HNavigable)
	 */
	public void setFocusTraversal(HNavigable up, HNavigable down, HNavigable left, HNavigable right){
		setMove(KeyEvent.VK_UP   , up);
		setMove(KeyEvent.VK_DOWN , down);
		setMove(KeyEvent.VK_LEFT , left);
		setMove(KeyEvent.VK_RIGHT, right);
	}

	/* (non-Javadoc)
	 * @see org.havi.ui.HNavigable#isSelected()
	 */
	public boolean isSelected() {		
		return hVisible.hasFocus();
	}

	/* (non-Javadoc)
	 * @see org.havi.ui.HNavigable#setGainFocusSound(org.havi.ui.HSound)
	 */
	public void setGainFocusSound(HSound sound){
		gainFocusSound = sound;
	}

	/* (non-Javadoc)
	 * @see org.havi.ui.HNavigable#setLoseFocusSound(org.havi.ui.HSound)
	 */
	public void setLoseFocusSound(HSound sound){
		loseFocusSound = sound;
	}

	/* (non-Javadoc)
	 * @see org.havi.ui.HNavigable#getGainFocusSound()
	 */
	public HSound getGainFocusSound(){
		return gainFocusSound;
	}

	/* (non-Javadoc)
	 * @see org.havi.ui.HNavigable#getLoseFocusSound()
	 */
	public HSound getLoseFocusSound(){
		return loseFocusSound;
	}

	/* (non-Javadoc)
	 * @see org.havi.ui.HNavigable#addHFocusListener(org.havi.ui.event.HFocusListener)
	 */
	public synchronized void addHFocusListener(HFocusListener listener){
		if (listener == null) {
			return;
		}
		hFocusListener = HEventMulticaster.add(hFocusListener, listener);
		
		/*
		 * To make the AWT focus mechanism trigger a focus event
		 * on this Component it needs to have a FocusListener.
		 * So, we add a dummy.
		 */
//		if(hVisible.getFocusListeners().length == 0){
//			hVisible.addFocusListener(net.beiker.xletview.event.FocusListenerDummy.getInstance());
//		}
		
	}

	/* (non-Javadoc)
	 * @see org.havi.ui.HNavigable#removeHFocusListener(org.havi.ui.event.HFocusListener)
	 */
	public synchronized void removeHFocusListener(HFocusListener listener) {
		if (listener == null) {
			return;
		}
		hFocusListener = HEventMulticaster.remove(hFocusListener, listener);
		
		/*
		 * Remove the focus listener dummy
		 */
//		if(hVisible.getFocusListeners().length == 0){
//			hVisible.removeFocusListener(net.beiker.xletview.event.FocusListenerDummy.getInstance());
//		}
	}

	/* (non-Javadoc)
	 * @see org.havi.ui.HNavigationInputPreferred#getNavigationKeys()
	 */
	public int[] getNavigationKeys(){
		if(navTargets == null){
			return null;
		}
		else if(navTargets.size() == 0){
			return null;
		}
		else{
			int[] keyCodes = new int[navTargets.size()];
			Enumeration enum_ = navTargets.elements();
			int i = 0;
			while(enum_.hasMoreElements()){
				Integer integer = (Integer) enum_.nextElement();
				keyCodes[i] = integer.intValue();
				i++;
			}
			return keyCodes;
		}
	}

	/**
	 * 
	 * @param evt
	 * @return The new state
	 */
	public int getHFocusEventResult(HFocusEvent evt) {

		// get state
		int state = hVisible.getInteractionState(); 
		
		if(evt.getID() == FocusEvent.FOCUS_GAINED){
			
			// bitwise OR
			state = state | HState.FOCUSED_STATE_BIT;
			
			if(hFocusListener != null){
				hFocusListener.focusGained(evt);
			}
		}
		else if(evt.getID() == FocusEvent.FOCUS_LOST){            
			
			// bitwise XOR
			state = state ^ HState.FOCUSED_STATE_BIT;
			
			if(hFocusListener != null){
				hFocusListener.focusLost(evt);
			}
		}
		else if(evt.getID() == HFocusEvent.FOCUS_TRANSFER && evt.getTransferId() != HFocusEvent.NO_TRANSFER_ID){
			Integer navTarget = new Integer(evt.getTransferId());
			HNavigable newNav = (HNavigable)navTargets.get(navTarget);
			
			if(newNav instanceof Component){
				((Component)newNav).requestFocus();
				log.debug("requested focus on newNav");
			}    		
		}
		
		return state;
	}

	/**
	 * Since the Component will not get focus unless there is
	 * a FocusListener registered we "secretly" add one.
	 * For keeping this a secret the HVisible needs to
	 * use our special getFocusListeners, that returns
	 * all FocusListener objects except this one.
	 */
	public synchronized FocusListener[] getFocusListeners(){
		hVisible.removeFocusListener(net.beiker.xletview.event.FocusListenerDummy.getInstance());
		FocusListener[] listeners = (FocusListener[]) hVisible.getListeners(FocusListener.class);
		hVisible.addFocusListener(net.beiker.xletview.event.FocusListenerDummy.getInstance());
		return listeners;
//		FocusListener[] listeners = (FocusListener[]) hVisible.getListeners(FocusListener.class);
//		return listeners;
	}
	
//	/**
//	 * Overload!
//	 */
//	public void processHFocusEvent(HFocusEvent evt) {
//	}

	
}

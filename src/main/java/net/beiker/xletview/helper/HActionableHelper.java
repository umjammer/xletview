package net.beiker.xletview.helper;

import org.havi.ui.HEventMulticaster;
import org.havi.ui.HSound;
import org.havi.ui.HVisible;
import org.havi.ui.event.HActionListener;

/**
 *
 * @author Martin Sveden
 */
public class HActionableHelper {

    transient HActionListener hActionListener;
    private HSound actionSound;
    private String actionCommand;
    private HVisible hVisible;

    public HActionableHelper(HVisible hVisible) {
        this.hVisible = hVisible;
    }

    /* (non-Javadoc)
     * @see org.havi.ui.HActionable#addHActionListener(org.havi.ui.event.HActionListener)
     */
    public synchronized void addHActionListener(HActionListener listener) {
        if (listener == null) {
            return;
        }
        hActionListener = HEventMulticaster.add(hActionListener, listener);

    }

    /* (non-Javadoc)
     * @see org.havi.ui.HActionable#removeHActionListener(org.havi.ui.event.HActionListener)
     */
    public void removeHActionListener(HActionListener listener) {
        if (listener == null) {
            return;
        }
        hActionListener = HEventMulticaster.remove(hActionListener, listener);

    }

    /* (non-Javadoc)
     * @see org.havi.ui.HActionable#setActionCommand(java.lang.String)
     */
    public void setActionCommand(String command) {
        actionCommand = command;
    }

    /* (non-Javadoc)
     * @see org.havi.ui.HActionable#setActionSound(org.havi.ui.HSound)
     */
    public void setActionSound(HSound sound) {
        actionSound = sound;
    }

    /* (non-Javadoc)
     * @see org.havi.ui.HActionable#getActionSound()
     */
    public HSound getActionSound() {
        return actionSound;
    }

//    /* (non-Javadoc)
//     * @see org.havi.ui.HActionInputPreferred#processHActionEvent(org.havi.ui.event.HActionEvent)
//     */
//    public void processHActionEvent(HActionEvent evt) {
//        // TODO Auto-generated method stub
//
//    }

    public int getHActionEventResult(org.havi.ui.event.HActionEvent evt) {
        // get state
        int state = hVisible.getInteractionState();
        if(hActionListener != null){
            hActionListener.actionPerformed(evt);
        }

        return state;
    }

    /* (non-Javadoc)
     * @see org.havi.ui.HActionInputPreferred#getActionCommand()
     */
    public String getActionCommand() {
        return actionCommand;
    }



//    // stuff for HNavigable --------------->
//
//    /**
//     * Since the Component will not get focus unless there is
//     * a FocusListener registered we "secretly" add one in the
//     * helper.
//     * We don't want this secret one to be returned when someone
//     * asks for the FocusListener objects.
//     * This mehod overrides Component.getFocusListeners()
//     * and takes care of that.
//     */
//    public synchronized FocusListener[] getFocusListeners(){
//        return navHelper.getFocusListeners();
//    }
//
//    public int getHFocusEventResult(HFocusEvent evt) {
//        return navHelper.getHFocusEventResult(evt);
//    }
//
//    /* (non-Javadoc)
//     * @see org.havi.ui.HNavigable#setMove(int, org.havi.ui.HNavigable)
//     */
//    public void setMove(int keyCode, HNavigable target) {
//        navHelper.setMove(keyCode, target);
//    }
//
//    /* (non-Javadoc)
//     * @see org.havi.ui.HNavigable#getMove(int)
//     */
//    public HNavigable getMove(int keyCode) {
//        return navHelper.getMove(keyCode);
//    }
//
//    /* (non-Javadoc)
//     * @see org.havi.ui.HNavigable#setFocusTraversal(org.havi.ui.HNavigable, org.havi.ui.HNavigable, org.havi.ui.HNavigable, org.havi.ui.HNavigable)
//     */
//    public void setFocusTraversal(HNavigable up, HNavigable down, HNavigable left, HNavigable right) {
//        navHelper.setFocusTraversal(up, down, left, right);
//    }
//
//    /* (non-Javadoc)
//     * @see org.havi.ui.HNavigable#isSelected()
//     */
//    public boolean isSelected() {
//        return navHelper.isSelected();
//    }
//
//    /* (non-Javadoc)
//     * @see org.havi.ui.HNavigable#setGainFocusSound(org.havi.ui.HSound)
//     */
//    public void setGainFocusSound(HSound sound) {
//        navHelper.setGainFocusSound(sound);
//    }
//
//    /* (non-Javadoc)
//     * @see org.havi.ui.HNavigable#setLoseFocusSound(org.havi.ui.HSound)
//     */
//    public void setLoseFocusSound(HSound sound) {
//        navHelper.setLoseFocusSound(sound);
//    }
//
//    /* (non-Javadoc)
//     * @see org.havi.ui.HNavigable#getGainFocusSound()
//     */
//    public HSound getGainFocusSound() {
//        return navHelper.getGainFocusSound();
//    }
//
//    /* (non-Javadoc)
//     * @see org.havi.ui.HNavigable#getLoseFocusSound()
//     */
//    public HSound getLoseFocusSound() {
//        return navHelper.getLoseFocusSound();
//    }
//
//    /* (non-Javadoc)
//     * @see org.havi.ui.HNavigable#addHFocusListener(org.havi.ui.event.HFocusListener)
//     */
//    public void addHFocusListener(HFocusListener listener) {
//        navHelper.addHFocusListener(listener);
//    }
//
//    /* (non-Javadoc)
//     * @see org.havi.ui.HNavigable#removeHFocusListener(org.havi.ui.event.HFocusListener)
//     */
//    public void removeHFocusListener(HFocusListener listener) {
//        navHelper.removeHFocusListener(listener);
//    }
//
//    /* (non-Javadoc)
//     * @see org.havi.ui.HNavigationInputPreferred#getNavigationKeys()
//     */
//    public int[] getNavigationKeys() {
//        return navHelper.getNavigationKeys();
//    }
//
//    /* (non-Javadoc)
//     * @see org.havi.ui.HNavigationInputPreferred#processHFocusEvent(org.havi.ui.event.HFocusEvent)
//     */
//    public void processHFocusEvent(HFocusEvent evt) {
//        navHelper.processHFocusEvent(evt);
//    }


}

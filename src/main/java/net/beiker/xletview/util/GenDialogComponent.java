
package net.beiker.xletview.util;

import javax.swing.JComponent;

/**
 * An interface that has to be implemented by classes that wants to be content in GenDialog 
 */
public abstract class GenDialogComponent extends JComponent{
    
    public abstract boolean isOk();
    
}

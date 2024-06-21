package net.beiker.xletview.event;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;

import static java.lang.System.getLogger;


/**
 * @author Martin Sveden
 */
public class FocusListenerDummy implements FocusListener {

    private static final Logger logger = getLogger(FocusListenerDummy.class.getName());

    private static final FocusListenerDummy THE_INSTANCE = new FocusListenerDummy();

    public static FocusListenerDummy getInstance() {
        return THE_INSTANCE;
    }

    @Override
    public void focusGained(FocusEvent e) {
        logger.log(Level.DEBUG, "focusGained-" + e);
    }

    @Override
    public void focusLost(FocusEvent e) {
//        logger.log(Level.DEBUG, this, "focusLost-" + e);
    }
}

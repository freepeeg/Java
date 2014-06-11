package iitc.swing.desktop.input.events;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * KeyEventCopy
 * <p/>
 * Subclass of KeyEvent to differentiate between human and desktop generated events
 *
 * @author Ian
 * @version 1.0
 */
public class KeyEventCopy extends KeyEvent {
    public KeyEventCopy(Component source, int id, long when, int modifiers, int keyCode, char keyChar, int keyLocation) {
        super(source, id, when, modifiers, keyCode, keyChar, keyLocation);
    }

    public KeyEventCopy(Component source, int id, long when, int modifiers, int keyCode, char keyChar) {
        super(source, id, when, modifiers, keyCode, keyChar);
    }

    public KeyEventCopy(Component source, int id, long when, int modifiers, int keyCode) {
        super(source, id, when, modifiers, keyCode);
    }
}

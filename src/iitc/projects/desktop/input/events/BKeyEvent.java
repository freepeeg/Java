package iitc.projects.desktop.input.events;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * BKeyEvent
 * <p/>
 * Subclass of KeyEvent to differentiate between human and desktop generated events
 *
 * @author Ian
 * @version 1.0
 */
public class BKeyEvent extends KeyEvent {
    public BKeyEvent(Component source, int id, long when, int modifiers, int keyCode, char keyChar, int keyLocation) {
        super(source, id, when, modifiers, keyCode, keyChar, keyLocation);
    }

    public BKeyEvent(Component source, int id, long when, int modifiers, int keyCode, char keyChar) {
        super(source, id, when, modifiers, keyCode, keyChar);
    }

    public BKeyEvent(Component source, int id, long when, int modifiers, int keyCode) {
        super(source, id, when, modifiers, keyCode);
    }
}

package iitc.swing.desktop.input.events;

import java.awt.*;
import java.awt.event.FocusEvent;

/**
 * BFocusEvent
 * <p/>
 * Subclass of FocusEvent to differentiate between human and desktop generated events
 *
 * @author Ian
 * @version 1.0
 */
public class BFocusEvent extends FocusEvent {
    public BFocusEvent(Component source, int id, boolean temporary, Component opposite) {
        super(source, id, temporary, opposite);
    }

    public BFocusEvent(Component source, int id, boolean temporary) {
        super(source, id, temporary);
    }

    public BFocusEvent(Component source, int id) {
        super(source, id);
    }
}

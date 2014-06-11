package iitc.swing.desktop.input.events;

import java.awt.*;
import java.awt.event.FocusEvent;

/**
 * FocusEventCopy
 * <p/>
 * Subclass of FocusEvent to differentiate between human and desktop generated events
 *
 * @author Ian
 * @version 1.0
 */
public class FocusEventCopy extends FocusEvent {
    public FocusEventCopy(Component source, int id, boolean temporary, Component opposite) {
        super(source, id, temporary, opposite);
    }

    public FocusEventCopy(Component source, int id, boolean temporary) {
        super(source, id, temporary);
    }

    public FocusEventCopy(Component source, int id) {
        super(source, id);
    }
}

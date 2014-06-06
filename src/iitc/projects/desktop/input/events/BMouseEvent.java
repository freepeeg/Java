package iitc.projects.desktop.input.events;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * BMouseEvent
 * <p/>
 * Subclass of MouseEvent to differentiate between human and desktop generated events
 *
 * @author Ian
 * @version 1.0
 */
public class BMouseEvent extends MouseEvent {
    public BMouseEvent(Component source, int id, long when, int modifiers, int x, int y, int clickCount, boolean popupTrigger, int button) {
        super(source, id, when, modifiers, x, y, clickCount, popupTrigger, button);
    }

    public BMouseEvent(Component source, int id, long when, int modifiers, int x, int y, int clickCount, boolean popupTrigger) {
        super(source, id, when, modifiers, x, y, clickCount, popupTrigger);
    }

    public BMouseEvent(Component source, int id, long when, int modifiers, int x, int y, int xAbs, int yAbs, int clickCount, boolean popupTrigger, int button) {
        super(source, id, when, modifiers, x, y, xAbs, yAbs, clickCount, popupTrigger, button);
    }
}

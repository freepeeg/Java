package iitc.swing.desktop.input.events;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * MouseEventCopy
 * <p/>
 * Subclass of MouseEvent to differentiate between human and desktop generated events
 *
 * @author Ian
 * @version 1.0
 */
public class MouseEventCopy extends MouseEvent {
    public MouseEventCopy(Component source, int id, long when, int modifiers, int x, int y, int clickCount, boolean popupTrigger, int button) {
        super(source, id, when, modifiers, x, y, clickCount, popupTrigger, button);
    }

    public MouseEventCopy(Component source, int id, long when, int modifiers, int x, int y, int clickCount, boolean popupTrigger) {
        super(source, id, when, modifiers, x, y, clickCount, popupTrigger);
    }

    public MouseEventCopy(Component source, int id, long when, int modifiers, int x, int y, int xAbs, int yAbs, int clickCount, boolean popupTrigger, int button) {
        super(source, id, when, modifiers, x, y, xAbs, yAbs, clickCount, popupTrigger, button);
    }
}

package iitc.projects.bot.input.events;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * BotMouseEvent
 * <p/>
 * Subclass of MouseEvent to differentiate between human and bot generated events
 *
 * @author Ian
 * @version 1.0
 */
public class BotMouseEvent extends MouseEvent {
    public BotMouseEvent(Component source, int id, long when, int modifiers, int x, int y, int clickCount, boolean popupTrigger, int button) {
        super(source, id, when, modifiers, x, y, clickCount, popupTrigger, button);
    }

    public BotMouseEvent(Component source, int id, long when, int modifiers, int x, int y, int clickCount, boolean popupTrigger) {
        super(source, id, when, modifiers, x, y, clickCount, popupTrigger);
    }

    public BotMouseEvent(Component source, int id, long when, int modifiers, int x, int y, int xAbs, int yAbs, int clickCount, boolean popupTrigger, int button) {
        super(source, id, when, modifiers, x, y, xAbs, yAbs, clickCount, popupTrigger, button);
    }
}

package iitc.projects.bot.input.events;

import java.awt.*;
import java.awt.event.MouseWheelEvent;

/**
 * BotMouseWheelEvent
 * <p/>
 * Subclass of MouseWheelEvent to differentiate between human and bot generated events
 *
 * @author Ian
 * @version 1.0
 */
public class BotMouseWheelEvent extends MouseWheelEvent {
    public BotMouseWheelEvent(Component source, int id, long when, int modifiers, int x, int y, int clickCount, boolean popupTrigger, int scrollType, int scrollAmount, int wheelRotation) {
        super(source, id, when, modifiers, x, y, clickCount, popupTrigger, scrollType, scrollAmount, wheelRotation);
    }

    public BotMouseWheelEvent(Component source, int id, long when, int modifiers, int x, int y, int xAbs, int yAbs, int clickCount, boolean popupTrigger, int scrollType, int scrollAmount, int wheelRotation) {
        super(source, id, when, modifiers, x, y, xAbs, yAbs, clickCount, popupTrigger, scrollType, scrollAmount, wheelRotation);
    }

    public BotMouseWheelEvent(Component source, int id, long when, int modifiers, int x, int y, int xAbs, int yAbs, int clickCount, boolean popupTrigger, int scrollType, int scrollAmount, int wheelRotation, double preciseWheelRotation) {
        super(source, id, when, modifiers, x, y, xAbs, yAbs, clickCount, popupTrigger, scrollType, scrollAmount, wheelRotation, preciseWheelRotation);
    }
}

package iitc.projects.bot.input.events;

import java.awt.*;
import java.awt.event.FocusEvent;

/**
 * BotFocusEvent
 * <p/>
 * Subclass of FocusEvent to differentiate between human and bot generated events
 *
 * @author Ian
 * @version 1.0
 */
public class BotFocusEvent extends FocusEvent {
    public BotFocusEvent(Component source, int id, boolean temporary, Component opposite) {
        super(source, id, temporary, opposite);
    }

    public BotFocusEvent(Component source, int id, boolean temporary) {
        super(source, id, temporary);
    }

    public BotFocusEvent(Component source, int id) {
        super(source, id);
    }
}

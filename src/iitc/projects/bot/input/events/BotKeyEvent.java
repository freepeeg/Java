package iitc.projects.bot.input.events;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * BotKeyEvent
 * <p/>
 * Subclass of KeyEvent to differentiate between human and bot generated events
 *
 * @author Ian
 * @version 1.0
 */
public class BotKeyEvent extends KeyEvent {
    public BotKeyEvent(Component source, int id, long when, int modifiers, int keyCode, char keyChar, int keyLocation) {
        super(source, id, when, modifiers, keyCode, keyChar, keyLocation);
    }

    public BotKeyEvent(Component source, int id, long when, int modifiers, int keyCode, char keyChar) {
        super(source, id, when, modifiers, keyCode, keyChar);
    }

    public BotKeyEvent(Component source, int id, long when, int modifiers, int keyCode) {
        super(source, id, when, modifiers, keyCode);
    }
}

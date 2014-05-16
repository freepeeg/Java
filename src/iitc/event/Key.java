package iitc.event;

import javax.swing.*;

/**
 * Key
 *
 * @author Ian
 * @version 1.0
 */
public class Key {
    public static KeyStroke getKeyStroke(int keycode) {
        return getKeyStroke(keycode, 0);
    }

    public static KeyStroke getKeyStroke(int keycode, int modifiers) {
        return KeyStroke.getKeyStroke(keycode, modifiers);
    }

    public static void bindTo(JComponent component, KeyStroke keystroke, Object key, Action action) {
        component.getInputMap().put(keystroke, key);
        component.getActionMap().put(key, action);
    }

    public static void removeBind(JComponent component, KeyStroke keystroke, Object key) {
        component.getInputMap().remove(keystroke);
        component.getActionMap().remove(key);
    }
}

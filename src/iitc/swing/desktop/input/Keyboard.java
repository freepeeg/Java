package iitc.swing.desktop.input;

import iitc.event.StateBasedInputHandler;
import iitc.swing.desktop.Utility;

/**
 * Keyboard
 *
 * @author Ian
 * @version 1.0
 */
public class Keyboard extends Utility<Manager> {
    public static char ENTER = '\n';
    public static char BACKSPACE = '\b';
    public static char TAB = '\t';

    public Keyboard(Manager manager) {
        super(manager);
    }

    public void setEnabled(boolean enabled) {
        switch (manager.getState()) {
            case ALL:
                if (!enabled)
                    manager.setState(StateBasedInputHandler.State.MOUSE);
                break;
            case KEY:
                if (!enabled)
                    manager.setState(StateBasedInputHandler.State.NONE);
                break;
            case MOUSE:
                if (enabled)
                    manager.setState(StateBasedInputHandler.State.ALL);
                break;
            case NONE:
                if (enabled)
                    manager.setState(StateBasedInputHandler.State.KEY);
                break;
        }
    }

    public boolean press(char keychar) {
        return manager.input.press(keychar);
    }

    public boolean release(char keychar) {
        return manager.input.release(keychar);
    }

    public boolean type(char keychar) {
        return manager.input.type(keychar);
    }

    public boolean type(char keychar, int min_delay, int max_delay) {
        return manager.input.type(keychar, min_delay, max_delay);
    }

    public boolean enter() {
        return type(ENTER);
    }

    public boolean tab() {
        return type(TAB);
    }

    public boolean backspace() {
        return type(BACKSPACE);
    }

    public boolean enter(int times) {
        return type(ENTER, times);
    }

    public boolean tab(int times) {
        return type(TAB, times);
    }

    public boolean backspace(int times) {
        return type(BACKSPACE, times);
    }

    public boolean type(char keychar, int amount) {
        for (int i = 0; i < amount; i++)
            if (!type(keychar))
                return false;
        return true;
    }

    public boolean type(CharSequence sequence) {
        for (int i = 0; i < sequence.length(); i++) {
            if (!type(sequence.charAt(i)))
                return false;
        }
        return true;
    }
}

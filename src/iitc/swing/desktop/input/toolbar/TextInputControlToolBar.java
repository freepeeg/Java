package iitc.swing.desktop.input.toolbar;

import iitc.event.StateBasedInputHandler;
import iitc.swing.desktop.input.Manager;

import javax.swing.*;

/**
 * TextInputControlToolbar
 *
 * @author Ian
 * @version 1.0
 */
public class TextInputControlToolbar<M extends Manager> extends InputControlToolbar<M> {
    public TextInputControlToolbar(int alignment, int hgap, int vgap) {
        super(alignment, hgap, vgap);
    }

    public TextInputControlToolbar(String name, int alignment, int hgap, int vgap) {
        super(name, alignment, hgap, vgap);
    }

    public TextInputControlToolbar(JButton mouse, JButton keyboard, int alignment, int hgap, int vgap) {
        super(mouse, keyboard, alignment, hgap, vgap);
    }

    public TextInputControlToolbar(JButton mouse, JButton keyboard, String name, int alignment, int hgap, int vgap) {
        super(mouse, keyboard, name, alignment, hgap, vgap);
    }

    @Override
    protected void onMouseChange() {
        if (manager != null) {
            StateBasedInputHandler.State state = manager.getState();
            switch (state) {
                case ALL:
                    manager.setState(StateBasedInputHandler.State.KEY);
                    break;
                case NONE:
                    manager.setState(StateBasedInputHandler.State.MOUSE);
                    break;
                case MOUSE:
                    manager.setState(StateBasedInputHandler.State.NONE);
                    break;
                case KEY:
                    manager.setState(StateBasedInputHandler.State.ALL);
                    break;
            }
        }
    }

    @Override
    protected void onKeyboardChange() {
        if (manager != null) {
            StateBasedInputHandler.State state = manager.getState();
            switch (state) {
                case ALL:
                    manager.setState(StateBasedInputHandler.State.MOUSE);
                    break;
                case NONE:
                    manager.setState(StateBasedInputHandler.State.KEY);
                    break;
                case MOUSE:
                    manager.setState(StateBasedInputHandler.State.ALL);
                    break;
                case KEY:
                    manager.setState(StateBasedInputHandler.State.NONE);
                    break;
            }
        }
    }

    @Override
    public void onStateChange(StateBasedInputHandler.State state) {

    }
}

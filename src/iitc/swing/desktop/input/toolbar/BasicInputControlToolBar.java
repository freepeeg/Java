package iitc.swing.desktop.input.toolbar;

import iitc.swing.desktop.input.Manager;
import iitc.swing.desktop.input.StateBasedInputHandler;

import javax.swing.*;

/**
 * BasicInputControlToolBar
 *
 * @author Ian
 * @version 1.0
 */
public class BasicInputControlToolBar<M extends Manager> extends InputControlToolBar<M> {
    public BasicInputControlToolBar(int alignment, int hgap, int vgap) {
        super(alignment, hgap, vgap);
    }

    public BasicInputControlToolBar(String name, int alignment, int hgap, int vgap) {
        super(name, alignment, hgap, vgap);
    }

    public BasicInputControlToolBar(JButton mouse, JButton keyboard, int alignment, int hgap, int vgap) {
        super(mouse, keyboard, alignment, hgap, vgap);
    }

    public BasicInputControlToolBar(JButton mouse, JButton keyboard, String name, int alignment, int hgap, int vgap) {
        super(mouse, keyboard, name, alignment, hgap, vgap);
    }

    @Override
    protected void onMouseChange(JButton button) {
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
    protected void onKeyboardChange(JButton button) {
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
}

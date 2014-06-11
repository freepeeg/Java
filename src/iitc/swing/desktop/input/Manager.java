package iitc.swing.desktop.input;

import iitc.event.StateBasedInputHandler;

/**
 * Manager
 *
 * @author Ian
 * @version 1.0
 */
public class Manager {
    public final Mouse mouse;
    public final Keyboard keyboard;
    protected StateBasedInputHandler input;

    public Manager(StateBasedInputHandler input) {
        this.input = input;
        this.mouse = new Mouse(this);
        this.keyboard = new Keyboard(this);
    }

    public StateBasedInputHandler.State getState() {
        return input.getInputState();
    }

    public void setState(StateBasedInputHandler.State state) {
        input.setState(state);
    }

    public void update(StateBasedInputHandler input) {
        this.input = input;
    }
}

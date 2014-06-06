package iitc.projects.desktop.input;

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

    public Manager update(StateBasedInputHandler input) {
        this.input = input;
        return this;
    }
}

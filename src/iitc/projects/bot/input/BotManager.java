package iitc.projects.bot.input;

/**
 * BotManager
 *
 * @author Ian
 * @version 1.0
 */
public class BotManager {
    public final Mouse mouse;
    public final Keyboard keyboard;
    protected BotInputHandler input;

    public BotManager(BotInputHandler input) {
        this.input = input;
        this.mouse = new Mouse(this);
        this.keyboard = new Keyboard(this);
    }

    public BotManager update(BotInputHandler input) {
        this.input = input;
        return this;
    }
}

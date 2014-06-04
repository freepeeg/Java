package iitc.projects.bot.input;

/**
 * BotController
 *
 * @author Ian
 * @version 1.0
 */
public class BotController {
    private BotInputHandler handler;

    public BotController() {
        this(null);
    }

    public BotController(BotInputHandler handler) {
        this.handler = handler;
    }

    public BotController update(BotInputHandler handler) {
        this.handler = handler;
        return this;
    }
}

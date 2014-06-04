package iitc.projects.bot.input;

/**
 * BotManager
 *
 * @author Ian
 * @version 1.0
 */
public class BotManager {
    private BotInputHandler handler;

    public BotManager() {
        this(null);
    }

    public BotManager(BotInputHandler handler) {
        this.handler = handler;
    }

    public BotInputHandler getHandler() {
        return handler;
    }

    public BotManager update(BotInputHandler handler) {
        this.handler = handler;
        return this;
    }
}

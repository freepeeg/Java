package iitc.projects.bot;

import iitc.projects.bot.input.BotManager;

/**
 * BotUtility
 *
 * @author Ian
 * @version 1.0
 */
public class BotUtility<B extends BotManager> {
    protected B manager;

    public BotUtility(B manager) {
        this.manager = manager;
    }

    public void renewManager(B manager) {
        this.manager = manager;
    }
}

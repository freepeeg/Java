package iitc.projects.bot;

import iitc.projects.bot.input.BotManager;

import java.util.EventListener;

/**
 * LoadListener
 *
 * @author Ian
 * @version 1.0
 */
public interface LoadListener<B1 extends BotInstance, B2 extends BotManager, B3 extends BotPanel<B1, B2>> extends EventListener {
    public void onLoad(B3 parent);
}

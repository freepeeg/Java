package iitc.projects.bot;

import java.util.EventListener;

/**
 * LoadListener
 *
 * @author Ian
 * @version 1.0
 */
public interface LoadListener extends EventListener {
    public void onLoad(BotPanel parent);
}

package iitc.projects.twentyfourtyeight;

import java.util.EventListener;

/**
 * GameListener
 *
 * @author Ian
 * @version 1.0
 */
public interface GameListener extends EventListener {
    public void onWin(GameEvent e);

    public void onLoss(GameEvent e);

    public void onPause(GameEvent e);

    public void onResume(GameEvent e);
}

package iitc.projects.twentyfourtyeight;

import iitc.event.Session;

/**
 * AI
 *
 * @author Ian
 * @version 1.0
 */
public abstract class AI extends Thread implements Session {
    protected final BoardManager manager;
    protected final int sleep;

    public AI(Game game, int sleep) {
        this.manager = game.getManager();
        this.sleep = sleep;
        game.start();
    }

    public abstract Shift next();

    public boolean execute() {
        return manager.shift(next());
    }

    public boolean isActive() {
        return isAlive();
    }

    @Override
    public void run() {
        while (manager.getState() != Board.State.FINISHED)
            try {
                execute();
                sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}

package iitc.projects.twentyfourtyeight;

import iitc.event.Session;

/**
 * User
 *
 * @author Ian
 * @version 1.0
 */
public class User implements Session {
    protected final BoardManager manager;

    public User(Game game) {
        this.manager = game.getManager();
        game.start();
    }

    @Override
    public final void start() {
        manager.addBind(Bind.LEFT);
        manager.addBind(Bind.RIGHT);
        manager.addBind(Bind.UP);
        manager.addBind(Bind.DOWN);
    }

    @Override
    public boolean isActive() {
        return manager.getState() != Board.State.FINISHED;
    }
}

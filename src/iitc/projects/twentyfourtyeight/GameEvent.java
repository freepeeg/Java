package iitc.projects.twentyfourtyeight;

/**
 * GameEvent
 *
 * @author Ian
 * @version 1.0
 */
public class GameEvent {
    protected final Board game;
    protected final String user;
    protected final int score;

    public GameEvent(Board game) {
        this.game = game;
        this.user = game.user;
        this.score = game.score;
    }

    public int[][] getBoard() {
        return game.get();
    }

    public String getUser() {
        return user;
    }

    public int getScore() {
        return score;
    }
}

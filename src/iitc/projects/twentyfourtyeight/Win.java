package iitc.projects.twentyfourtyeight;

/**
 * Win
 *
 * @author Ian
 * @version 1.0
 */
public class Win extends GameEvent {
    public Win(Board game) {
        super(game);
    }

    @Override
    public String toString() {
        return "Congratulations " + user + "! You've won! Score: " + score + "\n" + game;
    }
}

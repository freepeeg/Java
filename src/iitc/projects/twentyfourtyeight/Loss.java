package iitc.projects.twentyfourtyeight;

/**
 * Loss
 *
 * @author Ian
 * @version 1.0
 */
public class Loss extends GameEvent {
    public Loss(Board game) {
        super(game);
    }

    @Override
    public String toString() {
        return "Sorry " + user + ", you've lost. Score: " + score + "\n" + game;
    }
}

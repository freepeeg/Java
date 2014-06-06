package iitc.projects.desktop.input;

import iitc.projects.desktop.Utility;

import java.awt.*;

/**
 * Mouse
 *
 * @author Ian
 * @version 1.0
 */
public class Mouse extends Utility<Manager> {
    public Mouse(Manager manager) {
        super(manager);
    }

    private Point getPosition() {
        return manager.input.getMousePosition();
    }

    public Point getLocation() {
        return getPosition().getLocation();
    }

    public int getX() {
        return getPosition().x;
    }

    public int getY() {
        return getPosition().y;
    }

    public boolean click() {
        return manager.input.click();
    }

    public boolean click(boolean left) {
        return manager.input.click(left);
    }

    public boolean click(int min_delay, int max_delay) {
        return manager.input.click(min_delay, max_delay);
    }

    public boolean click(boolean left, int min_delay, int max_delay) {
        return manager.input.click(left, min_delay, max_delay);
    }

    public boolean hop(int x, int y) {
        return manager.input.hop(x, y);
    }
}

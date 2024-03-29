package iitc.swing.desktop;

import iitc.swing.desktop.input.Manager;

/**
 * Utility
 *
 * @author Ian
 * @version 1.0
 */
public class Utility<B extends Manager> {
    protected B manager;

    public Utility(B manager) {
        this.manager = manager;
    }

    public void renew(B manager) {
        this.manager = manager;
    }
}

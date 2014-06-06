package iitc.projects.desktop;

import iitc.projects.desktop.input.Manager;

import java.util.EventListener;

/**
 * LoadListener
 *
 * @author Ian
 * @version 1.0
 */
public interface LoadListener<B1 extends BPanel, B2 extends Manager, B3 extends BFrame<B2>> extends EventListener {
    public void onLoad(B3 parent);
}

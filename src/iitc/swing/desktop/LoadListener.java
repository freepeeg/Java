package iitc.swing.desktop;

import iitc.swing.desktop.input.Manager;

import java.util.EventListener;

/**
 * LoadListener
 *
 * @author Ian
 * @version 1.0
 */
public interface LoadListener<B extends Manager,B1 extends BToolBar<B>, B2 extends BFrame<B,B1>> extends EventListener {
    public void onLoad(B2 parent);
}

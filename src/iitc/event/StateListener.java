package iitc.event;

import java.util.EventListener;

/**
 * StateListener
 *
 * @author Ian
 * @version 1.0
 */
public interface StateListener extends EventListener {
    public void onStateChange(StateBasedInputHandler.State state);
}

package iitc.projects.chess;

import java.util.EventListener;

/**
 * MoveListener
 *
 * @author Ian
 * @version 1.0
 */
public interface MoveListener extends EventListener {
    public void onMove(Move move);
}

package iitc.projects.chess.piece;

import iitc.projects.chess.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Pawn
 *
 * @author Ian
 * @version 1.0
 */
public class Pawn extends Piece {
    private final MoveListener listener;
    private int moveLength;
    private boolean isListening;

    public Pawn(Color color, Square square) {
        super(color, square);
        this.moveLength = 2;
        this.isListening = false;
        this.listener = new MoveListener() {
            @Override
            public void onMove(Move move) {
                if (Pawn.this.equals(move.getPiece()))
                    moveLength = 1;
            }
        };
    }

    @Override
    public Type getType() {
        return Type.PAWN;
    }

    @Override
    public List<Square> getPotentialMoves(BoardManager manager) {
        if (moveLength == 2) {
            if (!isListening)
                manager.addListener(listener);
        } else if (isListening)
            manager.removeListener(listener);
        List<Square> moves = new ArrayList<>(4);
        int row = getSquare().getRow();
        int col = getSquare().getColumn();
        Square left = manager.get(row, col - 1);
        if (left != null && left.isEmpty())
            moves.add(left);
        Square right = manager.get(row, col + 1);
        if (right != null && right.isEmpty())
            moves.add(right);
        Square up = manager.get(row - 1, col);
        if (up != null && up.isEmpty())
            moves.add(up);
        Square down = manager.get(row + 1, col);
        if (down != null && down.isEmpty())
            moves.add(down);
        if (moveLength == 2) {
            boolean top = row < 4;
            if (top) {
                if (down != null && down.isEmpty()) {
                    Square down2 = manager.get(row + 2, col);
                    if (down2 != null && down2.isEmpty())
                        moves.add(down2);
                }
            } else {
                if (up != null && up.isEmpty()) {
                    Square up2 = manager.get(row - 2, col);
                    if (up2 != null && up2.isEmpty())
                        moves.add(up2);
                }
            }
        }
        //TODO:Include en passant
        return moves;
    }

}

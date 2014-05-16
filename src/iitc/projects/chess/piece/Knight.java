package iitc.projects.chess.piece;

import iitc.projects.chess.BoardManager;
import iitc.projects.chess.Piece;
import iitc.projects.chess.Square;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Knight
 *
 * @author Ian
 * @version 1.0
 */
public class Knight extends Piece {
    public Knight(Color color, Square square) {
        super(color, square);
    }

    @Override
    public Type getType() {
        return Type.KNIGHT;
    }

    @Override
    public List<Square> getPotentialMoves(BoardManager manager) {
        List<Square> moves = new ArrayList<>(8);
        int row = getSquare().getRow();
        int col = getSquare().getColumn();
        Square square = manager.get(row - 2, col + 1);
        if (square != null && square.isEmpty())
            moves.add(square);
        square = manager.get(row - 2, col - 1);
        if (square != null && square.isEmpty())
            moves.add(square);
        square = manager.get(row - 1, col + 2);
        if (square != null && square.isEmpty())
            moves.add(square);
        square = manager.get(row - 1, col - 2);
        if (square != null && square.isEmpty())
            moves.add(square);
        square = manager.get(row + 1, col + 2);
        if (square != null && square.isEmpty())
            moves.add(square);
        square = manager.get(row + 1, col - 2);
        if (square != null && square.isEmpty())
            moves.add(square);
        square = manager.get(row + 2, col + 1);
        if (square != null && square.isEmpty())
            moves.add(square);
        square = manager.get(row + 2, col - 1);
        if (square != null && square.isEmpty())
            moves.add(square);
        return moves;
    }
}

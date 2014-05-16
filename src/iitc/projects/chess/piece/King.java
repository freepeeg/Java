package iitc.projects.chess.piece;

import iitc.projects.chess.BoardManager;
import iitc.projects.chess.Piece;
import iitc.projects.chess.Square;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * King
 *
 * @author Ian
 * @version 1.0
 */
public class King extends Piece {
    public King(Color color, Square square) {
        super(color, square);
    }

    @Override
    public Type getType() {
        return Type.KING;
    }

    @Override
    public List<Square> getPotentialMoves(BoardManager manager) {
        List<Square> moves = new ArrayList<>(8);
        int row = getSquare().getRow();
        int col = getSquare().getColumn();
        //up-left
        Square square = manager.get(row - 1, col - 1);
        if (square != null && square.isEmpty())
            moves.add(square);
        //up
        square = manager.get(row - 1, col);
        if (square != null && square.isEmpty())
            moves.add(square);
        //up-right
        square = manager.get(row - 1, col + 1);
        if (square != null && square.isEmpty())
            moves.add(square);
        //left
        square = manager.get(row, col - 1);
        if (square != null && square.isEmpty())
            moves.add(square);
        //right
        square = manager.get(row, col + 1);
        if (square != null && square.isEmpty())
            moves.add(square);
        //down-left
        square = manager.get(row + 1, col - 1);
        if (square != null && square.isEmpty())
            moves.add(square);
        //down
        square = manager.get(row + 1, col);
        if (square != null && square.isEmpty())
            moves.add(square);
        //down-right
        square = manager.get(row + 1, col + 1);
        if (square != null && square.isEmpty())
            moves.add(square);
        return moves;
    }
}

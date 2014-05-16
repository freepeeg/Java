package iitc.projects.chess.piece;

import iitc.projects.chess.Board;
import iitc.projects.chess.BoardManager;
import iitc.projects.chess.Piece;
import iitc.projects.chess.Square;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Rook
 *
 * @author Ian
 * @version 1.0
 */
public class Rook extends Piece {
    public Rook(Color color, Square square) {
        super(color, square);
    }

    @Override
    public Type getType() {
        return Type.ROOK;
    }

    @Override
    public List<Square> getPotentialMoves(BoardManager manager) {
        List<Square> moves = new ArrayList<>(20);
        int row = getSquare().getRow();
        int col = getSquare().getColumn();
        for (int i = row + 1; i < Board.LENGTH; i++) {
            Square square = manager.get(i, col);
            if (square == null || !square.isEmpty())
                break;
            moves.add(manager.get(i, col));
        }
        for (int i = row - 1; i >= 0; --i) {
            Square square = manager.get(i, col);
            if (square == null || !square.isEmpty())
                break;
            moves.add(manager.get(i, col));
        }
        for (int i = col - 1; i >= 0; --i) {
            Square square = manager.get(row, i);
            if (square == null || !square.isEmpty())
                break;
            moves.add(manager.get(row, i));
        }
        for (int i = col + 1; i < Board.LENGTH; i++) {
            Square square = manager.get(row, i);
            if (square == null || !square.isEmpty())
                break;
            moves.add(manager.get(row, i));
        }
        return moves;
    }
}

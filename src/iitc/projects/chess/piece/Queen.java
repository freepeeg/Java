package iitc.projects.chess.piece;

import iitc.projects.chess.Board;
import iitc.projects.chess.BoardManager;
import iitc.projects.chess.Piece;
import iitc.projects.chess.Square;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Queen
 *
 * @author Ian
 * @version 1.0
 */
public class Queen extends Piece {
    public Queen(Color color, Square square) {
        super(color, square);
    }

    @Override
    public Type getType() {
        return Type.QUEEN;
    }

    @Override
    public List<Square> getPotentialMoves(BoardManager manager) {
        List<Square> moves = new ArrayList<>(20);
        int row = getSquare().getRow();
        int col = getSquare().getColumn();
        //up
        for (int i = 1; i < Board.LENGTH; i++) {
            Square square = manager.get(row, col - i);
            if (square == null || !square.isEmpty())
                break;
            moves.add(square);
        }
        //left
        for (int i = 1; i < Board.LENGTH; i++) {
            Square square = manager.get(row, col - i);
            if (square == null || !square.isEmpty())
                break;
            moves.add(square);
        }
        //right
        for (int i = 1; i < Board.LENGTH; i++) {
            Square square = manager.get(row, col + i);
            if (square == null || !square.isEmpty())
                break;
            moves.add(square);
        }
        //down
        for (int i = 1; i < Board.LENGTH; i++) {
            Square square = manager.get(row + i, col);
            if (square == null || !square.isEmpty())
                break;
            moves.add(square);
        }
        //top-left
        for (int i = 1; i < Board.LENGTH; i++) {
            Square square = manager.get(row - i, col - i);
            if (square == null || !square.isEmpty())
                break;
            moves.add(square);
        }
        //top-right
        for (int i = 1; i < Board.LENGTH; i++) {
            Square square = manager.get(row - i, col + i);
            if (square == null || !square.isEmpty())
                break;
            moves.add(square);
        }
        //bottom-left
        for (int i = 1; i < Board.LENGTH; i++) {
            Square square = manager.get(row + i, col - i);
            if (square == null || !square.isEmpty())
                break;
            moves.add(square);
        }
        //bottom-right
        for (int i = 1; i < Board.LENGTH; i++) {
            Square square = manager.get(row + i, col + i);
            if (square == null || !square.isEmpty())
                break;
            moves.add(square);
        }
        return moves;
    }
}

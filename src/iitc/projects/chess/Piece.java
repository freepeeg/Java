package iitc.projects.chess;


import java.awt.*;
import java.util.List;

/**
 * Piece
 *
 * @author Ian
 * @version 1.0
 */
public abstract class Piece {
    private final Color color;
    private Square square;

    public Piece(Color color, Square square) {
        this.color = color;
        this.square = square;
        //ensures the initial state of the board is correct
        square.setPiece(this);
    }

    public abstract Type getType();

    public abstract List<Square> getPotentialMoves(BoardManager manager);

    public Square getSquare() {
        return square;
    }

    protected void setSquare(Square square) {
        this.square = square;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    public enum Type {KING, QUEEN, ROOK, BISHOP, KNIGHT, PAWN}
}

package iitc.projects.chess;

import java.awt.*;

/**
 * Square
 *
 * @author Ian
 * @version 1.0
 */
public class Square {
    private final int row;
    private final int col;
    private final Color color;
    private Piece piece;

    public Square(int row, int col, Color color) {
        this(row, col, color, null);
    }

    public Square(int row, int col, Color color, Piece piece) {
        this.row = row;
        this.col = col;
        this.color = color;
        this.piece = piece;
    }

    public Color getColor() {
        return color;
    }

    public boolean isEmpty() {
        return piece == null;
    }

    public Piece getPiece() {
        return piece;
    }

    protected void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return col;
    }

    @Override
    public String toString() {
        return "[" + row + "][" + col + "]";
    }
}

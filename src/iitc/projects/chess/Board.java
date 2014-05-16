package iitc.projects.chess;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Board
 *
 * @author Ian
 * @version 1.0
 */
public class Board {
    public static final int LENGTH = 8;
    protected final Square[][] board;
    protected final List<MoveListener> listeners;

    public Board() {
        this(Color.black, Color.white);
    }

    public Board(Board board) {
        this.board = board.board;
        this.listeners = new ArrayList<>();
    }

    public Board(Color one, Color two) {
        this.board = new Square[LENGTH][LENGTH];
        this.listeners = new ArrayList<>();
        for (int row = 0; row < board.length; row++)
            for (int col = 0; col < board.length; col++) {
                Color color = row % 2 == 0 ? col % 2 == 1 ? one : two : col % 2 == 0 ? one : two;
                board[row][col] = new Square(row, col, color);
            }
    }

    protected void fireEvent(Move move) {
        for (MoveListener m : listeners)
            m.onMove(move);
    }

    protected <T extends Piece> T add(Class<T> pieceClass, Color color, char col, int row) {
        try {
            int int_col = col - 97;
            if (row < 0 || row >= LENGTH)
                return null;
            if (int_col < 0 || int_col >= LENGTH)
                return null;
            return pieceClass.getDeclaredConstructor(Color.class, Square.class).newInstance(color, board[row][int_col]);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            return null;
        }
    }

    protected <T extends Piece> T add(Class<T> pieceClass, Color color, int row, int col) {
        try {
            if (row < 0 || row >= LENGTH)
                return null;
            if (col < 0 || col >= LENGTH)
                return null;
            return pieceClass.getDeclaredConstructor(Color.class, Square.class).newInstance(color, board[row][col]);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (Square[] s : board)
            string.append(Arrays.toString(s)).append("\n");
        return string.toString();
    }
}

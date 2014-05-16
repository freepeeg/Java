package iitc.projects.chess;

import iitc.im.ListOperations;

import java.util.Collections;

/**
 * BoardManager
 *
 * @author Ian
 * @version 1.0
 */
public abstract class BoardManager {
    private final Board board;

    public BoardManager(Board board) {
        this.board = board;
    }

    protected abstract Game getGame();

    public Piece move(Move move) {
        return move(move.getPiece(), move.getFinish());
    }

    public Piece move(Piece start, Square finish) {
        if (start == null || finish == null)
            throw new IllegalArgumentException("Start and Finish squares must exist.");
        if (start.getPotentialMoves(this).contains(finish)) {
            Piece p = swap(start.getSquare(), finish);
            //TODO:Change pawn to piece when reaches opponents back row.
            return p;
        } else
            return null;
    }

    public boolean addListener(MoveListener... listeners) {
        return Collections.addAll(board.listeners, listeners);
    }

    public boolean removeListener(MoveListener... listeners) {
        return ListOperations.removeAll(board.listeners, listeners);
    }

    private Piece swap(Square start, Square finish) {
        Piece startPiece = start.getPiece();
        Piece finishPiece = finish.getPiece();
        Move move = new Move(startPiece, start, finish);
        finish.setPiece(startPiece);
        start.setPiece(null);
        startPiece.setSquare(finish);
        board.fireEvent(move);
        return finishPiece;
    }

    public Square get(int row, int col) {
        if (row < 0 || row >= Board.LENGTH)
            return null;
        if (col < 0 || col >= Board.LENGTH)
            return null;
        return board.board[row][col];
    }

    public Square get(char col, int row) {
        int int_col = col - 97;
        if (row < 0 || row >= Board.LENGTH)
            return null;
        if (int_col < 0 || int_col >= Board.LENGTH)
            return null;
        return board.board[row][int_col];
    }

    public Square[] get(int row) {
        if (row < 0 || row >= Board.LENGTH)
            return null;
        return board.board[row];
    }

    public Square[][] get() {
        return board.board;
    }

    public boolean isEmpty(int row, int col) {
        return get(row, col) != null;
    }
}

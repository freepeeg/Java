package iitc.projects.chess;

/**
 * Move
 *
 * @author Ian
 * @version 1.0
 */
public class Move {
    private final Square start;
    private final Square finish;
    private final Piece piece;

    public Move(Piece piece, Square start, Square finish) {
        this.start = start;
        this.piece = piece;
        this.finish = finish;
    }

    public Square getStart() {
        return start;
    }

    public Square getFinish() {
        return finish;
    }

    public Piece getPiece() {
        return piece;
    }
}

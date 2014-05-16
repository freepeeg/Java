package iitc.projects.chess.ui;

import iitc.projects.chess.Piece;
import iitc.projects.chess.Square;
import iitc.swing.JLFont;

import javax.swing.*;
import java.awt.*;

/**
 * SquareLabel
 *
 * @author Ian
 * @version 1.0
 */
public class SquareLabel extends JLabel {
    private final Square square;
    private boolean selected;

    public SquareLabel(final Square square) {
        super();
        if (square == null)
            throw new IllegalArgumentException("Square must exist.");
        setHorizontalTextPosition(CENTER);
        setVerticalTextPosition(CENTER);
        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        setOpaque(true);
        this.square = square;
        this.selected = false;
    }

    @Override
    public Color getBackground() {
        return selected ? Color.YELLOW : square == null ? super.getBackground() : square.getColor();
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public Font getFont() {
        return JLFont.fillContainer(this, super.getFont());
    }

    @Override
    public String getText() {
        Piece p = square == null ? null : square.getPiece();
        return p == null ? "" : p.getType().toString();
    }

    public Square getSquare() {
        return square;
    }
}

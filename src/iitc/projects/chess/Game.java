package iitc.projects.chess;

import iitc.projects.chess.ui.SquareLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Game
 *
 * @author Ian
 * @version 1.0
 */
public class Game extends JFrame {
    protected final BoardManager manager;
    private final JPanel panel;
    protected java.util.List<SquareLabel> labels;
    private SquareLabel selected;

    public Game(Board board) {
        super("Chess");
        this.panel = new JPanel();
        this.labels = new ArrayList<>(64);
        this.manager = new BoardManager(board) {
            @Override
            protected Game getGame() {
                return Game.this;
            }
        };
        panel.setLayout(new GridLayout(Board.LENGTH, Board.LENGTH));
        for (Square[] sq : manager.get())
            for (final Square s : sq) {
                SquareLabel l = new SquareLabel(s);
                labels.add(l);
                panel.add(l);
            }
        setContentPane(panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(400, 400));
    }

    @Override
    public void addMouseListener(MouseListener mouseListener) {
        panel.addMouseListener(mouseListener);
    }

    public void start() {
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Object o = e.getSource();
                if (o instanceof JPanel) {
                    JPanel b = (JPanel) o;
                    Component c = b.getComponentAt(e.getPoint());
                    if (c instanceof SquareLabel) {
                        SquareLabel s = (SquareLabel) c;
                        for (Component c1 : b.getComponents())
                            if (c1 instanceof SquareLabel)
                                ((SquareLabel) c1).setSelected(false);
                        if (s == selected) {
                            selected = null;
                        } else if (selected == null || s.getSquare().getPiece() != null) {
                            selected = s;
                        }
                        if (selected != null) {
                            Square square = selected.getSquare();
                            Piece p = square.getPiece();
                            if (p != null) {
                                java.util.List<Square> moves = p.getPotentialMoves(manager);
                                if (moves.contains(s.getSquare())) {
                                    manager.move(new Move(p, p.getSquare(), s.getSquare()));
                                    selected = null;
                                } else if (moves.size() == 0)
                                    selected = null;
                                else
                                    for (Square m : moves)
                                        for (SquareLabel l : labels)
                                            if (m.equals(l.getSquare()))
                                                l.setSelected(true);
                            }
                        }
                    }
                }
                repaint();
            }
        });
    }

    public BoardManager getManager() {
        return manager;
    }

}

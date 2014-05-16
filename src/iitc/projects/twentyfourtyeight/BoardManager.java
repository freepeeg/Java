package iitc.projects.twentyfourtyeight;

import iitc.event.Key;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * BoardManager
 *
 * @author Ian
 * @version 1.0
 */
public abstract class BoardManager {
    private final Board game;
    private int moves;

    public BoardManager(Board board) {
        this.game = board;
        this.moves = 0;
    }

    protected abstract JFrame getParent();

    protected abstract JComponent getContainer();

    protected void addBind(final Bind bind) {
        addBind(bind.getKeyStroke(), bind, bind.getShift());
    }

    protected void addBind(KeyStroke keystroke, Object key, final Shift shift) {
        Key.bindTo(getContainer(), keystroke, key, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shift(shift);
            }
        });
    }

    public void removeBind(Bind bind) {
        removeBind(bind.getKeyStroke(), bind);
    }

    public void removeBind(KeyStroke keystroke, Object key) {
        Key.removeBind(getContainer(), keystroke, key);
    }

    public Board.State getState() {
        return game.getState();
    }

    protected void setState(Board.State state) {
        game.state = state;
    }

    public int getMoves() {
        return moves;
    }

    public int[][] get() {
        return game.get();
    }

    public int get(int row, int col) {
        return game.current[row][col];
    }

    public int getLength(int row) {
        return game.current[row].length;
    }

    public int getLength() {
        return game.current.length;
    }

    public boolean shift(Shift shift) {
        boolean shifted = game.shift(shift);
        if (shifted) {
            moves++;
            addRandomTile();
        }
        JFrame parent = getParent();
        if (parent != null) {
            parent.repaint();
        }
        JComponent container = getContainer();
        if (container != null)
            container.repaint();
        return shifted;
    }

    public Board cloneGame() {
        return game.clone();
    }

    public void checkWin() {
        game.checkWin();
    }

    public boolean addBoardListener(GameListener listener) {
        return game.addListener(listener);
    }

    public boolean removeBoardListener(GameListener listener) {
        return game.removeListener(listener);
    }

    public String printBoard() {
        return game.toString();
    }

    public void resume() {
        game.resume();
    }

    public void pause() {
        game.pause();
    }

    public int getScore() {
        return game.score;
    }

    protected void addRandomTile() {
        game.addRandom();
    }

    public boolean canCombine(int row1, int col1, int row2, int col2) {
        return game.canCombine(row1, col1, row2, col2);
    }

    protected int combine(int row1, int col1, int row2, int col2) {
        return game.combine(row1, col1, row2, col2);
    }
}

package iitc.projects.twentyfourtyeight;

import iitc.util.Random;

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
    protected final String user;
    protected final List<GameListener> listeners;
    protected int[][] current;
    protected int score;
    protected State state;

    public Board() {
        this("Player 1", 4);
    }

    public Board(int length) {
        this("Player 1", length);
    }

    public Board(int[][] board) {
        this("Player 1", board);
    }

    public Board(String user, int length) {
        this(user, new int[length][length]);
        addRandom();
        addRandom();
    }

    public Board(String user, int[][] board) {
        this.user = user;
        this.current = board;
        this.state = State.PLAYING;
        this.score = 0;
        this.listeners = new ArrayList<>();
    }

    public boolean addListener(GameListener listener) {
        return listeners.add(listener);
    }

    public boolean removeListener(GameListener listener) {
        return listeners.remove(listener);
    }

    public Board clone() {
        Board var = new Board(user, get());
        var.score = score;
        return var;
    }

    public int[][] get() {
        int[][] copy = new int[current.length][current.length];
        for (int i = 0; i < current.length; i++)
            System.arraycopy(current[i], 0, copy[i], 0, current.length);
        return copy;
    }

    public void pause() {
        state = State.PAUSED;
        fireEvent(new GameEvent(this));
    }

    public void resume() {
        state = State.PLAYING;
        fireEvent(new GameEvent(this));
    }

    public boolean isOpen(int row, int col) {
        return current[row][col] == 0;
    }

    public boolean shift(Shift shift) {
        if (state != State.PLAYING)
            return false;
        boolean shifted = shift.shiftBoard(this);
        checkWin();
        return shifted;
    }

    public boolean canCombine(int row1, int col1, int row2, int col2) {
        return current[row1][col1] == current[row2][col2] && !isOpen(row1, col1) && !isOpen(row2, col2);
    }

    protected int combine(int row1, int col1, int row2, int col2) {
        if (state != State.PLAYING)
            return 0;
        current[row2][col2] += current[row1][col1];
        current[row1][col1] = 0;
        return current[row2][col2];
    }

    public void addRandom() {
        if (BoardEvaluator.isFull(current) || state != State.PLAYING)
            return;
        int row = Random.getInstance().nextInt(0, current.length);
        int col = Random.getInstance().nextInt(0, current.length);
        if (isOpen(row, col))
            current[row][col] = (int) Math.pow(2, Random.getInstance().nextInt(1, 3));
        else
            addRandom();
    }

    public void checkWin() {
        for (int[] a : current)
            for (int i : a)
                if (i == 2048) {
                    state = State.FINISHED;
                    fireEvent(new Win(this));
                }
    }

    protected void fireEvent(GameEvent event) {
        for (GameListener listener : listeners) {
            if (event instanceof Win)
                listener.onWin(event);
            else if (event instanceof Loss)
                listener.onLoss(event);
            else if (state == State.PAUSED)
                listener.onPause(event);
            else
                listener.onResume(event);
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder(user + "\n");
        for (int[] aBoard : current)
            string.append(Arrays.toString(aBoard)).append("\n");
        return string.toString();
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Board && Arrays.deepEquals(current, ((Board) o).current);
    }

    public State getState() {
        return state;
    }

    protected enum State {
        PLAYING, PAUSED, FINISHED
    }
}

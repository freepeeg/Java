package iitc.projects.twentyfourtyeight;

import iitc.im.Array2D;
import iitc.im.ListOperations;

import java.util.List;

/**
 * BoardEvaluator
 *
 * @author Ian
 * @version 1.0
 */
public class BoardEvaluator {
    private static int monotonicSequences(List<int[]> subarrays) {
        int count = 0;
        for (int[] i : subarrays)
            if (isMonotonic(i))
                count++;
        return count;
    }

    private static int monotonicSequences(int[] array) {
        if (array.length < 2)
            return 0;
        if (array.length == 2)
            return 1;
        List<int[]> subs = ListOperations.allSubArrays(array);
        return monotonicSequences(subs);
    }

    public static int monotonicSequences(int[][] board) {
        int count = 0;
        for (int[] row : board)
            count += monotonicSequences(removeZeros(row));
        for (int i = 0; i < board[0].length; i++)
            count += monotonicSequences(removeZeros(Array2D.column(board, i)));
        return count;
    }

    public static int compare(int[][] board1, int[][] board2) {
        int m1 = monotonicSequences(board1);
        int m2 = monotonicSequences(board2);
        int monotonic = m1 - m2;
        if (monotonic != 0)
            return monotonic > 0 ? 1 : -1;
        int e1 = emptySpaces(board1);
        int e2 = emptySpaces(board2);
        int empty = e1 - e2;
        if (empty != 0)
            return empty > 0 ? 1 : -1;
        return 0;
    }

    private static boolean isMonotonic(int[] array) {
        if (array.length < 3)
            return true;
        boolean decreasing = true;
        //monotone decreasing sequence
        for (int i = 0; i < array.length - 1; i++)
            if (array[i] > array[i + 1]) {
                decreasing = false;
                break;
            }
        if (decreasing) return true;
        //monotone increasing sequence
        for (int i = 0; i < array.length - 1; i++)
            if (array[i] < array[i + 1])
                return false;
        return true;
    }

    private static int[] removeZeros(int[] array) {
        int zeros = 0;
        for (int i : array)
            if (i == 0)
                zeros++;
        int[] withoutzeros = new int[array.length - zeros];
        int j = 0;
        for (int i : array) {
            if (i != 0)
                withoutzeros[j++] = i;
        }
        return withoutzeros;
    }

    public static int emptySpaces(int[][] board) {
        int count = 0;
        for (int[] a : board)
            for (int i : a)
                if (i == 0)
                    count++;
        return count;
    }

    public static boolean isEmpty(int[][] board) {
        return emptySpaces(board) == 0;
    }

    public static boolean isFull(int[][] board) {
        for (int[] a : board)
            for (int i : a)
                if (i == 0)
                    return false;
        return true;
    }
}

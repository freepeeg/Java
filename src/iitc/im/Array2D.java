package iitc.im;

/**
 * Array2D
 *
 * @author Ian
 * @version 1.0
 */
public class Array2D {
    public static double[] column(double[][] array, int col) {
        if (array == null || array.length == 0)
            return new double[0];
        double[] column = new double[array.length];
        for (int i = 0; i < column.length; i++)
            column[i] = array[i][col];
        return column;
    }

    public static float[] column(float[][] array, int col) {
        if (array == null || array.length == 0)
            return new float[0];
        float[] column = new float[array.length];
        for (int i = 0; i < column.length; i++)
            column[i] = array[i][col];
        return column;
    }

    public static long[] column(long[][] array, int col) {
        if (array == null || array.length == 0)
            return new long[0];
        long[] column = new long[array.length];
        for (int i = 0; i < column.length; i++)
            column[i] = array[i][col];
        return column;
    }

    public static int[] column(int[][] array, int col) {
        if (array == null || array.length == 0)
            return new int[0];
        int[] column = new int[array.length];
        for (int i = 0; i < column.length; i++)
            column[i] = array[i][col];
        return column;
    }

    public static short[] column(short[][] array, int col) {
        if (array == null || array.length == 0)
            return new short[0];
        short[] column = new short[array.length];
        for (int i = 0; i < column.length; i++)
            column[i] = array[i][col];
        return column;
    }

    public static byte[] column(byte[][] array, int col) {
        if (array == null || array.length == 0)
            return new byte[0];
        byte[] column = new byte[array.length];
        for (int i = 0; i < column.length; i++)
            column[i] = array[i][col];
        return column;
    }

    public static Object[] column(Object[][] array, int col) {
        if (array == null || array.length == 0)
            return new Object[0];
        Object[] column = new Object[array.length];
        for (int i = 0; i < column.length; i++)
            column[i] = array[i][col];
        return column;
    }

    public static void swap(double[][] array, int row1, int col1, int row2, int col2) {
        array[row2][col2] = array[row1][col1];
        array[row1][col1] = 0;
    }

    public static void swap(long[][] array, int row1, int col1, int row2, int col2) {
        array[row2][col2] = array[row1][col1];
        array[row1][col1] = 0;
    }

    public static void swap(float[][] array, int row1, int col1, int row2, int col2) {
        array[row2][col2] = array[row1][col1];
        array[row1][col1] = 0;
    }

    public static void swap(int[][] array, int row1, int col1, int row2, int col2) {
        array[row2][col2] = array[row1][col1];
        array[row1][col1] = 0;
    }

    public static void swap(short[][] array, int row1, int col1, int row2, int col2) {
        array[row2][col2] = array[row1][col1];
        array[row1][col1] = 0;
    }

    public static void swap(byte[][] array, int row1, int col1, int row2, int col2) {
        array[row2][col2] = array[row1][col1];
        array[row1][col1] = 0;
    }

    public static <T> void swap(T[][] array, int row1, int col1, int row2, int col2, T placeholder) {
        array[row2][col2] = array[row1][col1];
        array[row1][col1] = placeholder;
    }

    public static <T> void swap(T[][] array, int row1, int col1, int row2, int col2) {
        array[row2][col2] = array[row1][col1];
        array[row1][col1] = null;
    }

    public static void shift(Direction direction, double[][] array, int row, int col) {
        direction.shift(array, row, col);
    }

    public static void shift(Direction direction, float[][] array, int row, int col) {
        direction.shift(array, row, col);
    }

    public static void shift(Direction direction, short[][] array, int row, int col) {
        direction.shift(array, row, col);
    }

    public static void shift(Direction direction, byte[][] array, int row, int col) {
        direction.shift(array, row, col);
    }

    public static void shift(Direction direction, long[][] array, int row, int col) {
        direction.shift(array, row, col);
    }

    public static void shift(Direction direction, int[][] array, int row, int col) {
        direction.shift(array, row, col);
    }

    public static <T> void shift(Direction direction, T[][] array, int row, int col) {
        direction.shift(array, row, col);
    }

    public enum Direction {
        LEFT {
            @Override
            protected void shift(double[][] array, int row, int col) {
                int col2 = col - 1;
                if (col2 >= 0) {
                    array[row][col2] = array[row][col];
                    array[row][col] = 0.0;
                }
            }

            @Override
            protected void shift(float[][] array, int row, int col) {
                int col2 = col - 1;
                if (col2 >= 0) {
                    array[row][col2] = array[row][col];
                    array[row][col] = 0;
                }
            }

            @Override
            protected void shift(long[][] array, int row, int col) {
                int col2 = col - 1;
                if (col2 >= 0) {
                    array[row][col2] = array[row][col];
                    array[row][col] = 0;
                }
            }

            @Override
            protected void shift(short[][] array, int row, int col) {
                int col2 = col - 1;
                if (col2 >= 0) {
                    array[row][col2] = array[row][col];
                    array[row][col] = 0;
                }
            }

            @Override
            protected void shift(byte[][] array, int row, int col) {
                int col2 = col - 1;
                if (col2 >= 0) {
                    array[row][col2] = array[row][col];
                    array[row][col] = 0;
                }
            }

            @Override
            protected void shift(int[][] array, int row, int col) {
                int col2 = col - 1;
                if (col2 >= 0) {
                    array[row][col2] = array[row][col];
                    array[row][col] = 0;
                }
            }

            @Override
            protected <T> void shift(T[][] array, int row, int col) {
                int col2 = col - 1;
                if (col2 >= 0) {
                    array[row][col2] = array[row][col];
                    array[row][col] = null;
                }
            }
        }, RIGHT {
            @Override
            protected void shift(double[][] array, int row, int col) {
                int col2 = col + 1;
                if (col2 < array.length) {
                    array[row][col2] = array[row][col];
                    array[row][col] = 0;
                }
            }

            @Override
            protected void shift(float[][] array, int row, int col) {
                int col2 = col + 1;
                if (col2 < array.length) {
                    array[row][col2] = array[row][col];
                    array[row][col] = 0;
                }
            }

            @Override
            protected void shift(long[][] array, int row, int col) {
                int col2 = col + 1;
                if (col2 < array.length) {
                    array[row][col2] = array[row][col];
                    array[row][col] = 0;
                }
            }

            @Override
            protected void shift(short[][] array, int row, int col) {
                int col2 = col + 1;
                if (col2 < array.length) {
                    array[row][col2] = array[row][col];
                    array[row][col] = 0;
                }
            }

            @Override
            protected void shift(byte[][] array, int row, int col) {
                int col2 = col + 1;
                if (col2 < array.length) {
                    array[row][col2] = array[row][col];
                    array[row][col] = 0;
                }
            }

            @Override
            protected void shift(int[][] array, int row, int col) {
                int col2 = col + 1;
                if (col2 < array.length) {
                    array[row][col2] = array[row][col];
                    array[row][col] = 0;
                }
            }

            @Override
            protected <T> void shift(T[][] array, int row, int col) {
                int col2 = col + 1;
                if (col2 < array.length) {
                    array[row][col2] = array[row][col];
                    array[row][col] = null;
                }
            }
        }, UP {
            @Override
            protected void shift(double[][] array, int row, int col) {
                int row2 = row - 1;
                if (row2 >= 0) {
                    array[row2][col] = array[row][col];
                    array[row][col] = 0.0;
                }
            }

            @Override
            protected void shift(float[][] array, int row, int col) {
                int row2 = row - 1;
                if (row2 >= 0) {
                    array[row2][col] = array[row][col];
                    array[row][col] = 0;
                }
            }

            @Override
            protected void shift(long[][] array, int row, int col) {
                int row2 = row - 1;
                if (row2 >= 0) {
                    array[row2][col] = array[row][col];
                    array[row][col] = 0;
                }
            }

            @Override
            protected void shift(short[][] array, int row, int col) {
                int row2 = row - 1;
                if (row2 >= 0) {
                    array[row2][col] = array[row][col];
                    array[row][col] = 0;
                }
            }

            @Override
            protected void shift(byte[][] array, int row, int col) {
                int row2 = row - 1;
                if (row2 >= 0) {
                    array[row2][col] = array[row][col];
                    array[row][col] = 0;
                }
            }

            @Override
            protected void shift(int[][] array, int row, int col) {
                int row2 = row - 1;
                if (row2 >= 0) {
                    array[row2][col] = array[row][col];
                    array[row][col] = 0;
                }
            }

            @Override
            protected <T> void shift(T[][] array, int row, int col) {
                int row2 = row - 1;
                if (row2 >= 0) {
                    array[row2][col] = array[row][col];
                    array[row][col] = null;
                }
            }
        }, DOWN {
            @Override
            protected void shift(double[][] array, int row, int col) {
                int row2 = row + 1;
                if (row2 < array.length) {
                    array[row2][col] = array[row][col];
                    array[row][col] = 0.0;
                }
            }

            @Override
            protected void shift(float[][] array, int row, int col) {
                int row2 = row + 1;
                if (row2 < array.length) {
                    array[row2][col] = array[row][col];
                    array[row][col] = 0;
                }
            }

            @Override
            protected void shift(long[][] array, int row, int col) {
                int row2 = row + 1;
                if (row2 < array.length) {
                    array[row2][col] = array[row][col];
                    array[row][col] = 0;
                }
            }

            @Override
            protected void shift(short[][] array, int row, int col) {
                int row2 = row + 1;
                if (row2 < array.length) {
                    array[row2][col] = array[row][col];
                    array[row][col] = 0;
                }
            }

            @Override
            protected void shift(byte[][] array, int row, int col) {
                int row2 = row + 1;
                if (row2 < array.length) {
                    array[row2][col] = array[row][col];
                    array[row][col] = 0;
                }
            }

            @Override
            protected void shift(int[][] array, int row, int col) {
                int row2 = row + 1;
                if (row2 < array.length) {
                    array[row2][col] = array[row][col];
                    array[row][col] = 0;
                }
            }

            @Override
            protected <T> void shift(T[][] array, int row, int col) {
                int row2 = row + 1;
                if (row2 < array.length) {
                    array[row2][col] = array[row][col];
                    array[row][col] = null;
                }
            }
        };

        protected abstract void shift(double[][] array, int row, int col);

        protected abstract void shift(float[][] array, int row, int col);

        protected abstract void shift(long[][] array, int row, int col);

        protected abstract void shift(short[][] array, int row, int col);

        protected abstract void shift(byte[][] array, int row, int col);

        protected abstract void shift(int[][] array, int row, int col);

        protected abstract <T> void shift(T[][] array, int row, int col);
    }
}

package iitc.projects.twentyfourtyeight;

import iitc.im.Array2D;

public enum Shift {
    LEFT {
        @Override
        boolean shiftBoard(Board game) {
            boolean shifted = false;
            for (int row = 0; row < game.current.length; row++)
                if (shiftBoard(game, row))
                    shifted = true;
            return shifted;
        }

        boolean shiftBoard(Board game, int row) {
            boolean shifted = false;
            boolean hasCombined = false;
            for (int col = 1; col < game.current.length; col++) {
                if (game.isOpen(row, col))
                    continue;
                for (int col2 = col - 1; col2 >= 0; --col2) {
                    if (game.isOpen(row, col2)) {
                        Array2D.shift(Array2D.Direction.LEFT, game.current, row, col2 + 1);
                        shifted = true;
                    } else if (!hasCombined && game.canCombine(row, col2 + 1, row, col2)) {
                        game.score += game.combine(row, col2 + 1, row, col2);
                        hasCombined = true;
                    }
                }
            }
            return shifted || hasCombined;
        }
    }, RIGHT {
        @Override
        boolean shiftBoard(Board game) {
            boolean shifted = false;
            for (int row = 0; row < game.current.length; row++)
                if (shiftBoard(game, row))
                    shifted = true;
            return shifted;
        }

        boolean shiftBoard(Board game, int row) {
            boolean shifted = false;
            boolean hasCombined = false;
            for (int col = game.current.length - 2; col >= 0; --col) {
                if (game.isOpen(row, col))
                    continue;
                for (int col2 = col + 1; col2 < game.current.length; col2++) {
                    if (game.isOpen(row, col2)) {
                        Array2D.shift(Array2D.Direction.RIGHT, game.current, row, col2 - 1);
                        shifted = true;
                    } else if (!hasCombined && game.canCombine(row, col2 - 1, row, col2)) {
                        game.score += game.combine(row, col2 - 1, row, col2);
                        hasCombined = true;
                    }
                }
            }
            return shifted || hasCombined;
        }
    }, UP {
        @Override
        boolean shiftBoard(Board game) {
            boolean shifted = false;
            for (int col = 0; col < game.current[0].length; col++)
                if (shiftBoard(game, col))
                    shifted = true;
            return shifted;
        }

        boolean shiftBoard(Board game, int col) {
            boolean shifted = false;
            boolean hasCombined = false;
            for (int row = 1; row < game.current.length; row++) {
                if (game.isOpen(row, col))
                    continue;
                for (int row2 = row - 1; row2 >= 0; --row2) {
                    if (game.isOpen(row2, col)) {
                        Array2D.shift(Array2D.Direction.UP, game.current, row2 + 1, col);
                        shifted = true;
                    } else if (!hasCombined && game.canCombine(row2 + 1, col, row2, col)) {
                        game.score += game.combine(row2 + 1, col, row2, col);
                        hasCombined = true;
                    }
                }
            }
            return shifted || hasCombined;
        }
    }, DOWN {
        @Override
        boolean shiftBoard(Board game) {
            boolean shifted = false;
            for (int col = 0; col < game.current[0].length; col++)
                if (shiftBoard(game, col))
                    shifted = true;
            return shifted;
        }

        boolean shiftBoard(Board game, int col) {
            boolean shifted = false;
            boolean hasCombined = false;
            for (int row = game.current.length - 2; row >= 0; --row) {
                if (game.isOpen(row, col))
                    continue;
                for (int row2 = row + 1; row2 < game.current.length; row2++) {
                    if (game.isOpen(row2, col)) {
                        Array2D.shift(Array2D.Direction.DOWN, game.current, row2 - 1, col);
                        shifted = true;
                    } else if (!hasCombined && game.canCombine(row2 - 1, col, row2, col)) {
                        game.score += game.combine(row2 - 1, col, row2, col);
                        hasCombined = true;
                    }
                }
            }
            return shifted || hasCombined;
        }
    };

    abstract boolean shiftBoard(Board game);

    @Override
    public String toString() {
        return name();
    }
}
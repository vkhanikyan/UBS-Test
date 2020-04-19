package com.ubs.vahan.test;

import org.junit.Test;

public class SudokuValidatorExceptionalCasesTest {
    @Test(expected = IllegalArgumentException.class)
    public void nullTest() {
        SudokuValidator.isValid(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidHeightTest() {
        int[][] board = new int[][]{
                {9, 0, 4, 0, 6, 0, 7, 0, 1},
                {0, 2, 0, 4, 0, 3, 0, 8, 0},
                {8, 0, 0, 0, 0, 0, 0, 0, 4},
                {0, 0, 1, 8, 4, 9, 6, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 3, 2, 5, 7, 9, 0, 0},
                {4, 0, 0, 0, 0, 0, 0, 0, 7},
                {0, 8, 0, 6, 0, 4, 0, 5, 0},
        };
        SudokuValidator.isValid(board);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidWidthTest() {
        int[][] board = new int[][]{
                {9, 0, 4, 0, 6, 0, 7, 0, 1, 0},
                {0, 2, 0, 4, 0, 3, 0, 8, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 0, 4, 0},
                {0, 0, 1, 8, 4, 9, 6, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 3, 2, 5, 7, 9, 0, 0, 0},
                {4, 0, 0, 0, 0, 0, 0, 0, 7, 0},
                {0, 8, 0, 6, 0, 4, 0, 5, 0, 0},
                {5, 0, 6, 0, 8, 0, 2, 0, 3, 0}
        };
        SudokuValidator.isValid(board);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidNumberTest() {
        int[][] board = new int[][]{
                {9, 0, 4, 0, 6, 0, 7, 0, 1},
                {0, 2, 0, 4, 0, 3, 0, 8, 0},
                {8, 0, 0, 0, 0, 0, 0, 0, 4},
                {0, 0, 1, 8, 4, 9, 6, 0, 0},
                {0, 0, 0, 0, 10, 0, 0, 0, 0}, // have value 10
                {0, 0, 3, 2, 5, 7, 9, 0, 0},
                {4, 0, 0, 0, 0, 0, 0, 0, 7},
                {0, 8, 0, 6, 0, 4, 0, 5, 0},
                {5, 0, 6, 0, 8, 0, 2, 0, 3}
        };
        SudokuValidator.isValid(board);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidNegativeNumberTest() {
        int[][] board = new int[][]{
                {9, 0, 4, 0, 6, 0, 7, 0, 1},
                {0, 2, 0, 4, 0, 3, 0, 8, 0},
                {8, 0, 0, 0, 0, 0, 0, 0, 4},
                {0, 0, 1, 8, 4, 9, 6, 0, 0},
                {0, 0, 0, 0, -1, 0, 0, 0, 0}, // have value -1
                {0, 0, 3, 2, 5, 7, 9, 0, 0},
                {4, 0, 0, 0, 0, 0, 0, 0, 7},
                {0, 8, 0, 6, 0, 4, 0, 5, 0},
                {5, 0, 6, 0, 8, 0, 2, 0, 3}
        };
        SudokuValidator.isValid(board);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidShapeTest() {
        int[][] board = new int[][]{
                {9, 0, 4, 0, 6, 0, 7, 0, 1},
                {0, 2, 0, 4, 0, 3, 0, 8, 0},
                {8, 0, 0, 0, 0, 0, 0, 0, 4},
                {0, 0, 1, 8, 4, 9, 6, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // have invalid shape
                {0, 0, 3, 2, 5, 7, 9, 0, 0},
                {4, 0, 0, 0, 0, 0, 0, 0, 7},
                {0, 8, 0, 6, 0, 4, 0, 5, 0},
                {5, 0, 6, 0, 8, 0, 2, 0, 3}
        };
        SudokuValidator.isValid(board);
    }
}
package com.ubs.vahan.test;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertArrayEquals;

public class CSVReaderSudokuTest {

    @Test
    public void read_2LinesTest() throws IOException {
        String[][] data = CSVReaderSudoku.read(FileUtils.getAbsolutePathFromCSVFolder("2_lines.csv"));
        String[][] expected = new String[][]{
                {"one", "two", "three"},
                {"four", "five", "six"},
        };

        assertArrayEquals(expected, data);
    }

    @Test
    public void read_validSudokuBoardTest() throws IOException {
        String[][] data = CSVReaderSudoku.read(FileUtils.getAbsolutePathFromCSVFolder("valid_sudoku_board.csv"));
        String[][] expected = new String[][]{
                {"9", "0", "4", "0", "6", "0", "7", "0", "1"},
                {"0", "2", "0", "4", "0", "3", "0", "8", "0"},
                {"8", "0", "0", "0", "0", "0", "0", "0", "4"},
                {"0", "0", "1", "8", "4", "9", "6", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "3", "2", "5", "7", "9", "0", "0"},
                {"4", "0", "0", "0", "0", "0", "0", "0", "7"},
                {"0", "8", "0", "6", "0", "4", "0", "5", "0"},
                {"5", "0", "6", "0", "8", "0", "2", "0", "3"}
        };

        assertArrayEquals(expected, data);
    }

    @Test
    public void readInts_validSudokuBoardTest() throws IOException {
        int[][] data = CSVReaderSudoku.readInts(FileUtils.getAbsolutePathFromCSVFolder("valid_sudoku_board.csv"));
        int[][] expected = new int[][]{
                {9, 0, 4, 0, 6, 0, 7, 0, 1},
                {0, 2, 0, 4, 0, 3, 0, 8, 0},
                {8, 0, 0, 0, 0, 0, 0, 0, 4},
                {0, 0, 1, 8, 4, 9, 6, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 3, 2, 5, 7, 9, 0, 0},
                {4, 0, 0, 0, 0, 0, 0, 0, 7},
                {0, 8, 0, 6, 0, 4, 0, 5, 0},
                {5, 0, 6, 0, 8, 0, 2, 0, 3}
        };

        assertArrayEquals(expected, data);
    }

    @Test
    public void readInts_invalidSudokuBoardTest() throws IOException {
        int[][] data = CSVReaderSudoku.readInts(FileUtils.getAbsolutePathFromCSVFolder("invalid_sudoku_board.csv"));
        int[][] expected = new int[][]{
                {9, 0, 4, 0, 6, 0, 7, 0, 1},
                {0, 2, 0, 4, 0, 3, 0, 8, 0},
                {8, 0, 0, 0, 0, 0, 0, 0, 4},
                {0, 0, 1, 8, 4, 9, 6, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 3, 2, 5, 7, 9, 0, 0},
                {4, 0, 0, 0, 0, 0, 0, 0, 7},
                {0, 8, 0, 6, 0, 4, 0, 5, 0},
                {5, 0, 6, 0, 8, 0, 2, 0, 3}
        };

        assertArrayEquals(expected, data);
    }
}
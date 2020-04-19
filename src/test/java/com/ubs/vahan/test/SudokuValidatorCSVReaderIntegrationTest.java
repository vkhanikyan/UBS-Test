package com.ubs.vahan.test;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SudokuValidatorCSVReaderIntegrationTest {
    @Test
    public void readInts_validSudokuBoardTest() throws IOException {
        int[][] data = CSVReaderSudoku.readInts(FileUtils.getAbsolutePathFromCSVFolder("valid_sudoku_board.csv"));
        assertTrue(SudokuValidator.isValid(data));
    }

    @Test
    public void readInts_invalidSudokuBoardTest() throws IOException {
        int[][] data = CSVReaderSudoku.readInts(FileUtils.getAbsolutePathFromCSVFolder("invalid_sudoku_board.csv"));
        assertFalse(SudokuValidator.isValid(data));
    }
}

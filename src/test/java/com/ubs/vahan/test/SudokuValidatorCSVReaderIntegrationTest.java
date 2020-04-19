package com.ubs.vahan.test;

import com.ubs.vahan.test.exception.SudokuValidatorException;
import org.junit.Test;

import java.io.IOException;

public class SudokuValidatorCSVReaderIntegrationTest {
    @Test
    public void readInts_validSudokuBoardTest() throws IOException, SudokuValidatorException {
        int[][] data = CSVReaderSudoku.readInts(FileUtils.getAbsolutePathFromCSVFolder("valid_sudoku_board.csv"));
        SudokuValidator.validate(data);
    }

    @Test(expected = SudokuValidatorException.class)
    public void readInts_invalidSudokuBoardTest() throws IOException, SudokuValidatorException {
        int[][] data = CSVReaderSudoku.readInts(FileUtils.getAbsolutePathFromCSVFolder("invalid_sudoku_board.csv"));
        SudokuValidator.validate(data);
    }
}

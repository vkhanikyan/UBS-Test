package com.ubs.vahan.test;

import com.ubs.vahan.test.exception.SudokuValidatorException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AppMain {
    private static final Logger LOGGER = Logger.getLogger(AppMain.class.getName());

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please give the path of the csv file as a parameter");
            System.exit(1);
            return;
        }
        try {
            String path = args[0];
            int[][] board = CSVReaderSudoku.readInts(path);
            SudokuValidator.validate(board);
            System.out.println("it is valid Sudoku board");
            System.exit(0);
        } catch (SudokuValidatorException e) {
            System.out.println(String.format("it is invalid Sudoku board. Reason: %s", e.getMessage()));
            System.exit(1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            LOGGER.log(Level.SEVERE, "Exception occur", e);
            System.exit(1);
        }
    }
}

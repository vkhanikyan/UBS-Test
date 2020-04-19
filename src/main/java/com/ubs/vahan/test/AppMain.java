package com.ubs.vahan.test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AppMain {
    private static final Logger LOGGER = Logger.getLogger(AppMain.class.getName());

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please give the path of the csv file as a parameter");
            return;
        }
        try {
            String path = args[0];
            int[][] board = CSVReaderSudoku.readInts(path);
            boolean isValid = SudokuValidator.isValid(board);
            System.out.println(isValid ? "it is valid Sudoku board" : "it is invalid Sudoku board");
            System.exit(0);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Exception occur", e);
            System.exit(1);
        }
    }
}

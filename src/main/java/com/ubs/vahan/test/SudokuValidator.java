package com.ubs.vahan.test;

import java.util.HashSet;
import java.util.Set;

/**
 * Used enum as it is comfortable to use it as util class
 */
public enum SudokuValidator {
    ;

    public static boolean isValid(int[][] board) {
        validate(board);
        for (int i = 0; i < 9; i++) {

            int[] row = new int[9];
            int[] square = new int[9];
            int[] column = board[i];

            for (int j = 0; j < 9; j++) {
                row[j] = board[j][i];
                square[j] = board[(i / 3) * 3 + j / 3][i * 3 % 9 + j % 3];
            }
            if (!(isUnique(column) && isUnique(row) && isUnique(square)))
                return false;
        }
        return true;
    }

    private static void validate(int[][] board) {
        if (board == null) {
            throw new IllegalArgumentException("The board is empty");
        }

        validateHeight(board);
        validateWidth(board);
        validateValues(board);

    }

    private static void validateValues(int[][] board) {
        for (int[] row : board) {
            for (int item : row) {
                if (!(item >= 0 && item <= 9)) {
                    throw new IllegalArgumentException(String.format("The board item has value not in 1-9 range, it is: %d", item));
                }
            }
        }
    }

    private static void validateWidth(int[][] board) {
        for (int[] row : board) {
            if (row.length != 9) {
                throw new IllegalArgumentException(String.format("The board width is not 9, it is: %d", row.length));
            }
        }
    }

    private static void validateHeight(int[][] board) {
        if (board.length != 9) {
            throw new IllegalArgumentException(String.format("The board height is not 9, it is: %d", board.length));
        }
    }


    /**
     * Check if the array have unique values. Skip the 0s
     */
    static boolean isUnique(int[] check) {
        Set<Integer> set = new HashSet<>();
        for (int number : check) {
            // skip as empty
            if (number == 0)
                continue;

            // if set contains the element, then we have duplicate
            if (!set.add(number)) {
                return false;
            }
        }
        return true;
    }
}

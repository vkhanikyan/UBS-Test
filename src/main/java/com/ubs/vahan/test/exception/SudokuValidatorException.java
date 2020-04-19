package com.ubs.vahan.test.exception;

public class SudokuValidatorException extends Exception {
    public SudokuValidatorException(String message, Object... parameters) {
        super(String.format(message, parameters));
    }

    public SudokuValidatorException(String message, Throwable cause) {
        super(message, cause);
    }
}

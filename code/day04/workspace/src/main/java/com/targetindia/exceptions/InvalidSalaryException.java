package com.targetindia.exceptions;

public class InvalidSalaryException extends Exception {
    public InvalidSalaryException() {
        super("Invalid salary given");
    }

    public InvalidSalaryException(String message) {
        super(message);
    }

    public InvalidSalaryException(Throwable cause) {
        super(cause);
    }
}

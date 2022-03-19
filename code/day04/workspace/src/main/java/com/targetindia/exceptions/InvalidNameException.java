package com.targetindia.exceptions;

// application developers write checked exceptions'
// framework developers write unchecked exceptions'
public class InvalidNameException extends Exception{
    public InvalidNameException() {
        super("Invalid name");
    }

    public InvalidNameException(String message) {
        super(message);
    }

    public InvalidNameException(Throwable cause) {
        super(cause);
    }

}

package com.targetindia.exceptions;

public class InvalidEmployeeIdException extends Exception{
    public InvalidEmployeeIdException() {
        super("Invalid id for an employee");
    }

    public InvalidEmployeeIdException(String message) {
        super(message);
    }


    public InvalidEmployeeIdException(Throwable cause) {
        super(cause);
    }

}

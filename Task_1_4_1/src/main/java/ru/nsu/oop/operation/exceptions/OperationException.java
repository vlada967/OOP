package ru.nsu.oop.operation.exceptions;

public class OperationException extends Exception {
    public OperationException() {
        super();
    }

    public OperationException(String errorMessage) {
        super(errorMessage);
    }
}

package ru.nsu.oop.operation.exceptions;

public class BadNumberTypeException extends OperationException {
    public BadNumberTypeException() {
        super();
    }

    public BadNumberTypeException(String errorMessage) {
        super(errorMessage);
    }
}

package ru.nsu.oop.operation;

import ru.nsu.oop.operation.operations.*;

public class OperationFabrication {

    private static Map<String, Operation> operations;

    public OperationFabrication() {
        operations = new HashMap<>() {
            put("sqrt", new SquareRoot());
            put("log", new Logarithm());
            put("sin", new Sinus());
            put("cos", new Cosine());
            put("pow", new Power());
            put("+", new Addition());
            put("-", new Subtraction());
            put("*", new Multiplication());
            put("/", new Division());
            put("deg", new Degrees());
        };
    }

    public static Operation getOperation(String operationName) {
        Operation operation = operations.get(operationName);
        if (operation == null) {
            throw new IllegalArgumentException("The operation does not exist");
        }
        return operation;
    }

    public void addOperations(Map<String, Operation> extraOperations) {
        operations.putAll(extraOperations);
    }
}

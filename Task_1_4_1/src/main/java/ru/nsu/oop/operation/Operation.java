package ru.nsu.oop.operation;

import ru.nsu.oop.operation.arity.Arity;
import ru.nsu.oop.operation.exceptions.OperationException;

public abstract class Operation {
    private final Arity arity;

    public Operation(Arity arity) {
        this.arity = arity;
    }

    public Arity getArity() {
        return arity;
    }

    public abstract Number eval(Number... arguments) throws OperationException;
}

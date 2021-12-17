package ru.nsu.oop.operation.arity;

import ru.nsu.oop.number.Complex;
import ru.nsu.oop.operation.exceptions.BadNumberTypeException;
import ru.nsu.oop.operation.exceptions.InvalidNumberArgumentsException;
import ru.nsu.oop.operation.exceptions.OperationException;
import ru.nsu.oop.operation.Operation;

import static ru.nsu.oop.operation.arity.Arity.UNARY;

public abstract class UnaryOperation extends Operation {
    public UnaryOperation() {
        super(UNARY);
    }

    public abstract Number eval1(Double number);

    public abstract Number eval1(Complex number) throws OperationException;

    @Override
    public Number eval(Number... arguments) throws OperationException {
        if (arguments.length != UNARY.getArgumentsNumber()) {
            throw new InvalidNumberArgumentsException();
        }

        if (arguments[0] instanceof Double doubleNumber) {
            return eval1(doubleNumber);
        }

        if (arguments[0] instanceof Complex complexNumber) {
            return eval1(complexNumber);
        }

        throw new BadNumberTypeException("Unable to determine the behavior of a unary operation for a given type of " +
                "number: " + arguments[0].getClass().getName());
    }
}

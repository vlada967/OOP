package ru.nsu.oop.operation.arity;

import ru.nsu.oop.number.Complex;
import ru.nsu.oop.operation.exceptions.BadNumberTypeException;
import ru.nsu.oop.operation.exceptions.InvalidNumberArgumentsException;
import ru.nsu.oop.operation.exceptions.OperationException;
import ru.nsu.oop.operation.Operation;

import static ru.nsu.oop.operation.arity.Arity.BINARY;

public abstract class BinaryOperation extends Operation {
    public BinaryOperation() {
        super(BINARY);
    }

    public abstract Number eval2(Double number1, Double number2) throws OperationException;

    public abstract Number eval2(Double number1, Complex number2) throws OperationException;

    public abstract Number eval2(Complex number1, Double number2) throws OperationException;

    public abstract Number eval2(Complex number1, Complex number2) throws OperationException;

    @Override
    public Number eval(Number... arguments) throws OperationException {
        if (arguments.length != BINARY.getArgumentsNumber()) {
            throw new InvalidNumberArgumentsException();
        }

        if (arguments[0] instanceof Double doubleNumber1 && arguments[1] instanceof Double doubleNumber2) {
            return eval2(doubleNumber1, doubleNumber2);
        }

        if (arguments[0] instanceof Double doubleNumber && arguments[1] instanceof Complex complexNumber) {
            return eval2(doubleNumber, complexNumber);
        }

        if (arguments[0] instanceof Complex complexNumber && arguments[1] instanceof Double doubleNumber) {
            return eval2(complexNumber, doubleNumber);
        }

        if (arguments[0] instanceof Complex complexNumber1 && arguments[1] instanceof Complex complexNumber2) {
            return eval2(complexNumber1, complexNumber2);
        }

        throw new BadNumberTypeException("Unable to determine the behavior of a binary operation for a given type of " +
                "numbers: " + arguments[0].getClass().getName() + " and " + arguments[1].getClass().getName());
    }

}

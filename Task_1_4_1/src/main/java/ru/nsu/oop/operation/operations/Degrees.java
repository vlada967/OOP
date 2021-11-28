package ru.nsu.oop.operation.operations;

import ru.nsu.oop.number.Complex;
import ru.nsu.oop.operation.arity.UnaryOperation;

public class Degrees extends UnaryOperation {
    @Override
    public Number eval1(Double number) {
        return Math.toRadians(number);
    }

    @Override
    public Number eval1(Complex number) {
        return new Multiplication().eval2(Math.PI / 180, number);
    }
}

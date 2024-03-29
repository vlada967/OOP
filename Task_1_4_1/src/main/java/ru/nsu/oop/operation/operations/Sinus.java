package ru.nsu.oop.operation.operations;

import ru.nsu.oop.number.Complex;
import ru.nsu.oop.operation.arity.UnaryOperation;

public class Sinus extends UnaryOperation {
    @Override
    public Number eval1(Double number) {
        return Math.sin(number);
    }

    @Override
    public Number eval1(Complex number) {
        double realPart = number.getRealPart();
        double imaginaryPart = number.getImaginaryPart();
        if (imaginaryPart == 0.0) {
            return eval1(realPart);
        }

        double resultRealPart = Math.sin(realPart) * Math.cosh(imaginaryPart);
        double resultImaginaryPart = Math.cos(realPart) * Math.sinh(imaginaryPart);
        return new Complex(resultRealPart, resultImaginaryPart);
    }
}

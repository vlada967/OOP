package ru.nsu.fit.oop.task1_4_1;

public class CalculatorException extends Exception {
    public CalculatorException(){
        super();
    }

    public CalculatorException(String errorMessage) {
        super(errorMessage);
    }
}

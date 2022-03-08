package ru.nsu.oop.calculator;

import ru.nsu.oop.calculator.exceptions.CalculatorException;
import ru.nsu.oop.operation.exceptions.OperationException;

public interface Calculator {
    Number calculate(String expression) throws CalculatorException, OperationException;
}

package ru.nsu.fit.oop.task1_4_1;

import org.junit.jupiter.api.*;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void init() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Addition")
    public void calculate_Add() throws CalculatorException {
        Assertions.assertEquals(calculator.calculate("+ 2 2"), Double.valueOf(4));
    }

    @Test
    @DisplayName("Subtraction")
    public void calculate_Subtract() throws CalculatorException {
        Assertions.assertEquals(calculator.calculate("- 4 2"), Double.valueOf(2));
    }

    @Test
    @DisplayName("Multiplication")
    public void calculate_Multiply() throws CalculatorException {
        Assertions.assertEquals(calculator.calculate("* 2 2"), Double.valueOf(4));
    }

    @Test
    @DisplayName("Division")
    public void calculate_Divide() throws CalculatorException {
        Assertions.assertEquals(calculator.calculate("/ 4 2"), Double.valueOf(2));
    }

    @Test
    @DisplayName("Exponentiation")
    public void calculate_Power() throws CalculatorException {
        Assertions.assertEquals(calculator.calculate("pow 2 2"), Double.valueOf(4));
    }

    @Test
    @DisplayName("Natural logarithm")
    public void calculate_Log() throws CalculatorException {
        Assertions.assertEquals(calculator.calculate("log " + Math.E), Double.valueOf(1));
    }

    @Test
    @DisplayName("Square root")
    public void calculate_Sqrt() throws CalculatorException {
        Assertions.assertEquals(calculator.calculate("sqrt 4"), Double.valueOf(2));
    }

    @Test
    @DisplayName("Sine")
    public void calculate_Sin() throws CalculatorException {
        Assertions.assertEquals(calculator.calculate("sin " + Math.PI / 2), Double.valueOf(1));
    }

    @Test
    @DisplayName("Cosine")
    public void calculate_Cos() throws CalculatorException {
        Assertions.assertEquals(calculator.calculate("cos " + Math.PI), Double.valueOf(-1));
    }

    @Test
    @DisplayName("Example")
    public void calculate_Example() throws CalculatorException {
        Assertions.assertEquals(calculator.calculate("sin + - 1 2 1"), Double.valueOf(0));
    }
}
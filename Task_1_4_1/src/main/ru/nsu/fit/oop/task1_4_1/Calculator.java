package ru.nsu.fit.oop.task1_4_1;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private final String[] unaryOperators = {"log", "sin", "cos", "sqrt"};
    private final String[] binaryOperators = {"+", "-", "*", "/", "pow"};
    Stack<Double> operands;

    public Calculator() {
        operands = new Stack<>();
    }

    private boolean isUnaryOperator(String string) {
        for (String operator : unaryOperators) {
            if (string.equals(operator)) return true;
        }
        return false;
    }

    private boolean isBinaryOperator(String string) {
        for (String operator : binaryOperators) {
            if (string.equals(operator)) return true;
        }
        return false;
    }

    private Atom getAtomType(String atom) {
        if (isUnaryOperator(atom))
            return Atom.UNARY_OPERATOR;

        if (isBinaryOperator(atom))
            return Atom.BINARY_OPERATOR;

        Pattern pattern = Pattern.compile("\\d+.?\\d*");
        Matcher matcher = pattern.matcher(atom);
        if (matcher.matches())
            return Atom.NUMBER;

        return null;
    }

    private Double executeOperation(String operator, Double... parameters) throws UnknownArgumentException {
        Double result;
        switch (operator) {
            case "log" -> result = Math.log(parameters[0]);
            case "sin" -> result = Math.sin(parameters[0]);
            case "cos" -> result = Math.cos(parameters[0]);
            case "sqrt" -> result = Math.sqrt(parameters[0]);
            case "+" -> result = parameters[0] + parameters[1];
            case "-" -> result = parameters[0] - parameters[1];
            case "*" -> result = parameters[0] * parameters[1];
            case "/" -> result = parameters[0] / parameters[1];
            case "pow" -> result = Math.pow(parameters[0], parameters[1]);
            default -> throw new UnknownArgumentException(operator);
        }
        return result;
    }

    public Double calculate(String expression) throws CalculatorException {
        if (expression == null)
            throw new IllegalArgumentException();

        String[] atoms = expression.split("\\s+");

        for (int i = atoms.length - 1; i >= 0; --i) {
            Atom type = getAtomType(atoms[i]);
            Double result;
            switch (type) {
                case NUMBER -> result = Double.parseDouble(atoms[i]);
                case UNARY_OPERATOR -> {
                    if (operands.isEmpty())
                        throw new WrongArgumentsNumberException();
                    result = executeOperation(atoms[i], operands.pop());
                }
                case BINARY_OPERATOR -> {
                    if (operands.size() < 2)
                        throw new WrongArgumentsNumberException();
                    result = executeOperation(atoms[i], operands.pop(), operands.pop());
                }
                default -> throw new UnknownArgumentException(atoms[i]);
            }
            operands.push(result);
        }

        if (operands.size() != 1)
            throw new WrongArgumentsNumberException();

        return operands.pop();
    }
}

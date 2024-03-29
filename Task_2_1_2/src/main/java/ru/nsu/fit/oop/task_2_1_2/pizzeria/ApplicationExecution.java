package ru.nsu.fit.oop.task_2_1_2.pizzeria;

/**
 * ApplicationExecution is a class with main method, which allows starting application.
 */
public class ApplicationExecution {
    /**
     * Launches an application from the command line.
     *
     * @param args - arguments from the command.
     */
    public static void main(String[] args) {
        PizzeriaApplication application = new PizzeriaApplication();
        application.run();
    }
}

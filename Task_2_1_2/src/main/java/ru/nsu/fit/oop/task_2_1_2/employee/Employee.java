package ru.nsu.fit.oop.task_2_1_2.employee;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * The implementation of this abstract method allows you to simulate the work of an employee.
 */
public abstract class Employee implements Runnable {
    private final AtomicBoolean running = new AtomicBoolean(false);
    private final int id;

    /**
     * Constructor of an abstract class. Allows to set the employee id.
     *
     * @param id - employee's id.
     */
    public Employee(int id) {
        this.id = id;
    }

    /**
     * Returns employee's id.
     *
     * @return - employee's id.
     */
    public int getId() {
        return id;
    }

    /**
     * The implementation of this abstract method should be the fulfillment of one task of the employee.
     */
    abstract void work();

    /**
     * Simulates the permanent work of an employee. Execution stops when the run method is called.
     */
    @Override
    public void run() {
        running.set(true);
        while (running.get()) {
            if (Thread.currentThread().isInterrupted()) {
                Thread.currentThread().interrupt();
                running.set(false);
                break;
            }
            work();
        }
    }

    /**
     * Stops the run method.
     */
    public void stop() {
        running.set(false);
    }
}
package ru.nsu.fit.oop.task_2_1_2.customer;

import ru.nsu.fit.oop.task_2_1_2.queue.MyBlockingDequeue;
import ru.nsu.fit.oop.task_2_1_2.order.Order;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * The Customers class simulates the behavior of the customers flow.
 * Customers create orders and place them in a shared order queue.
 */
public class Customers implements Runnable {
    private final AtomicBoolean running = new AtomicBoolean(false);
    private final MyBlockingDequeue<Order> queue;

    /**
     * Creates an instance of the class Customers.
     *
     * @param queue - shared order queue.
     */
    public Customers(MyBlockingDequeue<Order> queue) {
        this.queue = queue;
    }

    /**
     * Implementation of the Runnable interface. Starts the customers flow and stops only when stop method is called.
     */
    @Override
    public void run() {
        int index = 0;
        running.set(true);
        while (running.get()) {
            index++;
            Order order = new Order(index);
            new Customer(this.queue).produce(order);
        }
    }

    /**
     * Stops the flow of customers.
     */
    public void stop() {
        running.set(false);
    }
}

package ru.nsu.fit.oop.task_2_1_2.employee;

import ru.nsu.fit.oop.task_2_1_2.order.Order;
import ru.nsu.fit.oop.task_2_1_2.queue.MyBlockingDequeue;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static ru.nsu.fit.oop.task_2_1_2.order.State.COOKING;
import static ru.nsu.fit.oop.task_2_1_2.order.State.IN_STOCK;

/**
 * The Baker class simulates the work of a baker.
 * The baker receives an order from the general queue of orders, within a certain time (depending on his work experience) makes an order and places it in the storage.
 */
public class Baker extends Employee implements Consumer<Order>, Supplier<Order> {
    private static final long MAX_COOKING_TIME = 5000;
    private final int workingExperience;
    private final Random random;
    private final MyBlockingDequeue<Order> queue;
    private final MyBlockingDequeue<Order> storage;

    /**
     * Creates an instance of the class Baker.
     *
     * @param id                - baker's id.
     * @param workingExperience - baker's work experience.
     * @param queue             - shared order queue.
     * @param storage           - place of storage of finished orders.
     */
    public Baker(int id, int workingExperience, MyBlockingDequeue<Order> queue, MyBlockingDequeue<Order> storage) {
        super(id);
        this.workingExperience = workingExperience;
        this.random = new Random();
        this.queue = queue;
        this.storage = storage;
    }

    /**
     * Takes an order out of the order queue, executes the order within a certain time, and then sends it to the storage.
     * This method is used in the run method, which allows to simulate the constant work of a baker.
     * In case of failure, this method stops the run method.
     */
    @Override
    public void work() {
        Order order = get();
        if (order == null) {
            stop();
        }
        accept(order);
    }

    /**
     * Places the finished order in the storage.
     *
     * @param order - object which should be produced.
     */
    @Override
    public void accept(Order order) {
        long leadTime = random.nextLong(MAX_COOKING_TIME) / workingExperience;
        try {
            Thread.sleep(leadTime);
            order.setState(IN_STOCK);
            storage.put(order);
        } catch (NullPointerException exception) {
            System.err.println("The baker №" + getId() + " tried to fulfill an order that does not exist.");
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Retrieves an order from the order queue.
     *
     * @return consumed order.
     */
    @Override
    public Order get() {
        try {
            Order order = queue.get();
            order.setState(COOKING);
            return order;
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            return null;
        }
    }
}

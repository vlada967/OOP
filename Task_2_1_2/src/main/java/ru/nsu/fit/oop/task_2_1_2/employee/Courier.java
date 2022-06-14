package ru.nsu.fit.oop.task_2_1_2.employee;

import ru.nsu.fit.oop.task_2_1_2.order.Order;
import ru.nsu.fit.oop.task_2_1_2.queue.MyBlockingDequeue;
import ru.nsu.fit.oop.task_2_1_2.order.State;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

import static ru.nsu.fit.oop.task_2_1_2.order.State.*;

/**
 * The Courier class simulates the work of a courier.
 * The courier receives one or more orders from the storage and then delivers them.
 */
public class Courier extends Employee implements Supplier<List<Order>> {
    private static final long MAX_DELIVERY_TIME = 1000;
    private final int bagCapacity;
    private List<Order> orders;
    private final MyBlockingDequeue<Order> storage;
    private final Random random;

    /**
     * Creates an instance of the class Courier.
     *
     * @param id          - courier's id.
     * @param bagCapacity - couriers' bag capacity.
     * @param storage     - place of storage of finished orders.
     */
    public Courier(int id, int bagCapacity, MyBlockingDequeue<Order> storage) {
        super(id);
        this.bagCapacity = bagCapacity;
        this.storage = storage;
        this.random = new Random();
    }

    private void setOrdersState(State state) {
        for (Order order : orders) {
            order.setState(state);
        }
    }

    /**
     * Receives orders from the storage and delivers them.
     * This method is used in the run method, which allows to simulate the constant work of a courier.
     * In case of failure, this method stops the run method.
     */
    @Override
    void work() {
        List<Order> orders = get();
        if (orders == null) {
            stop();
        }
    }

    /**
     * Retrieves orders from the warehouse and delivers it.
     *
     * @return - consumed orders.
     */
    @Override
    public List<Order> get() {
        long deliveryTime = random.nextLong(MAX_DELIVERY_TIME);
        try {
            orders = storage.get(bagCapacity);
            setOrdersState(DELIVERING);
            Thread.sleep(deliveryTime);
            setOrdersState(DELIVERED);
            return orders;
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            return null;
        }
    }
}

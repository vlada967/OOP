package ru.nsu.fit.oop.task_2_1_2.pizzeria;

import ru.nsu.fit.oop.task_2_1_2.customer.Customers;
import ru.nsu.fit.oop.task_2_1_2.employee.Baker;
import ru.nsu.fit.oop.task_2_1_2.employee.Courier;
import ru.nsu.fit.oop.task_2_1_2.json.BakerJSON;
import ru.nsu.fit.oop.task_2_1_2.json.CourierJSON;
import ru.nsu.fit.oop.task_2_1_2.json.PizzeriaJSON;
import ru.nsu.fit.oop.task_2_1_2.order.Order;
import ru.nsu.fit.oop.task_2_1_2.queue.MyBlockingDequeue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class simulates the operation of a pizzeria.
 */
public class Pizzeria implements Runnable {
    private final int SLEEP_TIME = 1000;
    private List<Baker> bakers;
    private List<Courier> couriers;
    private final Customers customers;
    private final MyBlockingDequeue<Order> queue;
    private final MyBlockingDequeue<Order> storage;

    private void setBakers(BakerJSON[] bakers) {
        this.bakers = Arrays.stream(bakers)
                .map(bakerJSON -> new Baker(bakerJSON.id(), bakerJSON.workingExperience(), this.queue, this.storage))
                .collect(Collectors.toList());
    }

    private void setCouriers(CourierJSON[] couriers) {
        this.couriers = Arrays.stream(couriers)
                .map(courierJSON -> new Courier(courierJSON.id(), courierJSON.bagCapacity(), this.storage))
                .collect(Collectors.toList());
    }

    /**
     * Sets up a pizzeria based on the pizzeriaJson content.
     *
     * @param settings - pizzeria configuration.
     */
    public Pizzeria(PizzeriaJSON settings) {
        this.queue = new MyBlockingDequeue<>(settings.queueSize());
        this.storage = new MyBlockingDequeue<>(settings.storageSize());
        this.customers = new Customers(this.queue);
        setBakers(settings.bakers());
        setCouriers(settings.couriers());
    }

    /**
     * Launches a pizzeria. The pizzeria stops working either when the stop method is called, or when an error occurs.
     */
    @Override
    public void run() {
        Thread customersThread = new Thread(this.customers);
        customersThread.start();
        bakers.stream().map(Thread::new).forEach(Thread::start);
        couriers.stream().map(Thread::new).forEach(Thread::start);
        System.out.println("The pizzeria is up and running!");
    }

    /**
     * Stops the pizzeria from working.
     */
    public void stop() {
        this.customers.stop();
        try {
            Thread.sleep(this.SLEEP_TIME);
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
        bakers.forEach(Baker::stop);
        try {
            Thread.sleep(this.SLEEP_TIME);
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
        couriers.forEach(Courier::stop);
        try {
            Thread.sleep(this.SLEEP_TIME);
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
    }
}

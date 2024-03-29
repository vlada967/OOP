package ru.nsu.fit.oop.task_2_1_2.pizzeria;

import ru.nsu.fit.oop.task_2_1_2.json.BakerJSON;
import ru.nsu.fit.oop.task_2_1_2.json.CourierJSON;
import ru.nsu.fit.oop.task_2_1_2.json.JSONReader;
import ru.nsu.fit.oop.task_2_1_2.json.PizzeriaJSON;

/**
 * This class reads the parameters of the pizzeria from the file, checks them for errors, configures the pizzeria and launches it.
 */
public class PizzeriaApplication implements Runnable {
    private final static long RUNNING_TIME = 30 * 1000;
    private PizzeriaJSON pizzeriaJSON;
    private Pizzeria pizzeria;

    private void setPizzeriaJSON() {
        JSONReader jsonReader = new JSONReader();
        jsonReader.open();
        pizzeriaJSON = jsonReader.read();
        jsonReader.close();
    }

    private void setPizzeria() {
        if (pizzeriaJSON == null) {
            System.err.println("Missing pizzeria configuration.");
            return;
        }
        if (pizzeriaJSON.queueSize() <= 0) {
            System.err.println("Queue size must be a positive number.");
            return;
        }
        if (pizzeriaJSON.storageSize() <= 0) {
            System.err.println("Storage size must be a positive number.");
            return;
        }
        BakerJSON[] bakersJSON = pizzeriaJSON.bakers();
        if (bakersJSON == null || bakersJSON.length == 0) {
            System.err.println("A pizzeria cannot operate without bakers. Please add bakers to the pizzeria configuration.");
            return;
        }
        CourierJSON[] couriersJSON = pizzeriaJSON.couriers();
        if (couriersJSON == null || couriersJSON.length == 0) {
            System.err.println("A pizzeria cannot operate without couriers. Please add couriers to the pizzeria configuration.");
            return;
        }
        pizzeria = new Pizzeria(pizzeriaJSON);
    }

    /**
     * Creates an instance of the class PizzeriaApplication.
     */
    public PizzeriaApplication() {
        setPizzeriaJSON();
        setPizzeria();
    }

    /**
     * Launches a pizzeria.
     * The application runs for a set time. In case of an error, it stops the application and displays a message.
     */
    @Override
    public void run() {
        if (pizzeria == null) {
            System.err.println("Failed to start pizzeria application.");
            System.exit(1);
        }
        Thread pizzeriaThread = new Thread(pizzeria);
        pizzeriaThread.start();
        try {
            Thread.sleep(RUNNING_TIME);
            pizzeria.stop();
            System.exit(0);
        } catch (InterruptedException exception) {
            System.err.println("The pizzeria application ended with an error.");
            System.exit(2);
        }
    }
}

package ru.nsu.fit.oop.task_2_1_2;

public abstract class Consumer implements Runnable {
    private boolean isRunning;

    abstract void consume() throws InterruptedException;

    @Override
    public void run() {
        isRunning = true;
        while(isRunning) {
            try {
                consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void stop(){
        isRunning = false;
    }
}
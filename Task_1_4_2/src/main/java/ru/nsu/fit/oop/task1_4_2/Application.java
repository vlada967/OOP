package ru.nsu.fit.oop.task1_4_2;

/**
 * Application is a class with main method, which allows starting application.
 */
public class Application {
    /**
     * Get arguments from command line and pass them to run method from {@link NotebookApplication}
     *
     * @param args - arguments from command line.
     */
    public static void main(String[] args) {
        NotebookApplication application = new NotebookApplication();
        application.run(args);
    }
}

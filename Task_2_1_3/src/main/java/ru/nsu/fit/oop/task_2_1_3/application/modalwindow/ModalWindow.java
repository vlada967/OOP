package ru.nsu.fit.oop.task_2_1_3.application.modalwindow;

import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.nsu.fit.oop.task_2_1_3.application.configuration.Configuration;

import java.io.IOException;

/**
 * This class is a modal window that opens during the snake game.
 */
public class ModalWindow {
    private Stage modalWindowStage;
    private ModalWindowController controller;

    /**
     * Class constructor. Initializes a modal window and a controller.
     *
     * @param stage         - the main window with snake game.
     * @param configuration - the current configuration of the snake game.
     * @param timeline      - the instance of the class responsible for changing the frames of the snake game.
     */
    public ModalWindow(Stage stage, Configuration configuration, Timeline timeline) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ru/nsu/fit/oop/task_2_1_3/fxml/modalWindow.fxml"));
        try {
            Parent root = loader.load();
            controller = loader.getController();
            controller.initialize(stage, configuration, timeline);
            modalWindowStage = new Stage();
            modalWindowStage.setScene(new Scene(root));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Opens modal window with the specified header.
     *
     * @param header - header for the modal window.
     */
    public void open(String header) {
        if (controller != null && modalWindowStage != null && !modalWindowStage.isShowing()) {
            controller.setHeader(header);
            modalWindowStage.show();
        }
    }
}

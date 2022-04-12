module ru.nsu.fit.oop.task_2_1_3 {
    requires javafx.controls;
    requires javafx.fxml;

    opens ru.nsu.fit.oop.task_2_1_3 to javafx.fxml;
    exports ru.nsu.fit.oop.task_2_1_3;
    exports ru.nsu.fit.oop.task_2_1_3.skin;
    opens ru.nsu.fit.oop.task_2_1_3.skin to javafx.fxml;
    exports ru.nsu.fit.oop.task_2_1_3.sprite;
    opens ru.nsu.fit.oop.task_2_1_3.sprite to javafx.fxml;
    exports ru.nsu.fit.oop.task_2_1_3.snake;
    opens ru.nsu.fit.oop.task_2_1_3.snake to javafx.fxml;
    exports ru.nsu.fit.oop.task_2_1_3.direction;
    opens ru.nsu.fit.oop.task_2_1_3.direction to javafx.fxml;
}
module ru.nsu.fit.oop.task_2_1_3 {
    requires javafx.controls;
    requires javafx.fxml;

    exports ru.nsu.fit.oop.task_2_1_3;
    opens ru.nsu.fit.oop.task_2_1_3 to javafx.fxml;
    exports ru.nsu.fit.oop.task_2_1_3.snakegame.sprite;
    opens ru.nsu.fit.oop.task_2_1_3.snakegame.sprite to javafx.fxml;
    exports ru.nsu.fit.oop.task_2_1_3.snakegame.sprite.board;
    opens ru.nsu.fit.oop.task_2_1_3.snakegame.sprite.board to javafx.fxml;
    exports ru.nsu.fit.oop.task_2_1_3.snakegame.sprite.snake;
    opens ru.nsu.fit.oop.task_2_1_3.snakegame.sprite.snake to javafx.fxml;
    exports ru.nsu.fit.oop.task_2_1_3.snakegame.sprite.fruit;
    opens ru.nsu.fit.oop.task_2_1_3.snakegame.sprite.fruit to javafx.fxml;
    exports ru.nsu.fit.oop.task_2_1_3.snakegame.game;
    opens ru.nsu.fit.oop.task_2_1_3.snakegame.game to javafx.fxml;
    exports ru.nsu.fit.oop.task_2_1_3.snakegame.cell;
    opens ru.nsu.fit.oop.task_2_1_3.snakegame.cell to javafx.fxml;
    exports ru.nsu.fit.oop.task_2_1_3.snakegamefx.skin;
    opens ru.nsu.fit.oop.task_2_1_3.snakegamefx.skin to javafx.fxml;
    exports ru.nsu.fit.oop.task_2_1_3.snakegamefx.sprite;
    opens ru.nsu.fit.oop.task_2_1_3.snakegamefx.sprite to javafx.fxml;
    exports ru.nsu.fit.oop.task_2_1_3.snakegamefx.game;
    opens ru.nsu.fit.oop.task_2_1_3.snakegamefx.game to javafx.fxml;
    exports ru.nsu.fit.oop.task_2_1_3.application.modalwindow;
    opens ru.nsu.fit.oop.task_2_1_3.application.modalwindow to javafx.fxml;
    exports ru.nsu.fit.oop.task_2_1_3.application.menu;
    opens ru.nsu.fit.oop.task_2_1_3.application.menu to javafx.fxml;
    exports ru.nsu.fit.oop.task_2_1_3.application.settings;
    opens ru.nsu.fit.oop.task_2_1_3.application.settings to javafx.fxml;
    exports ru.nsu.fit.oop.task_2_1_3.application.configuration;
    opens ru.nsu.fit.oop.task_2_1_3.application.configuration to javafx.fxml;
    exports ru.nsu.fit.oop.task_2_1_3.application.snakegame;
    opens ru.nsu.fit.oop.task_2_1_3.application.snakegame to javafx.fxml;
}
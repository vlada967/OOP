package ru.nsu.fit.oop.task_2_1_3.sprite;

import ru.nsu.fit.oop.task_2_1_3.direction.Direction;
import ru.nsu.fit.oop.task_2_1_3.skin.Skin;

public class Head extends Sprite {
    private final Skin head;

    public Head(Skin head) {
        this.head = head;
    }

    public void updateHeadImage(Direction direction) {
        switch (direction) {
            case LEFT -> setImage(head.getRotatedSkin(180));
            case UP -> setImage(head.getRotatedSkin(270));
            case DOWN -> setImage(head.getRotatedSkin(90));
            case RIGHT -> setImage(head.getSkin());
        }
    }
}

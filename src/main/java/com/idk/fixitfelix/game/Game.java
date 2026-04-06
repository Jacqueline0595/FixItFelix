package com.idk.fixitfelix.game;

import com.idk.fixitfelix.entities.Entity;
import javafx.scene.layout.Pane;

public class Game {
    private final Entity felix;

    public Game(Pane root)
    {
        felix = new Entity("/sprites/Felix.png", 100, 100);

        root.getChildren().add(felix.getSprite());
    }

    public void update()
    {
        felix.update();
    }
}

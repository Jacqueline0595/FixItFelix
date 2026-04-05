package com.idk.fixitfelix.game;

import com.idk.fixitfelix.entities.Entity;
import javafx.scene.layout.Pane;

public class Game {
    private Entity felix;
    private Pane root;

    public Game(Pane root)
    {
        this.root = root;
        felix = new Entity("/sprites/Felix.png", 100, 100);

        root.getChildren().add(felix.getSprite()); // ola
    }

    public void update()
    {
        felix.update();
    }
}

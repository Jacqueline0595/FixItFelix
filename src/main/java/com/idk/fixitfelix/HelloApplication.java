package com.idk.fixitfelix;

import com.idk.fixitfelix.game.Game;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    private Game game;
    @Override
    public void start(Stage stage) {

        Pane root = new Pane(); // contenedor vacio

        game = new Game(root);

        Scene scene = new Scene(root, 680, 520);
        stage.setTitle("Fix It Felix!");
        stage.setScene(scene);
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                game.update();
            }
        };

        timer.start();
    }
}

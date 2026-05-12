package com.idk.fixitfelix;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Objects;

public class HelloApplication extends Application {

    private boolean mostrar = true;

    @Override
    public void start(Stage stage) {
        // Contenedor vacio
        Pane root = new Pane();

        // Carga de las dos imagenes para animarlas
        Image inicio1 = new Image( Objects.requireNonNull( getClass().getResourceAsStream("/LoopInicio/1.png" ) ) );
        Image inicio2 = new Image( Objects.requireNonNull( getClass().getResourceAsStream("/LoopInicio/2.png" ) ) );

        // Para que se vean las imagenes
        ImageView img1 = new ImageView(inicio1);
        ImageView img2 = new ImageView(inicio2);

        img1.setLayoutX(0);
        img1.setLayoutY(0);

        img2.setLayoutX(0);
        img2.setLayoutY(0);

        root.getChildren().addAll(img1, img2);

        Scene scene = getScene(root, img1, img2);

        stage.setTitle("Fix It Felix!");
        stage.setScene(scene);
        stage.show();
    }

    private Scene getScene(Pane root, ImageView img1, ImageView img2) {
        Scene scene = new Scene(root, 680, 520);

        // Se encarga de alternar las imagenes
        Timeline animacion = new Timeline(
                new KeyFrame(Duration.millis(500), e -> {
                    mostrar = !mostrar;
                    img1.setVisible(mostrar);
                    img2.setVisible(!mostrar);
                } )
        );

        animacion.setCycleCount(Timeline.INDEFINITE);
        animacion.play();

        // Detecta si se presiono espacio o enter
        scene.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.SPACE || e.getCode() == KeyCode.ENTER) {
                // Detiene la animacion
                animacion.stop();
                // Quita las imagenes
                root.getChildren().removeAll(img1, img2);

                // Aviso
                System.out.println("Espacio o enter");
            }
        });
        return scene;
    }
}

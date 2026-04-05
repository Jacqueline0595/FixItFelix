package com.idk.fixitfelix.entities;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class Entity {
    protected double x;
    protected double y;

    protected double velocityX;
    protected double velocityY;

    protected ImageView sprite;

    public Entity(String imagePath, double x, double y) {
        this.x = x;
        this.y = y;

        Image image = new Image(Objects.requireNonNull(getClass().getResource(imagePath)).toExternalForm());

        sprite = new ImageView(image);
        sprite.setSmooth(false);
        sprite.setX(x);
        sprite.setY(y);
    }

    protected void move()
    {
        x += velocityX;
        y += velocityY;
    }

    public void update()
    {
        move();
        sprite.setX(x);
        sprite.setY(y);
    }

    public ImageView getSprite()
    {
        return sprite;
    }
}

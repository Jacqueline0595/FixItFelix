package com.idk.fixitfelix.entities;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Rectangle2D;

import java.util.Objects;

public class Entity {
    protected int frame = 0;
    protected int currentRow = 0;

    protected double offsetY = 30;
    protected double frameWidth = 40;
    protected double frameHeight = 70;
    protected int maxFrames = 4;

    protected double frameTimer = 0;
    protected double frameDelay = 25; // velocidad (más bajo = más rápido)

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

        updateAnimation();

        sprite.setX(x);
        sprite.setY(y);
    }

    protected void updateAnimation()
    {
        frameTimer++;

        if (frameTimer >= frameDelay)
        {
            frame++;
            frameTimer = 0;

            if (frame >= maxFrames)
            {
                frame = 0;
            }
        }

        sprite.setViewport(new Rectangle2D(
                30 + frame * 100,
                currentRow * 100 + offsetY,
                frameWidth,
                frameHeight
        ));
    }

    public void setAnimation(int row, double offsetY, double width, double height, int frames)
    {
        this.currentRow = row;
        this.offsetY = offsetY;
        this.frameWidth = width;
        this.frameHeight = height;
        this.maxFrames = frames;

        this.frame = 0; // reinicia animación
    }

    public ImageView getSprite()
    {
        return sprite;
    }
}

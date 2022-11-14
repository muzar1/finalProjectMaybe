package com.example.finalprojectmaybe;

import android.graphics.Canvas;

public abstract class Circle extends GameObject{
    protected double positionX;
    protected double positionY;
    protected double velocityX;
    protected double velocityY;

    public Circle(double positionX, double positionY) {
        super(positionX,positionY);
    }
    public abstract void draw(Canvas canvas);
    public abstract void update();
}

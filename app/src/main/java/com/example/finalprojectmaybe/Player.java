package com.example.finalprojectmaybe;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.core.content.ContextCompat;

public class Player extends Circle{
    private Paint paint;
    private double positionX;
    private double positionY;
    private double radius;
    private double velocityX;
    private double velocityY;
    private double SPEED_PIXELS_PER_SECOND;
    private double MAX_SPEED = SPEED_PIXELS_PER_SECOND /GameLoop.MAX_UPS;

    public Player(Context context, double positionX, double positionY, double radius){
        super(positionX,positionY);
        this.radius= radius;

        paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.player);
        paint.setColor(color);
    }
    public void draw(Canvas canvas) {
        canvas.drawCircle((float) positionX, (float) positionY, (float) radius, paint);
    }

    public void update() {
        velocityX = MAX_SPEED;
        velocityY = MAX_SPEED;
        positionX +=velocityX;
        positionY +=velocityY;
    }

    public void setPosition(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY=positionY;
    }
}

package com.example.finalprojectmaybe;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Balloon {
    protected int centerPositionX;
    protected int centerPositionY;
    protected int radius;
    protected Paint balloonPaint;
    private Canvas canvas;
    private Bitmap texture;
    public Balloon(int centerPositionX, int centerPositionY, int radius, Context context){
        this.centerPositionX=centerPositionX;
        this.centerPositionY=centerPositionY;
        this.radius=radius;
        balloonPaint = new Paint();
        texture = BitmapFactory.decodeResource(context.getResources(), R.drawable.red_balloon);
    }
    public void draw(Canvas canvas){
        canvas.drawCircle(centerPositionX,centerPositionY,radius,balloonPaint);
        canvas.drawBitmap(texture,centerPositionX-70,centerPositionY,balloonPaint);
    }
    public void update(){
        centerPositionY+=10;
    }
}


package com.example.finalprojectmaybe;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.Toast;

public class Balloon {
    protected int centerPositionX;
    protected int centerPositionY;
    protected int radius;
    protected Paint balloonPaint;
    private Canvas canvas;
    private Bitmap texture;
    Bitmap resizedBitmap;
    public Balloon(int centerPositionX, int centerPositionY, int radius, Context context){
        this.centerPositionX=centerPositionX;
        this.centerPositionY=centerPositionY;
        this.radius=radius;
        balloonPaint = new Paint();
        texture = BitmapFactory.decodeResource(context.getResources(), R.drawable.red_balloon);
        resizedBitmap = Bitmap.createScaledBitmap(texture, getScreenWidth()/40, getScreenHeight()/20, false);

    }
    public void draw(Canvas canvas){
        canvas.drawCircle(centerPositionX,centerPositionY,radius,balloonPaint);
        canvas.drawBitmap(resizedBitmap,centerPositionX-getScreenWidth()/80,centerPositionY-getScreenHeight()/50,balloonPaint);
    }
    public void update(){
        firstLine();
    }

    public int getCenterPositionX() {
        return centerPositionX;
    }

    public int getCenterPositionY() {
        return centerPositionY;
    }

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }
    public void firstLine(){
        if(centerPositionX<getScreenWidth()/2.11059 && centerPositionY<getScreenHeight()/2.44 && centerPositionY>getScreenHeight()/46)
        {
            centerPositionX+=getScreenWidth()/400;
        }
       else if(centerPositionX>getScreenWidth()/2.11070 && centerPositionY<getScreenHeight()/2.44 && centerPositionY>getScreenHeight()/2.65)
        {
            centerPositionX+=getScreenWidth()/400;
            centerPositionY-=getScreenHeight()/247;
        }

    }
}


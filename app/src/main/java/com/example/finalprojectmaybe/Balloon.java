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

    Boolean mapPart3finished=false;
    Boolean mapPart2finished=false;
    Boolean mapPart1finished=false;

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
        if(!mapPart1finished) //if the balloon didn't finish the 1st part of the map (before the merge)
            firstLinePart();
        else if(!mapPart2finished) //"" second ""
            secondLinePart();
        else if(!mapPart3finished) // "" third ""
            thirdLinePart();
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
    public void firstLinePart(){
        if(!mapPart1finished) {
            if (centerPositionX < getScreenWidth() / 2.025 && centerPositionY < getScreenHeight() / 2.44 && centerPositionY > getScreenHeight() / 2.7) {
                centerPositionX += getScreenWidth() / 400;
            }
            if (centerPositionX > getScreenWidth() / 2.1 && centerPositionY < getScreenHeight() / 2.44 && centerPositionY > getScreenHeight() / 5.3) {
                centerPositionY -= getScreenHeight() / 247;
            }
            if (centerPositionY < getScreenHeight() / 4.6 && centerPositionX < getScreenWidth() / 1.9 && centerPositionX > getScreenWidth() / 3.05) {
                centerPositionX -= getScreenWidth() / 400;
            }
            if (centerPositionX < getScreenWidth() / 3 && centerPositionY < getScreenHeight() / 3) {
                centerPositionY += getScreenHeight() / 247;
            }
            if (centerPositionX < getScreenWidth() / 3 && centerPositionY < getScreenHeight() / 2.9 && centerPositionY > getScreenHeight() / 3.1) {
                mapPart1finished = true;
            }
        }
    }
    public void secondLinePart(){
        if(!mapPart2finished) {
            if (centerPositionX < getScreenWidth() / 3 && centerPositionX > getScreenWidth() / 3.4 && centerPositionY > getScreenHeight() / 3.1 && centerPositionY < getScreenHeight() / 1.26) {
                centerPositionY += getScreenHeight() / 247;
            }
            if (centerPositionX < getScreenWidth() / 3 && centerPositionY < getScreenHeight() / 1.2 && centerPositionY > getScreenHeight() / 1.32 && centerPositionX > getScreenWidth() / 6.05) {
                centerPositionX -= getScreenWidth() / 400;
            }
            if (centerPositionX < getScreenWidth() / 5.6 && centerPositionX > getScreenWidth() / 6.2 && centerPositionY > getScreenHeight() / 1.8) {
                centerPositionY -= getScreenHeight() / 247;
            }
            if (centerPositionX < getScreenWidth() / 3.6 && centerPositionX > getScreenWidth() / 6.2 && centerPositionY > getScreenHeight() / 1.9 && centerPositionY < getScreenHeight() / 1.67) {
                centerPositionX += getScreenWidth() / 400;
            }
            if (centerPositionX > getScreenWidth() / 3.7 && centerPositionX < getScreenWidth() / 3.5 && centerPositionY > getScreenHeight() / 1.9 && centerPositionY < getScreenHeight() / 1.67) {
                mapPart2finished=true;
            }
        }
    }
    public void thirdLinePart(){
        if (centerPositionX < getScreenWidth() / 1.57 && centerPositionX > getScreenWidth() / 6.2 && centerPositionY > getScreenHeight() / 2.03 && centerPositionY < getScreenHeight() / 1.67) {
            centerPositionX += getScreenWidth() / 400;
        }
        if (centerPositionX > getScreenWidth() / 1.68 && centerPositionX < getScreenWidth() / 1.5 && centerPositionY > getScreenHeight() / 3 && centerPositionY < getScreenHeight() / 1.67) {
            centerPositionY -= getScreenHeight() / 247;
        }
        if (centerPositionX > getScreenWidth() / 1.7 && centerPositionX < getScreenWidth() / 1.325 && centerPositionY > getScreenHeight() / 3.1 && centerPositionY < getScreenHeight() / 2.8) {
            centerPositionX += getScreenWidth()/ 400;
        }
        if (centerPositionX > getScreenWidth() / 1.35 && centerPositionX < getScreenWidth() / 1.27 && centerPositionY > getScreenHeight() / 3.1 && centerPositionY < getScreenHeight() / 1.38) {
            centerPositionY += getScreenHeight() / 247;
        }
        if (centerPositionX > getScreenWidth() / 2.24 && centerPositionX < getScreenWidth() / 1.27 && centerPositionY > getScreenHeight() / 1.43 && centerPositionY < getScreenHeight() / 1.3) {
            centerPositionX -= getScreenWidth()/ 400;
        }
        if (centerPositionX > getScreenWidth() / 2.28 && centerPositionX < getScreenWidth() / 2.15 && centerPositionY > getScreenHeight() / 1.43 && centerPositionY < getScreenHeight() / 1) {
            centerPositionY += getScreenHeight() / 247;
        }
    }
}


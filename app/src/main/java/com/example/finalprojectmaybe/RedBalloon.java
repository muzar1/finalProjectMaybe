package com.example.finalprojectmaybe;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;

public class RedBalloon extends Balloon{
    public RedBalloon(int centerPositionX, int centerPositionY, int radius, Context context, Bitmap texture) {
        super(centerPositionX, centerPositionY, radius, context, texture,Balloon.getScreenWidth()/40,Balloon.getScreenHeight()/20);

    }
}

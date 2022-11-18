package com.example.finalprojectmaybe;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;

public class BlueBalloon extends Balloon{
    public BlueBalloon(int centerPositionX, int centerPositionY, int radius, Context context, Bitmap texture) {
        super(centerPositionX, centerPositionY, radius, context, texture,Balloon.getScreenWidth()/15,Balloon.getScreenHeight()/9);
    }
}

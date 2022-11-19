package Balloons;

import android.content.Context;
import android.graphics.Bitmap;

import Balloons.Balloon;

public class BlueBalloon extends Balloon {
    public BlueBalloon(int centerPositionX, int centerPositionY, int radius, Context context, Bitmap texture) {
        super(centerPositionX, centerPositionY, radius, context, texture,Balloon.getScreenWidth()/15,Balloon.getScreenHeight()/10);
    }
}

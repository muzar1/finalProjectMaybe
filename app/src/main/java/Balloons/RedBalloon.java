package Balloons;

import android.content.Context;
import android.graphics.Bitmap;

import Balloons.Balloon;

public class RedBalloon extends Balloon {
    public RedBalloon(int centerPositionX, int centerPositionY, int radius, Context context, Bitmap texture) {
        super(centerPositionX, centerPositionY, radius, context, texture,Balloon.getScreenWidth()/40,Balloon.getScreenHeight()/20);

    }
}

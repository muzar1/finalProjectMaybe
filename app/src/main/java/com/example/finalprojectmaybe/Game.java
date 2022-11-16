package com.example.finalprojectmaybe;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

//**
/* Game manages all objects in the game and is responsible for updating all states and rendering all
/* object to the screen
 */
public class Game extends SurfaceView implements SurfaceHolder.Callback{
    private final Player player;
    private final Balloon balloon;
    //  private final RedBalloon RedBalloon;
    private GameLoop gameLoop;
    private Bitmap map;


    public Game(Context context) {
        super(context);


        SurfaceHolder surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);

        gameLoop = new GameLoop(this, surfaceHolder);

        balloon = new Balloon(-getScreenWidth()/50,((int)(getScreenHeight()/2.45)),getScreenWidth()/60,context);
        player = new Player(getContext(), 500,500,30);

        map = BitmapFactory.decodeResource(context.getResources(), R.drawable.map);
        map= Bitmap.createScaledBitmap(map, getScreenWidth(), getScreenHeight(), false);

        Toast.makeText(context, "yep" + balloon.getCenterPositionY(), Toast.LENGTH_LONG).show();

        //   RedBalloon = new RedBalloon();
        setFocusable(true);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        gameLoop.startLoop();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        // Handle touch event actions
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                player.setPosition((double) event.getX(), (double) event.getY());
                return true;
            case MotionEvent.ACTION_MOVE:
                player.setPosition((double) event.getX(), (double) event.getY());
                return true;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        canvas.drawBitmap(map, 0, 0, null);
        drawUPS(canvas);
        drawFPS(canvas);
        balloon.draw(canvas);
        player.draw(canvas);



    }

    public void drawUPS(Canvas canvas){
        String averageUPS = Double.toString(gameLoop.getAverageUPS());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(getContext(), R.color.magenta);
        paint.setColor(color);
        paint.setTextSize(50);
        canvas.drawText("UPS: " + averageUPS,100,100,paint);
    }

    public void drawFPS(Canvas canvas){
        String averageFPS = Double.toString(gameLoop.getAverageFPS());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(getContext(), R.color.magenta);
        paint.setColor(color);
        paint.setTextSize(50);
        canvas.drawText("FPS: " + averageFPS,100,200,paint);
    }

    public void update() {
        //Update game state
        player.update();
        balloon.update();
    }
    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;

    }
}

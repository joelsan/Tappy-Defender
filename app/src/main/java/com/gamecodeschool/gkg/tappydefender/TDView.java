package com.gamecodeschool.gkg.tappydefender;

import android.content.Context;
import android.view.SurfaceView;

/**
 * Created on 9/21/2015.
 */

public class TDView extends SurfaceView implements Runnable
{
    volatile boolean playing;
    Thread gameThread = null;

    public TDView(Context context) {
        super(context);
    }

    @Override
    public void run(){
        while (playing){
            update();
            draw();
            control();
        }
    }

    private void update(){

    }

    private void draw(){

    }

    private void control(){

    }

    // Clean up our thread if the game is interrupted or the player quits
    public void pause(){
        playing = false;
        try {
            gameThread.join();
        }
        catch (InterruptedException e) {
            // do something
        }
    }

    // Make a new thread and start it
    // Execution moves to the R
    public void resume() {
        playing = true;
        gameThread = new Thread(this);
        gameThread.start();
    }
}

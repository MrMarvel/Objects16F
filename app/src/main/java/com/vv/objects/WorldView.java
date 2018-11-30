package com.vv.objects;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
public class WorldView extends View{
    Penguin kesha;
    Penguin lusi;
    Penguin[] penguins;
    int n = 10;
    public WorldView(Context context) {
        super(context);
        this.setBackgroundColor(Color.BLACK);
        kesha = new Penguin(25, 100);
        lusi = new Penguin(100, 100, 2, 2);
        penguins = new Penguin[10];
        for (int i = 0; i <  penguins.length; i++){
            penguins[i] = new Penguin(400, 600);
        }
    }

    public WorldView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setBackgroundColor(Color.BLACK);
        kesha = new Penguin(25, 100);
        lusi = new Penguin(100, 100, 2, 2);
        penguins = new Penguin[100];
        n = 10;
        for (int i = 0; i < n; i++){
            penguins[i] = new Penguin(400, 600);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        kesha.step();
        lusi.step();
        kesha.draw(canvas);
        lusi.draw(canvas);
        for (int i = 0; i <  n; i++){
            penguins[i].draw(canvas);
            penguins[i].step();
        }
        invalidate();
    }
}

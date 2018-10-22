package com.vv.objects;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;
public class WorldView extends View {
    Penguin kesha;
    Penguin lusi;
    Penguin[] penguins;
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
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        kesha.step();
        lusi.step();
        kesha.draw(canvas);
        lusi.draw(canvas);
        for (int i = 0; i <  penguins.length; i++){
            penguins[i].draw(canvas);
            penguins[i].step();
        }
        invalidate();
    }
}

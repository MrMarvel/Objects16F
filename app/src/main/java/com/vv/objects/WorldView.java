package com.vv.objects;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;
public class WorldView extends View {
    Penguin kesha = new Penguin(25, 100);
    Penguin lusi = new Penguin(100, 100);
    public WorldView(Context context) {
        super(context);
        this.setBackgroundColor(Color.BLACK);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        kesha.draw(canvas);
        lusi.draw(canvas);
    }
}

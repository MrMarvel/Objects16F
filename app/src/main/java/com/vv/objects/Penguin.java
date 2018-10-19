package com.vv.objects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Penguin {
    float x , y;
    Paint paint = new Paint();

    Penguin(float x, float y){
        this.x = x;
        this.y = y;
    }
    void draw(Canvas canvas){
         paint.setColor(Color.BLUE);
        canvas.drawCircle(x + 25, y + 90, 10, paint);
        canvas.drawCircle(x + 25,y + 45, 40, paint);
    }
}

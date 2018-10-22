package com.vv.objects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Penguin {
    float x , y;
    float vx, vy;
    Paint paint = new Paint();

    void step(){
        this.x += vx;
        this.y += vy;
    }

    Penguin(float x, float y){
        this.x = x;
        this.y = y;
        this.vx = (float)(Math.random()*4-2);
        this.vy = (float)(Math.random()*4-2);
    }

    Penguin(float x, float y, float vx, float vy){
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
    }

    void draw(Canvas canvas){
        paint.setColor(Color.BLUE);
        canvas.drawCircle(x + 25, y + 90, 10, paint);
        canvas.drawCircle(x + 25,y + 45, 40, paint);
    }
}

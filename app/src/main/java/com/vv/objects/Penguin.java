package com.vv.objects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.List;

import static com.vv.objects.MainActivity.sizeOfScreen;

public class Penguin extends Animal{
    double x = 1280/2;
    double y = 752/2-100;
    double vx = 0;
    double vy = 0;
    double fx, fy;
    double m = 1;
    double R = 40;

    Paint paint = new Paint();

    void step(){
        x = fx;
        y = fy;
    }

    Penguin(List<Penguin> penguins, float R, float m){
        this.R = R;
        this.m = m;
        int b = 1;
        while (b == 1) {
            b = 0;
            x += (Math.random()*400-200);
            y += (Math.random()*400-200);
            for (int i = 0; i < penguins.size(); i++) {
                double ax = penguins.get(i).x - x;
                double ay = penguins.get(i).y - y;
                double magn = Math.sqrt(ax*ax+ay*ay);
                double R2 = penguins.get(i).R;
                if (magn < R+R2) {
                    b = 1;
                    break;
                }
            }
        }
        vx = (Math.random()*4-2);
        vy = (Math.random()*4-2);
    }






    Penguin(float x, float y, float vx, float vy, float m, float R){
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.m = m;
        this.R = R;
        this.color_group = color_group;
    }

    public void draw(Canvas canvas){
        paint.setColor(Color.GREEN);
        canvas.drawCircle((float)x + 25, (float)(y + 90+((R-40)+(0.25*R-10))), (float)(0.25*R), paint);
        canvas.drawCircle((float)x + 25,(float)y + 45, (float)R, paint);
        paint.setColor(Color.RED);
        canvas.drawCircle((float)x + 25,(float)y + 45, 2, paint);//1280 752
    }
}

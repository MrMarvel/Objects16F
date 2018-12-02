package com.vv.objects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.List;

public class Penguin {
    double x , y;
    double vx, vy;
    double fx, fy;
    double m;
    double R;
    double color_group;

    Paint paint = new Paint();

    void step(){
        x = fx;
        y = fy;
    }

    Penguin(List<Penguin> penguins){
        this.R = 40;
        this.m = 1;
        this.color_group = 0;
        int b = 1;
        while (b == 1) {
            b = 0;
            x = (Math.random()*1000-100);
            y = (Math.random()*1400-100);
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

    Penguin(List<Penguin> penguins, float R, float m, int color_group){
        this.R = R;
        this.m = m;
        this.color_group = color_group;
        int b = 1;
        while (b == 1) {
            b = 0;
            x = (Math.random()*1000-100);
            y = (Math.random()*1400-100);
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

    Penguin(List<Penguin> penguins, float R, float m){
        this.R = R;
        this.m = m;
        this.color_group = 0;
        int b = 1;
        while (b == 1) {
            b = 0;
            x = (Math.random()*1000-100);
            y = (Math.random()*1400-100);
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
        vx = 0;//(Math.random()*4-2);
        vy = 0;//(Math.random()*4-2);
    }


    Penguin(List<Penguin> penguins, float R){
        this.R = R;
        this.m = 1;
        this.color_group = 0;
        int b = 1;
        while (b == 1) {
            b = 0;
            x = (Math.random()*1000-100);
            y = (Math.random()*1400-100);
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

    Penguin(float x, float y, float vx, float vy, float m, float R, int color_group){
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.m = m;
        this.R = R;
        this.color_group = color_group;
    }

    Penguin(float x, float y, float vx, float vy, float m, float R){
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.m = m;
        this.R = R;
        this.color_group = 0;
    }

    Penguin(float x, float y, float vx, float vy, float m){
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.m = m;
        this.R = 40;
        this.color_group = 0;
    }

    Penguin(float x, float y, float vx, float vy){
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.m = 1;
        this.R = 40;
        this.color_group = 0;
    }

    void draw(Canvas canvas){
        if (color_group == 0) paint.setColor(Color.BLUE);
        if (color_group == 1) paint.setColor(Color.GREEN);
        if (color_group == 2) paint.setColor(Color.YELLOW);
        if (color_group == 3) paint.setColor(Color.WHITE);
        if (color_group == 4) paint.setColor(Color.GRAY);
        canvas.drawCircle((float)x + 25, (float)(y + 90+((R-40)+(0.25*R-10))), (float)(0.25*R), paint);
        canvas.drawCircle((float)x + 25,(float)y + 45, (float)R, paint);
        paint.setColor(Color.RED);
        canvas.drawCircle((float)x + 25,(float)y + 45, 2, paint);
    }
}

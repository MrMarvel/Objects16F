package com.vv.objects;

import android.graphics.Canvas;

import java.util.List;

public abstract class Animal {

    public double x = 1080 / 2;
    public double y = 1794 / 2;
    public double vx = 0;
    public double vy = 0;
    public double fx, fy;
    public double m;
    public double R;
    private List<Animal> animals = WorldView.animals;


    //1080 1794
    Animal(double m, double R) {
        this.m = m;
        this.R = R;

        int b = 1;
        while (b == 1) {
            b = 0;
            x += (Math.random()*400-200);
            y += (Math.random()*400-200);
            for (int i = 0; i < animals.size(); i++) {
                double ax = animals.get(i).x - x;
                double ay = animals.get(i).y - y;
                double magn = Math.sqrt(ax*ax+ay*ay);
                double R2 = animals.get(i).R;
                if (magn < R+R2) {
                    b = 1;
                    break;
                }
            }
        }
        vx = (Math.random()*4-2);
        vy = (Math.random()*4-2);
    }

    Animal(double x, double y, double vx, double vy, double m, double R) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.m = m;
        this.R = R;

        int b = 1;
        while (b == 1) {
            b = 0;
            x += (Math.random()*400-200);
            y += (Math.random()*400-200);
            for (int i = 0; i < animals.size(); i++) {
                double ax = animals.get(i).x - x;
                double ay = animals.get(i).y - y;
                double magn = Math.sqrt(ax*ax+ay*ay);
                double R2 = animals.get(i).R;
                if (magn < R+R2) {
                    b = 1;
                    break;
                }
            }
        }
        vx = (Math.random()*4-2);
        vy = (Math.random()*4-2);
    }

    public void step() {
        x = fx;
        y = fy;
    }

    public abstract void draw(Canvas canvas);
}

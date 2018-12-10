package com.vv.objects;

import android.graphics.Canvas;
import android.widget.Toast;

import java.util.List;

public abstract class Animal {

    public double x , y;
    public double vx, vy;
    public double fx, fy;
    public double m;
    public double R;
    private List<Animal> animals = WorldView.animals;

    public double getX () {
        return x;
    }

    public double getY () {
        return y;
    }

    public double getVx () {
        return vx;
    }

    public double getVy () {
        return vy;
    }

    public double getFx () {
        return fx;
    }

    public double getFy () {
        return fy;
    }

    public double getM () {
        return m;
    }

    public double getR () {
        return R;
    }


    Animal(double m, double R) {
        this.x = 1280 / 2;
        this.y = 752 / 4;
        this.vx = vx;
        this.vy = vy;
        this.m = m;
        this.R = R;

        //1080 1794 //1280 752
        int b = 1;
        int tries = 0;
        while (b == 1 && tries < 1000) {
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
            tries++;
        }
        vx = (Math.random()*1-0.5);
        vy = (Math.random()*1-0.5);
    }

    public void step() {
        x = fx;
        y = fy;
    }

    public abstract void draw(Canvas canvas);
}

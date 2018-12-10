package com.vv.objects;

import android.graphics.Canvas;
import android.graphics.Color;

public abstract class Animal{
    private double x = 1280/2;
    private double y = 752/2-100;
    private double vx = 0;
    private double vy = 0;
    private double fx, fy;


    Animal(int x, int y, int fx, int fy) {
        this.x = x;
        this.y = y;
        this.fx = fx;
        this.fy = fy;
    }
    public abstract void draw(Canvas canvas);

    public void step() {

    }

}

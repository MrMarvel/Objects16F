package com.vv.objects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.List;

public class Penguin extends Animal{
    public List<Animal> animals = WorldView.animals;

    Penguin() {
        super(200, 60);
    }

    Penguin(double x, double y, double vx, double vy) {
        super(x, y, vx, vy, 200, 60);
    }


    public void draw(Canvas canvas){
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        canvas.drawCircle((float)x + 25, (float)(y + 90+((R-40)+(0.25*R-10))), (float)(0.25*R), paint);
        canvas.drawCircle((float)x + 25,(float)y + 45, (float)R, paint);
        paint.setColor(Color.RED);
        canvas.drawCircle((float)x + 25,(float)y + 45, 2, paint);
    }
}

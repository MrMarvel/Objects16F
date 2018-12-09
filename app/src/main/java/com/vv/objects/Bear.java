package com.vv.objects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.List;

public class Bear extends Animal{
    private List<Animal> animals = WorldView.animals;

    public Bear() {
        super(200, 60);

    }

    public Bear(double x, double y, double vx, double vy) {
        super(x, y, vx, vy, 200, 60);
    }


    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.rgb(150, 75, 0));
        canvas.drawCircle((float)x + 25, (float)(y + 90+((R-40)+(0.25*R-10))), (float)(0.25*R), paint);
        canvas.drawCircle((float)x + 25,(float)y + 45, (float)R, paint);
        paint.setColor(Color.RED);
        canvas.drawCircle((float)x + 25,(float)y + 45, 2, paint);
    }
}

package com.vv.objects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Bear {
    private Paint paint = new Paint();
    Bear(Animal[] animals){

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


    public void draw(Canvas canvas){
    paint.setColor(Color.GREEN);
    canvas.drawCircle((float)x + 25, (float)(y + 90+((R-40)+(0.25*R-10))), (float)(0.25*R), paint);
    canvas.drawCircle((float)x + 25,(float)y + 45, (float)R, paint);
    paint.setColor(Color.RED);
    canvas.drawCircle((float)x + 25,(float)y + 45, 2, paint);//1280 752
}
}

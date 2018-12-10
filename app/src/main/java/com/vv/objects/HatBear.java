package com.vv.objects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class HatBear extends Bear {
    public HatBear() {
        super();
    }
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.rgb(150, 75, 0));
        canvas.drawCircle((float)x + 25, (float)(y + 90+((R-40)+(0.25*R-10))), (float)(0.25*R), paint);
        canvas.drawCircle((float)x + 25,(float)y + 45, (float)R, paint);
        paint.setColor(Color.BLUE);
        canvas.drawCircle((float)x + 25,(float)y + 45, (float)(0.3*R), paint);
        paint.setColor(Color.RED);
        canvas.drawCircle((float)x + 25,(float)y + 45, 2, paint);
    }
}
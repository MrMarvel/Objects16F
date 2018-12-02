package com.vv.objects;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class WorldView extends View{
    private List<Penguin> penguins = new ArrayList<Penguin>();
    private double G = 6.177777777;
    public WorldView(Context context) {
        super(context);
        this.setBackgroundColor(Color.BLACK);
        for (int i = 0; i <  10; i++){
            penguins.add(new Penguin(penguins));
        }
    }

    public WorldView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setBackgroundColor(Color.BLACK);
        for (int i = 0; i < 10; i++){
            penguins.add(new Penguin(penguins, 60, 5));
        }
        //penguins.add(new Penguin(800,700,0,0, 1, 120));
        //penguins.add(new Penguin(400,300,2.5f,2.0f, 1, 120));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i <  penguins.size(); i++){
            calca(i);
            calcs(i);
            penguins.get(i).step();
            penguins.get(i).draw(canvas);
        }
        invalidate();
    }





    protected void calca(int xi) {
        Penguin penguin = penguins.get(xi);
        for (int i = 0; i < penguins.size(); i++) {
            if (i != xi) {
                Penguin penguin2 = penguins.get(i);
                double ax = penguin2.x - penguin.x;
                double ay = penguin2.y - penguin.y;
                double magn = Math.sqrt(ax*ax+ay*ay);
                ax/=magn;
                ay/=magn;
                double g = G*penguin2.m/magn/magn;
                ax*=g;
                ay*=g;
                penguin.vx = penguin.vx + ax;
                penguin.vy = penguin.vy + ay;
            }
            penguin.fx = penguin.x + penguin.vx;
            penguin.fy = penguin.y + penguin.vy;
        }
    }

    void calcs(int xi) {
        Penguin penguin = penguins.get(xi);
        for (int i = 0; i < penguins.size(); i++) {
            if (i != xi) {
                Penguin penguin2 = penguins.get(i);
                double ax = penguin2.fx - penguin.fx;
                double ay = penguin2.fy - penguin.fy;
                double magn = Math.sqrt(ax*ax+ay*ay);

                if (magn <= penguin.R+penguin2.R) {
                    //светло-серый вектор
                    double dvx = penguin.vx-penguin2.vx;
                    double dvy = penguin.vy-penguin2.vy;
                    //красный вектор
                    double v1 = (dvx*ax+dvy*ay)/magn;
                    double v2 = 0;

                    // Расчёт изменившийся скорости
                    double u1 = (v1*(penguin.m-penguin2.m)+2*penguin2.m*v2)/(penguin.m+penguin2.m);
                    double u2 = (v2*(penguin2.m-penguin.m)+2*penguin.m*v1)/(penguin2.m+penguin.m);

                    //изменение скоростей
                    double dv1 = u1 - v1;
                    double dv2 = u2 - v2;


                    //Время движения до столкновения
                    double dx = penguin2.x - penguin.x;
                    double dy = penguin2.y - penguin.y;
                    double t = (penguin.R+penguin2.R - Math.sqrt(dx*dx+dy*dy)) / v1; //0 >= t <= 1

                    //Движение до столкновения
                    penguin.fx = penguin.x + penguin.vx*t;
                    penguin.fy = penguin.y + penguin.vy*t;

                    penguin2.fx = penguin2.x + penguin2.vx*t;
                    penguin2.fy = penguin2.y + penguin2.vy*t;

                    //Расчитывание скорости
                    ax/=magn;
                    ay/=magn;
                    penguin.vx += dv1 * ax;
                    penguin.vy += dv1 * ay;
                    penguin2.vx += dv2 * ax;
                    penguin2.vy += dv2 * ay;


                    //Движение после столкновения
                    penguin.fx += penguin.vx*(1-t);
                    penguin.fy += penguin.vy*(1-t);

                    penguin2.fx += penguin2.vx*(1-t);
                    penguin2.fy += penguin2.vy*(1-t);

                    //Проверка последующих столкновений
                    calcs(i);
                    calcs(xi);
                }

            }
        }
    }

    public void createPenguin () {
        penguins.add(new Penguin(penguins));
    }
}

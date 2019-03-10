package com.vv.objects;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.vv.objects.Calculator.Calculator;

import java.util.ArrayList;
import java.util.List;



public class WorldView extends View {
    public static final List<Animal> animals = new ArrayList<Animal>();
    private final Calculator calculator = new Calculator();

    public WorldView(Context context) {
        super(context);
        this.setBackgroundColor(Color.BLACK);
        for (int i = 0; i <  10; i++){
            animals.add(new Penguin());
        }
        //Не играет роли
    }

    public WorldView(Context context, AttributeSet attrs) {
        super(context, attrs);


        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;



        this.setBackgroundColor(Color.BLACK);
        /*for (int i = 0; i < 1; i++) {
            animals.add(new Bear());
        }*/
        animals.add(new Bear(500,0,0,5));
        animals.add(new Bear(280,360,8,-4));
        animals.add(new Bear(660,360,-8,-4));
        animals.add(new Bear(500,400,0,-5));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i <  animals.size(); i++){
            Calculator.calca(i);
            Calculator.checkBorder(i);
        }

        int c  = 0;
        Calculator.checks();
        //if (c == 2) i--;
        //if (c > 0) Toast.makeText(getContext(), ""+Calculator.checks(), Toast.LENGTH_LONG).show();

        for (int i = 0; i <  animals.size(); i++){
            animals.get(i).step();
            animals.get(i).draw(canvas);
        }
        invalidate();
    }








    public void createPenguin () {
        animals.add(new Penguin());
    }
}

package com.vv.objects;

import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    public static final Point sizeOfScreen = new Point();
    WorldView worldView;
    final String TAG = "WORK";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        worldView = findViewById(R.id.world_view);
        Button button = findViewById(R.id.plusPenguin);
        Intent intent = getIntent();
        String p = intent.getStringExtra("passw");


        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        final int screenWidth = displaymetrics.widthPixels;
        final int screenHeight = displaymetrics.heightPixels;
        sizeOfScreen.set(screenWidth, screenHeight);
        Toast toast = Toast.makeText(MainActivity.this, sizeOfScreen.x+" "+sizeOfScreen.y, Toast.LENGTH_LONG);
        toast.show();


        if (p != null) button.setText(p);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View v) {
                worldView.createPenguin();
            }
        });
        Log.d(TAG, "onCreate");
    }
 }

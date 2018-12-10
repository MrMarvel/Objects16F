package com.vv.objects;

import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    WorldView worldView;
    final String TAG = "MainActivity";
    public final static Point sizeOfScreen = new Point();





    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        worldView = findViewById(R.id.world_view);
        Button button = findViewById(R.id.plusPenguin);
        Intent intent = getIntent();
        String p = intent.getStringExtra("passw");
        if (p != null) button.setText(p);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View v) {
                worldView.createPenguin();
            }
        });
        Log.d(TAG, "onCreate");

        Display display = getWindowManager().getDefaultDisplay();
        display.getSize(sizeOfScreen);
        Toast.makeText(MainActivity.this, sizeOfScreen.x+" "+sizeOfScreen.y, Toast.LENGTH_LONG).show();

    }
 }

package com.vv.objects;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    WorldView worldView;
    final String TAG = "WORK";
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
    }
 }

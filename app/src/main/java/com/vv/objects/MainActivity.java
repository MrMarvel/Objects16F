package com.vv.objects;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    WorldView worldView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        worldView = new WorldView(this);
        this.setContentView(worldView);
    }
}

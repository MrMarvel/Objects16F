package com.vv.objects;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    WorldView worldView;
    final String TAG = "WORK";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        worldView = findViewById(R.id.world_view);

        Log.d(TAG, "onCreate");
    }

          public void plusPenguin(View view) {
            worldView.penguins[worldView.n] =
                    new Penguin(200, 200);
            worldView.n++;
    }
}
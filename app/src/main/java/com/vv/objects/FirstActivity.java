package com.vv.objects;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    private Button button;
    private EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        button = (Button) findViewById(R.id.verify);
        text = (EditText) findViewById(R.id.password);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                String p = text.getText().toString();
                if (p.equals("1")) {
                    Intent intent = new Intent(FirstActivity.this, MainActivity.class);
                    intent.putExtra("passw", p);
                    startActivity(intent);
                }
                else {
                    Toast toast = Toast.makeText(FirstActivity.this,"WRONG", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}

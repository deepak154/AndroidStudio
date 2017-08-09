package com.example.writer.button2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 Button runBt, newBT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runBt = (Button) findViewById(R.id.runBt);
        newBT= (Button) findViewById(R.id.newbt);
        runBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Hi there!!", Toast.LENGTH_SHORT).show();
            }
        });
        newBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"New Button ",Toast.LENGTH_SHORT).show();
            }
        });
    }
}

package com.example.writer.intentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
 EditText nameET, lnameET;
    Button subBt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameET = (EditText) findViewById(R.id.nameEt);
        lnameET = (EditText) findViewById(R.id.lnameEt);
        subBt= (Button) findViewById(R.id.subBt);
        subBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameET.getText().toString();
                String lname= lnameET.getText().toString();
                Intent intent = new Intent(MainActivity.this, Next.class);
                intent.putExtra("user",name);
                intent.putExtra("password",lname);
                startActivity(intent);
            }
        });
    }
}

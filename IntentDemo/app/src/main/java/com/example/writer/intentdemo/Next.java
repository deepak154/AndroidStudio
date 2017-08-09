package com.example.writer.intentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Next extends AppCompatActivity {
    TextView resultTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        Intent intent= getIntent();
        resultTV= (TextView) findViewById(R.id.resultTV);
       String us = intent.getStringExtra("user");
      String pass=  intent.getStringExtra("password");
        resultTV.setText("User Name = "+ us +"\n Password = "+pass);
    }
}

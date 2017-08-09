package com.example.writer.spinneranddbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Next2 extends AppCompatActivity {
TextView resultTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next2);
        Intent intent= getIntent();
        resultTV= (TextView) findViewById(R.id.resultTV);
        String city = intent.getStringExtra("City");
            resultTV.setText("City = " + city);

    }
}

package com.example.writer.alternatemethod;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Target extends AppCompatActivity {
    TextView resultTV;
    Button backBT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);
        backBT = (Button) findViewById(R.id.backBT);
        Intent in= getIntent();
        resultTV= (TextView) findViewById(R.id.resultTV);
        String city = in.getStringExtra("city");
        String zip = in.getStringExtra("zip");
        String land = in.getStringExtra("landmark");
        String vill = in.getStringExtra("town");
            if(zip==null)
            {
                zip="Not Specified";
            }
            if(land==null)
            {
                land = "Not Specified";
            }
            if(vill==null)
            {
                vill = "Not Specified";
            }

            resultTV.setText("City = " + city + "\nLocation = " + vill + "\nZip Code = " + zip + "\nLandmark = " + land + "\n \n YOUR DATA IS SAVED");

            backBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Target.this, MainActivity.class);
                startActivity(it);
            }
        });
    }

}


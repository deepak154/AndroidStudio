package com.example.writer.spinneranddbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Next extends AppCompatActivity {
TextView resultTV;
    Button backBT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        backBT = (Button) findViewById(R.id.backBT);
        Intent intent= getIntent();
        resultTV= (TextView) findViewById(R.id.resultTV);
            String city = intent.getStringExtra("City");
            String zip = intent.getStringExtra("Zip");
            String land = intent.getStringExtra("land");
            String vill = intent.getStringExtra("vill");
        if(zip.length()==0 )
        {
            zip="Not Specified";
        }
            if(land.length()==0)
            {
                land="Not Specified";
            }
            resultTV.setText("City = " + city + "\nLocation = "+vill+ "\nZip Code = "+zip + "\nLandmark = "+land+ "\n \n YOUR DATA IS SAVED");
      backBT.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent it = new Intent(Next.this, MainActivity.class);
              startActivity(it);
          }
      });
    }

}

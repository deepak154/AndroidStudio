package com.example.writer.ratingbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
RatingBar rateRB;
    TextView rateTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rateRB= (RatingBar) findViewById(R.id.rateRB);
        rateTV= (TextView) findViewById(R.id.rateTV);
        rateRB.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if(rating>2.5 && rating<=3.5)
                {
                    rateTV.setText("App Is Very Poor "+rating);
                }
                else if(rating>3.5 && rating<4)
                {
                    rateTV.setText("App Is Average "+rating);

                }
                else if(rating>=4 && rating<=5)
                {
                    rateTV.setText("App Is Good "+rating);

                }
                else
                {
                    rateTV.setText("Invalid Rating");
                }

            }
        });
    }
}

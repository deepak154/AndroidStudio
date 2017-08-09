package com.example.writer.timepicker;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;
import java.util.Calendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {
TimePicker ctimeTP;
    int hrs, min;
    final int dialogid =100;
    TextView resultTV;
    EditText dialogET;

    @Override
    protected Dialog onCreateDialog(int id) {
        switch(id)
        {
            case dialogid :return new TimePickerDialog(MainActivity.this,timeListener,hrs,min,true);

        }
        return null;
    }
TimePickerDialog.OnTimeSetListener timeListener = new TimePickerDialog.OnTimeSetListener() {
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        MainActivity.this.hrs= hourOfDay;
        MainActivity.this.min= minute;
        ctimeTP.setCurrentHour(hrs);
        ctimeTP.setCurrentMinute(min);
        if(hrs<=12) {

             if(min<10)
             {
                 resultTV.setText("" + hrs + ":0" + min+" AM");
                 dialogET.setText("" + hrs + ":0" + min + " AM");

             }
            else
             {
                 resultTV.setText("" + hrs + ":" + min+" AM");
                 dialogET.setText("" + hrs + ":" + min + " AM");
             }

        }
        else
        { hrs=hrs-12;
            if(min<10)
            {
                resultTV.setText("" + hrs + ":0" + min+" PM");
                dialogET.setText("" + hrs + ":0" + min + " PM");
            }
            else
            {
                resultTV.setText("" + hrs + ":" + min+" PM");
                dialogET.setText("" + hrs + ":" + min+" PM");
            }
        }
    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ctimeTP= (TimePicker) findViewById(R.id.ctimeTP);
        resultTV= (TextView) findViewById(R.id.resultTV);
        dialogET= (EditText) findViewById(R.id.dialogET);

        setCurrentTime();
    }

    private void setCurrentTime() {
        StringBuilder s, m;
        Calendar cal = Calendar.getInstance();
        hrs=cal.get(Calendar.HOUR_OF_DAY);
        min=cal.get(Calendar.MINUTE);
        ctimeTP.setCurrentHour(hrs);
        ctimeTP.setCurrentMinute(min);
        if(hrs<=12) {

            if(min<10)
            {
                resultTV.setText("" + hrs + ":0" + min+" AM");
            }
            else
            {
                resultTV.setText(""+hrs+":"+min+" AM");

            }
        }
        else
        { hrs=hrs-12;
            if(min<10)
            {
                resultTV.setText("" + hrs + ":0" + min+" PM");

            }
            else
            {
                resultTV.setText("" + hrs + ":" + min + " PM");
            }
        }
        dialogET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(dialogid);
            }
        });

    }
}

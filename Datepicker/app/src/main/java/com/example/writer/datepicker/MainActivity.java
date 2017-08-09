package com.example.writer.datepicker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;
public class MainActivity extends AppCompatActivity {
DatePicker datepickDP;
    int year, month, day;
    final int dialogid =100;

    Button dialogBT;
    TextView resultTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTV= (TextView) findViewById(R.id.resultTV);
        dialogBT= (Button) findViewById(R.id.dialogBt);
        datepickDP= (DatePicker) findViewById(R.id.datepickDP);


        setCurrentDate();


    }

    @Override
    protected Dialog onCreateDialog(int id) {

        switch (id)
        {
            case dialogid: return  new DatePickerDialog(MainActivity.this,dateListener,year,month,day);

        }
        return null;
    }
    DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

       MainActivity.this.year=year;
            MainActivity.this.month=monthOfYear;
            MainActivity.this.day=dayOfMonth+1;
            resultTV.setText(day+"/"+month+"/"+year);
            datepickDP.init(year, month, day, null);
        }
    };







    private void setCurrentDate() {
        Calendar cal = Calendar.getInstance();
      year = cal.get(Calendar.YEAR);
        day =cal.get(Calendar.DAY_OF_MONTH);
        month =cal.get(Calendar.MONTH)+1;
        resultTV.setText(day+"/"+month+"/"+year);
        datepickDP.init(year, month, day, null);
        dialogBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            showDialog(dialogid);
            }
        });
    }
}

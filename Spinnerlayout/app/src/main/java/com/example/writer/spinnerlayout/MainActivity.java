package com.example.writer.spinnerlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Spinner.OnItemSelectedListener {
ArrayList<Integer> table = new ArrayList<>();
    int i;
    Spinner citySP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(i=1; i<=100; i++)
        {
            table.add(i);
        }
        citySP = (Spinner) findViewById(R.id.citySP);
        ArrayAdapter<Integer> cityADP = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_spinner_item,table);
        cityADP.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySP.setAdapter(cityADP);
        citySP.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        int num = (int) parent.getItemAtPosition(position);

        StringBuilder tab = new StringBuilder();
        tab.append("Table is: ");
        int j, mul;

        for(j=1 ; j<= 10; j++)
        {
            mul=num*j;
            tab.append("\n"+mul);
        }
        Toast.makeText(MainActivity.this,tab,Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(MainActivity.this,"Nothing is selected ", Toast.LENGTH_SHORT).show();
    }
}

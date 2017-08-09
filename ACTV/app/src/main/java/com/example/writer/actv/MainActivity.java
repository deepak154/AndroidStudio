package com.example.writer.actv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {
String [] city ={"Ramnagar", "Nainital", "Kotdwar", "Dehradun", "Delhi"};
    AutoCompleteTextView cityACTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cityACTV = (AutoCompleteTextView) findViewById(R.id.cityACTV);
        ArrayAdapter<String> cityADP = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, city);
        cityACTV.setAdapter(cityADP);
        cityACTV.setThreshold(1);
    }
}

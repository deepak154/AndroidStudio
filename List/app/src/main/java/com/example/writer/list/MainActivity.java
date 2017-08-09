package com.example.writer.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
     String []city = { "Kotdwar", "Ramnagar","Nainital", "Almora", "Pauri", "Mukteshwar"};
     ListView cityLV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cityLV = (ListView) findViewById(R.id.cityLV);
        ArrayAdapter<String> cityAdp = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1, city);
        cityLV.setAdapter(cityAdp);
        cityLV.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        String item = parent.getItemAtPosition(position).toString();

        Toast.makeText(MainActivity.this,item,Toast.LENGTH_SHORT).show();

    }
}

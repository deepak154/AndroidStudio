package com.example.writer.tableoflist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener{
    ArrayList<Integer> arrayList = new ArrayList<>();
    int i;
    ListView tableLV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tableLV= (ListView) findViewById(R.id.tableLV);


        for(i=1; i<=100;i++)
        {
            arrayList.add(i);
        }

        ArrayAdapter<Integer> tableADP = new ArrayAdapter<Integer>(MainActivity.this,android.R.layout.simple_list_item_1,arrayList);
        tableLV.setAdapter(tableADP);
        tableLV.setOnItemClickListener(this);
    }


    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

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
}

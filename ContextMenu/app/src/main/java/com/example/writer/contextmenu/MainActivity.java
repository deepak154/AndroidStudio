package com.example.writer.contextmenu;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String [] name ={"Ram","Akhil", "Suraj","Sohan","Ravi"};

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getTitle()=="call")
        {  int id = ((int) item.getItemId());
            String var = "9917803942";
            Intent in = new Intent(Intent.ACTION_CALL);
            in.setData(Uri.parse("tel:"+var));
            in.setData(Uri.parse("tel:8475047257"));
            startActivity(in);
        }
        return super.onContextItemSelected(item);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("User Choice");
        menu.setHeaderIcon(android.R.drawable.ic_menu_call);
        menu.add(0, v.getId(), 0, "call");
    }

    ListView cityLV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cityLV = (ListView) findViewById(R.id.cityLV);
        ArrayAdapter<String> cityADP= new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,name);
        cityLV.setAdapter(cityADP);
        registerForContextMenu(cityLV);
    }
}

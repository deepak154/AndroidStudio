package com.example.writer.options;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id= item.getItemId();
        switch(id)
        {
            case R.id.galleryIT:
                Intent in = new Intent(Intent.ACTION_MAIN);  //intent for going from one page to another
                in.addCategory(Intent.CATEGORY_APP_GALLERY);
                startActivity(in);

                    break;

            case R.id.browserIT:
                Intent inb = new Intent(Intent.ACTION_MAIN);
                inb.addCategory(Intent.CATEGORY_APP_BROWSER);
                startActivity(inb);

                break;

            case R.id.musicIT:
                Intent inm = new Intent(Intent.ACTION_MAIN);
                inm.addCategory(Intent.CATEGORY_APP_MUSIC);
                startActivity(inm);

                break;


        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

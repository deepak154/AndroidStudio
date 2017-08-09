package com.example.writer.popupmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {
Button showBT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showBT= (Button) findViewById(R.id.showBT);
        showBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, showBT);
                popupMenu.getMenuInflater().inflate(R.menu.popup, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();
                        switch (id) {
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
                        return false;
                    }

                });

                   popupMenu.show();

                }

        });
    }
}

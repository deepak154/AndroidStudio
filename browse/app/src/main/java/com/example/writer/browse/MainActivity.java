package com.example.writer.browse;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText searchET;
    Button browseBT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchET= (EditText) findViewById(R.id.searchET);
        browseBT= (Button) findViewById(R.id.browseBT);
        browseBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent in = new Intent(Intent.ACTION_VIEW);
                    in.setData(Uri.parse(searchET.getText().toString()));
                    startActivity(in);



            }
        });
    }
}

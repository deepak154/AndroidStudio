package com.example.writer.dialoguebox;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 Button alertBt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alertBt = (Button) findViewById(R.id.alertBt);
        alertBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder errorAD = new AlertDialog.Builder(MainActivity.this);

                errorAD.setTitle("Exit");
                errorAD.setMessage("Are You Sure ?");
                errorAD.setIcon(R.mipmap.ic_launcher);

                errorAD.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        MainActivity.this.finish();

                    }
                });

                errorAD.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        dialog.cancel();
                    }
                });

                errorAD.setNeutralButton("I don't Know", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        Toast.makeText(MainActivity.this, "Well Done", Toast.LENGTH_SHORT).show();
                    }
                });

                errorAD.show();

            }
        });
    }

}

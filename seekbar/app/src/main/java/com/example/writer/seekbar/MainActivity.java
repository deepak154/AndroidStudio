package com.example.writer.seekbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
TextView textTV;
    SeekBar musicSB;
    int prgrss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        musicSB= (SeekBar) findViewById(R.id.musicSB);
        textTV= (TextView) findViewById(R.id.textTV);
        textTV.setText("PROGRESS :"+musicSB.getProgress()+"/"+musicSB.getMax());
       musicSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }
            @Override
            public void onStartTrackingTouch(final SeekBar seekBar) {


                Toast.makeText(MainActivity.this,"Started Tracking Seek Bar ",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int i;
                for(i=0; i<100; i++) {
                    seekBar.setProgress(i);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {

                    }
                }



            textTV.setText("PROGRESS :" + prgrss + "/" + musicSB.getMax());
                Toast.makeText(MainActivity.this,"Stopped Tracking Seek Bar ",Toast.LENGTH_SHORT).show();

            }
        });
    }
}

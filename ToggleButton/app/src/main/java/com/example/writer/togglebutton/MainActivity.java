package com.example.writer.togglebutton;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
ToggleButton butTB;
    TextView wifiTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butTB= (ToggleButton) findViewById(R.id.butTB);
        wifiTV= (TextView) findViewById(R.id.wifiTV);
        butTB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WifiManager wf = (WifiManager) getSystemService(Context.WIFI_SERVICE);
                if(butTB.isChecked())
                {

                    wf.setWifiEnabled(true);
                    wifiTV.setText("DISABLE WIFI");
                    String sp= butTB.getTextOn().toString();
                    Toast.makeText(MainActivity.this,sp,Toast.LENGTH_SHORT).show();
                }
                else
                {
                   wf.setWifiEnabled(false);
                    String sp= butTB.getTextOff().toString();
                    wifiTV.setText("ENABLE WIFI");
                    Toast.makeText(MainActivity.this,sp,Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}

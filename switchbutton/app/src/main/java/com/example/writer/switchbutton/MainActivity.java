package com.example.writer.switchbutton;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Switch wifiS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wifiS= (Switch) findViewById(R.id.wifiS);
        wifiS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
                if(wifiS.isChecked())
                {
                    wifiManager.setWifiEnabled(true);
                    String sp= wifiS.getTextOn().toString();
                    Toast.makeText(MainActivity.this,sp,Toast.LENGTH_SHORT).show();
                }
                else
                {
                    wifiManager.setWifiEnabled(false);
                    String sp= wifiS.getTextOff().toString();
                    Toast.makeText(MainActivity.this,sp,Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}

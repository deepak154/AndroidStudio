package com.example.writer.message;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText phoneET, msgET;
    Button sendBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phoneET= (EditText) findViewById(R.id.phoneET);
        msgET= (EditText) findViewById(R.id.msgET);
        sendBT= (Button) findViewById(R.id.sendBT);
        sendBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* SmsManager msg = SmsManager.getDefault();
                msg.sendTextMessage(phoneET.getText().toString(), null ,msgET.getText().toString(),null,null);*/
                //ALTERNATE METHOD
                Uri xy= Uri.parse("smsto:"+phoneET.getText().toString());
                Intent in = new Intent(Intent.ACTION_SENDTO,xy);
                in.putExtra("sms_body",msgET.getText().toString());
                startActivity(in);

            }
        });
    }
}

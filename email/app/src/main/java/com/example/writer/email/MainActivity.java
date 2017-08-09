package com.example.writer.email;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.util.Rfc822Token;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
Button subBT;
    EditText toET, subET, msgET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        subET= (EditText) findViewById(R.id.subET);
        toET= (EditText) findViewById(R.id.toET);
        msgET= (EditText) findViewById(R.id.msgET);
        subBT= (Button) findViewById(R.id.subBT);
        subBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to=toET.getText().toString();
                String sub=subET.getText().toString();
                String msg=msgET.getText().toString();
                Intent in= new Intent(Intent.ACTION_SEND);
                in.putExtra(Intent.EXTRA_EMAIL, new String[] {to});
                in.putExtra(Intent.EXTRA_SUBJECT,sub);
                in.putExtra(Intent.EXTRA_TEXT,msg)  ;
                in.setType("message/Rfc822");
                startActivity(Intent.createChooser(in ,"message"));
            }
        });
    }
}

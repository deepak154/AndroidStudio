package com.example.writer.layoutpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button newBt;
    EditText FN, LN, phone, address, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newBt= (Button) findViewById(R.id.newBt);
        FN= (EditText) findViewById(R.id.FN);
        LN= (EditText) findViewById(R.id.LN);
        email= (EditText) findViewById(R.id.email);
        address= (EditText) findViewById(R.id.address);
        phone= (EditText) findViewById(R.id.phone);
        newBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fn = FN.getText().toString();
                String ln = LN.getText().toString();
                String mail = email.getText().toString();
                String Phone= phone.getText().toString();
                String addr= address.getText().toString();

                Toast.makeText(MainActivity.this,"Name :"+fn+" "+ln+"\n Email :"+mail+"\n Phone No :"+Phone+"\n Address : "+addr ,Toast.LENGTH_SHORT).show();
            }
        });
    }
}

package com.example.writer.tryprogram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText emailET, passwordET;
    ImageView fbimageIV;
    Button loginBT;
    TextView forgotTV, signupTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailET= (EditText) findViewById(R.id.emailET);
        passwordET= (EditText) findViewById(R.id.passwordET);
        fbimageIV= (ImageView) findViewById(R.id.fbimageIV);
        loginBT= (Button) findViewById(R.id.loginBT);
        forgotTV= (TextView) findViewById(R.id.forgotTV);
        signupTV= (TextView) findViewById(R.id.signupTV);
    }
}

package com.example.writer.changealphabet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button repBT,clearBT;
    EditText repET,intialET, finalET,giveET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intialET= (EditText) findViewById(R.id.intialET);
        finalET= (EditText) findViewById(R.id.finalET);
        repET= (EditText) findViewById(R.id.repET);
        giveET= (EditText) findViewById(R.id.giveET);
        repBT= (Button) findViewById(R.id.repBT);
        clearBT= (Button) findViewById(R.id.clearBT);
        repBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             int len=   intialET.getText().toString().length();
                String inti= intialET.getText().toString();
                StringBuilder fin = new StringBuilder("");
                char give=  giveET.getText().toString().charAt(0);
                char rep=  repET.getText().toString().charAt(0);

                for(int i=0; i<len; i++)
                {
                    if(inti.charAt(i)==give)
                    {
                        fin.append(""+rep);
                    }
                    else
                    {
                        fin.append(""+inti.charAt(i));
                    }

                }
                finalET.setText(fin);
            }
        });
        clearBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this,MainActivity.class);
                startActivity(in);
            }
        });
    }
}

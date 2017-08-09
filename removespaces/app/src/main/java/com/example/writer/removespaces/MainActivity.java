package com.example.writer.removespaces;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button csBT;
    TextView newTV;
    EditText enterET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enterET= (EditText) findViewById(R.id.enterET);
        csBT= (Button) findViewById(R.id.csBT);
        newTV= (TextView) findViewById(R.id.newTV);
        csBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String st = enterET.getText().toString();
                StringBuilder st1 = new StringBuilder("");
                int i;
                for(i=0; i<st.length();i++)
                {
                    if(st.charAt(i)==' ' )
                    {
                    }
                    else
                    {
                        st1.append(st.charAt(i));
                    }
                }
                newTV.setText(st1);
            }
        });
    }
}

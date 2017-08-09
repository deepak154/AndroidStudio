package com.example.writer.hotellayout;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
  Button submitbt;
    CheckBox pizzacb, burgercb, coffeecb;
    RadioGroup genderRG;
    RadioButton maleRb, femaleRB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        genderRG= (RadioGroup) findViewById(R.id.genderRG);
        maleRb = (RadioButton) findViewById(R.id.maleRB);
        femaleRB= (RadioButton) findViewById(R.id.femaleRB);
        pizzacb= (CheckBox) findViewById(R.id.pizzacb);
        burgercb= (CheckBox) findViewById(R.id.burgercb);
        coffeecb= (CheckBox) findViewById(R.id.coffeecb);
        submitbt= (Button) findViewById(R.id.submitbt);
        genderRG.setOnCheckedChangeListener(this);
        submitbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Bill =0;
                boolean coffeeod = ((boolean) coffeecb.isChecked());

                StringBuilder stringBuilder = new StringBuilder(" Bill Discription :");
                if(pizzacb.isChecked()) {

                    stringBuilder.append("\n Pizza :500 Rs");
                    Bill+=500;
                }
                if(burgercb.isChecked()) {
                   stringBuilder.append("\n Burger : 250 Rs");
                    Bill+=250;
                }
                if(coffeeod) {
                    stringBuilder.append("\n Coffee : 250 Rs");
                    Bill+=250;
                }
                stringBuilder.append(" \n Total Bill :"+Bill);
                Toast.makeText(MainActivity.this,stringBuilder, Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(checkedId== R.id.femaleRB)
        {
            Toast.makeText(MainActivity.this,"\n Welcome to this Restaurant milady !! ", Toast.LENGTH_SHORT).show();
        }
        if(checkedId== R.id.maleRB)
        {
            Toast.makeText(MainActivity.this,"\n It's a  pleasure to have you here monseiur !! ", Toast.LENGTH_SHORT).show();
        }

    }
}



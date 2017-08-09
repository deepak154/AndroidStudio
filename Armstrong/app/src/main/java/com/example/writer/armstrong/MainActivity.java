package com.example.writer.armstrong;

import android.app.AlertDialog;
import android.app.Notification;
import android.content.Context;
import android.content.DialogInterface;
import android.media.AudioManager;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText numET;
    Button oneBT, twoBT, threeBT, fourBT, fiveBT, sixBT, sevenBT, eightBT, nineBT ,zeroBT, delBT, sendBT,tryanBT, exitBT;
    TextView resultTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        oneBT= (Button) findViewById(R.id.oneBT);
        twoBT= (Button) findViewById(R.id.twoBT);
        threeBT= (Button) findViewById(R.id.threebT);
        fourBT= (Button) findViewById(R.id.fourBT);
        fiveBT= (Button) findViewById(R.id.fiveBT);
        sixBT= (Button) findViewById(R.id.sixBT);
        sevenBT= (Button) findViewById(R.id.sevenBT);
        eightBT= (Button) findViewById(R.id.eightBT);
        nineBT= (Button) findViewById(R.id.nineBT);
        zeroBT= (Button) findViewById(R.id.zeroBT);
        delBT= (Button) findViewById(R.id.delBT);
        sendBT= (Button) findViewById(R.id.sendBT);
        tryanBT= (Button) findViewById(R.id.tryanBT);
        exitBT= (Button) findViewById(R.id.exitBT);
        numET= (EditText) findViewById(R.id.numET);
        resultTV= (TextView) findViewById(R.id.resultTV);

        oneBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int len=numET.getText().toString().length();
                if(len>=5)
                {
                    Toast.makeText(MainActivity.this,"MAXIMUM NUMBER OF DIGITS (5) EXCEED",Toast.LENGTH_SHORT).show();
                }
                else {
                    numET.append("1");
                }
            }
        });
        twoBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int len = numET.getText().toString().length();
                if (len >=5) {
                    Toast.makeText(MainActivity.this, "MAXIMUM NUMBER OF DIGITS (5) EXCEED", Toast.LENGTH_SHORT).show();
                } else {
                    numET.append("2");
                }
            }
        });
        threeBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int len = numET.getText().toString().length();
                if (len >= 5) {
                    Toast.makeText(MainActivity.this, "MAXIMUM NUMBER OF DIGITS (5) EXCEED", Toast.LENGTH_SHORT).show();
                } else {
                    numET.append("3");
                }
            }
        });
        fourBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int len=numET.getText().toString().length();
                if(len>=5)
                {
                    Toast.makeText(MainActivity.this,"MAXIMUM NUMBER OF DIGITS (5) EXCEED",Toast.LENGTH_SHORT).show();
                }
                else
                {
                numET.append("4");
                }
            }

        });
        fiveBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int len = numET.getText().toString().length();
                if (len >= 5) {
                    Toast.makeText(MainActivity.this, "MAXIMUM NUMBER OF DIGITS (5) EXCEED", Toast.LENGTH_SHORT).show();
                } else {
                    numET.append("5");
                }
            }

        });
        sixBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int len=numET.getText().toString().length();
                if(len>=5)
                {
                    Toast.makeText(MainActivity.this,"MAXIMUM NUMBER OF DIGITS (5) EXCEED",Toast.LENGTH_SHORT).show();
                }
                else
                {
                numET.append("6");
               }
            }

        });
        sevenBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int len = numET.getText().toString().length();
                if (len >=5) {
                    Toast.makeText(MainActivity.this, "MAXIMUM NUMBER OF DIGITS (5) EXCEED", Toast.LENGTH_SHORT).show();
                } else {
                    numET.append("7");
                }
            }
        });
        eightBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int len = numET.getText().toString().length();
                if (len >= 5) {
                    Toast.makeText(MainActivity.this, "MAXIMUM NUMBER OF DIGITS (5) EXCEED", Toast.LENGTH_SHORT).show();
                } else {
                    numET.append("8");
                }
            }

        });
        nineBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int len = numET.getText().toString().length();
                if (len >=5) {
                    Toast.makeText(MainActivity.this, "MAXIMUM NUMBER OF DIGITS (5) EXCEED", Toast.LENGTH_SHORT).show();
                } else {
                    numET.append("9");
                }
            }

        });
        zeroBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int len = numET.getText().toString().length();
                if (len >=5) {
                    Toast.makeText(MainActivity.this, "MAXIMUM NUMBER OF DIGITS (5) EXCEED", Toast.LENGTH_SHORT).show();
                } else {
                    numET.append("0");
                }
            }
        });
        delBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (numET.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Nothing to delete !!", Toast.LENGTH_SHORT).show();
                } else {
                    if (resultTV.getText().toString().length() > 0) {
                     Toast toast =   Toast.makeText(MainActivity.this, "SELECT TRY AGAIN, TO OUTPUT FOR ANOTHER NUMBER", Toast.LENGTH_SHORT);
                         toast.show();
                    } else {
                        String tweet = numET.getText().toString();
                        numET.setText(tweet.substring(0, tweet.length() - 1));
                    }
                }
            }
        });
        delBT.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (numET.getText().toString().length() == 0) {
                    Toast.makeText(MainActivity.this, "Nothing to delete !!", Toast.LENGTH_SHORT).show();
                } else {
                    if (resultTV.getText().toString().length() > 0) {
                        Toast.makeText(MainActivity.this, "SELECT TRY AGAIN, TO OUTPUT FOR ANOTHER NUMBER", Toast.LENGTH_SHORT).show();
                    } else {
                        numET.setText("");
                    }
                }
                return true;
            }
        });
            sendBT.setOnClickListener(new View.OnClickListener()

            {
                @Override
                public void onClick (View v) {
                    if (numET.getText().toString().length() == 0) {
                        Toast.makeText(MainActivity.this, "ENTER A NUMBER FIRST!!", Toast.LENGTH_SHORT).show();
                    } else {
                        if (resultTV.getText().toString().length() > 0) {
                            Toast.makeText(MainActivity.this, "SELECT TRY AGAIN, TO OUTPUT FOR ANOTHER NUMBER", Toast.LENGTH_SHORT).show();
                        } else {
                            String x = numET.getText().toString();
                            int len = x.length();
                            int numb = Integer.parseInt(x);
                            int r, sum = 0, mul, numa = numb;
                            while (numb != 0) {
                                r = numb % 10;
                                mul = (int) Math.pow(r, len);
                                sum += mul;
                                numb = numb / 10;
                            }
                            if (sum == numa) {
                                resultTV.setText("" + numa + " IS A ARMSTRONG NUMBER");
                            } else {
                                resultTV.setText("" + numa + " IS  NOT A ARMSTRONG NUMBER");
                            }

                        }
                    }
                }
            }

            );
            tryanBT.setOnClickListener(new View.OnClickListener()

                                       {
                                           @Override
                                           public void onClick(View v) {
                                               resultTV.setText("");
                                               numET.setText("");
                                           }
                                       }

            );
            exitBT.setOnClickListener(new View.OnClickListener()

                                      {
                                          @Override
                                          public void onClick(View v) {
                                              AlertDialog.Builder errorAD = new AlertDialog.Builder(MainActivity.this);

                                              errorAD.setTitle("Exit");
                                              errorAD.setMessage("Are You Sure ?");
                                              errorAD.setIcon(R.mipmap.ic_launcher);

                                              errorAD.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                                                  @Override
                                                  public void onClick(DialogInterface dialog, int which) {

                                                      MainActivity.this.finish();

                                                  }
                                              });

                                              errorAD.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                                  @Override
                                                  public void onClick(DialogInterface dialog, int which) {


                                                      dialog.cancel();
                                                  }
                                              });


                                              errorAD.show();

                                          }
                                      }

            );
        }
    }

package com.example.writer.trial;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;





public class MainActivity extends AppCompatActivity implements Spinner.OnItemSelectedListener {
    String[] city = {"Select City", "Dehradun", "Delhi", "Ramnagar"};
    Spinner citySP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        citySP = (Spinner) findViewById(R.id.citySP);
        ArrayAdapter<String> cityADP = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, city);
        cityADP.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySP.setAdapter(cityADP);
        citySP.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        final String sid = (String) parent.getItemAtPosition(position);
        if (sid == "Select City") {

        } else {
            final Dialog dialog = new Dialog(MainActivity.this);
            dialog.setContentView(R.layout.alertbox);
            final EditText zipET;
            final int[] Textchange = {0};
            final StringBuilder sc = new StringBuilder("");
            final StringBuilder area = new StringBuilder("");
            final StringBuilder tc = new StringBuilder("");
            final StringBuilder vc = new StringBuilder("");
            final String[] zipstr = new String[1];
            final int[] ct = new int[1];
            final boolean[] value = new boolean[1];
            final AutoCompleteTextView landACTV;
            TextView cityTV;
            Button subBt, exitBt;
            final Spinner villageSP;
            final CheckBox saveCB;
            ImageView locnIV;
            locnIV = (ImageView) dialog.findViewById(R.id.locnIV);
            zipET = (EditText) dialog.findViewById(R.id.zipET);
            landACTV = (AutoCompleteTextView) dialog.findViewById(R.id.landACTV);
            cityTV = (TextView) dialog.findViewById(R.id.cityTV);
            subBt = (Button) dialog.findViewById(R.id.subBt);
            exitBt = (Button) dialog.findViewById(R.id.exitBT);
            villageSP = (Spinner) dialog.findViewById(R.id.villageSP);
            saveCB = (CheckBox) dialog.findViewById(R.id.saveCB);

            cityTV.setText(sid);

            if (sid == "Dehradun") {
                String[] vill = {"Select Area", "Premnagar", "Rajpur", "ISBT"};
                for (int i = 1; i < 4; i++) {
                    area.append("" + vill[i] + "\n");

                }

                ArrayAdapter<String> vADP = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, vill);
                vADP.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                villageSP.setAdapter((vADP));
                vc.delete(0,vc.length());
                villageSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        final int vpos = position;


                        if (vpos == 0) {

                        } else if (vpos == 1) {
                            final String[] ld = {"Gurudwara", "Caprico", "Cast"};
                            zipET.setText("1200");
                            zipstr[0] =zipET.getText().toString();
                            zipET.addTextChangedListener(new TextWatcher() {
                                @Override
                                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                                }

                                @Override
                                public void onTextChanged(CharSequence s, int start, int before, int count) {
                                  value[0] =true;
                                }

                                @Override
                                public void afterTextChanged(Editable s) {

                                }
                            });

                            ArrayAdapter<String> landADP = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, ld);
                            landACTV.setAdapter(landADP);
                            landACTV.setThreshold(1);
                            for (int i = 0; i < 3; i++) {
                                vc.append("" + ld[i]+"\n");

                            }



                            landACTV.addTextChangedListener(new TextWatcher() {
                                @Override
                                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                                    vc.delete(0,vc.length());
                                    for (int i = 0; i < 3; i++) {
                                        vc.append("" + ld[i]+"\n");

                                    }


                                }

                                @Override
                                public void onTextChanged(CharSequence s, int start, int before, int count) {
                                    Textchange[0] =1;
                                }

                                @Override
                                public void afterTextChanged(Editable s) {
                                    String st=landACTV.getText().toString();
                                    if(st.length()>=1) {
                                        int c = 0;
                                        sc.delete(0,sc.length());
                                        for (int i = 0; i < 3; i++) {
                                            if (ld[i].toUpperCase().startsWith(st.toUpperCase())) {
                                                c++;
                                                sc.append("" + ld[i]+"\n");
                                            }
                                        }
                                        if (c == 0) {
                                            tc.delete(0,tc.length());
                                            for (int i = 0; i < 3; i++) {
                                                tc.append("" + ld[i]+"\n");

                                            }
                                        }
                                        ct[0] = c;
                                    }


                                }
                            });
                        } else if (vpos == 2) {
                            final String[] ld = {"Pacific Mall", "Ghanta Ghar", "Gandhi Park"};
                            zipET.setText("1300");
                            zipstr[0] =zipET.getText().toString();
                            zipET.addTextChangedListener(new TextWatcher() {
                                @Override
                                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                                }

                                @Override
                                public void onTextChanged(CharSequence s, int start, int before, int count) {
                                    value[0] = true;
                                }

                                @Override
                                public void afterTextChanged(Editable s) {

                                }
                            });

                            ArrayAdapter<String> landADP = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, ld);
                            landACTV.setAdapter(landADP);
                            landACTV.setThreshold(1);
                            for (int i = 0; i < 3; i++) {
                                vc.append("" + ld[i] + "\n");
                            }


                            landACTV.addTextChangedListener(new TextWatcher() {
                                @Override
                                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                                    vc.delete(0,vc.length());
                                    for (int i = 0; i < 3; i++) {
                                        vc.append("" + ld[i]+"\n");

                                    }
                                }

                                @Override
                                public void onTextChanged(CharSequence s, int start, int before, int count) {
                                    Textchange[0] =1;
                                }

                                @Override
                                public void afterTextChanged(Editable s) {
                                    String st=landACTV.getText().toString();
                                    if(st.length()>=1) {
                                        int c = 0;
                                        sc.delete(0,sc.length());
                                        for (int i = 0; i < 3; i++) {
                                            if (ld[i].toUpperCase().startsWith(st.toUpperCase())) {
                                                c++;
                                                sc.append("" + ld[i]+"\n");
                                            }
                                        }
                                        if (c == 0) {
                                            tc.delete(0,tc.length());
                                            for (int i = 0; i < 3; i++) {
                                                tc.append("" + ld[i]+"\n");

                                            }
                                        }
                                        ct[0] = c;
                                    }

                                }
                            });
                        } else if (vpos == 3) {
                            final String[] ld = {"Old", "New", "IS"};
                            zipET.setText("4200");
                            zipstr[0] =zipET.getText().toString();
                            zipET.addTextChangedListener(new TextWatcher() {
                                @Override
                                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                                }

                                @Override
                                public void onTextChanged(CharSequence s, int start, int before, int count) {
                                    value[0] = true;
                                }

                                @Override
                                public void afterTextChanged(Editable s) {

                                }
                            });

                            ArrayAdapter<String> landADP = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, ld);
                            landACTV.setAdapter(landADP);
                            landACTV.setThreshold(1);
                            for (int i = 0; i < 3; i++) {
                                vc.append("" + ld[i]+"\n");

                            }



                            landACTV.addTextChangedListener(new TextWatcher() {
                                @Override
                                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                                    vc.delete(0,vc.length());
                                    for (int i = 0; i < 3; i++) {
                                        vc.append("" + ld[i]+"\n");

                                    }
                                }

                                @Override
                                public void onTextChanged(CharSequence s, int start, int before, int count) {
                                    Textchange[0] =1;
                                }

                                @Override
                                public void afterTextChanged(Editable s) {
                                    String st=landACTV.getText().toString();
                                    if(st.length()>=1) {
                                        int c = 0;
                                        sc.delete(0,sc.length());
                                        for (int i = 0; i < 3; i++) {
                                            if (ld[i].toUpperCase().startsWith(st.toUpperCase())) {
                                                c++;
                                                sc.append("" + ld[i]+"\n");
                                            }
                                        }
                                        if (c == 0) {
                                            tc.delete(0,tc.length());
                                            for (int i = 0; i < 3; i++) {
                                                tc.append("" + ld[i]+"\n");

                                            }
                                        }
                                        ct[0] = c;
                                    }


                                }
                            });
                        }


                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

            } else if (sid == "Delhi") {
                String[] vill = {"Select Area", "Chandni Chowk", "ISBT", "Lal Kila"};
                for (int i = 1; i < 4; i++) {
                    area.append("" + vill[i]+"\n");

                }
                ArrayAdapter<String> vADP = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, vill);
                vADP.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                villageSP.setAdapter((vADP));
                vc.delete(0, vc.length());
                villageSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        final int vpos = position;
                        if (vpos == 0) {

                        } else if (vpos == 1) {
                            final String[] ld = {"Old Delhi", "Maldanchaur", "Maldives"};
                            zipET.setText("4340");
                            zipstr[0] =zipET.getText().toString();
                            zipET.addTextChangedListener(new TextWatcher() {
                                @Override
                                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                                }

                                @Override
                                public void onTextChanged(CharSequence s, int start, int before, int count) {
                                    value[0] = true;
                                }

                                @Override
                                public void afterTextChanged(Editable s) {

                                }
                            });

                            ArrayAdapter<String> landADP = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, ld);
                            landACTV.setAdapter(landADP);
                            landACTV.setThreshold(1);
                            for (int i = 0; i < 3; i++) {
                                vc.append("" + ld[i]+"\n");

                            }
                            landACTV.addTextChangedListener(new TextWatcher() {
                                @Override
                                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                                    vc.delete(0,vc.length());
                                    for (int i = 0; i < 3; i++) {
                                        vc.append("" + ld[i]+"\n");

                                    }
                                }

                                @Override
                                public void onTextChanged(CharSequence s, int start, int before, int count) {
                                    Textchange[0] =1;
                                }

                                @Override
                                public void afterTextChanged(Editable s) {
                                    String st=landACTV.getText().toString();
                                    if(st.length()>=1) {
                                        int c = 0;
                                        sc.delete(0,sc.length());
                                        for (int i = 0; i < 3; i++) {
                                            if (ld[i].toUpperCase().startsWith(st.toUpperCase())) {
                                                c++;
                                                sc.append("" + ld[i]+"\n");
                                            }
                                        }
                                        if (c == 0) {
                                            tc.delete(0,tc.length());
                                            for (int i = 0; i < 3; i++) {
                                                tc.append("" + ld[i]+"\n");

                                            }
                                        }
                                        ct[0] = c;
                                    }


                                }
                            });
                        } else if (vpos == 3) {
                            final String[] ld = {"Lotus Temple", "Gandhi Park", "Mad"};
                            zipET.setText("4341");
                            zipstr[0] =zipET.getText().toString();
                            zipET.addTextChangedListener(new TextWatcher() {
                                @Override
                                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                                }

                                @Override
                                public void onTextChanged(CharSequence s, int start, int before, int count) {
                                    value[0] = true;
                                }

                                @Override
                                public void afterTextChanged(Editable s) {

                                }
                            });

                            ArrayAdapter<String> landADP = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, ld);
                            landACTV.setAdapter(landADP);
                            landACTV.setThreshold(1);
                            for (int i = 0; i < 3; i++) {
                                vc.append("" + ld[i]+"\n");

                            }
                            landACTV.addTextChangedListener(new TextWatcher() {
                                @Override
                                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                                    vc.delete(0,vc.length());
                                    for (int i = 0; i < 3; i++) {
                                        vc.append("" + ld[i]+"\n");

                                    }
                                }

                                @Override
                                public void onTextChanged(CharSequence s, int start, int before, int count) {
                                    Textchange[0] =1;
                                }

                                @Override
                                public void afterTextChanged(Editable s) {
                                    String st=landACTV.getText().toString();
                                    if(st.length()>=1) {
                                        int c = 0;
                                        sc.delete(0,sc.length());
                                        for (int i = 0; i < 3; i++) {
                                            if (ld[i].toUpperCase().startsWith(st.toUpperCase())) {
                                                c++;
                                                sc.append("" + ld[i]+"\n");
                                            }
                                        }
                                        if (c == 0) {
                                            tc.delete(0,tc.length());
                                            for (int i = 0; i < 3; i++) {
                                                tc.append("" + ld[i]+"\n");

                                            }
                                        }
                                        ct[0] = c;
                                    }
                                }
                            });
                        } else if (vpos == 2) {
                            final String[] ld = {"Old", "New", "IS"};
                            zipET.setText("4347");
                            zipstr[0] =zipET.getText().toString();
                            zipET.addTextChangedListener(new TextWatcher() {
                                @Override
                                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                                }

                                @Override
                                public void onTextChanged(CharSequence s, int start, int before, int count) {
                                    value[0] = true;
                                }

                                @Override
                                public void afterTextChanged(Editable s) {

                                }
                            });

                            ArrayAdapter<String> landADP = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, ld);
                            landACTV.setAdapter(landADP);
                            landACTV.setThreshold(1);
                            for (int i = 0; i < 3; i++) {
                                vc.append("" + ld[i]+"\n");

                            }
                            landACTV.addTextChangedListener(new TextWatcher() {
                                @Override
                                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                                    vc.delete(0,vc.length());
                                    for (int i = 0; i < 3; i++) {
                                        vc.append("" + ld[i]+"\n");

                                    }
                                }

                                @Override
                                public void onTextChanged(CharSequence s, int start, int before, int count) {
                                    Textchange[0] =1;
                                }

                                @Override
                                public void afterTextChanged(Editable s) {
                                    String st=landACTV.getText().toString();
                                    if(st.length()>=1) {
                                        int c = 0;
                                        sc.delete(0,sc.length());
                                        for (int i = 0; i < 3; i++) {
                                            if (ld[i].toUpperCase().startsWith(st.toUpperCase())) {
                                                c++;
                                                sc.append("" + ld[i]+"\n");
                                            }
                                        }
                                        if (c == 0) {
                                            tc.delete(0,tc.length());
                                            for (int i = 0; i < 3; i++) {
                                                tc.append("" + ld[i]+"\n");

                                            }
                                        }
                                        ct[0] = c;
                                    }
                                }
                            });
                        }

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });


            } else if (sid == "Ramnagar") {
                String[] vill = {"Select Area", "Garjia", "Pirumadara", "Kaniya"};
                for (int i = 1; i < 4; i++) {
                    area.append("" + vill[i]+"\n");

                }
                ArrayAdapter<String> vADP = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, vill);
                vADP.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                villageSP.setAdapter((vADP));
                vc.delete(0, vc.length());
                villageSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        final int vpos = position;
                        if (vpos == 0) {

                        } else if (vpos == 1) {
                            final String[] ld = {"Temple Old", "Mohan", "Marchula"};
                            zipET.setText("5671");
                            zipstr[0] =zipET.getText().toString();
                            zipET.addTextChangedListener(new TextWatcher() {
                                @Override
                                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                                }

                                @Override
                                public void onTextChanged(CharSequence s, int start, int before, int count) {
                                    value[0] = true;
                                }

                                @Override
                                public void afterTextChanged(Editable s) {

                                }
                            });

                            ArrayAdapter<String> landADP = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, ld);
                            landACTV.setAdapter(landADP);
                            landACTV.setThreshold(1);
                            for (int i = 0; i < 3; i++) {
                                vc.append("" + ld[i]+"\n");

                            }
                            landACTV.addTextChangedListener(new TextWatcher() {
                                @Override
                                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                                    vc.delete(0,vc.length());
                                    for (int i = 0; i < 3; i++) {
                                        vc.append("" + ld[i]+"\n");

                                    }
                                }

                                @Override
                                public void onTextChanged(CharSequence s, int start, int before, int count) {
                                    Textchange[0] =1;
                                }

                                @Override
                                public void afterTextChanged(Editable s) {
                                    String st=landACTV.getText().toString();
                                    if(st.length()>=1) {
                                        int c = 0;
                                        sc.delete(0,sc.length());
                                        for (int i = 0; i < 3; i++) {
                                            if (ld[i].toUpperCase().startsWith(st.toUpperCase())) {
                                                c++;
                                                sc.append("" + ld[i]+"\n");
                                            }
                                        }
                                        if (c == 0) {
                                            tc.delete(0,tc.length());
                                            for (int i = 0; i < 3; i++) {
                                                tc.append("" + ld[i]+"\n");

                                            }
                                        }
                                        ct[0] = c;
                                    }
                                }
                            });
                        } else if (vpos == 2) {
                            final String[] ld = {"Sai Mandir", "Pir Baba", "Tanda"};
                            zipET.setText("5673");
                            zipstr[0] =zipET.getText().toString();
                            zipET.addTextChangedListener(new TextWatcher() {
                                @Override
                                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                                }

                                @Override
                                public void onTextChanged(CharSequence s, int start, int before, int count) {
                                    value[0] = true;
                                }

                                @Override
                                public void afterTextChanged(Editable s) {

                                }
                            });

                            ArrayAdapter<String> landADP = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, ld);
                            landACTV.setAdapter(landADP);
                            landACTV.setThreshold(1);
                            for (int i = 0; i < 3; i++) {
                                vc.append("" + ld[i]+"\n");

                            }
                            landACTV.addTextChangedListener(new TextWatcher() {
                                @Override
                                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                                    vc.delete(0,vc.length());
                                    for (int i = 0; i < 3; i++) {
                                        vc.append("" + ld[i]+"\n");

                                    }
                                }

                                @Override
                                public void onTextChanged(CharSequence s, int start, int before, int count) {
                                    Textchange[0] =1;
                                }

                                @Override
                                public void afterTextChanged(Editable s) {
                                    String st=landACTV.getText().toString();
                                    if(st.length()>=1) {
                                        int c = 0;
                                        sc.delete(0,sc.length());
                                        for (int i = 0; i < 3; i++) {
                                            if (ld[i].toUpperCase().startsWith(st.toUpperCase())) {
                                                c++;
                                                sc.append("" + ld[i]+"\n");
                                            }
                                        }
                                        if (c == 0) {
                                            tc.delete(0,tc.length());
                                            for (int i = 0; i < 3; i++) {
                                                tc.append("" + ld[i]+"\n");

                                            }
                                        }
                                        ct[0] = c;
                                    }
                                }
                            });
                        } else if (vpos == 3) {
                            final String[] ld = {" Ka Old", "Ha House", "Madcracker"};
                            zipET.setText("5109");
                            zipstr[0] =zipET.getText().toString();
                            zipET.addTextChangedListener(new TextWatcher() {
                                @Override
                                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                                }

                                @Override
                                public void onTextChanged(CharSequence s, int start, int before, int count) {
                                    value[0] = true;
                                }

                                @Override
                                public void afterTextChanged(Editable s) {

                                }
                            });

                            ArrayAdapter<String> landADP = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, ld);
                            landACTV.setAdapter(landADP);
                            landACTV.setThreshold(1);
                            for (int i = 0; i < 3; i++) {
                                vc.append("" + ld[i]+"\n");

                            }
                            landACTV.addTextChangedListener(new TextWatcher() {
                                @Override
                                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                                    vc.delete(0,vc.length());
                                    for (int i = 0; i < 3; i++) {
                                        vc.append("" + ld[i]+"\n");

                                    }
                                }

                                @Override
                                public void onTextChanged(CharSequence s, int start, int before, int count) {
                                    Textchange[0] =1;
                                }

                                @Override
                                public void afterTextChanged(Editable s) {
                                    String st=landACTV.getText().toString();
                                    if(st.length()>=1) {
                                        int c = 0;
                                        sc.delete(0,sc.length());
                                        for (int i = 0; i < 3; i++) {
                                            if (ld[i].toUpperCase().startsWith(st.toUpperCase())) {
                                                c++;
                                                sc.append("" + ld[i]+"\n");
                                            }
                                        }
                                        if (c == 0) {
                                            tc.delete(0,tc.length());
                                            for (int i = 0; i < 3; i++) {
                                                tc.append("" + ld[i]+"\n");

                                            }
                                        }
                                        ct[0] = c;
                                    }

                                }
                            });
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });


            }
            dialog.show();
            Window window = dialog.getWindow();
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            exitBt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent it = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(it);
                }
            });
            subBt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (saveCB.isChecked()) {
                        String zip = zipET.getText().toString();
                        String vid = villageSP.getSelectedItem().toString();
                        String st = landACTV.getText().toString();
                        if (vid == "Select Area") {
                            Toast.makeText(MainActivity.this, "AREA NOT SPECIFIED !!! \n" + area.toString(), Toast.LENGTH_SHORT).show();
                            zipET.setText("");
                            landACTV.setText("");
                            saveCB.setChecked(false);
                        } else {
                            if (st.length() >= 1) {
                                if (ct[0] == 1) {
                                    if (vid == "Select Area") {
                                        vid = "Not Specified";
                                    }
                                    if(value[0]==true)
                                    {
                                     Toast.makeText(MainActivity.this,"Correct Zip value not Specified , It must be\n"+zipstr[0],Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        String land = sc.toString();
                                        sc.delete(0, sc.length());
                                        Intent intent = new Intent(MainActivity.this, Next.class);
                                        intent.putExtra("City", sid);
                                        intent.putExtra("Zip", zip);
                                        intent.putExtra("land", land);
                                        intent.putExtra("vill", vid);
                                        startActivity(intent);
                                    }
                                } else if (ct[0] == 0) {
                                    if(value[0]==true)
                                    {
                                        Toast.makeText(MainActivity.this,"Correct Zip value not Specified, It must be \n"+zipstr[0],Toast.LENGTH_SHORT).show();
                                    }
                                    Toast.makeText(MainActivity.this, "Area not Specified, Try again with this list \n" + tc.toString()
                                            , Toast.LENGTH_SHORT).show();
                                    landACTV.setText("");
                                    saveCB.setChecked(false);
                                    tc.delete(0, tc.length());
                                } else if (ct[0] > 1) {
                                    if(value[0]==true)
                                    {
                                        Toast.makeText(MainActivity.this,"Correct Zip value not Specified, It must be \n"+zipstr[0],Toast.LENGTH_SHORT).show();
                                    }
                                    Toast.makeText(MainActivity.this, "Area not Specified, Try again with this list \n" + sc.toString()
                                            , Toast.LENGTH_SHORT).show();
                                    landACTV.setText("");
                                    saveCB.setChecked(false);
                                    sc.delete(0, sc.length());
                                }
                            } else if (st.length() == 0 && Textchange[0] == 0) {
                                if(value[0]==true)
                                {
                                    Toast.makeText(MainActivity.this,"Correct Zip value not Specified , It must be\n"+zipstr[0],Toast.LENGTH_SHORT).show();
                                }
                                Toast.makeText(MainActivity.this, "Landmark not Specified, Try again with this list \n" + vc.toString()
                                        , Toast.LENGTH_SHORT).show();
                                landACTV.setText("");
                                saveCB.setChecked(false);
                            } else if (st.length() == 0 && Textchange[0] == 1) {
                                if(value[0]==true)
                            {
                                Toast.makeText(MainActivity.this,"Correct Zip value not Specified , It must be\n"+zipstr[0],Toast.LENGTH_SHORT).show();
                            }

                                Toast.makeText(MainActivity.this, "Landmark not Specified, Try again with this list \n" + vc.toString()
                                        , Toast.LENGTH_SHORT).show();
                                landACTV.setText("");
                                saveCB.setChecked(false);
                                vc.delete(0, vc.length());
                            }
                        }
                    } else {
                        Intent intent = new Intent(MainActivity.this, Next2.class);
                        intent.putExtra("City", sid);
                        startActivity(intent);
                    }
                }
            });
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



}





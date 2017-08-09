package com.example.writer.alternatemethod;


        import android.app.Dialog;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.net.MailTo;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.view.Window;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.AutoCompleteTextView;
        import android.widget.Button;
        import android.widget.CheckBox;
        import android.widget.CompoundButton;
        import android.widget.EditText;
        import android.widget.Spinner;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.lang.annotation.Target;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView cityTV;
    Spinner townSP;
    EditText zipET;
    AutoCompleteTextView landmarkACTV;
    Button submitBT,cancelBT;
    CheckBox rememberCB;
    StringBuilder storeVal;
    Spinner citySP;

    //Array of Cities
    String [] cityArray = {"Select City","Dehradun","Delhi"};

    //Towns of Cities
    String [] townDelhi = {"Select Town","Cp" , " Bhajanpura" , "Burari"};
    String [] townDun = {"Select Town","Premnagar" , " Ballupur" , "Nehru Colony"};

    //Universal Towns Array
    String[][] towns = {null,townDun,townDelhi};

    //Landmarks of Towns

    //Dehradun
    String [] landPremNagar = {"Capriko","UIT","UTU"};
    String [] landBallupur = {"A1 TOWER","NETWORK JONE","NEW FLYOVER"};
    String [] landNehru = {"Chnachal","Chowk","Rishpana"};
    String[][] landmarksDun = {null,landPremNagar,landBallupur,landNehru};

    //Delhi
    String[] landmarkCP = {"Nehru Place","Front of Nehru Place","Behind Nehru Place"};
    String[] landmarkBhajanpura = {"Ghonda","Gangotri Vihar","Yamuna Vihar"};
    String[] landmarkBurari = {"Kaushik","Santnagar","Nathupura"};
    String[][] landmarksDelhi = {null,landmarkCP,landmarkBhajanpura,landmarkBurari};
    //Universal array for Landmarks
    String[][][] landMarks = {null,landmarksDun,landmarksDelhi};

    //Zip Codes of cities
    String [] zipDelhi = {"","110053","110006","110054"};
    String [] zipDun = {"","241001","241002","241003"};
    //Universal Array for Zip Codes
    String[][] zipCodes = {null,zipDun,zipDelhi};
    String cityTitle,townTitle,storedLandmark,storedZip;
    String[] errors = new String[10];
    int error_count= 0;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        citySP = (Spinner) findViewById(R.id.citySP);

        ArrayAdapter<String> cityAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,cityArray);
        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySP.setAdapter(cityAdapter);
        citySP.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        if(position != 0)
        {
            final int citypos = position;
            dialogCreation();
            final String[] zips = getZipArray(position);
            final String[] townAr = getTownsArray(position);
            cityTV.setText(cityArray[position]);
            cityTitle = cityArray[position];
            ArrayAdapter<String> townAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,townAr);
            townAdapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);
            townSP.setAdapter(townAdapter);
            townSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    rememberCB.setChecked(false);
                    if(position != 0) {
                        final String[] landmrk = getLandmarksArray(citypos, position);
                        ArrayAdapter landmrkAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.select_dialog_item, landmrk);
                        landmarkACTV.setThreshold(1);
                        landmarkACTV.setAdapter(landmrkAdapter);
                        zipET.setText(zips[position]);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            landmarkACTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rememberCB.setChecked(false);
                }
            });
            zipET.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rememberCB.setChecked(false);
                }
            });

            rememberCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {



                    cityTitle = cityArray[citypos];

                }
            });
            submitBT.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (townSP.getSelectedItemPosition() == 0 && rememberCB.isChecked()) {
                        errors[error_count] = "Town is not Selected!";
                        error_count++;
                    }

                    if(rememberCB.isChecked() && townSP.getSelectedItemPosition() !=0) {
                        cityTitle = cityArray[citypos];

                        townTitle = (String) townSP.getSelectedItem();

                        String[] lm = getLandmarksArray(citypos, townSP.getSelectedItemPosition());
                        if (landmarkACTV.getText().toString().length() > 1) {
                            boolean found = false;
                            for (int i = 0; i < lm.length; i++) {
                                if (landmarkACTV.getText().toString().equalsIgnoreCase(lm[i])) {
                                    found = true;
                                    storedLandmark = lm[i];
                                    break;
                                }
                            }
                            if (found == false) {
                                errors[error_count] = "Entered Landmark is not in list!";
                                error_count++;
                            }
                        } else if (landmarkACTV.getText().toString().length() == 0) {
                            StringBuilder lms = new StringBuilder();
                            for (int i = 0; i < lm.length; i++) {
                                lms.append(lm[i] + "\n");
                            }
                            errors[error_count] = "Landmark is empty! Please select from following : \n" + lms.toString();
                            error_count++;
                        } else {
                            int count = 0;
                            String first = landmarkACTV.getText().toString().toLowerCase();
                            StringBuilder sb = new StringBuilder();
                            for (int i = 0; i < lm.length; i++) {
                                if (lm[i].toLowerCase().startsWith(first)) {
                                    sb.append(lm[i] + "\n");
                                    count++;
                                }
                            }
                            if (count == 1) {
                                sb.deleteCharAt(sb.length() - 1);
                                storedLandmark = sb.toString();
                            } else if (count > 1) {
                                errors[error_count] = "Landmark is not acceptable .Please Select from following : \n" + sb.toString();
                                error_count++;
                            } else {
                                StringBuilder lms = new StringBuilder();
                                for (int i = 0; i < lm.length; i++) {
                                    lms.append(lm[i] + "\n");
                                }
                                errors[error_count] = "Landmark is not acceptable .Please Select from following : \n" + lms.toString();
                                error_count++;
                            }
                        }
                        storedZip = zipET.getText().toString();
                        if (storedZip.equals("")) {
                            errors[error_count] = "Zip code is empty!";
                            error_count++;
                        } else if (!storedZip.equals(zips[townSP.getSelectedItemPosition()])) {
                            errors[error_count] = "Zip code is not valid!";
                            error_count++;
                        }
                    }

                    if(error_count ==0)
                    {
                        Intent in = new Intent(MainActivity.this, com.example.writer.alternatemethod.Target.class);
                        in.putExtra("city", cityTitle);
                        if(rememberCB.isChecked())
                        {

                            in.putExtra("town", townTitle);
                            in.putExtra("zip", storedZip);
                            in.putExtra("landmark", storedLandmark);
                        }
                        startActivity(in);
                    }
                    else
                    {
                        StringBuilder sb =new StringBuilder();

                        sb.append("Please Fix following Errors : \n");
                        for(int i=0;i<error_count;i++)
                        {
                            sb.append(errors[i] + "\n");
                        }
                        error_count =0;
                        Toast.makeText(MainActivity.this,sb.toString(),Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }


    private String[] getZipArray(int cityPos)
    {

        return zipCodes[cityPos];

    }
    private String[] getTownsArray(int cityPos)
    {
        return towns[cityPos];
    }
    private String[] getLandmarksArray(int cityPos,int townPos)
    {
        return landMarks[cityPos][townPos];
    }
    private void dialogCreation()
    {
        //Dialog Creation
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialogbox);

        //DialogItem Initialization
        cityTV = (TextView) dialog.findViewById(R.id.cityTV);
        cityTV.setText(cityTitle);
        townSP = (Spinner) dialog.findViewById(R.id.townSP);
        zipET = (EditText) dialog.findViewById(R.id.zipET);
        landmarkACTV = (AutoCompleteTextView) dialog.findViewById(R.id.landmarkACTV);
        rememberCB = (CheckBox) dialog.findViewById(R.id.rememberCB);
        submitBT = (Button) dialog.findViewById(R.id.submitBt);
        cancelBT = (Button) dialog.findViewById(R.id.cancelBT);
        dialog.show();
        dialog.setCanceledOnTouchOutside(true);

        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {

                count=0;
                citySP.setSelection(0);
            }
        });

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
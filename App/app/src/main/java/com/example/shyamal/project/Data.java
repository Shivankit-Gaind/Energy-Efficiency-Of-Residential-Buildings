package com.example.shyamal.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Data extends AppCompatActivity {

    Button button;
    EditText Relative_compactness,Surface_area,Wall_area,Roof_area,Overall_height,Orientation,Glazing_area,Glazing_area_ditribution;
    double X1,X2,X3,X4,X5,X6,X7,X8,heating,cooling;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        button = (Button)findViewById(R.id.button);
        Relative_compactness = (EditText)findViewById(R.id.editText1);
        Surface_area = (EditText)findViewById(R.id.editText2);
        Wall_area = (EditText)findViewById(R.id.editText3);
        Roof_area = (EditText)findViewById(R.id.editText4);
        Overall_height = (EditText)findViewById(R.id.editText5);
        Orientation = (EditText)findViewById(R.id.editText6);
        Glazing_area = (EditText)findViewById(R.id.editText7);
        Glazing_area_ditribution = (EditText)findViewById(R.id.editText8);

        Relative_compactness.setText("");
        Surface_area.setText("");
        Wall_area.setText("");
        Glazing_area_ditribution.setText("");
        Glazing_area.setText("");
        Orientation.setText("");
        Overall_height.setText("");
        Roof_area.setText("");


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(getApplicationContext(),Final.class);
                if (Relative_compactness.getText().toString().length() <= 0) {
                    Relative_compactness.setError("Enter Relative compactness");
                                 }else if(Surface_area.getText().toString().length() <= 0){
                    Surface_area.setError("Enter Surface area");
                        }else if(Wall_area.getText().toString().length() <= 0){
                    Wall_area.setError("Enter Wall area");
                     }else if(Roof_area.getText().toString().length() <= 0){
                    Roof_area.setError("Enter Roof area");
                     }else if(Overall_height.getText().toString().length() <= 0) {
                    Overall_height.setError("Enter overall height");
                          }else if(Orientation.getText().toString().length() <= 0){
                    Orientation.setError("Enter Orientation");
                      }else if(Glazing_area.getText().toString().length() <= 0){
                    Glazing_area.setError("Enter Glazing area");
                        }else if(Glazing_area_ditribution.getText().toString().length() <= 0){
                    Glazing_area_ditribution.setError("Enter Glazing area distribution");

                }else{
                    X1 = Double.parseDouble(Relative_compactness.getText().toString());
                    X2 = Double.parseDouble(Surface_area.getText().toString());
                    X3 = Double.parseDouble(Wall_area.getText().toString());
                    X4 = Double.parseDouble(Roof_area.getText().toString());
                    X5 = Double.parseDouble(Overall_height.getText().toString());
                    X6 = Double.parseDouble(Orientation.getText().toString());
                    X7 = Double.parseDouble(Glazing_area.getText().toString());
                    X8 = Double.parseDouble(Glazing_area_ditribution.getText().toString());
                    try {
                        URL url = new URL("http://192.168.43.107/ml/"+ Relative_compactness.getText().toString() + "/"  + Surface_area.getText().toString() + "/" +  Wall_area.getText().toString() + "/" + Roof_area.getText().toString() + "/" + Overall_height.getText().toString() + "/" + Orientation.getText().toString() + "/" + Glazing_area.getText().toString() + "/"  + Glazing_area_ditribution.getText().toString() + "/");
                        HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
                        urlConnection.setRequestMethod("GET");
                        int statusCode = urlConnection.getResponseCode();
                        if (statusCode ==  -21) {
                            InputStream it = new BufferedInputStream(urlConnection.getInputStream());
                            InputStreamReader read = new InputStreamReader(it);
                            BufferedReader buff = new BufferedReader(read);
                            StringBuilder dta = new StringBuilder();
                            String chunks ;
                            while((chunks = buff.readLine()) != null)
                            {
                                dta.append(chunks);
                            }
                            String heating = dta.toString();

                            while((chunks = buff.readLine()) != null)
                            {
                                dta.append(chunks);
                            }
                            String cooling = dta.toString();
                        }
                    }catch (Exception e){}

                    String str = String.valueOf(heating) + "  " + String.valueOf(cooling);
                    i2.putExtra("heat",String.valueOf(heating));
                    i2.putExtra("cool",String.valueOf(cooling));
                    Toast.makeText(getApplicationContext(),str,Toast.LENGTH_LONG).show();
                    startActivityForResult(i2,2);}
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 2){
            Relative_compactness.setText("");
            Surface_area.setText("");
            Wall_area.setText("");
            Glazing_area_ditribution.setText("");
            Glazing_area.setText("");
            Orientation.setText("");
            Overall_height.setText("");
            Roof_area.setText("");
        }

    }


}



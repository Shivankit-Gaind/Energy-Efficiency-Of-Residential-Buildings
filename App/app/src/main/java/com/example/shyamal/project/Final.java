package com.example.shyamal.project;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Final extends AppCompatActivity {

    TextView Heating_load,Cooling_load;
    Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        Heating_load = (TextView) findViewById(R.id.textView4);
        Cooling_load = (TextView) findViewById(R.id.textView5);
        exit = (Button)findViewById(R.id.button2);

        Intent in = getIntent();

        String heat = in.getStringExtra("heat");
        String cool = in.getStringExtra("cool");
        cool = cool.substring(0,4);
        Heating_load.setText(heat);
        Cooling_load.setText(cool);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setResult(2);
                finish();
            }
        });







    }
}

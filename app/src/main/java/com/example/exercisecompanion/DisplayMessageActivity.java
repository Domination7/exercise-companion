package com.example.exercisecompanion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;


public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);



        Intent intent = getIntent();
        String message = intent.getStringExtra("EXTRA_MESSAGE");
        String numStars = intent.getStringExtra("NUM_STARS");
        String weightStr = intent.getStringExtra("WEIGHT_VALUE");
        String heightStr = intent.getStringExtra("HEIGHT_VALUE");

        TextView textView = findViewById(R.id.textView);
        TextView textView4 = findViewById(R.id.textView4);
        TextView textView2 = findViewById(R.id.textView2);

        textView.setText("Hi there " + message);
        textView4.setText(numStars);
        textView2.setText("Your BMI is " + calcBmi(weightStr,heightStr));
    }

    public double calcBmi(String weight, String height){
        DecimalFormat oneD = new DecimalFormat("##.##");
        double weightVal = Double.parseDouble(weight);
        double heightVal = Double.parseDouble(height);
        weightVal *= .453592;
        heightVal *= .3048;
        double bmi = Double.valueOf(oneD.format((weightVal/heightVal)/heightVal));
        return bmi;
    }
}

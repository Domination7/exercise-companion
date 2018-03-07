package com.example.exercisecompanion;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;


public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);



        Intent intent = getIntent();
        String message = intent.getStringExtra("EXTRA_MESSAGE");
        //String numStars = intent.getStringExtra("NUM_STARS");
        String weightStr = intent.getStringExtra("WEIGHT_VALUE");
        String heightFtStr = intent.getStringExtra("HEIGHT_VALUE_FT");
        String heightInStr = intent.getStringExtra("HEIGHT_VALUE_IN");

        TextView textView = findViewById(R.id.textView);
        //TextView textView4 = findViewById(R.id.textView4);
        TextView textView2 = findViewById(R.id.textView2);

        textView.setText("Hi there " + message);
        //textView4.setText(numStars);
        textView2.setText("Your BMI is " + calcBmi(weightStr,heightFtStr,heightInStr));
    }

    public double calcBmi(String weight, String heightFt, String heightIn){
        DecimalFormat oneD = new DecimalFormat("##.##");
        double weightVal = Double.parseDouble(weight);
        double heightVal = Double.parseDouble(heightFt) + (Double.parseDouble(heightIn)/12);

        weightVal *= .453592;
        heightVal *= .3048;
        double bmi = Double.valueOf(oneD.format((weightVal/heightVal)/heightVal));

        View underweight = findViewById(R.id.underweight);
        View normal = findViewById(R.id.normal);
        View overweight = findViewById(R.id.overweight);
        View obese = findViewById(R.id.obese);
        View exObese = findViewById(R.id.extremeObese);
        TextView textView3 = findViewById(R.id.textView3);

        if(bmi < 18.5){
            underweight.setBackgroundColor(getResources().getColor(R.color.underweight));
            textView3.setText("Underweight BMI");
            textView3.setTextColor(getResources().getColor(R.color.underweight));
        }
        else if(bmi >= 18.5 && bmi < 25) {
            normal.setBackgroundColor(getResources().getColor(R.color.normal));
            textView3.setText("Healthy BMI");
            textView3.setTextColor(getResources().getColor(R.color.normal));
        }
        else if(bmi >= 25 && bmi < 30) {
            overweight.setBackgroundColor(getResources().getColor(R.color.overweight));
            textView3.setText("Overweight BMI");
            textView3.setTextColor(getResources().getColor(R.color.overweight));
        }
        else if(bmi >= 30 && bmi < 40) {
            obese.setBackgroundColor(getResources().getColor(R.color.obese));
            textView3.setText("Obesity BMI");
            textView3.setTextColor(getResources().getColor(R.color.obese));
        }
        else if(bmi >= 40) {
            exObese.setBackgroundColor(getResources().getColor(R.color.extremeObese));
            textView3.setText("Extreme Obesity BMI");
            textView3.setTextColor(getResources().getColor(R.color.extremeObese));
        }
        return bmi;
    }
}

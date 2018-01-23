package com.example.exercisecompanion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);



        Intent intent = getIntent();
        String message = intent.getStringExtra("EXTRA_MESSAGE");
        String numStars = intent.getStringExtra("NUM_STARS");

        TextView textView = findViewById(R.id.textView);
        TextView textView4 = findViewById(R.id.textView4);
        textView.setText(message);
        textView4.setText(numStars);
    }
}

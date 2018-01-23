package com.example.exercisecompanion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar2);
        String message =  editText.getText().toString();
        String numStars = String.valueOf(ratingBar.getRating());
        intent.putExtra("NUM_STARS",numStars);
        intent.putExtra("EXTRA_MESSAGE",message);
        startActivity(intent);
    }
}
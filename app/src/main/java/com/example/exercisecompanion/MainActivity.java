package com.example.exercisecompanion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);

        EditText editText = findViewById(R.id.editText);
        //RatingBar ratingBar = findViewById(R.id.ratingBar2);
        EditText editText2 = findViewById(R.id.editText2);
        EditText editText3 = findViewById(R.id.editText3);
        EditText editText4 = findViewById(R.id.editText4);

        String message =  editText.getText().toString();
        //String numStars = String.valueOf(ratingBar.getRating());
        String weightStr = editText2.getText().toString();
        String heightFtStr = editText3.getText().toString();
        String heightInStr = editText4.getText().toString();

        //intent.putExtra("NUM_STARS",numStars);
        intent.putExtra("EXTRA_MESSAGE",message);
        intent.putExtra("WEIGHT_VALUE",weightStr);
        intent.putExtra("HEIGHT_VALUE_FT",heightFtStr);
        intent.putExtra("HEIGHT_VALUE_IN",heightInStr);

        startActivity(intent);
    }
}

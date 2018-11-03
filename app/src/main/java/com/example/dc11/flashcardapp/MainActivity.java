package com.example.dc11.flashcardapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Flash Card Question
        findViewById(R.id.flashcardQuestion).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findViewById(R.id.flashcardAnswer).setVisibility(View.VISIBLE);
                findViewById(R.id.flashcardQuestion).setVisibility(View.INVISIBLE);

            }
        });

        // Flash Card Answer
        findViewById(R.id.flashcardAnswer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findViewById(R.id.flashcardAnswer).setVisibility(View.INVISIBLE);
                findViewById(R.id.flashcardQuestion).setVisibility(View.VISIBLE);

            }
        });

        //Go to addCard Activity
        findViewById(R.id.addCardScreen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent to go to the addCard Activity
                // And to retrieve data from activity addCardActivity
                // with the identification number of 100
                Intent intent = new Intent(MainActivity.this, addCardActivity.class);
                MainActivity.this.startActivityForResult(intent, 100);

            }

        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        if (requestCode == 100) { // this 100 needs to match the 100 we used when we called startActivityForResult!
            String strQuestion = data.getExtras().getString("question"); // 'string1' needs to match the key we used when we put the string in the Intent
            String strAnswer = data.getExtras().getString("answer");

            //Change Text View in Main
            ((TextView) findViewById(R.id.flashcardQuestion)).setText(strQuestion);
            ((TextView) findViewById(R.id.flashcardAnswer)).setText(strAnswer);


        }


    }
}
package com.example.dc11.flashcardapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class addCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);




        //Dismissing Activity

        findViewById(R.id.cancelCardScreen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Goes back to Main Activity
                //Does not pass data back to previous Activity
                finish();
            }
        });

        //Go to Main Activity when Save button is pressed
        findViewById(R.id.saveCardScreen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String editQuestion =((EditText)findViewById(R.id.editTextQuestion)).getText().toString();
                final String editAnswer = ((EditText)findViewById(R.id.editTextAnswer)).getText().toString();

                //Intent to pass the data
                //Test
                Intent data = new Intent();
                data.putExtra("question",editQuestion);
                data.putExtra("answer",editAnswer);
                setResult(RESULT_OK,data);
                finish();

            }
        });


    }
}

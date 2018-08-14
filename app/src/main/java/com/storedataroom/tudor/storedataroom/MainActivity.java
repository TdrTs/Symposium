package com.storedataroom.tudor.storedataroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ConcurrentLinkedDeque;

public class MainActivity extends AppCompatActivity {


    DatabaseHelper myDb;
    EditText firstName;
    EditText secondName;
    EditText ageAge;
    Button submitButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       myDb = new DatabaseHelper(this);

       firstName = (EditText) findViewById(R.id.editTextName);
       secondName = (EditText) findViewById(R.id.editTextSecondName);
       ageAge = (EditText) findViewById(R.id.editTextAge);
       submitButton = (Button) findViewById(R.id.buttonSubmit);

       AddData();

    }

    public  void AddData() {

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              boolean isInserted = myDb.insertData(firstName.getText().toString(), secondName.getText().toString(), ageAge.getText().toString());

              if (isInserted == true) {
                  Toast.makeText(MainActivity.this, "Data inserted", Toast.LENGTH_LONG).show();
              } else {
                  Toast.makeText(MainActivity.this, "Data NOT inserted", Toast.LENGTH_LONG).show();
              }
            }
        });

    }



}

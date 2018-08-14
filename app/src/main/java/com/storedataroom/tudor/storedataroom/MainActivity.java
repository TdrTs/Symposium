package com.storedataroom.tudor.storedataroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    DatabaseHelper myDb;
    EditText firstName;
    EditText lastName;
    EditText adress;
    EditText city;
    EditText country;
    Button submitButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       myDb = new DatabaseHelper(this);

       firstName = (EditText) findViewById(R.id.editTextFirstName);
       lastName = (EditText) findViewById(R.id.editTextLastName);
       adress = (EditText) findViewById(R.id.editTextAdress);
       submitButton = (Button) findViewById(R.id.buttonSubmit);
       city = (EditText) findViewById(R.id.editTextCity);
       country = (EditText) findViewById(R.id.editTextCountry);


       AddData();

    }

    public  void AddData() {

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              boolean isInserted = myDb.insertData(firstName.getText().toString(), lastName.getText().toString(), adress.getText().toString(), city.getText().toString(), country.getText().toString());

              if (isInserted == true) {
                  Toast.makeText(MainActivity.this, "Data inserted", Toast.LENGTH_LONG).show();
              } else {
                  Toast.makeText(MainActivity.this, "Data NOT inserted", Toast.LENGTH_LONG).show();
              }
            }
        });

    }



}

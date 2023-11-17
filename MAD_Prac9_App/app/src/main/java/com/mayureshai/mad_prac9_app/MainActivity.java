package com.mayureshai.mad_prac9_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private Button btnSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the reference of EditText and Button
        name = (EditText) findViewById(R.id.editName);
        btnSend = (Button) findViewById(R.id.btnSend);

        // Set a click listener on button
        btnSend.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Send button is clicked on.
            @Override
            public void onClick(View view) {
                // Get the text from EditText and store it in a variable
                String strName = name.getText().toString();
                // check if name is empty?
                if(strName.equals("")){
                    // Display a message to user to enter name
                    Toast.makeText(MainActivity.this, "Please enter name", Toast.LENGTH_SHORT).show();
                    // return statement will not allow the code to execute further
                    return;
                }
                // Create the object of Intent
                Intent intent = new Intent(MainActivity.this, NameActivity.class);
                // Pass the values of EditText to Intent
                intent.putExtra("name", strName);
                // Start the new activity
                startActivity(intent);
            }
        });
    }
}
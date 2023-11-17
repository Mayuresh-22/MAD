package com.mayureshai.mad_prac4_app;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.*;
import android.os.Bundle;

// Registration Form
public class MainActivity extends AppCompatActivity {
    EditText name, email, phone, dob;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Getting the values from the form
        name = findViewById(R.id.editTextText);
        email = findViewById(R.id.editTextTextEmailAddress);
        phone = findViewById(R.id.editTextPhone);
        dob = findViewById(R.id.editTextDate);
        register = findViewById(R.id.button);

        // On click listener for the button
        register.setOnClickListener(v -> {
            // Getting the values from the form
            String nameValue = name.getText().toString();
            String emailValue = email.getText().toString();
            String phoneValue = phone.getText().toString();
            String dobValue = dob.getText().toString();

            // Creating a bundle to pass the values to the next activity
            Bundle bundle = new Bundle();
            bundle.putString("name", nameValue);
            bundle.putString("email", emailValue);
            bundle.putString("phone", phoneValue);
            bundle.putString("dob", dobValue);

            // Creating an intent to start the next activity
            //Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
            //intent.putExtras(bundle);
            //startActivity(intent);

            // Toaster to display the values

            Toast.makeText(this, "Name: " + nameValue +
                    "\nEmail: " + emailValue + "\nPhone: " + phoneValue +
                    "\nDOB: " + dobValue, Toast.LENGTH_LONG).show();
        });
    }
}
package com.mayureshai.mad_prac3_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    EditText email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the reference of the views
        btnLogin = findViewById(R.id.button);
        email = findViewById(R.id.EmailAddress);
        password = findViewById(R.id.Password);

        // Set the onClickListener
        btnLogin.setOnClickListener(v -> {
            // Get the values from the views
            String emailText = email.getText().toString();
            String passwordText = password.getText().toString();

            // Check if the email and password are correct
            if (emailText.equals("admin@gmail.com") && passwordText.equals("admin")) {
                // If correct, show a toast
                Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
            } else {
                // If incorrect, show a toast
                Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
package com.mayureshai.mad_prac9_app;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.os.Bundle;

public class NameActivity extends AppCompatActivity {
    private TextView txtName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        // Get the reference of TextView
        txtName = (TextView) findViewById(R.id.txtName);
        // Get the value of Intent
        String strName = getIntent().getStringExtra("name");
        // Set the value of TextView
        txtName.setText("Welcome " + strName);
    }
}
package com.mayureshai.mad_prac5_app;

import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

// Native Calculator App
public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, clear, add, sub, mul, div, equal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Buttons
        clear = findViewById(R.id.button);
        div = findViewById(R.id.button2);
        mul = findViewById(R.id.button4);
        sub = findViewById(R.id.button22);
        add = findViewById(R.id.button24);
        equal = findViewById(R.id.button23);

        // Numbers
        btn7 = findViewById(R.id.button6);
        btn8 = findViewById(R.id.button7);
        btn9 = findViewById(R.id.button8);
        btn4 = findViewById(R.id.button10);
        btn5 = findViewById(R.id.button11);
        btn6 = findViewById(R.id.button12);
        btn1 = findViewById(R.id.button14);
        btn2 = findViewById(R.id.button15);
        btn3 = findViewById(R.id.button16);
        btn0 = findViewById(R.id.button19);

        // EditText
        final EditText editText = findViewById(R.id.editTextText);

        // Clear Button
        clear.setOnClickListener(v -> editText.setText(""));

        // Numbers
        btn0.setOnClickListener(v -> editText.setText(editText.getText() + "0"));
        btn1.setOnClickListener(v -> editText.setText(editText.getText() + "1"));
        btn2.setOnClickListener(v -> editText.setText(editText.getText() + "2"));
        btn3.setOnClickListener(v -> editText.setText(editText.getText() + "3"));
        btn4.setOnClickListener(v -> editText.setText(editText.getText() + "4"));
        btn5.setOnClickListener(v -> editText.setText(editText.getText() + "5"));
        btn6.setOnClickListener(v -> editText.setText(editText.getText() + "6"));
        btn7.setOnClickListener(v -> editText.setText(editText.getText() + "7"));
        btn8.setOnClickListener(v -> editText.setText(editText.getText() + "8"));
        btn9.setOnClickListener(v -> editText.setText(editText.getText() + "9"));

        // Operators
        add.setOnClickListener(v -> editText.setText(editText.getText() + "+"));
        sub.setOnClickListener(v -> editText.setText(editText.getText() + "-"));
        mul.setOnClickListener(v -> editText.setText(editText.getText() + "*"));
        div.setOnClickListener(v -> editText.setText(editText.getText() + "/"));

        // Equal Button
        equal.setOnClickListener(v -> {
            String str = editText.getText().toString();
            String[] arr = str.split("\\+|-|\\*|/");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            int result = 0;
            if (str.contains("+")) {
                result = a + b;
            } else if (str.contains("-")) {
                result = a - b;
            } else if (str.contains("*")) {
                result = a * b;
            } else if (str.contains("/")) {
                result = a / b;
            }
            editText.setText(String.valueOf(result));
        });

    }
}
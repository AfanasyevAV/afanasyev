package com.example.afanasyev_demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Pattern;

public class enter extends AppCompatActivity {

    Button bCancel, bProceed;
    EditText etFirstName, etLastName, etEmail, etPassword;

    boolean isAllFieldsChecked = false;
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^([a-z1-9]{4,})+[@]+([a-z]{2,})+[.]+([a-z]{2,})$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bProceed = findViewById(R.id.btnEnter);
        bCancel = findViewById(R.id.btnReg);


        etEmail = findViewById(R.id.etMail);
        etPassword = findViewById(R.id.etPass);


        bProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                isAllFieldsChecked = CheckAllFields();

                if (isAllFieldsChecked) {
                    Intent i = new Intent(enter.this, MainActivity.class);
                    startActivity(i);
                }
            }
        });
    }

    private boolean CheckAllFields() {


        String emailToText = etEmail.getText().toString();
        if (!PASSWORD_PATTERN.matcher(emailToText).matches()){
            etEmail.setError("Email is required");
            return false;
        }

        if (etPassword.length() == 0) {
            etPassword.setError("Password is required");
            return false;
        } else if (etPassword.length() < 8) {
            etPassword.setError("Password must be minimum 8 characters");
            return false;
        }

        return true;
    }
}
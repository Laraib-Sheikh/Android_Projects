package com.example.assign_qasf_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        EditText name, email, password;
        Button loginButton, signUpButton;

        //Binding
        name = findViewById(R.id.editTextName);
        email = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);
        signUpButton = findViewById(R.id.buttonSignUp);
        loginButton = findViewById(R.id.buttonSignIn);

        //SharedPrefrences
        SharedPreferences sharedPreferences = getSharedPreferences("credentials", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();


        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameText = name.getText().toString();
                String emailText = email.getText().toString();
                String passwordText = password.getText().toString();

                if(nameText.isEmpty() || emailText.isEmpty() || passwordText.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please fill all the fields!", Toast.LENGTH_LONG).show();
                }else{
                    editor.putString("name", nameText);
                    editor.putString("email", emailText);
                    editor.putString("password", passwordText);
                    editor.apply();

                    Intent i = new Intent(SignupActivity.this, LoginActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}
package com.example.assign_qasf_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView name, email;

        name = findViewById(R.id.textViewUserName);
        email = findViewById(R.id.textViewUserEmail);

        SharedPreferences sharedPreferences = getSharedPreferences("credentials", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String emailStored = sharedPreferences.getString("email", "");
        String nameStored = sharedPreferences.getString("name", "");

        name.setText(emailStored);
        email.setText(nameStored);

        Button logoutButton = findViewById(R.id.buttonLogout);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear login credentials
                editor.putBoolean("isLoggedIn", false);
                editor.apply();

                // Navigate back to Login_activity
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
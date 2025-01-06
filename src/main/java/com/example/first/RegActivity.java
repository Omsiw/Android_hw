package com.example.first;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegActivity extends AppCompatActivity {

    Button signUpBtn;
    EditText editTextNewLogin;
    EditText editTextNewPassword;
    EditText editTextConfirmPassword;

    public static String mainLogin;
    public static String mainPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reg);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        signUpBtn = findViewById(R.id.signUp);
        editTextNewLogin = findViewById(R.id.tvNewLogin);
        editTextNewPassword = findViewById(R.id.tvNewPassword);
        editTextConfirmPassword = findViewById(R.id.tvConfirmPassword);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = editTextNewLogin.getText().toString();
                String password = editTextNewPassword.getText().toString();
                String confirmPassword = editTextConfirmPassword.getText().toString();

                if (login.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
                    Toast.makeText(RegActivity.this, "login or password are empty", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(confirmPassword)) {
                    Toast.makeText(RegActivity.this, "passwords arent same", Toast.LENGTH_SHORT).show();
                } else {
                    mainLogin = login;
                    mainPassword = password;
                    Intent intent = new Intent(RegActivity.this, AuthActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
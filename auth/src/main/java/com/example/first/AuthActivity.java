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

public class AuthActivity extends AppCompatActivity {

    Button signInBtn;
    EditText editTextLogin;
    EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_auth);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        signInBtn = findViewById(R.id.signIn);
        editTextLogin = findViewById(R.id.tvLogin);
        editTextPassword = findViewById(R.id.tvPassword);

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = editTextLogin.getText().toString();
                String password = editTextPassword.getText().toString();

                if (login.isEmpty() || password.isBlank()) {
                    Toast.makeText(AuthActivity.this, "login or password are empty", Toast.LENGTH_SHORT).show();
                } else if (!RegActivity.mainLogin.equals(login) || !RegActivity.mainPassword.equals(password)) {
                    Toast.makeText(AuthActivity.this, "login or password are incorrect", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(AuthActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}
package com.example.radha.loginlogout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class registerActivity extends AppCompatActivity implements View.OnClickListener {
    private Button reg;
    private TextView tvLogin;
    private EditText etEmail, etPass;
    private DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DbHelper(this);
        reg = findViewById(R.id.btnReg);
        tvLogin = findViewById(R.id.tvLogin);
        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);
        reg.setOnClickListener(this);
        tvLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnReg:
                register();
                break;
            case R.id.tvLogin:
                startActivity(new Intent(registerActivity.this, loginactivity.class));
                finish();
                break;
            default:

        }
    }

    private void register() {
        String email = etEmail.getText().toString();
        String pass = etPass.getText().toString();
        if (email.isEmpty() && pass.isEmpty()) {
            displayToast("Username/password field empty");
        } else {
            db.addUser(email, pass);
            displayToast("User registered");
            finish();
        }
    }

    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
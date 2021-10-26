package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    private SharedPreferences.Editor editor;
    private TextInputLayout lyUsername, lyPsw;
    private TextInputEditText username, psw;
    private String strUsername, strPsw;
    private CheckBox remember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPreferences preferences = getSharedPreferences("data", MODE_PRIVATE);
        editor = preferences.edit();

        lyUsername = findViewById(R.id.ly_username);
        lyPsw = findViewById(R.id.ly_psw);

        username = findViewById(R.id.edt_username);
        psw = findViewById(R.id.edt_psw);

        remember = findViewById(R.id.cb_remember);
    }

    private void getData() {
        strUsername = Objects.requireNonNull(username.getText()).toString();
        strPsw = Objects.requireNonNull(psw.getText()).toString();
    }

    private void logOn() {
        if (remember.isChecked()) {
            editor.putBoolean("status", true);
            editor.apply();
        }
        startActivity(new Intent(this, HomeActivity.class));
    }

    private void validator() {
        getData();

        if (strUsername.isEmpty()) {
            lyUsername.setErrorEnabled(true);
            lyUsername.setError("The username is obligatory!");
        } else {
            lyUsername.setErrorEnabled(false);
            lyUsername.setError(null);
        }

        if (strPsw.isEmpty()) {
            lyPsw.setErrorEnabled(true);
            lyPsw.setError("The password is obligatory!");
        } else {
            lyPsw.setErrorEnabled(false);
            lyPsw.setError(null);
        }

        if (lyUsername.getError() == null && lyPsw.getError() == null) logOn();
    }
}
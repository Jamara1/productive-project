package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

@SuppressLint("CustomSplashScreen")
public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences preferences = getSharedPreferences(getString(R.string.key), MODE_PRIVATE);

        try {
            Thread.sleep(2000);
            if (preferences.getBoolean(getString(R.string.key_login), false)) {
                startActivity(new Intent(this, HomeActivity.class));
                super.finish();
            } else {
                startActivity(new Intent(this, LoginActivity.class));
                super.finish();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
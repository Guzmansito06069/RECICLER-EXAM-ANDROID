package com.example.examenrecycler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new CountDownTimer(1000, 10000) {
            @Override
            public void onTick(long l) {
            }

            @Override
            public void onFinish() { startActivity(new Intent(splash.this, MainActivity.class)); }
        }.start();
    }
}
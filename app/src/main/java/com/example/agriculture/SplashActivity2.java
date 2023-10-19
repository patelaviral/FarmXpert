package com.example.agriculture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);

        Intent spl = new Intent(SplashActivity2.this, login_Activity2.class);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(spl);
                finish();
            }
        },4000);
    }
}
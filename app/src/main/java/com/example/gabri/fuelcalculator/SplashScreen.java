package com.example.gabri.fuelcalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen2);

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                showMain();
            }
        }, 2000);
    }

    private void showMain(){
        Intent intent = new Intent(SplashScreen.this,
                MainActivity.class);
        startActivity(intent);
        finish();
    }
    }


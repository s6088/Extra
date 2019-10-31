package com.tamannatabassum.extra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {

                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
                Intent welcomeIntent = new Intent(SplashActivity.this, WelcomeActivity.class);
                Intent homeIntent = new Intent(SplashActivity.this, HomeActivity.class);
                boolean welcome = pref.getBoolean("welcome", false);

                if(welcome)startActivity(homeIntent);
                else startActivity(welcomeIntent);

                finish();
            }
        }, 3000);
    }
}

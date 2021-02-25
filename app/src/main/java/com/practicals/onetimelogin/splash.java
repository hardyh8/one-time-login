package com.practicals.onetimelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class splash extends AppCompatActivity {

    public static final int TIME_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splash.this,MainActivity.class);
                splash.this.startActivity(intent);
                splash.this.finish();
            }
        },TIME_LENGTH);
    }
}

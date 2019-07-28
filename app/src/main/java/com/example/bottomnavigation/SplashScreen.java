package com.example.bottomnavigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import static java.lang.Thread.sleep;

public class SplashScreen extends AppCompatActivity {
    ProgressBar progressBar;
    Thread thread;
    private int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        progressBar = findViewById(R.id.progressBar);

        thread = new Thread() {
            @Override
            public void run() {

                try {
                    while (index < 100) {
                        progressBar.setProgress(index);
                        sleep(50);
                        index++;
                    }
                } catch (Exception e) {
                } finally {
                    Intent intent = new Intent(SplashScreen.this, MainNavActivity.class);
                    startActivity(intent);
                    SplashScreen.this.finish();
                }
            }
        };
        thread.start();
    }
    }



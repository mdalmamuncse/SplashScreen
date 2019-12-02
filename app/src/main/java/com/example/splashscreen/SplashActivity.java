package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private int progressing;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //full screen activity
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        progressBar = findViewById(R.id.progressBarId);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                startApp();

            }
        });
        thread.start();
    }



    private void doWork() {

        for (progressing = 20;progressing<=100;progressing+=20){
            try {
                Thread.sleep(1000);
                progressBar.setProgress(progressing);
            }catch (Exception e){

            }
        }

    }
    private void startApp() {
        Intent intent = new Intent(SplashActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}

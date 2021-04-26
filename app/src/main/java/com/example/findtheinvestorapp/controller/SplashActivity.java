package com.example.findtheinvestorapp.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.findtheinvestorapp.R;
import com.example.findtheinvestorapp.controller.MainActivity;

public class SplashActivity extends AppCompatActivity {

    ImageView logo, appName,spalshImg;
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_splash );

        logo = findViewById ( R.id.logo );
        appName = findViewById ( R.id.appName );
        spalshImg = findViewById ( R.id.img );
        lottieAnimationView = findViewById ( R.id.lottie );

        spalshImg.animate ().translationY ( -1600 ).setDuration ( 1000 ).setStartDelay ( 4000 );
        logo.animate ().translationY ( 1400 ).setDuration ( 1000 ).setStartDelay ( 4000 );
        appName.animate ().translationY ( 1400 ).setDuration ( 1000 ).setStartDelay ( 4000 );
        lottieAnimationView.animate ().translationY ( 1400 ).setDuration ( 1000 ).setStartDelay ( 4000 );


        new Thread ( new Runnable ( ) {
            @Override
            public void run ( ) {
                try {
                    Thread.sleep ( 4000 );

                }catch (InterruptedException e){
                    e.printStackTrace ();
                }
                Intent intent = new Intent ( getApplicationContext (), MainActivity.class );
                startActivity ( intent );
                finish();

            }

        } ).start ();

    }

}
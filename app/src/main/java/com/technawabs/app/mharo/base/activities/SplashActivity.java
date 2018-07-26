package com.technawabs.app.mharo.base.activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

import com.technawabs.app.mharo.R;
import com.technawabs.app.mharo.base.scanner.LivePreviewActivity;

public class SplashActivity extends AppCompatActivity {

    private VideoView v ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if(this.getSupportActionBar()!=null){
            this.getSupportActionBar().hide();
        }

        v = findViewById(R.id.videoView);
        Uri ur = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.intro);
        v.setVideoURI(ur);
        v.start();

        //To run video in loop
        v.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

    }

    public void createAccount(View vw)
    {
//        this.makeText(getBaseContext(),"Clicked", Toast.LENGTH_SHORT).show();

//        Intent myIntent = new Intent(SplashActivity.this, LivePreviewActivity.class);
        Intent myIntent = new Intent(SplashActivity.this, DashboardActivity.class);
        startActivity(myIntent);
    }

}

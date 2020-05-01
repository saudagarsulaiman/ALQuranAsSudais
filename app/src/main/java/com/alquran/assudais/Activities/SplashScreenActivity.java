package com.alquran.assudais.Activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.alquran.assudais.R;
import com.alquran.assudais.Utilities.MyApplication;

public class SplashScreenActivity extends AppCompatActivity {

/*
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

/*
        sharedPreferences = getSharedPreferences(getResources().getString(R.string.app_name), MODE_PRIVATE);
        editor = sharedPreferences.edit();
*/
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.salaam);

        if (/*sharedPreferences.getBoolean(CommonUtilities.SALAAMSOUND, true)*/MyApplication.isSALAAMSOUND()) {
            mediaPlayer.start();
        }

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    Intent intent = new Intent(SplashScreenActivity.this, DashboardActivity.class);
                    startActivity(intent);
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                        mediaPlayer.release();
                    }
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 3000);
    }
}

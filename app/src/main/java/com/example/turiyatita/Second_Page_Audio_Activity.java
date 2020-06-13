package com.example.turiyatita;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Second_Page_Audio_Activity extends AppCompatActivity {
    RelativeLayout relativeLayout;
    static MediaPlayer player = null;
    static boolean isplaying = false;
        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second__page__audio);

        relativeLayout = (RelativeLayout) findViewById(R.id.audio_activity_Layout);

        relativeLayout.setOnTouchListener(new OnSwipeTouchListener(this) {
            public void onSwipeTop() {
                Toast.makeText(getApplicationContext(), "top", Toast.LENGTH_SHORT).show();
            }

            public void onSwipeRight() {
                Toast.makeText(getApplicationContext(), "right", Toast.LENGTH_SHORT).show();
                stopPlayer();
                finish();
            }

            public void onSwipeLeft() {
                Toast.makeText(getApplicationContext(), "left", Toast.LENGTH_SHORT).show();
            }

            public void onSwipeBottom() {
                Toast.makeText(getApplicationContext(), "bottom", Toast.LENGTH_SHORT).show();
            }

        });
    }

        public void play (View v){
        play();
    }
        private void play () {
        if (player == null) {
            player = MediaPlayer.create(this, R.raw.ringtone);
            player.setLooping(true);
        }
        player.start();
    }
        public void pause (View v){
        if (player != null) {
            player.pause();
        }
    }
        public void stop (View v){

        stopPlayer();
    }
        private void stopPlayer () {
        if (player != null) {
            player.release();
            player = null;
            Toast.makeText(this, "MediaPlayer released", Toast.LENGTH_SHORT).show();
        }
    }

        @Override
        protected void onPause () {
        super.onPause();
        if (player != null && player.isPlaying()) {
            player.pause();
            isplaying = true;
        }
    }

        protected void onResume () {
        super.onResume();
        if (isplaying) {
            play();
            isplaying = false;
        }
    }
        @Override
        protected void onRestart () {
        super.onRestart();
        if (isplaying) {
            play();
            isplaying = false;
        }
    }

    public void onBackPressed() {
        stopPlayer();
        finish();
    }
}
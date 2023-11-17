package com.mayureshai.mad_prac6_app;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.widget.*;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Button btnPlay;
    private SeekBar seekBar;
    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay = findViewById(R.id.btnPlay);
        seekBar = findViewById(R.id.seekBar);
        mediaPlayer = MediaPlayer.create(this, R.raw.tuhaikahan);
        if(!mediaPlayer.isPlaying()){
            mediaPlayer.start();
            btnPlay.setText("Pause");
        }

        // seekBar setup
        seekBar.setMax(mediaPlayer.getDuration());
        new Thread(() -> {
            while (mediaPlayer != null) {
                try {
                    if (mediaPlayer.isPlaying()) {
                        runOnUiThread(() -> {
                            seekBar.setProgress(mediaPlayer.getCurrentPosition());
                        });
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // seekBar change listener
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int pos, boolean b) {
                if (b) {
                    mediaPlayer.seekTo(pos);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                mediaPlayer.pause();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.start();
            }
        });

        // Play/Pause button setup
        btnPlay.setOnClickListener(v -> {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                btnPlay.setText("Play");
            } else {
                mediaPlayer.start();
                btnPlay.setText("Pause");
            }
        });

    }
}
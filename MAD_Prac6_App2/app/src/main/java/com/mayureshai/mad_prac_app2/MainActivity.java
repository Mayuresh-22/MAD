package com.mayureshai.mad_prac_app2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.*;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private SurfaceView videoPlayer;
    private Button btnPlay;
    private SeekBar seekBar;
    private SurfaceHolder surfaceHolder;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the variables
        videoPlayer = findViewById(R.id.videoPlayer);
        btnPlay = findViewById(R.id.btnPlay);
        surfaceHolder = videoPlayer.getHolder();
        seekBar = findViewById(R.id.seekBar);

        // Add a callback to the surface holder
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                // Initialize the media player
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.cs50);
                mediaPlayer.setDisplay(surfaceHolder);
                mediaPlayer.setLooping(true);
                mediaPlayer.start();
                btnPlay.setText("Pause");

                // Set the seek bar max to the media player duration
                seekBar.setMax(mediaPlayer.getDuration());

                // Create a thread to update position of seek bar
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        try {
                            while (mediaPlayer != null) {
                                // Get the current position of the media player
                                int currentPosition = mediaPlayer.getCurrentPosition();
                                // Set the current position of the seek bar
                                seekBar.setProgress(currentPosition);
                                // Sleep for 1 second
                                sleep(1000);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                // Start the thread
                thread.start();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                // Empty
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                // Empty
            }
        });

        // Add a change listener to the seek bar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
           @Override
           public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
               if (fromUser){
                   mediaPlayer.seekTo(progress);
               }
           }

           @Override
           public void onStartTrackingTouch(SeekBar seekBar) {

           }

           @Override
           public void onStopTrackingTouch(SeekBar seekBar) {

           }
       });

        // Add a click listener to the play button
        btnPlay.setOnClickListener(v -> {
            if (mediaPlayer.isPlaying()) {
                // If media player is playing, pause it
                mediaPlayer.pause();
                btnPlay.setText("Play");
            } else {
                // Otherwise, play it
                mediaPlayer.start();
                btnPlay.setText("Pause");
            }
        });
    }

    // Release the media player when the activity is destroyed
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }

    // on pause
    @Override
    protected void onPause() {
        super.onPause();
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }

    // on resume
    @Override
    protected void onResume() {
        super.onResume();
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }
}
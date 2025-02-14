package com.example.mediaplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class VideoActivity extends AppCompatActivity {
    MediaPlayer mPlayer;

    VideoView videoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_video);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        mPlayer = MediaPlayer.create(this, R.raw.givemeatank_logic);

        videoPlayer = findViewById(R.id.videoPlayer);
        Uri myVideoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);
        videoPlayer.setVideoURI(myVideoUri);
    }

    public void play1(View view){
        videoPlayer.start();
    }
    public void pause1(View view){
        videoPlayer.pause();
    }
    public void stop1(View view){
        videoPlayer.stopPlayback();
        videoPlayer.resume();
    }

    public void back(View view){
        Intent intent = new Intent(VideoActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
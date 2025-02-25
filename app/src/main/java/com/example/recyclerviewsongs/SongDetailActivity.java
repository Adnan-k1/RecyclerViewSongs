package com.example.recyclerviewsongs;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SongDetailActivity extends AppCompatActivity {
    private ImageView ivAlbum;
    private TextView tvTitle, tvArtist, tvMeaning;
    private Button btnPlayPause;
    private MediaPlayer mediaPlayer;
    private boolean isPlaying = false;
    private int audioResource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_detail);

        ivAlbum = findViewById(R.id.ivAlbumDetail);
        tvTitle = findViewById(R.id.tvTitleDetail);
        tvArtist = findViewById(R.id.tvArtistDetail);
        tvMeaning = findViewById(R.id.tvMeaning);
        btnPlayPause = findViewById(R.id.btnPlayPause);

        Intent intent = getIntent();
        if (intent != null) {
            String title = intent.getStringExtra("title");
            String artist = intent.getStringExtra("artist");
            int imageResource = intent.getIntExtra("imageResource", 0);
            String meaning = intent.getStringExtra("meaning");
            audioResource = intent.getIntExtra("audioResource", 0);

            ivAlbum.setImageResource(imageResource);
            tvTitle.setText(title);
            tvArtist.setText(artist);
            tvMeaning.setText(meaning);

            if (audioResource != 0) {
                initializeMediaPlayer();
            } else {
                btnPlayPause.setEnabled(false);
                Toast.makeText(this, "Audio tidak tersedia", Toast.LENGTH_SHORT).show();
            }
        }

        btnPlayPause.setOnClickListener(view -> togglePlayback());
    }

    private void initializeMediaPlayer() {
        if (mediaPlayer == null && audioResource != 0) {
            mediaPlayer = MediaPlayer.create(this, audioResource);
            if (mediaPlayer == null) {
                btnPlayPause.setEnabled(false);
                Toast.makeText(this, "Gagal memuat audio", Toast.LENGTH_SHORT).show();
                return;
            }
            mediaPlayer.setOnCompletionListener(mp -> {
                btnPlayPause.setText("Play");
                isPlaying = false;
            });
        }
    }

    private void togglePlayback() {
        if (mediaPlayer == null) {
            initializeMediaPlayer();
        }

        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                btnPlayPause.setText("Play");
            } else {
                mediaPlayer.start();
                btnPlayPause.setText("Pause");
            }
            isPlaying = !isPlaying;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            btnPlayPause.setText("Play");
            isPlaying = false;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}

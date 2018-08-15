package com.gmail.kol.c.arindam.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongPlayerActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<SongDetail> songsToPlay;
    private int nowPlaying;
    private boolean isPlaying;
    ImageView songPlayingImage;
    TextView songPlayingName;
    TextView songPlayingArtist;
    ImageButton prevButton, playButton, nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_player);

        Intent intent = getIntent();

        nowPlaying = intent.getIntExtra("Position",0);
        songsToPlay = intent.getParcelableArrayListExtra("List");

        songPlayingImage = findViewById(R.id.song_player_image);
        songPlayingName = findViewById(R.id.song_player_name);
        songPlayingArtist =findViewById(R.id.song_player_artist);
        prevButton = findViewById(R.id.prev_button);
        playButton = findViewById(R.id.play_button);
        nextButton = findViewById(R.id.next_button);

        showSongDetails();

        prevButton.setOnClickListener(this);
        playButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.prev_button :
                if(nowPlaying>0)
                    nowPlaying--;
                else
                    nowPlaying=songsToPlay.size()-1;
                showSongDetails();
                break;
            case R.id.play_button :
                if(!isPlaying) {
                    playButton.setImageResource(R.drawable.baseline_pause_black_36);
                    isPlaying = true;
                } else {
                    playButton.setImageResource(R.drawable.baseline_play_arrow_black_36);
                    isPlaying = false;
                }
                break;
            case R.id.next_button :
                if(nowPlaying<(songsToPlay.size()-1))
                    nowPlaying++;
                else
                    nowPlaying=0;
                showSongDetails();
                break;
            default: break;
        }

    }

    public void showSongDetails () {
        songPlayingImage.setImageResource(songsToPlay.get(nowPlaying).getSongImageID());
        songPlayingName.setText(getString(R.string.show_name,songsToPlay.get(nowPlaying).getSongName()));
        songPlayingArtist.setText(getString(R.string.show_artist,songsToPlay.get(nowPlaying).getSongArtist()));
        playButton.setImageResource(R.drawable.baseline_play_arrow_black_36);
        isPlaying = false;
    }
}
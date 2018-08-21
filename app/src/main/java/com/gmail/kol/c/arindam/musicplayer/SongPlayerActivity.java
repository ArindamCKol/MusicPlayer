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

    static final String STATE_NOW_PLAYIG = "song_now_playing";
    static final String STATE_PLAY = "is_song_playing";

    private ArrayList<SongDetail> songsToPlay;
    private int nowPlaying;
    private boolean isPlaying;
    ImageView songPlayingImage;
    TextView songPlayingName, songPlayingArtist, songPlayerDuration, songPlayerURL;
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
        songPlayerDuration = findViewById(R.id.song_player_duration);
        songPlayerURL = findViewById(R.id.song_player_url);
        prevButton = findViewById(R.id.prev_button);
        playButton = findViewById(R.id.play_button);
        nextButton = findViewById(R.id.next_button);

        if(savedInstanceState!=null) {
            nowPlaying = savedInstanceState.getInt(STATE_NOW_PLAYIG);
            isPlaying = savedInstanceState.getBoolean(STATE_PLAY);
        }

        setTitle(R.string.player);
        showSongDetails();

        prevButton.setOnClickListener(this);
        playButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_NOW_PLAYIG,nowPlaying);
        outState.putBoolean(STATE_PLAY,isPlaying);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.prev_button :
                if(nowPlaying>0)
                    nowPlaying--;
                else
                    nowPlaying=songsToPlay.size()-1;
                isPlaying=false;
                showSongDetails();
                break;
            case R.id.play_button :
                if(isPlaying) {
                    pauseMusic();
                } else {
                    playMusic();
                }
                break;
            case R.id.next_button :
                if(nowPlaying<(songsToPlay.size()-1))
                    nowPlaying++;
                else
                    nowPlaying=0;
                isPlaying=false;
                showSongDetails();
                break;
            default: break;
        }

    }

    public void showSongDetails () {
        songPlayingImage.setImageResource(songsToPlay.get(nowPlaying).getSongImageID());
        songPlayingName.setText(getString(R.string.show_name,songsToPlay.get(nowPlaying).getSongName()));
        songPlayingArtist.setText(getString(R.string.show_artist,songsToPlay.get(nowPlaying).getSongArtist()));
        songPlayerDuration.setText(getString(R.string.show_duration,songsToPlay.get(nowPlaying).getSongDuration()));
        songPlayerURL.setText(getString(R.string.show_url,songsToPlay.get(nowPlaying).getSongURL()));
        if(isPlaying) {
            playMusic();
        } else {
            pauseMusic();
        }
    }

    public void playMusic() {
        playButton.setImageResource(R.drawable.baseline_pause_black_36);
        isPlaying = true;
    }

    public void pauseMusic() {
        playButton.setImageResource(R.drawable.baseline_play_arrow_black_36);
        isPlaying = false;
    }
}

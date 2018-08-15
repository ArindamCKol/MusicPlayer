package com.gmail.kol.c.arindam.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class SongListActivity extends AppCompatActivity {

    ListView songListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        Intent intent = getIntent();

        final ArrayList<SongDetail> currentSongs;
        currentSongs = intent.getParcelableArrayListExtra("List");
        setTitle(currentSongs.get(0).getSongGenre());

        songListView = findViewById(R.id.song_list_view);
        SongListAdapter adapter = new SongListAdapter(this,R.layout.song_card,currentSongs);
        songListView.setAdapter(adapter);

        songListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent songPlayerIntent = new Intent(SongListActivity.this, SongPlayerActivity.class);

                songPlayerIntent.putExtra("Position",i);
                songPlayerIntent.putParcelableArrayListExtra("List",currentSongs);
                startActivity(songPlayerIntent);
            }
        });
    }
}

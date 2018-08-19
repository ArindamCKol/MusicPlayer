package com.gmail.kol.c.arindam.musicplayer;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList <GenreDetails> genreList = new ArrayList<>();
    private GridView genreGrid;
    private ArrayList <SongDetail> songList = new ArrayList<>();
    private ArrayList <SongDetail> selectedSong = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadGenre();
        loadSong();

        genreGrid = findViewById(R.id.genre_grid_view);
        GenreAdapter adapter = new GenreAdapter(this,R.layout.genre_card,genreList);
        genreGrid.setAdapter(adapter);

        genreGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent songListIntent = new Intent(MainActivity.this, SongListActivity.class);

                selectedSong = selectSongByGenre(genreList.get(i).getGenreName());
                songListIntent.putParcelableArrayListExtra("List",selectedSong);
                startActivity(songListIntent);
            }
        });
    }

    public void loadGenre() {
        Resources res = getResources();
        String [] genreNameList = res.getStringArray(R.array.genre_name);
        TypedArray genreImageList = res.obtainTypedArray(R.array.genre_image);

        for (int i=0; i<genreNameList.length; i++) {
            GenreDetails temp = new GenreDetails(genreNameList[i],genreImageList.getResourceId(i,R.drawable.ic_launcher_background));
            genreList.add(temp);
        }
        genreImageList.recycle();
    }

    public void loadSong () {
        Resources res = getResources();
        String [] songNameList = res.getStringArray(R.array.song_name);
        String [] songArtistList = res.getStringArray(R.array.song_artist);
        TypedArray songImageList = res.obtainTypedArray(R.array.song_image_id);
        String [] songDurationList = res.getStringArray(R.array.song_duration);
        String [] songURLList = res.getStringArray(R.array.song_url);

        int genrePosition = 0;

        for (int i=0; i<songNameList.length; i++) {
            if(i>0 && ((i%10) == 0)) {genrePosition++;}
            SongDetail temp = new SongDetail(songNameList[i], songArtistList[i],songImageList.getResourceId(i,R.drawable.ic_launcher_background), songDurationList[i],songURLList[i], genreList.get(genrePosition).getGenreName());
            songList.add(temp);
        }
        songImageList.recycle();
    }

    public ArrayList<SongDetail> selectSongByGenre(String genre) {
        ArrayList <SongDetail> temp = new ArrayList<>();

        for(int i=0; i<songList.size(); i++) {
            if(songList.get(i).getSongGenre().equals(genre)) {
                temp.add(songList.get(i));
            }
        }
        return temp;
    }
}

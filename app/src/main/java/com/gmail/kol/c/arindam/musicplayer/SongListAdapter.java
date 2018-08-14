package com.gmail.kol.c.arindam.musicplayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SongListAdapter extends ArrayAdapter {

    ArrayList<SongDetail> songList = new ArrayList<>();


    public SongListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<SongDetail> objects) {
        super(context, resource, objects);
        songList=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.song_card,null);
        ImageView songImage = view.findViewById(R.id.song_image);
        TextView songName = view.findViewById(R.id.song_name);
        TextView songArtist = view.findViewById(R.id.song_artist);

        songImage.setImageResource(songList.get(position).getSongImageID());
        songName.setText(songList.get(position).getSongName());
        songArtist.setText(songList.get(position).getSongArtist());
        return view;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }
}

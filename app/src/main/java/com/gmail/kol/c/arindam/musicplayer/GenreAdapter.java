package com.gmail.kol.c.arindam.musicplayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GenreAdapter extends ArrayAdapter {

    ArrayList<GenreDetails> genreList = new ArrayList<>();

    public GenreAdapter(@NonNull Context context, int resource, @NonNull ArrayList<GenreDetails> objects) {
        super(context, resource, objects);
        genreList = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.genre_card,null);
        ImageView genreImageView = view.findViewById(R.id.genre_image_view);
        TextView genreTextView = view.findViewById(R.id.genre_text_view);

        genreImageView.setImageResource(genreList.get(position).getGenreImageID());
        genreTextView.setText(genreList.get(position).getGenreName());

        return view;
    }
}

package com.gmail.kol.c.arindam.musicplayer;

public class GenreDetails {
    private String genreName;
    private int genreImageID;

    GenreDetails(String genreName, int genreImageID) {
        this.genreName = genreName;
        this.genreImageID = genreImageID;
    }

    public String getGenreName() {
        return genreName;
    }

    public int getGenreImageID() {
        return genreImageID;
    }
}

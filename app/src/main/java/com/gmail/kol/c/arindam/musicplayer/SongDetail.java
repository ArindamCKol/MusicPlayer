package com.gmail.kol.c.arindam.musicplayer;

public class SongDetail {
    private String songName;
    private String songArtist;
    private int songImageID;

    SongDetail(String songName, String songArtist, int songImageID) {
        this.songName = songName;
        this.songArtist = songArtist;
        this.songImageID = songImageID;
    }

    public String getSongName() {
        return songName;
    }

    public String getSongArtist() {
        return songArtist;
    }

    public int getSongImageID() {
        return songImageID;
    }
}

package com.gmail.kol.c.arindam.musicplayer;

import android.os.Parcel;
import android.os.Parcelable;

public class SongDetail implements Parcelable {
    private String songName;
    private String songArtist;
    private int songImageID;
    private String songURL;
    private String songDuration;
    private String songGenre;

    SongDetail(String songName, String songArtist, int songImageID, String songDuration, String songURL, String songGenre) {
        this.songName = songName;
        this.songArtist = songArtist;
        this.songImageID = songImageID;
        this.songDuration = songDuration;
        this.songURL = songURL;
        this.songGenre = songGenre;
    }

    protected SongDetail(Parcel in) {
        songName = in.readString();
        songArtist = in.readString();
        songImageID = in.readInt();
        songDuration = in.readString();
        songURL = in.readString();
        songGenre = in.readString();
    }

    public static final Creator<SongDetail> CREATOR = new Creator<SongDetail>() {
        @Override
        public SongDetail createFromParcel(Parcel in) {
            return new SongDetail(in);
        }

        @Override
        public SongDetail[] newArray(int size) {
            return new SongDetail[size];
        }
    };

    public String getSongName() {
        return songName;
    }

    public String getSongArtist() {
        return songArtist;
    }

    public int getSongImageID() {
        return songImageID;
    }

    public String getSongDuration() {
        return songDuration;
    }

    public String getSongURL () {
        return songURL;
    }

    public String getSongGenre() {
        return songGenre;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(songName);
        parcel.writeString(songArtist);
        parcel.writeInt(songImageID);
        parcel.writeString(songDuration);
        parcel.writeString(songURL);
        parcel.writeString(songGenre);
    }
}

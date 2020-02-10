package com.rebornsolutions.megyemix.Utils.Entities;


import android.os.Parcel;
import android.os.Parcelable;

public class TipgameScore implements Parcelable {

    private String location;
    private String date;
    private Tipgame tipgame;

    public TipgameScore(String location, String date) {
        this.location = location;
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public Tipgame getTipgame(){
        return tipgame;
    }

    public void setTipgame(Tipgame tipgame) {
        this.tipgame = tipgame;
    }

    protected TipgameScore(Parcel in) {
        location = in.readString();
        date = in.readString();
    }

    public static final Creator<TipgameScore> CREATOR = new Creator<TipgameScore>() {
        @Override
        public TipgameScore createFromParcel(Parcel in) {
            return new TipgameScore(in);
        }

        @Override
        public TipgameScore[] newArray(int size) {
            return new TipgameScore[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(location);
        dest.writeString(date);
    }

}
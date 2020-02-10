package com.rebornsolutions.megyemix.Utils.Entities;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.Comparator;

public class PlayerScore implements Parcelable {

    private int points;
    private int all_tips;
    private int correct;
    private int incorrect;
    private int all_completed_missions;

    public PlayerScore( int points, int all_tips, int correct, int incorrect, int all_completed_missions) {
        this.points = points;
        this.all_tips = all_tips;
        this.correct = correct;
        this.incorrect = incorrect;
        this.all_completed_missions = all_completed_missions;
    }


    public int getAll_tips() {
        return all_tips;
    }

    public int getCorrect() {
        return correct;
    }

    public int getIncorrect() {
        return incorrect;
    }

    public int getAll_completed_missions() {
        return all_completed_missions;
    }


    protected PlayerScore(Parcel in) {
        points = in.readInt();
        all_tips = in.readInt();
        correct = in.readInt();
        incorrect = in.readInt();
        all_completed_missions = in.readInt();
    }

    public static final Creator<PlayerScore> CREATOR = new Creator<PlayerScore>() {
        @Override
        public PlayerScore createFromParcel(Parcel in) {
            return new PlayerScore(in);
        }

        @Override
        public PlayerScore[] newArray(int size) {
            return new PlayerScore[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(String.valueOf(all_tips));
        dest.writeString(String.valueOf(correct));
        dest.writeString(String.valueOf(incorrect));
        dest.writeString(String.valueOf(all_completed_missions));
    }

    @Override
    public String toString() {
        return String.valueOf(points);
    }
}
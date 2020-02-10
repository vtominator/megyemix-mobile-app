package com.rebornsolutions.megyemix.Utils.Entities;


import android.os.Parcel;
import android.os.Parcelable;

public class TeamScore implements Parcelable {

    private int points;
    private int all_matches;
    private int wins;
    private int draws;
    private int loses;
    private int goals_for;
    private int goals_against;
    private int goal_difference;

    public TeamScore(int points, int all_matches, int wins, int draws, int loses, int goals_for, int goals_against, int goal_difference) {
        this.points = points;
        this.all_matches = all_matches;
        this.wins = wins;
        this.draws = draws;
        this.loses = loses;
        this.goals_for = goals_for;
        this.goals_against = goals_against;
        this.goal_difference = goal_difference;
    }

    public int getAll_matches() {
        return all_matches;
    }

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getLoses() {
        return loses;
    }

    public int getGoals_for() {
        return goals_for;
    }

    public int getGoals_against() {
        return goals_against;
    }

    public int getGoal_difference() {
        return goal_difference;
    }

    protected TeamScore(Parcel in) {
        points = in.readInt();
        all_matches = in.readInt();
        wins = in.readInt();
        draws = in.readInt();
        loses = in.readInt();
        goals_for = in.readInt();
        goals_against = in.readInt();
        goal_difference = in.readInt();
    }

    public static final Creator<TeamScore> CREATOR = new Creator<TeamScore>() {
        @Override
        public TeamScore createFromParcel(Parcel in) {
            return new TeamScore(in);
        }

        @Override
        public TeamScore[] newArray(int size) {
            return new TeamScore[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(String.valueOf(all_matches));
        dest.writeString(String.valueOf(wins));
        dest.writeString(String.valueOf(draws));
        dest.writeString(String.valueOf(loses));
        dest.writeString(String.valueOf(goals_for));
        dest.writeString(String.valueOf(goals_against));
        dest.writeString(String.valueOf(goal_difference));
    }

    @Override
    public String toString() {
        return String.valueOf(points);
    }
}
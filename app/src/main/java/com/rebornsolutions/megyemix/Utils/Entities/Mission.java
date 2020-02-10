package com.rebornsolutions.megyemix.Utils.Entities;


public class Mission {
    private int logo;
    private String missionName;
    private String short_description;
    private String long_description;
    private String fromDate;
    private String toDate;
    private int points;
    private int correct;


    public Mission(int logo, String missionName, String short_description, String long_description, String fromDate, String toDate, int points) {
        this.logo = logo;
        this.missionName = missionName;
        this.short_description = short_description;
        this.long_description = long_description;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.points = points;
    }

    public int getLogo() {
        return logo;
    }

    public String getMissionName() {
        return missionName;
    }

    public String getShort_description() {
        return short_description;
    }

    public String getLong_description() {
        return long_description;
    }

    public String getFromDate() {
        return fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public int getPoints() {
        return points;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }
}



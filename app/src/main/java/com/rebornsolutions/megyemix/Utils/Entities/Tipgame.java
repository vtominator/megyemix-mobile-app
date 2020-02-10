package com.rebornsolutions.megyemix.Utils.Entities;


import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class Tipgame extends ExpandableGroup {
    private int firstTeamLogo, firstTeamTip, firstTeamScore;
    private int secondTeamLogo, secondTeamTip, secondTeamScore;
    private String secondTeamName;
    private int points;
    private boolean tip, ended;

    public Tipgame(String firstTeamName, int firstTeamLogo, int firstTeamTip, int firstTeamScore,
                   String secondTeamName, int secondTeamLogo, int secondTeamTip, int secondTeamScore,
                   int points, boolean ended, List items) {
        super(firstTeamName, items);
        this.firstTeamLogo = firstTeamLogo;
        this.firstTeamTip = firstTeamTip;
        this.firstTeamScore = firstTeamScore;
        this.secondTeamName = secondTeamName;
        this.secondTeamLogo = secondTeamLogo;
        this.secondTeamTip = secondTeamTip;
        this.secondTeamScore = secondTeamScore;
        this.points = points;
        this.ended = ended;
    }

    public int getFirstTeamLogo() {
        return firstTeamLogo;
    }

    public int getSecondTeamLogo() {
        return secondTeamLogo;
    }

    public String getSecondTeamName() {
        return secondTeamName;
    }

    public int getFirstTeamTip() {
        return firstTeamTip;
    }

    public void setFirstTeamTip(int firstTeamTip) {
        this.firstTeamTip = firstTeamTip;
    }

    public int getFirstTeamScore() {
        return firstTeamScore;
    }

    public void setFirstTeamScore(int firstTeamScore) {
        this.firstTeamScore = firstTeamScore;
    }

    public int getSecondTeamTip() {
        return secondTeamTip;
    }

    public void setSecondTeamTip(int secondTeamTip) {
        this.secondTeamTip = secondTeamTip;
    }

    public int getSecondTeamScore() {
        return secondTeamScore;
    }

    public void setSecondTeamScore(int secondTeamScore) {
        this.secondTeamScore = secondTeamScore;
    }

    public boolean isEnded() {
        return ended;
    }

    public void setEnded(boolean ended) {
        this.ended = ended;
    }

    public boolean isTip() {
        return tip;
    }

    public void setTip(boolean tip) {
        this.tip = tip;
    }

    public int getPoints() {
        return points;
    }
}

package com.rebornsolutions.megyemix.Utils.Entities;


import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.Comparator;
import java.util.List;

public class Team extends ExpandableGroup {
    private int logo;

    public Team(String name, int logo, List items) {
        super(name, items);
        this.logo = logo;
    }


    public static final Comparator<Team> BY_SCORE = new Comparator<Team>() {
        @Override
        public int compare(Team team, Team o2) {
            if (Integer.parseInt(team.getItems().get(0).toString()) < Integer.parseInt(o2.getItems().get(0).toString())) return 1;
            else if (Integer.parseInt(team.getItems().get(0).toString()) > Integer.parseInt(o2.getItems().get(0).toString())) return -1;
            return 0;
        }
    };

    public int getLogo() {
        return logo;
    }
}

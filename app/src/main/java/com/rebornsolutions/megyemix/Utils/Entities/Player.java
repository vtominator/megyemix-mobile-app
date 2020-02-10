package com.rebornsolutions.megyemix.Utils.Entities;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.Comparator;
import java.util.List;

public class Player extends ExpandableGroup {
    public Player(String name, List items) {
        super(name, items);
    }


    public static final Comparator<Player> BY_SCORE = new Comparator<Player>() {
        @Override
        public int compare(Player player, Player o2) {
            if (Integer.parseInt(player.getItems().get(0).toString()) < Integer.parseInt(o2.getItems().get(0).toString())) return 1;
            else if (Integer.parseInt(player.getItems().get(0).toString()) > Integer.parseInt(o2.getItems().get(0).toString())) return -1;
            return 0;
        }
    };
}

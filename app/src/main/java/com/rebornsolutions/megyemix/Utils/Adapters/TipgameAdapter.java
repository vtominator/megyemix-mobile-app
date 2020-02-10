package com.rebornsolutions.megyemix.Utils.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rebornsolutions.megyemix.R;
import com.rebornsolutions.megyemix.TipgameActivity;
import com.rebornsolutions.megyemix.Utils.Entities.Tipgame;
import com.rebornsolutions.megyemix.Utils.Entities.TipgameScore;
import com.rebornsolutions.megyemix.Utils.ViewHolders.TipgameScoresViewHolder;
import com.rebornsolutions.megyemix.Utils.ViewHolders.TipgameViewHolder;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.ArrayList;
import java.util.List;

public class TipgameAdapter extends ExpandableRecyclerViewAdapter<TipgameViewHolder, TipgameScoresViewHolder> {

    public TipgameAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }


    @Override
    public TipgameViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_tip_games, parent, false);
        return new TipgameViewHolder(v);
    }

    @Override
    public TipgameScoresViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_tip_games_scores, parent, false);
        return new TipgameScoresViewHolder(v);
    }

    @Override
    public void onBindChildViewHolder(TipgameScoresViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final TipgameScore tipgameScore = (TipgameScore) group.getItems().get(childIndex);
        Tipgame tipgame = tipgameScore.getTipgame();
        holder.bind(tipgameScore, tipgame);
    }


    @Override
    public void onBindGroupViewHolder(TipgameViewHolder holder, int flatPosition, ExpandableGroup group) {
        final Tipgame tipgame = (Tipgame) group;
        holder.bind(tipgame);
    }
}

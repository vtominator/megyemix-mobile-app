package com.rebornsolutions.megyemix.Utils.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rebornsolutions.megyemix.R;
import com.rebornsolutions.megyemix.Utils.Entities.Player;
import com.rebornsolutions.megyemix.Utils.Entities.PlayerScore;
import com.rebornsolutions.megyemix.Utils.ViewHolders.PlayerViewHolder;
import com.rebornsolutions.megyemix.Utils.ViewHolders.PlayerScoresViewHolder;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class PlayerAdapter extends ExpandableRecyclerViewAdapter<PlayerViewHolder, PlayerScoresViewHolder> {

    public PlayerAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }


    @Override
    public PlayerViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_table_megyemix, parent, false);
        return new PlayerViewHolder(v);
    }

    @Override
    public PlayerScoresViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_table_megyemix_scores, parent, false);
        return new PlayerScoresViewHolder(v);
    }

    @Override
    public void onBindChildViewHolder(PlayerScoresViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final PlayerScore playerScore = (PlayerScore) group.getItems().get(childIndex);
        holder.bind(playerScore);
    }


    @Override
    public void onBindGroupViewHolder(PlayerViewHolder holder, int flatPosition, ExpandableGroup group) {
        final Player player = (Player) group;
        holder.bind(player, flatPosition);
    }
}

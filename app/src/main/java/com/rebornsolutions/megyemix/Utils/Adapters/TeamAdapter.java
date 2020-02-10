package com.rebornsolutions.megyemix.Utils.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rebornsolutions.megyemix.R;
import com.rebornsolutions.megyemix.Utils.Entities.Team;
import com.rebornsolutions.megyemix.Utils.Entities.TeamScore;
import com.rebornsolutions.megyemix.Utils.ViewHolders.TeamScoresViewHolder;
import com.rebornsolutions.megyemix.Utils.ViewHolders.TeamViewHolder;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class TeamAdapter extends ExpandableRecyclerViewAdapter<TeamViewHolder, TeamScoresViewHolder> {

    public TeamAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }


    @Override
    public TeamViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_table_teams, parent, false);
        return new TeamViewHolder(v);
    }

    @Override
    public TeamScoresViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_table_teams_scores, parent, false);
        return new TeamScoresViewHolder(v);
    }

    @Override
    public void onBindChildViewHolder(TeamScoresViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final TeamScore teamScore = (TeamScore) group.getItems().get(childIndex);
        holder.bind(teamScore);
    }


    @Override
    public void onBindGroupViewHolder(TeamViewHolder holder, int flatPosition, ExpandableGroup group) {
        final Team team = (Team) group;
        holder.bind(team, flatPosition);
    }
}

package com.rebornsolutions.megyemix.Utils.ViewHolders;

import android.view.View;
import android.widget.TextView;

import com.rebornsolutions.megyemix.R;
import com.rebornsolutions.megyemix.Utils.Entities.PlayerScore;
import com.rebornsolutions.megyemix.Utils.Entities.TeamScore;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class TeamScoresViewHolder extends ChildViewHolder {
    private TextView tvAllMatches, tvWins, tvDraws, tvLoses, tvGoalsFor, tvGoalsAgainst, tvGoalDifference;

    // [card_table_teams_scores.xml]
    public TeamScoresViewHolder(View itemView) {
        super(itemView);

        tvAllMatches = itemView.findViewById(R.id.tvAllMatches);
        tvWins = itemView.findViewById(R.id.tvWins);
        tvDraws = itemView.findViewById(R.id.tvDraws);
        tvLoses = itemView.findViewById(R.id.tvLoses);
        tvGoalsFor = itemView.findViewById(R.id.tvGoalsFor);
        tvGoalsAgainst = itemView.findViewById(R.id.tvGoalsAgainst);
        tvGoalDifference = itemView.findViewById(R.id.tvGoalDifference);
    }

    public void bind(TeamScore teamScore){
        tvAllMatches.setText(String.valueOf(teamScore.getAll_matches()));
        tvWins.setText(String.valueOf(teamScore.getWins()));
        tvDraws.setText(String.valueOf(teamScore.getDraws()));
        tvLoses.setText(String.valueOf(teamScore.getLoses()));
        tvGoalsFor.setText(String.valueOf(teamScore.getGoals_for()));
        tvGoalsAgainst.setText(String.valueOf(teamScore.getGoals_against()));
        tvGoalDifference.setText(String.valueOf(teamScore.getGoal_difference()));
    }
}

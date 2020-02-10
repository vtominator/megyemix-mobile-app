package com.rebornsolutions.megyemix.Utils.ViewHolders;

import android.view.View;
import android.widget.TextView;

import com.rebornsolutions.megyemix.R;
import com.rebornsolutions.megyemix.Utils.Entities.PlayerScore;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class PlayerScoresViewHolder extends ChildViewHolder {
    private TextView tvAllTips, tvCorrect, tvIncorrect, tvAllCompletedMissions;

    // [card_table_megyemix_scores.xml]
    public PlayerScoresViewHolder(View itemView) {
        super(itemView);
        tvAllTips = itemView.findViewById(R.id.tvAllTips);
        tvCorrect = itemView.findViewById(R.id.tvCorrect);
        tvIncorrect = itemView.findViewById(R.id.tvIncorrect);
        tvAllCompletedMissions = itemView.findViewById(R.id.tvAllCompletedMissions);
    }

    public void bind(PlayerScore playerScore){
        tvAllTips.setText(String.valueOf(playerScore.getAll_tips()));
        tvCorrect.setText(String.valueOf(playerScore.getCorrect()));
        tvIncorrect.setText(String.valueOf(playerScore.getIncorrect()));
        tvAllCompletedMissions.setText(String.valueOf(playerScore.getAll_completed_missions()));
    }
}

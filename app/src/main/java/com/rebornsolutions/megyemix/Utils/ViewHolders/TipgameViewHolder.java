package com.rebornsolutions.megyemix.Utils.ViewHolders;

import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rebornsolutions.megyemix.R;
import com.rebornsolutions.megyemix.Utils.Entities.Team;
import com.rebornsolutions.megyemix.Utils.Entities.Tipgame;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

public class TipgameViewHolder extends GroupViewHolder {
    private TextView tvFirstTeamName, tvFirstTeamScore, tvFirstTeamTip, tvEarnedPoints;
    private TextView tvSecondTeamName, tvSecondTeamScore, tvSecondTeamTip, tvScorePlaceHolder;
    private ImageView ivFirstTeamLogo, ivSecondTeamLogo, ivArrow;
    private LinearLayout layoutResult, layoutTip, layoutEarnedPoints;

    // [card_tip_games.xml]
    public TipgameViewHolder(View itemView) {
        super(itemView);
        ivFirstTeamLogo = itemView.findViewById(R.id.ivFirstTeamLogo);
        tvFirstTeamName = itemView.findViewById(R.id.tvFirstTeamName);
        tvFirstTeamScore = itemView.findViewById(R.id.tvFirstTeamScore);
        tvFirstTeamTip = itemView.findViewById(R.id.tvFirstTeamTip);

        ivSecondTeamLogo = itemView.findViewById(R.id.ivSecondTeamLogo);
        tvSecondTeamName = itemView.findViewById(R.id.tvSecondTeamName);
        tvSecondTeamScore = itemView.findViewById(R.id.tvSecondTeamScore);
        tvSecondTeamTip = itemView.findViewById(R.id.tvSecondTeamTip);

        tvEarnedPoints = itemView.findViewById(R.id.tvEarnedPoints);
        tvScorePlaceHolder = itemView.findViewById(R.id.tvScorePlaceHolder);
        layoutResult = itemView.findViewById(R.id.layoutResult);
        layoutTip = itemView.findViewById(R.id.layoutTip);
        layoutEarnedPoints = itemView.findViewById(R.id.layoutEarnedPoints);
        ivArrow = itemView.findViewById(R.id.ivArrow);
    }

    public void bind(Tipgame tipgame) {

        if (tipgame.isTip()) {

            tvScorePlaceHolder.setVisibility(View.GONE);
            layoutTip.setVisibility(View.VISIBLE);
        }

        if (tipgame.isEnded()) {


            layoutResult.setVisibility(View.VISIBLE);
            layoutEarnedPoints.setVisibility(View.VISIBLE);
        }

        ivFirstTeamLogo.setImageResource(tipgame.getFirstTeamLogo());
        tvFirstTeamName.setText(tipgame.getTitle());
        tvFirstTeamScore.setText(String.valueOf(tipgame.getFirstTeamScore()));
        tvFirstTeamTip.setText(String.valueOf(tipgame.getFirstTeamTip()));

        ivSecondTeamLogo.setImageResource(tipgame.getSecondTeamLogo());
        tvSecondTeamName.setText(tipgame.getSecondTeamName());
        tvSecondTeamScore.setText(String.valueOf(tipgame.getSecondTeamScore()));
        tvSecondTeamTip.setText(String.valueOf(tipgame.getSecondTeamTip()));

        tvEarnedPoints.setText(String.valueOf(tipgame.getPoints()));
    }


    @Override
    public void expand() {
        animateExpand();
    }

    @Override
    public void collapse() {
        animateCollapse();
    }

    private void animateExpand() {
        RotateAnimation rotate =
                new RotateAnimation(360, 180, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        ivArrow.startAnimation(rotate);
    }

    private void animateCollapse() {
        RotateAnimation rotate =
                new RotateAnimation(180, 360, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        ivArrow.startAnimation(rotate);
    }

}

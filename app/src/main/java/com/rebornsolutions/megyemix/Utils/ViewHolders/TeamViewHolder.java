package com.rebornsolutions.megyemix.Utils.ViewHolders;

import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.rebornsolutions.megyemix.R;
import com.rebornsolutions.megyemix.Utils.Entities.Team;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

public class TeamViewHolder extends GroupViewHolder {
    private TextView tvTeamPosition, tvTeamName, tvTeamPoints;
    private ImageView ivBadge, ivTeamLogo, ivArrow;


    // [card_table_teams.xml]
    public TeamViewHolder(View itemView) {
        super(itemView);
        ivBadge = itemView.findViewById(R.id.ivBadge);
        tvTeamPosition = itemView.findViewById(R.id.tvTeamPosition);
        ivTeamLogo = itemView.findViewById(R.id.ivTeamLogo);
        tvTeamName = itemView.findViewById(R.id.tvTeamName);
        tvTeamPoints = itemView.findViewById(R.id.tvTeamPoints);
        ivArrow = itemView.findViewById(R.id.ivArrow);
    }

    public void bind(Team team, int position) {
        if (position == 0){
            ivBadge.setImageResource(R.drawable.badge_first);
        } else if(position == 1){
            ivBadge.setImageResource(R.drawable.badge_second);
        } else if(position == 2){
            ivBadge.setImageResource(R.drawable.badge_third);
        } else {
            ivBadge.setImageResource(0);
            tvTeamPosition.setText(String.valueOf(position+1));
        }

        tvTeamName.setText(team.getTitle());
        ivTeamLogo.setImageResource(team.getLogo());
        tvTeamPoints.setText(String.valueOf(team.getItems().get(0).toString()));


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

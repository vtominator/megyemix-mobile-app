package com.rebornsolutions.megyemix.Utils.ViewHolders;

import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.rebornsolutions.megyemix.R;
import com.rebornsolutions.megyemix.Utils.Entities.Player;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

public class PlayerViewHolder extends GroupViewHolder {
    private TextView tvPlayerName, tvPlayerPoints, tvPlayerPosition;
    private ImageView ivBadge, ivArrow;


    // [card_table_megyemix.xml]
    public PlayerViewHolder(View itemView) {
        super(itemView);
        ivBadge = itemView.findViewById(R.id.ivBadge);
        tvPlayerPosition = itemView.findViewById(R.id.tvPlayerPosition);
        tvPlayerName = itemView.findViewById(R.id.tvPlayerName);
        tvPlayerPoints = itemView.findViewById(R.id.tvPlayerPoints);
        ivArrow = itemView.findViewById(R.id.ivArrow);
    }

    public void bind(Player player, int position) {
        if (position == 0){
            ivBadge.setImageResource(R.drawable.badge_first);
        } else if(position == 1){
            ivBadge.setImageResource(R.drawable.badge_second);
        } else if(position == 2){
            ivBadge.setImageResource(R.drawable.badge_third);
        } else {
            ivBadge.setImageResource(0);
            tvPlayerPosition.setText(String.valueOf(position+1));
        }


        tvPlayerName.setText(player.getTitle());
        tvPlayerPoints.setText(String.valueOf(player.getItems().get(0).toString()));


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

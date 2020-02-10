package com.rebornsolutions.megyemix.Utils.ViewHolders;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.rebornsolutions.megyemix.R;
import com.rebornsolutions.megyemix.Utils.Entities.Tipgame;
import com.rebornsolutions.megyemix.Utils.Entities.TipgameScore;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class TipgameScoresViewHolder extends ChildViewHolder {
    private TextView tvLocation, tvDate;
    private Button bTipGame;

    // [card_tip_games_scores.xml]
    public TipgameScoresViewHolder(View itemView) {
        super(itemView);

        tvLocation = itemView.findViewById(R.id.tvLocation);
        tvDate = itemView.findViewById(R.id.tvDate);
        bTipGame = itemView.findViewById(R.id.bTipGame);
    }

    public void bind(final TipgameScore tipgameScore, final Tipgame tipgame) {
        final Context mContext = bTipGame.getContext();


        if (tipgame.isEnded()) {
            bTipGame.setBackground(mContext.getResources().getDrawable(R.drawable.button_gray_transparent_rounded));
            bTipGame.setTextColor(mContext.getResources().getColor(R.color.background_gray));
            bTipGame.setClickable(false);
        } else {
            bTipGame.setBackground(mContext.getResources().getDrawable(R.drawable.button_green_transparent_rounded));
            bTipGame.setTextColor(mContext.getResources().getColor(R.color.green));
            bTipGame.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Dialog detailDialog = new Dialog(mContext);

                    detailDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    detailDialog.setContentView(R.layout.dialog_tipgame_window);

                    ImageView tvFirstTeamLogo = detailDialog.findViewById(R.id.ivFirstTeamLogo);
                    TextView tvFirstTeamName = detailDialog.findViewById(R.id.tvFirstTeamName);
                    ImageView ivFirstUpArrow = detailDialog.findViewById(R.id.ivFirstUpArrow);
                    final TextView tvFirstScore = detailDialog.findViewById(R.id.tvFirstScore);
                    ImageView ivFirstDownArrow = detailDialog.findViewById(R.id.ivFirstDownArrow);

                    ImageView ivSecondTeamLogo = detailDialog.findViewById(R.id.ivSecondTeamLogo);
                    TextView tvSecondTeamName = detailDialog.findViewById(R.id.tvSecondTeamName);
                    ImageView ivSecondUpArrow = detailDialog.findViewById(R.id.ivSecondUpArrow);
                    final TextView tvSecondScore = detailDialog.findViewById(R.id.tvSecondScore);
                    ImageView ivSecondDownArrow = detailDialog.findViewById(R.id.ivSecondDownArrow);


                    tvFirstTeamLogo.setImageResource(tipgame.getFirstTeamLogo());
                    tvFirstTeamName.setText(tipgame.getTitle());
                    tvFirstScore.setText(String.valueOf(tipgame.getFirstTeamTip()));
                    ivFirstUpArrow.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int currentScore = Integer.parseInt(tvFirstScore.getText().toString());
                            tvFirstScore.setText(String.valueOf(++currentScore));
                        }
                    });
                    ivFirstDownArrow.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int currentScore = Integer.parseInt(tvFirstScore.getText().toString());
                            if (!(currentScore <= 0)) {
                                tvFirstScore.setText(String.valueOf(--currentScore));
                            }
                        }
                    });

                    ivSecondTeamLogo.setImageResource(tipgame.getSecondTeamLogo());
                    tvSecondTeamName.setText(tipgame.getSecondTeamName());
                    tvSecondScore.setText(String.valueOf(tipgame.getSecondTeamTip()));
                    ivSecondUpArrow.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int currentScore = Integer.parseInt(tvSecondScore.getText().toString());
                            tvSecondScore.setText(String.valueOf(++currentScore));
                        }
                    });
                    ivSecondDownArrow.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int currentScore = Integer.parseInt(tvSecondScore.getText().toString());
                            if (!(currentScore <= 0)) {
                                tvSecondScore.setText(String.valueOf(--currentScore));
                            }
                        }
                    });

                    TextView tvLocation = detailDialog.findViewById(R.id.tvLocation);
                    TextView tvDate = detailDialog.findViewById(R.id.tvDate);

                    tvLocation.setText(tipgameScore.getLocation());
                    tvDate.setText(tipgameScore.getDate());

                    Button bSave = detailDialog.findViewById(R.id.bSave);
                    bSave.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            int firstTeamTip = Integer.parseInt(tvFirstScore.getText().toString());
                            int secondTeamTip = Integer.parseInt(tvSecondScore.getText().toString());

                            tipgame.setFirstTeamTip(firstTeamTip);
                            tipgame.setSecondTeamTip(secondTeamTip);

                            tipgame.setTip(true);

                            detailDialog.dismiss();
                        }
                    });

                    detailDialog.show();
                }
            });
        }

        tvLocation.setText(tipgameScore.getLocation());
        tvDate.setText(tipgameScore.getDate());

    }

}

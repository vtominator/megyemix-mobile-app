package com.rebornsolutions.megyemix;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rebornsolutions.megyemix.Utils.SharedPrefManager;


public class ProfileActivity extends AppCompatActivity {
    private Context mContext = ProfileActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initView();
    }

    private void initView() {
        TextView tvAllTips, tvAllPoints, tvCorrectTips, tvMissions;
        TextView tvUserName, tvPosition, tvRegistration, tvHitRate, tvFavoriteTeam, tvLogOut;
        ImageView ivTeamLogo;

        tvAllTips = findViewById(R.id.tvAllTips);
        tvAllPoints = findViewById(R.id.tvAllPoints);
        tvCorrectTips = findViewById(R.id. tvCorrectTips);
        tvMissions = findViewById(R.id.tvMissions);

        tvUserName = findViewById(R.id.tvUserName);
        tvPosition = findViewById(R.id.tvPosition);
        tvRegistration = findViewById(R.id.tvRegistration);
        tvHitRate = findViewById(R.id.tvHitRate);
        tvFavoriteTeam = findViewById(R.id.tvFavoriteTeam);
        tvLogOut = findViewById(R.id.tvLogOut);

        ivTeamLogo = findViewById(R.id.ivTeamLogo);

        tvAllTips.setText("119");
        tvAllPoints.setText(String.valueOf(SharedPrefManager.getInstance(mContext).getPoints()));
        tvCorrectTips.setText("67");
        tvMissions.setText("36");

        tvUserName.setText(SharedPrefManager.getInstance(mContext).getUsername());
        tvPosition.setText("36");
        tvRegistration.setText("2019.11.05");
        tvHitRate.setText("56.3");
        tvFavoriteTeam.setText("Gödöllői SK III.");

        tvLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPrefManager.getInstance(mContext).logout();
            }
        });

        ivTeamLogo.setImageResource(R.drawable.team_godollo);
    }
}

package com.rebornsolutions.megyemix;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rebornsolutions.megyemix.Fragments.Missions.MissionsActivity;
import com.rebornsolutions.megyemix.Fragments.Table.TableActivity;
import com.rebornsolutions.megyemix.Utils.Adapters.TipgameAdapter;
import com.rebornsolutions.megyemix.Utils.Entities.Tipgame;
import com.rebornsolutions.megyemix.Utils.SharedPrefManager;

public class HomeActivity extends AppCompatActivity {
    private Context mContext = HomeActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // TODO: SharedPrefManagerben átírni a placeholder adatokat [John Doe, 48pt]

        initHeader();
        initButtons();
    }

    private void initHeader(){
        TextView tvPoints = findViewById(R.id.tvPoints);
        TextView tvUserName = findViewById(R.id.tvUserName);

        tvPoints.setText(String.valueOf(SharedPrefManager.getInstance(mContext).getPoints()));
        tvUserName.setText(SharedPrefManager.getInstance(mContext).getUsername());
    }
    private void initButtons(){
        Button bTipGame = findViewById(R.id.bTipGame);
        bTipGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, TipgameActivity.class));
            }
        });

        Button bMission = findViewById(R.id.bMission);
        bMission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, MissionsActivity.class));
            }
        });

        Button bTable = findViewById(R.id.bTable);
        bTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, TableActivity.class));
            }
        });

        Button bNextMatches = findViewById(R.id.bNextMatches);
        bNextMatches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, NextMatchesActivity.class));
            }
        });

        Button bProfile = findViewById(R.id.bProfile);
        bProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, ProfileActivity.class));
            }
        });

    }
}

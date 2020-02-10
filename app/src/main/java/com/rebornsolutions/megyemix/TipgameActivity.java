package com.rebornsolutions.megyemix;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.rebornsolutions.megyemix.Utils.Adapters.TeamAdapter;
import com.rebornsolutions.megyemix.Utils.Adapters.TipgameAdapter;
import com.rebornsolutions.megyemix.Utils.Entities.Team;
import com.rebornsolutions.megyemix.Utils.Entities.TeamScore;
import com.rebornsolutions.megyemix.Utils.Entities.Tipgame;
import com.rebornsolutions.megyemix.Utils.Entities.TipgameScore;

import java.util.ArrayList;
import java.util.Collections;

public class TipgameActivity extends AppCompatActivity {
    private Context mContext = TipgameActivity.this;

    private TipgameAdapter adapter;

    private ArrayList<Tipgame> tipgamesList = new ArrayList<Tipgame>();
    protected ArrayList<ArrayList> tipgameScoresList = new ArrayList<>();

    private ArrayList<TipgameScore> tipgameScore1 = new ArrayList<>();
    private ArrayList<TipgameScore> tipgameScore2 = new ArrayList<>();
    private ArrayList<TipgameScore> tipgameScore3 = new ArrayList<>();
    private ArrayList<TipgameScore> tipgameScore4 = new ArrayList<>();

    private Spinner sRound;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipgame);

        TipgameScore tipgameScore_1 = new TipgameScore("NYC Stadion, Tiszakécske", "2019.09.11");
        TipgameScore tipgameScore_2 = new TipgameScore("NYC Stadion, Tiszakécske", "2019.09.11");
        TipgameScore tipgameScore_3 = new TipgameScore("NYC Stadion, Tiszakécske", "2019.09.11");
        TipgameScore tipgameScore_4 = new TipgameScore("NYC Stadion, Tiszakécske", "2019.09.11");

        tipgameScore1.add(tipgameScore_1);
        tipgameScore2.add(tipgameScore_2);
        tipgameScore3.add(tipgameScore_3);
        tipgameScore4.add(tipgameScore_4);

        tipgameScoresList.add(tipgameScore1);
        tipgameScoresList.add(tipgameScore2);
        tipgameScoresList.add(tipgameScore3);
        tipgameScoresList.add(tipgameScore4);

        Tipgame tipgame_1 = new Tipgame("Főnix ISE-Gödöllő", R.drawable.team_fonix, 2, 2, "Aszód FC", R.drawable.team_aszod, 4, 4, 5, true, tipgameScore1);
        Tipgame tipgame_2 = new Tipgame("Bagi TC '95", R.drawable.team_bagi, 2, 1, "Iszaszeg BSC", R.drawable.team_isaszeg, 0, 0, 2, true, tipgameScore2);
        Tipgame tipgame_3 = new Tipgame("Bagi TC '95", R.drawable.team_bagi, 0, 0, "Aszód FC", R.drawable.team_aszod, 0, 0, 0, false, tipgameScore3);
        Tipgame tipgame_4 = new Tipgame("Főnix ISE-Gödöllő", R.drawable.team_fonix, 0, 0, "Aszód FC", R.drawable.team_aszod, 0, 0, 0, false, tipgameScore4);

        tipgame_1.setTip(true);
        tipgame_2.setTip(true);

        tipgameScore_1.setTipgame(tipgame_1);
        tipgameScore_2.setTipgame(tipgame_2);
        tipgameScore_3.setTipgame(tipgame_3);
        tipgameScore_4.setTipgame(tipgame_4);

        tipgamesList.add(tipgame_1);
        tipgamesList.add(tipgame_2);
        tipgamesList.add(tipgame_3);
        tipgamesList.add(tipgame_4);

        initSpinners();
        listToView();
    }

    private void initSpinners() {
        sRound = findViewById(R.id.sRound);

        ArrayAdapter<CharSequence> roundAdapter = ArrayAdapter.createFromResource(mContext, R.array.round, android.R.layout.simple_spinner_item);
        roundAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sRound.setAdapter(roundAdapter);
    }

    private void listToView() {
        RecyclerView recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new TipgameAdapter(tipgamesList);
        recyclerView.setAdapter(adapter);
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        adapter.notifyDataSetChanged();
    }
}

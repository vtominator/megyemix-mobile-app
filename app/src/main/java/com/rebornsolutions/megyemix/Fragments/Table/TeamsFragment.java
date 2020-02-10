package com.rebornsolutions.megyemix.Fragments.Table;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.rebornsolutions.megyemix.R;
import com.rebornsolutions.megyemix.Utils.Adapters.TeamAdapter;
import com.rebornsolutions.megyemix.Utils.Entities.Team;
import com.rebornsolutions.megyemix.Utils.Entities.TeamScore;

import java.util.ArrayList;
import java.util.Collections;

public class TeamsFragment extends Fragment {
    private ArrayList<Team> teamList = new ArrayList<Team>();
    protected ArrayList<ArrayList> teamScoreList = new ArrayList<>();

    private ArrayList<TeamScore> teamScore1 = new ArrayList<>();
    private ArrayList<TeamScore> teamScore2 = new ArrayList<>();
    private ArrayList<TeamScore> teamScore3 = new ArrayList<>();
    private ArrayList<TeamScore> teamScore4 = new ArrayList<>();
    private ArrayList<TeamScore> teamScore5 = new ArrayList<>();
    private ArrayList<TeamScore> teamScore6 = new ArrayList<>();
    private ArrayList<TeamScore> teamScore7 = new ArrayList<>();

    private Spinner sTeamClass, sRound;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_teams, container, false);

        teamScore1.add(new TeamScore(45, 1, 1, 1, 1, 1, 1, 1));
        teamScore2.add(new TeamScore(39, 16, 13, 0, 3, 96, 33, 63));
        teamScore3.add(new TeamScore(37, 0, 0, 0, 0, 0, 0, 0));
        teamScore4.add(new TeamScore(26, 0, 0, 0, 0, 0, 0, 0));
        teamScore5.add(new TeamScore(19, 0, 0, 0, 0, 0, 0, 0));
        teamScore6.add(new TeamScore(18, 0, 0, 0, 0, 0, 0, 0));
        teamScore7.add(new TeamScore(16, 0, 0, 0, 0, 0, 0, 0));

        teamScoreList.add(teamScore1);
        teamScoreList.add(teamScore2);
        teamScoreList.add(teamScore3);
        teamScoreList.add(teamScore4);
        teamScoreList.add(teamScore5);
        teamScoreList.add(teamScore6);
        teamScoreList.add(teamScore7);

        Team team_1 = new Team("Főnix ISE Gödöllő", R.drawable.team_fonix, teamScore1);
        Team team_2 = new Team("Gödöllői SK III.", R.drawable.team_godollo, teamScore2);
        Team team_3 = new Team("Aszód FC", R.drawable.team_aszod, teamScore3);
        Team team_4 = new Team("Bagi TC '96", R.drawable.team_bagi, teamScore4);
        Team team_5 = new Team("Isaszeg BSC", R.drawable.team_isaszeg, teamScore5);
        Team team_6 = new Team("Vácszentlászló SE", R.drawable.team_vacszentlaszlo, teamScore6);
        Team team_7 = new Team("Gödöllői SK II.", R.drawable.team_godollo, teamScore7);

        teamList.add(team_1);
        teamList.add(team_2);
        teamList.add(team_3);
        teamList.add(team_4);
        teamList.add(team_5);
        teamList.add(team_6);
        teamList.add(team_7);


        initView(view);
        initSpinners(view);
        listToView(view);

        return view;
    }

    private void initView(View view) {
        sTeamClass = view.findViewById(R.id.sTeamClass);
        sRound = view.findViewById(R.id.sRound);
    }

    private void initSpinners(View view) {
        Context mContext = view.getContext();

        ArrayAdapter<CharSequence> teamClassAdapter = ArrayAdapter.createFromResource(mContext, R.array.teamClass, android.R.layout.simple_spinner_item);
        teamClassAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sTeamClass.setAdapter(teamClassAdapter);

        ArrayAdapter<CharSequence> roundAdapter = ArrayAdapter.createFromResource(mContext, R.array.round, android.R.layout.simple_spinner_item);
        roundAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sRound.setAdapter(roundAdapter);


    }

    private void listToView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        TeamAdapter adapter = new TeamAdapter(teamList);
        Collections.sort(teamList, Team.BY_SCORE);
        recyclerView.setAdapter(adapter);
    }
}

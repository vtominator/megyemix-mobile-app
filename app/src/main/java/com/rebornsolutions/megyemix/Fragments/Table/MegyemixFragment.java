package com.rebornsolutions.megyemix.Fragments.Table;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rebornsolutions.megyemix.R;
import com.rebornsolutions.megyemix.Utils.Entities.Player;
import com.rebornsolutions.megyemix.Utils.Entities.PlayerScore;
import com.rebornsolutions.megyemix.Utils.Adapters.PlayerAdapter;

import java.util.ArrayList;
import java.util.Collections;

public class MegyemixFragment extends Fragment {


    private ArrayList<Player> playerList = new ArrayList<Player>();
    protected ArrayList<ArrayList> playerScoreList = new ArrayList<>();

    private ArrayList<PlayerScore> playerScore1 = new ArrayList<>();
    private ArrayList<PlayerScore> playerScore2 = new ArrayList<>();
    private ArrayList<PlayerScore> playerScore3 = new ArrayList<>();
    private ArrayList<PlayerScore> playerScore4 = new ArrayList<>();
    private ArrayList<PlayerScore> playerScore5 = new ArrayList<>();
    private ArrayList<PlayerScore> playerScore6 = new ArrayList<>();
    private ArrayList<PlayerScore> playerScore7 = new ArrayList<>();
    private ArrayList<PlayerScore> playerScore8 = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_megyemix, container, false);

        playerScore1.add(new PlayerScore(45, 100, 100, 100, 100));
        playerScore2.add(new PlayerScore(39, 6, 0, 0, 0));
        playerScore3.add(new PlayerScore(37, 0, 0, 0, 0));
        playerScore4.add(new PlayerScore(26, 0, 0, 0, 0));
        playerScore5.add(new PlayerScore(19, 0, 0, 0, 0));
        playerScore6.add(new PlayerScore(18, 0, 0, 0, 0));
        playerScore7.add(new PlayerScore(16, 0, 0, 0, 0));
        playerScore8.add(new PlayerScore(10, 0, 0, 0, 0));

        playerScoreList.add(playerScore1);
        playerScoreList.add(playerScore2);
        playerScoreList.add(playerScore3);
        playerScoreList.add(playerScore4);
        playerScoreList.add(playerScore5);
        playerScoreList.add(playerScore6);
        playerScoreList.add(playerScore7);
        playerScoreList.add(playerScore8);

        Player player_1 = new Player("Overture", playerScore1);
        Player player_2 = new Player("Tony15", playerScore2);
        Player player_3 = new Player("Coverx", playerScore3);
        Player player_4 = new Player("WeirdoO", playerScore4);
        Player player_5 = new Player("Jazy", playerScore5);
        Player player_6 = new Player("Bamu", playerScore6);
        Player player_7 = new Player("Spooney", playerScore7);
        Player player_8 = new Player("Hex", playerScore8);

        playerList.add(player_1);
        playerList.add(player_2);
        playerList.add(player_3);
        playerList.add(player_4);
        playerList.add(player_5);
        playerList.add(player_6);
        playerList.add(player_7);
        playerList.add(player_8);

        listToView(view);

        return view;
    }

    private void listToView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        PlayerAdapter adapter = new PlayerAdapter(playerList);
        Collections.sort(playerList, Player.BY_SCORE);
        recyclerView.setAdapter(adapter);
    }
}

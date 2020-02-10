package com.rebornsolutions.megyemix.Fragments.Missions;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.rebornsolutions.megyemix.R;
import com.rebornsolutions.megyemix.Utils.Adapters.MissionAdapter;
import com.rebornsolutions.megyemix.Utils.Entities.Mission;

import java.util.ArrayList;

import static com.rebornsolutions.megyemix.Utils.Adapters.MissionAdapter.NOT_CORRECT;

public class FormerFragment extends Fragment {

    private ArrayList<Mission> formerMissions = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_former, container, false);

        initStaticMissions();

        listToView(view);

        return view;
    }

    private void initStaticMissions() {
        int staticLogo = R.drawable.incorrect_mission;
        String staticMissionName, staticShortDescription, staticLongDescription, staticFromDate, staticToDate;

        staticMissionName = "Első tipped!";
        staticShortDescription = "Tippelj helyesen egy mérkőzésre";
        staticLongDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus nunc tellus, tincidunt sit amet fringilla quis, sollicitudin sed lorem. Etiam et turpis tortor. Fusce lectus ante, vulputate sit amet ante sodales, auctor aliquam tortor. Maecenas tincidunt";
        staticFromDate = "2019.06.01";
        staticToDate = "2019.06.10";
        formerMissions.add(new Mission(staticLogo, staticMissionName, staticShortDescription, staticLongDescription, staticFromDate, staticToDate, 10));

        staticLogo = R.drawable.correctmission_a;
        staticMissionName = "Heti helyes tipp!";
        staticShortDescription = "Találj el minden Isaszeg BSC mérközést helyesen a héten";
        formerMissions.add(new Mission(staticLogo, staticMissionName, staticShortDescription, staticLongDescription, staticFromDate, staticToDate, 15));

        staticLogo = R.drawable.correctmission_b;
        staticMissionName = "Hány mérkőzés";
        staticShortDescription = "Hány mérkőzést nyer a héten az Aszód FC?";
        formerMissions.add(new Mission(staticLogo, staticMissionName, staticShortDescription, staticLongDescription, staticFromDate, staticToDate, 15));

        for (Mission mission : formerMissions) {

            if (mission.getMissionName().equals("Első tipped!")) {
                mission.setCorrect(NOT_CORRECT);
            }
        }
    }

    private void listToView(View view) {
        RecyclerView mRecycleView = view.findViewById(R.id.recycleView);
        mRecycleView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());

        MissionAdapter mAdapter = new MissionAdapter(formerMissions);
        mAdapter.setOnItemClickListener(new MissionAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Mission currentMission = formerMissions.get(position);
                initDialog(currentMission);
            }
        });

        mRecycleView.setLayoutManager(mLayoutManager);
        mRecycleView.setAdapter(mAdapter);

    }

    private void initDialog(Mission mission) {
        Dialog detailDialog = new Dialog(getContext());

        detailDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        detailDialog.setContentView(R.layout.dialog_missions_window);

        ImageView ivMissionLogo = detailDialog.findViewById(R.id.ivMissionLogo);
        TextView tvMissionName = detailDialog.findViewById(R.id.tvMissionName);
        TextView tvShortDescription = detailDialog.findViewById(R.id.tvShortDescription);
        TextView tvLongDescription = detailDialog.findViewById(R.id.tvLongDescription);
        TextView tvPoints = detailDialog.findViewById(R.id.tvPoints);


        ivMissionLogo.setImageResource(mission.getLogo());
        tvMissionName.setText(mission.getMissionName());
        tvShortDescription.setText(mission.getShort_description());
        tvLongDescription.setText(mission.getLong_description());
        tvPoints.setText(String.valueOf(mission.getPoints()));
        detailDialog.show();
    }
}

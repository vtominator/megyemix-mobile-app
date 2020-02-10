package com.rebornsolutions.megyemix.Utils.Adapters;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rebornsolutions.megyemix.R;
import com.rebornsolutions.megyemix.Utils.Entities.Mission;

import java.util.List;

public class MissionAdapter extends RecyclerView.Adapter<MissionAdapter.MissionViewHolder> {
    private List<Mission> missionList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }


    public static final int DEFAULT = 0;
    public static final int NOT_CORRECT = 1;

    public MissionAdapter(List<Mission> missionList) {
        this.missionList = missionList;
    }


    public static class MissionViewHolder extends RecyclerView.ViewHolder {
        private TextView tvMissionName, tvShortDescription, tvPoints;


        public MissionViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            tvMissionName = itemView.findViewById(R.id.tvMissionName);
            tvShortDescription = itemView.findViewById(R.id.tvShortDescription);
            tvPoints = itemView.findViewById(R.id.tvPoints);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }

    public int getItemViewType(int position) {
        Mission currentMission = missionList.get(position);

        if (currentMission.getCorrect() == NOT_CORRECT) {
            return NOT_CORRECT;
        }
        return DEFAULT;
    }

    @Override
    public MissionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_missions, viewGroup, false);
        MissionViewHolder missionViewHolder = new MissionViewHolder(view, mListener);

        if (i == NOT_CORRECT) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_missions_not_correct, viewGroup, false);
            missionViewHolder = new MissionViewHolder(view, mListener);
        }

        return missionViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MissionViewHolder viewHolder, int i) {
        final Mission currentMission = missionList.get(i);

        viewHolder.tvMissionName.setText(currentMission.getMissionName());
        viewHolder.tvShortDescription.setText(currentMission.getShort_description());
        viewHolder.tvPoints.setText(String.valueOf(currentMission.getPoints()));
    }


    @Override
    public int getItemCount() {
        return missionList.size();
    }

}
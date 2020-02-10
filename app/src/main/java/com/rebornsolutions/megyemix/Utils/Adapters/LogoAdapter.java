package com.rebornsolutions.megyemix.Utils.Adapters;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.rebornsolutions.megyemix.R;

import java.util.List;

public class LogoAdapter extends PagerAdapter {
    private List<Integer> teamLogosList;
    private LayoutInflater layoutInflater;

    ImageView imageView;

    public LogoAdapter(List<Integer> teamLogosList, Context context) {
        this.teamLogosList = teamLogosList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return teamLogosList.size();
    }



    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view.equals(o);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = layoutInflater.inflate(R.layout.registration_team_logos, container, false);
        imageView = view.findViewById(R.id.ivTeamLogo);
        imageView.setImageResource(teamLogosList.get(position));
        container.addView(view);
        return view;
    }



}

package com.rebornsolutions.megyemix.Fragments.Missions;

import android.content.Context;
import android.os.Bundle;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.rebornsolutions.megyemix.R;
import com.rebornsolutions.megyemix.Utils.SectionsPageAdapter;
import com.rebornsolutions.megyemix.Utils.SharedPrefManager;

public class MissionsActivity extends AppCompatActivity {
    private Context mContext = MissionsActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_missions);

        // TODO: Navigation drawer gombok bekötése

        // Címsor
        initToolbar();

        // Swipeolható tabok
        initTabLayout();

        // Oldalról kihúzható navigációs menü
        initDrawer();
    }



    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.missions));
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
    }

    private void initTabLayout() {
        ViewPager mViewPager = findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.white));
        tabLayout.setTabTextColors(getResources().getColor(R.color.white), getResources().getColor(R.color.white));
    }

    private void initDrawer(){
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.inflateMenu(R.menu.drawer_menu);
        View headerView = navigationView.getHeaderView(0);

        TextView tvPoints = headerView.findViewById(R.id.profile_points);
        TextView tvName = headerView.findViewById(R.id.profile_name);
        TextView tvEmail = headerView.findViewById(R.id.profile_email);

        tvPoints.setText(String.valueOf(SharedPrefManager.getInstance(mContext).getPoints()));
        tvName.setText(SharedPrefManager.getInstance(mContext).getUsername());
        tvEmail.setText(SharedPrefManager.getInstance(mContext).getEmail());
    }


    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new ActualFragment(), "Aktuális");
        adapter.addFragment(new FormerFragment(), "Korábbi");
        viewPager.setAdapter(adapter);
    }
}

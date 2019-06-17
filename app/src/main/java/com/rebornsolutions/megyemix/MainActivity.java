package com.rebornsolutions.megyemix;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Context mContext = MainActivity.this;

    protected static final int APP_NAME_START_INDEX = 5;
    protected static final int APP_NAME_END_INDEX = 8;
    private static final int DELAY = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        transparentStatusAndNavigationBar();
        boldAppNameStyle();
        startAnimation();
        buttonListeners();
    }

    // Áttetszővé teszi a navigációsmenü, illetve a statusbar hátterét: [styles.xml]
    private void transparentStatusAndNavigationBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }

    // Az applikáció nevében szereplő "Mix" szót teszi félkövérré
    private void boldAppNameStyle() {
        SpannableStringBuilder str = new SpannableStringBuilder(getResources().getString(R.string.app_name));
        str.setSpan(new android.text.style.StyleSpan(
                        android.graphics.Typeface.BOLD),
                APP_NAME_START_INDEX,
                APP_NAME_END_INDEX,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        TextView tvAppName;
        tvAppName = findViewById(R.id.tvAppName);
        tvAppName.setText(str);
    }

    // Splash screen animáció
    private void startAnimation() {
        LinearLayout logoLayout, buttonLayout;
        Animation logo_animation, button_animation;

        logoLayout = findViewById(R.id.topLayout);
        buttonLayout = findViewById(R.id.bottomLayout);

        button_animation = AnimationUtils.loadAnimation(this, R.anim.button_animation);
        button_animation.setStartOffset(DELAY);
        buttonLayout.setAnimation(button_animation);

        logo_animation = AnimationUtils.loadAnimation(this, R.anim.logo_animation);
        logo_animation.setStartOffset(DELAY);
        logoLayout.setAnimation(logo_animation);



    }

    // A bejelentkezés és regisztráció gombok listenerjei
    private void buttonListeners(){
        Button bLogIn = findViewById(R.id.bLogIn);
        bLogIn.setOnClickListener(this);

        Button bSignUp = findViewById(R.id.bSignUp);
        bSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bLogIn:
                startActivity(new Intent(mContext, LoginActivity.class));
                finish();
                break;
            case R.id.bSignUp:
                startActivity(new Intent(mContext, SignupActivity.class));
                break;
        }
    }
}

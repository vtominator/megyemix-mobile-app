package com.rebornsolutions.megyemix;

import android.content.Context;
import android.content.Intent;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;
import com.rebornsolutions.megyemix.Utils.Adapters.LogoAdapter;

import java.util.ArrayList;
import java.util.List;

public class SignupActivity extends AppCompatActivity {
    private Context mContext = SignupActivity.this;
    private List<Integer> teamLogosList = new ArrayList<>();
    private static final String TAG = "SignupActivity";

    private HorizontalInfiniteCycleViewPager pager;
    private Spinner sTeamClass, sTeamName;
    private TextView tvTeamName;
    private final int INIT_SLIDER_POS = 4999998;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // TODO: Szerződési feltételek, adatvédelmi szabályzat
        // TODO: Checkbox listener bekötése
        // TODO: Regisztráció gomb bekötése
        // TODO: Csapatlogók feltöltése adatbáziból
        // TODO: Spinnerek feltöltése adatbázisból [strings.xml]

        initViews();
        initLogos();
        initSpinners();

        setFavoriteWithSlider();
        setFavoriteWithSpinner();

        privacyPolicy();
        jumpToLogIn();


    }

    // Globális scopeban deklarált View elemek definiálása
    private void initViews() {
        pager = findViewById(R.id.horizontal_cycle);
        sTeamClass = findViewById(R.id.sTeamClass);
        sTeamName = findViewById(R.id.sTeamName);
        tvTeamName = findViewById(R.id.tvTeamName);
    }

    // A csapatkiválasztóban szereplő ikonok
    private void initLogos() {
        // Mindenképpen a lista feltöltése az első, különben IllegalStateException dob

        teamLogosList.add(R.drawable.team_godollo);
        teamLogosList.add(R.drawable.team_fonix);
        teamLogosList.add(R.drawable.team_bagi);


        LogoAdapter logoAdapter = new LogoAdapter(teamLogosList, getBaseContext());
        pager.setAdapter(logoAdapter);
    }

    // Spinnerek inicializálása
    private void initSpinners() {
        ArrayAdapter<CharSequence> teamClassAdapter = ArrayAdapter.createFromResource(mContext, R.array.teamClass, android.R.layout.simple_spinner_item);
        teamClassAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sTeamClass.setAdapter(teamClassAdapter);

        TextView tvTeamClass = findViewById(R.id.tvTeamClass);
        tvTeamClass.setText(sTeamClass.getSelectedItem().toString());


        ArrayAdapter<CharSequence> teamNameAdapter = ArrayAdapter.createFromResource(mContext, R.array.teamName, android.R.layout.simple_spinner_item);
        teamNameAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sTeamName.setAdapter(teamNameAdapter);
        tvTeamName.setText(sTeamName.getSelectedItem().toString());




    }

    // Kedvenc csapat kiválasztása Slider segítségével
    private void setFavoriteWithSlider() {
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int sliderCurrentPosition) {
                pager.notifyDataSetChanged();

                sliderCurrentPosition = (sliderCurrentPosition - INIT_SLIDER_POS) % teamLogosList.size();

                if (sliderCurrentPosition < 0) {
                    sliderCurrentPosition = teamLogosList.size() + sliderCurrentPosition;
                }
                sTeamName.setSelection(sliderCurrentPosition);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    // Kedvenc csapat kiválasztása Spinnerek segítségével
    private void setFavoriteWithSpinner() {

        sTeamName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int spinnerCurrentPosition, long id) {
                pager.setCurrentItem(spinnerCurrentPosition);
                pager.notifyDataSetChanged();
                tvTeamName.setText(sTeamName.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    // Általános szerződési feltételek és Adatvédelmi szabályzat
    private void privacyPolicy() {
        SpannableString str = new SpannableString(getResources().getString(R.string.privacy_policy));
        int FIRST_LINK_START_INDEX = 13;
        int FIRST_LINK_END_INDEX = 46;
        int SECOND_LINK_START_INDEX = 53;
        int SECOND_LINK_END_INDEX = str.length();

        ClickableSpan clickableSpan_1 = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                // TODO: Általános szerződési feltételek link
                startActivity(new Intent(mContext, SignupActivity.class));
                finish();
            }
        };

        ClickableSpan clickableSpan_2 = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                // TODO: Adatvédelmi szabályzat link
                startActivity(new Intent(mContext, SignupActivity.class));
                finish();
            }
        };

        str.setSpan(clickableSpan_1, FIRST_LINK_START_INDEX, FIRST_LINK_END_INDEX, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        str.setSpan(new UnderlineSpan(), FIRST_LINK_START_INDEX, FIRST_LINK_END_INDEX, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), FIRST_LINK_START_INDEX, FIRST_LINK_END_INDEX, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        str.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.light)), FIRST_LINK_START_INDEX, FIRST_LINK_END_INDEX, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        str.setSpan(clickableSpan_2, SECOND_LINK_START_INDEX, SECOND_LINK_END_INDEX, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        str.setSpan(new UnderlineSpan(), SECOND_LINK_START_INDEX, SECOND_LINK_END_INDEX, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), SECOND_LINK_START_INDEX, SECOND_LINK_END_INDEX, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        str.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.light)), SECOND_LINK_START_INDEX, SECOND_LINK_END_INDEX, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        TextView tvPrivacyPolicy = findViewById(R.id.tvPrivacyPolicy);
        tvPrivacyPolicy.setText(str);
        tvPrivacyPolicy.setMovementMethod(LinkMovementMethod.getInstance());
    }

    // A bejelentkező oldalhoz vezető gomb
    private void jumpToLogIn() {

        SpannableString str = new SpannableString(getResources().getString(R.string.jump_to_login));
        int START_INDEX = 16;
        int END_INDEX = str.length();

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                startActivity(new Intent(mContext, LoginActivity.class));
            }
        };

        str.setSpan(clickableSpan, START_INDEX, END_INDEX, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        str.setSpan(new UnderlineSpan(), START_INDEX, END_INDEX, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), START_INDEX, END_INDEX, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        str.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.green)), START_INDEX, END_INDEX, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        TextView tvJumpToLogIn = findViewById(R.id.tvJumpToLogIn);
        tvJumpToLogIn.setText(str);
        tvJumpToLogIn.setMovementMethod(LinkMovementMethod.getInstance());

    }


}
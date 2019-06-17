package com.rebornsolutions.megyemix;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;

public class SignupActivity extends AppCompatActivity {
    private Context mContext = SignupActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // TODO: Checkbox bekötése
        // TODO: Regisztráció gomb bekötése

        privacyPolicy();
        jumpToLogIn();
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
        str.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.red)), START_INDEX, END_INDEX, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        TextView tvJumpToLogIn = findViewById(R.id.tvJumpToLogIn);
        tvJumpToLogIn.setText(str);
        tvJumpToLogIn.setMovementMethod(LinkMovementMethod.getInstance());

    }
}
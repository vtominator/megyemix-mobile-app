package com.rebornsolutions.megyemix;

import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import static com.rebornsolutions.megyemix.MainActivity.APP_NAME_END_INDEX;
import static com.rebornsolutions.megyemix.MainActivity.APP_NAME_START_INDEX;

public class LoginActivity extends AppCompatActivity {
    private Context mContext = LoginActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // TODO: Jelszóemlékeztető bekötése
        // TODO: Facebook-gomb bekötése
        loginButton();
        jumpToSignUp();


    }

    private void loginButton() {
        Button bLogIn = findViewById(R.id.bLogIn);
        bLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, HomeActivity.class));
                finish();
            }
        });
    }

    // A regisztrációs oldalhoz vezető gomb
    private void jumpToSignUp() {

        SpannableString str = new SpannableString(getResources().getString(R.string.jump_to_signup));
        int START_INDEX = 18;
        int END_INDEX = str.length();

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                startActivity(new Intent(mContext, SignupActivity.class));
                finish();
            }
        };

        str.setSpan(clickableSpan, START_INDEX, END_INDEX, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        str.setSpan(new UnderlineSpan(), START_INDEX, END_INDEX, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), START_INDEX, END_INDEX, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        str.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.green)), START_INDEX, END_INDEX, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        TextView tvJumpToSignUp = findViewById(R.id.tvJumpToSignUp);
        tvJumpToSignUp.setText(str);
        tvJumpToSignUp.setMovementMethod(LinkMovementMethod.getInstance());

    }


}

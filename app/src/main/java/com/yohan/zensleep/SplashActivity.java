package com.yohan.zensleep;

import android.content.Intent;
import android.nfc.TagLostException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {


    private TextView z1, z2, z3;
    private ImageView mArrow;
    private View mGoToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        z1 = (TextView) findViewById(R.id.z1);
        z2 = (TextView) findViewById(R.id.z2);
        z3 = (TextView) findViewById(R.id.z3);
        mArrow = (ImageView) findViewById(R.id.arrow);
        mGoToMain = (View) findViewById(R.id.button_next);

        //THREE Z ANIMATION
        Animation animationz1 = new AlphaAnimation(1, 0);
        animationz1.setDuration(2000);
        animationz1.setInterpolator(new LinearInterpolator());
        animationz1.setRepeatCount(Animation.INFINITE);
        animationz1.setRepeatMode(Animation.REVERSE);
        z1.startAnimation(animationz1);

        Animation animationz2 = new AlphaAnimation(1, 0);
        animationz2.setDuration(2000);
        animationz2.setInterpolator(new LinearInterpolator());
        animationz2.setRepeatCount(Animation.INFINITE);
        animationz2.setRepeatMode(Animation.REVERSE);
        animationz2.setStartOffset(1000);
        z2.startAnimation(animationz2);

        Animation animationz3 = new AlphaAnimation(1, 0);
        animationz3.setDuration(1000);
        animationz3.setInterpolator(new LinearInterpolator());
        animationz3.setRepeatCount(Animation.INFINITE);
        animationz3.setRepeatMode(Animation.REVERSE);
        animationz3.setStartOffset(2000);
        z3.startAnimation(animationz3);

        //ANIMATION ARROW
        Animation animationPlane = new TranslateAnimation(0, 0, 0, 30);
        animationPlane.setDuration(2000);
        animationPlane.setInterpolator(new LinearInterpolator());
        animationPlane.setRepeatCount(Animation.INFINITE);
        animationPlane.setRepeatMode(Animation.REVERSE);
        mArrow.startAnimation(animationPlane);

        //GO TO MAIN
        mGoToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

    }
}

package com.yohan.zensleep;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.shawnlin.numberpicker.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private View viewPurple, mleft, mmiddle, mright, mInfoBtn;
    private Dialog epicDialog;
    ImageView camping, heart;
    TextView mtv_span, tvResultMiddle, tvResultShort, tvResultLong;
    private NumberPicker numberPicker;
    private String ResultShort, ResultMiddle, ResultLong;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPurple = (View) findViewById(R.id.purple_move);
        mleft = (View) findViewById(R.id.left);
        mmiddle = (View) findViewById(R.id.middle);
        mright = (View) findViewById(R.id.right);
        tvResultMiddle = (TextView) findViewById(R.id.tv_resultMiddle);
        tvResultShort = (TextView) findViewById(R.id.tv_resultShort);
        tvResultLong = (TextView) findViewById(R.id.tv_resultLong);

        epicDialog = new Dialog(this);

        mInfoBtn = (View) findViewById(R.id.info);

        //FLYING PURPLE GRADIENT ANIMATION
        Animation animationPurple = new TranslateAnimation(0, 0, 0, 500);
        animationPurple.setDuration(10000);
        animationPurple.setInterpolator(new LinearInterpolator());
        animationPurple.setRepeatCount(Animation.INFINITE);
        animationPurple.setRepeatMode(Animation.REVERSE);
        viewPurple.startAnimation(animationPurple);


        //NUMBER PICKER
        final NumberPicker numberPicker = findViewById(R.id.number_picker);
        String[] data = {"09:00pm", "09:30pm", "10:00pm", "10:30pm", "11:00pm", "11:30pm", "Midnight", "00:30am", "01:00am"};
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(data.length);
        numberPicker.setDisplayedValues(data);
        numberPicker.setValue(4);
        // OnValueChangeListener
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

                Toast.makeText(MainActivity.this, "NewValue : " + newVal, Toast.LENGTH_SHORT).show();

                switch (newVal) {
                    case 1:
                        tvResultShort.setText("03:00am");
                        tvResultMiddle.setText("04:30am");
                        tvResultLong.setText("06:00am");
                        break;
                    case 2:
                        tvResultShort.setText("03:30am");
                        tvResultMiddle.setText("05:00am");
                        tvResultLong.setText("06:30am");
                        break;
                    case 3:
                        tvResultShort.setText("04:00am");
                        tvResultMiddle.setText("05:30am");
                        tvResultLong.setText("07:00am");
                        break;
                    case 4:
                        tvResultShort.setText("04:30am");
                        tvResultMiddle.setText("06:00am");
                        tvResultLong.setText("07:30am");
                        break;
                    case 5:
                        tvResultShort.setText("05:00am");
                        tvResultMiddle.setText("06:30am");
                        tvResultLong.setText("08:00am");
                        break;
                    case 6:
                        tvResultShort.setText("05:30am");
                        tvResultMiddle.setText("07:00am");
                        tvResultLong.setText("08:30am");
                        break;
                    case 7:
                        tvResultShort.setText("06:00am");
                        tvResultMiddle.setText("07:30am");
                        tvResultLong.setText("09:00am");
                        break;
                    case 8:
                        tvResultShort.setText("06:30am");
                        tvResultMiddle.setText("08:00am");
                        tvResultLong.setText("09:30am");
                        break;
                    case 9:
                        tvResultShort.setText("07:00am");
                        tvResultMiddle.setText("08:30am");
                        tvResultLong.setText("10:00am");
                        break;
                }

            }
        });


        mleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mleft.setElevation(10);
                mmiddle.setElevation(0);
                mright.setElevation(0);
                mleft.setBackground(getResources().getDrawable(R.drawable.background_short_white));
                mmiddle.setBackground(getResources().getDrawable(R.drawable.background_middle_grey));
                mright.setBackground(getResources().getDrawable(R.drawable.background_long_grey));
                tvResultShort.setVisibility(View.VISIBLE);
                tvResultMiddle.setVisibility(View.INVISIBLE);
                tvResultLong.setVisibility(View.INVISIBLE);
                }
        });

        mmiddle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mleft.setElevation(0);
                mmiddle.setElevation(10);
                mright.setElevation(0);
                mleft.setBackground(getResources().getDrawable(R.drawable.background_short_grey));
                mmiddle.setBackground(getResources().getDrawable(R.drawable.background_middle_white));
                mright.setBackground(getResources().getDrawable(R.drawable.background_long_grey));
                tvResultShort.setVisibility(View.INVISIBLE);
                tvResultMiddle.setVisibility(View.VISIBLE);
                tvResultLong.setVisibility(View.INVISIBLE);
                }
        });

        mright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mleft.setElevation(0);
                mmiddle.setElevation(0);
                mright.setElevation(10);
                mleft.setBackground(getResources().getDrawable(R.drawable.background_short_grey));
                mmiddle.setBackground(getResources().getDrawable(R.drawable.background_middle_grey));
                mright.setBackground(getResources().getDrawable(R.drawable.background_long_white));
                tvResultShort.setVisibility(View.INVISIBLE);
                tvResultMiddle.setVisibility(View.INVISIBLE);
                tvResultLong.setVisibility(View.VISIBLE);
                }
        });

        mInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showPopup(R.style.DialogSlide);
            }
        });


    }

    public void showPopup(int type){

        epicDialog.setContentView(R.layout.activity_popup);

        heart = epicDialog.findViewById(R.id.heart);
        mtv_span = epicDialog.findViewById(R.id.tv_span);

        heart.setScaleX(-1f);

        Animation animationHeart = new TranslateAnimation(0, 0, 0, 30);
        animationHeart.setDuration(2000);
        animationHeart.setInterpolator(new LinearInterpolator());
        animationHeart.setRepeatCount(Animation.INFINITE);
        animationHeart.setRepeatMode(Animation.REVERSE);
        heart.startAnimation(animationHeart);



        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.getWindow().getAttributes().windowAnimations = type;
        epicDialog.show();

        //SPANNABLE

        String span = "App created with ♥ by me";

        SpannableString ss = new SpannableString(span);

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://linkedin.com/in/yoboitel"));
                startActivity(browserIntent);

            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(true);
                ds.setColor(getResources().getColor(R.color.night_blue));
            }
        };

        ss.setSpan(clickableSpan,22,24, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mtv_span.setText(ss);
        mtv_span.setMovementMethod(LinkMovementMethod.getInstance());
        mtv_span.setHighlightColor(Color.TRANSPARENT);


    }

}

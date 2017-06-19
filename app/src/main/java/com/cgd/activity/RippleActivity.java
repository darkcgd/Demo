package com.cgd.activity;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cgd.R;
import com.cgd.widget.CustomCanvaCircle;
import com.cgd.widget.MyRevealLayout;
import com.darkcgd.library.AbToastUtil;

public class RippleActivity extends AppCompatActivity{
    private CustomCanvaCircle mCustomCanvaCircle;
    private Button bt;
    private TextView tv_status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ripple);
        mCustomCanvaCircle= (CustomCanvaCircle) findViewById(R.id.mCustomCanvaCircle);
        bt= (Button) findViewById(R.id.bt);
        tv_status= (TextView) findViewById(R.id.tv_status);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCustomCanvaCircle.start();
            }
        });
        mCustomCanvaCircle.setShowTextAnimation(new CustomCanvaCircle.ShowTextAnimation() {
            @Override
            public void showText() {
                tv_status.setText("已更新19条资讯");
                TranslateAnimation animation = new TranslateAnimation(0, 0, -100, 0);
                animation.setInterpolator(new AccelerateInterpolator());
                animation.setDuration(100);
                tv_status.startAnimation(animation);
            }
        });
    }


}

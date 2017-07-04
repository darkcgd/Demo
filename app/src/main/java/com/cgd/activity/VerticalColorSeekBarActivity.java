package com.cgd.activity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cgd.R;
import com.cgd.widget.VerticalColorSeekBar;


public class VerticalColorSeekBarActivity extends AppCompatActivity {
    private VerticalColorSeekBar mVpb1;
    private VerticalColorSeekBar mVpb2;
    private VerticalColorSeekBar mVpb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_color_seek_bar);
        mVpb1 = (VerticalColorSeekBar) findViewById(R.id.vpb1);
        mVpb2 = (VerticalColorSeekBar) findViewById(R.id.vpb2);
        mVpb3 = (VerticalColorSeekBar) findViewById(R.id.vpb3);
        mVpb1.setProgress(50);
        mVpb2.setMax(120);
        /**-------------设置属性动画-------------**/
        ObjectAnimator moneyAnimator = ObjectAnimator.ofFloat(mVpb2, "progress", 0, 100);
        moneyAnimator.setDuration(1800);
        moneyAnimator.start();
    }

}
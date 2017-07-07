package com.cgd.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cgd.R;
import com.cgd.widget.VerticalColorSeekBar;


public class VerticalColorSeekBarActivity extends AppCompatActivity implements View.OnClickListener, VerticalColorSeekBar.OnStateChangeListener {

    private TextView tvCurrentTemper, tvCurrentBrightness;
    private VerticalColorSeekBar vpbInnerTemper;
    private VerticalColorSeekBar vpbBrightness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_color_seek_bar);
        initViews();
        initEvents();
        initData();
    }

    private void initViews() {

        tvCurrentTemper = (TextView) findViewById(R.id.tv_current_temper);
        tvCurrentBrightness = (TextView) findViewById(R.id.tv_current_brightness);
        vpbInnerTemper = (VerticalColorSeekBar)findViewById(R.id.vpb_inner_temper);
        vpbBrightness = (VerticalColorSeekBar) findViewById(R.id.vpb_brightness);
        //vpbInnerTemper.setColor(Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE, Color.TRANSPARENT);
        //vpbBrightness.setColor(Color.BLUE, Color.WHITE, Color.YELLOW, Color.BLUE, Color.TRANSPARENT);
    }

    private void initEvents() {
        vpbInnerTemper.setOnStateChangeListener(this);
        vpbBrightness.setOnStateChangeListener(this);
    }

    private void initData() {
        vpbInnerTemper.setProgress(50);
        vpbBrightness.setProgress(70);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        }
    }

    @Override
    public void OnStateChangeListener(View view, float progress) {

    }

    @Override
    public void onStopTrackingTouch(View view, float progress) {
        int viewId = view.getId();
        switch (viewId) {
            case R.id.vpb_inner_temper:
                if (progress < 0) {
                    progress = 0;
                }
                if(progress > 100) {
                    progress = 100;
                }
                tvCurrentTemper.setText(""+progress);
                break;

            case R.id.vpb_brightness:
                if (progress < 0) {
                    progress = 0;
                }
                if(progress > 100) {
                    progress = 100;
                }
                tvCurrentBrightness.setText(""+progress);
                break;
        }

    }
}
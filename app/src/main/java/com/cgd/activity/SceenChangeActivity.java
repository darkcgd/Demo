package com.cgd.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import com.cgd.R;
import com.cgd.util.DensityUtil;
import com.cgd.util.ScreenOrientationUtil;
import com.cgd.util.ScreenSwitchUtils;
import com.cgd.widget.VideoView;

public class SceenChangeActivity extends Activity implements View.OnClickListener {
    private int screenWidth;
    private int screenHeight;
    private VideoView videoView;
    private LinearLayout ll_playcontroller;
    private ImageView iv_stretch;
    private ImageView iv_recordcourse_start;

    //private ScreenSwitchUtils instance;
    private ScreenOrientationUtil instance;
    private ScreenSwitchUtils mScreenSwitchUtils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        screenWidth = display.getWidth();
        screenHeight = display.getHeight();
        setContentView(R.layout.activity_sceen_change);
        initView();

        //instance = ScreenSwitchUtils.init(this.getApplicationContext());
        instance = ScreenOrientationUtil.getInstance();
    }


    @Override
    protected void onStart() {
        super.onStart();
        instance.start(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        instance.stop();
    }


    @SuppressLint("NewApi")
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.e("test", "onConfigurationChanged");
        if (instance.isPortrait()) {
            // 切换成竖屏
            LayoutParams params1 = new RelativeLayout.LayoutParams(screenWidth, DensityUtil.dip2px(this, 160));
            videoView.setLayoutParams(params1);
            Log.e("test", "onConfigurationChanged,竖屏");
        } else {
            // 切换成横屏
            LayoutParams params1 = new RelativeLayout.LayoutParams(screenHeight, screenWidth);
            videoView.setLayoutParams(params1);
            Log.e("test", "onConfigurationChanged,横屏");
        }
    }

    private void initView() {
        videoView = (VideoView) findViewById(R.id.sf_play);

        ll_playcontroller = (LinearLayout) findViewById(R.id.ll_playcontroller);
        ll_playcontroller.getBackground().setAlpha(150);

        iv_stretch = (ImageView) findViewById(R.id.iv_stretch);
        iv_recordcourse_start = (ImageView) findViewById(R.id.iv_recordcourse_start);
        iv_stretch.setOnClickListener(this);
        iv_recordcourse_start.setOnClickListener(this);

    }

    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()) {
            case R.id.iv_stretch:
                instance.toggleScreen();
                break;
        }
    }
}

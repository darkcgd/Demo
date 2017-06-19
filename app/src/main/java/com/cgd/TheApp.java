package com.cgd;

import android.app.Application;
import android.util.DisplayMetrics;

import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by chijiaduo on 2016/11/7.
 */

public class TheApp extends Application{
    public static int screenWidth;
    public static int screenHeight;
    public static TheApp instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        getScreen();  // 初始化屏幕
        initCrashException();//开启全局异常捕捉
    }


    public void getScreen() {
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        screenWidth = metrics.widthPixels;
        screenHeight = metrics.heightPixels;
        if (screenWidth == 0 || screenHeight == 0) {
            screenWidth = 1080;
            screenHeight = 1920;
        }
    }

    private void initCrashException() {
        //使用第三方:腾讯的Bugly
        CrashReport.initCrashReport(getApplicationContext(), "c84b963ce9", true);
    }
}

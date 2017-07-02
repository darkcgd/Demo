package com.cgd.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cgd.R;
import com.cgd.util.DayNightHelper;

public class TestDayNightActivity extends AppCompatActivity {
    private DayNightHelper mDayNightHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        initTheme();
        setContentView(R.layout.activity_test_day_night);
    }
    private void initData() {
        mDayNightHelper = new DayNightHelper(this);
    }

    private void initTheme() {
        if (mDayNightHelper.isDay()) {
            setTheme(R.style.DayTheme);
        } else {
            setTheme(R.style.NightTheme);
        }
    }
}

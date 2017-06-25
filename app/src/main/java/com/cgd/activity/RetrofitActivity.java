package com.cgd.activity;

import android.os.Bundle;

import com.cgd.BaseActivity;
import com.cgd.R;

import butterknife.ButterKnife;

public class RetrofitActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        ButterKnife.bind(this);
    }
}

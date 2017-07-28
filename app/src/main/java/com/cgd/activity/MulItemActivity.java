package com.cgd.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.cgd.R;

public class MulItemActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mul_item);
        initView();
        initData();
    }

    private void initView() {
        mRecyclerView= (RecyclerView) findViewById(R.id.mRecyclerView);
    }

    private void initData() {
    }
}

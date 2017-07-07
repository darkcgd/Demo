package com.cgd.activity;

import java.util.ArrayList;


import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.cgd.R;
import com.cgd.widget.VerticalPageSeekBar;


public class VerticalPageSeekBarActivity extends Activity {

    //页码进度条
    private VerticalPageSeekBar mPageSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_page_seek_bar);
        initDatas();
        initView();
    }

    private void initDatas() {
    }

    private void initView() {
        mPageSeekBar = (VerticalPageSeekBar)findViewById(R.id.seekBar);
    }


}


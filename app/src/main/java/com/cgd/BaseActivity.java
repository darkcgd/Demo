package com.cgd;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by cgd on 2017/6/25.
 */

public abstract class BaseActivity extends Activity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createPresenter();
        initLayout();
        initViews();
        initDatas();
        setListeners();
    }
    protected abstract void createPresenter();
    protected abstract void initLayout();
    protected abstract void initViews();
    protected abstract void initDatas();
    protected abstract void setListeners();

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

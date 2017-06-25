package com.cgd.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by cgd on 2017/6/19.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements View.OnClickListener {
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(createPresenter()==null){
            mPresenter = createPresenter();
        }
        initLayout();
        initViews();
        initDatas();
        setListeners();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        onBaseClick(v);
    }

    protected abstract P createPresenter();
    protected abstract void initLayout();
    protected abstract void initViews();
    protected abstract void initDatas();
    protected abstract void setListeners();
    public abstract void onBaseClick(View v);
}

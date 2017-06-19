package com.cgd.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cgd.R;
import com.cgd.bean.MainData;
import com.cgd.mvp.base.BaseActivity;
import com.cgd.mvp.base.BasePresenter;
import com.cgd.mvp.contract.MainContract;
import com.cgd.mvp.presenter.MainPresenter;

public class MVPActivity extends BaseActivity<MainPresenter> implements MainContract.View{
    private Button bt;
    private TextView tv;
    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected void initLayout() {
        setContentView(R.layout.activity_mvp);
    }

    @Override
    protected void initViews() {
        bt= (Button) findViewById(R.id.bt);
        tv= (TextView) findViewById(R.id.tv);
    }

    @Override
    protected void initDatas() {

    }

    @Override
    protected void setListeners() {
        bt.setOnClickListener(this);
    }

    @Override
    public void onBaseClick(View v) {
        switch (v.getId()){
            case R.id.bt:
                mPresenter.getData();
                break;
        }
    }


    @Override
    public void start() {

    }

    @Override
    public void onSucceed(MainData data) {

    }

    @Override
    public void fail(String info) {

    }

    @Override
    public void end() {

    }
}

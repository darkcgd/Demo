package com.cgd.mvp.presenter;

import com.cgd.mvp.base.BasePresenter;
import com.cgd.mvp.contract.MainContract;
import com.cgd.mvp.model.MainModel;

/**
 * Created by cgd on 2017/6/18.
 */

public class MainPresenter extends MainContract.Presenter{

    public MainPresenter(MainContract.View view) {
        mView=view;
        mModel=new MainModel();
    }

    @Override
    public void getData() {
        mModel.getData();
    }
}

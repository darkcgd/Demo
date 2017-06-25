package com.cgd.presenter;

import com.cgd.bean.BusListBean;
import com.cgd.callback.IBaseResultCallBack;
import com.cgd.model.RetrofitModel;
import com.cgd.view.IRetrofitView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Created by cgd on 2017/6/25.
 */

public class RetrofitPresenter implements IBasePresenter,IBaseResultCallBack{
    private RetrofitModel model;
    private IRetrofitView retrofitView;
    public RetrofitPresenter(IRetrofitView retrofitView) {
        this.retrofitView=retrofitView;
        model=new RetrofitModel();
    }

    public void getSimpleData(int page){
        model.getSimpleData(page,this);
    }

    @Override
    public void onDestroy() {
        retrofitView=null;
    }

    @Override
    public void onSuccess(String content) {
        retrofitView.setText(content);
    }

    @Override
    public void onFailure(String errorMsg) {
        retrofitView.handlerError(errorMsg);
    }
}

package com.cgd.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.cgd.BaseActivity;
import com.cgd.R;
import com.cgd.bean.BusListBean;
import com.cgd.presenter.RetrofitPresenter;
import com.cgd.util.AbAdapter;
import com.cgd.util.AbViewHolder;
import com.cgd.view.IRetrofitView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RetrofitActivity extends BaseActivity implements IRetrofitView{

    @Bind(R.id.lv)
    ListView lv;

    private List<BusListBean.BodyBean.ResultBean.ListBean> list=new ArrayList<>();
    private AbAdapter<BusListBean.BodyBean.ResultBean.ListBean> adapter;
    private RetrofitPresenter presenter;
    @Override
    protected void initLayout() {
        setContentView(R.layout.activity_retrofit);
        ButterKnife.bind(this);
        presenter=new RetrofitPresenter(this);
    }

    @Override
    protected void initViews() {
        adapter=new AbAdapter<BusListBean.BodyBean.ResultBean.ListBean>(this,list,R.layout.item_retrofit) {
            @Override
            public void convert(AbViewHolder viewHolder, BusListBean.BodyBean.ResultBean.ListBean item, int position) {
                TextView tv = viewHolder.getView(R.id.tv);
                tv.setText(""+item.getName());
            }
        };
        lv.setAdapter(adapter);
    }

    @Override
    protected void initDatas() {

    }

    @Override
    protected void setListeners() {

    }

    @OnClick(R.id.bt )   //给 button1 设置一个点击事件
    public void clickBt(){
        presenter.getSimpleData(0);
    }

    @Override
    public void setText(String content) {
        //tv_content.setText(content);
        BusListBean busListBean = new Gson().fromJson(content, new TypeToken<BusListBean>() {}.getType());
        list=busListBean.getBody().getResult().getList();
        adapter.updateView(list);
    }

    @Override
    public void handlerError(String errorMsg) {
       // tv_content.setText(errorMsg);
    }
}

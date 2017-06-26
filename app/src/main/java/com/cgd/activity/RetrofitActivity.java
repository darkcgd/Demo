package com.cgd.activity;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.cgd.BaseActivity;
import com.cgd.R;
import com.cgd.bean.BusListBean;
import com.cgd.bean.RegionListBean;
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
    @Bind(R.id.tv_content)
    TextView tv_content;

    @Bind(R.id.lv)
    ListView lv;

    private List<BusListBean.BodyBean.ResultBean.ListBean> listBus=new ArrayList<>();
    private AbAdapter<BusListBean.BodyBean.ResultBean.ListBean> adapterBus;

    private List<RegionListBean.BodyBean.ResultBean.ListBean> listRegion=new ArrayList<>();
    private AbAdapter<RegionListBean.BodyBean.ResultBean.ListBean> adapterRegion;

    private RetrofitPresenter presenter;

    @Override
    protected void createPresenter() {
        presenter=new RetrofitPresenter(this);
    }

    @Override
    protected void initLayout() {
        setContentView(R.layout.activity_retrofit);
        ButterKnife.bind(this);
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }

    @Override
    protected void setListeners() {

    }

    @OnClick({ R.id.bt1, R.id.bt2, R.id.bt3, R.id.bt4 })
    public void clickBt(View view) {
        switch (view.getId()) {
            case R.id.bt1:
                presenter.getBusList(0);
                break;
            case R.id.bt2:
                presenter.getRegionList();
                break;
            case R.id.bt3:
                break;
            case R.id.bt4:
                break;
            default:
                break;
        }
    }

    @Override
    public void setBusData(String content) {
        if(adapterBus==null){
            adapterBus=new AbAdapter<BusListBean.BodyBean.ResultBean.ListBean>(this,listBus,R.layout.item_retrofit) {
                @Override
                public void convert(AbViewHolder viewHolder, BusListBean.BodyBean.ResultBean.ListBean item, int position) {
                    TextView tv = viewHolder.getView(R.id.tv);
                    tv.setText(""+item.getName());
                }
            };
        }
        lv.setAdapter(adapterBus);
        tv_content.setVisibility(View.GONE);
        lv.setVisibility(View.VISIBLE);
        BusListBean busListBean = new Gson().fromJson(content, new TypeToken<BusListBean>() {}.getType());
        listBus=busListBean.getBody().getResult().getList();
        adapterBus.updateView(listBus);
    }

    @Override
    public void setRegionData(String content) {
        if(adapterRegion==null){
            adapterRegion=new AbAdapter<RegionListBean.BodyBean.ResultBean.ListBean>(this,listRegion,R.layout.item_retrofit) {
                @Override
                public void convert(AbViewHolder viewHolder, RegionListBean.BodyBean.ResultBean.ListBean item, int position) {
                    TextView tv = viewHolder.getView(R.id.tv);
                    tv.setText(""+item.getName());
                }
            };
        }
        lv.setAdapter(adapterRegion);
        tv_content.setVisibility(View.GONE);
        lv.setVisibility(View.VISIBLE);
        RegionListBean regionListBean = new Gson().fromJson(content, new TypeToken<RegionListBean>() {}.getType());
        listRegion=regionListBean.getBody().getResult().getList();
        adapterRegion.updateView(listRegion);
    }

    @Override
    public void handlerError(String url,String errorMsg) {
        lv.setVisibility(View.GONE);
        tv_content.setVisibility(View.VISIBLE);
        tv_content.setText(errorMsg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}

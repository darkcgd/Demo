package com.cgd.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cgd.R;
import com.cgd.adapter.MultiTypeAdapter;
import com.cgd.bean.BusLine;
import com.cgd.bean.BusLinePoint;
import com.cgd.mvc.BaseController;
import com.cgd.mvc.IResultView;
import com.cgd.mvc.OkRequestParams;
import com.darkcgd.library.AbJsonUtil;

import java.util.ArrayList;
import java.util.List;

public class StickyHeadersRecyclerViewActivity extends AppCompatActivity implements IResultView{
    private RecyclerView mRecyclerView;
    //private RelativeLayout mSuspensionBar;
    //private TextView mSuspensionTv;
    private RelativeLayout rl_head_top;
    TextView lineTitle, lineStartEnd;
    ImageView yellow, blue, green;
    View line;

    private int mCurrentPosition = 0;

    private int mSuspensionHeight;

    private List<BusLine.BodyBean.ResultBean.ListBean> listNewsBean=new ArrayList<>();

    private MultiTypeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sticky_headers_recycler_view);
        initViews();
        initData();
    }

    private void initViews() {
        /*mSuspensionBar = (RelativeLayout) findViewById(R.id.suspension_bar);
        mSuspensionTv = (TextView) findViewById(R.id.tv_time);*/

        this.rl_head_top = (RelativeLayout) findViewById(R.id.rl_head_top);
        this.green = (ImageView) findViewById(R.id.green);
        this.line = findViewById(R.id.line);
        this.blue = (ImageView) findViewById(R.id.blue);
        this.yellow = (ImageView) findViewById(R.id.yellow);
        this.lineStartEnd = (TextView) findViewById(R.id.start_end);
        this.lineTitle = (TextView) findViewById(R.id.bus_line_title);

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        adapter = new MultiTypeAdapter(this,this,listNewsBean);

        mRecyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                mSuspensionHeight = rl_head_top.getHeight();
            }

            @Override public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (adapter.getItemViewType(mCurrentPosition + 1) == MultiTypeAdapter.ITEM_GROUP) {
                    View view = linearLayoutManager.findViewByPosition(mCurrentPosition + 1);
                    if (view != null) {
                        if (view.getTop() <= mSuspensionHeight) {
                            rl_head_top.setY(-(mSuspensionHeight - view.getTop()));
                        } else {
                            rl_head_top.setY(0);
                        }
                    }
                }

                if (mCurrentPosition != linearLayoutManager.findFirstVisibleItemPosition()) {
                    mCurrentPosition = linearLayoutManager.findFirstVisibleItemPosition();
                    rl_head_top.setY(0);

                    updateSuspensionBar();
                }
            }
        });

        updateSuspensionBar();
    }

    private void updateSuspensionBar() {
        if(listNewsBean.size()>0){
            lineTitle.setText(""+listNewsBean.get(mCurrentPosition).getName());
        }
    }

    private void initData() {
        getBusData();
    }

    private void getBusData() {
        OkRequestParams params = new OkRequestParams();
        params.put("page", 0);
        BaseController.getInstance(this).doPostRequest("https://tour.qinglimedia.com/bus/listBus",params);
    }
    public void getBusChildData(String uuid) {
        OkRequestParams params = new OkRequestParams();
        params.put("bus", uuid);
        BaseController.getInstance(this).doPostRequest("https://tour.qinglimedia.com/bus/listBusRouteLocales",params);
    }

    @Override
    public void showLoadView(String url) {

    }

    @Override
    public void showResultView(String url, String content) {
        if("https://tour.qinglimedia.com/bus/listBus".equals(url)){
            BusLine busLine = AbJsonUtil.fromJson(content, BusLine.class);
            List<BusLine.BodyBean.ResultBean.ListBean> newList = busLine.getBody().getResult().getList();
            for (BusLine.BodyBean.ResultBean.ListBean listBean : newList) {
                listBean.setGroupType(0);
            }
            listNewsBean.addAll(newList);
            adapter.notifyDataSetChanged();
        }else if("https://tour.qinglimedia.com/bus/listBusRouteLocales".equals(url)){
            BusLinePoint busTourListBean = AbJsonUtil.fromJson(content, BusLinePoint.class);
            BusLinePoint busLinePoint = listNewsBean.get(adapter.clickPosition).getBusLinePoint();
            if(busLinePoint==null){
                List<BusLinePoint.BodyBean.ResultBean.ListBean> newList = busTourListBean.getBody().getResult().getList();
                for (BusLinePoint.BodyBean.ResultBean.ListBean listBean : newList) {
                    listBean.setGroupType(1);
                }
                listNewsBean.get(adapter.clickPosition).setBusLinePoint(busTourListBean);
                adapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void showErrorView(String url, String msg) {

    }

    @Override
    public void showProgressView(String url, int progress) {

    }
}

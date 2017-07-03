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


public class VerticalPageSeekBarActivity extends Activity
        implements VerticalPageSeekBar.OnSeekBarPageChangeListener,OnClickListener{

    //页码进度条
    private VerticalPageSeekBar mPageSeekBar;
    //数据源
    private ArrayList<String> mArrayList;
    // 一页最多多少条数据
    protected int mMaxShowLinesPage = 20;
    // 当前是第几页
    protected int mCurrentSelectPageIndex = 0;
    // 当前有多少页
    protected int mPagesCount = 0;
    // 当前的有效记录数
    protected int mRecordCount = 0;
    // 存放每页数据第一条数据的索引
    protected ArrayList<Integer> mEveryPageOffestArray = new ArrayList<Integer>();
    // 当前页面的每一项的偏移数据 方便检索数据和删除数据
    protected ArrayList<Integer> mPageItemsIndex = new ArrayList<Integer>();
    //listview的适配器
    protected ListViewAdapter mAdapter;
    //测试数据的条数
    private int mnTestCount = 230;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_page_seek_bar);
        initDatas();
        initView();
    }

    private void initDatas() {
        if (mArrayList == null) {
            mArrayList = new ArrayList<String>();
            for (int i = 0; i < mnTestCount; i++) {
                mArrayList.add("第   " + String.valueOf(i) + " 项");
            }
        }
    }

    private void initView() {
        mPageSeekBar = (VerticalPageSeekBar)findViewById(R.id.seekBar);
        mPageSeekBar.setSeekBarPageChangeListener(this);

        Button imageviewUp = (Button)findViewById(R.id.imageviewUp);
        imageviewUp.setOnClickListener(this);
        Button imageviewDown = (Button)findViewById(R.id.imageviewDown);
        imageviewDown.setOnClickListener(this);
        ListView listView = (ListView)findViewById(R.id.listView1);
        mAdapter = new ListViewAdapter(this);
        listView.setAdapter(mAdapter);

        initResetListView(0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageviewUp:
                setPrePage();
                break;
            case R.id.imageviewDown:
                setAftPage();
                break;
            default:
                break;
        }
    }

    //初始化进度条管理数据显示
    protected void initResetListView(int pageIndex) {
        mRecordCount = mArrayList.size();

        // 计算有多少页数据
        mPagesCount = mRecordCount/mMaxShowLinesPage + (mRecordCount%mMaxShowLinesPage == 0 ? 0 : 1);

        // 判断 页面数目是2的时候, 简化为1页
        if (mPagesCount == 2) {
            mMaxShowLinesPage = mMaxShowLinesPage * 2;
            mPagesCount = 1;
        } else {
            mMaxShowLinesPage = 20;
        }

        // 设置当前选中也为0
        mCurrentSelectPageIndex = pageIndex;
        if (mCurrentSelectPageIndex >= mPagesCount)
            mCurrentSelectPageIndex = mPagesCount - 1;
        //刷新每一页的首偏移
        setResetEveryPageOffestArray();
        //根据首偏移，得到这一页偏移序号
        setResetPageItemsIndex(mCurrentSelectPageIndex);
        //上下按键翻页，需要同时滚动进度条效果.如果只有两页数据，不显示进度条
        setSelectPageControl(mCurrentSelectPageIndex, mPagesCount,false);
        //总共几页，设置到进度条控件
        mPageSeekBar.setPagesCount(mPagesCount);
    }

    //刷新每一页的首偏移
    protected void setResetEveryPageOffestArray() {
        int nValidItemNums = 0;
        mEveryPageOffestArray.clear();
        //记住每页的首偏移序号
        for (int i = 0; i < mPagesCount; i++) {
            int nRecordIndex = GetCountSpecialPage(i);
            mEveryPageOffestArray.add(nValidItemNums);
            nValidItemNums = nValidItemNums + nRecordIndex;
        }

        if (nValidItemNums != mRecordCount) {
            mRecordCount = nValidItemNums;
            // 计算有多少页数据
            mPagesCount = mRecordCount/mMaxShowLinesPage + (mRecordCount%mMaxShowLinesPage == 0 ? 0 : 1);
        }
    }

    //根据首偏移，得到这一页偏移序号
    protected void setResetPageItemsIndex(int pageIndex) {
        if (pageIndex >= mEveryPageOffestArray.size()) return;
        int pageItemsCount = GetCountSpecialPage(pageIndex);
        int nRecordIndex = mEveryPageOffestArray.get(pageIndex).intValue();
        mPageItemsIndex.clear();
        //首偏移开始累加
        for(int i = nRecordIndex; i < pageItemsCount + nRecordIndex; i++) {
            mPageItemsIndex.add(i);
        }

        //刷新listview的适配器
        if (mAdapter != null) {
            mAdapter.notifyDataSetChanged();
        }
    }

    // 获取当前页面多少数据
    protected int GetCountSpecialPage(int nPage) {
        if (nPage < 0) return 0;
        if(nPage < (mPagesCount-1)) return mMaxShowLinesPage;
        //如果是最后一页，就是总的数据减去前面几页*每一页的数据
        //因为页码是从0开始，所以这里是最后一页
        if (nPage == mPagesCount - 1) return mRecordCount - mMaxShowLinesPage*(mPagesCount-1);
        return 0;
    }

    //上一页
    protected void setPrePage() {
        if (mCurrentSelectPageIndex == 0) return;
        mCurrentSelectPageIndex -= 1;
        //根据首偏移，得到这一页偏移序号
        setResetPageItemsIndex(mCurrentSelectPageIndex);
        // 翻页控件
        setSelectPageControl(mCurrentSelectPageIndex, mPagesCount,true);
    }

    //下一页
    protected void setAftPage() {
        if (mCurrentSelectPageIndex == (mPagesCount-1)) return;
        mCurrentSelectPageIndex += 1;
        //根据首偏移，得到这一页偏移序号
        setResetPageItemsIndex(mCurrentSelectPageIndex);
        // 翻页控件
        setSelectPageControl(mCurrentSelectPageIndex, mPagesCount,true);
    }

    //进度条滑动改变的数据，进行刷新
    protected void setPageChanged(int index, boolean isSetProgress) {
        if (index < 0 || index >= mPagesCount || mCurrentSelectPageIndex == index) return;
        mCurrentSelectPageIndex = index;

        // 刷新每一项的索引数据
        setResetPageItemsIndex(mCurrentSelectPageIndex);
        // 翻页控件
        setSelectPageControl(mCurrentSelectPageIndex, mPagesCount, isSetProgress);
    }

    //上下按键翻页，需要同时滚动进度条效果.如果只有两页数据，不显示进度条
    protected void setSelectPageControl(int index, int count, boolean isSet) {
        View selectPageBar = findViewById(R.id.layoutShow);
        if (selectPageBar != null) {
            //如果只有两页数据，不显示进度条
            if (count <= 1) selectPageBar.setVisibility(View.GONE);
            else selectPageBar.setVisibility(View.VISIBLE);
            //上下按键翻页，需要同时滚动进度条效果
            if (mPageSeekBar != null && isSet == true)
                mPageSeekBar.setProgressSpecialPage(mCurrentSelectPageIndex, mPagesCount);
        }
    }

    //进度条滑动改变的数据，进行刷新
    @Override
    public void setSeekBarPageChanged(int page) {
        setPageChanged(page, false);
    }

    private class ViewHolder{
        TextView textView;
    }

    private class ListViewAdapter extends BaseAdapter{
        private Context mContext;
        private LayoutInflater mLayoutInflater;
        public ListViewAdapter(Context context) {
            mContext = context;
            mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        @Override
        public int getCount() {
            return mPageItemsIndex.size();
        }

        @Override
        public Object getItem(int position) {
            return 0;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder vHolder = null;
            if (convertView == null) {
                vHolder = new ViewHolder();
                convertView = mLayoutInflater.inflate(R.layout.listview_item, null);
                vHolder.textView = (TextView)convertView.findViewById(R.id.textView1);
                convertView.setTag(vHolder);
            }else {
                vHolder = (ViewHolder) convertView.getTag();
            }
            vHolder.textView.setText(mArrayList.get(mPageItemsIndex.get(position).intValue()));
            return convertView;
        }
    }

}


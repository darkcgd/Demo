package com.cgd.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cgd.R;

/**
 * Created by Administrator on 2017/6/11.
 */

public class PullableLayout extends ViewGroup{
    private View header;
    private View footer;
    private TextView tv_status;


    public PullableLayout(Context context) {
        super(context);
        init(context);
    }

    public PullableLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        header= LayoutInflater.from(context).inflate(R.layout.custom_header,null);
        tv_status= (TextView) header.findViewById(R.id.tv_status);

        footer= LayoutInflater.from(context).inflate(R.layout.custom_footer,null);
    }


    private int mLastMoveY;
    private int effectiveScrollY=300;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int y = (int) event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mLastMoveY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int dy = mLastMoveY - y;
                // dy < 0代表是针对下拉刷新的操作
                if(dy < 0) {
                    if(Math.abs(getScrollY()) <= header.getMeasuredHeight() / 2) {
                        scrollBy(0, dy);
                        if(Math.abs(getScrollY()) >= effectiveScrollY){
                            tv_status.setText("松开刷新");
                        }
                    }
                }
                break;
        }

        mLastMoveY = y;
        return true;
    }
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        // 看这里哦，亲
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT);
        header.setLayoutParams(params);
        footer.setLayoutParams(params);
        addView(header);
        addView(footer);
    }

    /**
     //获取模式和大小，边界参数共有3种模式：UNSPECIFIED一般为0, EXACTLY准确尺寸, AT_MOST自适应尺寸
     int w_mode = MeasureSpec.getMode(widthMeasureSpec);
     int w_size = MeasureSpec.getSize(widthMeasureSpec);
     int h_mode = MeasureSpec.getMode(heightMeasureSpec);
     int h_size = MeasureSpec.getSize(heightMeasureSpec);
     //计算自定义的所有子控件的大小
     measureChildren(widthMeasureSpec, heightMeasureSpec);
     //通知父控件，宽高需要多大地方放置子控件
     //setMeasuredDimension(resolveSize(size, widthMeasureSpec),resolveSize(size, heightMeasureSpec));
     setMeasuredDimension(w_size, h_size);
     Log.e("onMeasure","宽mode=" + w_mode + "宽size="+ w_size
     + "高mode=" + h_mode+ "高size=" +h_size);
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            measureChild(childAt,widthMeasureSpec,heightMeasureSpec);
        }
    }

    /**
     * 详看drawable下的onlayout.png
     1）参数changed表示view有新的尺寸或位置；
     2）参数l表示相对于父view的Left位置；
     3）参数t表示相对于父view的Top位置；
     4）参数r表示相对于父view的Right位置；
     5）参数b表示相对于父view的Bottom位置。.
     */
    //在这里定义了一个变量mLayoutContentHeight用来记录内容视图部分的实际总高度。需要注意的是，要在onLayout开头的地方将其置零，否则同样会因为重复累加得到错误的结果。
    private int mLayoutContentHeight;
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        mLayoutContentHeight = 0;
        //置位
        for (int i = 0; i < getChildCount(); i++){
            View child = getChildAt(i);
            if (child == header) { // 头视图隐藏在顶端
                child.layout(0, 0 - child.getMeasuredHeight(), child.getMeasuredWidth(), 0);
            } else if (child == footer) { // 尾视图隐藏在layout所有内容视图之后
                child.layout(0, mLayoutContentHeight, child.getMeasuredWidth(), mLayoutContentHeight + child.getMeasuredHeight());
            } else { // 内容视图根据定义(插入)顺序,按由上到下的顺序在垂直方向进行排列
                child.layout(0, mLayoutContentHeight, child.getMeasuredWidth(), mLayoutContentHeight + child.getMeasuredHeight());
                mLayoutContentHeight += child.getMeasuredHeight();
            }
        }
    }

}

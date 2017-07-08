package com.cgd.activity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.cgd.R;
import com.cgd.widget.MyScrollView;
import com.darkcgd.library.AbToastUtil;

public class ScrollViewToTopActivity extends AppCompatActivity implements MyScrollView.ScrollListener {

    RelativeLayout viewSpace;
    RelativeLayout stickView;
    LinearLayout ll_content;
    LinearLayout ll_content_new;
    MyScrollView myScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view_to_top);
        myScrollView = (MyScrollView) findViewById(R.id.scroll_view);
        myScrollView.registerListener(this);
        viewSpace = (RelativeLayout) findViewById(R.id.stick_view_space);
        stickView = (RelativeLayout) findViewById(R.id.stick_view);
        ll_content = (LinearLayout) findViewById(R.id.ll_content);
        ll_content_new = (LinearLayout) findViewById(R.id.ll_content_new);

        stickView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            //当布局文件加载完成时，会调用该方法
            @Override
            public void onGlobalLayout() {
                //初始化stickView的位置
                onScroll(0,0);
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ll_content.setVisibility(View.GONE);
                ll_content_new.setVisibility(View.VISIBLE);

                ViewGroup.MarginLayoutParams paramsAddVideoLayoutNew = (ViewGroup.MarginLayoutParams) ll_content.getLayoutParams();
                int topMargin = paramsAddVideoLayoutNew.topMargin;

                AbToastUtil.showToast(ScrollViewToTopActivity.this,"topMargin:"+topMargin);
            }
        }, 3000);
    }

    @Override
    public void onScroll(int top, int left) {
        /**
         * 根据scrollView的滑动距离，来动态移动stickView
         * setTranslationY(x) 当x为正数的时候stickView是向下移动的
         * 开始时 top< viewSpace.getTop() 所以stickView 的位置一直与viewSpace位置重合，随着ScrollView一起滑动
         * 当用户手动向上滑动MyScrollView的时候，stickView（或viewSpace）处于顶部的时候，此时top > viewSpace.getTop()
         * stickView就会相对scrollView向下运动，又因为scrollView是向下运动的，所以相对手机屏幕就是静止的啦，看起来就是悬浮在顶部
         */
        Log.i("=======onScrollChanged","top:"+top+":::left="+left);
        stickView.setTranslationY(Math.max(top, viewSpace.getTop()));
    }
}

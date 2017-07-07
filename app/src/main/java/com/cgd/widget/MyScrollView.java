package com.cgd.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ScrollView;
/**
 * Created by cgd on 17/7/6.
 */

public class MyScrollView extends ScrollView{

    private ScrollListener scrollListener;

    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        Log.e("Tag", "l = " + l + ", t = " + t + ", oldl =" + oldl + ",oldt =" + oldt);
        if (scrollListener != null) {
            scrollListener.onScroll(t, l);
        }
    }

    public void registerListener(ScrollListener scrollListener){
        this.scrollListener = scrollListener;
    }


    public interface ScrollListener{
        void onScroll(int t,int l);
    }
}
package com.cgd.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.cgd.TheApp;

/**
 * Created by Administrator on 2017/6/17.
 */

public class CustomCanvaCircle extends View{
    private Paint mPaint;

    public CustomCanvaCircle(Context context) {
        super(context);
        init(context);
    }

    public CustomCanvaCircle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        initView();
    }

    private int centerX;
    private int centerY;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(isOnDraw){
            /**
             cx：圆心的x坐标。
             cy：圆心的y坐标。
             radius：圆的半径。
             paint：绘制时所使用的画笔。
             */
            if(radius <= TheApp.screenWidth/2){
                //canvas.drawColor(Color.WHITE);                  //白色背景
                canvas.drawCircle(centerX,centerY,radius,mPaint);
                handler.sendEmptyMessage(0);
                //500-524              500
                //525               500
                if(radius>=TheApp.screenWidth/8&&radius<TheApp.screenWidth/8+addRadius){
                    handler.sendEmptyMessage(1);
                }

            } else{
                canvas.drawColor(Color.parseColor("#083a6d"));                  //白色背景
                isOnDraw=false;


            /*String testString = "已更新10条咨询";
            Paint mPaint = new Paint();
            mPaint.setStrokeWidth(3);
            mPaint.setTextSize(50);
            mPaint.setColor(Color.WHITE);
            mPaint.setTextAlign(Paint.Align.LEFT);
            Rect bounds = new Rect();
            mPaint.getTextBounds(testString, 0, testString.length(), bounds);
            canvas.drawText(testString, getMeasuredWidth()/2 - bounds.width()/2, getMeasuredHeight()/2 + bounds.height()/2, mPaint);*/
            }
        }else{
            //canvas.drawColor(Color.WHITE);                  //白色背景
        }
    }


    private int addRadius=25;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            int what = msg.what;
            switch (what){
                case 0:
                    //改变半径大小，并且半径一直加上5
                    radius += addRadius;
                    mPaint.setStrokeWidth(radius / 3);
                    //改变透明度
                    int alpha = mPaint.getAlpha();
                    alpha -= 5;//透明度不断减去5
                    //设置透明度
                    // mPaint.setAlpha(alpha);
                    //调用onDraw方法
                    invalidate();
                    break;
                case 1:
                    if(showTextAnimation!=null){
                        showTextAnimation.showText();
                    }
                    break;
                default:
                    break;
            }

        }
    };


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        centerX = getMeasuredWidth() / 2;
        centerY = getMeasuredHeight() / 2;
    }

    private int radius = 5;//这是设置内圆的半径，并且设置为全局变量

    public void initView() {
        mPaint = new Paint();//定义一个画笔
        mPaint.setColor(Color.parseColor("#083a6d"));//设置画笔的颜色，画笔的颜色决定了画出来是什么颜色的圆环
        //定义抗锯齿
        mPaint.setAntiAlias(true);
        //设置样式
        mPaint.setStyle(Paint.Style.FILL);//
        //设置默认的透明度
        mPaint.setAlpha(250);
        radius = 5;//这是设置内圆的半径，并且设置为全局变量
        mPaint.setStrokeWidth(radius / 3);//外圆的半径减去内圆的半径的结果值，也就是圆环的半径，我这里设置为内圆半径的三分之一
    }

    private boolean isOnDraw;
    public void start(){
        isOnDraw=true;
        initView();//重新调用initView()方法，重新绘制圆
        invalidate();//调用onDraw方法
    }

    float downY;
    float downX;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN://按下
                //isOnDraw=true;
                //downX = event.getX();//获取按下时的x坐标
                //downY = event.getY();//获取按下时的y坐标
                //initView();//重新调用initView()方法，重新绘制圆
                //invalidate();//调用onDraw方法
                break;
            case MotionEvent.ACTION_MOVE://移动
                break;
            case MotionEvent.ACTION_UP://离开
                break;
        }
        return true;
    }

    private ShowTextAnimation showTextAnimation;
    public void setShowTextAnimation(ShowTextAnimation showTextAnimation){
        this.showTextAnimation=showTextAnimation;
    }
    public interface ShowTextAnimation{
        void showText();
    }
}
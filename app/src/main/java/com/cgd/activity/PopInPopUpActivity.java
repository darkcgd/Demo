package com.cgd.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.cgd.BaseActivity;
import com.cgd.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PopInPopUpActivity extends BaseActivity implements View.OnClickListener{
    @Bind(R.id.bt)
    Button bt;
    @Bind(R.id.rl_head)
    RelativeLayout rl_head;
    @Bind(R.id.rl_bottom)
    RelativeLayout rl_bottom;

    @Override
    protected void createPresenter() {

    }

    @Override
    protected void initLayout() {
        setContentView(R.layout.activity_pop_in_pop_up);
        ButterKnife.bind(this);
    }

    @Override
    protected void initViews() {
        showOrHideHeadLayout(true);//是否隐藏 true隐藏
    }

    @Override
    protected void initDatas() {

    }

    @Override
    protected void setListeners() {
        bt.setOnClickListener(this);
    }

    private boolean isShow;
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt:
                isShow=!isShow;
                showOrHideHeadLayout(isShow);
                showOrHideBottomLayout(isShow);
                //showOrHideRlChangeFontLayout(isShow);
                break;
            default:
                break;
        }
    }

    private ObjectAnimator moveHeadShow;
    private ObjectAnimator moveHeadHide;
    private void showOrHideHeadLayout(boolean isShow){//是否隐藏 true隐藏 false显示
        int headHeight = rl_head.getMeasuredHeight();
        if(headHeight==0){
            headHeight=200;
        }
        if (isShow) {
            if(moveHeadShow==null){
                moveHeadShow = ObjectAnimator.ofFloat(rl_head, "translationY", 0f, -headHeight);
                moveHeadShow.setDuration(200);
                moveHeadShow.setInterpolator(new LinearInterpolator());
            }
            moveHeadShow.start();
        } else {
            if(moveHeadHide==null){
                moveHeadHide = ObjectAnimator.ofFloat(rl_head, "translationY", -headHeight, 0f);
                moveHeadHide.setDuration(200);
                moveHeadHide.setInterpolator(new LinearInterpolator());
            }
            moveHeadHide.start();
        }
    }
    private ObjectAnimator moveBottomShow;
    private ObjectAnimator moveBottomHide;
    private void showOrHideBottomLayout(boolean isShow){//是否隐藏 true隐藏 false显示
        int bottomHeight = rl_bottom.getMeasuredHeight();
        if(bottomHeight==0){
            bottomHeight=200;
        }
        if (isShow) {
            if(moveBottomShow==null){
                moveBottomShow = ObjectAnimator.ofFloat(rl_bottom, "translationY", 0f, bottomHeight);
                moveBottomShow.setDuration(200);
                moveBottomShow.setInterpolator(new LinearInterpolator());
            }
            moveBottomShow.start();
        } else {
            if(moveBottomHide==null){
                moveBottomHide = ObjectAnimator.ofFloat(rl_bottom, "translationY", bottomHeight, 0f);
                moveBottomHide.setDuration(200);
                moveBottomHide.setInterpolator(new LinearInterpolator());
            }
            moveBottomHide.start();
        }
    }

    private void showOrHideRlChangeFontLayout(boolean isShow) {
        int headHeight = rl_head.getMeasuredHeight();
        int bottomHeight = rl_bottom.getMeasuredHeight();

        if (isShow) {//隐藏
            ObjectAnimator moveHead = ObjectAnimator.ofFloat(rl_head, "translationY", 0f, -headHeight);
            ObjectAnimator alphaHead = ObjectAnimator.ofFloat(rl_head, "alpha", 1f, 0.5f);
          /*  moveHead.setDuration(200);
            moveHead.setInterpolator(new LinearInterpolator());
            moveHead.start();*/
            AnimatorSet animSetHead = new AnimatorSet();
            animSetHead.play(moveHead).with(alphaHead);
            animSetHead.setDuration(200);
            animSetHead.start();

            ObjectAnimator moveBottom = ObjectAnimator.ofFloat(rl_bottom, "translationY", 0f, headHeight);
            ObjectAnimator alphaBottom = ObjectAnimator.ofFloat(rl_head, "alpha", 1f, 0f);
           /* moveBottom.setDuration(200);
            moveBottom.setInterpolator(new LinearInterpolator());
            moveBottom.start();*/
            AnimatorSet animSetBottom = new AnimatorSet();
            animSetBottom.play(moveBottom).with(alphaBottom);
            animSetBottom.setDuration(200);
            animSetBottom.start();

        } else {
            ObjectAnimator moveHead = ObjectAnimator.ofFloat(rl_head, "translationY", -bottomHeight, 0f);
            ObjectAnimator alphaHead = ObjectAnimator.ofFloat(rl_head, "alpha", 0f, 1.0f);
          /*  moveHead.setDuration(200);
            moveHead.setInterpolator(new LinearInterpolator());
            moveHead.start();*/
            AnimatorSet animSetHead = new AnimatorSet();
            animSetHead.play(moveHead).with(alphaHead);
            animSetHead.setDuration(200);
            animSetHead.start();

            ObjectAnimator moveBottom = ObjectAnimator.ofFloat(rl_bottom, "translationY", bottomHeight, 0f);
            ObjectAnimator alphaBottom = ObjectAnimator.ofFloat(rl_head, "alpha", 0f, 1.0f);
           /* moveBottom.setDuration(200);
            moveBottom.setInterpolator(new LinearInterpolator());
            moveBottom.start();*/
            AnimatorSet animSetBottom = new AnimatorSet();
            animSetBottom.play(moveBottom).with(alphaBottom);
            animSetBottom.setDuration(200);
            animSetBottom.start();
        }
    }
}

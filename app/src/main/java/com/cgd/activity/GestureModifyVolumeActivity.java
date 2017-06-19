package com.cgd.activity;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.view.GestureDetector.OnGestureListener;
import android.widget.*;

import com.cgd.R;
import com.cgd.util.DateTools;
import com.cgd.util.DensityUtil;

public class GestureModifyVolumeActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,View.OnTouchListener {

    /** 手势改变视频进度,音量,亮度 */
    private RelativeLayout root_layout;// 根布局
    private RelativeLayout gesture_volume_layout;// 音量控制布局,亮度控制布局
    private TextView geture_tv_volume_percentage;// 音量百分比,亮度百分比
    private ImageView gesture_iv_player_volume;// 音量图标,亮度图标
    private GestureDetector gestureDetector;
    private AudioManager audiomanager;
    private int maxVolume, currentVolume;
    private static final float STEP_VOLUME = 1f;// 协调音量滑动时的步长，避免每次滑动都改变，导致改变过快
    private boolean firstScroll = false;// 每次触摸屏幕后，第一次scroll的标志

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_modify_volume);

        initView();
    }

    private void initView() {

        // ****************音量/进度/亮度*********************
        root_layout = (RelativeLayout) findViewById(R.id.root_layout);
        gesture_volume_layout = (RelativeLayout) findViewById(R.id.gesture_volume_layout);
        geture_tv_volume_percentage = (TextView) findViewById(R.id.geture_tv_volume_percentage);
        gesture_iv_player_volume = (ImageView) findViewById(R.id.gesture_iv_player_volume);
        gestureDetector = new GestureDetector(this, this);
        root_layout.setLongClickable(true);
        gestureDetector.setIsLongpressEnabled(true);
        root_layout.setOnTouchListener(this);
        audiomanager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        maxVolume = audiomanager.getStreamMaxVolume(AudioManager.STREAM_MUSIC); // 获取系统最大音量
        currentVolume = audiomanager.getStreamVolume(AudioManager.STREAM_MUSIC); // 获取当前值
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        // 手势里除了singleTapUp，没有其他检测up的方法
        if (event.getAction() == MotionEvent.ACTION_UP) {
            gesture_volume_layout.setVisibility(View.GONE);
        }
        return gestureDetector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        firstScroll = true;// 设定是触摸屏幕后第一次scroll的标志
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        float mOldX = e1.getX(), mOldY = e1.getY();
        int y = (int) e2.getRawY();
        if (firstScroll) {// 以触摸屏幕后第一次滑动为标准，避免在屏幕上操作切换混乱
            // 横向的距离变化大则调整进度，纵向的变化大则调整音量
            if (Math.abs(distanceX) >= Math.abs(distanceY)) {
                gesture_volume_layout.setVisibility(View.GONE);
            } else {
                gesture_volume_layout.setVisibility(View.VISIBLE);

            }
        }
            currentVolume = audiomanager.getStreamVolume(AudioManager.STREAM_MUSIC); // 获取当前值
            if (Math.abs(distanceY) > Math.abs(distanceX)) {// 纵向移动大于横向移动
                if (distanceY >= DensityUtil.dip2px(this, STEP_VOLUME)) {// 音量调大,注意横屏时的坐标体系,尽管左上角是原点，但横向向上滑动时distanceY为正
                    if (currentVolume < maxVolume) {// 为避免调节过快，distanceY应大于一个设定值
                        currentVolume++;
                    }
                    gesture_iv_player_volume.setImageResource(R.drawable.souhu_player_volume);
                } else if (distanceY <= -DensityUtil.dip2px(this, STEP_VOLUME)) {// 音量调小
                    if (currentVolume > 0) {
                        currentVolume--;
                        if (currentVolume == 0) {// 静音，设定静音独有的图片
                            gesture_iv_player_volume.setImageResource(R.drawable.souhu_player_silence);
                        }
                    }
                }
                int percentage = (currentVolume * 100) / maxVolume;
                geture_tv_volume_percentage.setText(percentage + "%");
                audiomanager.setStreamVolume(AudioManager.STREAM_MUSIC,currentVolume, 0);
            }

        firstScroll = false;// 第一次scroll执行完成，修改标志
        return false;
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {}

    @Override
    public void onShowPress(MotionEvent e) {}
}
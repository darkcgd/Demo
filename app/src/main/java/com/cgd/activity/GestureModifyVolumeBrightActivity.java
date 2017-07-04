package com.cgd.activity;

import android.content.Context;
import android.media.AudioManager;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.cgd.R;
import com.cgd.TheApp;
import com.cgd.util.DateTools;
import com.cgd.util.DensityUtil;
import com.cgd.widget.MyVideoView;
import com.cgd.widget.VerticalPageSeekBar;

public class GestureModifyVolumeBrightActivity extends FragmentActivity implements GestureDetector.OnGestureListener,View.OnTouchListener {

    /** 手势改变视频进度,音量,亮度 */
    private RelativeLayout root_layout;// 根布局
    private LinearLayout ll_gesture_volume, ll_gesture_bright;// 音量控制布局,亮度控制布局
    private VerticalPageSeekBar seekBar_volume,seekBar_bright;
    private GestureDetector gestureDetector;
    private AudioManager audiomanager;
    private int maxVolume, currentVolume;
    private float mBrightness = -1f; // 亮度
    private static final float STEP_VOLUME = 2f;// 协调音量滑动时的步长，避免每次滑动都改变，导致改变过快
    private boolean firstScroll = false;// 每次触摸屏幕后，第一次scroll的标志
    private int GESTURE_FLAG = 0;// 1,调节进度，2，调节音量,3.调节亮度
    private static final int GESTURE_MODIFY_PROGRESS = 1;
    private static final int GESTURE_MODIFY_VOLUME = 2;
    private static final int GESTURE_MODIFY_BRIGHT = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_modify_volume_bright);
        initView();
    }

    private void initView() {
        // ****************音量/进度/亮度*********************
        root_layout = (RelativeLayout) findViewById(R.id.root_layout);
        ll_gesture_volume = (LinearLayout) findViewById(R.id.ll_gesture_volume);
        ll_gesture_bright = (LinearLayout) findViewById(R.id.ll_gesture_bright);
        seekBar_volume = (VerticalPageSeekBar) findViewById(R.id.seekBar_volume);
        seekBar_bright = (VerticalPageSeekBar) findViewById(R.id.seekBar_bright);
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
            GESTURE_FLAG = 0;// 手指离开屏幕后，重置调节音量或进度的标志
            ll_gesture_volume.setVisibility(View.GONE);
            ll_gesture_bright.setVisibility(View.GONE);
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
                ll_gesture_volume.setVisibility(View.GONE);
                ll_gesture_bright.setVisibility(View.GONE);
                GESTURE_FLAG = GESTURE_MODIFY_PROGRESS;
            } else {
                if (mOldX > TheApp.screenWidth * 3.0 / 5) {// 音量
                    ll_gesture_volume.setVisibility(View.VISIBLE);
                    ll_gesture_bright.setVisibility(View.GONE);
                    GESTURE_FLAG = GESTURE_MODIFY_VOLUME;
                } else if (mOldX < TheApp.screenWidth * 2.0 / 5) {// 亮度
                    ll_gesture_bright.setVisibility(View.VISIBLE);
                    ll_gesture_volume.setVisibility(View.GONE);
                    GESTURE_FLAG = GESTURE_MODIFY_BRIGHT;
                }
            }
        }
       if (GESTURE_FLAG == GESTURE_MODIFY_VOLUME) {
            currentVolume = audiomanager.getStreamVolume(AudioManager.STREAM_MUSIC); // 获取当前值
            if (Math.abs(distanceY) > Math.abs(distanceX)) {// 纵向移动大于横向移动
                if (distanceY >= DensityUtil.dip2px(this, STEP_VOLUME)) {// 音量调大,注意横屏时的坐标体系,尽管左上角是原点，但横向向上滑动时distanceY为正
                    if (currentVolume < maxVolume) {// 为避免调节过快，distanceY应大于一个设定值
                        currentVolume++;
                    }
                    //gesture_iv_player_volume.setImageResource(R.drawable.souhu_player_volume);
                } else if (distanceY <= -DensityUtil.dip2px(this, STEP_VOLUME)) {// 音量调小
                    if (currentVolume > 0) {
                        currentVolume--;
                        if (currentVolume == 0) {// 静音，设定静音独有的图片
                            //gesture_iv_player_volume.setImageResource(R.drawable.souhu_player_silence);
                        }
                    }
                }
                int percentage = (currentVolume * 100) / maxVolume;
                //geture_tv_volume_percentage.setText(percentage + "%");
                seekBar_volume.setProgressSpecialPage(percentage,100);
                audiomanager.setStreamVolume(AudioManager.STREAM_MUSIC,currentVolume, 0);
            }
        }
        // 如果每次触摸屏幕后第一次scroll是调节亮度，那之后的scroll事件都处理亮度调节，直到离开屏幕执行下一次操作
        else if (GESTURE_FLAG == GESTURE_MODIFY_BRIGHT) {
            //gesture_iv_player_bright.setImageResource(R.drawable.souhu_player_bright);
            if (mBrightness < 0) {
                mBrightness = getWindow().getAttributes().screenBrightness;
                if (mBrightness <= 0.00f)
                    mBrightness = 0.50f;
                if (mBrightness < 0.01f)
                    mBrightness = 0.01f;
            }
            WindowManager.LayoutParams lpa = getWindow().getAttributes();
            lpa.screenBrightness = mBrightness + (mOldY - y) / TheApp.screenHeight;
            if (lpa.screenBrightness > 1.0f)
                lpa.screenBrightness = 1.0f;
            else if (lpa.screenBrightness < 0.01f)
                lpa.screenBrightness = 0.01f;
            getWindow().setAttributes(lpa);
            //geture_tv_bright_percentage.setText((int) (lpa.screenBrightness * 100) + "%");
           seekBar_bright.setProgressSpecialPage((int) (lpa.screenBrightness * 100),100);
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
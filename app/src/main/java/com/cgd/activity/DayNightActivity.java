package com.cgd.activity;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cgd.R;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DayNightActivity extends AppCompatActivity {
    @Bind(R.id.root)
    RelativeLayout root;
    @Bind(R.id.bt)
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_night);
        ButterKnife.bind(this);
        initTag(root);
    }

    private Map<String,Object> map=new HashMap<>();
    private void initTag(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            int id = childAt.getId();
            if (childAt instanceof TextView){
                map.put(""+id,((TextView) childAt).getCurrentTextColor());
            } else if (childAt instanceof ViewGroup) {
                // 若是布局控件（LinearLayout或RelativeLayout）,继续查询子View
                this.initTag((ViewGroup) childAt);
                Drawable background = ((ViewGroup) childAt).getBackground();
                if(background!=null){
                    map.put(""+id,background);
                }else{
                    map.put(""+id,null);
                }
            }


        }
    }

    private boolean isDay;
    @OnClick(R.id.bt)
    public void clickBt(View v){
        if(isDay)
            bt.setText("切换成夜间模式");
        else
            bt.setText("切换成日间模式");

        if(isDay){//日间模式
            root.setBackgroundColor(getResources().getColor(R.color.color3A3A3A));
        }else{//夜间模式
            root.setBackgroundColor(getResources().getColor(R.color.main_bg));
        }

        setDayNightMode(root,isDay);
        isDay=!isDay;
    }

    private void setDayNightMode(ViewGroup viewGroup,boolean isDay) {
        int childCount = viewGroup.getChildCount();

        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            int id = childAt.getId();
            Object object = map.get("" + id);
            if (childAt instanceof TextView){
                if(isDay){//日间模式
                    if(object!=null){
                        int mCurTextColor=(int)object;
                        ((TextView) childAt).setTextColor(mCurTextColor);
                    }else{
                        ((TextView) childAt).setTextColor(getResources().getColor(R.color.color8A9599));
                    }
                }else{//夜间模式
                    ((TextView) childAt).setTextColor(getResources().getColor(R.color.white));
                }
            }else if (childAt instanceof ViewGroup) {
                if(isDay){//日间模式
                    if(object!=null){
                        Drawable background =(Drawable)object;
                        if (background instanceof ColorDrawable) {
                            ColorDrawable colorDrawable =(ColorDrawable)object;
                            ((ViewGroup) childAt).setBackgroundColor(colorDrawable.getColor());
                        } else {
                            ((ViewGroup) childAt).setBackground(background);
                        }
                    }
                }else{
                    ((ViewGroup) childAt).setBackgroundColor(getResources().getColor(R.color.color3A3A3A));
                }

                // 若是布局控件（LinearLayout或RelativeLayout）,继续查询子View
                this.setDayNightMode((ViewGroup) childAt,isDay);
            }


        }
    }
}

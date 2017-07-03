package com.cgd;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.cgd.activity.DayNightActivity;
import com.cgd.activity.GestureModifyVolumeActivity;
import com.cgd.activity.GestureModifyVolumeBrightActivity;
import com.cgd.activity.MVPActivity;
import com.cgd.activity.PopInPopUpActivity;
import com.cgd.activity.PullRefreshActivity;
import com.cgd.activity.RetrofitActivity;
import com.cgd.activity.RippleActivity;
import com.cgd.activity.RxjavaActivity;
import com.cgd.activity.SceenChangeActivity;
import com.cgd.activity.VerticalPageSeekBarActivity;
import com.cgd.bean.Params;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<Params> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();
        mRecyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
        MainAdapter adapter=new MainAdapter(this,list);
        mRecyclerView.setAdapter(adapter);
    }

    private void getData() {
        list.add(new Params("下拉刷新",PullRefreshActivity.class));
        list.add(new Params("屏幕旋转",SceenChangeActivity.class));
        list.add(new Params("手势滑动调节音量",GestureModifyVolumeActivity.class));
        list.add(new Params("手势滑动调节音量亮度快进快退",GestureModifyVolumeBrightActivity.class));
        list.add(new Params("水波纹效果",RippleActivity.class));
        list.add(new Params("MVP",MVPActivity.class));
        list.add(new Params("Rxjava",RxjavaActivity.class));
        list.add(new Params("淡入淡出",PopInPopUpActivity.class));
        list.add(new Params("Retrofit",RetrofitActivity.class));
        list.add(new Params("夜间模式",DayNightActivity.class));
        list.add(new Params("垂直SeekBar",VerticalPageSeekBarActivity.class));
    }


    class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

        private Context context;
        private List<Params> list;

        public MainAdapter(Context context, List<Params> list) {
            this.context=context;
            this.list=list;
        }

        @Override
        public MainViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            MainViewHolder holder = new MainViewHolder(LayoutInflater.from(context).inflate(R.layout.item_home, viewGroup,false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MainViewHolder holder, final int position) {
            String content = list.get(position).getContent();
            holder.bt.setText(content);
            holder.bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context,list.get(position).getClazz()));
                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class MainViewHolder extends RecyclerView.ViewHolder {

            Button bt;

            public MainViewHolder(View view) {
                super(view);
                bt = (Button) view.findViewById(R.id.bt);
            }
        }
    }
}

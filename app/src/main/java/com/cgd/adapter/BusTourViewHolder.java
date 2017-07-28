package com.cgd.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cgd.R;
import com.cgd.widget.expandablerecyclerview.holder.BaseViewHolder;


/**
 * author：Drawthink
 * describe：
 * date: 2017/5/22
 */

public class BusTourViewHolder extends BaseViewHolder {

    RelativeLayout rl_group_item;
    TextView lineTitle, lineStartEnd;
    ImageView yellow, blue, green;
    View line;

     LinearLayout mLine_btn_bus;
     LinearLayout mLine_bus_station;
     ImageView mPoint_img;
     ImageView mType;
     TextView mPoint_name;
     TextView mPoint_descrition;
     RelativeLayout mRoot;


    public BusTourViewHolder(Context ctx, View itemView, int viewType) {
        super(ctx,itemView, viewType);
        this.rl_group_item = (RelativeLayout) itemView.findViewById(R.id.rl_group_item);
        this.green = (ImageView) itemView.findViewById(R.id.green);
        this.line = itemView.findViewById(R.id.line);
        this.blue = (ImageView) itemView.findViewById(R.id.blue);
        this.yellow = (ImageView) itemView.findViewById(R.id.yellow);
        this.lineStartEnd = (TextView) itemView.findViewById(R.id.start_end);
        this.lineTitle = (TextView) itemView.findViewById(R.id.bus_line_title);

        mLine_btn_bus = (LinearLayout) itemView.findViewById(R.id.line_btn_bus);
        mRoot = (RelativeLayout) itemView.findViewById(R.id.root);
        mLine_bus_station = (LinearLayout) itemView.findViewById(R.id.line_bus_station);
        mPoint_img = (ImageView) itemView.findViewById(R.id.point_img);
        mType = (ImageView) itemView.findViewById(R.id.type);
        mPoint_name = (TextView) itemView.findViewById(R.id.point_name);
        mPoint_descrition = (TextView) itemView.findViewById(R.id.point_descrition);
    }

    @Override
    public int getGroupViewResId() {
        return R.id.rl_group_item;
    }

    @Override
    public int getChildViewResId() {
        return R.id.parent;
    }
}

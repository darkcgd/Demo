package com.cgd.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cgd.R;
import com.cgd.bean.BusLine;
import com.cgd.bean.BusLinePoint;
import com.cgd.mvc.BaseController;
import com.cgd.mvc.IResultView;
import com.cgd.mvc.OkRequestParams;
import com.cgd.widget.expandablerecyclerview.adapter.BaseRecyclerViewAdapter;
import com.cgd.widget.expandablerecyclerview.bean.RecyclerViewData;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BusTourAdapter extends BaseRecyclerViewAdapter<BusLine.BodyBean.ResultBean.ListBean, BusLinePoint.BodyBean.ResultBean.ListBean,BusTourViewHolder> {

  private Context ctx;
  private LayoutInflater mInflater;

  private List<RecyclerViewData> datas;

  public BusTourAdapter(Context ctx, List<RecyclerViewData> datas) {
    super(ctx, datas);
    mInflater = LayoutInflater.from(ctx);
    this.ctx = ctx;
    this.datas = datas;
  }


  public void updateView(List<RecyclerViewData> datas){
    this.datas = datas;
    notifyDataSetChanged();
  }

  /**
   * head View数据设置
   * @param holder
   * @param groupPos
   * @param position
   * @param groupData
   */
  @Override
  public void onBindGroupHolder(BusTourViewHolder holder, int groupPos,int position,BusLine.BodyBean.ResultBean.ListBean groupData) {
    //holder.tvTitle.setText(groupData);
    holder.lineTitle.setText(groupData.getName());
    holder.lineStartEnd.setText(groupData.getFront_name() + "/" + groupData.getTerminal_name());
    if (groupData.getTypes() != null && groupData.getTypes().length() > 0) {
      String[] type = groupData.getTypes().split(",");
            /*全部gone*/
      holder.yellow.setVisibility(View.GONE);
      holder.green.setVisibility(View.GONE);
      holder.blue.setVisibility(View.GONE);
      for (String t : type) {
        switch (t) {
                    /*历史 黄*/
          case "0":
            holder.yellow.setVisibility(View.VISIBLE);
            break;
                    /*建筑 绿*/
          case "1":
            holder.green.setVisibility(View.VISIBLE);
            break;
                    /*景点 蓝*/
          case "2":
            holder.blue.setVisibility(View.VISIBLE);
            break;
        }
      }
    } else {
            /*如果为空就显示一个默认的黄色 历史古迹*/
      holder.yellow.setVisibility(View.VISIBLE);
    }

  }

  /**
   * child View数据设置
   * @param holder
   * @param groupPos
   * @param childPos
   * @param position
   * @param childData
   */
  @Override
  public void onBindChildpHolder(BusTourViewHolder holder, int groupPos,int childPos,int position, BusLinePoint.BodyBean.ResultBean.ListBean childData) {
    holder.mPoint_name.setText(childData.getTitle());
    holder.mPoint_descrition.setText(childData.getThumb_content());
    if (childData.getCover() != null && childData.getCover().length() > 0) {
      Picasso.with(ctx).load(childData.getCover()).centerCrop().resize(303, 303).into(holder.mPoint_img);
    }
    switch (childData.getType()) {
      case 0:
        holder.mType.setImageResource(R.mipmap.bus_historic_sites_nocircle);
        break;
      case 1:
        holder.mType.setImageResource(R.mipmap.bus_natural_scenery_nocircle);
        break;
      case 2:
        holder.mType.setImageResource(R.mipmap.bus_institutional_revolution_nocircle);
        break;
      default:
        holder.mType.setImageResource(R.mipmap.bus_historic_sites_nocircle);
        break;
    }
        /*去路线界面*/
    /*child.mLine_btn_bus.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
                *//*这个消息发往 mainActivity，*//*
        EventBusResultBean busResultBean = new EventBusResultBean("main", "openMapFragmeng");
        EventBus.getDefault().post(busResultBean);
        Intent intent = new Intent(mContext, BusTourMapActivity.class);
        intent.putExtra("uuid", mZhiNanPartent.get(groupPosition).getUuid());
        intent.putExtra("name", mZhiNanPartent.get(groupPosition).getName());
        intent.putExtra("mapuid", mZhiNanPartent.get(groupPosition).getMapUid());
        intent.putExtra("from", "busTour");
        ctx.startActivity(intent);
      }
    });
        *//*去导航页面，找到最近的车站*//*
    holder.mLine_bus_station.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        int[] list = PackegForMap.checkMapClient();
        if (list.length <= 0) {
          ToastUtils.show("你还没有安装地图客户端，无法跳转导航！");
        } else {
          getBusStation.getStation(groupPosition, mZhiNanPartent.get(groupPosition).getUuid());
        }
      }
    });*/
    if (childPos == 0) {
      holder.mRoot.setVisibility(View.VISIBLE);
    } else {
      holder.mRoot.setVisibility(View.GONE);
    }
  }

  @Override
  public View getGroupView(ViewGroup parent) {
    return mInflater.inflate(R.layout.item_busline,parent,false);
  }

  @Override
  public View getChildView(ViewGroup parent) {
    return mInflater.inflate(R.layout.item_busline_child,parent,false);
  }

  @Override
  public BusTourViewHolder createRealViewHolder(Context ctx, View view, int viewType) {
    return new BusTourViewHolder(ctx,view,viewType);
  }

  /**
   * true 全部可展开
   * fasle  同一时间只能展开一个
   * */
  @Override
  public boolean canExpandAll() {
    return false;
  }
}

package com.cgd.adapter;

import android.content.Context;
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
import com.cgd.mvc.BaseController;
import com.cgd.mvc.IResultView;
import com.cgd.mvc.OkRequestParams;

import java.util.List;

public class MultiTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  private LayoutInflater mLayoutInflater;
  private Context context;
  private IResultView mIResultView;
  private List<BusLine.BodyBean.ResultBean.ListBean> listNewsBean;

  Object tag = new Object();

  public int clickPosition;

  public final static int ITEM_GROUP=1;
  public final static int ITEM_CHILD=2;

  public MultiTypeAdapter(Context context, IResultView mIResultView, List<BusLine.BodyBean.ResultBean.ListBean> listNewsBean) {
    this.listNewsBean = listNewsBean;
    this.context = context;
    this.mIResultView = mIResultView;
    mLayoutInflater = LayoutInflater.from(context);
  }

  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    //加载Item View的时候根据不同TYPE加载不同的布局
    if (viewType == ITEM_GROUP) {
      return new GroupViewHolder(mLayoutInflater.inflate(R.layout.item_busline, parent, false));
    } else if (viewType == ITEM_CHILD) {
      return new ChildViewHolder(mLayoutInflater.inflate(R.layout.item_busline_child, parent, false));
    }
    return null;
  }

  @Override
  public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
    if (holder instanceof GroupViewHolder) {
      GroupViewHolder mHolder = (GroupViewHolder) holder;
      mHolder.rl_group_item.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          clickPosition=position;
          OkRequestParams params = new OkRequestParams();
          params.put("bus", listNewsBean.get(position).getUuid());
          BaseController.getInstance(mIResultView).doPostRequest("https://tour.qinglimedia.com/bus/listBusRouteLocales",params);
        }
      });
    } else if (holder instanceof ChildViewHolder) {

    }
  }

  //设置ITEM类型，可以自由发挥
  @Override
  public int getItemViewType(int position) {
    /**
     *
     广告，直播，是大图模式，一个220， 一个是200， 其它方面，只要imageFlag=1就是大图，其它模式是小图，当imageFlag=1的时候，如果type=3，则是视频新闻，加一个视频的标志
     */
    int type = listNewsBean.get(position).getGroupType();
    if (type == 1) {
      return ITEM_CHILD;
    }else{
      return ITEM_GROUP;
    }
  }


  @Override
  public int getItemCount() {
    return listNewsBean == null ? 0 : listNewsBean.size();
  }


  //GroupView 的ViewHolder
  public static class GroupViewHolder extends RecyclerView.ViewHolder {
    RelativeLayout rl_group_item;
    TextView lineTitle, lineStartEnd;
    ImageView yellow, blue, green;
    View line;

    public GroupViewHolder(View view) {
      super(view);
      this.rl_group_item = (RelativeLayout) view.findViewById(R.id.rl_group_item);
      this.green = (ImageView) view.findViewById(R.id.green);
      this.line = view.findViewById(R.id.line);
      this.blue = (ImageView) view.findViewById(R.id.blue);
      this.yellow = (ImageView) view.findViewById(R.id.yellow);
      this.lineStartEnd = (TextView) view.findViewById(R.id.start_end);
      this.lineTitle = (TextView) view.findViewById(R.id.bus_line_title);
    }
  }

  //ChildView 的ViewHolder
  public static class ChildViewHolder extends RecyclerView.ViewHolder {
    private LinearLayout mLine_btn_bus;
    private LinearLayout mLine_bus_station;
    private ImageView mPoint_img;
    private ImageView mType;
    private TextView mPoint_name;
    private TextView mPoint_descrition;
    private RelativeLayout mRoot;

    public ChildViewHolder(View view) {
      super(view);
      mLine_btn_bus = (LinearLayout) view.findViewById(R.id.line_btn_bus);
      mRoot = (RelativeLayout) view.findViewById(R.id.root);
      mLine_bus_station = (LinearLayout) view.findViewById(R.id.line_bus_station);
      mPoint_img = (ImageView) view.findViewById(R.id.point_img);
      mType = (ImageView) view.findViewById(R.id.type);
      mPoint_name = (TextView) view.findViewById(R.id.point_name);
      mPoint_descrition = (TextView) view.findViewById(R.id.point_descrition);
    }
  }

}
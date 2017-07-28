package com.cgd.activity;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cgd.R;
import com.cgd.adapter.BusTourAdapter;
import com.cgd.bean.BusLine;
import com.cgd.bean.BusLinePoint;
import com.cgd.mvc.BaseController;
import com.cgd.mvc.IResultView;
import com.cgd.mvc.OkRequestParams;
import com.cgd.util.SimplePaddingDecoration;
import com.cgd.widget.expandablerecyclerview.bean.GroupItem;
import com.cgd.widget.expandablerecyclerview.bean.RecyclerViewData;
import com.cgd.widget.expandablerecyclerview.holder.BaseViewHolder;
import com.cgd.widget.expandablerecyclerview.listener.OnRecyclerViewListener;
import com.darkcgd.library.AbJsonUtil;

import java.util.ArrayList;
import java.util.List;

public class BusTourActivity extends AppCompatActivity implements OnRecyclerViewListener.OnItemClickListener, OnRecyclerViewListener.OnItemLongClickListener ,IResultView {


    private List<RecyclerViewData> mDatas;
    private RecyclerView mRecyclerview;
    private BusTourAdapter adapter;
    private LinearLayoutManager linearLayoutManager;

    private RelativeLayout rl_head_top;
    TextView lineTitle, lineStartEnd;
    ImageView yellow, blue, green;
    View line;

    private int mCurrentPosition = 0;
    private int clickGroupPosition=-1;
    private int childPosition=0;
    private boolean isExpand;

    private int mSuspensionHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_tour);

        mDatas = new ArrayList<>();
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);


        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerview);

        this.rl_head_top = (RelativeLayout) findViewById(R.id.rl_head_top);
        this.green = (ImageView) findViewById(R.id.green);
        this.line = findViewById(R.id.line);
        this.blue = (ImageView) findViewById(R.id.blue);
        this.yellow = (ImageView) findViewById(R.id.yellow);
        this.lineStartEnd = (TextView) findViewById(R.id.start_end);
        this.lineTitle = (TextView) findViewById(R.id.bus_line_title);

        mRecyclerview.setLayoutManager(linearLayoutManager);
        //mRecyclerview.addItemDecoration(new SimplePaddingDecoration(this));




        mRecyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                mSuspensionHeight = rl_head_top.getHeight();
            }

            @Override public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (adapter.getItemViewType(mCurrentPosition + 1) == BaseViewHolder.VIEW_TYPE_PARENT) {
                    View view = linearLayoutManager.findViewByPosition(mCurrentPosition + 1);
                    if (view != null) {
                        if (view.getTop() <= mSuspensionHeight) {
                            rl_head_top.setY(-(mSuspensionHeight - view.getTop()));
                        } else {
                            rl_head_top.setY(0);
                        }
                    }
                }

                if (mCurrentPosition != linearLayoutManager.findFirstVisibleItemPosition()) {
                    mCurrentPosition = linearLayoutManager.findFirstVisibleItemPosition();
                    rl_head_top.setY(0);

                    updateSuspensionBar();
                }

                //Log.i("======position","childPosition:"+childPosition+"\t"+"clickGroupPosition:"+clickGroupPosition+"\t"+"mCurrentPosition:"+mCurrentPosition);

            }
        });

        updateSuspensionBar();

        //initBooks();
        getBusData();
    }


    /**
     如果不超出child范围 则显示clickposition
     如果超出child范围
     如果展开 则显示mCurrentPosition-childPosition
     如果没展开 则显示mCurrentPosition

     */
    private void updateSuspensionBar() {
        if(mDatas.size()>0){
            if(isExpand){
                rl_head_top.setVisibility(View.VISIBLE);
                if(childPosition+clickGroupPosition>mCurrentPosition-1){
                    if(clickGroupPosition>mCurrentPosition){
                        setHeadData((BusLine.BodyBean.ResultBean.ListBean) mDatas.get(mCurrentPosition).getGroupData());
                    }else{
                        setHeadData((BusLine.BodyBean.ResultBean.ListBean) mDatas.get(clickGroupPosition).getGroupData());
                    }
                }else{
                    if(isExpand){
                        setHeadData((BusLine.BodyBean.ResultBean.ListBean) mDatas.get(mCurrentPosition-childPosition).getGroupData());
                    }else{
                        setHeadData((BusLine.BodyBean.ResultBean.ListBean) mDatas.get(mCurrentPosition).getGroupData());
                    }
                }
            }else{
                rl_head_top.setVisibility(View.GONE);
            }

        }
    }


    private void setHeadData(BusLine.BodyBean.ResultBean.ListBean groupData){
        lineTitle.setText(groupData.getName());
        lineStartEnd.setText(groupData.getFront_name() + "/" + groupData.getTerminal_name());
        if (groupData.getTypes() != null && groupData.getTypes().length() > 0) {
            String[] type = groupData.getTypes().split(",");
            /*全部gone*/
            yellow.setVisibility(View.GONE);
            green.setVisibility(View.GONE);
            blue.setVisibility(View.GONE);
            for (String t : type) {
                switch (t) {
                    /*历史 黄*/
                    case "0":
                        yellow.setVisibility(View.VISIBLE);
                        break;
                    /*建筑 绿*/
                    case "1":
                        green.setVisibility(View.VISIBLE);
                        break;
                    /*景点 蓝*/
                    case "2":
                        blue.setVisibility(View.VISIBLE);
                        break;
                }
            }
        } else {
            /*如果为空就显示一个默认的黄色 历史古迹*/
            yellow.setVisibility(View.VISIBLE);
        }
    }

    private void getBusData() {
        OkRequestParams params = new OkRequestParams();
        params.put("page", 0);
        BaseController.getInstance(this).doPostRequest("https://tour.qinglimedia.com/bus/listBus",params);
    }
    public void getBusChildData(String uuid) {
        OkRequestParams params = new OkRequestParams();
        params.put("bus", uuid);
        BaseController.getInstance(this).doPostRequest("https://tour.qinglimedia.com/bus/listBusRouteLocales",params);
    }


    /*private void initBooks() {
        List<Book> bean1 = new ArrayList<>();
        List<Book> bean2 = new ArrayList<>();
        List<Book> bean3 = new ArrayList<>();
        List<Book> bean4 = new ArrayList<>();
        // id , pid , label , 其他属性
        bean2.add(new Book("war3","分组1"));
        bean2.add(new Book("刀塔传奇","分组1"));

        bean2.add(new Book("非面向对象","分组1"));

        bean2.add(new Book("C++","分组1"));
        bean2.add(new Book("JAVA","分组1"));
        bean2.add(new Book("Javascript","分组1"));
        bean2.add(new Book("C","分组1"));

        bean3.add(new Book("文件管理系统","分组2"));
        bean3.add(new Book("游戏","分组2"));
        bean4.add(new Book("文档","分组3"));
        bean4.add(new Book("程序","分组3"));
        bean4.add(new Book("war3","分组3"));
        bean3.add(new Book("刀塔传奇","分组2"));

        bean3.add(new Book("面向对象","分组2"));
        bean4.add(new Book("非面向对象","分组3"));

        bean3.add(new Book("文件管理系统","分组2"));
        bean3.add(new Book("游戏","分组2"));
        bean4.add(new Book("文档","分组3"));
        bean4.add(new Book("程序","分组3"));
        bean4.add(new Book("war3","分组3"));
        bean4.add(new Book("刀塔传奇","分组3"));

        bean1.add(new Book("文件管理系统","分组0"));
        bean1.add(new Book("游戏","分组0"));
        bean1.add(new Book("文档","分组0"));
        bean1.add(new Book("程序","分组0"));
        bean1.add(new Book("面向对象","分组0"));

        mDatas.add(new RecyclerViewData("分组0", bean1, false));
        mDatas.add(new RecyclerViewData("分组4", bean1, false));
        mDatas.add(new RecyclerViewData("分组8", bean1, false));
        mDatas.add(new RecyclerViewData("分组12", bean1, false));
        mDatas.add(new RecyclerViewData("分组16", bean1, false));
        mDatas.add(new RecyclerViewData("分组21", bean1, false));
        mDatas.add(new RecyclerViewData("分组26", bean1, false));

        mDatas.add(new RecyclerViewData("分组1", bean2, false));
        mDatas.add(new RecyclerViewData("分组2", bean3, false));
        mDatas.add(new RecyclerViewData("分组3", bean4, false));
        mDatas.add(new RecyclerViewData("分组5", bean2, false));
        mDatas.add(new RecyclerViewData("分组6", bean3, false));
        mDatas.add(new RecyclerViewData("分组7", bean4, false));
        mDatas.add(new RecyclerViewData("分组9", bean2, false));
        mDatas.add(new RecyclerViewData("分组10", bean3, false));
        mDatas.add(new RecyclerViewData("分组11", bean4, false));
        mDatas.add(new RecyclerViewData("分组13", bean2, false));
        mDatas.add(new RecyclerViewData("分组14", bean3, false));
        mDatas.add(new RecyclerViewData("分组15", bean4, false));
        mDatas.add(new RecyclerViewData("分组17", bean2, false));
        mDatas.add(new RecyclerViewData("分组18", bean3, false));
        mDatas.add(new RecyclerViewData("分组19", bean4, false));
        mDatas.add(new RecyclerViewData("分组20", bean4, false));
        mDatas.add(new RecyclerViewData("分组22", bean2, false));
        mDatas.add(new RecyclerViewData("分组23", bean3, false));
        mDatas.add(new RecyclerViewData("分组24", bean4, false));
        mDatas.add(new RecyclerViewData("分组25", bean4, false));
        mDatas.add(new RecyclerViewData("分组27", bean2, false));
        mDatas.add(new RecyclerViewData("分组28", bean3, false));
        mDatas.add(new RecyclerViewData("分组29", bean4, false));
    }*/

    @Override
    public void onGroupItemClick(int position,int groupPosition, View view) {
        /*String group = (String) mDatas.get(groupPosition).getGroupData();
        Toast.makeText(this, "groupPos:" + groupPosition + " group:" + group, Toast.LENGTH_SHORT).show();*/

        clickGroupPosition=groupPosition;
        GroupItem groupItem = mDatas.get(clickGroupPosition).getGroupItem();
        List childDatas = groupItem.getChildDatas();
        if(childDatas!=null&&childDatas.size()>0){//说明之前已经请求过数据
            isExpand=!groupItem.isExpand();
            childPosition=childDatas.size();
        }else{
            BusLine.BodyBean.ResultBean.ListBean mListBean = (BusLine.BodyBean.ResultBean.ListBean) groupItem.getGroupData();
            getBusChildData(mListBean.getUuid());
        }
    }

    @Override
    public void onChildItemClick(int position,int groupPosition, int childPosition, View view) {
        BusLinePoint.BodyBean.ResultBean.ListBean bean = (BusLinePoint.BodyBean.ResultBean.ListBean) mDatas.get(groupPosition).getChild(childPosition);
        //Toast.makeText(this, "groupPos:" + groupPosition + "  childPos:" + childPosition + " child:" + bean.getBody().getResult()., Toast.LENGTH_SHORT).show();
        clickGroupPosition=groupPosition;
    }


    @Override
    public void onGroupItemLongClick(int position,int groupPosition, View view) {
        //String group = (String) mDatas.get(groupPosition).getGroupData();
        //Toast.makeText(this, "groupPos:" + groupPosition + " group:" + group, Toast.LENGTH_SHORT).show();
        showDeleteDialog(position,groupPosition,0,true);
    }

    @Override
    public void onChildItemLongClick(int position,int groupPosition, int childPosition, View view) {
        BusLinePoint.BodyBean.ResultBean.ListBean bean = (BusLinePoint.BodyBean.ResultBean.ListBean) mDatas.get(groupPosition).getChild(childPosition);
        //Toast.makeText(this, "groupPos:" + groupPosition + "  childPos:" + childPosition + " child:" + bean.getName(), Toast.LENGTH_SHORT).show();
        showDeleteDialog(position,groupPosition,childPosition,false);
    }

    /**
     * 删除数据
     * @param position
     * @param isGroup
     */
    private void showDeleteDialog(final int position, final int groupPosition, final int childPosition, final boolean isGroup){
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("提示!")
                .setMessage(isGroup?"您确定要删除此组数据":"您确定要删除此条数据")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //然后根据回调里的groupPosition和childPosition来更新你的数据源
                        if(isGroup){
                            mDatas.remove(groupPosition);
                        }else {
                            mDatas.get(groupPosition).removeChild(childPosition);
                        }
                        adapter.notifyRecyclerViewData();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        builder.show();
    }

    @Override
    public void showLoadView(String url) {

    }

    @Override
    public void showResultView(String url, String content) {
        if("https://tour.qinglimedia.com/bus/listBus".equals(url)){
            BusLine busLine = AbJsonUtil.fromJson(content, BusLine.class);
            List<BusLine.BodyBean.ResultBean.ListBean> newList = busLine.getBody().getResult().getList();
            for (BusLine.BodyBean.ResultBean.ListBean listBean : newList) {
                mDatas.add(new RecyclerViewData(listBean, new ArrayList<BusLinePoint.BodyBean.ResultBean.ListBean>(), false));
            }

            if(newList.size()>0){
                rl_head_top.setVisibility(View.VISIBLE);
                rl_head_top.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                setHeadData(newList.get(0));
                adapter = new BusTourAdapter(this, mDatas);
                adapter.setOnItemClickListener(this);
                adapter.setOnItemLongClickListener(this);
                mRecyclerview.setAdapter(adapter);
                //adapter.notifyRecyclerViewData();
                //adapter.notifyDataSetChanged();
            }else{
                rl_head_top.setVisibility(View.GONE);
            }

        }else if("https://tour.qinglimedia.com/bus/listBusRouteLocales".equals(url)){
            BusLinePoint busTourListBean = AbJsonUtil.fromJson(content, BusLinePoint.class);

            mDatas.get(clickGroupPosition).getGroupItem().onExpand();
            isExpand=true;
            List childDatas = mDatas.get(clickGroupPosition).getGroupItem().getChildDatas();
            if(childDatas==null){//说明之前未请求数据
                childDatas=new ArrayList();
            }

            List<BusLinePoint.BodyBean.ResultBean.ListBean> list = busTourListBean.getBody().getResult().getList();
            childPosition = list.size();
            for (BusLinePoint.BodyBean.ResultBean.ListBean listBean : list) {
                //mDatas.add(new RecyclerViewData(listBean, new ArrayList<BusLinePoint.BodyBean.ResultBean.ListBean>(), false));
                childDatas.add(listBean);
            }
            //mRecyclerview.setAdapter(adapter);
            adapter.notifyRecyclerViewData();
            //adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showErrorView(String url, String msg) {

    }

    @Override
    public void showProgressView(String url, int progress) {

    }
}


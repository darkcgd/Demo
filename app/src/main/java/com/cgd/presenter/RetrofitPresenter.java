package com.cgd.presenter;

import com.cgd.callback.IBaseResultCallBack;
import com.cgd.model.ApiFactory;
import com.cgd.model.BaseModel;
import com.cgd.util.Constant;
import com.cgd.view.IRetrofitView;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * Created by cgd on 2017/6/25.
 */

public class RetrofitPresenter extends BasePresenter implements IBaseResultCallBack{
    private BaseModel model;
    private IRetrofitView retrofitView;

    private List<Call<ResponseBody>> listCall=new ArrayList();
    public RetrofitPresenter(IRetrofitView retrofitView) {
        this.retrofitView=retrofitView;
        model=new BaseModel();
    }

    public void getBusList(int page){
        Call<ResponseBody> busListCall = ApiFactory.getAPI().getBusList(page);
        listCall.add(busListCall);
        model.getBaseData(Constant.GET_BUS_LIST,busListCall,this);
    }

    public void getRegionList(){
        Call<ResponseBody> regionListCall = ApiFactory.getAPI().getRegionList();
        listCall.add(regionListCall);
        model.getBaseData(Constant.GET_REGION_LIST,regionListCall,this);
    }

    @Override
    public void onDestroy() {
        retrofitView=null;
        for (Call<ResponseBody> call:listCall) {
            if (!call.isCanceled()){
                call.cancel();
            }
        }
    }

    @Override
    public void onSuccess(String url,String content) {
        if(Constant.GET_BUS_LIST.equals(url)){
            retrofitView.setBusData(content);
        }else if(Constant.GET_REGION_LIST.equals(url)){
            retrofitView.setRegionData(content);
        }
    }

    @Override
    public void onFailure(String url,String errorMsg) {
        retrofitView.handlerError(url,errorMsg);
    }
}

package com.cgd.model;

import android.util.Log;

import com.cgd.bean.BusListBean;
import com.cgd.callback.IBaseResultCallBack;
import com.cgd.presenter.RetrofitPresenter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by cgd on 2017/6/25.
 */

public class RetrofitModel {

    public void getSimpleData(int page, final IBaseResultCallBack baseResultCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://tour.qinglimedia.com/")
                .build();
        ServiceApi api = retrofit.create(ServiceApi.class);

        Call<ResponseBody> call = api.getSimpleData(page);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    /*Gson gson = new Gson();
                    BusListBean busListBean = gson.fromJson(response.body().string(), new TypeToken<BusListBean>() {
                    }.getType());*/
                    String content = response.body().string();
                    baseResultCallBack.onSuccess(content);
                } catch (Exception e) {
                    e.printStackTrace();
                    baseResultCallBack.onFailure(e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                baseResultCallBack.onFailure(t.getMessage());
            }
        });
    }

}

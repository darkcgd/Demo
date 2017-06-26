package com.cgd.model;

import com.cgd.callback.IBaseResultCallBack;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by cgd on 2017/6/25.
 */

public class BaseModel {

    public void getBaseData(final String url, Call<ResponseBody> call, final IBaseResultCallBack baseResultCallBack){
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String content = response.body().string();
                    baseResultCallBack.onSuccess(url,content);
                } catch (Exception e) {
                    e.printStackTrace();
                    baseResultCallBack.onFailure(url,e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                if (call.isCanceled()) {
                    baseResultCallBack.onFailure(url,"取消请求");
                } else {
                    baseResultCallBack.onFailure(url,t.getMessage());
                }
            }
        });
    }

}

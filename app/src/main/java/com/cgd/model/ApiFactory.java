package com.cgd.model;

import com.cgd.util.Constant;

import retrofit2.Retrofit;

/**
 * Created by cgd on 17/6/26.
 */

public class ApiFactory {

    private static BaseApi api;

    public static BaseApi getAPI() {
        if (api == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.BaseUrl)
                    .build();
            api = retrofit.create(BaseApi.class);
        }
        return api;
    }
}

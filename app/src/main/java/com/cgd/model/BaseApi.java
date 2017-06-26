package com.cgd.model;

import com.cgd.util.Constant;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by cgd on 2017/6/25.
 */

public interface BaseApi {

    @GET(Constant.GET_BUS_LIST)
    Call<ResponseBody> getBusList(@Query("page") int page);

    @GET(Constant.GET_REGION_LIST)
    Call<ResponseBody> getRegionList();

}

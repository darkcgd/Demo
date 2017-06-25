package com.cgd.model;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by cgd on 2017/6/25.
 */

public interface ServiceApi {
    @GET("bus/listBus")
    Call<ResponseBody> getSimpleData(@Query("page") int page);
}

package com.cgd.view;

/**
 * Created by cgd on 2017/6/25.
 */

public interface IRetrofitView {
    void setBusData(String content);
    void setRegionData(String content);
    void handlerError(String url,String errorMsg);
}

package com.cgd.callback;

/**
 * Created by cgd on 2017/6/25.
 */

public interface IBaseResultCallBack {
    void onSuccess(String url,String content);
    void onFailure(String url,String errorMsg);
}

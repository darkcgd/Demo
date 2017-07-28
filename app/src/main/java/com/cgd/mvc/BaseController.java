package com.cgd.mvc;


import java.io.File;
import java.util.Map;

/**
 * Created by chenjun on 2016/8/5.
 */
public class BaseController {

    private IResultView resultView;
    private IResultModel resultModel;

    /**
     * 获得一个实例(不是单例)
     *
     * @return
     */
    public static BaseController getInstance(IResultView resultView) {
        return new BaseController(resultView);
    }


    public BaseController(IResultView resultView) {
        this.resultView = resultView;
        resultModel = new IResultModel();
    }

    /***OKHttp的get请求***/
    public void doGetRequest(String url, OkRequestParams params) {
        resultModel.doGetRequest(url, params, resultView);
    }

    /***OKHttp的get请求***/
    public void doGetRequestCode(String url, OkRequestParams params, String requestCode) {
        resultModel.doGetRequestCode(url, params, resultView, requestCode);
    }

    /***OKHttp的post请求***/
    public void doPostRequest(String url, OkRequestParams params) {
        resultModel.doPostRequest(url, params, resultView);
    }

    /***OKHttp的post请求***/
    public void doPostRequestCode(String url, OkRequestParams params, String requestCode) {
        resultModel.doPostRequestCode(url, params, resultView, requestCode);
    }

    /***OKHttp的post请求***/
    public void doPostRequest(String url, OkRequestParams params, String header) {
        resultModel.doPostRequest(url, params, resultView, header);
    }

    /***OKHttp的post请求（JSON格式发送）***/
    public void doPostStringRequest(String url, OkRequestParams params) {
        resultModel.doPostStringRequest(url, params, resultView);
    }



}

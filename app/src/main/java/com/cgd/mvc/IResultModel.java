package com.cgd.mvc;


import com.cgd.mvc.fileutil.FileBody;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.builder.GetBuilder;
import com.zhy.http.okhttp.builder.PostFormBuilder;
import com.zhy.http.okhttp.callback.FileCallBack;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zhy.http.okhttp.request.RequestCall;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Request;


/**
 * Created by cgd on 2016/8/5.
 */
public class IResultModel {

public static final String GET="GET";
public static final String POST="POST";
public static final String POSTSTRING="POSTSTRING";
public static final String POSTFILE="POSTFILE";
public static final String UPLOADFILE="UPLOADFILE";
public static final String DOWNLOADFILE="DOWNLOADFILE";

    // OKHTTP请求方式（新加）
 //   =====================================================================================================================================================
    /***
     * GET请求
     * @param url  请求地址
     * @param params   参数params封装的是参数
     * @param resultView  resultView,用于回调数据结果
     * @param requestCode 用于识别同url 时，不同参数的请求
     */

    public void doGetRequestCode(final String url, OkRequestParams params, final IResultView resultView,
                                 String requestCode) {
        GetBuilder getBuilder = OkHttpUtils.get();//
        ConcurrentHashMap<String, String> urlParams = params.getUrlParams();
        for (ConcurrentHashMap.Entry<String, String> entry : urlParams.entrySet()) {
            getBuilder.addParams(entry.getKey(),entry.getValue());
        }
        /*if (BuildConfig.LOG) {
            Log.d("==========请求的相关数据", "请求地址:"+url+"\n请求的参数:"+params.getUrlParams().toString());
        }*/
        getBuilder.url(url)//
                .id(101)
                .tag(this)
                .build()//
                .execute(MyStringCallBack(requestCode,resultView));
    }
    /***
     * GET请求
     * @param url  请求地址
     * @param params   参数params封装的是参数
     * @param resultView  resultView,用于回调数据结果
     */

    public void doGetRequest(final String url, OkRequestParams params, final IResultView resultView) {
        GetBuilder getBuilder = OkHttpUtils.get();//
        ConcurrentHashMap<String, String> urlParams = params.getUrlParams();
        for (ConcurrentHashMap.Entry<String, String> entry : urlParams.entrySet()) {
            getBuilder.addParams(entry.getKey(),entry.getValue());
        }
        /*if (BuildConfig.LOG) {
            Log.d("==========请求的相关数据", "请求地址:"+url+"\n请求的参数:"+params.getUrlParams().toString());
        }*/
        getBuilder.url(url)//
                    .id(101)
                    .tag(this)
                    .build()//
                    .execute(MyStringCallBack(url,resultView));
        }
    /**
     *
     * POET请求
     * @param url  请求地址
     * @param params   参数params封装的是参数
     * @param resultView  resultView,用于回调数据结果
     */
    public void doPostRequestCode(final String url, OkRequestParams params, final IResultView resultView,String requestCode) {
        PostFormBuilder postBuilder = OkHttpUtils.post();
        postBuilder.url(url);
        ConcurrentHashMap<String, String> urlParams = params.getUrlParams();
        for (ConcurrentHashMap.Entry<String, String> entry : urlParams.entrySet()) {
            postBuilder.addParams(entry.getKey(),entry.getValue());
        }
        /*if (BuildConfig.LOG) {
            Log.d("==========请求的相关数据", "请求地址:"+url+"\n请求的参数:"+params.getUrlParams().toString());
        }*/
        String tag = urlParams.get("tag");

        postBuilder.id(101)
                .tag(tag)
                .build()//
                .execute(MyStringCallBack(requestCode,resultView));
    }
    /**
     *
     * POET请求
     * @param url  请求地址
     * @param params   参数params封装的是参数
     * @param resultView  resultView,用于回调数据结果
     */
    public void doPostRequest(final String url, OkRequestParams params, final IResultView resultView) {
        PostFormBuilder postBuilder = OkHttpUtils.post();
        postBuilder.url(url);
        ConcurrentHashMap<String, String> urlParams = params.getUrlParams();
        for (ConcurrentHashMap.Entry<String, String> entry : urlParams.entrySet()) {
            postBuilder.addParams(entry.getKey(),entry.getValue());
        }
        /*if (BuildConfig.LOG) {
            Log.d("==========请求的相关数据", "请求地址:"+url+"\n请求的参数:"+params.getUrlParams().toString());
        }*/
        String tag = urlParams.get("tag");

        postBuilder.id(101)
                .tag(tag)
                .build()//
                .execute(MyStringCallBack(url,resultView));
    }
    /**
     *
     * POET请求
     * @param url  请求地址
     * @param params   参数params封装的是参数
     * @param resultView  resultView,用于回调数据结果
     */
    public void doPostRequest(final String url, OkRequestParams params, final IResultView resultView,String header) {

        PostFormBuilder postBuilder = OkHttpUtils.post();
        postBuilder.url(url);
        postBuilder.addHeader("authorization",header);
        postBuilder.addHeader("Content-Type", "text/plain");
        ConcurrentHashMap<String, String> urlParams = params.getUrlParams();

        for (ConcurrentHashMap.Entry<String, String> entry : urlParams.entrySet()) {
            postBuilder.addParams(entry.getKey(),entry.getValue());
        }
        /*if (BuildConfig.LOG) {
            Log.d("==========请求的相关数据", "请求地址:"+url+"\nheader:"+header+"\n请求的参数:"+params.getUrlParams().toString());
        }*/

        String tag = urlParams.get("tag");

        postBuilder.id(101)
                .tag(tag)
                .build()//
                .execute(MyStringCallBack(url,resultView));
    }

    /**
     *
     *  Post请求（用于Psot的值为JSON数据）
     * @param url  请求地址
     * @param params   参数params封装的是参数
     * @param resultView  resultView,用于回调数据结果
     */
    public void doPostStringRequest(final String url, OkRequestParams params, final IResultView resultView) {
        OkHttpUtils
                .postString()//
                .url(url)//
                .id(101)
                .mediaType(MediaType.parse("text/plain ; application/json; charset=utf-8"))
                .tag(this)
                .build()//
                .execute(MyStringCallBack(url,resultView));

    }


    private StringCallback MyStringCallBack(final String url, final IResultView resultView){
          return new StringCallback(){
              @Override
              public void onBefore(Request request, int id) {
                  resultView.showLoadView(url);
              }
              @Override
              public void inProgress(float progress, long total, int id) {
                  resultView.showProgressView(url, (int) (100 * progress));
              }
              @Override
              public void onError(Call call, Exception e, int id) {
                  /*if (BuildConfig.LOG) {
                      Log.d("==========返回的错误数据", "请求地址:"+url+"\n"+"返回的数据:"+e.toString());
                  }*/

                  if(e.toString().contains("UnknownHostException")){
                      resultView.showErrorView(url,  "请检查网络");
                  }else{
                      resultView.showErrorView(url,  e.toString());
                  }

              }
              @Override
              public void onResponse(String response, int id) {
                  /*if (BuildConfig.LOG) {
                      Log.d("==========返回的数据", "请求地址:"+url+"\n"+"返回的数据:"+response);
                  }*/
                  resultView.showResultView(url, response.toString());
              }
          };
    }


}

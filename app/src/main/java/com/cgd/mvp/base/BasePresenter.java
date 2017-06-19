package com.cgd.mvp.base;

/**
 * Created by cgd on 2017/6/18.
 */

public class BasePresenter<V extends BaseView,M extends BaseModel> {
    protected V mView;
    protected M mModel;

}

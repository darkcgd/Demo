package com.cgd.mvp.contract;

import com.cgd.mvp.base.BaseModel;
import com.cgd.mvp.base.BasePresenter;
import com.cgd.mvp.base.BaseView;

/**
 * Created by cgd on 2017/6/18.
 */

public interface MainContract {
    interface View extends BaseView{

    }

    interface Model extends BaseModel{
        void getData();
    }

    abstract class Presenter extends BasePresenter<View,Model>{
        public abstract void getData();

    }
}

package com.cgd.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cgd.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;


public class RxjavaActivity extends AppCompatActivity {
    @Bind(R.id.tv)
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
        ButterKnife.bind(this);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
            }
        });
    }

    private void getData() {
        //一个Observable可以发出一个或者多个事件，直到结束或者出错。
        //每发出一个事件，他会调用他的Subscriber的OnNext()的方法，最后调用Subscriber.OnComplete()或者Subscriber.OnError()作为结束。

        //Observable部分,被观察者部分
        Observable<String> myObservable=Observable.create(new Observable.OnSubscribe<String>(){
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Dark");
                subscriber.onNext("cgd");
                subscriber.onCompleted();
            }
        });


        //Subscriber部分，观察者部分
        //创建Subscriber对象响应Observable所发出的事件。上面的Observable所发出的事件为Dark。
        Subscriber<String> mySubscriber=new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                tv.setText(s);
            }
        };


        //将观察者和被观察者相关联，完成subscriber对observable的订阅
        myObservable
                .subscribeOn(Schedulers.newThread())
                .subscribe(mySubscriber);

    }
}

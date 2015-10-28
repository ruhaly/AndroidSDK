package com.ruhaly.androidsdk.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.ruhaly.androidsdk.baseapi.Urls;
import com.ruhaly.androidsdk.bean.LoginResult;
import com.ruhaly.androidsdk.model.ApiService;
import com.ruhaly.androidsdk.view.ILoginView;

import nucleus.presenter.RxPresenter;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Func0;
import rx.schedulers.Schedulers;

/**
 * Created by hlr on 2015/9/18.
 */
public class LoginPresenter<T> extends RxPresenter<T> {

    private static final int REQUEST_LOGIN = 1;

    private String name;

    private String pwd;

    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        requestLogin(REQUEST_LOGIN, name, pwd, Urls.mlogins);
    }


    public void requestLogin(int request, final String name, final String pwd, final String url) {

        restartableFirst(request, new Func0<Observable<LoginResult>>() {
            @Override
            public Observable<LoginResult> call() {
                return new ApiService().requestLogin(name, pwd, url).doOnNext(new Action1<LoginResult>() {
                    @Override
                    public void call(LoginResult loginResult) {
                        //异步保存数据
                    }
                }).subscribeOn(Schedulers.io());
            }
        }, new Action2<T, LoginResult>() {
            @Override
            public void call(T view, LoginResult result) {
                ((ILoginView) view).notifyData(result);
            }
        }, new Action2<T, Throwable>() {
            @Override
            public void call(T view, Throwable throwable) {
                ((ILoginView) view).handleError(throwable);
            }
        });
    }


    /**
     * @param name
     * @param pwd
     */
    public void requestLogin(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
        start(REQUEST_LOGIN);
    }

    @Override
    public void onSave(@NonNull Bundle state) {
        super.onSave(state);
    }
}

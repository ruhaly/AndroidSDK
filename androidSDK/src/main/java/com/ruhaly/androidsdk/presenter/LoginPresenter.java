package com.ruhaly.androidsdk.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.ruhaly.androidsdk.baseapi.Urls;
import com.ruhaly.androidsdk.bean.LoginResult;
import com.ruhaly.androidsdk.model.ApiService;
import com.ruhaly.androidsdk.view.ILoginView;

import nucleus.presenter.RxPresenter;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action2;
import rx.functions.Func0;

/**
 * Created by hlr on 2015/9/18.
 */
public class LoginPresenter<T> extends RxPresenter<ILoginView> {

    private static final int REQUEST_LOGIN = 1;

    private String name;

    private String pwd;


    ILoginView loginView;

    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        requestLogin(REQUEST_LOGIN, name, pwd, Urls.mlogins);
    }


    public void requestLogin(int request, final String name, final String pwd, final String url) {

        new ApiService().requestLogin(name, pwd, url).subscribe(new Subscriber<LoginResult>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                loginView.handleError(e);
            }

            @Override
            public void onNext(LoginResult result) {
                loginView.notifyData(result);
            }
        });


        restartableFirst(request, new Func0<Observable<LoginResult>>() {
            @Override
            public Observable<LoginResult> call() {
                return new ApiService().requestLogin(name, pwd, url);
            }
        }, new Action2<ILoginView, LoginResult>() {
            @Override
            public void call(ILoginView view, LoginResult result) {
                view.notifyData(result);
            }
        }, new Action2<ILoginView, Throwable>() {
            @Override
            public void call(ILoginView view, Throwable throwable) {
                view.handleError(throwable);
            }
        });
        Observable.just("").subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {

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

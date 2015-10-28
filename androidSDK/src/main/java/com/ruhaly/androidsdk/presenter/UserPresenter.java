package com.ruhaly.androidsdk.presenter;

import android.os.Bundle;

import com.ruhaly.androidsdk.baseapi.Urls;
import com.ruhaly.androidsdk.bean.UserListResult;
import com.ruhaly.androidsdk.model.ApiService;
import com.ruhaly.androidsdk.view.ILoadDataView;

import nucleus.presenter.RxPresenter;
import rx.Observable;
import rx.functions.Action2;
import rx.functions.Func0;

/**
 * Created by hlr on 2015/10/28.
 */
public class UserPresenter<T> extends RxPresenter<T> {
    private static final int REQUEST_USER_LIST = 1;
    private int groupId;
    private boolean refresh;
    private int pageNum;
    private static final int PERNUM = 10;
    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        requestUserList();
    }
    public void requestUserList() {
        final int tempPageNum = refresh ? 1 : pageNum + 1;
        restartableFirst(groupId, new Func0<Observable<UserListResult>>() {
            @Override
            public Observable<UserListResult> call() {
                return new ApiService().getUserList(groupId, pageNum, PERNUM, Urls.mlogins);
            }
        }, new Action2<T, UserListResult>() {
            @Override
            public void call(T t, UserListResult result) {
                pageNum = tempPageNum;
                //更新界面
            }
        }, new Action2<T, Throwable>() {
            @Override
            public void call(T view, Throwable throwable) {
                ((ILoadDataView) view).handleError(throwable);
            }
        });
    }
    public void requestUserList(int groupId, boolean refresh) {
        this.groupId = groupId;
        this.refresh = refresh;
        start(REQUEST_USER_LIST);
    }
}

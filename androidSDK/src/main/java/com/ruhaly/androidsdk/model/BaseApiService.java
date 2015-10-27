package com.ruhaly.androidsdk.model;

import com.ruhaly.androidsdk.baseapi.AppLog;
import com.ruhaly.androidsdk.baseapi.BaseConstant;
import com.ruhaly.androidsdk.baseapi.CustomThrowable;
import com.ruhaly.androidsdk.baseapi.OkHttpUtil;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.Map;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hlr on 2015/9/21.
 */
public class BaseApiService {

    public Observable<String> createObservable(final Map<String, Object> map) {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    Response response = OkHttpUtil.postRequest(map, (String) map.remove(BaseConstant.URL));

                    int code = response.code();
                    switch (code) {
                        case 200: {
                            if (null != response && null != response.body()) {
                                AppLog.out("返回响应response：", response.body().string(), AppLog.LEVEL_INFO);
                            }
                            subscriber.onNext(response.body().string());
                            subscriber.onCompleted();
                            break;
                        }
                        default: {
                            subscriber.onError(new CustomThrowable(code));
                            break;
                        }
                    }
                } catch (IOException e) {
                    AppLog.out("返回响应response：", e.getMessage(), AppLog.LEVEL_ERROR);
                    subscriber.onError(new CustomThrowable(e.getMessage()));
                }
            }
        }).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread());
    }
}

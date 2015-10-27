package com.ruhaly.androidsdk.model;

import com.ruhaly.androidsdk.baseapi.AppLog;
import com.ruhaly.androidsdk.baseapi.BaseConstant;
import com.ruhaly.androidsdk.baseapi.DataParseFactory;
import com.ruhaly.androidsdk.baseapi.IDataParse;
import com.ruhaly.androidsdk.baseapi.MyMD5;
import com.ruhaly.androidsdk.bean.LoginResult;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by hlr on 2015/9/18.
 */
public class ApiService extends BaseApiService {

    /**
     * 登录请求
     *
     * @param name
     * @param pwd
     * @param url
     * @return
     */
    public Observable<LoginResult> requestLogin(String name, String pwd, String url) {
        Map<String, Object> map = new HashMap<>();
        map.put("phone", name);
        map.put("pwd", MyMD5.MD5(pwd));
        map.put(BaseConstant.URL, url);

        return createObservable(map).map(new Func1<String, LoginResult>() {
            @Override
            public LoginResult call(String s) {
                AppLog.out("ApiService", s, AppLog.LEVEL_INFO);
                IDataParse<LoginResult> dataParse = DataParseFactory.newDataParse("json");
                LoginResult result = dataParse.toBean(s, LoginResult.class);
                return result;
            }
        }).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread());

    }


}

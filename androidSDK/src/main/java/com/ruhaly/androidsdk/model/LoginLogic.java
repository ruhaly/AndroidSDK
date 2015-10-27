package com.ruhaly.androidsdk.model;

import android.util.Log;

import com.ruhaly.androidsdk.baseapi.BaseConstant;
import com.ruhaly.androidsdk.baseapi.BaseLogic;
import com.ruhaly.androidsdk.baseapi.Urls;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginLogic extends BaseLogic {

    private static LoginLogic loginLogic = null;

    public static LoginLogic getInstance() {
        if (null == loginLogic) {
            loginLogic = new LoginLogic();
        }
        return loginLogic;
    }

    public void loginRequest(String name, String pwd) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("pwd", pwd);
        map.put(BaseConstant.URL, Urls.loginurl);
        postRequest(map, new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                Log.i("IOException", e.getMessage());
            }

            @Override
            public void onResponse(Response response) throws IOException {
                String body = response.body().string();
                Log.i("response", body);
            }


        });
    }
}

package com.ruhaly.androidsdk.baseapi;

import android.content.Context;
import android.os.Handler;

import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;

import java.util.Map;

public class BaseLogic implements HttpResponseHanlder {

    public static String TAG = "BaseLogic";

    public int currentPage = 1;

    public int perPage = 10;

    public int total = 0;

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    public Handler handler;

    public BaseLogic() {
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public void cancelRequests(Context context) {
        AppLog.out(TAG, "取消", AppLog.LEVEL_ERROR);
    }

    @Override
    public void handleHttpError(Throwable throwable, int statusCode, String msg) {
        handler.sendEmptyMessage(BaseMsgWhat.CONNECT_ERROR_MSGWHAT);
    }


    public void postRequest(Map<String, Object> map, Callback callback) {

        String url = (String) map.remove(BaseConstant.URL);
        RequestBody body = RequestBody.create(JSON, fixRequestParams(map));
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        enqueue(request, callback);
    }


    public void enqueue(Request request, Callback callback) {

        OkHttpUtil.enqueue(request, callback);
    }

    /**
     * 组装RequestParams
     * [功能详细描述]
     *
     * @param bodyMap
     * @return
     */
    public String fixRequestParams(Map<String, Object> bodyMap) {
        bodyMap.remove("url");
        String paramsStr = "";
        try {
            Gson gson = new Gson();
            paramsStr =  gson.toJson(bodyMap);
//            ObjectMapper objectMapper = new ObjectMapper();
//            paramsStr = objectMapper.writeValueAsString(bodyMap);
        } catch (Exception e) {
            AppLog.out(TAG, "fixRequestParams():参数错误", AppLog.LEVEL_ERROR);
        }

        return paramsStr;
    }
}

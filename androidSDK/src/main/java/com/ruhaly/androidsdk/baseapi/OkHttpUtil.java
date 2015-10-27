package com.ruhaly.androidsdk.baseapi;

import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class OkHttpUtil {


    public static String TAG = "BaseLogic";

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private static final OkHttpClient mOkHttpClient = new OkHttpClient();

    static {
        mOkHttpClient.setConnectTimeout(30, TimeUnit.SECONDS);
    }

    /**
     * 该不会开启异步线程。
     *
     * @param request
     * @return
     * @throws IOException
     */
    public static Response execute(Request request) throws IOException {
        return mOkHttpClient.newCall(request).execute();
    }

    /**
     * 开启异步线程访问网络
     *
     * @param request
     * @param responseCallback
     */
    public static void enqueue(Request request, Callback responseCallback) {
        mOkHttpClient.newCall(request).enqueue(responseCallback);
    }

    /**
     * 开启异步线程访问网络, 且不在意返回结果（实现空callback）
     *
     * @param request
     */
    public static void enqueue(Request request) {
        mOkHttpClient.newCall(request).enqueue(new Callback() {

            @Override
            public void onResponse(Response arg0) throws IOException {

            }

            @Override
            public void onFailure(Request arg0, IOException arg1) {

            }
        });
    }

    public static String getStringFromServer(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = execute(request);
        if (response.isSuccessful()) {
            String responseUrl = response.body().string();
            return responseUrl;
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    private static final String CHARSET_NAME = "UTF-8";


    /**
     * 为HttpGet 的 url 方便的添加1个name value 参数。
     *
     * @param url
     * @param name
     * @param value
     * @return
     */
    public static String attachHttpGetParam(String url, String name, String value) {
        return url + "?" + name + "=" + value;
    }


    /**
     * 组装RequestParams
     * [功能详细描述]
     *
     * @param bodyMap
     * @return
     */
    public static String fixRequestParams(Map<String, Object> bodyMap) {
        bodyMap.remove("url");
        String paramsStr = "";
        try {
            Gson gson = new Gson();
            paramsStr = gson.toJson(bodyMap);
            paramsStr = URLEncoder.encode(paramsStr, CHARSET_NAME);
//            ObjectMapper objectMapper = new ObjectMapper();
//            paramsStr = URLEncoder.encode(objectMapper.writeValueAsString(bodyMap), CHARSET_NAME);
        } catch (Exception e) {
            AppLog.out(TAG, "fixRequestParams():参数错误", AppLog.LEVEL_ERROR);
        }

        return paramsStr;
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

    public static Response postRequest(Map<String, Object> map, String url) throws IOException {

        AppLog.out("postRequest->url:", url, AppLog.LEVEL_INFO);
        RequestBody body = RequestBody.create(JSON, fixRequestParams(map));
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        return execute(request);
    }
}

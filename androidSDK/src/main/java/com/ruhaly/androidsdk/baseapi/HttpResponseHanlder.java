package com.ruhaly.androidsdk.baseapi;

public abstract interface HttpResponseHanlder {
    public abstract void handleHttpError(Throwable throwable, int statusCode,
                                         String msg);

    //    public abstract void handleHttpSuccess(ResponseBody serviceRes,
    //            int requestId);
}
package com.ruhaly.androidsdk.baseapi;

/**
 * Created by hlr on 2015/9/21.
 */
public class CustomThrowable extends Throwable {

    private int code;

    public CustomThrowable(String detailMessage) {
        super(detailMessage);
    }

    public CustomThrowable(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}

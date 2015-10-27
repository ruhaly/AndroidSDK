package com.ruhaly.androidsdk.bean;

/**
 * Created by hlr on 2015/9/18.
 */
public class BaseResult {

    private int isOK;
    private String err;

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }

    public int getIsOK() {
        return isOK;
    }

    public void setIsOK(int isOK) {
        this.isOK = isOK;
    }
}

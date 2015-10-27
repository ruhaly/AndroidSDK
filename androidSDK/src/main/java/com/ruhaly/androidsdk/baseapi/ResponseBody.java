package com.ruhaly.androidsdk.baseapi;

/**
 * @author zhangxurong
 * @version 1.0, 2013-6-10
 */
public class ResponseBody {
    private int statusCode;

    //接口
    private String action;

    // 响应服务的结果，默认响应结果为200
    protected String resultCode;

    // 响应服务内容
    protected String resultParams;

    // 响应服务的结果描述
    protected String resultMessage;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getResultParams() {
        return resultParams;
    }

    public void setResultParams(String resultParams) {
        this.resultParams = resultParams;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    @Override
    public String toString() {
        return "ResponseBody [Action=" + action + ", resultCode=" + resultCode
                + ", ResultMessage=" + resultMessage + ", Params="
                + getResultParams() + "]";
    }
}

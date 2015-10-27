package com.ruhaly.androidsdk.view;

/**
 * Created by hlr on 2015/9/22.
 */
public interface ILoadDataView {

    /***
     * 耗时操作，加载数据，显示Progress
     */
    void showLoading();

    /***
     * 隐藏Progress
     */
    void hideLoading();

    /**
     * 公共异常处理
     *
     * @param throwable
     */
    void handleError(Throwable throwable);
}

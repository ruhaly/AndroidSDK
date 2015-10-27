package com.ruhaly.androidsdk.view;

import com.ruhaly.androidsdk.bean.LoginResult;

/**
 * Created by hlr on 2015/9/22.
 */
public interface ILoginView extends ILoadDataView {
    void notifyData(LoginResult result);
}

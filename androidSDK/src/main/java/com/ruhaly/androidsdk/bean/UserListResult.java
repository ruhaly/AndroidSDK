package com.ruhaly.androidsdk.bean;

import java.util.List;

/**
 * Created by hlr on 2015/10/28.
 */
public class UserListResult extends BaseResult {
    private List<UserBean> userBeanList;

    public List<UserBean> getUserBeanList() {
        return userBeanList;
    }

    public void setUserBeanList(List<UserBean> userBeanList) {
        this.userBeanList = userBeanList;
    }
}

package com.ruhaly.androidsdk.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ruhaly.androidsdk.baseapi.BaseFragment;
import com.ruhaly.androidsdk.presenter.LoginPresenter;

import nucleus.factory.RequiresPresenter;

/**
 * Created by hlr on 2015/9/21.
 */
@RequiresPresenter(LoginPresenter.class)
public class RegisterFragment extends BaseFragment<LoginPresenter> {
    @Override
    public void initData() {

    }

    @Override
    public View initLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }
}

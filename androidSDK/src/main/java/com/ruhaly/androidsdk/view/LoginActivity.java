package com.ruhaly.androidsdk.view;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.ruhaly.androidsdk.R;
import com.ruhaly.androidsdk.baseapi.BaseActivity;
import com.ruhaly.androidsdk.bean.LoginResult;
import com.ruhaly.androidsdk.presenter.LoginPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import nucleus.factory.RequiresPresenter;

@RequiresPresenter(LoginPresenter.class)
public class LoginActivity extends BaseActivity<LoginPresenter> implements ILoginView {


    @Bind(R.id.etName)
    EditText etName;
    @Bind(R.id.etPwd)
    EditText etPwd;

    @Override
    public void initData() {


    }

    @Override
    public void initLayout(Bundle paramBundle) {
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @Override
    public void initView() {

    }


    @OnClick(R.id.btnLogin)
    public void btnLoginClick(View view) {
        showLoading();
        getPresenter().requestLogin("", "");
    }

    @Override
    public void showLoading() {
        openWaittingDialog(this);
    }

    @Override
    public void hideLoading() {
        closeWaittingDialog();
    }

    @Override
    public void handleError(Throwable throwable) {
        super.handleError(throwable);
    }

    @Override
    public void notifyData(LoginResult result) {
    }
}

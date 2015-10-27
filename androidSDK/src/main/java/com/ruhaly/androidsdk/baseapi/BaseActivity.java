package com.ruhaly.androidsdk.baseapi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.ruhaly.androidsdk.R;

import nucleus.presenter.Presenter;
import nucleus.view.NucleusAppCompatActivity;

public abstract class BaseActivity<P extends Presenter> extends NucleusAppCompatActivity<P> implements BaseMsgWhat {
    public static String TAG = "BaseActivity";

    /**
     * 初始化数据.
     */
    public abstract void initData();

    /**
     * 初始化界面布局.
     *
     * @param paramBundle
     */
    public abstract void initLayout(Bundle paramBundle);

    /**
     * 初始化界面控件
     */
    public abstract void initView();


    /**
     * 初始化界面布局 .
     *
     * @param savedInstanceState
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        initData();
        initLayout(savedInstanceState);
        initView();
        TAG = this.getClass().getName();
        ActivityStack.getIns().pushActivity(this);
    }

    public void finish() {
        ActivityStack.getIns().popupActivity(this.getClass().getName());
        super.finish();
    }

    public void showToast(final String str) {
        Toast.makeText(getBaseContext(), str, Toast.LENGTH_SHORT).show();
    }


    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * 全屏
     */
    public void fullScreen() {
        WindowManager.LayoutParams attrs = getParent().getWindow()
                .getAttributes();
        attrs.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setAttributes(attrs);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    /**
     * 取消全屏
     */
    public void cancelFullScreen() {
        WindowManager.LayoutParams attrs = getParent().getWindow()
                .getAttributes();
        attrs.flags &= (~WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setAttributes(attrs);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    /**
     * 是否带有动画效果
     *
     * @param intent
     * @param isAnimation
     */
    public void startActivity(Intent intent, boolean isAnimation) {
        startActivity(intent);
        if (isAnimation)
            overridePendingTransition(R.anim.activity_scale_in,
                    R.anim.activity_scale_out);
    }

    /**
     * mHandler
     */
    public MHandler mHandler = new MHandler();

    @SuppressLint("HandlerLeak")
    public class MHandler extends Handler {
        /*
         * (non-Javadoc) (覆盖方法) 方法名称： handleMessage 作者： hanliangru 方法描述：
         * 
         * @see android.os.Handler#handleMessage(android.os.Message)
         */
        @Override
        public void handleMessage(Message msg) {
            handleMsg(msg);
        }
    }

    /**
     * 消息处理
     *
     * @param msg
     */
    public void handleMsg(Message msg) {
        switch (msg.what) {
            case CONNECT_ERROR_MSGWHAT: {
                showToast(getString(R.string.net_error));
                break;
            }
            case DATA_FORMAT_ERROR_MSGWHAT: {
                showToast(getString(R.string.date_format_error));
                break;
            }
            default:
                break;
        }
    }

    private CustomProgressDialog progressDialog = null;

    /**
     * 开启等待框
     * [功能详细描述]
     *
     * @param context
     */
    public CustomProgressDialog openWaittingDialog(final Context context,
                                                   DialogInterface.OnDismissListener dismiss) {
        if (null == dismiss) {
            dismiss = new DialogInterface.OnDismissListener() {

                @Override
                public void onDismiss(DialogInterface dialog) {
                }
            };
        }
        progressDialog = DialogUtils.startProgressDialog(context, dismiss, true);
        return progressDialog;
    }

    /**
     * 开启等待框
     * [功能详细描述]
     *
     * @param context
     */
    public void openWaittingDialog(Context context) {
        progressDialog = openWaittingDialog(context, null);
    }

    /**
     * 关闭等待框
     * [功能详细描述]
     */
    public void closeWaittingDialog() {
        if (null != progressDialog) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    /**
     * 处理异常
     *
     * @param throwable
     */
    public void handleError(Throwable throwable) {
        int code = ((CustomThrowable) throwable).getCode();
        switch (code) {
            case 500: {
                showToast(getString(R.string.server_error));
                break;
            }
            default: {
                showToast(getString(R.string.net_error));
                break;
            }
        }
    }

}

package com.ruhaly.androidsdk.baseapi;


import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;

import com.ruhaly.androidsdk.R;

/**
 * 通用等待框
 * [功能详细描述]
 *
 * @author hlr
 * @version [AndroidSdk, 2015年5月28日]
 */
public class CustomProgressDialog extends Dialog {

    private static CustomProgressDialog customProgressDialog = null;

    public CustomProgressDialog(Context context) {
        super(context);
    }

    public CustomProgressDialog(Context context, int theme) {
        super(context, theme);
    }

    ImageView imageView = null;

    public static CustomProgressDialog createDialog(Context context,
                                                    OnDismissListener dismiss, boolean cancelable) {
        customProgressDialog = new CustomProgressDialog(context,
                R.style.CustomProgressDialog);
        customProgressDialog.setCancelable(cancelable);
        customProgressDialog.setCanceledOnTouchOutside(false);
        customProgressDialog.setContentView(R.layout.customprogressdialog);
        customProgressDialog.getWindow().getAttributes().gravity = Gravity.CENTER;
        if (null != dismiss) {
            customProgressDialog.setOnDismissListener(dismiss);
        }
        customProgressDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode,
                                 KeyEvent event) {
                if (KeyEvent.KEYCODE_SEARCH == keyCode) {
                    return true;
                }
                return false;
            }
        });

        ImageView imageView = (ImageView) customProgressDialog.findViewById(R.id.loadingImageView);
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
        animationDrawable.start();
        return customProgressDialog;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        //        if (customProgressDialog == null)
        //        {
        //            return;
        //        }
        //        if (null == imageView)
        //        {
        //            imageView = (ImageView) customProgressDialog.findViewById(R.id.loadingImageView);
        //        }
        //        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
        //        animationDrawable.start();
        //        Toast.makeText(getContext(),
        //                "hasFocus:" + hasFocus + "运行：" + animationDrawable.isRunning(),
        //                Toast.LENGTH_SHORT).show();
    }

    /**
     * [Summary]
     * setTitile 标题
     *
     * @param strTitle
     * @return
     */
    public CustomProgressDialog setTitile(String strTitle) {
        return customProgressDialog;
    }

    /**
     * [Summary]
     * setMessage 提示内容
     *
     * @param strMessage
     * @return
     */
    public CustomProgressDialog setMessage(String strMessage) {
        TextView tvMsg = (TextView) customProgressDialog.findViewById(R.id.id_tv_loadingmsg);

        if (tvMsg != null) {
            tvMsg.setText(strMessage);
        }

        return customProgressDialog;
    }

}

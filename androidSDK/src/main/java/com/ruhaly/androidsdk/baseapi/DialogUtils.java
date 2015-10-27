package com.ruhaly.androidsdk.baseapi;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;

public class DialogUtils {

    public static CustomProgressDialog startProgressDialog(Context context,
                                                           OnDismissListener dismiss, boolean cancelable) {
        CustomProgressDialog progressDialog = CustomProgressDialog.createDialog(context,
                dismiss,
                cancelable);
        try {

            progressDialog.show();
        } catch (Exception e) {
            AppLog.out("DialogUtils", e.getMessage(), AppLog.LEVEL_ERROR);
        }
        return progressDialog;
    }
}

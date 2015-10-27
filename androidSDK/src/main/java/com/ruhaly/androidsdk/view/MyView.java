package com.ruhaly.androidsdk.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by hlr on 2015/9/23.
 */
public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
    }

}

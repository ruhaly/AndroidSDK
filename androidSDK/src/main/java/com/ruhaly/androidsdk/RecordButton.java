package com.ruhaly.androidsdk;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;

/**
 * Created by hlr on 2015/10/10.
 */
public class RecordButton extends Button {
    public RecordButton(Context context) {
        super(context);
    }

    public RecordButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RecordButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void scaleView(View view, float scaleXY) {
        if (android.os.Build.VERSION.SDK_INT > 10) {
            view.setScaleX(scaleXY);
            view.setScaleY(scaleXY);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        System.out.println("event.getAction()"+event.getAction());
        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN: {
                break;
            }
            case MotionEvent.ACTION_UP: {
                break;
            }
            case MotionEvent.ACTION_OUTSIDE:{

                break;
            }
            case MotionEvent.ACTION_MOVE: {
                if (event.getY()<0) {
                    setScaleX(1.5f);
                    setScaleY(1.5f);
                }
                break;
            }
        }
        return super.onTouchEvent(event);
    }
}

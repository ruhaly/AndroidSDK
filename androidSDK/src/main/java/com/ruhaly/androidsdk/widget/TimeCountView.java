package com.ruhaly.androidsdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.Button;

import com.ruhaly.androidsdk.R;

/**
 * Created by hlr on 2015/10/14.
 */
public class TimeCountView extends Button implements TimeCountViewListener {

    private CountDownTimer countDownTimer;

    private TimeCountViewListener mTimeCountViewListener;

    private static final int DEF_MILLISINFUTURE = 60 * 1000;

    private static final int DEF_COUNTDOWNINTERVAL = 1 * 1000;

    public TimeCountView(Context context) {
        super(context);
    }

    public TimeCountView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TimeCountView);

        int millisInFuture = typedArray.getInteger(R.styleable.TimeCountView_millisInFuture, DEF_MILLISINFUTURE);

        int countDownInterval = typedArray.getInteger(R.styleable.TimeCountView_countDownInterval, DEF_COUNTDOWNINTERVAL);
        countDownTimer = new CountDownTimer(millisInFuture, countDownInterval) {
            @Override
            public void onTick(long millisUntilFinished) {
                System.out.println("------------------------"+millisUntilFinished);
                setText(Math.round(millisUntilFinished / 1000f) + "秒");
            }

            @Override
            public void onFinish() {
                onFinishCount();
                setText("重新开始");
                setClickable(true);
            }
        };

    }

    public TimeCountView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * @param mTimeCountViewListener
     */
    public void setOnTimeCountListener(TimeCountViewListener mTimeCountViewListener) {
        this.mTimeCountViewListener = mTimeCountViewListener;
    }

    @Override
    public void onFinishCount() {
        mTimeCountViewListener.onFinishCount();
    }

    /**
     * 取消计数
     */
    public void cancelCount() {
        if (null != countDownTimer) {
            countDownTimer.cancel();
        }
        countDownTimer = null;
    }

    /**
     * 开始计数
     */
    public void countStart() {
        countDownTimer.start();
        setClickable(false);
    }
}

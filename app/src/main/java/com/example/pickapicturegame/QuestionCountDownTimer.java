package com.example.pickapicturegame;

import android.os.CountDownTimer;

public class QuestionCountDownTimer {
    private QuestionCountDownTimer(){}
    private static QuestionCountDownTimer mInstance;
    private CountDownTimer mCDTimer;
    private OnCountDownListener mListener;

    public static QuestionCountDownTimer getInstance(){
        if(mInstance==null)
            mInstance = new QuestionCountDownTimer();
        return mInstance;
    }

    public void setCountDownTimer(long total, long interval){
        if(mCDTimer!=null)
            mCDTimer.cancel();
        mCDTimer = new CountDownTimer(total,interval) {
            @Override
            public void onTick(long l) {
                mListener.onTick(l);
            }

            @Override
            public void onFinish() {
                mListener.onFinish();
            }
        };
        mCDTimer.start();
    }

    public void stopCountDown(){
        if(mCDTimer!=null)
            mCDTimer.cancel();
        mCDTimer = null;
    }

    public void setOnCountDownListener(OnCountDownListener listener){
        mListener = listener;
    }

    public interface OnCountDownListener{
        void onTick(long l);
        void onFinish();
    }
}

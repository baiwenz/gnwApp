package com.example.commonlibrary.utils;

import android.os.Handler;

import com.dd.processbutton.ProcessButton;

import java.util.Random;

public class ProgressGenerator {
    private int mProgress;
    public void setmProgress(int mProgress) {
        this.mProgress = mProgress;
    }
    public ProgressGenerator() {
    }
    public void start(final ProcessButton button) {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                System.out.println(mProgress);
                button.setProgress(mProgress);
                if (mProgress < 100&&mProgress>=0) {
                    handler.postDelayed(this, generateDelay());
                }
            }
        }, generateDelay());
    }
    private Random random = new Random();
    private int generateDelay() {
        return random.nextInt(1000);
    }
}

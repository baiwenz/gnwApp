package com.example.commonlibrary.ARouter;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;

public class LoginNavigationCallbackImpl implements NavigationCallback{
    @Override
    public void onFound(Postcard postcard) {

    }

    @Override
    public void onLost(Postcard postcard) {

    }

    @Override
    public void onArrival(Postcard postcard) {

    }

    @Override
    public void onInterrupt(Postcard postcard) {
        String path=postcard.getPath();
        Bundle bundle =postcard.getExtras();
        ARouter.getInstance()
                .build(Constance.LOGIN_ACTIVITY)
                .with(bundle)
                .withString(Constance.TEMP_PATH,path)
                .navigation();
    }
}

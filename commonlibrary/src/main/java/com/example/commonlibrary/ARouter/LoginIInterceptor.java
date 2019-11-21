package com.example.commonlibrary.ARouter;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * ARouter 登录拦截路由拦截
 * 在这里判断是否登录 并进行拦截或放行
 *
 */

@Interceptor(priority = 1)
public class LoginIInterceptor implements IInterceptor {
    private Context mContext;
    private static final String TAG = "LoginIInterceptor";
    @Override
    public void init(Context context) {
        mContext=context;
    }

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        Boolean isLogin =false;//这里判断是否登录
        String PATH=postcard.getPath();
        if (isLogin){
            callback.onContinue(postcard);
        }else {
            switch (PATH){
                case Constance.SEARCH_ACTIVITY:callback.onInterrupt(null);break;//这里写需要进行登录拦截的界面

                default:callback.onContinue(postcard);
            }
        }

    }

}

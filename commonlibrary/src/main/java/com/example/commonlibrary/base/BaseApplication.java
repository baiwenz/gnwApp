package com.example.commonlibrary.base;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.commonlibrary.BuildConfig;
import com.example.commonlibrary.http.BaseApiService;
import com.example.commonlibrary.http.RetrofitUtils;
import com.tencent.smtt.sdk.QbSdk;

import okhttp3.logging.HttpLoggingInterceptor;


public class BaseApplication extends Application {
    private static BaseApplication instance;
    private static Context appContext;
    public static BaseApiService basicUseService;

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        instance = this;
        appContext = instance.getApplicationContext();
        //初始化X内核
        initX5Webview();
        initARouter();
        initHttpConnect();

    }

    private void initARouter() {
        if (BuildConfig.DEBUG) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(getInstance()); // 尽可能早，推荐在Application中初始化
    }

    private void initX5Webview() {
        //搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {

            @Override
            public void onViewInitFinished(boolean arg0) {
                // TODO Auto-generated method stub
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                Log.d("app", " onViewInitFinished is " + arg0);
            }

            @Override
            public void onCoreInitFinished() {
                // TODO Auto-generated method stub
            }
        };
        //x5内核初始化接口
        QbSdk.initX5Environment(getApplicationContext(), cb);
    }

    public void initHttpConnect(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("114lalala", message);
            }
        });
        if (BuildConfig.DEBUG) {
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        }

        RetrofitUtils builder = RetrofitUtils.getInstance()
                .init(instance) //初始化
                .setLog(true)
                .setBaseUrl(UrlConfig.BASEURL)
                //                .setReadTimeOut(100)//默认 60000
                //                .setWriteTimeOut(100)//默认 60000
                //                .setConnectTimeout(100)//默认 60000
                .build()
                .create();
        basicUseService = builder.create(BaseApiService.class);
    }
    public static synchronized BaseApplication getInstance() {
        return instance;
    }

    public static Context getAppContext() {
        return appContext;
    }


}

package com.example.commonlibrary.base;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.commonlibrary.permission.PermissionUtils;
import com.example.commonlibrary.permission.request.IRequestPermissions;
import com.example.commonlibrary.permission.request.RequestPermissions;
import com.example.commonlibrary.permission.requestresult.IRequestPermissionsResult;
import com.example.commonlibrary.permission.requestresult.RequestPermissionsResultSetApp;
import com.example.commonlibrary.presenter.BasePresenter;
import com.example.commonlibrary.utils.FileProviderUtils;
import com.example.commonlibrary.utils.SystemProgramUtils;

import java.io.File;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 *
 * BaseActivity设置两个泛型——V和P，分别代表对应的View和Presenter。
 * @param <V>
 * @param <P>
 */
public abstract class BaseActivity<V, P extends BasePresenter<V>> extends AppCompatActivity   {
    public String TAG = getClass().getSimpleName().toString();
    protected Context mContext;
    private Unbinder mUnbinder;
    //表示层的引用
    protected P basePresenter;

    IRequestPermissions requestPermissions = RequestPermissions.getInstance();//动态权限请求
    IRequestPermissionsResult requestPermissionsResult = RequestPermissionsResultSetApp.getInstance();//动态权限请求结果处理

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayoutInflater());
        mUnbinder = ButterKnife.bind(this);
        mContext = this;
        //将子类创建的presenter 赋值给基类表示层
        basePresenter = createPresenter();
        if (basePresenter != null)
            //绑定
            basePresenter.onAttachView((V) this);
        ARouter.getInstance().inject(this);
        //requestPermissions();
        initView();
        initData();
    }


    protected <T> T findId(int id) {
        T view = (T) findViewById(id);
        return view;
    }
    private boolean requestPermissions(){
        //需要请求的权限
        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.CAMERA};
        //开始请求权限
        return requestPermissions.requestPermissions(
                this,
                permissions,
                PermissionUtils.ResultCode1);
    }
    protected abstract P createPresenter();

    protected abstract int initLayoutInflater(); //初始化布局

    public abstract void initView();

    public abstract void initData();

    private P getPresenter() {
        return basePresenter;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //用户给APP授权的结果
        //判断grantResults是否已全部授权，如果是，执行相应操作，如果否，提醒开启权限
        if(requestPermissionsResult.doRequestPermissionsResult(this, permissions, grantResults)){
            //请求的权限全部授权成功，此处可以做自己想做的事了
            //输出授权结果
            Toast.makeText(mContext,"授权成功，请重新点击刚才的操作！",Toast.LENGTH_LONG).show();
        }else{
            //输出授权结果
            Toast.makeText(mContext,"请给APP授权，否则功能无法正常使用！",Toast.LENGTH_LONG).show();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK) {
            return;
        }
        Uri filtUri;
        File outputFile = new File("/mnt/sdcard/tupian_out.jpg");//裁切后输出的图片
        switch (requestCode) {
            case SystemProgramUtils.REQUEST_CODE_PAIZHAO:
                //拍照完成，进行图片裁切
                File file = new File("/mnt/sdcard/tupian.jpg");
                filtUri = FileProviderUtils.uriFromFile(this, file);
                SystemProgramUtils.Caiqie(this, filtUri, outputFile);
                break;
            case SystemProgramUtils.REQUEST_CODE_ZHAOPIAN:
                //相册选择图片完毕，进行图片裁切
                if (data == null ||  data.getData()==null) {
                    return;
                }
                filtUri = data.getData();
                SystemProgramUtils.Caiqie(this, filtUri, outputFile);
                break;
            case SystemProgramUtils.REQUEST_CODE_CAIQIE:
                //图片裁切完成，显示裁切后的图片
                try {
                    Uri uri = Uri.fromFile(outputFile);
                    Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
                    //ivTupian.setImageBitmap(bitmap);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                break;
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null)
            mUnbinder.unbind();
        if (basePresenter != null)
            //解绑
            basePresenter.onDetachView();
    }
}

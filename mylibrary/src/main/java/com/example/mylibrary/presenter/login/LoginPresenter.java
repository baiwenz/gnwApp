package com.example.mylibrary.presenter.login;

import com.example.commonlibrary.interfaces.OnCallBackListener;
import com.example.commonlibrary.presenter.BasePresenter;
import com.example.commonlibrary.utils.Result;
import com.example.mylibrary.model.login.impl.LoginModelImpl;
import com.example.mylibrary.model.login.LoginModel;
import com.example.mylibrary.view.login.LoginView;

public class LoginPresenter<T extends LoginView> extends BasePresenter<T> {
    LoginModel loginModel = new LoginModelImpl();

    public LoginPresenter() {
    }

    public void Login(String username,String password){
        if(mTWeakReference.get()!=null){
            mTWeakReference.get().showLoading();
            if(loginModel!=null){
                loginModel.login(username,password,new OnCallBackListener<Result>() {
                    @Override
                    public void onSuccess(Result result) {
                        mTWeakReference.get().reBackLogin(result);
                    }

                    @Override
                    public void onFailed(String e) {
                        mTWeakReference.get().onError(e);
                    }
                });
            }
        }
    }
}

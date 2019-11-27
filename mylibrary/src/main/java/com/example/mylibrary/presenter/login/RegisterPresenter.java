package com.example.mylibrary.presenter.login;

import com.example.commonlibrary.interfaces.OnCallBackListener;
import com.example.commonlibrary.presenter.BasePresenter;
import com.example.commonlibrary.utils.Result;
import com.example.mylibrary.model.login.RegisterModel;
import com.example.mylibrary.model.login.impl.RegisterModelImpl;
import com.example.mylibrary.view.login.RegisterView;

public class RegisterPresenter<T extends RegisterView> extends BasePresenter<T> {
    RegisterModel registerModel = new RegisterModelImpl();

    public RegisterPresenter() {
    }

    public void postCode(String phoneNumber){
        if(mTWeakReference.get()!=null){
            mTWeakReference.get().showLoading();
            if(registerModel!=null){
                registerModel.postCode(phoneNumber, new OnCallBackListener<Result>() {
                    @Override
                    public void onSuccess(Result o) {
                        System.out.println(o);
                        mTWeakReference.get().rePostCode(o);
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

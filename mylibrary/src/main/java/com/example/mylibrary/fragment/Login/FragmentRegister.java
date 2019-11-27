package com.example.mylibrary.fragment.Login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.alibaba.android.arouter.facade.annotation.Route;
import com.dd.processbutton.ProcessButton;
import com.dd.processbutton.iml.ActionProcessButton;
import com.example.commonlibrary.ARouter.Constance;
import com.example.commonlibrary.base.BaseFragment;
import com.example.commonlibrary.base.Constants;
import com.example.commonlibrary.presenter.BasePresenter;
import com.example.commonlibrary.utils.ProgressGenerator;
import com.example.commonlibrary.utils.Result;
import com.example.mylibrary.R;
import com.example.mylibrary.presenter.login.RegisterPresenter;
import com.example.mylibrary.view.login.RegisterView;

@Route(path = Constance.REGISTER_FRAGMENT)
public class FragmentRegister
        extends BaseFragment<RegisterView, RegisterPresenter<RegisterView>>
        implements RegisterView,View.OnClickListener{
    private LoginActivity loginActivity;
    private EditText mPhone;
    private ActionProcessButton mGetCode;
    private static FragmentRegister mFragmentRegister;
    private FragmentInputCode mFragmentInputCode;
    private String phoneNumber;
    private ProgressGenerator progressGenerator = new ProgressGenerator();
    public static FragmentRegister newInstance(String param1) {
        mFragmentRegister = new FragmentRegister();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        mFragmentRegister.setArguments(args);
        return mFragmentRegister;
    }

    public FragmentRegister() {
    }

    @Override
    protected RegisterPresenter createPresenter() {
        return new RegisterPresenter();
    }

    @Override
    protected int initLayoutInflater() {
        return R.layout.fragment_register;
    }

    /**
     * 初始化视图
     * @param view
     */
    @Override
    public void initView(View view) {
        loginActivity=(LoginActivity) getActivity();
        mGetCode=view.findViewById(R.id.btn_get_code);
        mPhone=view.findViewById(R.id.edt_input_phone);
    }

    /**
     * 初始化数据
     */
    @Override
    public void initData() {
        mGetCode.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btn_get_code){
            postCode();
        }
    }

    @Override
    public void postCode() {
        phoneNumber= mPhone.getText().toString().trim();
        mPhone.setEnabled(false);
        mGetCode.setEnabled(false);
        basePresenter.postCode(phoneNumber);
    }

    @Override
    public void rePostCode(Result result) {
        if(true){
            progressGenerator.setmProgress(Constants.SUCCESS);
            Bundle bundle = new Bundle();
            bundle.putString("phoneNumber",phoneNumber);
            mFragmentInputCode=FragmentInputCode.newInstance(bundle);
            loginActivity.showFragment(mFragmentInputCode);
        }else {
            progressGenerator.setmProgress(Constants.ERROR);
            Toast.makeText(getActivity(),result.getMessage(),Toast.LENGTH_LONG).show();
        }
        mGetCode.setEnabled(true);
        mPhone.setEnabled(true);
    }

    @Override
    public void showLoading() {
        mGetCode.setMode(ActionProcessButton.Mode.ENDLESS);
        progressGenerator.setmProgress(Constants.STATR);
        progressGenerator.start(mGetCode);
    }

    @Override
    public void hideLoading(boolean b) {

    }

    @Override
    public void onError(Object result) {
        //rePostCode(new Result());
        progressGenerator.setmProgress(Constants.ERROR);
        mGetCode.setEnabled(true);
        mPhone.setEnabled(true);
    }
}

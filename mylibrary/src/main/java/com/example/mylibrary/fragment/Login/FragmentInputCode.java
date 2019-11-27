package com.example.mylibrary.fragment.Login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dd.processbutton.iml.ActionProcessButton;
import com.example.commonlibrary.base.BaseFragment;
import com.example.commonlibrary.presenter.BasePresenter;
import com.example.mylibrary.R;
import com.example.mylibrary.fragment.MessageFragment;

public class FragmentInputCode extends BaseFragment implements View.OnClickListener{
    private LoginActivity loginActivity;
    private EditText mCode;
    private ActionProcessButton mCheckCode;
    private static FragmentInputCode mFragmentInputCode;
    private FragmentSetPwd mFragmentSetPwd;
    private TextView tv_show;
    private TextView tv_code_fail;
    public static FragmentInputCode newInstance(Bundle bundle){
        mFragmentInputCode = new FragmentInputCode();
        mFragmentInputCode.setArguments(bundle);
        return mFragmentInputCode;
    }

    public FragmentInputCode() {
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int initLayoutInflater() {
        return R.layout.fragment_input_code;
    }

    @Override
    public void initView(View view) {
        loginActivity=(LoginActivity) getActivity();
        mCheckCode=view.findViewById(R.id.btn_submit_code);
        mCode=view.findViewById(R.id.edt_input_code);
        tv_show=view.findViewById(R.id.tv_show);
        tv_code_fail=view.findViewById(R.id.tv_code_fail);
    }

    @Override
    public void initData() {
        mCheckCode.setOnClickListener(this);
        tv_code_fail.setText("请你填一下你收到的验证码!给老子快点!");
        tv_show.setText("验证码已经发送到 "+mFragmentInputCode.getArguments().get("phoneNumber"));
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_submit_code){
            mFragmentSetPwd=FragmentSetPwd.newInstance("设置密码");
            loginActivity.showFragment(mFragmentSetPwd);
        }
    }
}

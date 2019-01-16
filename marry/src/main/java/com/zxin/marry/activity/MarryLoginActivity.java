package com.zxin.marry.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.marry.mvp.presenter.MainCriclePresenter;
import com.zxin.marry.mvp.presenter.UserLoginPresenter;
import com.zxin.marry.mvp.view.UserLoginContract;
import com.zxin.network.mvp.inject.InjectPresenter;

/**
 * Created by Administrator on 2018/6/13.
 */

public class MarryLoginActivity extends BaseActivity implements UserLoginContract.MarrayLoginView {
    @InjectPresenter
    UserLoginPresenter presenter;


    @Override
    public void initData() {
        presenter.initMarryLoginDatas(this);
        setViewOnclick(R.id.tv_account_login,R.id.tv_register,R.id.btn_login_verifycode,R.id.btn_login);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_marrylogin;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btn_login){
            presenter.verifyLogin(getETUserView().getText().toString().trim(),getETPassView().getText().toString().trim());
        } else if (v.getId()==R.id.btn_login_verifycode) {
            //发送验证码
           presenter.OnClick(v);
        } else if (v.getId()==R.id.tv_register) {
            //注册
            startActivity(new Intent(mContext,MarryRegisterActivity.class));
        } else if (v.getId()==R.id.tv_account_login) {
            //账号登录
            startActivity(new Intent(mContext,AccountLoginActivity.class));
            onBackPressed();
        }
    }

    @Override
    public EditText getETUserView() {
        return getViewById(R.id.et_user);
    }

    @Override
    public Button getBTNVerifycodeView() {
        return getViewById(R.id.btn_login_verifycode);
    }

    @Override
    public EditText getETPassView() {
        return getViewById(R.id.et_password);
    }

    @Override
    public Button getBTNLoginView() {
        return getViewById(R.id.btn_login);
    }
}

package com.zxin.marry.activity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.marry.mvp.presenter.MainCriclePresenter;
import com.zxin.marry.mvp.presenter.UserLoginPresenter;
import com.zxin.marry.mvp.view.MainCricleContract;
import com.zxin.marry.mvp.view.UserLoginContract;
import com.zxin.marry.util.StringUtils;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.util.ToastUtil;

/**
 * Created by Administrator on 2018/6/13.
 */

public class AccountLoginActivity extends BaseActivity implements UserLoginContract.AccountLoginView {
    @InjectPresenter
    UserLoginPresenter presenter;

    @Override
    public void initData() {
        setViewOnclick(R.id.btn_login,R.id.tv_phonelogin);
        presenter.initDatas(this);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_accountlogin;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btn_login){
            if (StringUtils.textIsEmpty(getUserNameView().getText().toString())) {
                ToastUtil.showShort("账号不能为空");
                return;
            }
            if (StringUtils.textIsEmpty(getUserPWDView().getText().toString())) {
                ToastUtil.showShort("密码不能为空");
                return;
            }
            presenter.accountLogin(getUserNameView().getText().toString(),getUserPWDView().getText().toString());
        }else if (v.getId()==R.id.tv_phonelogin){
            startActivity(new Intent(mContext, MarryLoginActivity.class));
            onBackPressed();
        }
    }

    @Override
    public EditText getUserNameView() {
        return getViewById(R.id.et_user);
    }

    @Override
    public EditText getUserPWDView() {
        return getViewById(R.id.et_password);
    }
}

package com.zxin.jdxsxp.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.zxin.jdxsxp.R;
import com.zxin.jdxsxp.base.BaseActivity;
import com.zxin.jdxsxp.mvp.presenter.XiGuaMainPresenter;
import com.zxin.jdxsxp.mvp.view.XiGuaMainContract;
import com.zxin.network.mvp.inject.InjectPresenter;

/**
 * Created by Administrator on 2018/9/5.
 */

public class UserLoginActivity extends BaseActivity implements XiGuaMainContract.UserLoginView {
    @InjectPresenter
    XiGuaMainPresenter presenter;

    @Override
    public void initData() {
        presenter.initUserLoginDatas(this);
        setTitleViewOnclick(R.id.ccb_jdxsxp_title,R.id.common_bar_leftBtn);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_userlogin;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_leftBtn){
            onBackPressed();
        }
    }

    @Override
    public EditText ed_phone() {
        return getViewById(R.id.ed_phone);
    }

    @Override
    public EditText ed_password() {
        return getViewById(R.id.ed_password);
    }

    @Override
    public TextView btn_login() {
        return getViewById(R.id.btn_login);
    }
}

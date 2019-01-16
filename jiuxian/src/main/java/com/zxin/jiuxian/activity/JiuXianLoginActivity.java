package com.zxin.jiuxian.activity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import com.zxin.jiuxian.R;
import com.zxin.jiuxian.base.BaseActivity;
import com.zxin.jiuxian.mvp.presenter.UserPresenter;
import com.zxin.jiuxian.mvp.view.UserContract;
import com.zxin.network.mvp.inject.InjectPresenter;

/**
 * Created by Administrator on 2018/8/3.
 */

public class JiuXianLoginActivity extends BaseActivity implements UserContract.PasswordLoginView {
    @InjectPresenter
    UserPresenter presenter;

    @Override
    public void initData() {
        setTitleViewOnclick(R.id.ccb_jiuxian_title,R.id.common_bar_leftBtn,R.id.common_bar_rightBtn);
        setViewOnclick(R.id.login_findpassword,R.id.login_phonefast_tv,R.id.login_btn);
        presenter.initDatas(this);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_jiuxian_login;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_leftBtn||v.getId()==R.id.login_phonefast_tv){
            onBackPressed();
            return;
        }
        if (v.getId()==R.id.common_bar_rightBtn){
            startActivity(new Intent(mContext, RegisterActivity.class));
            return;
        }
        if (v.getId()==R.id.login_findpassword){
            //忘记密码
            startActivity(new Intent(mContext, FindPasswordActivity.class));
            return;
        }
        presenter.OnClick(v);
    }

    @Override
    public EditText getEDTMobileView() {
        return getViewById(R.id.edt_login_mobile);
    }

    @Override
    public EditText getEDTPasswordView() {
        return getViewById(R.id.login_psw_edt);
    }
}

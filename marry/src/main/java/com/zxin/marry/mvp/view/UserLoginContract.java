package com.zxin.marry.mvp.view;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.zxin.marry.R;
import com.zxin.marry.activity.MarryMainActivity;
import com.zxin.marry.bean.Common;
import com.zxin.marry.bean.UserCommon;
import com.zxin.marry.mvp.presenter.UserLoginPresenter;
import com.zxin.marry.util.StringUtils;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.network.mvp.view.IBaseView;
import com.zxin.zxinlib.util.AppManager;
import com.zxin.zxinlib.util.RegUtil;
import com.zxin.zxinlib.util.SharedPreferencesManager;
import com.zxin.zxinlib.util.ToastUtil;

/**
 * Created by Administrator on 2018/5/24.
 */

public class UserLoginContract implements IBaseView{

    private Context mContext;

    @Override
    public void setParameter(Object... parameter) {

    }

    @Override
    public void initDatas() {

    }

    @Override
    public void loadDatas() {

    }

    @Override
    public void onResultSuccess(Object bean) {
        if (bean==null)
            return;
        UserCommon userCommon = (UserCommon)bean;
        SharedPreferencesManager.setMarryUserInfo(userCommon);
        SharedPreferencesManager.setMarryUserName(iView.getUserNameView().getText().toString());
        SharedPreferencesManager.setMarryPassword(iView.getUserPWDView().getText().toString());
        SharedPreferencesManager.setMarryUid(userCommon.getUid());
        SharedPreferencesManager.setEcshop(userCommon.getEcshop());
        mContext.startActivity(new Intent(mContext, MarryMainActivity.class));
        AppManager.getAppManager().finishCurrentActivity();
    }

    @Override
    public void onAddResult(boolean bool) {

    }

    @Override
    public void onUpdateResult(boolean bool) {

    }

    @Override
    public void onDeleteResult(boolean bool) {

    }

    @Override
    public void onComplete() {

    }

    @Override
    public void setContext(Context context) {
        this.mContext = context;
    }

    private UserLoginPresenter presenter;
    @Override
    public void setP(BasePresenter... basePresenter) {
        presenter = (UserLoginPresenter) basePresenter[0];
    }

    @Override
    public void OnClick(View v) {
        if (v.getId()== R.id.btn_login_verifycode){
            //发送验证码
            if (isCheckVerify(iMarrayLoginView.getETUserView())){
                presenter.sendVerifyLogin(iMarrayLoginView.getETUserView().getText().toString().trim());
            }
        }
    }

    private AccountLoginView iView;

    public void setAccountLoginViewListener(AccountLoginView testView){
        this.iView = testView;
    }
    public interface AccountLoginView{
        EditText getUserNameView();
        EditText getUserPWDView();
    }



    public void setMarrayLoginViewListener(MarrayLoginView iMarrayLoginView){
        this.iMarrayLoginView = iMarrayLoginView;
    }
    private MarrayLoginView iMarrayLoginView;
    public interface MarrayLoginView{
        EditText getETUserView();
        Button getBTNVerifycodeView();
        EditText getETPassView();
        Button getBTNLoginView();
    }

    //定时秒数
    private TimeCount time;
    public void initMarrayLoginViewDatas(){
        time = new TimeCount(60000, 1000);
        iMarrayLoginView.getBTNLoginView().setEnabled(false);
        iMarrayLoginView.getETUserView().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (StringUtils.textIsEmpty(iMarrayLoginView.getETUserView().getText().toString().trim()) || TextUtils.isEmpty(iMarrayLoginView.getETPassView().getText().toString().trim().trim()))
                    iMarrayLoginView.getBTNLoginView().setEnabled(false);
                else
                    iMarrayLoginView.getBTNLoginView().setEnabled(true);
            }
        });
        iMarrayLoginView.getETPassView().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (StringUtils.textIsEmpty(iMarrayLoginView.getETUserView().getText().toString().trim()) || TextUtils.isEmpty(iMarrayLoginView.getETPassView().getText().toString().trim().trim()))
                    iMarrayLoginView.getBTNLoginView().setEnabled(false);
                else
                    iMarrayLoginView.getBTNLoginView().setEnabled(true);
            }
        });
    }


    public boolean isCheckVerify(EditText phoneText) {
        String mPhone = phoneText.getText().toString().trim();
        if (TextUtils.isEmpty(mPhone)) {
            ToastUtil.topToast("请输入手机号！");
            setEtLoginMobile(iMarrayLoginView.getETUserView());
            return false;
        }
        if (!RegUtil.checkPhone(mPhone)) {
            ToastUtil.topToast("手机号有误，请重新输入");
            setEtLoginMobile(iMarrayLoginView.getETPassView());
            return false;
        }
        return true;
    }

    /**
     * 检查是不是正确
     *
     * @return
     */
    public boolean isCheck(EditText phoneText,EditText passText) {
        String mPhone = phoneText.getText().toString().trim();
        String mSecurity = passText.getText().toString().trim();
        if (TextUtils.isEmpty(mPhone)) {
            ToastUtil.topToast("请输入手机号！");
            setEtLoginMobile(phoneText);
            return false;
        }
        if (!RegUtil.checkPhone(mPhone)) {
            ToastUtil.topToast("手机号有误，请重新输入");
            setEtLoginMobile(phoneText);
            return false;
        }
        if (TextUtils.isEmpty(mSecurity)) {
            ToastUtil.topToast("请您输入验证码！");
            return false;
        }
        if (!RegUtil.isSecurity(mSecurity)) {
            ToastUtil.topToast("验证码输入有误");
            return false;
        }
        return true;
    }

    /**
     * 聚焦
     */
    public void setEtLoginMobile(EditText editText) {
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
    }

    /**
     * 倒计时的内部类
     *
     * @author Administrator 只要继承CountDownTimer 自会重写继承构造，方法
     */
    private class TimeCount extends CountDownTimer {
        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            iMarrayLoginView.getBTNVerifycodeView().setEnabled(false);// 设置不可点击
            iMarrayLoginView.getBTNVerifycodeView().setText(millisUntilFinished / 1000 + "s");
            if (millisUntilFinished / 1000 <= 1) {
                iMarrayLoginView.getBTNVerifycodeView().setEnabled(true);// 倒数一秒的时候 获得点击
                iMarrayLoginView.getBTNVerifycodeView().setText("获取验证码");
            }
        }

        @Override
        public void onFinish() {
            iMarrayLoginView.getBTNVerifycodeView().setEnabled(true);
        }
    }

    public void onResultSendVerifySuccess(Object bean) {
        if (bean==null)
            return;
        //倒计时
        time.start();
    }

    public void onResultVerifyLoginSuccess(Object bean) {
        if (bean==null)
            return;
        UserCommon userCommon = (UserCommon)bean;
        SharedPreferencesManager.setMarryUserInfo(userCommon);
        SharedPreferencesManager.setMarryUserName(iMarrayLoginView.getETUserView().getText().toString());
        SharedPreferencesManager.setMarryUid(userCommon.getUid());
        SharedPreferencesManager.setEcshop(userCommon.getEcshop());
        mContext.startActivity(new Intent(mContext, MarryMainActivity.class));
        AppManager.getAppManager().finishCurrentActivity();
    }

}

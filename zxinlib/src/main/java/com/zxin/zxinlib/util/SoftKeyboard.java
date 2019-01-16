package com.zxin.zxinlib.util;

import android.app.Activity;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.zxin.zxinlib.app.BaseApplication;

public class SoftKeyboard {

    /**
     * 打开软键盘
     *
     */
    public static void openKeybord(Activity mActivity,EditText mEditText) {
        if (mActivity != null){
            mEditText.requestFocus();
            InputMethodManager imm = (InputMethodManager)mActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(mEditText, InputMethodManager.SHOW_IMPLICIT);
        }
    }
    /**
     * 关闭软键盘
     */
    public static void closeKeybord(Activity mActivity, EditText mEditText) {
        if (mActivity != null){
            InputMethodManager imm = (InputMethodManager)mActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
            if(imm.isActive() && mActivity.getCurrentFocus()!=null){
                if (mActivity.getCurrentFocus().getWindowToken()!=null) {
                    imm.hideSoftInputFromWindow(mActivity.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                }
            }
        }
    }

    public static void hide(EditText editText) {
        editText.clearFocus();
        InputMethodManager imm = (InputMethodManager) BaseApplication.getInstance().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    //此方法只是关闭软键盘
    public static void hide(Activity mActivity) {
        InputMethodManager imm = (InputMethodManager) mActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive() && mActivity.getCurrentFocus() != null) {
            if (mActivity.getCurrentFocus().getWindowToken() != null) {
                imm.hideSoftInputFromWindow(mActivity.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }

}

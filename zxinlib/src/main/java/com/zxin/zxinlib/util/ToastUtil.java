package com.zxin.zxinlib.util;

import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import com.zxin.zxinlib.R;
import com.zxin.zxinlib.app.BaseApplication;

/**
 * Created by hy on 2017/10/16.
 */
public class ToastUtil {
    static String tag = ToastUtil.class.getSimpleName();

    /**
     * 顶部Toast
     * 非队列形式
     *
     * @param str
     */
    public static void topToast(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e(tag, "topToast str == null");
            return;
        }
        Toast mToast = Toast.makeText(BaseApplication.getInstance().getContext(), str, Toast.LENGTH_LONG);
        mToast.setDuration(Toast.LENGTH_LONG);
        int topHeight = (int) BaseApplication.getInstance().getContext().getResources()
                .getDimension(R.dimen.top_hight);
        mToast.setGravity(Gravity.TOP, 0, SystemInfoUtil.dip2px(topHeight));
        mToast.show();

    }

    /****
     * 提示信息显示
     * @param str
     */
    public static void showToast(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e(tag, "topToast str == null");
            return;
        }
        Toast mToast = Toast.makeText(BaseApplication.getInstance().getContext(), str, Toast.LENGTH_LONG);
        mToast.setDuration(Toast.LENGTH_LONG);
        mToast.show();
    }

    public static void showShort(String no_result) {
        if (TextUtils.isEmpty(no_result)) {
            Log.e(tag, "topToast str == null");
            return;
        }
        Toast.makeText(BaseApplication.getInstance(), no_result, Toast.LENGTH_SHORT).show();
    }

}

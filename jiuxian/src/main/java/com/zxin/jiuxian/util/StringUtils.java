package com.zxin.jiuxian.util;


import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;

import com.zxin.jiuxian.R;
import com.zxin.zxinlib.app.BaseApplication;
import com.zxin.zxinlib.util.BaseStringUtils;

import java.text.DecimalFormat;

/**
 * Created by Administrator on 2017/12/5.
 */

public class StringUtils extends BaseStringUtils {

    //Activity中需要注册RXBUS事件的类
    public static final String RxBusActivityNames = "";

    //Fragment中需要注册RXBUS事件的类
    public static final String EventBusFragmentNames = "";

    public static String exchangeWine(int paramInt) {
        switch (paramInt) {
            case 8:
                return "酒时尚";
            case 7:
                return "酒具周边";
            case 6:
                return "黄/保/啤";
            case 4:
                return "洋酒";
            case 3:
                return "葡萄酒";
            case 2:
                return "白酒";
        }
        return "一键选酒";
    }

    public static final String formatPriceA(double paramDouble) {
        return BaseApplication.getInstance().getResources().getString(R.string.rmb_identifier, new Object[]{new DecimalFormat("0.00").format(paramDouble)});
    }

    public static final String formatPriceE(double paramDouble) {
        SpannableString localObject = new SpannableString(BaseApplication.getInstance().getResources().getString(R.string.rmb_identifier, new Object[]{new DecimalFormat("0.00").format(paramDouble)}));
        localObject.setSpan(new RelativeSizeSpan(0.7F), 0, 1, 33);
        localObject.setSpan(new RelativeSizeSpan(0.8F), localObject.length() - 2, localObject.length(), 33);
        return localObject.toString();
    }


}

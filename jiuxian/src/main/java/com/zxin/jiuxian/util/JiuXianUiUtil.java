package com.zxin.jiuxian.util;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;

import com.zxin.jiuxian.R;
import com.zxin.root.util.UiUtils;

/**
 * Created by Administrator on 2018/8/16.
 */

public class JiuXianUiUtil extends UiUtils {

    public static GradientDrawable getRadiusColor(String color){
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(Color.parseColor(color));
        drawable.setCornerRadius(getCornerRadius(R.dimen.tag_roundradius));
        return drawable;
    }

}

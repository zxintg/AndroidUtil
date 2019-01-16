package com.zxin.zxinlib.util;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import com.zxin.zxinlib.R;
import com.zxin.zxinlib.app.BaseApplication;
import com.zxin.zxinlib.view.CustomGridLayoutManager;
import com.zxin.zxinlib.view.CustomLinearLayoutManager;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class UiUtils {

    public enum LayoutManager{
        HORIZONTAL,
        VERTICAL;
    }

    /******
     * 获取资源颜色
     * @param color
     * @return
     * liukui 2017/06/23 10:38
     */
    public static int getColor(int color){
        return ContextCompat.getColor(BaseApplication.getInstance().getContext(),color);
    }

    public static ColorStateList getColorStateList(int color){
        return ContextCompat.getColorStateList(BaseApplication.getInstance().getContext(),color);
    }

    public static List<Integer> getColorList() {
        List<Integer> colorList = new ArrayList<>();
        colorList.add(0,UiUtils.getColor(R.color.color_df0000));
        colorList.add(1,UiUtils.getColor(R.color.color_ff8000));
        colorList.add(2,UiUtils.getColor(R.color.color_c71585));
        colorList.add(3,UiUtils.getColor(R.color.color_9370db));
        colorList.add(4,UiUtils.getColor(R.color.color_db7093));
        colorList.add(5,UiUtils.getColor(R.color.color_f8080));
        colorList.add(6,UiUtils.getColor(R.color.color_ffa500));
        return colorList;
    }

    /*****
     * 获取本地资源文件
     * @param resources
     * @return
     *
     * liukui 2017/06/23 10:38
     *
     */
    public static Drawable getDrawable(int resources){
        return ContextCompat.getDrawable(BaseApplication.getInstance().getContext(),resources);
    }

    /*****
     * 格式化字符串
     * @param strRes
     * @param str
     * @return
     *
     * liukui 2017/06/23 10:38
     *
     */
    public static String getFormatString(int strRes ,Object str){
        return String.format(BaseApplication.getInstance().getContext().getResources().getString(strRes), str);
    }


    /**
     * 根据百分比改变颜色透明度
     */
    public static int changeAlpha(int color, float fraction) {
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        int alpha = (int) (Color.alpha(color) * fraction);
        return Color.argb(alpha, red, green, blue);
    }

    /****
     * 获取RecyclerView布局
     * @param orientation
     * @return
     */
    public static RecyclerView.LayoutManager getLayoutManager(LayoutManager orientation){
        CustomLinearLayoutManager linearLayoutManager = new CustomLinearLayoutManager(BaseApplication.getInstance().getContext());
        switch (orientation){
            case HORIZONTAL:
                linearLayoutManager.setOrientation(OrientationHelper.HORIZONTAL);
                break;

            case VERTICAL:
                linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
                break;
        }
        return linearLayoutManager;
    }

    public static RecyclerView.LayoutManager getGridLayoutManager(int spanCount){
        return new CustomGridLayoutManager(BaseApplication.getInstance().getContext(),spanCount);
    }

    public static String getString(int resId) {
        return BaseApplication.getInstance().getContext().getString(resId);
    }

    public static float getDimension(int resId) {
        return BaseApplication.getInstance().getContext().getResources()
                .getDimension(resId);
    }

    public static String getFromAssets(String fileName) {
        try {
            InputStream paramString = BaseApplication.getInstance().getContext().getResources().getAssets().open(fileName);
            byte[] arrayOfByte = new byte[paramString.available()];
            paramString.read(arrayOfByte);
            String txt = new String(arrayOfByte, "UTF-8");
            return txt;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static float getCornerRadius(int dimen){
       return BaseApplication.getInstance().getContext().getResources().getDimensionPixelOffset(dimen);
    }

}

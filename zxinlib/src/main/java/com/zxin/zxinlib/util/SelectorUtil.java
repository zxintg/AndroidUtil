package com.zxin.zxinlib.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

import java.io.IOException;
import java.net.URL;

/**
 * 动态设置 点击事件 selector 的工具类  可以从本地添加  也可以从网络添加
 * Created by suwenlai on 16-12-26.
 */

public class SelectorUtil {

    /**
     * 从 drawable 获取图片 id 给 Imageview 添加 selector
     *
     * @param context  调用方法的 Activity
     * @param idNormal 默认图片的 id
     * @param idPress  点击图片的 id
     * @param iv       点击的 view
     */
    public static void addSelectorFromDrawable(Context context, int idNormal, int idPress, ImageView iv) {

        StateListDrawable drawable = new StateListDrawable();
        Drawable normal = context.getResources().getDrawable(idNormal);
        Drawable press = context.getResources().getDrawable(idPress);
        drawable.addState(new int[]{android.R.attr.state_pressed}, press);
        drawable.addState(new int[]{-android.R.attr.state_pressed}, normal);
        iv.setBackgroundDrawable(drawable);
    }

    /**
     * 从 drawable 获取图片 id 给 Button 添加 selector
     *
     * @param context  调用方法的 Activity
     * @param idNormal 默认图片的 id
     * @param idPress  点击图片的 id
     * @param button   点击的 view
     */

    public static void addSelectorFromDrawable(Context context, int idNormal, int idPress, Button button) {

        StateListDrawable drawable = new StateListDrawable();
        Drawable normal = context.getResources().getDrawable(idNormal);
        Drawable press = context.getResources().getDrawable(idPress);
        drawable.addState(new int[]{android.R.attr.state_pressed}, press);
        drawable.addState(new int[]{-android.R.attr.state_pressed}, normal);
        button.setBackgroundDrawable(drawable);
    }

    /**
     * 从 drawable 获取图片 id 给 RadioButton 添加 selector
     * @param idNormal 默认图片的 id
     * @param idPress  点击图片的 id
     */
    public static void addSelectorFromDrawable(final int idNormal,final int idPress,final int weith,final int height,final RadioButton radioButton) {
        new AsyncTask<Void, Void, Drawable>() {

            @Override
            protected Drawable doInBackground(Void... params) {
                StateListDrawable drawable = new StateListDrawable();
                Drawable normal = ImageUtil.loadImageView(idNormal,weith,height);
                Drawable press = ImageUtil.loadImageView(idPress, weith, height);
                drawable.addState(new int[]{-android.R.attr.state_checked},normal);
                drawable.addState(new int[]{android.R.attr.state_checked},press);
                return drawable;
            }

            @Override
            protected void onPostExecute(Drawable drawable) {
                super.onPostExecute(drawable);
                radioButton.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
            }
        }.execute();
    }

    /**
     * 从网络获取图片 给 ImageView 设置 selector
     *
     * @param clazz     调用方法的类
     * @param normalUrl 获取默认图片的链接
     * @param pressUrl  获取点击图片的链接
     * @param imageView 点击的 view
     */
    public static void addSeletorFromNet(final Class clazz, final String normalUrl, final String pressUrl,final String name, final ImageView imageView) {
        new AsyncTask<Void, Void, Drawable>() {

            @Override
            protected Drawable doInBackground(Void... params) {
                StateListDrawable drawable = new StateListDrawable();
                Drawable normal = loadImageFromNet(normalUrl,name+"normal");
                Drawable press = loadImageFromNet(pressUrl,name+"press");
                drawable.addState(new int[]{android.R.attr.state_pressed}, press);
                drawable.addState(new int[]{-android.R.attr.state_pressed}, normal);
                return drawable;
            }

            @Override
            protected void onPostExecute(Drawable drawable) {
                super.onPostExecute(drawable);
                imageView.setBackgroundDrawable(drawable);
            }
        }.execute();
    }

    public static void addSeletorFromNet(final String normalUrl, final String pressUrl,final int weith,final int height, final RadioButton radioButton) {
        new AsyncTask<Void, Void, Drawable>() {

            @Override
            protected Drawable doInBackground(Void... params) {
                StateListDrawable drawable = new StateListDrawable();
                Drawable normal = ImageUtil.getBitMapForUrl(normalUrl,weith,height);
                Drawable press = ImageUtil.getBitMapForUrl(pressUrl, weith, height);
                drawable.addState(new int[]{-android.R.attr.state_checked},normal);
                drawable.addState(new int[]{android.R.attr.state_checked},press);
                return drawable;
            }

            @Override
            protected void onPostExecute(Drawable drawable) {
                super.onPostExecute(drawable);
                radioButton.setButtonDrawable(drawable);
            }
        }.execute();
    }

    /**
     * 从网络获取图片 给 Button 设置 selector
     *
     * @param clazz     调用方法的类
     * @param normalUrl 获取默认图片的链接
     * @param pressUrl  获取点击图片的链接
     * @param button    点击的 view
     */
    public static void addSeletorFromNet(final Class clazz, final String normalUrl, final String pressUrl,final String name, final Button button) {
        new AsyncTask<Void, Void, Drawable>() {

            @Override
            protected Drawable doInBackground(Void... params) {
                StateListDrawable drawable = new StateListDrawable();
                Drawable normal = loadImageFromNet(normalUrl,name+"normal");
                Drawable press = loadImageFromNet(pressUrl,name+"press");
                drawable.addState(new int[]{android.R.attr.state_pressed}, press);
                drawable.addState(new int[]{-android.R.attr.state_pressed}, normal);
                return drawable;
            }

            @Override
            protected void onPostExecute(Drawable drawable) {
                super.onPostExecute(drawable);
                button.setBackgroundDrawable(drawable);
            }
        }.execute();

    }

    /**
     * 从网络获取图片
     * @param netUrl 获取图片的链接
     * @return 返回一个 drawable 类型的图片
     */
    private static Drawable loadImageFromNet(String netUrl,String name) {
        Drawable drawable = null;
        try {
            drawable = Drawable.createFromStream(new URL(netUrl).openStream(), name+".jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return drawable;
    }
}

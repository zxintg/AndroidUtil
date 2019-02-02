package com.zxin.zxinlib.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;

import com.blankj.utilcode.util.StringUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.zxin.zxinlib.app.BaseApplication;
import com.zxin.zxinlib.bean.MenuEntity;
import com.zxin.zxinlib.bean.User;
import com.zxin.zxinlib.entity.City;
import java.util.List;

/****
 * 共享文件工具
 */
public class SharedPreferencesManager extends SharePrefUtils {

    /****
     * 保存用户信息
     * @param user
     */
    public static void setUserInfo(User user) {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.UserInfo_Datas, Context.MODE_PRIVATE);
        Editor editor = sp.edit();
        Gson gson = new Gson();
        editor.putString("user", gson.toJson(user));
        editor.commit();
    }

    /****
     * 获取用户信息
     * @return
     */
    public static User getUserInfo() {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.UserInfo_Datas, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        try {
            User user = gson.fromJson(sp.getString("user", ""), User.class);
            return user;
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    /****
     * 保存用户信息
     * @param data
     */
    public static void setPersonaInfo(String data) {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.UserInfo_Datas, Context.MODE_PRIVATE);
        Editor editor = sp.edit();
        editor.putString("Persona", data);
        editor.commit();
    }

    /*****
     * 保存是否第一次使用
     * @param isEnter
     */
    public static void setIsFirstEnter(boolean isEnter) {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.System_Datas, Context.MODE_PRIVATE);
        Editor editor = sp.edit();
        editor.putBoolean("isEnter", isEnter);
        editor.commit();
    }

    /****
     * 获取是否第一次装APP
     * @return
     */
    public static boolean getIsFirstEnter() {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.System_Datas, Context.MODE_PRIVATE);
        return sp.getBoolean("isEnter", true);
    }

    public static void setIsMarryEnter(boolean isEnter) {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.System_Datas, Context.MODE_PRIVATE);
        Editor editor = sp.edit();
        editor.putBoolean("isMarryEnter", isEnter);
        editor.commit();
    }

    public static boolean getIsMarryFirstEnter() {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.System_Datas, Context.MODE_PRIVATE);
        return sp.getBoolean("isMarryEnter", true);
    }

    public static String getDeviceId() {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.System_Datas, Context.MODE_PRIVATE);
        return sp.getString("device_id", "");
    }


    public static void setDeviceId(String param) {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.System_Datas, Context.MODE_PRIVATE);
        Editor editor = sp.edit();
        editor.putString("device_id", param);
        editor.commit();
    }

    public static void setMarryVersionName(String versionName) {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.Marry_Datas, Context.MODE_PRIVATE);
        Editor editor = sp.edit();
        editor.putString("VERSION_NAME", versionName);
        editor.commit();
    }

    public static String getMarryVersionName() {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.Marry_Datas, Context.MODE_PRIVATE);
        return sp.getString("VERSION_NAME","1.0.1");
    }

    public static void setMarryUserName(String versionName) {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.Marry_Datas, Context.MODE_PRIVATE);
        Editor editor = sp.edit();
        editor.putString("UserName", versionName);
        editor.commit();
    }

    public static String getMarryUsernName() {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.Marry_Datas, Context.MODE_PRIVATE);
        return sp.getString("UserName","");
    }

    public static void setMarryPassword(String password) {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.Marry_Datas, Context.MODE_PRIVATE);
        Editor editor = sp.edit();
        editor.putString("Password", password);
        editor.commit();
    }

    public static String getMarryPassword() {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.Marry_Datas, Context.MODE_PRIVATE);
        return sp.getString("Password","");
    }

    public static void setMarryUid(String uid) {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.Marry_Datas, Context.MODE_PRIVATE);
        Editor editor = sp.edit();
        editor.putString("uid", uid);
        editor.commit();
    }

    public static String getMarryUid() {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.Marry_Datas, Context.MODE_PRIVATE);
        return sp.getString("uid","");
    }

    /****
     * 保存用户信息
     * @param user
     */
    public static <T> void setMarryUserInfo(T user) {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.Marry_Datas, Context.MODE_PRIVATE);
        Editor editor = sp.edit();
        Gson gson = new Gson();
        editor.putString("UserInfo", gson.toJson(user));
        editor.commit();
    }

    /****
     * 获取用户信息
     * @return
     */
    public static<T> T getMarryUserInfo(Class<T> clazz) {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.Marry_Datas, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        try {
            return gson.fromJson(sp.getString("UserInfo", ""), clazz);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> void setInfoEntity(T user) {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.Marry_Datas, Context.MODE_PRIVATE);
        Editor editor = sp.edit();
        Gson gson = new Gson();
        editor.putString("InfoEntity", gson.toJson(user));
        editor.commit();
    }

    public static<T> T getInfoEntity(Class<T> clazz) {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.Marry_Datas, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        try {
            return gson.fromJson(sp.getString("InfoEntity", ""), clazz);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void setEcshop(String ecshop) {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.Marry_Datas, Context.MODE_PRIVATE);
        Editor editor = sp.edit();
        editor.putString("ecshop", ecshop);
        editor.commit();
    }

    public static String getEcshop(Context paramContext) {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.Marry_Datas, Context.MODE_PRIVATE);
        return sp.getString("ecshop","");
    }

    public static void setIsLogins(boolean islogin) {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.Marry_Datas, Context.MODE_PRIVATE);
        Editor editor = sp.edit();
        editor.putBoolean("islogin", islogin);
        editor.commit();
    }

    public static boolean getIsLogin() {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.Marry_Datas, Context.MODE_PRIVATE);
        return sp.getBoolean("islogin",false);
    }

    public static void setIsGif(boolean isGif) {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.Marry_Datas, Context.MODE_PRIVATE);
        Editor editor = sp.edit();
        editor.putBoolean("isGif", isGif);
        editor.commit();
    }

    public static boolean getIsGif() {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.Marry_Datas, Context.MODE_PRIVATE);
        return sp.getBoolean("isGif",false);
    }

    public static void setShopCart(String shopCart) {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.Marry_Datas, Context.MODE_PRIVATE);
        Editor editor = sp.edit();
        editor.putString("shopCart", shopCart);
        editor.commit();
    }

    public static String getShopCart() {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.Marry_Datas, Context.MODE_PRIVATE);
        return sp.getString("shopCart","");
    }

    public static void setMarrayDate(String marrayDate) {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.Marry_Datas, Context.MODE_PRIVATE);
        Editor editor = sp.edit();
        editor.putString("marrayDate", marrayDate);
        editor.commit();
    }

    public static String getMarrayDate() {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.Marry_Datas, Context.MODE_PRIVATE);
        return sp.getString("marrayDate","");
    }

    public static <T> void setMarryCity(T user) {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.Marry_Datas, Context.MODE_PRIVATE);
        Editor editor = sp.edit();
        Gson gson = new Gson();
        editor.putString("City", gson.toJson(user));
        editor.commit();
    }

    /****
     * 获取用户信息
     * @return
     */
    public static<T> T getMarryCity(Class<T> clazz) {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.Marry_Datas, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        try {
            if (!BaseStringUtils.textIsEmpty(sp.getString("City", "")))
            return gson.fromJson(sp.getString("City", ""), clazz);
            return null;
        } catch (JsonSyntaxException e) {
            return null;
        }
    }

    public static void clearMarryDatas() {
        Editor UserInfo_Datas = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.Marry_Datas, Context.MODE_PRIVATE).edit();
        UserInfo_Datas.clear();
        UserInfo_Datas.commit();
    }

    /*****
     * 获取地址信息
     * @return
     */
    public static String getCityId() {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.Share_Datas, Context.MODE_PRIVATE);
        return sp.getString("cityCode", "3101");
    }

    /****
     * 保存地址信息
     * @param cityCode
     */
    public static void saveCityId(String cityCode) {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.Share_Datas, Context.MODE_PRIVATE);
        Editor editor = sp.edit();
        editor.putString("cityCode", cityCode.substring(0, 4));
        editor.commit();
    }

    /****
     * 消息通知角标数
     * @return
     */
    public static int getBadgeCount() {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.BadgeCount, Context.MODE_PRIVATE);
        return sp.getInt("BadgeCount_parent", 0);
    }

    /****
     * 消息通知角标数
     */
    public static void setBadgeCount(int BadgeCount) {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.BadgeCount, Context.MODE_PRIVATE);
        Editor editor = sp.edit();
        editor.putInt("BadgeCount_parent", BadgeCount);
        editor.commit();
    }

    /*****
     * 获取手机号码
     */
    public static String getPhoneNum() {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.System_Datas, Context.MODE_PRIVATE);
        return sp.getString(BaseStringUtils.Share_Phone, "");
    }


    /*****
     * 保存手机号码
     * @param phoneNum
     */
    public static void savePhoneNum(String phoneNum) {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.System_Datas, Context.MODE_PRIVATE);
        Editor editor = sp.edit();
        editor.putString(BaseStringUtils.Share_Phone, phoneNum);
        editor.commit();
    }

    /****
     * 保存区县
     * @param subject
     */
    public static void saveArea(String subject) {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.Share_Datas, Context.MODE_PRIVATE);
        Editor editor = sp.edit();
        editor.putString(BaseStringUtils.Share_Area, subject);
        editor.commit();
    }


    /****
     * 保存城市
     * @param subject
     */
    public static void saveCity(String subject) {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.Share_Datas, Context.MODE_PRIVATE);
        Editor editor = sp.edit();
        editor.putString(BaseStringUtils.Share_City, subject);
        editor.commit();
    }

    /*****
     * 获取城市
     * @return
     */
    public static List<City> getCity() {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.Share_Datas, Context.MODE_PRIVATE);
        String subject = sp.getString(BaseStringUtils.Share_City, "");
        return TextUtils.isEmpty(subject) ? null : (List<City>) new Gson().fromJson(subject, new TypeToken<List<City>>() {
        }.getType());
    }

    /****
     * 清空用户本地缓存信息
     */
    public static void clearDatas() {
        Editor UserInfo_Datas = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.UserInfo_Datas, Context.MODE_PRIVATE).edit();
        UserInfo_Datas.clear();
        UserInfo_Datas.commit();
    }

    public static List<MenuEntity> getMineMenuList() {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.Share_Datas, Context.MODE_PRIVATE);
        String subject = sp.getString(BaseStringUtils.Share_MineMenu, "");
        List<MenuEntity> menuList = TextUtils.isEmpty(subject) ? null : (List<MenuEntity>) new Gson().fromJson(subject, new TypeToken<List<MenuEntity>>() {
        }.getType());

        if (menuList==null||menuList.isEmpty()){
            menuList = FileUtil.getInstance().getAllMenuList();
            saveMineMenu(menuList);
        }
        return menuList;
    }

    public static void saveMineMenu(List<MenuEntity> menuList) {
        SharedPreferences sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.Share_Datas, Context.MODE_PRIVATE);
        Editor editor = sp.edit();
        Gson gson = new Gson();
        editor.putString(BaseStringUtils.Share_MineMenu, gson.toJson(menuList));
        editor.commit();
    }

    public static String getAccessToken() {
        SharedPreferences sp = getSharedBeiKePreferences();
        return sp.getString(BaseStringUtils.access_token, "");
    }

    public static void setAccessToken(String access_token) {
        SharedPreferences.Editor editor = getSharedBeiKePreferences().edit();
        editor.putString(BaseStringUtils.access_token, access_token);
        editor.commit();
    }

    public static SharedPreferences getSharedBeiKePreferences() {
        return BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.Share_BeiKe_Datas, Context.MODE_PRIVATE);
    }

}

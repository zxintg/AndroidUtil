package com.zxin.jdxsxp.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.zxin.jdxsxp.bean.UserModel;
import com.zxin.basemodel.app.BaseApplication;
import com.zxin.basemodel.util.BaseStringUtils;
import com.zxin.root.util.SharedPreferencesManager;
import com.zxin.root.util.SystemInfoUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2018/7/23.
 */

public class MeiNvPicturePreferences extends SharedPreferencesManager {
    private static SharedPreferences sp;

    static {
        sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.MeiPicture_Datas, Context.MODE_PRIVATE);
    }

    public static UserModel getUserInfos() {
        String userInfo = sp.getString("userInfo", "");
        if (StringUtils.textIsEmpty(userInfo)){
            return null;
        }
        return new Gson().fromJson(userInfo,UserModel.class);
    }

    public static void setUserInfo(UserModel userInfo) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("userInfo", new Gson().toJson(userInfo));
        editor.commit();
    }

    public static long getUserId() {
        return sp.getLong("userId", -1);
    }

    public static void setUserId(long userId) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong("userId", userId);
        editor.commit();
    }

    public static List<String> getSearchHistoryArr() {
        List<String> list = new ArrayList<>();
        Set<String> values = sp.getStringSet("search_history", null);
        if (values == null)
            return list;
        list.addAll(values);
        return list;
    }

    public static void setSearchHistoryArr(List<String> history) {
        Set<String> values = new HashSet<>();
        for (String tag: history) {
            values.add(tag);
        }
        SharedPreferences.Editor editor = sp.edit();
        editor.putStringSet("search_history",values);
        editor.commit();
    }

    public static void clearSearchHistory() {
        SharedPreferences.Editor editor = sp.edit();
        editor.remove("search_history");
        editor.commit();
    }
}

package com.zxin.jdxsxp.api;

import android.provider.Settings;
import com.zxin.jdxsxp.bean.UserModel;
import com.zxin.jdxsxp.util.MeiNvPicturePreferences;
import com.zxin.jdxsxp.util.StringUtils;
import com.zxin.root.app.BaseApplication;
import com.zxin.root.util.SystemInfoUtil;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

/**
 * Created by Administrator on 2018/9/5.
 */

public class RequestParameter {

    private static final String versionCode = "2";
    private static final String versionName = "1.0.1";
    private static final String packId = "27";
    public static final String T_id = Settings.Secure.getString(BaseApplication.getInstance().getContext().getContentResolver(), "android_id");

    public static Map<String, String> commonParam() {
        TreeMap treeMap = new TreeMap();
        UserModel userInfo = MeiNvPicturePreferences.getUserInfos();
        if (userInfo != null) {
            treeMap.put("userId", String.valueOf(userInfo.getUserId()));
            treeMap.put("token", userInfo.getToken());
        }
        //treeMap.put("os", String.valueOf(OsEnum.ANDROID.getType()));
        treeMap.put("os", "1");
        treeMap.put("version", versionCode);
        treeMap.put("packId", packId);
        String str = StringUtils.getTD_CHANNEL_ID();
        if (!StringUtils.textIsEmpty(str)) {
            treeMap.put("channel", str);
        }
        return treeMap;
    }

    public static Map<String, String> commonParamExToken() {
        TreeMap treeMap = new TreeMap();
        UserModel userInfo = MeiNvPicturePreferences.getUserInfos();
        if (userInfo != null) {
            treeMap.put("userId", String.valueOf(userInfo.getUserId()));
        }
        //treeMap.put("os", String.valueOf(OsEnum.ANDROID.getType()));
        treeMap.put("os", "1");
        treeMap.put("version", versionCode);
        treeMap.put("packId", packId);
        String str = StringUtils.getTD_CHANNEL_ID();
        if (!StringUtils.textIsEmpty(str)) {
            treeMap.put("channel", str);
        }
        return treeMap;
    }

    public static Map<String, String> commonPhoneInfo() {
        TreeMap treeMap = new TreeMap();
        treeMap.put("udid", getDeviceIdentify());
        treeMap.put("mac", "");
        //treeMap.put("os", OsEnum.ANDROID.getType() + "");
        treeMap.put("os","1");
        String str = StringUtils.getTD_CHANNEL_ID();
        if (!StringUtils.textIsEmpty(str)) {
            treeMap.put("channel", str);
        }
        treeMap.put("device", getDeviceIdentify());
        //treeMap.put("osVersion", SystemUtil.getOSVersion());
        treeMap.put("osVersion", "");
        treeMap.put("lon", "0.0D");
        treeMap.put("lat", "0.0D");
        treeMap.put("version", versionCode);
        return treeMap;
    }

    public static Map<String, String> commonReq() {
        TreeMap treeMap = new TreeMap();
        //treeMap.put("os", String.valueOf(OsEnum.ANDROID.getType()));
        treeMap.put("os", "1");
        treeMap.put("version", versionCode);
        treeMap.put("packId", packId);
        String str = StringUtils.getTD_CHANNEL_ID();
        if (!StringUtils.textIsEmpty(str)) {
            treeMap.put("channel", str);
        }
        return treeMap;
    }

    private static String getDeviceIdentify() {
        String device_id = MeiNvPicturePreferences.getDeviceId();
        if (!StringUtils.textIsEmpty(device_id)) {
            return device_id;
        }
        device_id = getUUid();
        MeiNvPicturePreferences.setDeviceId(device_id);
        return device_id;

    }

    private static String getUUid() {
        try {
            if (!"9774d56d682e549c".equals(RequestParameter.T_id)) {
                return UUID.nameUUIDFromBytes(RequestParameter.T_id.getBytes("utf8")).toString();
            } else {
                UUID uuid = UUID.nameUUIDFromBytes(SystemInfoUtil.getPhoneNum().getBytes("utf8"));
                if (uuid == UUID.randomUUID()) {
                    return uuid.toString();
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

}

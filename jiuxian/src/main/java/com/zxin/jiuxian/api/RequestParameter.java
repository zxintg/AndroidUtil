package com.zxin.jiuxian.api;

import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;

import com.zxin.jiuxian.util.JiuXianSharedPreferences;
import com.zxin.jiuxian.util.StringUtils;
import com.zxin.root.app.BaseApplication;
import com.zxin.root.util.SystemInfoUtil;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

/**
 * Created by Administrator on 2018/8/8.
 */

public class RequestParameter {
    public static final String VersionName = "8.2.2";//version: 2.3.3_0413
    public static final String VersionCode = "12900";
    public static final String AppKey = "68af6dd28f724d4985494e77fc9444ec";
    public static final String T_id = Settings.Secure.getString(BaseApplication.getInstance().getContext().getContentResolver(), "android_id");


    protected static TreeMap<String, String> getRequestParameter(Map<String, String> paramMap) {
        TreeMap map = new TreeMap();
        //appkey=82479e883a338c303d3130d49f79cb01 gid=866413035430881
        map.put("appKey", "68af6dd28f724d4985494e77fc9444ec");//PackageManager.INSTALL_ALLOW_DOWNGRADE
        map.put("channelId", getChannel());
        map.put("os", Build.MODEL);
        map.put("resolution", getResolution());
        map.put("sysVersion", Build.VERSION.RELEASE);
        map.put("tid", T_id);
        map.put("version", VersionName); //versionCode: '12900' versionName: 8.2.2
        map.putAll(paramMap);
        return map;
    }

    private static String getResolution() {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(SystemInfoUtil.getScreenWidth());
        localStringBuilder.append("x");
        localStringBuilder.append(SystemInfoUtil.getScreenHeight());
        return localStringBuilder.toString();
    }

    public static String getChannel() {
        try {
            return BaseApplication.getInstance().getPackageManager().getApplicationInfo("com.jiuxianapk.ui", PackageManager.GET_META_DATA).metaData.getString("JIUXIAN_CHANNEL");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static boolean getAndroidSystemInfo() {
        return Build.FINGERPRINT.startsWith("generic") ||
                Build.FINGERPRINT.toLowerCase().contains("vbox") ||
                Build.FINGERPRINT.toLowerCase().contains("test-keys") ||
                Build.MODEL.contains("google_sdk") ||
                Build.MODEL.contains("Emulator") ||
                Build.MODEL.contains("Android SDK built for x86") ||
                Build.MANUFACTURER.contains("Genymotion") ||
                (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")) ||
                "google_sdk".equals(Build.PRODUCT);
    }

    public static String getAndroidDisplayMetrics() {
        StringBuilder builder = new StringBuilder();
        builder.append(SystemInfoUtil.getScreenWidth());
        builder.append("x");
        builder.append(SystemInfoUtil.getScreenHeight());
        return builder.toString();
    }

    public static Map<String, String> getParameter() {
        TreeMap treeMap = new TreeMap();
        try {
            treeMap.put("appVersion", RequestParameter.VersionName);
            treeMap.put("deviceType", "ANDROID");
            String channel = RequestParameter.getChannel();
            if (!StringUtils.textIsEmpty(channel))
                treeMap.put("cpsId", channel);

            String deviceId = getDeviceIdentify();
            if (!StringUtils.textIsEmpty(deviceId))
                treeMap.put("deviceIdentify", deviceId);

            String deviceType = deviceTypeExtra();
            if (!StringUtils.textIsEmpty(deviceType))
                treeMap.put("deviceTypeExtra", deviceType);

            treeMap.put("appKey", RequestParameter.T_id);
            String token = JiuXianSharedPreferences.token();
            if (!StringUtils.textIsEmpty(token))
                treeMap.put("token", token);
            treeMap.put("areaId", "500");
            treeMap.put("sysVersion", Build.VERSION.RELEASE);
            treeMap.put("screenReslolution", RequestParameter.getAndroidDisplayMetrics());
            treeMap.put("equipmentType", Build.MODEL);
            treeMap.put("supportWebp", "2");
            treeMap.put("netEnv", "4G");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return treeMap;
    }

    private static String getDeviceIdentify() throws UnsupportedEncodingException {
        String device_id = JiuXianSharedPreferences.getDeviceId();
        if (!StringUtils.textIsEmpty(device_id)) {
            return device_id;
        }
        if (!"9774d56d682e549c".equals(RequestParameter.T_id)) {
            device_id = UUID.nameUUIDFromBytes(RequestParameter.T_id.getBytes("utf8")).toString();
        } else {
            UUID uuid = UUID.nameUUIDFromBytes(SystemInfoUtil.getPhoneNum().getBytes("utf8"));
            if (uuid == UUID.randomUUID()) {
                device_id = uuid.toString();
            }
        }
        JiuXianSharedPreferences.setDeviceId(device_id);
        return device_id;
    }

    private static String deviceTypeExtra() throws UnsupportedEncodingException {
        String device_type = JiuXianSharedPreferences.device_type();
        if (!StringUtils.textIsEmpty(device_type)) {
            return device_type;
        }
        String info = "";
        if (RequestParameter.getAndroidSystemInfo()) {
            info = "1";
        } else {
            info = "0";
        }
        JiuXianSharedPreferences.device_type(info);
        return info;
    }
}

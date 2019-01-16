package com.zxin.zxinlib.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import com.zxin.zxinlib.app.BaseApplication;
import com.zxin.zxinlib.bean.AppInfoBean;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class SystemInfoUtil {

    public static final String TAG = SystemInfoUtil.class.getSimpleName();

    /**
     * 得到sdk 版本号
     *
     * @return
     */
    public static int getSdkVersion() {
        return Build.VERSION.SDK_INT;
    }

    /**
     * 判断网络是否可用
     *
     * @return
     */
    public static boolean isNetworkAvailable() {
        try {
            ConnectivityManager cm = (ConnectivityManager) BaseApplication.getInstance().getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netWorkInfo = cm.getActiveNetworkInfo();
            return (netWorkInfo != null && netWorkInfo.isAvailable());// 检测网络是否可用
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取当前手机系统版本号
     *
     * @return 系统版本号
     */
    public static String getSystemVersion() {
        return Build.VERSION.RELEASE;
    }

    /**
     * 获取手机型号
     *
     * @return 手机型号
     */
    public static String getSystemModel() {
        return Build.MODEL;
    }

    public static String getProjectName(Context _context) {
        PackageManager pm = _context.getPackageManager();
        String appName = _context.getApplicationInfo().loadLabel(pm).toString();
        return appName;
    }

    /**
     * 得到版本名称
     *
     * @return
     */
    public static String getVersionName() {
        try {
            return BaseApplication.contextApp.getPackageManager().getPackageInfo(BaseApplication.contextApp.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 得到版本号
     *
     * @return
     */
    public static int getVersionCode() {
        try {
            return BaseApplication.contextApp.getPackageManager().getPackageInfo(BaseApplication.contextApp.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            return -1;
        }
    }

    /****
     * 是否强行更新app
     * @return
     */
    public static boolean isUpdateApp(String webAppCode) {
        String[] localCode = getVersionName().split("\\.");
        String[] webCode = webAppCode.split("\\.");
        if (localCode.length != webCode.length)
            return true;
        if (localCode.length != 3)
            return true;
        return Integer.parseInt(localCode[0]) > Integer.parseInt(webCode[0]) || Integer.parseInt(localCode[1]) > Integer.parseInt(webCode[1]) || Integer.parseInt(localCode[2]) > Integer.parseInt(webCode[2]) + 2;
    }


    public static String getPackageName(Context context) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0);
            if (info != null) {
                return info.packageName;
            }
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getApplicationName() {
        PackageManager packageManager = null;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = BaseApplication.getInstance().getContext().getPackageManager();
            applicationInfo = packageManager.getApplicationInfo(getPackageName(BaseApplication.getInstance().getContext()), 0);
        } catch (NameNotFoundException e) {
            applicationInfo = null;
        }
        String applicationName =
                (String) packageManager.getApplicationLabel(applicationInfo);
        return applicationName;
    }

    public static String getPhoneNum() {
        TelephonyManager phoneMgr = (TelephonyManager) BaseApplication.getInstance().getContext().getSystemService(Context.TELEPHONY_SERVICE);
        return phoneMgr.getLine1Number();
    }

    public static String getIMEI(Context _context) {
        TelephonyManager _manager = (TelephonyManager) _context.getSystemService(Context.TELEPHONY_SERVICE);
        String _imei = _manager.getDeviceId(); // 取出IMEI
        return _imei;
    }

    public static String getICCID(Context _context) {
        TelephonyManager _manager = (TelephonyManager) _context.getSystemService(Context.TELEPHONY_SERVICE);
        String _iccid = _manager.getSimSerialNumber(); // 取出ICCID
        return _iccid;
    }

    public static String getIMSI(Context _context) {
        TelephonyManager _manager = (TelephonyManager) _context.getSystemService(Context.TELEPHONY_SERVICE);
        String _imsi = _manager.getSubscriberId(); // 取出IMSI
        return _imsi;
    }

    public static boolean isPad(Context _context) {
        if (Build.VERSION.SDK_INT >= 11) {
            Configuration con = _context.getResources().getConfiguration();
            try {
                Method mIsLayoutSizeAtLeast = con.getClass().getMethod("isLayoutSizeAtLeast", int.class);
                return (Boolean) mIsLayoutSizeAtLeast.invoke(con, 0x00000004);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static Intent call_1(String _phoneNum) {

        return new Intent(Intent.ACTION_CALL_BUTTON, Uri.parse("tel:" + _phoneNum));
    }

    /*****
     * 去拨号界面
     * @param _phoneNum
     * @return
     */
    public static void callDialing(String _phoneNum) {
        ActivityCompat.startActivity(BaseApplication.getInstance().getContext(), new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + _phoneNum)), null);
    }

    /**
     * 得到设备的唯一Id
     *
     * @return
     */
    public static String getInstallationId() {
        return Build.SERIAL;
    }

    /**
     * 获取屏幕参数
     */
    public static DisplayMetrics getDisplayMetrics() {
        return BaseApplication.getInstance().getContext().getResources().getDisplayMetrics();
    }

    /**
     * 得到设备屏幕的宽度
     */
    public static int getScreenWidth() {
        return getDisplayMetrics().widthPixels;
    }

    /**
     * 得到设备屏幕的高度
     */
    public static int getScreenHeight() {
        return getDisplayMetrics().heightPixels;
    }

    /**
     * 得到设备的密度
     */
    public static float getScreenDensity() {
        return getDisplayMetrics().density;
    }

    public static int dpTpPx(float value) {
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, getDisplayMetrics()) + 0.5);
    }

    /**
     * 把密度转换为像素
     */
    public static int dip2px(float px) {
        final float scale = getScreenDensity();
        return (int) (px * scale + 0.5);
    }

    public static int px2dip(float pxValue) {
        final float scale = getScreenDensity();
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 跳转到权限设置界面
     */
    public static void getSettingIntent() {

        // vivo 点击设置图标>加速白名单>我的app
        //点击软件管理>软件管理权限>软件>我的app>信任该软件
        Intent appIntent = BaseApplication.getInstance().getContext().getPackageManager().getLaunchIntentForPackage("com.iqoo.secure");
        if (appIntent != null) {
            BaseApplication.getInstance().getContext().startActivity(appIntent);
            return;
        }

        // oppo 点击设置图标>应用权限管理>按应用程序管理>我的app>我信任该应用
        //点击权限隐私>自启动管理>我的app
        appIntent = BaseApplication.getInstance().getContext().getPackageManager().getLaunchIntentForPackage("com.oppo.safe");
        if (appIntent != null) {
            BaseApplication.getInstance().getContext().startActivity(appIntent);
            return;
        }

        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (Build.VERSION.SDK_INT >= 9) {
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", getPackageName(BaseApplication.getInstance().getContext()), null));
        } else if (Build.VERSION.SDK_INT <= 8) {
            intent.setAction(Intent.ACTION_VIEW);
            intent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
            intent.putExtra("com.android.settings.ApplicationPkgName", getPackageName(BaseApplication.getInstance().getContext()));
        }
        BaseApplication.getInstance().getContext().startActivity(intent);
    }

    /**
     * 获取状态栏高度
     *
     * @return
     */
    public static int getStatusBarHeight() {
        int result = 0;
        int resourceId = BaseApplication.getInstance().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = BaseApplication.getInstance().getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public static boolean hasJellyBean() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN;
    }

    public static boolean hasLollipop() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }

    /*****
     * 查询本机所有可以分享
     * @return
     * @param share
     */
    public static List<AppInfoBean> canShareList(List<String> share) {
        List<AppInfoBean> canList = new ArrayList<>();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");//设置分享内容的类型 image/*、text/plain
        PackageManager pm = BaseApplication.contextApp.getPackageManager();
        List<ResolveInfo> resInfoList = pm.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        for (ResolveInfo resInfo : resInfoList) {
            String pkgName = resInfo.activityInfo.packageName; // 获得应用程序的包名
            if (share == null || share.isEmpty() || share.contains(pkgName)) {
                String activityName = resInfo.activityInfo.name; // 获得该应用程序的启动Activity的name
                String appLabel = (String) resInfo.loadLabel(pm); // 获得应用程序的Label
                String appName = resInfo.activityInfo.applicationInfo.loadLabel(pm).toString();
                Drawable icon = resInfo.loadIcon(pm); // 获得应用程序图标
                // 为应用程序的启动Activity 准备Intent
                Intent launchIntent = new Intent();
                launchIntent.setComponent(new ComponentName(pkgName, activityName));
                // 创建一个AppInfo对象，并赋值
                AppInfoBean appInfo = new AppInfoBean();
                appInfo.setAppName(appName);
                appInfo.setAppLabel(appLabel);
                appInfo.setPkgName(pkgName);
                appInfo.setAppIcon(icon);
                appInfo.setIntent(launchIntent);
                canList.add(appInfo);
            }
        }
        return canList;
    }

    /**
     * Retrieve launcher activity name of the application from the context
     *
     * @param context The context of the application package.
     * @return launcher activity name of this application. From the
     * "android:name" attribute.
     */
    public static String getLauncherClassName(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setPackage(context.getPackageName());
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        // All Application must have 1 Activity at least.
        // Launcher activity must be found!
        ResolveInfo info = packageManager
                .resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        // get a ResolveInfo containing ACTION_MAIN, CATEGORY_LAUNCHER
        // if there is no Activity which has filtered by CATEGORY_DEFAULT
        if (info == null) {
            info = packageManager.resolveActivity(intent, 0);
        }
        //////////////////////另一种实现方式//////////////////////
        // ComponentName componentName = context.getPackageManager().getLaunchIntentForPackage(mContext.getPackageName()).getComponent();
        // return componentName.getClassName();
        //////////////////////另一种实现方式//////////////////////
        return info.activityInfo.name;
    }

    /******
     * 获取当前
     * @return
     */
    public static View getCurrentView() {
        FrameLayout contentParent = (FrameLayout) AppManager.getAppManager().currentActivity().getWindow().getDecorView().findViewById(android.R.id.content);
        return contentParent.getFocusedChild();
    }

    /*****
     * 判断手机中是否安装了
     * @param packageName
     * @return
     */
    public static boolean isPackageInstalled(String packageName) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = BaseApplication.getInstance().getContext().getPackageManager().getPackageInfo(packageName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
            e.printStackTrace();
        } finally {
            return packageInfo != null;
        }
    }

    /****
     * 剪切板
     * @param title
     * @param mesg
     */
    public static void systemClipBoard(String title, String mesg) {
        ((ClipboardManager) BaseApplication.getInstance().getSystemService(Context.CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText(title, mesg));
    }

    public static String getActivityMetaData(String tagName) {
        ActivityInfo info = null;
        try {
            info = BaseApplication.getInstance().getContext().getPackageManager()
                    .getActivityInfo(AppManager.getAppManager().currentActivity().getComponentName(),
                            PackageManager.GET_META_DATA);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return info == null? "" : info.metaData.getString(tagName);
    }

    public static String getAppMetaData(String tagName) {
        ApplicationInfo info = null;
        try {
            info = BaseApplication.getInstance().getContext().getPackageManager()
                    .getApplicationInfo(BaseApplication.getInstance().getContext().getPackageName(),
                            PackageManager.GET_META_DATA);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return info == null? "" : info.metaData.getString(tagName);
    }

    public static String getServiceMetaData(String tagName,Class service) {
        ServiceInfo info = null;
        try {
            info = BaseApplication.getInstance().getContext().getPackageManager()
                    .getServiceInfo(new ComponentName(BaseApplication.getInstance().getContext(), service),
                            PackageManager.GET_META_DATA);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return info == null? "" : info.metaData.getString(tagName);
    }

    public static String getReceiverMetaData(String tagName,Class service) {
        ActivityInfo info = null;
        try {
            info = BaseApplication.getInstance().getContext().getPackageManager()
                    .getReceiverInfo(new ComponentName(BaseApplication.getInstance().getContext(), service),
                            PackageManager.GET_META_DATA);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return info == null? "" : info.metaData.getString(tagName);
    }

    public static String getAndroidId(){
        return Settings.System.getString(BaseApplication.getInstance().getContext().getContentResolver(), Settings.System.ANDROID_ID);
    }

    public static PowerManager.WakeLock getPowerManager(){
        PowerManager pm = (PowerManager) BaseApplication.getInstance().getContext().getSystemService(Context.POWER_SERVICE);
        return pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK, "liveTAG");
    }

}

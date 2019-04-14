package com.zxin.basemodel.util;

import android.app.Activity;
import android.content.Intent;

import com.zxin.basemodel.activity.CommWebActivity;
import com.zxin.root.util.AppManager;
import com.zxin.root.view.banner.BannerBean;
/**
 * Created by Html跳转公共处理 on 2017/12/29.
 */

public class HtmlJumpUtil {

    /*****
     * 服务协议
     */
    public static void fwxyActivity(){
        Activity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, CommWebActivity.class);
        intent.putExtra(BaseStringUtils.ACTIVITY_title,"服务协议");
        intent.putExtra(BaseStringUtils.WEB_TYPE,BaseStringUtils.WEB_TYPE_fileHtml5);
        intent.putExtra(BaseStringUtils.url,"user_agreement.html");
        activity.startActivity(intent);
    }

    /*****
     * 关于我们
     */
    public static void gywmActivity(){
        Activity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, CommWebActivity.class);
        intent.putExtra(BaseStringUtils.ACTIVITY_title,"关于我们");
        intent.putExtra(BaseStringUtils.WEB_TYPE,BaseStringUtils.WEB_TYPE_url);
        intent.putExtra(BaseStringUtils.url,"https://www.jianshu.com/u/38dae1253ae5");
        activity.startActivity(intent);
    }

    /*****
     * 首页banner点击
     */
    public static void bannerActivity(BannerBean banner){
        Activity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, CommWebActivity.class);
        intent.putExtra(BaseStringUtils.ACTIVITY_title,banner.getAdName());
        intent.putExtra(BaseStringUtils.WEB_TYPE,BaseStringUtils.WEB_TYPE_url);
        intent.putExtra(BaseStringUtils.url,banner.getPicLink());
        activity.startActivity(intent);
    }

    /****
     * 用户协议
     */
    public static void yhxyActivity(){
        Activity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, CommWebActivity.class);
        intent.putExtra(BaseStringUtils.ACTIVITY_title,"霸气侧漏服务协议");
        intent.putExtra(BaseStringUtils.WEB_TYPE,BaseStringUtils.WEB_TYPE_fileHtml5);
        intent.putExtra(BaseStringUtils.url,"user_agreement.html");
        activity.startActivity(intent);
    }

    public static void toWebForUrlActivity(String title ,String url){
        Activity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, CommWebActivity.class);
        intent.putExtra(BaseStringUtils.ACTIVITY_title,title);
        intent.putExtra(BaseStringUtils.WEB_TYPE,BaseStringUtils.WEB_TYPE_url);
        intent.putExtra(BaseStringUtils.url,url);
        activity.startActivity(intent);
    }


}

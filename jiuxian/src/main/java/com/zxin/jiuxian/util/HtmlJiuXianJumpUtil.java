package com.zxin.jiuxian.util;

import android.app.Activity;
import android.content.Intent;
import com.zxin.basemodel.util.HtmlJumpUtil;
import com.zxin.jiuxian.activity.JiuXianWebActivity;
import com.zxin.root.util.AppManager;
import com.zxin.root.util.BaseStringUtils;

/**
 * Created by Administrator on 2018/8/17.
 */

public class HtmlJiuXianJumpUtil extends HtmlJumpUtil {


    public static void toJiuXianWebForUrlActivity(String title ,String url){
        Activity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, JiuXianWebActivity.class);
        intent.putExtra(BaseStringUtils.ACTIVITY_title,title);
        intent.putExtra(BaseStringUtils.WEB_TYPE,BaseStringUtils.WEB_TYPE_url);
        intent.putExtra(BaseStringUtils.url,url);
        activity.startActivity(intent);
    }
}

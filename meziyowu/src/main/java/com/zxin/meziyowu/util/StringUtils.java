package com.zxin.meziyowu.util;


import com.zxin.meziyowu.activity.YoMeiCollectActivity;
import com.zxin.meziyowu.activity.YoMeiLocalVideoActivity;
import com.zxin.root.util.BaseStringUtils;

/**
 * Created by Administrator on 2017/12/5.
 */

public class StringUtils extends BaseStringUtils {

    //Activity中需要注册RXBUS事件的类
    public static final String RxBusActivityNames = YoMeiCollectActivity.class.getName()+
                                                            YoMeiLocalVideoActivity.class.getName();

    //Fragment中需要注册RXBUS事件的类
    public static final String EventBusFragmentNames = "";

}

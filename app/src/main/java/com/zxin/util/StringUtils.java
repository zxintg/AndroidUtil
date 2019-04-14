package com.zxin.util;


import com.zxin.activity.AddressListActivity;
import com.zxin.activity.EditTitleActivity;
import com.zxin.activity.HttpUrlDetailActivity;
import com.zxin.activity.MainActivity;
import com.zxin.basemodel.util.BaseStringUtils;

/**
 * Created by Administrator on 2017/12/5.
 */

public class StringUtils extends BaseStringUtils {

    //Activity中需要注册RXBUS事件的类
    public static final String RxBusActivityNames = MainActivity.class.getName()
            + HttpUrlDetailActivity.class.getName()
            + AddressListActivity.class.getName()
            + EditTitleActivity.class.getName();

    //Fragment中需要注册RXBUS事件的类
    public static final String EventBusFragmentNames = "";
}

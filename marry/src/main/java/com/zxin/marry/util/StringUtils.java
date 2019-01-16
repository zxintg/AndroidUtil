package com.zxin.marry.util;


import com.zxin.marry.activity.MarryMainActivity;
import com.zxin.marry.activity.ShippingAddressActivity;
import com.zxin.marry.fragment.DiscoveryFragment;
import com.zxin.marry.fragment.MineFragment;
import com.zxin.marry.fragment.UserOrderFragment;
import com.zxin.marry.fragment.discovery.DiscoveryCityFragment;
import com.zxin.marry.fragment.discovery.NationwideFragment;
import com.zxin.marry.fragment.order.NewCircuitViewFragment;
import com.zxin.zxinlib.util.BaseStringUtils;

/**
 * Created by Administrator on 2017/12/5.
 */

public class StringUtils extends BaseStringUtils {

    //Activity中需要注册RXBUS事件的类
    public static final String RxBusActivityNames = MarryMainActivity.class.getName()
            + ShippingAddressActivity.class.getName();

    //Fragment中需要注册RXBUS事件的类
    public static final String EventBusFragmentNames = MineFragment.class.getName()
            + UserOrderFragment.class.getName()
            + NewCircuitViewFragment.class.getName()
            + DiscoveryFragment.class.getName()
            + DiscoveryCityFragment.class.getName()
            ;
}

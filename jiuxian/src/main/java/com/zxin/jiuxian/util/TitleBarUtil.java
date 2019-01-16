package com.zxin.jiuxian.util;

import com.zxin.jiuxian.R;
import com.zxin.jiuxian.bean.CateLeftPageResult;
import com.zxin.jiuxian.bean.HomeHeaderResult;
import com.zxin.jiuxian.bean.HomeTabIconResult;
import com.zxin.jiuxian.bean.MainBarBean;
import com.zxin.jiuxian.fragment.ClassifyAllFragment;
import com.zxin.jiuxian.fragment.ClassifyFragment;
import com.zxin.jiuxian.fragment.ClassifyItemFragment;
import com.zxin.jiuxian.fragment.CommunityFragment;
import com.zxin.jiuxian.fragment.CouponItemFragment;
import com.zxin.jiuxian.fragment.HomeFragment;
import com.zxin.jiuxian.fragment.MineFragment;
import com.zxin.jiuxian.fragment.OrderItemFragment;
import com.zxin.jiuxian.fragment.ProductCommentsFragment;
import com.zxin.jiuxian.fragment.ProductDetailFragment;
import com.zxin.jiuxian.fragment.ProductGoodsFragment;
import com.zxin.jiuxian.fragment.ShoppingCarFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/12.
 * <p>
 * JVM只会加载一次单例类。可以使用同步锁来解决多线程不安全的问题
 */

public class TitleBarUtil {

    private static TitleBarUtil instance = null;

    private TitleBarUtil() {

    }

    public static TitleBarUtil newInstance() {
        synchronized (TitleBarUtil.class) {
            if (instance == null) {
                instance = new TitleBarUtil();
            }
            return instance;
        }
    }

    public ArrayList<MainBarBean> getBarTitleList(List<HomeTabIconResult.IconInfo> iconList) {
        ArrayList<MainBarBean> titleList = new ArrayList<>();
        MainBarBean titleBean = new MainBarBean();
        titleBean.label = "首页";
        titleBean.labSource = R.drawable.selector_tab_home;
        titleBean.fragment = HomeFragment.newInstance(titleBean);
        titleBean.index = 0;
        titleList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "分类";
        titleBean.labSource = R.drawable.selector_tab_category;
        titleBean.fragment = ClassifyFragment.newInstance(titleBean);
        titleBean.index = 1;
        titleList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "社区";
        titleBean.labSource = R.drawable.selector_tab_community;
        titleBean.fragment = CommunityFragment.newInstance(titleBean);
        titleBean.index = 2;
        titleList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "购物车";
        titleBean.labSource = R.drawable.selector_tab_cart;
        titleBean.fragment = ShoppingCarFragment.newInstance(titleBean);
        titleBean.index = 3;
        titleList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "我的酒仙";
        titleBean.labSource = R.drawable.selector_tab_usercenter;
        titleBean.fragment = MineFragment.newInstance(titleBean);
        titleBean.index = 4;
        titleList.add(titleBean);


        if (iconList != null && !iconList.isEmpty()) {
            for (HomeTabIconResult.IconInfo iconInfo : iconList) {
                if (StringUtils.textIsEmpty(iconInfo.drakImg) || StringUtils.textIsEmpty(iconInfo.lightImg))
                    continue;
                switch (iconInfo.logicType) {

                    case "home":
                        MainBarBean home = titleList.get(0);
                        titleList.remove(0);
                        home.labSourceUrl_normal = iconInfo.lightImg;
                        home.labSourceUrl_press = iconInfo.drakImg;
                        home.title = iconInfo.logicType;
                        titleList.add(0, home);
                        break;

                    case "category":
                        MainBarBean category = titleList.get(1);
                        titleList.remove(1);
                        category.labSourceUrl_normal = iconInfo.lightImg;
                        category.labSourceUrl_press = iconInfo.drakImg;
                        category.title = iconInfo.logicType;
                        titleList.add(1, category);
                        break;

                    case "community":
                        MainBarBean community = titleList.get(2);
                        titleList.remove(2);
                        community.labSourceUrl_normal = iconInfo.lightImg;
                        community.labSourceUrl_press = iconInfo.drakImg;
                        community.title = iconInfo.logicType;
                        titleList.add(2, community);
                        break;

                    case "shoppingCart":
                        MainBarBean shoppingCart = titleList.get(3);
                        titleList.remove(3);
                        shoppingCart.labSourceUrl_normal = iconInfo.lightImg;
                        shoppingCart.labSourceUrl_press = iconInfo.drakImg;
                        shoppingCart.title = iconInfo.logicType;
                        titleList.add(3, shoppingCart);
                        break;

                    case "myJiuXian":
                        MainBarBean myJiuXian = titleList.get(4);
                        titleList.remove(4);
                        myJiuXian.labSourceUrl_normal = iconInfo.lightImg;
                        myJiuXian.labSourceUrl_press = iconInfo.drakImg;
                        myJiuXian.title = iconInfo.logicType;
                        titleList.add(4, myJiuXian);
                        break;

                    default:
                        titleBean = new MainBarBean();
                        titleBean.label = iconInfo.logicType;
                        titleBean.labSourceUrl_normal = iconInfo.lightImg;
                        titleBean.labSourceUrl_press = iconInfo.drakImg;
                        titleBean.title = iconInfo.logicType;
                        titleBean.fragment = MineFragment.newInstance(titleBean);
                        titleBean.index = titleList.size();
                        titleList.add(titleBean);
                        break;
                }
            }
        }
        return titleList;
    }

    public ArrayList<MainBarBean> getClassifyTitleList(List<CateLeftPageResult.CateListItem> mCateList) {
        ArrayList<MainBarBean> titleList = new ArrayList<>();
        for (CateLeftPageResult.CateListItem cateListItem : mCateList) {
            MainBarBean titleBean = new MainBarBean();
            titleBean.label = cateListItem.cateName;
            titleBean.id = cateListItem.cateIdAlias;
            if (titleBean.label.equals("一键选酒"))
                titleBean.fragment = ClassifyAllFragment.newInstance(titleBean);
            else
                titleBean.fragment = ClassifyItemFragment.newInstance(titleBean);
            titleBean.index = mCateList.indexOf(cateListItem);
            titleList.add(titleBean);
        }
        return titleList;
    }

    public ArrayList<MainBarBean> getOrderTitleList() {
        ArrayList<MainBarBean> titleList = new ArrayList<>();
        MainBarBean titleBean = new MainBarBean();
        titleBean.label = "全部";
        titleBean.fragment = OrderItemFragment.newInstance(titleBean);
        titleBean.index = 0;
        titleList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "待付款";
        titleBean.fragment = OrderItemFragment.newInstance(titleBean);
        titleBean.index = 1;
        titleList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "待发货";
        titleBean.fragment = OrderItemFragment.newInstance(titleBean);
        titleBean.index = 2;
        titleList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "待收货";
        titleBean.fragment = OrderItemFragment.newInstance(titleBean);
        titleBean.index = 3;
        titleList.add(titleBean);

        return titleList;
    }

    public ArrayList<MainBarBean> getUserCouponList() {
        ArrayList<MainBarBean> titleList = new ArrayList<>();
        MainBarBean titleBean = new MainBarBean();
        titleBean.label = "未使用";
        titleBean.fragment = CouponItemFragment.newInstance(titleBean);
        titleBean.index = 0;
        titleList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "已使用";
        titleBean.fragment = CouponItemFragment.newInstance(titleBean);
        titleBean.index = 1;
        titleList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "已过期";
        titleBean.fragment = CouponItemFragment.newInstance(titleBean);
        titleBean.index = 2;
        titleList.add(titleBean);

        return titleList;
    }

    public ArrayList<MainBarBean> getProductDetailList(String proId) {
        ArrayList<MainBarBean> titleList = new ArrayList<>();
        MainBarBean titleBean = new MainBarBean();
        titleBean.label = "商品";
        titleBean.fragment = ProductGoodsFragment.newInstance(titleBean);
        titleBean.index = 0;
        titleBean.id2 = proId;
        titleList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "详情";
        titleBean.fragment = ProductDetailFragment.newInstance(titleBean);
        titleBean.index = 1;
        titleBean.id2 = proId;
        titleList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "评价";
        titleBean.fragment = ProductCommentsFragment.newInstance(titleBean);
        titleBean.index = 2;
        titleBean.id2 = proId;
        titleList.add(titleBean);

        return titleList;
    }

}

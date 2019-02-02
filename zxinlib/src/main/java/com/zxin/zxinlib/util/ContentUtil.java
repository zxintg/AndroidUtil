package com.zxin.zxinlib.util;

import com.zxin.zxinlib.bean.TitleBean;
import com.zxin.zxinlib.bean.ToolsBean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by liukui on 2015/12/4.
 */
public class ContentUtil {

    private static volatile ContentUtil contentUtil = null;

    private ContentUtil(){}

    public static ContentUtil getInstance() {
        if (contentUtil == null)
            synchronized (ContentUtil.class) {
                if (contentUtil == null)
                    contentUtil = new ContentUtil();
            }
        return contentUtil;
    }

    public List<TitleBean> getCodeKKTitleBeanList() {
        List<TitleBean> beanList = new ArrayList<>();
        TitleBean titleBean = new TitleBean();
        titleBean.label = "开源项目";
        beanList.add(titleBean);

        titleBean = new TitleBean();
        titleBean.label = "日历";
        beanList.add(titleBean);

        titleBean = new TitleBean();
        titleBean.label = "网络请求";
        beanList.add(titleBean);

        titleBean = new TitleBean();
        titleBean.label = "缓存";
        beanList.add(titleBean);

        titleBean = new TitleBean();
        titleBean.label = "kotlin";
        beanList.add(titleBean);

        titleBean = new TitleBean();
        titleBean.label = "权限";
        beanList.add(titleBean);

        titleBean = new TitleBean();
        titleBean.label = "动画库";
        beanList.add(titleBean);

        titleBean = new TitleBean();
        titleBean.label = "视频";
        beanList.add(titleBean);

        titleBean = new TitleBean();
        titleBean.label = "recyclerview";
        beanList.add(titleBean);

        titleBean = new TitleBean();
        titleBean.label = "插件化";
        beanList.add(titleBean);

        titleBean = new TitleBean();
        titleBean.label = "工具";
        beanList.add(titleBean);

        titleBean = new TitleBean();
        titleBean.label = "video";
        beanList.add(titleBean);

        titleBean = new TitleBean();
        titleBean.label = "dagger2";
        beanList.add(titleBean);

        titleBean = new TitleBean();
        titleBean.label = "retrofit2";
        beanList.add(titleBean);

        titleBean = new TitleBean();
        titleBean.label = "Rxjava";
        beanList.add(titleBean);

        titleBean = new TitleBean();
        titleBean.label = "自动滚动 ViewPager";
        beanList.add(titleBean);

        titleBean = new TitleBean();
        titleBean.label = "图表";
        beanList.add(titleBean);

        titleBean = new TitleBean();
        titleBean.label = "指示器";
        beanList.add(titleBean);

        titleBean = new TitleBean();
        titleBean.label = "微信";
        beanList.add(titleBean);

        titleBean = new TitleBean();
        titleBean.label = "热修复";
        beanList.add(titleBean);

        titleBean = new TitleBean();
        titleBean.label = "动态部署";
        beanList.add(titleBean);

        titleBean = new TitleBean();
        titleBean.label = "ORM";
        beanList.add(titleBean);

        titleBean = new TitleBean();
        titleBean.label = "贝塞尔曲线";
        beanList.add(titleBean);

        titleBean = new TitleBean();
        titleBean.label = "图片压缩";
        beanList.add(titleBean);

        titleBean = new TitleBean();
        titleBean.label = "MVP";
        beanList.add(titleBean);

        return beanList;
    }

    public String[] selectOperatorYoMei() {
        return new String[]{"视频", "相册"};
    }


    public String[] selectBaiDuMapType() {
        return new String[]{"普通地图", "卫星图", "路况图", "城市热力图"};
    }

}

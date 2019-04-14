package com.zxin.meziyowu.util;

import com.zxin.meziyowu.R;
import com.zxin.meziyowu.bean.MainBarBean;
import com.zxin.meziyowu.bean.YoMeiTagModel;
import com.zxin.meziyowu.fragment.MiniVideoFragment;
import com.zxin.meziyowu.fragment.MiniVideoItemFragment;
import com.zxin.meziyowu.fragment.PhotoScrFragment;
import com.zxin.meziyowu.fragment.VideoVrFragment;
import com.zxin.meziyowu.fragment.YoGuoQuanFragment;
import com.zxin.meziyowu.fragment.YoMeiItemFragment;
import com.zxin.meziyowu.fragment.YoWuMineFragment;
import com.zxin.meziyowu.fragment.YouMeiFragment;
import com.zxin.root.bean.TitleBean;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/12.
 *
 * JVM只会加载一次单例类。可以使用同步锁来解决多线程不安全的问题
 *
 */

public class TitleBarUtil {

    private static TitleBarUtil instance = null;
    private TitleBarUtil() {

    }

    public static TitleBarUtil newInstance() {
        synchronized(TitleBarUtil.class) {
            if (instance == null) {
                instance = new TitleBarUtil();
            }
            return instance;
        }
    }

    public ArrayList<MainBarBean> getBarTitleList(){
        ArrayList<MainBarBean> titleList = new ArrayList<>();
        MainBarBean titleBean = new MainBarBean();
        titleBean.label = "优美";
        titleBean.labImage = R.drawable.button_home;
        titleBean.labImage2 = R.drawable.button_home_click;
        titleBean.fragment = YouMeiFragment.newInstance(titleBean);
        titleBean.index=0;
        titleList.add(titleBean);


        titleBean = new MainBarBean();
        titleBean.label = "尤果圈";
        titleBean.labImage = R.drawable.button_user;
        titleBean.labImage2 = R.drawable.button_user_click;
        titleBean.fragment = YoGuoQuanFragment.newInstance(titleBean);
        titleBean.index=1;
        titleList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "私照";
        titleBean.labImage = R.drawable.button_album;
        titleBean.labImage2 = R.drawable.button_album_click;
        titleBean.fragment = PhotoScrFragment.newInstance(titleBean);
        titleBean.index=2;
        titleList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "视频/VR";
        titleBean.labImage = R.drawable.button_video;
        titleBean.labImage2 = R.drawable.button_video_click;
        titleBean.fragment = VideoVrFragment.newInstance(titleBean);
        titleBean.index=3;
        titleList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "mini剧";
        titleBean.labImage = R.drawable.button_audiobook;
        titleBean.labImage2 = R.drawable.button_audiobook_click;
        titleBean.fragment = MiniVideoFragment.newInstance(titleBean);
        titleBean.index=4;
        titleList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "我的";
        titleBean.labImage = R.drawable.button_user;
        titleBean.labImage2 = R.drawable.button_user_click;
        titleBean.fragment = YoWuMineFragment.newInstance(titleBean);
        titleBean.index=5;
        titleList.add(titleBean);
        return titleList;
    }

    public List<MainBarBean> getHomeTagList(List<YoMeiTagModel> tagList) {
        List<MainBarBean> beanList = new ArrayList<>();
        for (YoMeiTagModel tagModel : tagList){
            if (tagModel.getName().equals("关注"))
                continue;
            MainBarBean titleBean = new MainBarBean();
            titleBean.label = tagModel.getName();
            titleBean.id = Long.parseLong(String.valueOf(tagModel.getId()));
            titleBean.fragment = YoMeiItemFragment.newInstance(tagModel.getId());
            beanList.add(titleBean);
        }
        return beanList;
    }


    public List<MainBarBean> getMiniVideoTitleList() {
        List<MainBarBean> beanList = new ArrayList<>();
        MainBarBean titleBean = new MainBarBean();
        titleBean.label = "最新";
        titleBean.fragment = MiniVideoItemFragment.newInstance(2);
        beanList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "最热";
        titleBean.fragment = MiniVideoItemFragment.newInstance(4);
        beanList.add(titleBean);

        return beanList;
    }
}

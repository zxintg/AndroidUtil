package com.zxin.jdxsxp.util;

import com.zxin.jdxsxp.R;
import com.zxin.jdxsxp.bean.HomeTagModel;
import com.zxin.jdxsxp.bean.MainBarBean;
import com.zxin.jdxsxp.bean.MeiNvLocal;
import com.zxin.jdxsxp.fragment.Find360Fragment;
import com.zxin.jdxsxp.fragment.FindBaiDuFragment;
import com.zxin.jdxsxp.fragment.FindFragment;
import com.zxin.jdxsxp.fragment.FindSouGouFragment;
import com.zxin.jdxsxp.fragment.HomeFragment;
import com.zxin.jdxsxp.fragment.SearchItemFragment;
import com.zxin.jdxsxp.fragment.VideoFragment;
import com.zxin.jdxsxp.fragment.SpecialFragment;
import com.zxin.jdxsxp.fragment.UserAttenFragment;
import com.zxin.jdxsxp.fragment.UserDynamicFragment;
import com.zxin.jdxsxp.fragment.VideoItemFragment;
import com.zxin.jdxsxp.fragment.WallPaperFragment;
import com.zxin.jdxsxp.fragment.XiGuaItemFragment;
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
        titleBean.label = "高清";
        titleBean.labImage = R.drawable.tkw;
        titleBean.labImage2 = R.drawable.tkf;
        titleBean.fragment = HomeFragment.newInstance(titleBean);
        titleBean.index=0;
        titleList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "专题";
        titleBean.labImage = R.drawable.zhuantig;
        titleBean.labImage2 = R.drawable.zhuantir;
        titleBean.fragment = SpecialFragment.newInstance(titleBean);
        titleBean.index=1;
        titleList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "动态";
        titleBean.labImage = R.drawable.mwzb;
        titleBean.labImage2 = R.drawable.mwzg;
        titleBean.fragment = UserDynamicFragment.newInstance(-1);
        titleBean.index=2;
        titleList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "壁纸";
        titleBean.labImage = R.drawable.singw;
        titleBean.labImage2 = R.drawable.singf;
        titleBean.fragment = WallPaperFragment.newInstance(titleBean);
        titleBean.index=3;
        titleList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "发现";
        titleBean.labImage = R.drawable.ssg;
        titleBean.labImage2 = R.drawable.ssf;
        titleBean.fragment = FindFragment.newInstance(titleBean);
        titleBean.index=4;
        titleList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "视频";
        titleBean.labImage = R.drawable.hyw;
        titleBean.labImage2 = R.drawable.hyf;
        titleBean.fragment = VideoFragment.newInstance(titleBean);
        titleBean.index=5;
        titleList.add(titleBean);

        return titleList;
    }

    public List<TitleBean> getWallPaperList() {
        List<TitleBean> beanList = new ArrayList<>();
        TitleBean titleBean = new TitleBean();
        titleBean.label = "清纯美女";
        titleBean.id2 = "mmtp_qcmn_page_";
        beanList.add(titleBean);

        titleBean = new TitleBean();
        titleBean.label = "美女壁纸";
        titleBean.id2 = "gqbz_mnbz_page_";
        beanList.add(titleBean);

        titleBean = new TitleBean();
        titleBean.label = "唯美写真";
        titleBean.id2 = "wmtp_wmxz_page_";
        beanList.add(titleBean);

        titleBean = new TitleBean();
        titleBean.label = "韩国美女";
        titleBean.id2 = "mmtp_hgmn_page_";
        beanList.add(titleBean);

        titleBean = new TitleBean();
        titleBean.label = "长腿美女";
        titleBean.id2 = "mmtp_ctmn_page_";
        beanList.add(titleBean);

        titleBean = new TitleBean();
        titleBean.label = "性感美女";
        titleBean.id2 = "mmtp_xgmn_page_";
        beanList.add(titleBean);

        titleBean = new TitleBean();
        titleBean.label = "丝袜美女";
        titleBean.id2 = "mmtp_swmn_page_";
        beanList.add(titleBean);

        return beanList;
    }

    public List<MainBarBean> getHomeTagList(List<HomeTagModel> tagList) {
        List<MainBarBean> beanList = new ArrayList<>();
        for (HomeTagModel tagModel : tagList){
            MainBarBean titleBean = new MainBarBean();
            titleBean.label = tagModel.getName();
            titleBean.id = Long.parseLong(String.valueOf(tagModel.getId()));
            titleBean.fragment = XiGuaItemFragment.newInstance(tagModel.getId());
            beanList.add(titleBean);
        }
        return beanList;
    }

    public List<MeiNvLocal> getMeiNvLocalList() {
        List<MeiNvLocal> beanList = new ArrayList<>();
        MeiNvLocal meiNvLocal = new MeiNvLocal();
        meiNvLocal.title = "韩国美女";
        meiNvLocal.pictureUrl = "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=4064654271,4253600182&fm=26&gp=0.jpg";
        beanList.add(meiNvLocal);

        meiNvLocal = new MeiNvLocal();
        meiNvLocal.title = "乌克兰美女";
        meiNvLocal.pictureUrl = "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2414343607,3318560685&fm=26&gp=0.jpg";
        beanList.add(meiNvLocal);

        meiNvLocal = new MeiNvLocal();
        meiNvLocal.title = "混血美女";
        meiNvLocal.pictureUrl = "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2504871522,2133877573&fm=11&gp=0.jpg";
        beanList.add(meiNvLocal);

        meiNvLocal = new MeiNvLocal();
        meiNvLocal.title = "清纯美女";
        meiNvLocal.pictureUrl = "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3700095236,2094809737&fm=26&gp=0.jpg";
        beanList.add(meiNvLocal);

        meiNvLocal = new MeiNvLocal();
        meiNvLocal.title = "超短裙美女";
        meiNvLocal.pictureUrl = "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=821280222,387749977&fm=26&gp=0.jpg";
        beanList.add(meiNvLocal);

        meiNvLocal = new MeiNvLocal();
        meiNvLocal.title = "美女秘书";
        meiNvLocal.pictureUrl = "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2123430475,1062893047&fm=26&gp=0.jpg";
        beanList.add(meiNvLocal);

        meiNvLocal = new MeiNvLocal();
        meiNvLocal.title = "美女护士";
        meiNvLocal.pictureUrl = "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1990714817,3350073932&fm=26&gp=0.jpg";
        beanList.add(meiNvLocal);

        meiNvLocal = new MeiNvLocal();
        meiNvLocal.title = "丝袜美女";
        meiNvLocal.pictureUrl = "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2330191839,174994712&fm=26&gp=0.jpg";
        beanList.add(meiNvLocal);

        meiNvLocal = new MeiNvLocal();
        meiNvLocal.title = "长腿美女";
        meiNvLocal.pictureUrl = "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2831900317,2463358058&fm=26&gp=0.jpg";
        beanList.add(meiNvLocal);

        meiNvLocal = new MeiNvLocal();
        meiNvLocal.title = "街拍美女";
        meiNvLocal.pictureUrl = "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3470346961,4162610202&fm=26&gp=0.jpg";
        beanList.add(meiNvLocal);

        meiNvLocal = new MeiNvLocal();
        meiNvLocal.title = "美女嫩模";
        meiNvLocal.pictureUrl = "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1385641616,1020963731&fm=26&gp=0.jpg";
        beanList.add(meiNvLocal);

        meiNvLocal = new MeiNvLocal();
        meiNvLocal.title = "美女丝足";
        meiNvLocal.pictureUrl = "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3929021129,1733463912&fm=26&gp=0.jpg";
        beanList.add(meiNvLocal);

        meiNvLocal = new MeiNvLocal();
        meiNvLocal.title = "美女空姐";
        meiNvLocal.pictureUrl = "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1124223748,2896165447&fm=26&gp=0.jpg";
        beanList.add(meiNvLocal);

        meiNvLocal = new MeiNvLocal();
        meiNvLocal.title = "日本美女";
        meiNvLocal.pictureUrl = "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1781132389,28021290&fm=26&gp=0.jpg";
        beanList.add(meiNvLocal);

        meiNvLocal = new MeiNvLocal();
        meiNvLocal.title = "日本女优";
        meiNvLocal.pictureUrl = "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3077880985,2373122118&fm=26&gp=0.jpg";
        beanList.add(meiNvLocal);

        meiNvLocal = new MeiNvLocal();
        meiNvLocal.title = "美胸美女";
        meiNvLocal.pictureUrl = "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3309437149,3348482183&fm=26&gp=0.jpg";
        beanList.add(meiNvLocal);

        meiNvLocal = new MeiNvLocal();
        meiNvLocal.title = "比基尼美女";
        meiNvLocal.pictureUrl = "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2243612161,314610278&fm=26&gp=0.jpg";
        beanList.add(meiNvLocal);

        meiNvLocal = new MeiNvLocal();
        meiNvLocal.title = "肉色丝袜美女";
        meiNvLocal.pictureUrl = "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=540867507,1477203042&fm=26&gp=0.jpg";
        beanList.add(meiNvLocal);

        meiNvLocal = new MeiNvLocal();
        meiNvLocal.title = "性感少妇";
        meiNvLocal.pictureUrl = "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2641352161,1233013048&fm=26&gp=0.jpg";
        beanList.add(meiNvLocal);

        meiNvLocal = new MeiNvLocal();
        meiNvLocal.title = "气质美女";
        meiNvLocal.pictureUrl = "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=343045542,3932809802&fm=26&gp=0.jpg";
        beanList.add(meiNvLocal);

        meiNvLocal = new MeiNvLocal();
        meiNvLocal.title = "办公室美女";
        meiNvLocal.pictureUrl = "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=134048637,2441064847&fm=26&gp=0.jpg";
        beanList.add(meiNvLocal);

        meiNvLocal = new MeiNvLocal();
        meiNvLocal.title = "制服诱惑";
        meiNvLocal.pictureUrl = "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2247249693,668314695&fm=26&gp=0.jpg";
        beanList.add(meiNvLocal);
        return beanList;
    }

    public List<MainBarBean> getSearchList(String keyword) {
        List<MainBarBean> beanList = new ArrayList<>();
        MainBarBean titleBean = new MainBarBean();
        titleBean.label = "百度图片";
        titleBean.fragment = FindBaiDuFragment.newInstance(keyword);
        beanList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "360图片";
        titleBean.fragment = Find360Fragment.newInstance(keyword);
        beanList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "搜狗图片";
        titleBean.fragment = FindSouGouFragment.newInstance(keyword);
        beanList.add(titleBean);

        return beanList;
    }

    public List<MainBarBean> getUserDetailTitle(int toUserId) {
        List<MainBarBean> beanList = new ArrayList<>();
        MainBarBean titleBean = new MainBarBean();
        titleBean.label = "专辑";
        titleBean.fragment = UserAttenFragment.newInstance(toUserId);
        beanList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "动态";
        titleBean.fragment = UserDynamicFragment.newInstance(toUserId);
        beanList.add(titleBean);

        return beanList;
    }

    public List<MainBarBean> getVideoTitleList() {
        List<MainBarBean> beanList = new ArrayList<>();
        MainBarBean titleBean = new MainBarBean();
        titleBean.label = "最新";
        titleBean.fragment = VideoItemFragment.newInstance(2);
        beanList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "最热";
        titleBean.fragment = VideoItemFragment.newInstance(4);
        beanList.add(titleBean);

        return beanList;
    }

    public List<MainBarBean> getSearchTitleList() {
        List<MainBarBean> beanList = new ArrayList<>();
        MainBarBean titleBean = new MainBarBean();
        titleBean.label = "全部";
        titleBean.fragment = SearchItemFragment.newInstance(0);
        beanList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "专辑";
        titleBean.fragment = SearchItemFragment.newInstance(1);
        beanList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "视频";
        titleBean.fragment = SearchItemFragment.newInstance(2);
        beanList.add(titleBean);

        return beanList;
    }

}

package com.zxin.marry.util;

import android.support.v4.app.Fragment;

import com.zxin.marry.R;
import com.zxin.marry.bean.CircleForm;
import com.zxin.marry.bean.FirstOrderBean;
import com.zxin.marry.bean.LabelForm;
import com.zxin.marry.bean.MainBarBean;
import com.zxin.marry.bean.MarryProductForm;
import com.zxin.marry.bean.OrderBarBean;
import com.zxin.marry.bean.ShootStategyBean;
import com.zxin.marry.fragment.AppointmentItemFragment;
import com.zxin.marry.fragment.CDKeyVoucherItemFragment;
import com.zxin.marry.fragment.CollectionItemFragment;
import com.zxin.marry.fragment.DiscoveryFragment;
import com.zxin.marry.fragment.PayOrderItemFragment;
import com.zxin.marry.fragment.TopicItemFragment;
import com.zxin.marry.fragment.UserOrderFragment;
import com.zxin.marry.fragment.MarriageCircleFragment;
import com.zxin.marry.fragment.MineFragment;
import com.zxin.marry.fragment.ToolsFragment;
import com.zxin.marry.fragment.VoucherItemFragment;
import com.zxin.marry.fragment.VoucherOrderItemFragment;
import com.zxin.marry.fragment.order.ComentFragment;
import com.zxin.marry.fragment.order.FinishingDateFragment;
import com.zxin.marry.fragment.order.NewCircuitViewFragment;
import com.zxin.marry.fragment.order.OrderInformationFragment;
import com.zxin.marry.fragment.order.PhotoAndMakeupArtistFragment;
import com.zxin.marry.fragment.order.ReserveChoiceClothesDateFragment;
import com.zxin.marry.fragment.order.ReserveChoicePhotoDateFragment;
import com.zxin.marry.fragment.order.ReserveExpressDateFragment;
import com.zxin.marry.fragment.order.ReservePhotoGraphFragment;
import com.zxin.marry.fragment.order.TemplateFragment;
import com.zxin.marry.fragment.strategy.IndoorSceneFragment;
import com.zxin.marry.fragment.strategy.OutdoorSceneFragment;
import com.zxin.marry.fragment.tools.TaskItemFragment;
import com.zxin.marry.fragment.topic.HomeCircleFragment;
import com.zxin.zxinlib.bean.TitleBean;
import com.zxin.zxinlib.bean.ToolsBean;
import com.zxin.zxinlib.util.UiUtils;
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
        titleBean.label = "结婚圈";
        titleBean.labSource = R.drawable.main_sale;
        titleBean.fragment = MarriageCircleFragment.newInstance(titleBean);
        titleBean.index=0;
        titleList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "摄影";
        titleBean.labSource = R.drawable.main_order;
        titleBean.fragment = UserOrderFragment.newInstance(titleBean);
        titleBean.index=1;
        titleList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "发现";
        titleBean.labSource = R.drawable.main_find;
        titleBean.fragment = DiscoveryFragment.newInstance(titleBean);
        titleBean.index=2;
        titleList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "工具";
        titleBean.labSource = R.drawable.main_setting;
        titleBean.fragment = ToolsFragment.newInstance(titleBean);
        titleBean.index=3;
        titleList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "我的";
        titleBean.labSource = R.drawable.main_task;
        titleBean.fragment = MineFragment.newInstance(titleBean);
        titleBean.index=4;
        titleList.add(titleBean);
        return titleList;
    }

    public ArrayList<MainBarBean> getCollectionList(){
        ArrayList<MainBarBean> titleList = new ArrayList<>();
        MainBarBean titleBean = new MainBarBean();
        titleBean.label = "商家";
        titleBean.fragment = CollectionItemFragment.newInstance("store");
        titleBean.index=0;
        titleList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "套餐";
        titleBean.fragment = CollectionItemFragment.newInstance("goods");
        titleBean.index=1;
        titleList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "案例";
        titleBean.fragment = CollectionItemFragment.newInstance("cases");
        titleBean.index=2;
        titleList.add(titleBean);
        return titleList;
    }

    public ArrayList<MainBarBean> getTaskList(){
        ArrayList<MainBarBean> titleList = new ArrayList<>();
        MainBarBean titleBean = new MainBarBean();
        titleBean.label = "按日期";
        titleBean.fragment = TaskItemFragment.newInstance("get_tasks_date");
        titleBean.index=0;
        titleList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "按类别";
        titleBean.fragment = TaskItemFragment.newInstance("get_tasks");
        titleBean.index=1;
        titleList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "已完成";
        titleBean.fragment = TaskItemFragment.newInstance("get_overtasks_date");
        titleBean.index=2;
        titleList.add(titleBean);
        return titleList;
    }

    public ArrayList<MainBarBean> getTopicList(){
        ArrayList<MainBarBean> titleList = new ArrayList<>();
        MainBarBean titleBean = new MainBarBean();
        titleBean.label = "我发布的话题";
        titleBean.fragment = TopicItemFragment.newInstance("index");
        titleBean.index=0;
        titleList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "我收藏的话题";
        titleBean.fragment = TopicItemFragment.newInstance("mycollectindex");
        titleBean.index=1;
        titleList.add(titleBean);

        return titleList;
    }

    public ArrayList<MainBarBean> getAppointmentList(){
        ArrayList<MainBarBean> titleList = new ArrayList<>();
        MainBarBean titleBean = new MainBarBean();
        titleBean.label = "全部";
        titleBean.fragment = AppointmentItemFragment.newInstance("3");
        titleBean.index=0;
        titleList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "商家已回访";
        titleBean.fragment = AppointmentItemFragment.newInstance("1");
        titleBean.index=1;
        titleList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "商家未回访";
        titleBean.fragment = AppointmentItemFragment.newInstance("2");
        titleBean.index=2;
        titleList.add(titleBean);

        return titleList;
    }

    public ArrayList<MainBarBean> getPayOrderList(){
        ArrayList<MainBarBean> titleList = new ArrayList<>();
        MainBarBean titleBean = new MainBarBean();
        titleBean.label = "全部";
        titleBean.fragment = PayOrderItemFragment.newInstance(null);
        titleBean.index=0;
        titleList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "待支付";
        titleBean.fragment = PayOrderItemFragment.newInstance("10");
        titleBean.index=1;
        titleList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "待发货";
        titleBean.fragment = PayOrderItemFragment.newInstance("20");
        titleBean.index=2;
        titleList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "待收货";
        titleBean.fragment = PayOrderItemFragment.newInstance("30");
        titleBean.index=3;
        titleList.add(titleBean);

        return titleList;
    }

    public ArrayList<MainBarBean> getVoucherOrderList(){
        ArrayList<MainBarBean> titleList = new ArrayList<>();
        MainBarBean titleBean = new MainBarBean();
        titleBean.label = "全部";
        titleBean.fragment = VoucherOrderItemFragment.newInstance(titleBean);
        titleBean.index=0;
        titleList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "待付款";
        titleBean.fragment = VoucherOrderItemFragment.newInstance(titleBean);
        titleBean.index=1;
        titleList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "已成交";
        titleBean.fragment = VoucherOrderItemFragment.newInstance(titleBean);
        titleBean.index=2;
        titleList.add(titleBean);

        return titleList;
    }

    public ArrayList<MainBarBean> getVoucherList(){
        ArrayList<MainBarBean> titleList = new ArrayList<>();
        MainBarBean titleBean = new MainBarBean();
        titleBean.label = "未使用";
        titleBean.fragment = VoucherItemFragment.newInstance("2");
        titleBean.index=0;
        titleList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "已使用";
        titleBean.fragment = VoucherItemFragment.newInstance("1");
        titleBean.index=1;
        titleList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "已过期";
        titleBean.fragment = VoucherItemFragment.newInstance("3");
        titleBean.index=2;
        titleList.add(titleBean);
        return titleList;
    }

    public ArrayList<MainBarBean> getCDKeyVoucherList(){
        ArrayList<MainBarBean> titleList = new ArrayList<>();
        MainBarBean titleBean = new MainBarBean();
        titleBean.label = "未使用";
        titleBean.fragment = CDKeyVoucherItemFragment.newInstance("0");
        titleBean.index=0;
        titleList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "已使用";
        titleBean.fragment = CDKeyVoucherItemFragment.newInstance("1");
        titleBean.index=1;
        titleList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "已过期";
        titleBean.fragment = CDKeyVoucherItemFragment.newInstance("2");
        titleBean.index=2;
        titleList.add(titleBean);
        return titleList;
    }

    public List<ToolsBean> getToolsList() {
        List<ToolsBean> toolsList = new ArrayList<>();
        ToolsBean toolsBean = new ToolsBean();
        toolsBean.setId(0);
        toolsBean.setName(UiUtils.getString(R.string.main_task));
        toolsBean.setImgRes(R.drawable.icon_task);
        toolsList.add(toolsBean);

        toolsBean = new ToolsBean();
        toolsBean.setId(1);
        toolsBean.setName(UiUtils.getString(R.string.invitation));
        toolsBean.setImgRes(R.drawable.icon_invitation);
        toolsList.add(toolsBean);

        toolsBean = new ToolsBean();
        toolsBean.setId(2);
        toolsBean.setName(UiUtils.getString(R.string.registration));
        toolsBean.setImgRes(R.drawable.icon_registration);
        toolsList.add(toolsBean);

        toolsBean = new ToolsBean();
        toolsBean.setId(3);
        toolsBean.setName(UiUtils.getString(R.string.myphotos));
        toolsBean.setImgRes(R.drawable.icon_photos);
        toolsList.add(toolsBean);

        toolsBean = new ToolsBean();
        toolsBean.setId(4);
        toolsBean.setName("结婚吉日");
        toolsBean.setImgRes(R.drawable.marry_luck_day);
        toolsList.add(toolsBean);

        toolsBean = new ToolsBean();
        toolsBean.setId(5);
        toolsBean.setName("婚礼测算");
        toolsBean.setImgRes(R.drawable.wedding_budget);
        toolsList.add(toolsBean);

        return toolsList;
    }

    public List<TitleBean> getMainOrderList(FirstOrderBean orderBean) {
        List<String> display = orderBean.getDisplay();
        List<TitleBean> toolsList = new ArrayList<>();
        TitleBean orderBarBean = null;

        if (display.contains("one")) {
            orderBarBean = new TitleBean();
            orderBarBean.id = 0;
            orderBarBean.label = "订单\n详情";
            orderBarBean.labImage = orderBean.getOne().getCurrent() == 1?R.drawable.order_one_selected:R.drawable.order_one_normal;
            toolsList.add(orderBarBean);
        }

        if (display.contains("two")) {
            orderBarBean = new OrderBarBean();
            orderBarBean.id = 1;
            orderBarBean.label = "预约\n拍照";
            orderBarBean.labImage = orderBean.getTwo().getCurrent() == 1?R.drawable.order_two_selected:R.drawable.order_two_normal;
            toolsList.add(orderBarBean);
        }

        if (display.contains("three")) {
            orderBarBean = new OrderBarBean();
            orderBarBean.id = 2;
            orderBarBean.label = "摄影\n化妆";
            orderBarBean.labImage = orderBean.getThree().getCurrent() == 1?R.drawable.order_three_selected:R.drawable.order_three_normal;
            toolsList.add(orderBarBean);
        }

        if (display.contains("four")) {
            orderBarBean = new OrderBarBean();
            orderBarBean.id = 3;
            orderBarBean.label = "预选\n礼服";
            orderBarBean.labImage = orderBean.getFour().getCurrent() == 1?R.drawable.order_four_selected:R.drawable.order_four_normal;
            toolsList.add(orderBarBean);
        }

        if (display.contains("five")) {
            orderBarBean = new OrderBarBean();
            orderBarBean.id = 4;
            orderBarBean.label = "拍摄\n评价";
            orderBarBean.labImage = orderBean.getFive().getCurrent() == 1?R.drawable.order_five_selected:R.drawable.order_five_normal;
            toolsList.add(orderBarBean);
        }

        if (display.contains("six")) {
            orderBarBean = new OrderBarBean();
            orderBarBean.id = 5;
            orderBarBean.label = "预约\n选样";
            orderBarBean.labImage = orderBean.getSix().getCurrent() == 1?R.drawable.order_eight_selected:R.drawable.order_eight_normal;
            toolsList.add(orderBarBean);
        }

        if (display.contains("nine")) {
            orderBarBean = new OrderBarBean();
            orderBarBean.id = 6;
            orderBarBean.label = "选样\n评价";
            orderBarBean.labImage = orderBean.getNine().getCurrent() == 1?R.drawable.order_nine_selected:R.drawable.order_nine_normal;
            toolsList.add(orderBarBean);
        }

        if (display.contains("seven")) {
            orderBarBean = new OrderBarBean();
            orderBarBean.id = 7;
            orderBarBean.label = "浏览\n精修";
            orderBarBean.labImage = orderBean.getSeven().getCurrent() == 1?R.drawable.order_seven_selected:R.drawable.order_seven_normal;
            toolsList.add(orderBarBean);
        }

        if (display.contains("thirteen")) {
            orderBarBean = new OrderBarBean();
            orderBarBean.id = 8;
            orderBarBean.label = "数码\n评价";
            orderBarBean.labImage = orderBean.getThirteen().getCurrent() == 1?R.drawable.order_eleven_selected:R.drawable.order_eleven_normal;
            toolsList.add(orderBarBean);
        }

        if (display.contains("eight")) {
            orderBarBean = new OrderBarBean();
            orderBarBean.id = 9;
            orderBarBean.label = "看版\n时间";
            orderBarBean.labImage = orderBean.getEight().getCurrent() == 1?R.drawable.order_six_selected:R.drawable.order_six_normal;
            toolsList.add(orderBarBean);
        }

        if (display.contains("ten")) {
            orderBarBean = new OrderBarBean();
            orderBarBean.id = 10;
            orderBarBean.label = "预约\n取件";
            orderBarBean.labImage = orderBean.getTen().getCurrent() == 1?R.drawable.order_ten_selected:R.drawable.order_ten_normal;
            toolsList.add(orderBarBean);
        }

        if (display.contains("eleven")) {
            orderBarBean = new OrderBarBean();
            orderBarBean.id = 11;
            orderBarBean.label = "取件\n评价";
            orderBarBean.labImage = orderBean.getEleven().getCurrent() == 1?R.drawable.order_eleven_selected:R.drawable.order_eleven_normal;
            toolsList.add(orderBarBean);
        }

        return toolsList;
    }

    public List<Fragment> getMainOrderFragmentList(FirstOrderBean orderBean) {
        List<String> display = orderBean.getDisplay();
        List<Fragment> mFragmentList = new ArrayList<>();
        if (display.contains("one")) {
            mFragmentList.add(OrderInformationFragment.newInstance(orderBean.getOne()));
        }

        if (display.contains("two")) {
            mFragmentList.add(ReservePhotoGraphFragment.newInstance(orderBean.getTwo()));
        }

        if (display.contains("three")) {
            mFragmentList.add(PhotoAndMakeupArtistFragment.newInstance(orderBean.getThree()));

        }

        if (display.contains("four")) {
            mFragmentList.add(ReserveChoiceClothesDateFragment.newInstance(orderBean.getFour()));
        }

        if (display.contains("five")) {
            mFragmentList.add(ComentFragment.newInstance(orderBean.getFive().getOrderid(),orderBean.getFive().getShopid(),"人员服务评价","1"));
        }

        if (display.contains("six")) {
            mFragmentList.add(ReserveChoicePhotoDateFragment.newInstance(orderBean.getSix()));
        }

        if (display.contains("nine")) {
            mFragmentList.add(ComentFragment.newInstance(orderBean.getNine().getOrderid(),orderBean.getNine().getShopid(),"业务技能评价","2"));
        }

        if (display.contains("seven")) {
            mFragmentList.add(FinishingDateFragment.newInstance(orderBean.getSeven()));
        }

        if (display.contains("thirteen")) {
            mFragmentList.add(ComentFragment.newInstance(orderBean.getThirteen().getOrderid(),orderBean.getThirteen().getShopid(),"数码评价","4"));
        }

        if (display.contains("eight")) {
            mFragmentList.add(TemplateFragment.newInstance(orderBean.getEight()));
        }

        if (display.contains("ten")) {
            mFragmentList.add(ReserveExpressDateFragment.newInstance(orderBean.getTen()));
        }

        if (display.contains("eleven")) {
            mFragmentList.add(ComentFragment.newInstance(orderBean.getEleven().getOrderid(),orderBean.getEleven().getShopid(),"综合评价","3"));
        }

        return mFragmentList;
    }

    public ArrayList<MainBarBean> getNewCircuitSelectList(String orderid, String shopId, List<ShootStategyBean.Line> lineList){
        ArrayList<MainBarBean> titleList = new ArrayList<>();

        for (int i=0;i<lineList.size();i++) {
            ShootStategyBean.Line line = lineList.get(i);
            MainBarBean titleBean = new MainBarBean();
            titleBean.label = StringUtils.textIsEmpty(line.getName())?"线路"+(i+1):line.getName();
            titleBean.fragment = NewCircuitViewFragment.newInstance(orderid,shopId,line);
            titleList.add(titleBean);
        }
        return titleList;
    }

    public ArrayList<TitleBean> getProductList(List<MarryProductForm.MarryProductType> listDatas) {
        ArrayList<TitleBean> toolsList = new ArrayList<>();
        for (MarryProductForm.MarryProductType type:listDatas) {
            TitleBean product = new TitleBean();
            product.id2 = type.getId();
            product.label = type.getName();
            product.url = type.getLogo();
            toolsList.add(product);
        }
        return toolsList;
    }

    public List<TitleBean> getShopTitle(){
        List<TitleBean> toolsList = new ArrayList<>();
        TitleBean orderBarBean = new TitleBean();
        orderBarBean.id = 0;
        orderBarBean.label = "套餐";
        orderBarBean.labImage = R.drawable.combo_selector;
        toolsList.add(orderBarBean);

        orderBarBean = new TitleBean();
        orderBarBean.id = 1;
        orderBarBean.label = "案例";
        orderBarBean.labImage = R.drawable.case_selector;
        toolsList.add(orderBarBean);

        orderBarBean = new TitleBean();
        orderBarBean.id = 2;
        orderBarBean.label = "商家";
        orderBarBean.labImage = R.drawable.business_selector;
        toolsList.add(orderBarBean);
        return toolsList;
    }

    public List<MainBarBean> getHomeCircleTitle(CircleForm.Circle mCircle, List<LabelForm.Label> labelList){
        List<MainBarBean> toolsList = new ArrayList<>();
        for (LabelForm.Label label: labelList){
            MainBarBean titleBean = new MainBarBean();
            titleBean.id2 = label.getThclass_id();
            titleBean.label = label.getThclass_name();
            titleBean.fragment = HomeCircleFragment.newInstance(mCircle,titleBean.id2);
            toolsList.add(titleBean);
        }
        return toolsList;
    }


    public ArrayList<MainBarBean> getNewStrategyEditList(String mOrderId,String mShopid,String showouter){
        ArrayList<MainBarBean> titleList = new ArrayList<>();
        MainBarBean titleBean = new MainBarBean();
        titleBean.label = "外景";
        titleBean.fragment = OutdoorSceneFragment.newInstance(mOrderId,mShopid,showouter);
        titleBean.index=0;
        titleList.add(titleBean);

        titleBean = new MainBarBean();
        titleBean.label = "内景";
        titleBean.fragment = IndoorSceneFragment.newInstance(mOrderId,mShopid,showouter);
        titleBean.index=1;
        titleList.add(titleBean);

        return titleList;
    }

}

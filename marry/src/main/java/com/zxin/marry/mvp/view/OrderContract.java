package com.zxin.marry.mvp.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zxin.marry.R;
import com.zxin.marry.activity.CDkeyOrderDetailsActivity;
import com.zxin.marry.activity.CalendarActivity;
import com.zxin.marry.activity.ComentsActivity;
import com.zxin.marry.activity.NewAllStrategyActivity;
import com.zxin.marry.activity.NewCircuitSelectActivity;
import com.zxin.marry.activity.NewStrategyEditActvitiy;
import com.zxin.marry.activity.OnLineCameraActivity;
import com.zxin.marry.activity.OrderDetalisActivity;
import com.zxin.marry.activity.PayingActivity;
import com.zxin.marry.activity.ReservationDetailsActivity;
import com.zxin.marry.activity.SceneDetailsActivity;
import com.zxin.marry.activity.ServiceCenterActivity;
import com.zxin.marry.activity.ShootStrategyActivity;
import com.zxin.marry.activity.SpreeDetailsActivity;
import com.zxin.marry.bean.AppointmentBean;
import com.zxin.marry.bean.BookdressdateBean;
import com.zxin.marry.bean.CDkeyBean1;
import com.zxin.marry.bean.CircuitViewPagerBean;
import com.zxin.marry.bean.CurrentProcedureBean;
import com.zxin.marry.bean.Entity;
import com.zxin.marry.bean.FInishingBean;
import com.zxin.marry.bean.FirstOrderBean;
import com.zxin.marry.bean.GetphotodateBean;
import com.zxin.marry.bean.GifListBean;
import com.zxin.marry.bean.MyGoodsOrderBean;
import com.zxin.marry.bean.MyOrderBean;
import com.zxin.marry.bean.OrderBean;
import com.zxin.marry.bean.OrderListBean;
import com.zxin.marry.bean.PhotoDataBean;
import com.zxin.marry.bean.PickUpBean;
import com.zxin.marry.bean.RemarkBean;
import com.zxin.marry.bean.RemarkListBean;
import com.zxin.marry.bean.RemarkStatusBean;
import com.zxin.marry.bean.ReplyBean;
import com.zxin.marry.bean.SelectPhotoDateBean;
import com.zxin.marry.bean.ShootStategyBean;
import com.zxin.marry.bean.TEmplateBean;
import com.zxin.marry.bean.VoucherBaseBean;
import com.zxin.marry.bean.VoucherBean;
import com.zxin.marry.mvp.presenter.OrderPresenter;
import com.zxin.marry.util.StringUtils;
import com.zxin.marry.util.TitleBarUtil;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.network.mvp.view.IBaseView;
import com.zxin.root.adapter.simple.SimpleAdapter;
import com.zxin.root.adapter.simple.TrdViewHolder;
import com.zxin.root.adapter.ViewPageFragmentAdapter;
import com.zxin.root.bean.TitleBean;
import com.zxin.root.util.AppManager;
import com.zxin.root.util.ImageUtil;
import com.zxin.root.util.IntegerUtil;
import com.zxin.root.util.SharedPreferencesManager;
import com.zxin.root.util.SystemInfoUtil;
import com.zxin.root.util.ToastUtil;
import com.zxin.root.util.UiUtils;
import com.zxin.root.view.CommonCrosswiseBar;
import com.zxin.root.view.PagerSlidingVerTabStrip;
import com.zxin.root.view.RefreshCommonView;
import com.zxin.root.view.MyViewPager;
import com.zxin.root.view.dialog.ConfirmDialog;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/24.
 */

public class OrderContract implements IBaseView {
    private SimpleAdapter orderAdapter, orderInfoAdapter, photoGraphAdapter, newCircuitAdapter, newAllStrategyAdapter;
    private List<OrderBean> orderList = new ArrayList<>();
    private List<MyOrderBean.Packagegoods> orderInfoList = new ArrayList<>();
    private List<PhotoDataBean.Rephotolist> photoGraphList = new ArrayList<>();
    private List<CircuitViewPagerBean.Linescenes> newCircuitList = new ArrayList<>();
    private List<ShootStategyBean.Date> newAllStrategyList = new ArrayList<>();
    private Context mContext;
    private String type;
    private TitleBean titleBean;
    private FragmentManager manager;

    @Override
    public void setParameter(Object... parameter) {
        type = (String) parameter[0];
    }

    public void setMainParameter(Object... parameter) {
        titleBean = (TitleBean) parameter[0];
        manager = (FragmentManager) parameter[1];
    }

    private FirstOrderBean.OneEntity oneEntity;

    public void setOrderInfoParameter(Object... parameter) {
        oneEntity = (FirstOrderBean.OneEntity) parameter[0];
    }

    private FirstOrderBean.TwoEntity twoEntity;

    public void setReservePhotographParameter(Object... parameter) {
        twoEntity = (FirstOrderBean.TwoEntity) parameter[0];
    }

    @Override
    public void initDatas() {
        orderList.clear();
        orderAdapter = new SimpleAdapter<OrderBean>(mContext, orderList, R.layout.item_lv_order) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final OrderBean data) {
                holder.setText(R.id.tv_storename, data.getShopname())
                        .setText(R.id.tv_price, "价格:\t￥" + data.getPrice());
                if (StringUtils.textIsEmpty(data.getImgsrc())) {
                    ImageUtil.loadImageView(mContext, R.drawable.icon_order_default, holder.<ImageView>getView(R.id.iv_photo));
                } else {
                    ImageUtil.loadImageViewLoding(mContext, data.getImgsrc(), holder.<ImageView>getView(R.id.iv_photo), R.drawable.icon_default, R.drawable.icon_default);
                }
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle bundle = new Bundle();
                        bundle.putInt(StringUtils.EVENT_ID, IntegerUtil.EVENT_ID_11004);
                        bundle.putParcelable(StringUtils.EVENT_DATA, data);
                        EventBus.getDefault().post(bundle);
                        AppManager.getAppManager().finishCurrentActivity();
                    }
                });
            }
        };
        iView.getRecyclerView().setRecyclerViewAdapter(orderAdapter);
        iView.getRecyclerView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {

            @Override
            public void startRefresh() {
                orderList.clear();
                presenter.getOrderList(type);
            }

            @Override
            public void startLoadMore() {

            }
        });
        iView.getRecyclerView().setIsLoadMore(false);
    }

    @Override
    public void loadDatas() {

    }

    @Override
    public void onResultSuccess(Object bean) {
        finishLoad();
        if (bean == null)
            return;
        orderList.clear();
        OrderListBean datas = (OrderListBean) bean;
        orderList.addAll(datas.getData());
        orderAdapter.notifyDataSetChanged();
    }

    @Override
    public void onAddResult(boolean bool) {

    }

    @Override
    public void onUpdateResult(boolean bool) {

    }

    @Override
    public void onDeleteResult(boolean bool) {

    }

    @Override
    public void onComplete() {

    }

    @Override
    public void setContext(Context context) {
        this.mContext = context;
    }

    private OrderPresenter presenter;

    @Override
    public void setP(BasePresenter... basePresenter) {
        presenter = (OrderPresenter) basePresenter[0];
    }

    @Override
    public void OnClick(View v) {
        if (v.getId() == R.id.ll_complaints) {
            //电话客服
            if (oneEntity == null)
                return;
            Intent intent = new Intent(mContext, ServiceCenterActivity.class);
            intent.putExtra("shopid", oneEntity.getShopid());
            intent.putExtra("orderid", oneEntity.getOrderid());
            mContext.startActivity(intent);
        } else if (v.getId() == R.id.ll_department) {
            //客服
            SystemInfoUtil.callDialing("18550424957");
        } else if (v.getId() == R.id.rl_onlinebooking) {
            //预约时间
            initPhotoTimeDatas();
        } else if (v.getId() == R.id.btn_reserve_date) {
            //在线选摄影师
            initPhotoCameraer();
        } else if (v.getId() == R.id.btn_reserve_camera) {
            //拍摄攻略
            Intent paramView = new Intent(mContext, ShootStrategyActivity.class);
            paramView.putExtra("orderid", twoEntity.getOrderid());
            paramView.putExtra("shopId", twoEntity.getShopid());
            mContext.startActivity(paramView);
        } else if (v.getId() == R.id.iv_left_interior) {
            //内景查看
            Intent paramView = new Intent(mContext, NewAllStrategyActivity.class);
            paramView.putExtra("orderid", orderId);
            paramView.putExtra("shopid", shopId);
            mContext.startActivity(paramView);
        } else if (v.getId() == R.id.iv_right_exterior) {
            //外景线路
            Intent paramView = new Intent(mContext, NewCircuitSelectActivity.class);
            paramView.putExtra("orderid", orderId);
            paramView.putExtra("shopid", shopId);
            paramView.putExtra("model", stategyBean);
            mContext.startActivity(paramView);
        } else if (v.getId() == R.id.tv_bottom_btn) {
            //查看我的攻略
            Intent paramView = new Intent(mContext, NewStrategyEditActvitiy.class);
            paramView.putExtra("orderid", orderId);
            paramView.putExtra("shopid", shopId);
            paramView.putExtra("showouter", "showouter");
            mContext.startActivity(paramView);
        }
    }

    private MyMarryOrderView iView;

    public void setMyMarryOrderViewListener(MyMarryOrderView testView) {
        this.iView = testView;
    }

    private MarryOrderView iOrderView;

    public void setMarryOrderViewListener(MarryOrderView testView) {
        this.iOrderView = testView;
    }

    private OrderBean order;

    public void onResultOrderBeanSuccess(OrderBean order) {
        this.order = order;
        presenter.getOrderProgress(order.getOrderid(), order.getShopid());
    }

    public interface MyMarryOrderView {
        RefreshCommonView getRecyclerView();
    }

    public void finishLoad() {
        iView.getRecyclerView().finishRefresh();
        iView.getRecyclerView().finishLoadMore();
    }

    public interface MarryOrderView {
        PagerSlidingVerTabStrip pstTitleView();

        MyViewPager mOrderPagerView();
    }

    private String orderId;
    private String shopId;

    public void setShootStrategyParameter(Object... parameter) {
        orderId = (String) parameter[0];
        shopId = (String) parameter[1];
    }

    private ArrayList<TitleBean> titleList = new ArrayList<>();
    private List<Fragment> mFragmentList = new ArrayList<>();//页卡视图集合
    private ViewPageFragmentAdapter pageAdapter;

    public void onResultTabSuccess(Object data) {
        if (data == null)
            return;
        FirstOrderBean orderBean = (FirstOrderBean) data;
        titleList.addAll(TitleBarUtil.newInstance().getMainOrderList(orderBean));
        mFragmentList.addAll(TitleBarUtil.newInstance().getMainOrderFragmentList(orderBean));
        iOrderView.mOrderPagerView().removeAllViews();
        pageAdapter = new ViewPageFragmentAdapter(mFragmentList, titleList);
        iOrderView.mOrderPagerView().setCurrentItem(0);
        iOrderView.mOrderPagerView().setAdapter(pageAdapter);
        iOrderView.mOrderPagerView().setOffscreenPageLimit(titleList.size());
        iOrderView.pstTitleView().setViewPager(iOrderView.mOrderPagerView());
    }

    private OrderInformationView iOrderInfoView;

    public void setOrderInformationViewListener(OrderInformationView testView) {
        this.iOrderInfoView = testView;
    }

    public interface OrderInformationView {

        SimpleDraweeView mImgView();

        TextView mPhotoTypeView();

        TextView mPhotoNameView();

        TextView mMoneyView();

        TextView mOrderPayForkeyView();

        TextView mBookSuccessDateView();

        RelativeLayout pstDepartmentView();

        ImageView mInfoImageView();

        RelativeLayout mrRLLView();

        TextView mManagerNameView();

        TextView mPhoneNumberView();

        RelativeLayout mrDepView();

        TextView mSectionView();

        TextView mDepView();

        View mLineView();

        RelativeLayout mrCallView();

        ImageView mrImageLView();

        TextView mManNameView();

        TextView mManPhoneView();

        TextView mWmanNameView();

        TextView mWmanPhoneView();

        TextView mMarriedDateView();

        TextView mShootLevelView();

        TextView mPriceView();

        TextView mManClothingView();

        TextView mTextView();

        TextView mWmanClothingView();

        TextView mPhotoTotalNumberView();

        TextView mPhotoFinishingNumberView();

        TextView mLocationShootView();

        TextView mInteriorShootView();

        LinearLayout mSpecificProductView();

        RecyclerView mNlvSpecificProductView();

        LinearLayout mLLNoteView();

        TextView mNoteView();

        TextView mOfSeriesPriceView();

        TextView mTailPaymentView();
    }

    public void initOrderInfoDatas() {
        orderInfoList.clear();
        orderInfoAdapter = new SimpleAdapter<MyOrderBean.Packagegoods>(mContext, orderInfoList, R.layout.order_dress_item) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final MyOrderBean.Packagegoods data) {
                if (!StringUtils.textIsEmpty(data.getGoodname())) {
                    holder.setText(R.id.tv_name, data.getGoodname());
                }
                if (!StringUtils.textIsEmpty(data.getGoodsizename())) {
                    holder.setText(R.id.tv_size, data.getGoodsizename());
                }
                holder.setText(R.id.tv_number, data.getNumber())
                        .setText(R.id.tv_pnumber, data.getPnumber())
                        .setText(R.id.tv_pageNumber, data.getPage());
            }
        };
        iOrderInfoView.mNlvSpecificProductView().setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.VERTICAL));
        iOrderInfoView.mNlvSpecificProductView().setNestedScrollingEnabled(false);
        iOrderInfoView.mNlvSpecificProductView().setAdapter(orderInfoAdapter);
    }

    public void onResultMainSuccess(Object data) {
        if (data == null)
            return;
        CurrentProcedureBean bean = (CurrentProcedureBean) data;
        if (bean.getOrderpackage() != null) {
            iOrderInfoView.mPhotoTypeView().setText(bean.getOrderpackage().getPackagetype());
            iOrderInfoView.mMoneyView().setText("￥" + bean.getOrderpackage().getPrice());
            iOrderInfoView.mOrderPayForkeyView().setText(bean.getOrderpayforkey());
            iOrderInfoView.mBookSuccessDateView().setText(bean.getBooksuccessdate());
            ImageUtil.loadImageViewLoding(mContext, bean.getOrderpackage().getImgsrc(), iOrderInfoView.mImgView(), R.drawable.icon_default, R.drawable.icon_default);
        }
    }

    public void onResultOrderInfoDatas(Object data) {
        if (data == null) {
            return;
        }
        MyOrderBean myOrderBean = (MyOrderBean) data;
        iOrderInfoView.mManNameView().setText(myOrderBean.getData().getMname());
        iOrderInfoView.mManPhoneView().setText(myOrderBean.getData().getMphone());
        iOrderInfoView.mWmanNameView().setText(myOrderBean.getData().getWname());
        iOrderInfoView.mWmanPhoneView().setText(myOrderBean.getData().getWphone());
        iOrderInfoView.mMarriedDateView().setText(myOrderBean.getData().getMarrydate());
        iOrderInfoView.mShootLevelView().setText(myOrderBean.getData().getPhotolevelname());
        iOrderInfoView.mPriceView().setText(myOrderBean.getData().getOrder_price());
        iOrderInfoView.mManClothingView().setText(myOrderBean.getData().getPackageX().getMan());
        iOrderInfoView.mWmanClothingView().setText(myOrderBean.getData().getPackageX().getWoman());
        iOrderInfoView.mPhotoTotalNumberView().setText(myOrderBean.getData().getPackageX().getPhotonumber());
        iOrderInfoView.mPhotoFinishingNumberView().setText(myOrderBean.getData().getPackageX().getVipphotonumber());
        iOrderInfoView.mLocationShootView().setText(myOrderBean.getData().getPlaceout());
        iOrderInfoView.mInteriorShootView().setText(myOrderBean.getData().getPlacein());
        iOrderInfoView.mOfSeriesPriceView().setText(myOrderBean.getData().getOrder_price());
        iOrderInfoView.mTailPaymentView().setText(myOrderBean.getData().getBalance());
        iOrderInfoView.mLLNoteView().setVisibility(View.GONE);
        if (!StringUtils.textIsEmpty(myOrderBean.getData().getAuthorizedescr())) {
            iOrderInfoView.mNoteView().setText(myOrderBean.getData().getAuthorizedescr());
            iOrderInfoView.mLLNoteView().setVisibility(View.VISIBLE);
        }

        iOrderInfoView.pstDepartmentView().setVisibility(!TextUtils.isEmpty(myOrderBean.getDatang().getPhone()) ? View.VISIBLE : View.GONE);
        iOrderInfoView.mManagerNameView().setText(myOrderBean.getDatang().getName());
        iOrderInfoView.mPhoneNumberView().setText(myOrderBean.getDatang().getPhone());
        iOrderInfoView.mSectionView().setText(myOrderBean.getDatang().getDepartmentname());

        if ((myOrderBean.getData().getPackagegoods() == null) || (myOrderBean.getData().getPackagegoods().isEmpty())) {
            iOrderInfoView.mSpecificProductView().setVisibility(View.GONE);
            return;
        }
        iOrderInfoView.mSpecificProductView().setVisibility(View.VISIBLE);
        orderInfoList.addAll(myOrderBean.getData().getPackagegoods());
        orderInfoAdapter.notifyDataSetChanged();
    }

    private ReservePhotographView iReservePhotographView;

    public void setReservePhotographListener(ReservePhotographView testView) {
        this.iReservePhotographView = testView;
    }

    public interface ReservePhotographView {
        LinearLayout pstLLdepartmentView();

        ImageView mImageView();

        RelativeLayout mRL1View();

        TextView mManagerNameView();

        TextView mPhoneNumberView();

        RelativeLayout mrDepView();

        TextView mSectionView();

        TextView mDepView();

        View mLineView();

        RelativeLayout mrCallView();

        ImageView mrImageLView();

        TextView mProgressView();

        LinearLayout mYearView();

        ImageView mYear1View();

        ImageView mYear2View();

        ImageView mYear3View();

        ImageView mYear4View();

        ImageView mMonth1View();

        ImageView mMonth2View();

        ImageView mDay1View();

        ImageView mDay2View();

        LinearLayout mLLTimeView();

        TextView mTimeView();

        LinearLayout mLayoutTimeView();

        ImageView mTime1View();

        ImageView mTime2View();

        ImageView mTime3View();

        ImageView mTime4View();

        RelativeLayout mRLOnlineBookingView();

        TextView mOnlineBookingView();

        ImageView mOnlineBookingImgView();

        LinearLayout mLLButtonView();

        RelativeLayout mRLReserveDateView();

        Button mReserveDateView();

        RelativeLayout mRLReserveCameraView();

        Button mReserveCameraView();

        RecyclerView mShootingTimeRecyclerViewView();

        TextView mToastView();
    }

    public void initReservePhotographDatas() {
        photoGraphList.clear();
        photoGraphAdapter = new SimpleAdapter<PhotoDataBean.Rephotolist>(mContext, photoGraphList, R.layout.shooting_time_item) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final PhotoDataBean.Rephotolist data) {
                holder.setText(R.id.tv_time, data.getPhotodate())
                        .setText(R.id.tv_shooting_type, data.getTypeidstr())
                        .setTextColor(R.id.tv_time, data.getIsmark().equals("1") ? R.color.order_radio_bg : R.color.black);
                ImageView mIvPosition = holder.getView(R.id.iv_position);
                switch (data.getIsmark()) {
                    case "1":
                        mIvPosition.setImageResource(R.drawable.num1);
                        break;

                    case "2":
                        mIvPosition.setImageResource(R.drawable.num2);
                        break;

                    case "3":
                        mIvPosition.setImageResource(R.drawable.num3);
                        break;

                    case "4":
                        mIvPosition.setImageResource(R.drawable.num4);
                        break;

                    case "5":
                        mIvPosition.setImageResource(R.drawable.num5);
                        break;

                    case "6":
                        mIvPosition.setImageResource(R.drawable.num6);

                        break;

                    case "7":
                        mIvPosition.setImageResource(R.drawable.num7);

                        break;

                    case "8":
                        mIvPosition.setImageResource(R.drawable.num8);
                        break;

                    case "9":
                        mIvPosition.setImageResource(R.drawable.num9);
                        break;
                }
            }
        };
        iReservePhotographView.mShootingTimeRecyclerViewView().setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.VERTICAL));
        iReservePhotographView.mShootingTimeRecyclerViewView().setNestedScrollingEnabled(false);
        iReservePhotographView.mShootingTimeRecyclerViewView().setAdapter(photoGraphAdapter);
    }

    public void onResultReservePhotoGraphDetailDatas(Object data) {
        if (data == null) {
            return;
        }
        this.photoDataBean = (PhotoDataBean) data;
        if ((photoDataBean.getCode().equals("1")) && (photoDataBean.getRephotolist() != null)) {
            photoGraphList.addAll(photoDataBean.getRephotolist());
            photoGraphAdapter.notifyDataSetChanged();
        }
        if (("等待安排".equals(photoDataBean.getArrivearea())) && ("暂未安排".equals(photoDataBean.getPhotodate()))) {
            iReservePhotographView.mLayoutTimeView().setVisibility(View.GONE);
            iReservePhotographView.mTimeView().setVisibility(View.GONE);
        }

        if (!"等待安排".equals(photoDataBean.getArrivearea())) {
            iReservePhotographView.mTime1View().setImageDrawable(checkNum(String.valueOf(photoDataBean.getArrivearea().charAt(0))));
            iReservePhotographView.mTime2View().setImageDrawable(checkNum(String.valueOf(photoDataBean.getArrivearea().charAt(1))));
            iReservePhotographView.mTime3View().setImageDrawable(checkNum(String.valueOf(photoDataBean.getArrivearea().charAt(3))));
            iReservePhotographView.mTime4View().setImageDrawable(checkNum(String.valueOf(photoDataBean.getArrivearea().charAt(4))));
            iReservePhotographView.mLayoutTimeView().setVisibility(View.VISIBLE);
        }

        iReservePhotographView.mLLButtonView().setVisibility(View.VISIBLE);
        iReservePhotographView.mProgressView().setText("暂未安排".equals(photoDataBean.getPhotodate()) ? "拍照时间暂未安排" : "拍照时间已安排");

        //在线预订拍照
        iReservePhotographView.mRLOnlineBookingView().setVisibility(View.VISIBLE);
        iReservePhotographView.mOnlineBookingView().setText(photoDataBean.getAllow_advance().equals("0") ? "电话预订" : photoDataBean.getIsonlinebookcamer() == 1 ? "在线预订时间" : "更改预定时间");
        //在线选摄影师
        iReservePhotographView.mRLReserveDateView().setVisibility(photoDataBean.getIsonlinebookcamer() == 0 ? View.VISIBLE : View.GONE);
        //拍摄攻略
        iReservePhotographView.mRLReserveCameraView().setVisibility(photoDataBean.getIsraiders() == 1 ? View.VISIBLE : View.GONE);

        if (photoDataBean.getDatang() == null)
            return;
        iReservePhotographView.pstLLdepartmentView().setVisibility(StringUtils.textIsEmpty(photoDataBean.getDatang().getPhone()) ? View.GONE : View.VISIBLE);

        iReservePhotographView.mManagerNameView().setText(photoDataBean.getDatang().getName());
        iReservePhotographView.mPhoneNumberView().setText(photoDataBean.getDatang().getPhone());
        iReservePhotographView.mSectionView().setText(photoDataBean.getDatang().getDepartmentname());

        iReservePhotographView.mYear1View().setImageDrawable(checkNum(String.valueOf(photoDataBean.getPhotodate().charAt(0))));
        iReservePhotographView.mYear2View().setImageDrawable(checkNum(String.valueOf(photoDataBean.getPhotodate().charAt(1))));
        iReservePhotographView.mYear3View().setImageDrawable(checkNum(String.valueOf(photoDataBean.getPhotodate().charAt(2))));
        iReservePhotographView.mYear4View().setImageDrawable(checkNum(String.valueOf(photoDataBean.getPhotodate().charAt(3))));
        iReservePhotographView.mMonth1View().setImageDrawable(checkNum(String.valueOf(photoDataBean.getPhotodate().charAt(5))));
        iReservePhotographView.mMonth2View().setImageDrawable(checkNum(String.valueOf(photoDataBean.getPhotodate().charAt(6))));
        iReservePhotographView.mDay1View().setImageDrawable(checkNum(String.valueOf(photoDataBean.getPhotodate().charAt(8))));
        iReservePhotographView.mDay2View().setImageDrawable(checkNum(String.valueOf(photoDataBean.getPhotodate().charAt(9))));

        iReservePhotographView.mToastView().setText(photoDataBean.getExplain());
    }

    private Drawable checkNum(String mesg) {
        switch (mesg) {
            case "1":
                return UiUtils.getDrawable(R.drawable.time_01);
            case "2":
                return UiUtils.getDrawable(R.drawable.time_02);
            case "3":
                return UiUtils.getDrawable(R.drawable.time_03);
            case "4":
                return UiUtils.getDrawable(R.drawable.time_04);
            case "5":
                return UiUtils.getDrawable(R.drawable.time_05);
            case "6":
                return UiUtils.getDrawable(R.drawable.time_06);
            case "7":
                return UiUtils.getDrawable(R.drawable.time_07);
            case "8":
                return UiUtils.getDrawable(R.drawable.time_08);
            case "9":
                return UiUtils.getDrawable(R.drawable.time_09);
            case "0":
                return UiUtils.getDrawable(R.drawable.time_00);
        }
        return null;
    }

    private int STATUS;
    private PhotoDataBean photoDataBean;

    /*****
     * 预约时间
     */
    private void initPhotoTimeDatas() {
        switch (photoDataBean.getAllow_advance()) {

            case "0":
                if (!StringUtils.textIsEmpty(photoDataBean.getShop_tel_dangqi()))
                    mContext.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.photoDataBean.getShop_tel_dangqi())));
                break;

            case "1":
                if (this.photoDataBean.getRest_count() > 0) {
                    Intent localObject = new Intent(mContext, CalendarActivity.class);
                    localObject.putExtra("date", photoDataBean.getPhotodate());
                    localObject.putExtra("uid", SharedPreferencesManager.getMarryUid());
                    localObject.putExtra("orderid", twoEntity.getOrderid());
                    localObject.putExtra("shopid", twoEntity.getShopid());
                    localObject.putExtra("mindate", photoDataBean.getMin_interval_date());
                    localObject.putExtra("maxdate", photoDataBean.getMax_interval_date());
                    mContext.startActivity(localObject);
                    return;
                }
                break;

            case "2":
                showDialog(UiUtils.getString(R.string.remindcontentstart) + this.photoDataBean.getDefault_orderModify_nums() + UiUtils.getString(R.string.remindcontentend));
                break;

            case "3":
                showDialog1(photoDataBean.getMessage());
                break;

            case "4":
                showDialog(photoDataBean.getMessage());
                break;

        }
    }

    /****
     * 在线选摄影师
     */
    private void initPhotoCameraer() {
        if (this.STATUS == 1) {
            if (photoDataBean.getServicelevel() == null) {
                return;
            }
            Intent localIntent = new Intent(mContext, OnLineCameraActivity.class);
            localIntent.putExtra("photoDate", photoDataBean.getPhotodate());
            localIntent.putExtra("serviceLevel", photoDataBean.getServicelevel());
            localIntent.putExtra("orderId", twoEntity.getOrderid());
            localIntent.putExtra("shopId", twoEntity.getShopid());
            mContext.startActivity(localIntent);
        }
        initPhotoTimeDatas();
    }

    private void showDialog(String paramString) {
        final AlertDialog alertDialog = new AlertDialog.Builder(mContext).create();
        alertDialog.show();
        Window window = alertDialog.getWindow();
        window.setContentView(R.layout.dialog_appointment);
        TextView context = (TextView) window.findViewById(R.id.appointment_context);
        context.setText(paramString);
        window.findViewById(R.id.tv_confirm).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!TextUtils.isEmpty(photoDataBean.getShop_tel_dangqi())) {
                    Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + photoDataBean.getShop_tel_dangqi()));
                    mContext.startActivity(intent);
                }
                alertDialog.dismiss();
            }
        });
        window.findViewById(R.id.tv_cancel).setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                alertDialog.dismiss();
            }
        });
    }

    private void showDialog1(String paramString) {
        final AlertDialog alertDialog = new AlertDialog.Builder(mContext).create();
        alertDialog.show();
        Window window = alertDialog.getWindow();
        window.setContentView(R.layout.dialog_appointment);
        TextView context = (TextView) window.findViewById(R.id.appointment_context);
        context.setText(paramString);
        window.findViewById(R.id.tv_confirm).setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                alertDialog.dismiss();
            }
        });
        window.findViewById(R.id.tv_cancel).setVisibility(View.GONE);
    }


    private CameraStrategyView iCameraStrategyView;

    public void setCameraStrategyViewListener(CameraStrategyView testView) {
        this.iCameraStrategyView = testView;
    }

    public interface CameraStrategyView {
        ImageView mImageBgView();
    }

    private ShootStategyBean stategyBean;

    public void onResultCameraStrategyDetail(Object data) {
        if (data == null) {
            return;
        }
        stategyBean = (ShootStategyBean) data;
        String url = "";
        if (StringUtils.textIsEmpty(stategyBean.getSystemset().getRaiders_applogo())) {
            url = stategyBean.getSystemset().getRaiders_applogo();
        }
        if (StringUtils.textIsEmpty(stategyBean.getSystemset().getRaiders_linelogo())) {
            url = stategyBean.getSystemset().getRaiders_linelogo();
        }
        if (StringUtils.textIsEmpty(stategyBean.getSystemset().getRaiders_scenelogo())) {
            url = stategyBean.getSystemset().getRaiders_scenelogo();
        }
        ImageUtil.loadImageViewLoding(mContext, url, iCameraStrategyView.mImageBgView(), R.mipmap.default_iamge, R.drawable.shoot_bg_default);
    }


    private NewCircuitView iNewCircuitView;

    public void setNewCircuitViewListener(NewCircuitView iNewCircuitView) {
        this.iNewCircuitView = iNewCircuitView;
    }

    public interface NewCircuitView {
        RefreshCommonView getRefreshCommonView();

        SimpleDraweeView getIVPhotoView();

        ImageView getIVSignView();

        TextView getTVCircuitTitleView();

        TextView getTVCircuitDesView();
    }

    private String lineid;

    public void setNewCircuitViewParameter(Object... parameter) {
        orderId = (String) parameter[0];
        shopId = (String) parameter[1];
        lineid = (String) parameter[2];
    }

    public void initNewCircuitViewDatas() {
        //瀑布流形式
        newCircuitList.clear();
        newCircuitAdapter = new SimpleAdapter<CircuitViewPagerBean.Linescenes>(mContext, newCircuitList, R.layout.item_shoot_strategy) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final CircuitViewPagerBean.Linescenes data) {
                holder.setText(R.id.tv_title, data.getName())
                        .setText(R.id.tv_size, data.getCount())
                        .setVisible(R.id.iv_icon, "1".equals(data.getIscollect()));
                ImageUtil.loadImageViewLoding(mContext, data.getPic(), holder.<ImageView>getView(R.id.iv_photo), R.drawable.icon_default, R.drawable.icon_default);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, SceneDetailsActivity.class);
                        intent.putExtra("url", data.getUrl());
                        intent.putExtra("title", data.getName());
                        intent.putExtra("iscollect", data.getIscollect());
                        intent.putExtra("orderid", orderId);
                        intent.putExtra("shopid", shopId);
                        intent.putExtra("lineid", lineid);
                        intent.putExtra("id", data.getSceneid());
                        mContext.startActivity(intent);
                    }
                });
            }
        };

        iNewCircuitView.getRefreshCommonView().setRecyclerViewAdapter(newCircuitAdapter);
        iNewCircuitView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {
            @Override
            public void startRefresh() {
                presenter.NewCircuitViewList(orderId, shopId, lineid);
            }

            @Override
            public void startLoadMore() {

            }
        });
    }

    public void onResultNewCircuitView(Object obj) {
        iNewCircuitView.getRefreshCommonView().finishRefresh();
        iNewCircuitView.getRefreshCommonView().finishLoadMore();
        if (obj == null)
            return;
        CircuitViewPagerBean circuitBean = (CircuitViewPagerBean) obj;
        ImageUtil.loadImageViewLoding(mContext, circuitBean.getLine().getPic(), iNewCircuitView.getIVPhotoView(), R.drawable.icon_default, R.drawable.icon_default);
        iNewCircuitView.getTVCircuitDesView().setText(circuitBean.getLine().getText());

        if (circuitBean.getLine().getIscollect().equals("1")) {
            iNewCircuitView.getIVSignView().setVisibility(View.VISIBLE);
            iNewCircuitView.getTVCircuitTitleView().setText("\t\t\t\t\t\t\t\t\t\t\t" + circuitBean.getLine().getName());
        } else {
            iNewCircuitView.getIVSignView().setVisibility(View.GONE);
            iNewCircuitView.getTVCircuitTitleView().setText(circuitBean.getLine().getName());
        }
        newCircuitList.clear();
        newCircuitList.addAll(circuitBean.getLinescenes());
        if (newCircuitList == null || newCircuitList.isEmpty()) {
            newCircuitList.clear();
            iNewCircuitView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iNewCircuitView.getRefreshCommonView().setIsEmpty(false);
            iNewCircuitView.getRefreshCommonView().setIsLoadMore(false);
        }
        newCircuitAdapter.notifyDataSetChanged();
    }

    private NewAllStrategyView iNewAllStrategyView;

    public void setNewAllStrategyViewListener(NewAllStrategyView iNewAllStrategyView) {
        this.iNewAllStrategyView = iNewAllStrategyView;
    }

    public interface NewAllStrategyView {
        CommonCrosswiseBar getTitleView();

        RefreshCommonView getRefreshCommonView();

        TextView getTVBottomView();
    }

    public void setNewAllStrategyViewParameter(Object... parameter) {
        orderId = (String) parameter[0];
        shopId = (String) parameter[1];
        lineid = (String) parameter[2];
    }

    public void initNewAllStrategyViewDatas() {
        if (StringUtils.textIsEmpty(lineid)) {
            iNewAllStrategyView.getTitleView().setTitleText("所有内景");
            iNewAllStrategyView.getTVBottomView().setVisibility(View.VISIBLE);
            iNewAllStrategyView.getTVBottomView().setText("已收藏内景");
        } else {
            iNewAllStrategyView.getTitleView().setTitleText("所有外景");
            iNewAllStrategyView.getTVBottomView().setVisibility(View.GONE);
        }
        newAllStrategyList.clear();
        newAllStrategyAdapter = new SimpleAdapter<ShootStategyBean.Date>(mContext, newAllStrategyList, R.layout.item_shoot_strategy) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final ShootStategyBean.Date data) {
                holder.setText(R.id.tv_title, data.getName())
                        .setText(R.id.tv_size, data.getCount())
                        .setVisible(R.id.iv_icon, "1".equals(data.getIscollect()));
                ImageUtil.loadImageViewLoding(mContext, data.getPic(), holder.<ImageView>getView(R.id.iv_photo), R.drawable.icon_default, R.drawable.icon_default);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, SceneDetailsActivity.class);
                        intent.putExtra("url", data.getUrl());
                        intent.putExtra("title", data.getName());
                        intent.putExtra("iscollect", data.getIscollect());
                        intent.putExtra("orderid", orderId);
                        intent.putExtra("shopid", shopId);
                        intent.putExtra("lineid", lineid);
                        intent.putExtra("id", data.getId());
                        mContext.startActivity(intent);
                    }
                });
            }
        };

        iNewAllStrategyView.getRefreshCommonView().setRecyclerViewAdapter(newAllStrategyAdapter);
        iNewAllStrategyView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {
            @Override
            public void startRefresh() {
                presenter.getNewAllStrategyViewList(orderId, shopId, lineid);
            }

            @Override
            public void startLoadMore() {

            }
        });
    }

    public void onResultAllStrategyView(Object obj) {
        iNewAllStrategyView.getRefreshCommonView().finishRefresh();
        iNewAllStrategyView.getRefreshCommonView().finishLoadMore();
        if (obj == null)
            return;
        ShootStategyBean circuitBean = (ShootStategyBean) obj;
        newAllStrategyList.clear();
        newAllStrategyList.addAll(circuitBean.getData());
        if (newAllStrategyList == null || newAllStrategyList.isEmpty()) {
            newAllStrategyList.clear();
            iNewAllStrategyView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iNewAllStrategyView.getRefreshCommonView().setIsEmpty(false);
            iNewAllStrategyView.getRefreshCommonView().setIsLoadMore(false);
        }
        newAllStrategyAdapter.notifyDataSetChanged();
    }

    private VoucherItemView iVoucherItemView;

    public void setVoucherItemViewListener(VoucherItemView iVoucherItemView) {
        this.iVoucherItemView = iVoucherItemView;
    }

    public interface VoucherItemView {
        RefreshCommonView getRefreshCommonView();
    }

    private String voucher_state;

    public void setVoucherItemViewParameter(Object... parameter) {
        voucher_state = (String) parameter[0];
    }

    private SimpleAdapter voucherItemAdapter;
    private List<VoucherBean> voucherItemList = new ArrayList<>();

    public void initVoucherItemViewDatas() {
        voucherItemAdapter = new SimpleAdapter<VoucherBean>(mContext, voucherItemList, R.layout.item_coupon) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final VoucherBean data) {
                holder.setText(R.id.tv_voucher_title, data.getVoucher_title())
                        .setText(R.id.tv_voucher_time, data.getVoucher_start_date() + "-" + data.getVoucher_end_date())
                        .setText(R.id.tv_voucher_price, "￥" + data.getVoucher_price())
                        .setText(R.id.voucher_t_storename, "￥" + data.getVoucher_t_storename())
                        .setText(R.id.tv_voucher_desc, "￥" + data.getVoucher_desc());
                switch (data.getVoucher_state()) {

                    case "1":
                        holder.setText(R.id.tv_voucher_state, "未使用")
                                .setBackgroundRes(R.id.rl_coupon_up, R.drawable.icon_coupon_up)
                                .setBackgroundRes(R.id.rl_coupon_down, R.drawable.icon_coupon_dowm)
                                .setVisible(R.id.img_overdue, false);
                        break;

                    case "2":
                        holder.setText(R.id.tv_voucher_state, "已使用")
                                .setBackgroundRes(R.id.rl_coupon_up, R.drawable.icon_coupon_up_un)
                                .setBackgroundRes(R.id.rl_coupon_down, R.drawable.icon_coupon_doem_un)
                                .setVisible(R.id.img_overdue, true);
                        break;

                    case "3":
                        holder.setText(R.id.tv_voucher_state, "已过期")
                                .setBackgroundRes(R.id.rl_coupon_up, R.drawable.icon_coupon_up_un)
                                .setBackgroundRes(R.id.rl_coupon_down, R.drawable.icon_coupon_doem_un)
                                .setVisible(R.id.img_overdue, true);
                        break;

                    case "4":
                        holder.setText(R.id.tv_voucher_state, "未使用")
                                .setBackgroundRes(R.id.rl_coupon_up, R.drawable.icon_coupon_up)
                                .setBackgroundRes(R.id.rl_coupon_down, R.drawable.icon_coupon_dowm)
                                .setVisible(R.id.img_overdue, false);
                        break;
                }
            }
        };
        switch (voucher_state) {
            case "1":
                iVoucherItemView.getRefreshCommonView().setEmptyText("暂无已使用优惠券");
                break;

            case "2":
                iVoucherItemView.getRefreshCommonView().setEmptyText("暂无可用优惠券");
                break;

            case "3":
                iVoucherItemView.getRefreshCommonView().setEmptyText("暂无过期优惠券");
                break;
        }
        iVoucherItemView.getRefreshCommonView().setEmptyImage(R.drawable.icon_empty_cdkey);
        iVoucherItemView.getRefreshCommonView().setRecyclerViewAdapter(voucherItemAdapter);
        iVoucherItemView.getRefreshCommonView().setIsLoadMore(false);
        iVoucherItemView.getRefreshCommonView().setIsAutoLoad(false);
        iVoucherItemView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {
            @Override
            public void startRefresh() {
                presenter.getVoucherOrderList(voucher_state);
            }

            @Override
            public void startLoadMore() {

            }
        });
    }

    public void onResultVoucherOrder(Object obj) {
        iVoucherItemView.getRefreshCommonView().finishRefresh();
        if (obj == null) {
            voucherItemList.clear();
            iVoucherItemView.getRefreshCommonView().setIsEmpty(true);
            return;
        }
        VoucherBaseBean voucher = (VoucherBaseBean) obj;
        voucherItemList.clear();
        voucherItemList.addAll(voucher.getVoucher());
        if (voucherItemList == null || voucherItemList.isEmpty()) {
            voucherItemList.clear();
            iVoucherItemView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iVoucherItemView.getRefreshCommonView().setIsEmpty(false);
        }
        voucherItemAdapter.notifyDataSetChanged();
    }


    private CDKeyVoucherItemView iCDKeyVoucherItemView;

    public void setCDKeyVoucherItemViewListener(CDKeyVoucherItemView iCDKeyVoucherItemView) {
        this.iCDKeyVoucherItemView = iCDKeyVoucherItemView;
    }

    public interface CDKeyVoucherItemView {
        RefreshCommonView getRefreshCommonView();
    }

    private String vr_state;

    public void setCDKeyVoucherItemViewParameter(Object... parameter) {
        vr_state = (String) parameter[0];
    }

    private SimpleAdapter cdkeyVoucherItemAdapter;
    private List<CDkeyBean1.MyorderBean> cdkeyVoucherList = new ArrayList<>();

    public void initCDKeyVoucherItemViewDatas() {
        cdkeyVoucherItemAdapter = new SimpleAdapter<CDkeyBean1.MyorderBean>(mContext, cdkeyVoucherList, R.layout.item_cdkey_order) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final CDkeyBean1.MyorderBean data) {
                holder.setText(R.id.tv_ok_buy, "有效期至：" + data.getVr_indate())
                        .setText(R.id.tv_shop_name, data.getStore_name())
                        .setText(R.id.tv_goods_name, data.getGoods_name())
                        .setText(R.id.tv_order_number, "订单编号：" + data.getOrder_sn());
                switch (data.getVr_state()) {

                    case "0":
                        holder.setText(R.id.tv_vr_state, "未使用");
                        break;

                    case "1":
                        holder.setText(R.id.tv_vr_state, "已使用");
                        break;

                    case "2":
                        holder.setText(R.id.tv_vr_state, "已过期");
                        break;

                }
                ImageUtil.loadImageViewLoding(mContext, data.getGoods_image(), holder.<ImageView>getView(R.id.img_goods_image), R.drawable.icon_default, R.drawable.icon_default);
                ImageUtil.loadCircleImageView(mContext, data.getStore_avatar(), holder.<ImageView>getView(R.id.img_store_img), R.drawable.icon_shop_title);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, CDkeyOrderDetailsActivity.class);
                        intent.putExtra("rec_id", data.getRec_id());
                        mContext.startActivity(intent);
                    }
                });
            }
        };
        switch (vr_state) {
            case "0":
                iCDKeyVoucherItemView.getRefreshCommonView().setEmptyText("暂无可用兑换券");
                break;

            case "1":
                iCDKeyVoucherItemView.getRefreshCommonView().setEmptyText("暂无已使用兑换券");
                break;

            case "2":
                iCDKeyVoucherItemView.getRefreshCommonView().setEmptyText("暂无过期兑换券");
                break;
        }

        iCDKeyVoucherItemView.getRefreshCommonView().setEmptyImage(R.drawable.icon_empty_cdkey);
        iCDKeyVoucherItemView.getRefreshCommonView().setRecyclerViewAdapter(cdkeyVoucherItemAdapter);
        iCDKeyVoucherItemView.getRefreshCommonView().setIsLoadMore(false);
        iCDKeyVoucherItemView.getRefreshCommonView().setIsAutoLoad(false);
        iCDKeyVoucherItemView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {
            @Override
            public void startRefresh() {
                presenter.getCDKeyVoucherOrderList(vr_state);
            }

            @Override
            public void startLoadMore() {

            }
        });
    }

    public void onResultCDKeyVoucherOrder(Object obj) {
        iCDKeyVoucherItemView.getRefreshCommonView().finishRefresh();
        if (obj == null) {
            cdkeyVoucherList.clear();
            iCDKeyVoucherItemView.getRefreshCommonView().setIsEmpty(true);
            return;
        }
        CDkeyBean1 cDkeyBean = (CDkeyBean1) obj;
        cdkeyVoucherList.clear();
        cdkeyVoucherList.addAll(cDkeyBean.getMyorder());
        if (cdkeyVoucherList == null || cdkeyVoucherList.isEmpty()) {
            cdkeyVoucherList.clear();
            iCDKeyVoucherItemView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iCDKeyVoucherItemView.getRefreshCommonView().setIsEmpty(false);
        }
        cdkeyVoucherItemAdapter.notifyDataSetChanged();
    }


    private SpreeBounsView iSpreeBounsView;

    public void setSpreeBounsViewListener(SpreeBounsView iSpreeBounsView) {
        this.iSpreeBounsView = iSpreeBounsView;
    }

    public interface SpreeBounsView {
        RefreshCommonView getRefreshCommonView();
    }

    private SimpleAdapter spreeBounsAdapter;
    private List<GifListBean.GiftuserBean> spreeBounsList = new ArrayList<>();

    public void initSpreeBounsViewDatas() {
        spreeBounsAdapter = new SimpleAdapter<GifListBean.GiftuserBean>(mContext, spreeBounsList, R.layout.item_spree) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final GifListBean.GiftuserBean data) {
                holder.setText(R.id.store_name, data.getStore_name())
                        .setText(R.id.gift_name, data.getGift_name())
                        .setText(R.id.create_time, data.getCreatetime());
                holder.getView(R.id.state).setBackground(UiUtils.getDrawable(data.getIsread().equals("0") ? R.drawable.ic_big_state1 : R.drawable.ic_big_state0));
                ImageUtil.loadImageViewLoding(mContext, data.getGift_image(), holder.<ImageView>getView(R.id.gift_image), R.drawable.icon_default, R.drawable.icon_shop_title);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, SpreeDetailsActivity.class);
                        intent.putExtra("id", data.getId());
                        mContext.startActivity(intent);
                    }
                });
            }
        };
        iSpreeBounsView.getRefreshCommonView().setRecyclerViewAdapter(spreeBounsAdapter);
        iSpreeBounsView.getRefreshCommonView().setIsLoadMore(false);
        iSpreeBounsView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {
            @Override
            public void startRefresh() {
                presenter.getSpreeBounsList();
            }

            @Override
            public void startLoadMore() {

            }
        });
    }

    public void onResultSpreeBounsDatas(Object obj) {
        iSpreeBounsView.getRefreshCommonView().finishRefresh();
        if (obj == null) {
            spreeBounsList.clear();
            iSpreeBounsView.getRefreshCommonView().setIsEmpty(true);
            return;
        }
        GifListBean gifListBean = (GifListBean) obj;
        spreeBounsList.clear();
        spreeBounsList.addAll(gifListBean.getGiftuser());
        if (spreeBounsList == null || spreeBounsList.isEmpty()) {
            spreeBounsList.clear();
            iSpreeBounsView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iSpreeBounsView.getRefreshCommonView().setIsEmpty(false);
        }
        spreeBounsAdapter.notifyDataSetChanged();
    }

    private AppointmentListView iAppointmentListView;

    public void setAppointmentListViewListener(AppointmentListView iAppointmentListView) {
        this.iAppointmentListView = iAppointmentListView;
    }

    public interface AppointmentListView {
        RefreshCommonView getRefreshCommonView();
    }

    private String appointment_isfeed;

    public void setAppointmentViewParameter(Object... parameter) {
        appointment_isfeed = (String) parameter[0];
    }

    private SimpleAdapter appointmentListAdapter;
    private List<AppointmentBean.AppointmentlistBean> appointmentList = new ArrayList<>();

    public void initAppointmentListDatas() {
        appointmentListAdapter = new SimpleAdapter<AppointmentBean.AppointmentlistBean>(mContext, appointmentList, R.layout.item_appointment) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final AppointmentBean.AppointmentlistBean data) {
                holder.setText(R.id.tv_shop_name, data.getStore_name())
                        .setText(R.id.tv_goods_name, data.getGoods_name())
                        .setText(R.id.tv_appointment_time, data.getAppointment_time().isEmpty() ? "暂未安排" : data.getAppointment_time())
                        .setText(R.id.tv_appointment_isfeed, data.getAppointment_isfeed());
                holder.setTextColor(R.id.tv_appointment_isfeed, UiUtils.getColor(data.getAppointment_isfeed().equals("商家未回访") ? R.color.f4666d : R.color.t7e7e7e));
                ImageUtil.loadImageViewLoding(mContext, data.getGoods_image(), holder.<ImageView>getView(R.id.img_goods), R.drawable.icon_default, R.drawable.icon_default);
                ImageUtil.loadCircleImageView(mContext, data.getStore_avatar(), holder.<ImageView>getView(R.id.img_store_img), R.drawable.icon_shop_title);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, ReservationDetailsActivity.class);
                        intent.putExtra("appointment_id", data.getAppointment_id());
                        mContext.startActivity(intent);
                    }
                });
            }
        };
        iAppointmentListView.getRefreshCommonView().setRecyclerViewAdapter(appointmentListAdapter);
        iAppointmentListView.getRefreshCommonView().setIsLoadMore(false);
        iAppointmentListView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {
            @Override
            public void startRefresh() {
                presenter.getAppointmentList(appointment_isfeed);
            }

            @Override
            public void startLoadMore() {

            }
        });
    }

    public void onResultAppointmentList(Object obj) {
        iAppointmentListView.getRefreshCommonView().finishRefresh();
        if (obj == null) {
            appointmentList.clear();
            iAppointmentListView.getRefreshCommonView().setIsEmpty(true);
            return;
        }
        AppointmentBean gifListBean = (AppointmentBean) obj;
        appointmentList.clear();
        appointmentList.addAll(gifListBean.getAppointmentlist());
        if (appointmentList == null || appointmentList.isEmpty()) {
            appointmentList.clear();
            iAppointmentListView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iAppointmentListView.getRefreshCommonView().setIsEmpty(false);
        }
        appointmentListAdapter.notifyDataSetChanged();
    }


    private PayOrderItemView iPayOrderItemView;

    public void setPayOrderItemViewListener(PayOrderItemView iPayOrderItemView) {
        this.iPayOrderItemView = iPayOrderItemView;
    }

    public interface PayOrderItemView {
        RefreshCommonView getRefreshCommonView();
    }

    private String order_state;

    public void setPayOrderItemViewParameter(Object... parameter) {
        order_state = (String) parameter[0];
        manager = (FragmentManager) parameter[1];
    }

    private SimpleAdapter payOrderItemAdapter;
    private List<MyGoodsOrderBean.MyorderBean> payOrderItemList = new ArrayList<>();

    public void initPayOrderItemViewDatas() {
        payOrderItemAdapter = new SimpleAdapter<MyGoodsOrderBean.MyorderBean>(mContext, payOrderItemList, R.layout.my_goods_adpater) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final MyGoodsOrderBean.MyorderBean data) {
                holder.setText(R.id.tv_total_price, "合计：￥" + data.getOrder().get(0).getOrder_amount());
                RecyclerView recyclerView = holder.getView(R.id.lv_goods_order);
                recyclerView.setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.VERTICAL));
                recyclerView.setNestedScrollingEnabled(false);
                recyclerView.setAdapter(new SimpleAdapter<MyGoodsOrderBean.MyorderBean.OrderBean>(mContext, data.getOrder(), R.layout.item_my_goods_adpater) {
                    @Override
                    protected void onBindViewHolder(TrdViewHolder holder, final MyGoodsOrderBean.MyorderBean.OrderBean order) {
                        holder.setText(R.id.tv_store_name, order.getStore_name());
                        ImageUtil.loadCircleImageView(mContext, order.getStore_avatar(), holder.<ImageView>getView(R.id.img_store_img), R.drawable.icon_shop_title);
                        RecyclerView recyclerView = holder.getView(R.id.lv_goods_order);
                        recyclerView.setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.VERTICAL));
                        recyclerView.setNestedScrollingEnabled(false);
                        recyclerView.setAdapter(new SimpleAdapter<MyGoodsOrderBean.MyorderBean.OrderBean.CartlistBean>(mContext, order.getCartlist(), R.layout.item_goods_cart_list) {
                            @Override
                            protected void onBindViewHolder(TrdViewHolder holder, final MyGoodsOrderBean.MyorderBean.OrderBean.CartlistBean cart) {
                                holder.setText(R.id.tv_goods_name, cart.getGoods_name())
                                        .setText(R.id.tv_price, "￥" + cart.getGoods_price())
                                        .setText(R.id.tv_buy_num, "x" + cart.getGoods_num());
                                ImageUtil.loadImageViewLoding(mContext, cart.getGoods_image(), holder.<ImageView>getView(R.id.goods_image), R.drawable.icon_default, R.drawable.icon_default_shop);
                            }
                        });
                        switch (order.getOrder_state()) {
                            case "10":
                                holder.setText(R.id.tv_order_state, "待付款");
                                break;

                            case "20":
                                holder.setText(R.id.tv_order_state, "待发货");
                                break;

                            case "30":
                                holder.setText(R.id.tv_order_state, "待收货");
                                break;

                            case "40":
                                holder.setText(R.id.tv_order_state, "已完成");
                                break;
                        }
                    }
                });
                switch (data.getApi_pay_state()) {
                    case "0":
                        holder.setVisible(R.id.rl_mune, true)
                                .setVisible(R.id.tv_delete_order, true)
                                .setVisible(R.id.tv_submit_order, true)
                                .setVisible(R.id.rl_ok_mune, false);
                        break;

                    case "1":
                        if (data.getOrder().get(0).getOrder_state().equals("30")) {
                            holder.setVisible(R.id.rl_mune, false)
                                    .setVisible(R.id.tv_ok_order, true)
                                    .setVisible(R.id.rl_ok_mune, true);
                        }
                        if (data.getOrder().get(0).getOrder_state().equals("20")) {
                            holder.setVisible(R.id.rl_mune, true)
                                    .setVisible(R.id.tv_delete_order, false)
                                    .setVisible(R.id.tv_submit_order, false)
                                    .setVisible(R.id.rl_ok_mune, false);
                        }
                        if (data.getOrder().get(0).getOrder_state().equals("40")) {
                            holder.setVisible(R.id.rl_mune, false)
                                    .setVisible(R.id.tv_ok_order, false)
                                    .setVisible(R.id.rl_ok_mune, true);
                        }
                        break;
                }

                holder.setOnClickListener(R.id.tv_submit_order, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, PayingActivity.class);
                        intent.putExtra("price", data.getTotal_price());
                        intent.putExtra("pay_sn", data.getPay_sn());
                        intent.putExtra("Flag", "1");
                        mContext.startActivity(intent);
                    }
                });
                holder.setOnClickListener(R.id.tv_order_details, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, OrderDetalisActivity.class);
                        intent.putExtra("is_virtual", "0");
                        intent.putExtra("pay_sn", data.getPay_sn());
                        intent.putExtra("type", "0");
                        mContext.startActivity(intent);
                    }
                });
                holder.setOnClickListener(R.id.tv_delete_order, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (backDialog == null) {
                            backDialog = ConfirmDialog.newInstance("温馨提示", "亲、您真的要取消该单吗？", "取消", "确定");
                        }
                        backDialog.setMargin(60)
                                .setWidth(SystemInfoUtil.getScreenWidth() * 2 / 3)
                                .setOutCancel(false)
                                .show();
                        backDialog.setConfirmDialogListener(new ConfirmDialog.ConfirmDialogListener() {

                            @Override
                            public void dialogStatusYes() {
                                presenter.cancelOrder(data.getPay_sn());
                                colseDialog();
                            }

                            @Override
                            public void dialogStatusNo() {

                            }
                        });
                    }
                });
                holder.setOnClickListener(R.id.tv_order_details1, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, OrderDetalisActivity.class);
                        intent.putExtra("is_virtual", "0");
                        intent.putExtra("pay_sn", data.getPay_sn());
                        intent.putExtra("type", "1");
                        mContext.startActivity(intent);
                    }
                });
                holder.setOnClickListener(R.id.tv_ok_order, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        presenter.confirmOrder(data.getOrder().get(0).getOrder_id());
                    }
                });
            }
        };
        iPayOrderItemView.getRefreshCommonView().setRecyclerViewAdapter(payOrderItemAdapter);
        iPayOrderItemView.getRefreshCommonView().setIsAutoLoad(false);
        iPayOrderItemView.getRefreshCommonView().setIsLoadMore(false);
        iPayOrderItemView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {
            @Override
            public void startRefresh() {
                presenter.getPayOrderList(order_state);
            }

            @Override
            public void startLoadMore() {

            }
        });
    }

    public void onResultPayOrderList(Object obj) {
        iPayOrderItemView.getRefreshCommonView().finishRefresh();
        if (obj == null) {
            payOrderItemList.clear();
            iPayOrderItemView.getRefreshCommonView().setIsEmpty(true);
            return;
        }
        MyGoodsOrderBean myGoodsOrder = (MyGoodsOrderBean) obj;
        payOrderItemList.clear();
        payOrderItemList.addAll(myGoodsOrder.getMyorder());
        if (payOrderItemList == null || payOrderItemList.isEmpty()) {
            payOrderItemList.clear();
            iPayOrderItemView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iPayOrderItemView.getRefreshCommonView().setIsEmpty(false);
        }
        payOrderItemAdapter.notifyDataSetChanged();
    }

    private ConfirmDialog backDialog;

    private void colseDialog() {
        if (backDialog != null && backDialog.isVisible()) {
            backDialog.dismiss();
        }
    }

    public void onResultCancelOrder(Object obj) {
        if (obj == null) {
            return;
        }
        Entity entity = (Entity) obj;
        ToastUtil.showShort(entity.getMessage());
        iPayOrderItemView.getRefreshCommonView().notifyData();
    }

    public void onResultConfirmOrder(Object obj) {
        if (obj == null) {
            return;
        }
        MyGoodsOrderBean orderBean = (MyGoodsOrderBean) obj;
        ToastUtil.showShort(orderBean.getMessage());
        iPayOrderItemView.getRefreshCommonView().notifyData();
    }


    private ReserveChoiceClothesView iReserveChoiceClothesView;

    public void setReserveChoiceClothesViewListener(ReserveChoiceClothesView iReserveChoiceClothesView) {
        this.iReserveChoiceClothesView = iReserveChoiceClothesView;
    }

    public interface ReserveChoiceClothesView {
        TextView getServiceProgressView();

        LinearLayout mYearView();

        ImageView mYear1View();

        ImageView mYear2View();

        ImageView mYear3View();

        ImageView mYear4View();

        ImageView mMonth1View();

        ImageView mMonth2View();

        ImageView mDay1View();

        ImageView mDay2View();

        LinearLayout mLLTimeView();

        ImageView mHour1View();

        ImageView mHour2View();

        ImageView mHour3View();

        ImageView mHour4View();

        TextView mTextToastView();
    }

    private FirstOrderBean.FourEntity fourEntity;

    public void setReserveChoiceClothesViewParameter(Object... parameter) {
        fourEntity = (FirstOrderBean.FourEntity) parameter[0];
    }

    public void onResultReserveChoiceClothesDatas(Object data) {
        if (data == null)
            return;
        BookdressdateBean bookdressdate = (BookdressdateBean) data;
        if (bookdressdate == null) {
            iReserveChoiceClothesView.getServiceProgressView().setText("暂未安排");
            return;
        }
        iReserveChoiceClothesView.mTextToastView().setText(bookdressdate.getBookdress_explain());
        if (bookdressdate.getBookdressdate().equals("暂未安排")) {
            iReserveChoiceClothesView.getServiceProgressView().setText("暂未安排");
            return;
        }
        iReserveChoiceClothesView.getServiceProgressView().setText("预选服装时间已安排");

        iReserveChoiceClothesView.mYear1View().setImageDrawable(checkNum(String.valueOf(bookdressdate.getBookdressdate().charAt(0))));
        iReserveChoiceClothesView.mYear2View().setImageDrawable(checkNum(String.valueOf(bookdressdate.getBookdressdate().charAt(1))));
        iReserveChoiceClothesView.mYear3View().setImageDrawable(checkNum(String.valueOf(bookdressdate.getBookdressdate().charAt(2))));
        iReserveChoiceClothesView.mYear4View().setImageDrawable(checkNum(String.valueOf(bookdressdate.getBookdressdate().charAt(3))));
        iReserveChoiceClothesView.mMonth1View().setImageDrawable(checkNum(String.valueOf(bookdressdate.getBookdressdate().charAt(5))));
        iReserveChoiceClothesView.mMonth2View().setImageDrawable(checkNum(String.valueOf(bookdressdate.getBookdressdate().charAt(6))));
        iReserveChoiceClothesView.mDay1View().setImageDrawable(checkNum(String.valueOf(bookdressdate.getBookdressdate().charAt(8))));
        iReserveChoiceClothesView.mDay2View().setImageDrawable(checkNum(String.valueOf(bookdressdate.getBookdressdate().charAt(9))));
        iReserveChoiceClothesView.mHour1View().setImageDrawable(checkNum(String.valueOf(bookdressdate.getBookdressdate().charAt(11))));
        iReserveChoiceClothesView.mHour2View().setImageDrawable(checkNum(String.valueOf(bookdressdate.getBookdressdate().charAt(12))));
        iReserveChoiceClothesView.mHour3View().setImageDrawable(checkNum(String.valueOf(bookdressdate.getBookdressdate().charAt(14))));
        iReserveChoiceClothesView.mHour4View().setImageDrawable(checkNum(String.valueOf(bookdressdate.getBookdressdate().charAt(15))));
    }

    private ReserveChoicePhotoView iReserveChoicePhotoView;

    public void setReserveChoicePhotoViewListener(ReserveChoicePhotoView iReserveChoicePhotoView) {
        this.iReserveChoicePhotoView = iReserveChoicePhotoView;
    }

    public interface ReserveChoicePhotoView {
        LinearLayout pstLLDepartmentView();

        ImageView mImageView();

        RelativeLayout mRL1View();

        TextView mManagerNameView();

        TextView mPhoneNumberView();

        RelativeLayout mrDepView();

        TextView mSectionView();

        TextView mDepView();

        View mLineView();

        RelativeLayout mrCallView();

        ImageView mrImageLView();

        TextView mProgressView();

        LinearLayout mYearView();

        ImageView mYear1View();

        ImageView mYear2View();

        ImageView mYear3View();

        ImageView mYear4View();

        ImageView mMonth1View();

        ImageView mMonth2View();

        ImageView mDay1View();

        ImageView mDay2View();

        LinearLayout mLLTimeView();

        ImageView mHour1View();

        ImageView mHour2View();

        ImageView mHour3View();

        ImageView mHour4View();

        RelativeLayout mRLOnlineBookingView();

        TextView mOnlineBookingView();

        TextView mToastView();
    }

    private FirstOrderBean.SixEntity sixEntity;

    public void setReserveChoicePhotoViewParameter(Object... parameter) {
        sixEntity = (FirstOrderBean.SixEntity) parameter[0];
    }

    public void onResultReserveChoicePhotoDatas(Object data) {
        if (data == null)
            return;
        SelectPhotoDateBean photoDate = (SelectPhotoDateBean) data;
        if (photoDate == null) {
            iReserveChoicePhotoView.mProgressView().setText("暂未安排");
            return;
        }
        iReserveChoicePhotoView.mToastView().setText(photoDate.getExplain());
        iReserveChoicePhotoView.mProgressView().setText("选样时间已安排");
        iReserveChoicePhotoView.mManagerNameView().setText(photoDate.getDatang().getName());
        iReserveChoicePhotoView.mPhoneNumberView().setText(photoDate.getDatang().getPhone());
        iReserveChoicePhotoView.mSectionView().setText(photoDate.getDatang().getDepartmentname());
        if (photoDate.getDatang() == null) {
            iReserveChoicePhotoView.mOnlineBookingView().setText(UiUtils.getString(R.string.phonebooking));
            iReserveChoicePhotoView.pstLLDepartmentView().setVisibility(View.GONE);
        } else {
            if (StringUtils.textIsEmpty(photoDate.getDatang().getPhone()))
                iReserveChoicePhotoView.pstLLDepartmentView().setVisibility(View.GONE);
            else
                iReserveChoicePhotoView.pstLLDepartmentView().setVisibility(View.VISIBLE);

            if (StringUtils.textIsEmpty(photoDate.getMessage()))
                iReserveChoicePhotoView.mOnlineBookingView().setText(UiUtils.getString(R.string.onlinebooking));
            else
                iReserveChoicePhotoView.mOnlineBookingView().setText(photoDate.getMessage());
        }

        if (photoDate.getSelectphotodate().equals("暂未安排")) {
            iReserveChoicePhotoView.mProgressView().setText("暂未安排");
            return;
        }
        if (photoDate.getAllow_selectphoto() != 3) {
            iReserveChoicePhotoView.mOnlineBookingView().setText(UiUtils.getString(R.string.changebooking));
        }
        iReserveChoicePhotoView.mYear1View().setImageDrawable(checkNum(String.valueOf(photoDate.getSelectphotodate().charAt(0))));
        iReserveChoicePhotoView.mYear2View().setImageDrawable(checkNum(String.valueOf(photoDate.getSelectphotodate().charAt(1))));
        iReserveChoicePhotoView.mYear3View().setImageDrawable(checkNum(String.valueOf(photoDate.getSelectphotodate().charAt(2))));
        iReserveChoicePhotoView.mYear4View().setImageDrawable(checkNum(String.valueOf(photoDate.getSelectphotodate().charAt(3))));
        iReserveChoicePhotoView.mMonth1View().setImageDrawable(checkNum(String.valueOf(photoDate.getSelectphotodate().charAt(5))));
        iReserveChoicePhotoView.mMonth2View().setImageDrawable(checkNum(String.valueOf(photoDate.getSelectphotodate().charAt(6))));
        iReserveChoicePhotoView.mDay1View().setImageDrawable(checkNum(String.valueOf(photoDate.getSelectphotodate().charAt(8))));
        iReserveChoicePhotoView.mDay2View().setImageDrawable(checkNum(String.valueOf(photoDate.getSelectphotodate().charAt(9))));
        iReserveChoicePhotoView.mHour1View().setImageDrawable(checkNum(String.valueOf(photoDate.getSelectphotodate().charAt(11))));
        iReserveChoicePhotoView.mHour2View().setImageDrawable(checkNum(String.valueOf(photoDate.getSelectphotodate().charAt(12))));
        iReserveChoicePhotoView.mHour3View().setImageDrawable(checkNum(String.valueOf(photoDate.getSelectphotodate().charAt(14))));
        iReserveChoicePhotoView.mHour4View().setImageDrawable(checkNum(String.valueOf(photoDate.getSelectphotodate().charAt(15))));
    }


    private FinishingDateView iFinishingDateView;

    public void setFinishingDateViewListener(FinishingDateView iFinishingDateView) {
        this.iFinishingDateView = iFinishingDateView;
    }

    public interface FinishingDateView {
        LinearLayout pstLLDepartmentView();

        ImageView mImageView();

        RelativeLayout mRL1View();

        TextView mManagerNameView();

        TextView mPhoneNumberView();

        RelativeLayout mrDepView();

        TextView mSectionView();

        TextView mDepView();

        View mLineView();

        RelativeLayout mrCallView();

        ImageView mrImageLView();

        TextView mProgressView();

        LinearLayout mYearView();

        ImageView mYear1View();

        ImageView mYear2View();

        ImageView mYear3View();

        ImageView mYear4View();

        ImageView mMonth1View();

        ImageView mMonth2View();

        ImageView mDay1View();

        ImageView mDay2View();

        LinearLayout mLLTimeView();

        ImageView mHour1View();

        ImageView mHour2View();

        ImageView mHour3View();

        ImageView mHour4View();

        TextView mToastView();
    }

    private FirstOrderBean.SevenEntity sevenEntity;

    public void setFinishingDateViewParameter(Object... parameter) {
        sevenEntity = (FirstOrderBean.SevenEntity) parameter[0];
    }

    public void onResultReserveFinishingDate(Object data) {
        if (data == null)
            return;
        FInishingBean fInishingBean = (FInishingBean) data;
        iFinishingDateView.mToastView().setText(fInishingBean.getSeven().getChecktruing_explain());
        if (fInishingBean.getDatang() == null || StringUtils.textIsEmpty(fInishingBean.getDatang().getPhone())) {
            iFinishingDateView.pstLLDepartmentView().setVisibility(View.GONE);
        } else {
            iFinishingDateView.mManagerNameView().setText(fInishingBean.getDatang().getName());
            iFinishingDateView.mPhoneNumberView().setText(fInishingBean.getDatang().getPhone());
            iFinishingDateView.mSectionView().setText(fInishingBean.getDatang().getDepartmentname());
            iFinishingDateView.pstLLDepartmentView().setVisibility(View.VISIBLE);
        }
        if (fInishingBean.getSeven().getChecktruing().equals("暂未安排")) {
            iFinishingDateView.mProgressView().setText("暂未安排");
            return;
        }
        iFinishingDateView.mProgressView().setText(fInishingBean.getName());
        iFinishingDateView.mYear1View().setImageDrawable(checkNum(String.valueOf(fInishingBean.getSeven().getChecktruing().charAt(0))));
        iFinishingDateView.mYear2View().setImageDrawable(checkNum(String.valueOf(fInishingBean.getSeven().getChecktruing().charAt(1))));
        iFinishingDateView.mYear3View().setImageDrawable(checkNum(String.valueOf(fInishingBean.getSeven().getChecktruing().charAt(2))));
        iFinishingDateView.mYear4View().setImageDrawable(checkNum(String.valueOf(fInishingBean.getSeven().getChecktruing().charAt(3))));

        iFinishingDateView.mMonth1View().setImageDrawable(checkNum(String.valueOf(fInishingBean.getSeven().getChecktruing().charAt(5))));
        iFinishingDateView.mMonth2View().setImageDrawable(checkNum(String.valueOf(fInishingBean.getSeven().getChecktruing().charAt(6))));

        iFinishingDateView.mDay1View().setImageDrawable(checkNum(String.valueOf(fInishingBean.getSeven().getChecktruing().charAt(8))));
        iFinishingDateView.mDay2View().setImageDrawable(checkNum(String.valueOf(fInishingBean.getSeven().getChecktruing().charAt(9))));

        iFinishingDateView.mHour1View().setImageDrawable(checkNum(String.valueOf(fInishingBean.getSeven().getChecktruing().charAt(11))));
        iFinishingDateView.mHour2View().setImageDrawable(checkNum(String.valueOf(fInishingBean.getSeven().getChecktruing().charAt(12))));

        iFinishingDateView.mHour3View().setImageDrawable(checkNum(String.valueOf(fInishingBean.getSeven().getChecktruing().charAt(14))));
        iFinishingDateView.mHour4View().setImageDrawable(checkNum(String.valueOf(fInishingBean.getSeven().getChecktruing().charAt(15))));
    }

    private TemplateDateView iTemplateDateView;

    public void setTemplateDateViewListener(TemplateDateView iTemplateDateView) {
        this.iTemplateDateView = iTemplateDateView;
    }

    public interface TemplateDateView {

        TextView mProgressView();

        LinearLayout mYearView();

        ImageView mYear1View();

        ImageView mYear2View();

        ImageView mYear3View();

        ImageView mYear4View();

        ImageView mMonth1View();

        ImageView mMonth2View();

        ImageView mDay1View();

        ImageView mDay2View();

        LinearLayout mLLTimeView();

        ImageView mHour1View();

        ImageView mHour2View();

        ImageView mHour3View();

        ImageView mHour4View();

        TextView mToastView();
    }

    private FirstOrderBean.EightEntity eightEntity;

    public void setTemplateDateViewParameter(Object... parameter) {
        eightEntity = (FirstOrderBean.EightEntity) parameter[0];
    }

    public void onResultReserveTemplateDate(Object data) {
        if (data == null)
            return;

        TEmplateBean tEmplateBean = (TEmplateBean) data;

        iTemplateDateView.mToastView().setText(tEmplateBean.getEight().getCompareDate_explain());

        if (tEmplateBean.getEight().getCompareDate().equals("暂未安排")) {
            iTemplateDateView.mProgressView().setText(tEmplateBean.getEight().getCompareDate());
            return;
        }
        iTemplateDateView.mProgressView().setText(tEmplateBean.getName());

        iTemplateDateView.mYear1View().setImageDrawable(checkNum(String.valueOf(tEmplateBean.getEight().getCompareDate().charAt(0))));
        iTemplateDateView.mYear2View().setImageDrawable(checkNum(String.valueOf(tEmplateBean.getEight().getCompareDate().charAt(1))));
        iTemplateDateView.mYear3View().setImageDrawable(checkNum(String.valueOf(tEmplateBean.getEight().getCompareDate().charAt(2))));
        iTemplateDateView.mYear4View().setImageDrawable(checkNum(String.valueOf(tEmplateBean.getEight().getCompareDate().charAt(3))));

        iTemplateDateView.mMonth1View().setImageDrawable(checkNum(String.valueOf(tEmplateBean.getEight().getCompareDate().charAt(5))));
        iTemplateDateView.mMonth2View().setImageDrawable(checkNum(String.valueOf(tEmplateBean.getEight().getCompareDate().charAt(6))));

        iTemplateDateView.mDay1View().setImageDrawable(checkNum(String.valueOf(tEmplateBean.getEight().getCompareDate().charAt(8))));
        iTemplateDateView.mDay2View().setImageDrawable(checkNum(String.valueOf(tEmplateBean.getEight().getCompareDate().charAt(9))));

        iTemplateDateView.mHour1View().setImageDrawable(checkNum(String.valueOf(tEmplateBean.getEight().getCompareDate().charAt(11))));
        iTemplateDateView.mHour2View().setImageDrawable(checkNum(String.valueOf(tEmplateBean.getEight().getCompareDate().charAt(12))));

        iTemplateDateView.mHour3View().setImageDrawable(checkNum(String.valueOf(tEmplateBean.getEight().getCompareDate().charAt(14))));
        iTemplateDateView.mHour4View().setImageDrawable(checkNum(String.valueOf(tEmplateBean.getEight().getCompareDate().charAt(15))));
    }


    private ReserveExpressView iReserveExpressView;

    public void setReserveExpressViewListener(ReserveExpressView iReserveExpressView) {
        this.iReserveExpressView = iReserveExpressView;
    }

    public interface ReserveExpressView {
        LinearLayout pstLLDepartmentView();

        ImageView mImageView();

        RelativeLayout mRL1View();

        TextView mManagerNameView();

        TextView mPhoneNumberView();

        RelativeLayout mrDepView();

        TextView mSectionView();

        TextView mDepView();

        View mLineView();

        RelativeLayout mrCallView();

        ImageView mrImageLView();

        TextView mProgressView();

        LinearLayout mYearView();

        ImageView mYear1View();

        ImageView mYear2View();

        ImageView mYear3View();

        ImageView mYear4View();

        ImageView mMonth1View();

        ImageView mMonth2View();

        ImageView mDay1View();

        ImageView mDay2View();

        LinearLayout mLLTimeView();

        ImageView mHour1View();

        ImageView mHour2View();

        ImageView mHour3View();

        ImageView mHour4View();

        LinearLayout mLLYunPanView();

        TextView mTVYunAddressView();

        TextView mTVCopyView();

        LinearLayout mLLPanMoreView();

        RelativeLayout mRLOnlineBookingView();

        TextView mOnlineBookingView();

        TextView mToastView();
    }

    private FirstOrderBean.TenEntity tenEntity;

    public void setReserveExpressViewParameter(Object... parameter) {
        tenEntity = (FirstOrderBean.TenEntity) parameter[0];
    }

    public void onResultReserveExpressDate(Object data) {
        if (data == null)
            return;
        GetphotodateBean getphotodate = (GetphotodateBean) data;

        if (getphotodate.getDatang() == null || StringUtils.textIsEmpty(getphotodate.getDatang().getPhone())) {
            iReserveExpressView.pstLLDepartmentView().setVisibility(View.GONE);
        } else {
            iReserveExpressView.pstLLDepartmentView().setVisibility(View.VISIBLE);
            iReserveExpressView.mManagerNameView().setText(getphotodate.getDatang().getName());
            iReserveExpressView.mPhoneNumberView().setText(getphotodate.getDatang().getPhone());
            iReserveExpressView.mSectionView().setText(getphotodate.getDatang().getDepartmentname());
        }

        if (getphotodate.getWangpan() != null) {
            if (!StringUtils.textIsEmpty(getphotodate.getWangpan().getContent())) {
                iReserveExpressView.mLLYunPanView().setVisibility(View.VISIBLE);
                iReserveExpressView.mTVYunAddressView().setText(getphotodate.getWangpan().getContent());
            }
        }
        iReserveExpressView.mToastView().setText(getphotodate.getGetphoto_explain());
        if (StringUtils.textIsEmpty(getphotodate.getGetphotodate()) || getphotodate.getGetphotodate().equals("暂未安排")) {
            iReserveExpressView.mProgressView().setText(UiUtils.getString(R.string.xuanyang_title_null));
            return;
        }
        iReserveExpressView.mProgressView().setText("取件时间已安排");
        iReserveExpressView.mYear1View().setImageDrawable(checkNum(String.valueOf(getphotodate.getGetphotodate().charAt(0))));
        iReserveExpressView.mYear2View().setImageDrawable(checkNum(String.valueOf(getphotodate.getGetphotodate().charAt(1))));
        iReserveExpressView.mYear3View().setImageDrawable(checkNum(String.valueOf(getphotodate.getGetphotodate().charAt(2))));
        iReserveExpressView.mYear4View().setImageDrawable(checkNum(String.valueOf(getphotodate.getGetphotodate().charAt(3))));

        iReserveExpressView.mMonth1View().setImageDrawable(checkNum(String.valueOf(getphotodate.getGetphotodate().charAt(5))));
        iReserveExpressView.mMonth2View().setImageDrawable(checkNum(String.valueOf(getphotodate.getGetphotodate().charAt(6))));

        iReserveExpressView.mDay1View().setImageDrawable(checkNum(String.valueOf(getphotodate.getGetphotodate().charAt(8))));
        iReserveExpressView.mDay2View().setImageDrawable(checkNum(String.valueOf(getphotodate.getGetphotodate().charAt(9))));

        iReserveExpressView.mHour1View().setImageDrawable(checkNum(String.valueOf(getphotodate.getGetphotodate().charAt(11))));
        iReserveExpressView.mHour2View().setImageDrawable(checkNum(String.valueOf(getphotodate.getGetphotodate().charAt(12))));

        iReserveExpressView.mHour3View().setImageDrawable(checkNum(String.valueOf(getphotodate.getGetphotodate().charAt(14))));
        iReserveExpressView.mHour4View().setImageDrawable(checkNum(String.valueOf(getphotodate.getGetphotodate().charAt(15))));
    }


    private ReserveComentView iReserveComentView;

    public void setReserveComentViewListener(ReserveComentView iReserveComentView) {
        this.iReserveComentView = iReserveComentView;
    }

    public interface ReserveComentView {
        TextView getTVTypeView();

        TextView getTVStatusView();

        RelativeLayout getRLOnlinebookingView();

        TextView getTVOnlinebookingView();

        TextView getTVToWebView();

        TextView getTVToastView();
    }

    private String typeId, typeStr;

    public void setReserveComentViewParameter(Object... parameter) {
        orderId = (String) parameter[0];
        shopId = (String) parameter[1];
        typeId = (String) parameter[2];
        typeStr = (String) parameter[3];
    }

    public void initReserveComentViewDatas() {
        iReserveComentView.getTVTypeView().setText(typeStr);
        iReserveComentView.getRLOnlinebookingView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (remarkStatus.getStatus() != 2) {
                    Intent localIntent = new Intent(mContext, ComentsActivity.class);
                    localIntent.putExtra("shopid", shopId);
                    localIntent.putExtra("orderid", orderId);
                    localIntent.putExtra("remarktype", remarkStatus.getRemarktype());
                    localIntent.putExtra("status", remarkStatus.getStatus());
                    localIntent.putExtra("type", typeStr);
                    localIntent.putExtra("typeid", typeId);
                    mContext.startActivity(localIntent);
                }
            }
        });
    }

    private RemarkStatusBean remarkStatus;

    public void onResultReserveComentDatas(Object data) {
        if (data == null)
            return;
        remarkStatus = (RemarkStatusBean) data;
        if (remarkStatus == null) {
            iReserveComentView.getTVOnlinebookingView().setText("点击评价服务");
            return;
        }
        iReserveComentView.getTVStatusView().setText(remarkStatus.getMessage());
        iReserveComentView.getTVToastView().setText(remarkStatus.getExplain());
        switch (remarkStatus.getStatus()) {
            case 1:
                if (remarkStatus.getUrlmessage() != null) {
                    if (!StringUtils.textIsEmpty(remarkStatus.getUrlmessage().getUrltitle())) {
                        iReserveComentView.getTVToWebView().setVisibility(View.VISIBLE);
                        iReserveComentView.getTVToWebView().setText(remarkStatus.getUrlmessage().getButtontitle());
                    }
                    iReserveComentView.getTVOnlinebookingView().setText("点击查看评价");
                    iReserveComentView.getRLOnlinebookingView().setBackgroundResource(R.drawable.btn_shape_orange);
                } else {
                    iReserveComentView.getTVOnlinebookingView().setText("点击评价客服");
                }
                break;

            default:
                iReserveComentView.getTVOnlinebookingView().setText("暂时无法评价");
                iReserveComentView.getRLOnlinebookingView().setBackgroundResource(R.drawable.btn_grag_shap);
                break;
        }

    }


    private ReserveRemarkView iReserveRemarkView;

    public void setReserveRemarkViewListener(ReserveRemarkView iReserveRemarkView) {
        this.iReserveRemarkView = iReserveRemarkView;
    }

    public interface ReserveRemarkView {
        CommonCrosswiseBar getCommonCrosswiseBarView();

        ImageView getImageView();

        RecyclerView getRCCommentView();

        LinearLayout getLLNoCommentView();

        EditText getEDCommentView();

        TextView getTVCommentCountView();

        LinearLayout getLLBeenCommentedView();

        TextView getTVCommentuserView();

        TextView getTVCommentdateView();

        TextView getTVCommentcontentView();

        RecyclerView getRVBeenCommentedView();

        LinearLayout getLLUserCallbackView();

        TextView getTVAddCommentdateView();

        TextView getTVSecondCommentcontentView();

        LinearLayout getLLQuestionnaireView();

        TextView getTVQuestionnaireDesView();

        RecyclerView getRVQuestionView();

        LinearLayout getLLObstacleView();

        TextView getTVSubmitView();

        TextView getTVAdditionalSubmitView();
    }

    private int remarkType, status;

    public void setReserveRemarkViewParameter(Object... parameter) {
        orderId = (String) parameter[0];
        shopId = (String) parameter[1];
        typeId = (String) parameter[2];
        type = (String) parameter[3];
        remarkType = (int) parameter[4];
        status = (int) parameter[5];
    }

    private List<RemarkListBean.MyQustion> myQustionList = new ArrayList<>();
    private List<RemarkBean> commentsList = new ArrayList<>();
    private List<ReplyBean> replyBeanList = new ArrayList<>();
    private SimpleAdapter commentsAdapter, qustionAdapter, replyAdapter;

    public void initReserveRemarkViewDatas() {
        iReserveRemarkView.getCommonCrosswiseBarView().setTitleText(type);
        switch (typeId) {
            case "1":
                iReserveRemarkView.getImageView().setImageDrawable(UiUtils.getDrawable(R.drawable.order_service_logo));
                break;
            case "2":
                iReserveRemarkView.getImageView().setImageDrawable(UiUtils.getDrawable(R.drawable.order_remark2));
                break;
            case "3":
                iReserveRemarkView.getImageView().setImageDrawable(UiUtils.getDrawable(R.drawable.order_remark3));
                break;
            case "4":
                iReserveRemarkView.getImageView().setImageDrawable(UiUtils.getDrawable(R.drawable.order_remark4));
                break;
        }
        commentsAdapter = new SimpleAdapter<RemarkBean>(mContext, commentsList, R.layout.item_comment) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final RemarkBean data) {
                holder.setText(R.id.tv_title, data.getTitle());
                RadioGroup radioGroup = holder.getView(R.id.rg_comment);
                switch (data.getScore()) {
                    case "1":
                        radioGroup.check(R.id.rb_notsatisfied);
                        break;
                    case "2":
                        radioGroup.check(R.id.rb_general);
                        break;
                    case "3":
                        radioGroup.check(R.id.rb_verysatisfied);
                        break;
                    case "4":
                        radioGroup.check(R.id.rb_best);
                        break;
                }

            }
        };
        iReserveRemarkView.getRCCommentView().setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.VERTICAL));
        iReserveRemarkView.getRCCommentView().setNestedScrollingEnabled(false);
        iReserveRemarkView.getRCCommentView().setAdapter(commentsAdapter);

        qustionAdapter = new SimpleAdapter<RemarkListBean.MyQustion>(mContext, myQustionList, R.layout.qusiton_item) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final RemarkListBean.MyQustion data) {

            }
        };
        iReserveRemarkView.getRVQuestionView().setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.VERTICAL));
        iReserveRemarkView.getRVQuestionView().setNestedScrollingEnabled(false);
        iReserveRemarkView.getRVQuestionView().setAdapter(qustionAdapter);

        replyAdapter = new SimpleAdapter<ReplyBean>(mContext, replyBeanList, R.layout.item_translation) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final ReplyBean data) {
                holder.setText(R.id.tv_commentcontent, data.getMessage())
                        .setText(R.id.tv_commentdate, data.getCreatetime())
                        .setText(R.id.tv_commentreply, data.getName());

            }
        };
        iReserveRemarkView.getRVBeenCommentedView().setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.VERTICAL));
        iReserveRemarkView.getRVBeenCommentedView().setNestedScrollingEnabled(false);
        iReserveRemarkView.getRVBeenCommentedView().setAdapter(replyAdapter);

        if (status == 0) {
            iReserveRemarkView.getTVSubmitView().setVisibility(View.VISIBLE);
            iReserveRemarkView.getLLNoCommentView().setVisibility(View.VISIBLE);
            iReserveRemarkView.getLLObstacleView().setVisibility(View.GONE);
        }


    }

    public void onResultReserveRemarkDatas(Object data) {
        if (data == null)
            return;
        myQustionList.clear();
        commentsList.clear();
        replyBeanList.clear();

        RemarkListBean remarkBean = (RemarkListBean) data;

        iReserveRemarkView.getTVSecondCommentcontentView().setText(remarkBean.getSecondreply().getSecondcomment());
        iReserveRemarkView.getTVAddCommentdateView().setText(remarkBean.getSecondreply().getAddtime());


        myQustionList.addAll(remarkBean.getQuestion());
        if (myQustionList == null || myQustionList.isEmpty()) {
            iReserveRemarkView.getLLQuestionnaireView().setVisibility(View.GONE);
        } else {
            iReserveRemarkView.getLLQuestionnaireView().setVisibility(View.VISIBLE);
            iReserveRemarkView.getTVQuestionnaireDesView().setText(remarkBean.getQuestionkey());
            qustionAdapter.notifyDataSetChanged();
        }

        commentsList.addAll(remarkBean.getRemark());
        if (commentsList.isEmpty()) {
            iReserveRemarkView.getRCCommentView().setVisibility(View.GONE);
        } else {
            iReserveRemarkView.getRCCommentView().setVisibility(View.VISIBLE);
            commentsAdapter.notifyDataSetChanged();
        }

        replyBeanList.addAll(remarkBean.getReply());
        if (replyBeanList.isEmpty()) {
            iReserveRemarkView.getRVBeenCommentedView().setVisibility(View.GONE);
        } else {
            iReserveRemarkView.getRVBeenCommentedView().setVisibility(View.VISIBLE);
            replyAdapter.notifyDataSetChanged();
        }
        iReserveRemarkView.getLLBeenCommentedView().setVisibility(View.VISIBLE);
        iReserveRemarkView.getTVCommentuserView().setText(remarkBean.getUsername());
        iReserveRemarkView.getTVCommentdateView().setText(remarkBean.getAddtime());
        iReserveRemarkView.getTVCommentcontentView().setText(remarkBean.getComment());
    }


    private PickUpDetailsView iPickUpDetailsView;

    public void setPickUpDetailsViewListener(PickUpDetailsView iPickUpDetailsView) {
        this.iPickUpDetailsView = iPickUpDetailsView;
    }

    public interface PickUpDetailsView {
        RecyclerView getRecyclerView();
    }

    public void setPickUpDetailsViewParameter(Object... parameter) {
        orderId = (String) parameter[0];
        shopId = (String) parameter[1];
    }

    private SimpleAdapter pickUpAdapter;
    private List<PickUpBean.InfoEntity> pickUpList = new ArrayList<>();

    public void initPickUpDetailsViewDatas() {
        pickUpAdapter = new SimpleAdapter<PickUpBean.InfoEntity>(mContext, pickUpList, R.layout.item_pick_up) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final PickUpBean.InfoEntity data) {
                holder.setText(R.id.goodname, data.getGoodname())
                        .setText(R.id.unittype, data.getUnittype())
                        .setText(R.id.goodsizename, data.getGoodsizename())
                        .setText(R.id.number, data.getNumber())
                        .setText(R.id.tv_state, "制作中");
                if (data.getIsout() == 1) {
                    holder.setText(R.id.tv_state, "已取件");
                }
                if (data.getIsin() == 1) {
                    holder.setText(R.id.tv_state, "制作完成");
                }
            }
        };
        iPickUpDetailsView.getRecyclerView().setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.VERTICAL));
        iPickUpDetailsView.getRecyclerView().setAdapter(pickUpAdapter);
    }

    public void onResultPickUpDetailsDatas(Object data) {
        if (data == null)
            return;
        PickUpBean pickUpBean = (PickUpBean) data;
        pickUpList.clear();
        pickUpList.addAll(pickUpBean.getInfo());
        pickUpAdapter.notifyDataSetChanged();
    }


    private OutdoorSceneView iOutdoorSceneView;

    public void setOutdoorSceneViewListener(OutdoorSceneView iOutdoorSceneView) {
        this.iOutdoorSceneView = iOutdoorSceneView;
    }

    public interface OutdoorSceneView {
        RefreshCommonView getRefreshCommonView();
    }

    private String showouter;

    public void setOutdoorSceneViewParameter(Object... parameter) {
        orderId = (String) parameter[0];
        shopId = (String) parameter[1];
        showouter = (String) parameter[2];
    }

    private SimpleAdapter outdoorAdapter;
    private List<ShootStategyBean.Date> outdoorList = new ArrayList<>();
    public void initOutdoorSceneViewDatas() {
        outdoorAdapter = new SimpleAdapter<ShootStategyBean.Date>(mContext, outdoorList, R.layout.item_shoot_course) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final ShootStategyBean.Date data) {
                Drawable localDrawable1 = UiUtils.getDrawable(R.drawable.set_final_circuit_gray);
                localDrawable1.setBounds(0, 0, localDrawable1.getMinimumWidth(), localDrawable1.getMinimumHeight());
                Drawable localDrawable2 = UiUtils.getDrawable(R.drawable.set_final_circuit);
                localDrawable2.setBounds(0, 0, localDrawable2.getMinimumWidth(), localDrawable2.getMinimumHeight());
                if (data.getIschioce().equals("1")) {
                    holder.setBackgroundRes(R.id.tv_set,R.drawable.button_ok);
                    holder.<TextView>getView(R.id.tv_set).setCompoundDrawables(localDrawable2, null, null, null);
                    holder.setTextColor(R.id.tv_set,UiUtils.getColor(R.color.color_ffffff));
                    holder.setText(R.id.tv_set,"已设为最喜欢的路线");
                }else{
                    holder.setBackgroundRes(R.id.tv_set,R.drawable.border_shape_gray2);
                    holder.<TextView>getView(R.id.tv_set).setCompoundDrawables(localDrawable1, null, null, null);
                    holder.setTextColor(R.id.tv_set,UiUtils.getColor(R.color.grey_color2));
                    holder.setText(R.id.tv_set,"设为最喜欢的线路");
                }
                holder.setText(R.id.tv_des,data.getText())
                        .setText(R.id.tv_title,data.getName())
                        .setVisible(R.id.ll_page,false);
                ImageUtil.loadImageViewLoding(mContext, data.getPic(), holder.<ImageView>getView(R.id.iv_photo), R.drawable.icon_default, R.drawable.icon_default_shop);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, NewAllStrategyActivity.class);
                        intent.putExtra("lineid", data.getId());
                        intent.putExtra("orderid", orderId);
                        intent.putExtra("shopid", shopId);
                        mContext.startActivity(intent);
                    }
                });
            }
        };
        iOutdoorSceneView.getRefreshCommonView().setRecyclerViewAdapter(outdoorAdapter);
        iOutdoorSceneView.getRefreshCommonView().setIsAutoLoad(false);
        iOutdoorSceneView.getRefreshCommonView().setIsLoadMore(false);
        iOutdoorSceneView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {
            @Override
            public void startRefresh() {
                presenter.getOutdoorSceneList(orderId,shopId);
            }

            @Override
            public void startLoadMore() {

            }
        });
    }

    public void onResultOutdoorScene(Object datas){
        iOutdoorSceneView.getRefreshCommonView().finishRefresh();
        if (datas==null)
            return;
        ShootStategyBean shootStategy = (ShootStategyBean)datas;
        outdoorList.clear();
        outdoorList.addAll(shootStategy.getData());
        if (outdoorList == null || outdoorList.isEmpty()) {
            outdoorList.clear();
            iOutdoorSceneView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iOutdoorSceneView.getRefreshCommonView().setIsEmpty(false);
        }
        outdoorAdapter.notifyDataSetChanged();
    }


    private IndoorSceneView iIndoorSceneView;

    public void setIndoorSceneViewListener(IndoorSceneView iIndoorSceneView) {
        this.iIndoorSceneView = iIndoorSceneView;
    }

    public interface IndoorSceneView {
        RefreshCommonView getRefreshCommonView();
    }

    public void setIndoorSceneViewParameter(Object... parameter) {
        orderId = (String) parameter[0];
        shopId = (String) parameter[1];
        showouter = (String) parameter[2];
    }

    private SimpleAdapter indoorAdapter;
    private List<ShootStategyBean.Date> indoorList = new ArrayList<>();
    public void initIndoorSceneViewDatas() {
        indoorAdapter = new SimpleAdapter<ShootStategyBean.Date>(mContext, indoorList, R.layout.item_shoot_strategy) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final ShootStategyBean.Date data) {
                holder.setText(R.id.tv_title,data.getName())
                        .setText(R.id.tv_size,data.getCount())
                        .setVisible(R.id.iv_delete_collect,true);
                ImageUtil.loadImageViewLoding(mContext, data.getPic(), holder.<ImageView>getView(R.id.iv_photo), R.drawable.icon_default, R.drawable.icon_default_shop);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, SceneDetailsActivity.class);
                        intent.putExtra("url", data.getUrl());
                        intent.putExtra("title", data.getName());
                        intent.putExtra("iscollect", data.getIscollect());
                        intent.putExtra("orderid", orderId);
                        intent.putExtra("shopid", shopId);
                        intent.putExtra("id", data.getId());
                        mContext.startActivity(intent);
                    }
                });

            }
        };
        iIndoorSceneView.getRefreshCommonView().setRecyclerViewAdapter(indoorAdapter);
        iIndoorSceneView.getRefreshCommonView().setIsAutoLoad(false);
        iIndoorSceneView.getRefreshCommonView().setIsLoadMore(false);
        iIndoorSceneView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {
            @Override
            public void startRefresh() {
                presenter.getIndoorSceneList(orderId,shopId);
            }

            @Override
            public void startLoadMore() {

            }
        });
    }

    public void onResultIndoorScene(Object datas){
        iIndoorSceneView.getRefreshCommonView().finishRefresh();
        if (datas==null)
            return;
        ShootStategyBean shootStategy = (ShootStategyBean)datas;
        indoorList.clear();
        indoorList.addAll(shootStategy.getData());
        if (indoorList == null || indoorList.isEmpty()) {
            indoorList.clear();
            iIndoorSceneView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iIndoorSceneView.getRefreshCommonView().setIsEmpty(false);
        }
        indoorAdapter.notifyDataSetChanged();
    }
}

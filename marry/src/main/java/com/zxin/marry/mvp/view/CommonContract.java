package com.zxin.marry.mvp.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.orhanobut.logger.Logger;
import com.zxin.marry.R;
import com.zxin.marry.activity.AddShippingAddressActivity;
import com.zxin.marry.activity.GoodsDetailsActivity;
import com.zxin.marry.activity.MarryLoginActivity;
import com.zxin.marry.activity.MarryMainActivity;
import com.zxin.marry.activity.ShopCaseDetailsActivity;
import com.zxin.marry.activity.ShopDetailsActivity;
import com.zxin.marry.bean.AddressBean;
import com.zxin.marry.bean.AddressListBean;
import com.zxin.marry.bean.AdvconBean;
import com.zxin.marry.bean.CaseBean;
import com.zxin.marry.bean.CityForm;
import com.zxin.marry.bean.CollectBean;
import com.zxin.marry.bean.Entity;
import com.zxin.marry.bean.GiftBean;
import com.zxin.marry.bean.GoodsBean;
import com.zxin.marry.bean.MarriedProcessBean;
import com.zxin.marry.bean.ShopInformation;
import com.zxin.marry.bean.UserCommon;
import com.zxin.marry.bean.UserMeaagseBean;
import com.zxin.marry.mvp.presenter.CommonPresenter;
import com.zxin.zxinlib.util.LocationUtil;
import com.zxin.marry.util.StringUtils;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.network.mvp.view.IBaseView;
import com.zxin.zxinlib.adapter.SimpleAdapter.SimpleAdapter;
import com.zxin.zxinlib.adapter.SimpleAdapter.TrdViewHolder;
import com.zxin.zxinlib.app.SystemPersimManage;
import com.zxin.zxinlib.bean.Address;
import com.zxin.zxinlib.util.AppManager;
import com.zxin.zxinlib.util.CityDaoUtil;
import com.zxin.zxinlib.util.ImageUtil;
import com.zxin.zxinlib.util.IntegerUtil;
import com.zxin.zxinlib.util.SharedPreferencesManager;
import com.zxin.zxinlib.util.SystemInfoUtil;
import com.zxin.zxinlib.util.ToastUtil;
import com.zxin.zxinlib.util.UiUtils;
import com.zxin.zxinlib.view.CommonCrosswiseBar;
import com.zxin.zxinlib.view.RefreshCommonView;
import com.zxin.zxinlib.view.X5WebView;
import com.zxin.zxinlib.view.dialog.BaseNiceDialog;
import com.zxin.zxinlib.view.dialog.NiceDialog;
import com.zxin.zxinlib.view.dialog.NiceDialogViewHolder;
import com.zxin.zxinlib.view.dialog.ProgressBarDialog;
import com.zxin.zxinlib.view.dialog.ViewConvertListener;
import com.zxin.zxinlib.view.popup.SelectorPickerView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/24.
 */

public class CommonContract implements IBaseView {
    private Context mContext;

    @Override
    public void setParameter(Object... parameter) {

    }

    @Override
    public void initDatas() {

    }

    @Override
    public void loadDatas() {

    }

    @Override
    public void onResultSuccess(Object bean) {
        if (bean == null)
            return;

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

    private CommonPresenter presenter;

    @Override
    public void setP(BasePresenter... basePresenter) {
        presenter = (CommonPresenter) basePresenter[0];
    }

    @Override
    public void OnClick(View v) {
        if (v.getId() == R.id.rl_phone1) {
            SystemInfoUtil.callDialing(userMeaagse.getShop_tel_custom());
        } else if (v.getId() == R.id.rl_phone2) {
            SystemInfoUtil.callDialing(userMeaagse.getShop_tel_second());
        } else if (v.getId() == R.id.rl_qq1) {
            if (SystemInfoUtil.isPackageInstalled("com.tencent.mobileqq")) {
                mContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("mqqwpa://im/chat?chat_type=wpa&uin=" + userMeaagse.getQq_first() + "&version=1")));
            }
        } else if (v.getId() == R.id.rl_qq2) {
            if (SystemInfoUtil.isPackageInstalled("com.tencent.mobileqq")) {
                mContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("mqqwpa://im/chat?chat_type=wpa&uin=" + userMeaagse.getQq_second() + "&version=1")));
            }
        } else if (v.getId() == R.id.rl_weixin) {
            SystemInfoUtil.systemClipBoard("微信公众号", userMeaagse.getWeixin_first());
            ToastUtil.showShort("微信公众号已复制至剪切板");
        } else if (v.getId() == R.id.ll_taking_pictures) {
            SystemInfoUtil.callDialing(userMeaagse.getShop_tel_xuanyang());
        } else if (v.getId() == R.id.ll_sample) {
            SystemInfoUtil.callDialing(userMeaagse.getShop_tel_dangqi());
        } else if (v.getId() == R.id.ll_getphoto) {
            SystemInfoUtil.callDialing(userMeaagse.getShop_tel_getphoto());
        } else if (v.getId() == R.id.common_bar_rightBtn) {
            if (iSceneDetailsView != null) {
                presenter.upDatasSeneCollect(mOrderId, mShopid, mLineId, mId, iSceneDetailsView.getTitleView().getRightText());
            }
            if (iAddressModifyView != null) {
                //保存地址
                checkedAddress();
            }
        } else if (v.getId() == R.id.tv_area_info && iAddressModifyView != null) {
            showAddressPopup();
        } else if (v.getId() == R.id.ll_address_default && iAddressModifyView != null) {
            iAddressModifyView.getCBAddressView().setChecked(!iAddressModifyView.getCBAddressView().isChecked());
        } else if (v.getId() == R.id.ll_location_city) {
            if (iCityListView.getLocationCityView().getText().toString().trim().equals("全国")) {
                jumpAllCity();
                return;
            }
            presenter.getCheckedCity(iCityListView.getLocationCityView().getText().toString().trim());
        }
    }

    private WeComeView iWeComeView;

    public void setWeComeViewListener(WeComeView testView) {
        this.iWeComeView = testView;
    }

    private AdvconBean.InfoEntity mInfoEntity;

    public void onAdsResultSuccess(Object data) {
        if (data == null)
            return;
        mInfoEntity = ((AdvconBean) data).getInfo();
        SharedPreferencesManager.setInfoEntity(mInfoEntity);
        //Fresco.newDraweeControllerBuilder().setControllerListener(controllerListener).setUri(Uri.parse(mInfoEntity.getImage())).build();
        //iWeComeView.getSdvView().setController(builder);
    }

    ControllerListener controllerListener = new BaseControllerListener() {
        public void onFailure(String paramAnonymousString, Throwable paramAnonymousThrowable) {
            Logger.e(paramAnonymousThrowable, "Error loading %s", new Object[]{paramAnonymousString});
        }

        public void onFinalImageSet(String paramAnonymousString, @Nullable ImageInfo paramAnonymousImageInfo, @Nullable Animatable paramAnonymousAnimatable) {
            if (paramAnonymousImageInfo == null) {
                return;
            }
            QualityInfo info = paramAnonymousImageInfo.getQualityInfo();
            iWeComeView.getSdvView().setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymous2View) {
                    if (!mInfoEntity.getHref().isEmpty()) {
                        iWeComeView.getSdvView().removeCallbacks(mRunnable);
                        Intent intent = new Intent();
                        intent.putExtra("address", mInfoEntity.getHref());
                        intent.putExtra("title", mInfoEntity.getTitle());
                        mContext.startActivity(intent);
                        AppManager.getAppManager().finishCurrentActivity();
                    }
                }
            });
        }

        public void onIntermediateImageSet(String paramAnonymousString, @Nullable ImageInfo paramAnonymousImageInfo) {
            Logger.d("Intermediate image received");
        }
    };

    Runnable mRunnable = new Runnable() {
        public void run() {
            if ("3.4.6".equals(SharedPreferencesManager.getMarryVersionName())) {
                SharedPreferencesManager.setMarryVersionName("3.4.6");
                UserCommon user = SharedPreferencesManager.getMarryUserInfo(UserCommon.class);
                if (user != null) {
                    mContext.startActivity(new Intent(mContext, MarryMainActivity.class));
                    return;
                }
                mContext.startActivity(new Intent(mContext, MarryLoginActivity.class));
            }
           /* Object localObject = new Intent(Ac_Welcome.this, WelcomeActivity.class);
            Ac_Welcome.this.startActivity((Intent) localObject);
            Ac_Welcome.this.finish();*/
            AppManager.getAppManager().finishCurrentActivity();
        }
    };

    public interface WeComeView {
        SimpleDraweeView getSdvView();

        RelativeLayout getTencentAdsView();

        SimpleDraweeView getSimpleView();
    }


    private ServiceCenterView iServiceCenterView;

    public void setServiceCenterViewListener(ServiceCenterView iServiceCenterView) {
        this.iServiceCenterView = iServiceCenterView;
    }

    public interface ServiceCenterView {
        CommonCrosswiseBar getTitleView();

        LinearLayout getLLPhone1View();

        TextView getTVPhone1View();

        RelativeLayout getRLPhone1View();

        ImageView getImgPhone1View();

        LinearLayout getLLPhone2View();

        TextView getTVPone2View();

        RelativeLayout getRLPhone2View();

        LinearLayout getLLTakingPicturesView();

        TextView getTVTakingPicturesView();

        RelativeLayout getRLTakingPicturesView();

        LinearLayout getLLSampleView();

        TextView getTVSampleView();

        RelativeLayout getRLSampleView();

        LinearLayout getLLPhotoView();

        TextView getTVPhotoView();

        RelativeLayout getRLPhotoView();

        LinearLayout getLLQQ1View();

        TextView getTVQQ1View();

        RelativeLayout getRLQQ1View();

        LinearLayout getLLQQ2View();

        TextView getTVQQ2View();

        RelativeLayout getRLQQ2View();

        LinearLayout getLLWeiXinView();

        TextView getTVWeiXinView();

        RelativeLayout getRLWeiXinView();
    }

    private UserMeaagseBean.InfoEntity userMeaagse;

    public void onResultServiceCenterSuccess(Object data) {
        if (data == null)
            return;
        userMeaagse = ((UserMeaagseBean) data).getInfo();
        if (userMeaagse == null)
            return;
        iServiceCenterView.getTitleView().setTitleText(userMeaagse.getShop_name());
        if (!StringUtils.textIsEmpty(userMeaagse.getShop_tel_custom())) {
            iServiceCenterView.getTVPhone1View().setText(userMeaagse.getShop_tel_custom());
            iServiceCenterView.getLLPhone1View().setVisibility(View.VISIBLE);
        }
        if (!StringUtils.textIsEmpty(userMeaagse.getShop_tel_second())) {
            iServiceCenterView.getTVPone2View().setText(userMeaagse.getShop_tel_second());
            iServiceCenterView.getLLPhone2View().setVisibility(View.VISIBLE);
        }
        if (!StringUtils.textIsEmpty(userMeaagse.getQq_first())) {
            iServiceCenterView.getTVQQ1View().setText(userMeaagse.getQq_first());
            iServiceCenterView.getLLQQ1View().setVisibility(View.VISIBLE);
        }
        if (!StringUtils.textIsEmpty(userMeaagse.getQq_second())) {
            iServiceCenterView.getTVQQ2View().setText(userMeaagse.getQq_second());
            iServiceCenterView.getLLQQ2View().setVisibility(View.VISIBLE);
        }
        if (!StringUtils.textIsEmpty(userMeaagse.getWeixin_first())) {
            iServiceCenterView.getTVWeiXinView().setText(userMeaagse.getWeixin_first());
            iServiceCenterView.getLLWeiXinView().setVisibility(View.VISIBLE);
        }
        if (!StringUtils.textIsEmpty(userMeaagse.getShop_tel_dangqi())) {
            iServiceCenterView.getTVTakingPicturesView().setText(userMeaagse.getShop_tel_dangqi());
            iServiceCenterView.getLLTakingPicturesView().setVisibility(View.VISIBLE);
        }
        if (!StringUtils.textIsEmpty(userMeaagse.getShop_tel_xuanyang())) {
            iServiceCenterView.getTVSampleView().setText(userMeaagse.getShop_tel_xuanyang());
            iServiceCenterView.getLLSampleView().setVisibility(View.VISIBLE);
        }
        if (!StringUtils.textIsEmpty(userMeaagse.getShop_tel_getphoto())) {
            iServiceCenterView.getTVPhotoView().setText(userMeaagse.getShop_tel_getphoto());
            iServiceCenterView.getLLPhotoView().setVisibility(View.VISIBLE);
        }
    }

    private SceneDetailsView iSceneDetailsView;

    public void setSceneDetailsViewListener(SceneDetailsView iSceneDetailsView) {
        this.iSceneDetailsView = iSceneDetailsView;
    }

    public interface SceneDetailsView {
        CommonCrosswiseBar getTitleView();

        X5WebView getX5WebViewView();
    }

    Intent sceneDetailsIntent;

    public void setSceneDetailsParameter(Object... parameter) {
        sceneDetailsIntent = (Intent) parameter[0];
    }

    private String mIscollect;
    private String title;
    private String mOrderId;
    private String mShopid;
    private String mLineId;
    private String url;
    private String mId;

    public void initSceneDetailsDatas() {
        mIscollect = sceneDetailsIntent.getStringExtra("iscollect");
        title = sceneDetailsIntent.getStringExtra("title");
        mOrderId = sceneDetailsIntent.getStringExtra("orderid");
        mShopid = sceneDetailsIntent.getStringExtra("shopid");
        mLineId = sceneDetailsIntent.getStringExtra("lineid");
        mId = sceneDetailsIntent.getStringExtra("id");
        url = sceneDetailsIntent.getStringExtra("url");
        iSceneDetailsView.getTitleView().setTitleText(title);
        iSceneDetailsView.getTitleView().setRightText(mIscollect.equals("0") ? "收藏" : "取消收藏");
        iSceneDetailsView.getX5WebViewView().loadUrl(url);
    }

    public void onResultUpdatasSeneCollectSuccess() {
        ToastUtil.showShort("更改成功！");
        String right = iSceneDetailsView.getTitleView().getRightText();
        iSceneDetailsView.getTitleView().setRightText(right.equals("收藏") ? "取消收藏" : "收藏");
        Bundle bundle = new Bundle();
        bundle.putInt(StringUtils.EVENT_ID, IntegerUtil.EVENT_ID_11005);
        EventBus.getDefault().post(bundle);
    }

    private CityListView iCityListView;

    public void setCityListViewListener(CityListView iCityListView) {
        this.iCityListView = iCityListView;
    }

    public interface CityListView {
        CommonCrosswiseBar getTitleView();

        RefreshCommonView getRefreshCommonView();

        TextView getLocationCityView();

        TextView getLocationNotifyView();

        RecyclerView getHotCityiew();
    }

    public void setCityListViewParameter(Object... parameter) {

    }

    private SimpleAdapter hotCityAdapter, cityAdapter;
    private List<CityForm.City> hotCityList = new ArrayList<>();
    private List<CityForm.City> cityList = new ArrayList<>();
    private BDAbstractLocationListener mListener;
    private LocationUtil locationService;
    private SystemPersimManage manage = null;
    private ProgressBarDialog dialog = null;

    public void initCityListViewDatas() {
        dialog = new ProgressBarDialog(mContext);
        if (manage == null) {
            manage = new SystemPersimManage(mContext) {
                @Override
                public void resultPerm(boolean isCan, int requestCode) {
                    if (isCan)
                        startLoacl();
                }
            };
        }
        iCityListView.getHotCityiew().setLayoutManager(UiUtils.getGridLayoutManager(3));
        iCityListView.getHotCityiew().setNestedScrollingEnabled(false);
        hotCityList.clear();
        hotCityAdapter = new SimpleAdapter<CityForm.City>(mContext, hotCityList, R.layout.item_city_hot) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final CityForm.City data) {
                holder.setText(R.id.btn_city, data.getCity());
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle bundle = new Bundle();
                        bundle.putInt(StringUtils.EVENT_ID, IntegerUtil.EVENT_ID_11012);
                        bundle.putParcelable(StringUtils.EVENT_DATA, data);
                        EventBus.getDefault().post(bundle);
                        AppManager.getAppManager().finishCurrentActivity();
                    }
                });
            }
        };
        iCityListView.getHotCityiew().setAdapter(hotCityAdapter);

        cityAdapter = new SimpleAdapter<CityForm.City>(mContext, cityList, R.layout.item_city) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final CityForm.City data) {
                holder.setText(R.id.tv_name, data.getCity());
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle bundle = new Bundle();
                        bundle.putInt(StringUtils.EVENT_ID, IntegerUtil.EVENT_ID_11012);
                        bundle.putParcelable(StringUtils.EVENT_DATA, data);
                        EventBus.getDefault().post(bundle);
                        AppManager.getAppManager().finishCurrentActivity();
                    }
                });
            }
        };
        iCityListView.getRefreshCommonView().setRecyclerViewAdapter(cityAdapter);
        iCityListView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {
            @Override
            public void startRefresh() {
                presenter.getCityList();
            }

            @Override
            public void startLoadMore() {

            }
        });
        mListener = new BDAbstractLocationListener() {

            @Override
            public void onReceiveLocation(BDLocation location) {
                locationService.stop();
                if (null != location && location.getLocType() != BDLocation.TypeServerError && location.getCity() != null) {
                    iCityListView.getLocationCityView().setText(location.getCity());
                    iCityListView.getLocationNotifyView().setText("当前GPS定位城市");
                    if (dialog != null && dialog.isShowing()) {
                        dialog.closeProgress();
                    }
                } else {
                    iCityListView.getLocationCityView().setText("全国");
                    iCityListView.getLocationNotifyView().setText("当前位置GPS定位失败");
                }
            }
        };
        locationService = new LocationUtil(mContext);
        //获取locationservice实例，建议应用中只初始化1个location实例，然后使用，可以参考其他示例的activity，都是通过此种方式获取locationservice实例的
        locationService.registerListener(mListener);
        locationService.setLocationOption(locationService.getDefaultLocationClientOption());

        manage.CheckedLoaction();
        closeDialog();
    }

    private void closeDialog() {
        iCityListView.getRefreshCommonView().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (dialog != null && dialog.isShowing()) {
                    dialog.closeProgress();
                }
            }
        }, 10000);
    }

    /*****
     * 获取定位信息
     */
    public void startLoacl() {
        if (locationService.isStart())
            locationService.stop();
        iCityListView.getRefreshCommonView().postDelayed(new Runnable() {
            @Override
            public void run() {
                locationService.start();// 定位SDK
                dialog.showProgress();
            }
        }, 100);
    }

    public void stopLoacl() {
        if (locationService == null)
            return;
        locationService.stop(); //停止定位服务
        if (dialog != null && dialog.isShowing()) {
            dialog.closeProgress();
        }
        dialog.closeProgress();
    }

    public void destroyLoacl() {
        if (locationService == null)
            return;
        locationService.unregisterListener(mListener); //注销掉监听
    }

    public void onResultCityListSuccess(Object data) {
        iCityListView.getRefreshCommonView().finishRefresh();
        iCityListView.getRefreshCommonView().finishLoadMore();
        if (data == null)
            return;
        CityForm cityForm = (CityForm) data;
        hotCityList.clear();
        cityList.clear();
        hotCityList.addAll(cityForm.getHotCitys());
        hotCityAdapter.notifyDataSetChanged();

        cityList.addAll(cityForm.getCities());
        if (cityList == null || cityList.isEmpty()) {
            cityList.clear();
            iCityListView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iCityListView.getRefreshCommonView().setIsEmpty(false);
            iCityListView.getRefreshCommonView().setIsLoadMore(false);
        }
        cityAdapter.notifyDataSetChanged();
    }

    public void onResultCheckedCitySuccess(Object bean) {
        if (bean == null) {
            jumpAllCity();
            return;
        }
        Entity entity = (Entity) bean;
        Bundle bundle = new Bundle();
        bundle.putInt(StringUtils.EVENT_ID, IntegerUtil.EVENT_ID_11012);
        CityForm.City localCity = new CityForm.City(entity.getCity(), entity.getFeastid(), entity.getCityid());
        bundle.putParcelable(StringUtils.EVENT_DATA, localCity);
        EventBus.getDefault().post(bundle);
        AppManager.getAppManager().finishCurrentActivity();
    }

    private void jumpAllCity() {
        Bundle bundle = new Bundle();
        bundle.putInt(StringUtils.EVENT_ID, IntegerUtil.EVENT_ID_11012);
        CityForm.City data = new CityForm.City("全国", "0", "24");
        bundle.putParcelable(StringUtils.EVENT_DATA, data);
        EventBus.getDefault().post(bundle);
        AppManager.getAppManager().finishCurrentActivity();
    }

    private MineCollectView iMineCollectView;

    public void setMineCollectViewListener(MineCollectView iMineCollectView) {
        this.iMineCollectView = iMineCollectView;
    }

    public interface MineCollectView {
        RefreshCommonView getRefreshCommonView();
    }

    private String fav_type;

    public void setMineCollectViewParameter(Object... parameter) {
        fav_type = (String) parameter[0];
    }

    private List<ShopInformation.EcshopBean> ecshopList = new ArrayList<>();
    private List<GoodsBean> goodsBeanList = new ArrayList<>();
    private List<CaseBean> caseBeanList = new ArrayList<>();
    private SimpleAdapter ecshopAdapter, goodsBeanAdapter, caseBeanAdapter;

    public void initMineCollectViewDadas() {
        ecshopList.clear();
        goodsBeanList.clear();
        caseBeanList.clear();
        iMineCollectView.getRefreshCommonView().setIsLoadMore(false);
        iMineCollectView.getRefreshCommonView().setIsAutoLoad(false);
        if (fav_type.equals("store")) {
            ecshopAdapter = new SimpleAdapter<ShopInformation.EcshopBean>(mContext, ecshopList, R.layout.item_shop_list) {
                @Override
                protected void onBindViewHolder(TrdViewHolder holder, final ShopInformation.EcshopBean ecshopBean) {
                    holder.setText(R.id.tv_store_name, ecshopBean.getStore_name())
                            .setText(R.id.tv_goods_count, "套餐 " + ecshopBean.getGoods_count())
                            .setText(R.id.tv_store_case, "案例 " + ecshopBean.getCases_count())
                            .setText(R.id.tv_store_collect, "粉丝 " + ecshopBean.getStore_collect())
                            .setVisible(R.id.tv_store_baozh, !ecshopBean.getStore_baozh().equals("1"))
                            .setVisible(R.id.tv_store_baozhopen, ecshopBean.getStore_baozhopen().equals("1"))
                            .setVisible(R.id.tv_store_zhping, ecshopBean.getStore_zhping().equals("1"))
                            .setVisible(R.id.tv_store_shiti, ecshopBean.getStore_shiti().equals("1"))
                            .setVisible(R.id.tv_store_qtian, ecshopBean.getStore_qtian().equals("1"))
                            .setVisible(R.id.tv_store_tuihuo, ecshopBean.getStore_tuihuo().equals("1"))
                            .setVisible(R.id.tv_store_shiyong, ecshopBean.getStore_shiyong().equals("1"))
                            .setVisible(R.id.tv_store_erxiaoshi, ecshopBean.getStore_erxiaoshi().equals("1"))
                            .setVisible(R.id.tv_store_huodaofk, ecshopBean.getStore_huodaofk().equals("1"))
                            .setVisible(R.id.tv_store_xiaoxie, ecshopBean.getStore_xiaoxie().equals("1"));
                    RecyclerView recyclerView = holder.getView(R.id.lv_gift);
                    recyclerView.setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.VERTICAL));
                    recyclerView.setNestedScrollingEnabled(false);
                    recyclerView.setAdapter(new SimpleAdapter<GiftBean>(mContext, ecshopBean.getGift(), R.layout.item_gift) {
                        @Override
                        protected void onBindViewHolder(TrdViewHolder holder, final GiftBean order) {
                            holder.setText(R.id.tv_gift_descr, order.getTitle());
                            String str = order.getType();
                            if (!str.equals("a")) {
                                holder.setText(R.id.tv_gift_title, "到店礼");
                            }
                            if (!str.equals("b")) {
                                holder.setText(R.id.tv_gift_title, "订单礼");
                            }
                            if (!str.equals("c")) {
                                holder.setText(R.id.tv_gift_title, "优惠");
                            }
                        }
                    });

                    switch (ecshopBean.getGrade_id()) {
                        case "1":
                            holder.<ImageView>getView(R.id.img_shop_level).setImageDrawable(UiUtils.getDrawable(R.drawable.icon_ordinary_buiness));
                            break;

                        case "2":
                            holder.<ImageView>getView(R.id.img_shop_level).setImageDrawable(UiUtils.getDrawable(R.drawable.icon_bronze_buiness));
                            break;

                        case "3":
                            holder.<ImageView>getView(R.id.img_shop_level).setImageDrawable(UiUtils.getDrawable(R.drawable.icon_silver_buiness));
                            break;

                        case "4":
                            holder.<ImageView>getView(R.id.img_shop_level).setImageDrawable(UiUtils.getDrawable(R.drawable.icon_gold_buiness));
                            break;

                        case "5":
                            holder.<ImageView>getView(R.id.img_shop_level).setImageDrawable(UiUtils.getDrawable(R.drawable.icon_masonry_buiness));
                            break;


                    }
                    ImageUtil.loadImageViewLoding(mContext, ecshopBean.getStore_avatar(), holder.<ImageView>getView(R.id.store_avatar), R.mipmap.default_iamge, R.mipmap.default_iamge);

                    holder.setOnItemListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(mContext, ShopDetailsActivity.class);
                            intent.putExtra("store_id", ecshopBean.getStore_id());
                            mContext.startActivity(intent);
                        }
                    });
                }
            };
            iMineCollectView.getRefreshCommonView().setEmptyText("您没收藏过任何商品哦！");
            iMineCollectView.getRefreshCommonView().setRecyclerViewAdapter(ecshopAdapter);
        }
        if (fav_type.equals("goods")) {
            goodsBeanAdapter = new SimpleAdapter<GoodsBean>(mContext, goodsBeanList, R.layout.item_set_meal) {
                @Override
                protected void onBindViewHolder(TrdViewHolder holder, final GoodsBean goodsBean) {
                    holder.setText(R.id.tv_goods_price, goodsBean.getGoods_price())
                            .setText(R.id.tv_goods_name, goodsBean.getGoods_name())
                            .setText(R.id.tv_goods_collect, goodsBean.getGoods_collect())
                            .setText(R.id.tv_marketprice, "￥" + goodsBean.getGoods_marketprice());
                    holder.<TextView>getView(R.id.tv_marketprice).getPaint().setFlags(16);
                    ImageUtil.loadImageViewLoding(mContext, goodsBean.getGoods_image(), holder.<ImageView>getView(R.id.img_icon), R.mipmap.default_iamge, R.mipmap.default_iamge);

                    holder.setOnItemListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(mContext, GoodsDetailsActivity.class);
                            intent.putExtra("goods_id", goodsBean.getGoods_id());
                            mContext.startActivity(intent);
                        }
                    });
                }
            };
            iMineCollectView.getRefreshCommonView().setEmptyText("您没收藏过任何套餐哦！");
            iMineCollectView.getRefreshCommonView().setRecyclerViewAdapter(goodsBeanAdapter);
        }
        if (fav_type.equals("cases")) {
            caseBeanAdapter = new SimpleAdapter<CaseBean>(mContext, caseBeanList, R.layout.item_studio_details) {
                @Override
                protected void onBindViewHolder(TrdViewHolder holder, final CaseBean caseBean) {
                    holder.setText(R.id.tv_content, caseBean.getCase_title());
                    ImageUtil.loadImageViewLoding(mContext, caseBean.getCase_images(), holder.<ImageView>getView(R.id.img_show), R.mipmap.default_iamge, R.mipmap.default_iamge);
                    holder.setOnItemListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(mContext, ShopCaseDetailsActivity.class);
                            intent.putExtra("case_id", caseBean.getCase_id());
                            mContext.startActivity(intent);
                        }
                    });
                }
            };
            iMineCollectView.getRefreshCommonView().setEmptyText("您没收藏过任何案例哦！");
            iMineCollectView.getRefreshCommonView().setRecyclerViewAdapter(caseBeanAdapter);
        }
        iMineCollectView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {
            @Override
            public void startRefresh() {
                presenter.getCollectList(fav_type);
            }

            @Override
            public void startLoadMore() {

            }
        });
    }

    public void onResultCollectListSuccess(Object data) {
        iMineCollectView.getRefreshCommonView().finishRefresh();
        if (data == null)
            return;
        CollectBean collectBean = (CollectBean) data;
        if (fav_type.equals("store")) {
            ecshopList.clear();
            ecshopList.addAll(collectBean.getEcshop());
            if (ecshopList == null || ecshopList.isEmpty()) {
                ecshopList.clear();
                iMineCollectView.getRefreshCommonView().setIsEmpty(true);
            } else {
                iMineCollectView.getRefreshCommonView().setIsEmpty(false);
                iMineCollectView.getRefreshCommonView().setIsLoadMore(false);
            }
            ecshopAdapter.notifyDataSetChanged();
        }
        if (fav_type.equals("goods")) {
            goodsBeanList.clear();
            goodsBeanList.addAll(collectBean.getGoods());
            if (goodsBeanList == null || goodsBeanList.isEmpty()) {
                goodsBeanList.clear();
                iMineCollectView.getRefreshCommonView().setIsEmpty(true);
            } else {
                iMineCollectView.getRefreshCommonView().setIsEmpty(false);
                iMineCollectView.getRefreshCommonView().setIsLoadMore(false);
            }
            goodsBeanAdapter.notifyDataSetChanged();
        }
        if (fav_type.equals("cases")) {
            caseBeanList.clear();
            caseBeanList.addAll(collectBean.getCaselist());
            if (caseBeanList == null || caseBeanList.isEmpty()) {
                caseBeanList.clear();
                iMineCollectView.getRefreshCommonView().setIsEmpty(true);
            } else {
                iMineCollectView.getRefreshCommonView().setIsEmpty(false);
                iMineCollectView.getRefreshCommonView().setIsLoadMore(false);
            }
            caseBeanAdapter.notifyDataSetChanged();
        }
    }

    private MineAddressView iMineAddressView;

    public void setMineAddressViewListener(MineAddressView iMineAddressView) {
        this.iMineAddressView = iMineAddressView;
    }

    public interface MineAddressView {
        RefreshCommonView getRefreshCommonView();
    }

    private List<AddressBean> addressList = new ArrayList<>();
    private SimpleAdapter addressAdapter;

    public void initMineAddressViewDadas() {
        addressAdapter = new SimpleAdapter<AddressBean>(mContext, addressList, R.layout.itme_shipping_address) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final AddressBean addressBean) {
                holder.setText(R.id.tv_user_address, addressBean.getArea_info() + addressBean.getAddress())
                        .setText(R.id.tv_user_name, addressBean.getTrue_name())
                        .setText(R.id.tv_user_phone, addressBean.getMob_phone());
                CheckBox checkBox = holder.getView(R.id.tv_selected);
                checkBox.setChecked(addressBean.getIs_default().equals("1"));

                checkBox.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //设置默认值
                        presenter.setAddressDefault(addressBean.getAddress_id());
                    }
                });
                holder.setOnClickListener(R.id.img_modify_address, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //修改
                        Intent intent = new Intent(mContext, AddShippingAddressActivity.class);
                        intent.putExtra("info", addressBean);
                        mContext.startActivity(intent);
                        return;
                    }
                });
                holder.setOnClickListener(R.id.img_delete, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //删除
                        presenter.deleteAddress(addressBean.getAddress_id());
                    }
                });
            }
        };
        iMineAddressView.getRefreshCommonView().setRecyclerViewAdapter(addressAdapter);
        iMineAddressView.getRefreshCommonView().setIsLoadMore(false);
        iMineAddressView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {
            @Override
            public void startRefresh() {
                presenter.getAddressList();
            }

            @Override
            public void startLoadMore() {

            }
        });
    }

    public void onResultAddressListSuccess(Object obj) {
        iMineAddressView.getRefreshCommonView().finishRefresh();
        if (obj == null)
            return;
        this.addressList.clear();
        AddressListBean addressList = (AddressListBean) obj;
        this.addressList.addAll(addressList.getAddress());
        if (this.addressList == null || this.addressList.isEmpty()) {
            this.addressList.clear();
            iMineAddressView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iMineAddressView.getRefreshCommonView().setIsEmpty(false);
            iMineAddressView.getRefreshCommonView().setIsLoadMore(false);
        }
        addressAdapter.notifyDataSetChanged();
    }


    private AddressModifyView iAddressModifyView;

    public void setAddressModifyViewListener(AddressModifyView iAddressModifyView) {
        this.iAddressModifyView = iAddressModifyView;
    }

    public interface AddressModifyView {
        CommonCrosswiseBar getCommonCrosswiseBarView();

        EditText getEDTNameView();

        EditText getEDTPhoneView();

        CommonCrosswiseBar getAreaInfoView();

        EditText getEDTAddressView();

        LinearLayout getAddressDefaultView();

        CheckBox getCBAddressView();
    }

    private AddressBean addressBean;

    public void initAddressModifyViewParameter(Object... parameter) {
        if (parameter[0] == null) {
            addressBean = null;
            return;
        }
        addressBean = (AddressBean) parameter[0];
    }

    public void initAddressModifyViewDadas() {
        iAddressModifyView.getCommonCrosswiseBarView().setTitleText(addressBean == null ? "添加地址" : "修改地址");
        if (addressBean == null)
            return;
        iAddressModifyView.getEDTNameView().setText(addressBean.getTrue_name());
        iAddressModifyView.getEDTPhoneView().setText(addressBean.getMob_phone());
        iAddressModifyView.getAreaInfoView().setRightText(addressBean.getArea_info());
        iAddressModifyView.getEDTAddressView().setText(addressBean.getAddress());
        iAddressModifyView.getCBAddressView().setChecked(addressBean.getIs_default().equals("1"));
    }

    private NiceDialog niceDialog;
    private Address address;

    private void showAddressPopup() {
        if (niceDialog == null) {
            niceDialog = NiceDialog.init();
        }
        niceDialog.setLayoutId(R.layout.common_popup_address)
                .setConvertListener(new ViewConvertListener() {
                    @Override
                    public void convertView(NiceDialogViewHolder holder, final BaseNiceDialog dialog) {
                        SelectorPickerView pickerView = (SelectorPickerView) holder.getConvertView();
                        pickerView.setShowCityDatas(CityDaoUtil.getInstance().getAllCityProvince());
                        if (address != null) {
                            pickerView.setShowAddressPicker(address);
                        }
                        holder.setOnClickListener(R.id.customer_picker_leftbtn, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                colseDialog();
                            }
                        });
                        pickerView.setSelectPicker(new SelectorPickerView.SelectPickerListener() {

                            @Override
                            public void onResultPicker(Object obj) {
                                if (address == null) {
                                    address = new Address();
                                }
                                address = (Address) obj;
                                iAddressModifyView.getAreaInfoView().setRightText(address.province + " " + address.city + " " + address.district);
                                colseDialog();
                            }
                        });
                    }
                })
                .setDimAmount(0.3f)
                .setShowBottom(true)
                .show();
    }

    private void colseDialog() {
        if (niceDialog != null && niceDialog.isVisible()) {
            niceDialog.dismiss();
        }
    }

    private void checkedAddress() {
        String name = iAddressModifyView.getEDTNameView().getText().toString().trim();
        String phone = iAddressModifyView.getEDTPhoneView().getText().toString().trim();
        String info = iAddressModifyView.getAreaInfoView().getRightText().toString().trim();
        String address = iAddressModifyView.getEDTAddressView().getText().toString().trim();
        if (StringUtils.textIsEmpty(name)) {
            ToastUtil.showShort("姓名不能为空...");
            return;
        }
        if (StringUtils.textIsEmpty(phone)) {
            ToastUtil.showShort("电话不能为空...");
            return;
        }
        if (StringUtils.textIsEmpty(info)) {
            ToastUtil.showShort("省市区不能为空...");
            return;
        }
        if (StringUtils.textIsEmpty(address)) {
            ToastUtil.showShort("详细地址不能为空...");
            return;
        }
        if (addressBean == null)
            //添加
            presenter.addAddress(name, phone, info, address, iAddressModifyView.getCBAddressView().isChecked() ? "1" : "0");
        else
            presenter.modifyAddress(addressBean.getAddress_id(), name, phone, info, address, iAddressModifyView.getCBAddressView().isChecked() ? "1" : "0");
    }

    public void onResultAddAddressSuccess(Object obj) {
        ToastUtil.showShort("添加成功");
        Bundle bundle = new Bundle();
        bundle.putInt(StringUtils.EVENT_ID, IntegerUtil.EVENT_ID_11011);
        EventBus.getDefault().post(bundle);
        AppManager.getAppManager().finishCurrentActivity();
    }

    public void onResultModifyAddressSuccess(Object obj) {
        ToastUtil.showShort("修改成功");
        Bundle bundle = new Bundle();
        bundle.putInt(StringUtils.EVENT_ID, IntegerUtil.EVENT_ID_11011);
        EventBus.getDefault().post(bundle);
        AppManager.getAppManager().finishCurrentActivity();
    }

    private MarriProcessView iMarriProcessView;

    public void setMarriProcessViewListener(MarriProcessView iMarriProcessView) {
        this.iMarriProcessView = iMarriProcessView;
    }

    public interface MarriProcessView {
        X5WebView getX5WebView();
    }

    public void onResultMarriProcessSuccess(Object obj) {
        if (obj == null)
            return;
        MarriedProcessBean married = (MarriedProcessBean) obj;
        iMarriProcessView.getX5WebView().loadDataWithBaseURL("about:blank", married.getInfo().getContent(), "text/html", "utf-8", null);
        //iMarriProcessView.getX5WebView().loadData(married.getInfo().getContent(),"text/html","utf-8");
    }
}

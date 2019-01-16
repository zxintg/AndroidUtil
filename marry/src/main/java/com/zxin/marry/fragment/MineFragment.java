package com.zxin.marry.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.zxin.basemodel.util.HtmlJumpUtil;
import com.zxin.marry.R;
import com.zxin.marry.activity.MarryLoginActivity;
import com.zxin.marry.activity.MarryAboutActivity;
import com.zxin.marry.activity.MarryAppointmentActivity;
import com.zxin.marry.activity.MarryCDkeyVoucherActivity;
import com.zxin.marry.activity.MarryCollectionActivity;
import com.zxin.marry.activity.MarryPayOrderActivity;
import com.zxin.marry.activity.MarrySettingActivity;
import com.zxin.marry.activity.MarryShoppingCartActivity;
import com.zxin.marry.activity.MarryTopicActivity;
import com.zxin.marry.activity.MarryVoucherActivity;
import com.zxin.marry.activity.MessageActivity;
import com.zxin.marry.activity.OrderListActivity;
import com.zxin.marry.activity.ShippingAddressActivity;
import com.zxin.marry.activity.SpreeBounsActivity;
import com.zxin.marry.activity.UserCentryActivity;
import com.zxin.marry.activity.VoucherOrderActivity;
import com.zxin.marry.base.BaseFragment;
import com.zxin.marry.mvp.presenter.UserPresenter;
import com.zxin.marry.mvp.view.UserContract;
import com.zxin.marry.util.StringUtils;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.zxinlib.bean.TitleBean;
import com.zxin.zxinlib.util.IntegerUtil;
import com.zxin.zxinlib.util.SharedPreferencesManager;
import com.zxin.zxinlib.view.RefreshCommonView;

/**
 * Created by Administrator on 2018/6/5.
 */

public class MineFragment extends BaseFragment implements BaseFragment.LazyLoadingListener,UserContract.MineMainView {
    private TitleBean titleBean;

    @InjectPresenter
    UserPresenter presenter;

    public static MineFragment newInstance(TitleBean titleBean) {
        MineFragment fragment = new MineFragment();
        Bundle args = new Bundle();
        args.putParcelable(StringUtils.FRAGMENT_DATA, titleBean);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        titleBean = getArguments().getParcelable(StringUtils.FRAGMENT_DATA);
        presenter.initDatas(this);
        setDatas();
        setLazyLoadingListener(this);
    }

    private void setDatas() {
        setTitleViewOnclick(R.id.ccb_marray_title,R.id.common_bar_rightBtn);
        setViewOnclick(R.id.iv_user_head,R.id.ll_marry_coupon,R.id.ll_cdkey_voucher,R.id.ll_spree,R.id.ll_consulting_order,R.id.ll_other_order,R.id.ll_cd_order,R.id.ll_myorder,R.id.ll_taobao,R.id.ll_shop_cart,R.id.ll_mine_topic,R.id.ll_collection,
                R.id.ll_address,R.id.ll_aboutus,R.id.ll_settings);
    }


    @Override
    public int setLayout() {
        return R.layout.fragment_mainmine;
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.common_bar_rightBtn) {
            //消息
            mContext.startActivity(new Intent(mContext, MessageActivity.class));
        } else if (i == R.id.iv_user_head) {
            //用户中心
            startActivity(new Intent(mContext, UserCentryActivity.class));
        } else if (i == R.id.ll_marry_coupon) {
            //优惠券
            startActivity(new Intent(mContext, MarryVoucherActivity.class));
        }else if (i == R.id.ll_cdkey_voucher) {
            //兑换券
            startActivity(new Intent(mContext, MarryCDkeyVoucherActivity.class));
        }else if (i == R.id.ll_spree) {
            //大礼包
            startActivity(new Intent(mContext, SpreeBounsActivity.class));
        }else if (i == R.id.ll_consulting_order) {
            //预约单
            startActivity(new Intent(mContext, MarryAppointmentActivity.class));
        }else if (i == R.id.ll_other_order) {
            //支付单
            startActivity(new Intent(mContext, MarryPayOrderActivity.class));
        }else if (i == R.id.ll_cd_order) {
            //兑换单
            startActivity(new Intent(mContext, VoucherOrderActivity.class));
        }else if (i == R.id.ll_myorder) {
            //婚纱照订单
            startActivity(new Intent(mContext, OrderListActivity.class));
        }else if (i ==R.id.ll_taobao) {
            //婚品订单
            HtmlJumpUtil.toWebForUrlActivity("婚品订单","https://s.taobao.com/search?q=%E5%A9%9A%E5%93%81&imgfile=&commend=all&ssid=s5-e&search_type=item&sourceId=tb.index&spm=a21bo.2017.201856-taobao-item.1&ie=utf8&initiative_id=tbindexz_20170306");
        }else if (i == R.id.ll_shop_cart) {
            //购物车
            startActivity(new Intent(mContext, MarryShoppingCartActivity.class));
        }else if (i == R.id.ll_mine_topic) {
            //我的话题
            startActivity(new Intent(mContext, MarryTopicActivity.class));
        }else if (i == R.id.ll_collection) {
            //我的收藏
            startActivity(new Intent(mContext, MarryCollectionActivity.class));
        }else if (i == R.id.ll_address) {
            //收货地址
            startActivity(new Intent(mContext, ShippingAddressActivity.class));
        }else if (i == R.id.ll_aboutus) {
            //关于我们
            startActivity(new Intent(mContext, MarryAboutActivity.class));
        }else if (i == R.id.ll_settings) {
            //设置
            startActivity(new Intent(mContext, MarrySettingActivity.class));
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void loadLazyDatas(boolean bool) {
        getRefreshCommonView().notifyData();
    }

    @Override
    public RefreshCommonView getRefreshCommonView() {
        return getViewById(R.id.rcv_mine_commonlayout);
    }

    @Override
    public ImageView getUserHeadView() {
        return getViewById(R.id.iv_user_head);
    }

    @Override
    public TextView getPhoneView() {
        return getViewById(R.id.tv_phone);
    }

    @Override
    public TextView getDateView() {
        return getViewById(R.id.tv_date);
    }

    //接受event事件
    @Override
    public void onEventMainThread(Bundle bundle) {
        switch (bundle.getInt(StringUtils.EVENT_ID)) {
            case IntegerUtil.EVENT_ID_11003:
                getRefreshCommonView().notifyData();
                break;
        }
    }

}

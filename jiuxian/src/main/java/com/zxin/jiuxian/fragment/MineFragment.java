package com.zxin.jiuxian.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zxin.jiuxian.R;
import com.zxin.jiuxian.activity.CollectActivity;
import com.zxin.jiuxian.activity.CommodityExchangeActivity;
import com.zxin.jiuxian.activity.FootPrintActivity;
import com.zxin.jiuxian.activity.JIuXianSettingActivity;
import com.zxin.jiuxian.activity.JiuXianRapidLoginActivity;
import com.zxin.jiuxian.activity.MemberChannelActivity;
import com.zxin.jiuxian.activity.MessageCenterActivity;
import com.zxin.jiuxian.activity.OrderListTabActivity;
import com.zxin.jiuxian.activity.UserBalanceActivity;
import com.zxin.jiuxian.activity.UserCashbackActivity;
import com.zxin.jiuxian.activity.UserCouponActivity;
import com.zxin.jiuxian.activity.UserGoldActivity;
import com.zxin.jiuxian.activity.UserWalletActivity;
import com.zxin.jiuxian.base.BaseFragment;
import com.zxin.jiuxian.mvp.presenter.UserPresenter;
import com.zxin.jiuxian.mvp.view.UserContract;
import com.zxin.jiuxian.util.StringUtils;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.bean.TitleBean;
import com.zxin.root.view.RefreshCommonView;

/**
 * Created by Administrator on 2018/8/6.
 */

public class MineFragment extends BaseFragment implements BaseFragment.LazyLoadingListener, UserContract.MineView {
    @InjectPresenter
    UserPresenter presenter;

    private TitleBean titleBean;

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
        presenter.initMineDatas(this);
        setTitleViewOnclick(R.id.ccb_jiuxian_title, R.id.common_bar_rightImage, R.id.common_bar_rightBtn);
        setViewOnclick(R.id.ccb_mine_orderlist
                , R.id.mine_jiuxian_head_notlogin
                , R.id.ccb_mine_mywallet
                , R.id.ll_mine_mywallet
                , R.id.ll_mine_backmoney
                , R.id.ll_collect
                , R.id.ll_browse
                , R.id.ll_channel
                , R.id.ll_exchange
                , R.id.ll_mine_couponcount, R.id.ll_mine_goldmoney, R.id.tv_recommond_more);
        setLazyLoadingListener(this);
    }

    @Override
    public int setLayout() {
        return R.layout.fragment_jiuxian_mine;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.mine_jiuxian_head_notlogin) {
            startActivity(new Intent(mContext, JiuXianRapidLoginActivity.class));
        }
        if (v.getId() == R.id.common_bar_rightImage) {
            //设置
            startActivity(new Intent(mContext, JIuXianSettingActivity.class));
        }
        if (v.getId() == R.id.common_bar_rightBtn) {
            //消息
            startActivity(new Intent(mContext, MessageCenterActivity.class));
        }
        if (v.getId() == R.id.ccb_mine_orderlist) {
            //我的订单
            startActivity(new Intent(mContext, OrderListTabActivity.class));
        }
        if (v.getId() == R.id.ccb_mine_mywallet) {
            //我的钱包
            startActivity(new Intent(mContext, UserWalletActivity.class));
        }
        if (v.getId() == R.id.ll_mine_mywallet) {
            startActivity(new Intent(mContext, UserBalanceActivity.class));
        }
        if (v.getId() == R.id.ll_mine_backmoney) {
            startActivity(new Intent(mContext, UserCashbackActivity.class));
        }
        if (v.getId() == R.id.ll_mine_couponcount) {
            startActivity(new Intent(mContext, UserCouponActivity.class));
        }
        if (v.getId() == R.id.ll_mine_goldmoney) {
            startActivity(new Intent(mContext, UserGoldActivity.class));
        }
        if (v.getId() == R.id.tv_recommond_more) {
            //会员推荐

        }
        if (v.getId() == R.id.ll_collect) {
            startActivity(new Intent(mContext, CollectActivity.class));
        }
        if (v.getId() == R.id.ll_browse) {
            startActivity(new Intent(mContext, FootPrintActivity.class));
        }
        if (v.getId() == R.id.ll_channel) {
            startActivity(new Intent(mContext, MemberChannelActivity.class));
        }
        if (v.getId() == R.id.ll_exchange) {
            startActivity(new Intent(mContext, CommodityExchangeActivity.class));
        }

    }

    @Override
    public void loadLazyDatas(boolean bool) {
        presenter.getModuleData();
        presenter.getWinebibber();
        presenter.getClubUserProduct();
    }

    @Override
    public RefreshCommonView getRefreshCommonView() {
        return getViewById(R.id.rcv_jiuxian_mine);
    }

    @Override
    public LinearLayout getHeadNotLoginView() {
        return getViewById(R.id.mine_jiuxian_head_notlogin);
    }

    @Override
    public RelativeLayout getHeadLoginView() {
        return getViewById(R.id.mine_jiuxian_head_login);
    }

    @Override
    public TextView getAccountMoneyView() {
        return getViewById(R.id.tv_account_money);
    }

    @Override
    public TextView getBackMoneyView() {
        return getViewById(R.id.tv_back_money);
    }

    @Override
    public TextView getCouponView() {
        return getViewById(R.id.tv_discount_coupon);
    }

    @Override
    public TextView getGoldMoneyView() {
        return getViewById(R.id.tv_gold);
    }

    @Override
    public ImageView getCollectView() {
        return getViewById(R.id.iv_collect);
    }

    @Override
    public TextView getCollectCountView() {
        return getViewById(R.id.tv_collect_count);
    }

    @Override
    public ImageView getBrowseView() {
        return getViewById(R.id.iv_browse);
    }

    @Override
    public TextView getBrowseCountView() {
        return getViewById(R.id.tv_browse_count);
    }

    @Override
    public ImageView getChannelView() {
        return getViewById(R.id.iv_channel);
    }

    @Override
    public TextView getExchangeCountView() {
        return getViewById(R.id.tv_exchange_count);
    }

    @Override
    public RecyclerView getModuleListView() {
        return getViewById(R.id.rv_mine_module);
    }

    @Override
    public RecyclerView getRecommondListView() {
        return getViewById(R.id.rv_mine_recommond);
    }
}

package com.zxin.jiuxian.activity;

import android.content.Intent;
import android.view.View;
import com.zxin.jiuxian.R;
import com.zxin.jiuxian.base.BaseActivity;

/**
 * Created by Administrator on 2018/8/3.
 */

public class UserWalletActivity extends BaseActivity {
    @Override
    public void initData() {
        setTitleViewOnclick(R.id.ccb_jiuxian_title,R.id.common_bar_leftBtn);
        setViewOnclick(R.id.ccb_wallet_balance,R.id.ccb_wallet_cashback,R.id.ccb_wallet_coupon,R.id.ccb_wallet_gold);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_user_wallet;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_leftBtn){
            onBackPressed();
            return;
        }
        if (v.getId()==R.id.ccb_wallet_balance){
            startActivity(new Intent(mContext, UserBalanceActivity.class));
        }
        if (v.getId()==R.id.ccb_wallet_cashback){
            startActivity(new Intent(mContext, UserCashbackActivity.class));
        }
        if (v.getId()==R.id.ccb_wallet_coupon){
            startActivity(new Intent(mContext, UserCouponActivity.class));
        }
        if (v.getId()==R.id.ccb_wallet_gold){
            startActivity(new Intent(mContext, UserGoldActivity.class));
        }
    }
}

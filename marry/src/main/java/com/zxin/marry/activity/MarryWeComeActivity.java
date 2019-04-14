package com.zxin.marry.activity;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;

import com.baidu.mapapi.SDKInitializer;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.marry.bean.UserCommon;
import com.zxin.marry.mvp.presenter.CommonPresenter;
import com.zxin.marry.mvp.view.CommonContract;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.router.annotation.Route;
import com.zxin.root.util.SharedPreferencesManager;

/**
 * Created by Administrator on 2018/6/13.
 */
@Route("marry/MarryWeComeActivity")
public class MarryWeComeActivity extends BaseActivity implements CommonContract.WeComeView {

    @InjectPresenter
    CommonPresenter presenter;

    @Override
    public void initData() {
        setViewOnclick(R.id.simple);
        presenter.initDatas(this);
        presenter.getTencentAds();
    }

    @Override
    public int setLayout() {
        return R.layout.activity_gate;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.simple){
            if (SharedPreferencesManager.getIsMarryFirstEnter()) {
                startActivity(new Intent(mContext, MarryGuideActivity.class));
                onBackPressed();
                return;
            }
            SharedPreferencesManager.setMarryVersionName("3.4.6");
            UserCommon user = SharedPreferencesManager.getMarryUserInfo(UserCommon.class);
            if (user != null) {
                startActivity(new Intent(mContext, MarryMainActivity.class));
                onBackPressed();
                return;
            }
            startActivity(new Intent(mContext, MarryLoginActivity.class));
            onBackPressed();
        }
    }

    @Override
    public SimpleDraweeView getSdvView() {
        return getViewById(R.id.sdv);
    }

    @Override
    public RelativeLayout getTencentAdsView() {
        return getViewById(R.id.tencent_ad);
    }

    @Override
    public SimpleDraweeView getSimpleView() {
        return getViewById(R.id.simple);
    }
}

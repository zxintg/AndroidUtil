package com.zxin.marry.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.marry.mvp.presenter.HotlePresenter;
import com.zxin.marry.mvp.view.HotleContract;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.zxinlib.view.RefreshCommonView;

/**
 * Created by Administrator on 2018/6/26.
 */

public class WeddingPartyActivity extends BaseActivity implements HotleContract.WeddingPartyView {
    @InjectPresenter
    HotlePresenter presenter;

    @Override
    public void initData() {
        setTitleViewOnclick(R.id.ccb_marray_title,R.id.common_bar_leftBtn);
        setViewOnclick(R.id.iv_goback);
        presenter.initWeddingPartyDatas(this);
    }

    @Override
    public int setLayout() {
        return R.layout.ac_wedding_party;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_leftBtn||v.getId()==R.id.iv_goback){
            onBackPressed();
        }
    }

    @Override
    public RefreshCommonView getRefreshCommonView() {
        return getViewById(R.id.rcv_party_commonlayout);
    }

    @Override
    public ConvenientBanner getConvenientBannerView() {
        return getViewById(R.id.cb_slidePage);
    }

    @Override
    public RecyclerView getGVOptionsiteView() {
        return getViewById(R.id.gv_optionsite);
    }

    @Override
    public RecyclerView getRVAreaView() {
        return getViewById(R.id.gv_area);
    }
}

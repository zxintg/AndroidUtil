package com.zxin.marry.activity;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.marry.mvp.presenter.HotlePresenter;
import com.zxin.marry.mvp.view.HotleContract;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.zxinlib.view.CommonCrosswiseBar;

/**
 * Created by Administrator on 2018/6/27.
 */

public class FindHotleActivity extends BaseActivity implements HotleContract.FindHotleView {
    @InjectPresenter
    HotlePresenter presenter;

    @Override
    public void initData() {
        presenter.initFindHotleDatas(this);
        setTitleViewOnclick(R.id.ccb_marray_title,R.id.common_bar_leftBtn);
        setViewOnclick(R.id.ll_more);
        presenter.getFindHotleDetail();
        presenter.getRecommendHotelList();
    }

    @Override
    public int setLayout() {
        return R.layout.ac_find_hotel;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_leftBtn){
            onBackPressed();
        }else if (v.getId()==R.id.ll_more){
            Intent intent = new Intent(mContext, WeddingPartyActivity.class);
            intent.setFlags(335544320);
            startActivity(intent);
        }
    }

    @Override
    public CommonCrosswiseBar getCommonCrosswiseBarView() {
        return getViewById(R.id.ccb_marray_title);
    }

    @Override
    public ConvenientBanner getConvenientBannerView() {
        return getViewById(R.id.convenientBanner);
    }

    @Override
    public RecyclerView getRecyclerView() {
        return getViewById(R.id.recyclerView);
    }

    @Override
    public EditText getEDTNameView() {
        return getViewById(R.id.edt_name);
    }

    @Override
    public EditText getEDTPhoneView() {
        return getViewById(R.id.edt_phone_number);
    }

    @Override
    public TextView getTVSuccessView() {
        return getViewById(R.id.tv_success);
    }

    @Override
    public TextView getTVAppdescView() {
        return getViewById(R.id.tv_appdesc);
    }

    @Override
    public LinearLayout getLLButtomView() {
        return getViewById(R.id.ll_buttom);
    }

    @Override
    public LinearLayout getLLMoreView() {
        return getViewById(R.id.ll_more);
    }

    @Override
    public RecyclerView getRecyclerHotleView() {
        return getViewById(R.id.gv_hotel);
    }
}

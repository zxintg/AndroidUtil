package com.zxin.marry.fragment.discovery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zxin.marry.R;
import com.zxin.marry.activity.HotNewsActivity;
import com.zxin.marry.activity.SubjectListActivity;
import com.zxin.marry.base.BaseFragment;
import com.zxin.marry.bean.CityForm;
import com.zxin.marry.mvp.presenter.DiscoveryPresenter;
import com.zxin.marry.mvp.view.MainDiscoveryContract;
import com.zxin.marry.util.StringUtils;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.zxinlib.util.IntegerUtil;
import com.zxin.zxinlib.util.SharedPreferencesManager;
import com.zxin.zxinlib.util.ToastUtil;
import com.zxin.zxinlib.view.RefreshCommonView;
import com.zxin.zxinlib.view.banner.VerticalBannerView;

/**
 * Created by Administrator on 2018/6/25.
 */

public class NationwideFragment extends BaseFragment implements MainDiscoveryContract.NationwideView {
    private CityForm.City mCity;

    @InjectPresenter
    DiscoveryPresenter presenter;

    @Override
    public void initData() {
        mCity = getArguments().getParcelable(StringUtils.FRAGMENT_DATA);
        setViewOnclick(R.id.sdv_subject,R.id.ll_marry_hot);
        presenter.initNationwideDatas(this,mCity,NationwideFragment.class.getName());
    }

    @Override
    public int setLayout() {
        return R.layout.fragment_nationwide;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.sdv_subject){
            startActivity(new Intent(mContext,SubjectListActivity.class));
        }else if (v.getId() == R.id.ll_marry_hot) {
            startActivity(new Intent(mContext, HotNewsActivity.class));
        }
    }

    @Override
    public RefreshCommonView getRefreshCommonView() {
        return getViewById(R.id.rcv_nationwide_commonlayout);
    }

    @Override
    public ConvenientBanner getConvenientBannerView() {
        return getViewById(R.id.convenientBanner);
    }

    @Override
    public RecyclerView getRecyclerView() {
        return getViewById(R.id.rv_goods_clazz);
    }

    @Override
    public SimpleDraweeView getSDVSubjectView() {
        return getViewById(R.id.sdv_subject);
    }

    @Override
    public LinearLayout getLLMarryHotView() {
        return getViewById(R.id.ll_marry_hot);
    }

    @Override
    public VerticalBannerView getVerticalBannerView() {
        return getViewById(R.id.vbv_banner);
    }
}

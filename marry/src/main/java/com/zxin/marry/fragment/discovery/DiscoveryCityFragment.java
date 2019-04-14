package com.zxin.marry.fragment.discovery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.zxin.marry.R;
import com.zxin.marry.activity.DesignActivity;
import com.zxin.marry.activity.FindHotleActivity;
import com.zxin.marry.activity.GoodsMoreActivity;
import com.zxin.marry.activity.HotNewsActivity;
import com.zxin.marry.activity.WeddingBudgetActivity;
import com.zxin.marry.activity.WeddingPlannerActivity;
import com.zxin.marry.base.BaseFragment;
import com.zxin.marry.bean.CityForm;
import com.zxin.marry.mvp.presenter.DiscoveryPresenter;
import com.zxin.marry.mvp.view.MainDiscoveryContract;
import com.zxin.marry.util.StringUtils;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.util.IntegerUtil;
import com.zxin.root.util.SharedPreferencesManager;
import com.zxin.root.view.RefreshCommonView;
import com.zxin.root.view.banner.VerticalBannerView;

/**
 * Created by Administrator on 2018/6/25.
 */

public class DiscoveryCityFragment extends BaseFragment implements MainDiscoveryContract.DiscoveryCityView {
    private CityForm.City mCity;
    private String sc_id;
    private String name;

    @InjectPresenter
    DiscoveryPresenter presenter;

    @Override
    public void initData() {
        mCity = getArguments().getParcelable(StringUtils.FRAGMENT_DATA);
        presenter.initDiscoveryCityDatas(this, mCity);
        presenter.getDiscoveryCityCheckedCity(mCity.getCity());
        setViewOnclick(R.id.ll_marry_product,R.id.ll_monster_goods,R.id.sdv_wedding_party, R.id.id_monster_wedding_budget, R.id.ll_marry_hot, R.id.ll_marry_plan, R.id.ll_wedding_planner);
    }

    @Override
    public int setLayout() {
        return R.layout.fragment_discoverycity;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ll_marry_product||v.getId() == R.id.ll_monster_goods) {
            startActivity(new Intent(mContext, GoodsMoreActivity.class));
        }else if (v.getId() == R.id.sdv_wedding_party) {
            startActivity(new Intent(mContext, FindHotleActivity.class));
        } else if (v.getId() == R.id.id_monster_wedding_budget) {
            startActivity(new Intent(mContext, WeddingBudgetActivity.class));
        } else if (v.getId() == R.id.ll_marry_hot) {
            startActivity(new Intent(mContext, HotNewsActivity.class));
        } else if (v.getId() == R.id.ll_marry_plan) {
            Intent intent = new Intent(mContext, DesignActivity.class);
            intent.putExtra("sc_id", sc_id);
            intent.putExtra("name", name);
            intent.putExtra("CityId", mCity.getCityid());
            startActivity(intent);
        } else if (v.getId() == R.id.ll_wedding_planner) {
            startActivity(new Intent(mContext, WeddingPlannerActivity.class));
        }
    }

    //接受event事件
    @Override
    public void onEventMainThread(Bundle bundle) {
        switch (bundle.getInt(StringUtils.EVENT_ID)) {
            case IntegerUtil.EVENT_ID_11012:
                //地址修改
                CityForm.City city = bundle.getParcelable(StringUtils.EVENT_DATA);
                if (city.getCity().equals("全国") || SharedPreferencesManager.getMarryCity(CityForm.City.class).getCity().equals(city.getCity()))
                    return;
                presenter.getDiscoveryCityCheckedCity(city.getCity());
                break;
        }
    }

    @Override
    public RefreshCommonView getRefreshCommonView() {
        return getViewById(R.id.rcv_discoverycity_commonlayout);
    }

    @Override
    public ConvenientBanner getConvenientBannerView() {
        return getViewById(R.id.cb_slidePage);
    }

    @Override
    public RecyclerView getRecyclerView() {
        return getViewById(R.id.rv_goods_clazz);
    }


    @Override
    public LinearLayout getLLMarryHotView() {
        return getViewById(R.id.ll_marry_hot);
    }

    @Override
    public VerticalBannerView getVerticalBannerView() {
        return getViewById(R.id.vbv_banner);
    }

    @Override
    public ImageView getSDVWeddingPartyView() {
        return getViewById(R.id.sdv_wedding_party);
    }

    @Override
    public LinearLayout getLLMarryProductView() {
        return getViewById(R.id.ll_marry_product);
    }

    @Override
    public LinearLayout getLLMonsterWeddingBudgetView() {
        return getViewById(R.id.id_monster_wedding_budget);
    }

    @Override
    public LinearLayout getLLMarryPlanView() {
        return getViewById(R.id.ll_marry_plan);
    }

    @Override
    public LinearLayout getLLWeddingPlannerView() {
        return getViewById(R.id.ll_wedding_planner);
    }

    @Override
    public TextView getTVCountView() {
        return getViewById(R.id.tv_count);
    }

    @Override
    public RecyclerView getRVGoodsView() {
        return getViewById(R.id.rv_monster_goods);
    }

    @Override
    public void setDatasResult(String sc_id, String name) {
        this.sc_id = sc_id;
        this.name = name;
    }

}

package com.zxin.marry.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zxin.marry.R;
import com.zxin.marry.activity.CityListActivity;
import com.zxin.marry.activity.MessageActivity;
import com.zxin.marry.base.BaseFragment;
import com.zxin.marry.bean.CityForm;
import com.zxin.marry.mvp.presenter.DiscoveryPresenter;
import com.zxin.marry.mvp.view.MainDiscoveryContract;
import com.zxin.marry.util.StringUtils;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.bean.TitleBean;
import com.zxin.root.util.IntegerUtil;
import com.zxin.root.util.SharedPreferencesManager;

/**
 * Created by Administrator on 2018/6/13.
 */

public class DiscoveryFragment extends BaseFragment implements BaseFragment.LazyLoadingListener,MainDiscoveryContract.DiscoveryView{
    private TitleBean titleBean;

    @InjectPresenter
    DiscoveryPresenter presenter;

    public static DiscoveryFragment newInstance(TitleBean titleBean) {
        DiscoveryFragment fragment = new DiscoveryFragment();
        Bundle args = new Bundle();
        args.putParcelable(StringUtils.FRAGMENT_DATA, titleBean);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        titleBean = getArguments().getParcelable(StringUtils.FRAGMENT_DATA);
        presenter.initDatas(this,getChildFragmentManager());
        setLazyLoadingListener(this);
        setViewOnclick(R.id.tv_city_name,R.id.iv_message);
    }

    @Override
    public int setLayout() {
        return R.layout.fragment_monster;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.tv_city_name){
            mContext.startActivity(new Intent(mContext, CityListActivity.class));
        }else if (v.getId()==R.id.iv_message){
            mContext.startActivity(new Intent(mContext, MessageActivity.class));
        }
    }

    @Override
    public void loadLazyDatas(boolean bool) {
        CityForm.City city = SharedPreferencesManager.getMarryCity(CityForm.City.class);
        if (city==null)
            presenter.getCheckedCity("");
        else
            presenter.modifyDiscovery(city);
    }

    @Override
    public LinearLayout getTopLayoutView() {
        return getViewById(R.id.rl_monster_headlayout);
    }

    @Override
    public TextView getCityNameView() {
        return getViewById(R.id.tv_city_name);
    }

    @Override
    public FrameLayout getFrameLayoutView() {
        return getViewById(R.id.rl_monster_headlayout);
    }

    //接受event事件
    @Override
    public void onEventMainThread(Bundle bundle) {
        switch (bundle.getInt(StringUtils.EVENT_ID)) {
            case IntegerUtil.EVENT_ID_11012:
                //地址修改
                CityForm.City city = bundle.getParcelable(StringUtils.EVENT_DATA);
                presenter.modifyDiscovery(city);
                if (!city.getCity().equals("全国"))
                    return;
                if (!SharedPreferencesManager.getMarryCity(CityForm.City.class).getCity().equals(city.getCity())) {
                    CityForm.City localCity = new CityForm.City(city.getCity(), city.getFeastid(), city.getCityid());
                    SharedPreferencesManager.setMarryCity(localCity);
                }
                break;
        }
    }
}
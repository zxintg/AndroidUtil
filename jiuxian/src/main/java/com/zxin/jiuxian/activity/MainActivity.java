package com.zxin.jiuxian.activity;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioGroup;
import com.zxin.jiuxian.R;
import com.zxin.jiuxian.base.BaseActivity;
import com.zxin.jiuxian.mvp.presenter.MainPresenter;
import com.zxin.jiuxian.mvp.view.MainContract;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.zxinlib.view.MyViewPager;

/**
 * Created by Administrator on 2018/8/3.
 */

public class MainActivity extends BaseActivity implements MainContract.MainBannerView {
    @InjectPresenter
    MainPresenter presenter;

    @Override
    public void initData() {
        presenter.initMainDatas(this);
        presenter.getTabMainIcon();
    }

    @Override
    public int setLayout() {
        return R.layout.activity_jiuxian_main;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public MyViewPager getViewPagerView() {
        return getViewById(R.id.vp_jiuxian_pager);
    }

    @Override
    public RadioGroup getRadioGroupView() {
        return getViewById(R.id.rg_jiuxian_bar);
    }

}

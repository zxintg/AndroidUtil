package com.zxin.sources.activity;

import android.view.View;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.sources.R;
import com.zxin.sources.base.BaseActivity;
import com.zxin.sources.mvp.presenter.AndroidBusPresenter;
import com.zxin.sources.mvp.view.AndroidBusContract;
import com.zxin.root.view.CommonCrosswiseBar;
import com.zxin.root.view.RefreshCommonView;

public class AndroidBusActivity extends BaseActivity implements AndroidBusContract.AndroidBusView {
    private CommonCrosswiseBar mTitle;
    @InjectPresenter
    AndroidBusPresenter presenter;

    @Override
    public void initData() {
        initView();
        presenter.initDatas(this);
    }

    private void initView() {
        mTitle = (CommonCrosswiseBar) getViewById(R.id.ccb_androidbus_head);
        mTitle.setOnClickListener(R.id.common_bar_leftBtn, this);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_android_bus;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.common_bar_leftBtn) {
            onBackPressed();
        }
    }

    @Override
    public RefreshCommonView getRecyclerView() {
        return (RefreshCommonView) getViewById(R.id.rcv_androidbus_commonlayout);
    }

}

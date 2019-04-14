package com.zxin.sources.activity;

import android.view.View;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.sources.R;
import com.zxin.sources.base.BaseActivity;
import com.zxin.sources.mvp.presenter.YunShangPresenter;
import com.zxin.sources.mvp.view.YunShangContract;
import com.zxin.root.view.CommonCrosswiseBar;
import com.zxin.root.view.RefreshCommonView;

/**
 * Created by Administrator on 2018/6/5.
 */

public class YunShangActivity extends BaseActivity implements YunShangContract.YunShangView {
    private CommonCrosswiseBar mTitle;
    @InjectPresenter
    YunShangPresenter presenter;

    @Override
    public void initData() {
        initView();
        presenter.initDatas(this);
    }

    private void initView() {
        mTitle = (CommonCrosswiseBar) getViewById(R.id.ccb_yunsahngji_head);
        mTitle.setOnClickListener(R.id.common_bar_leftBtn,this);
    }
    @Override
    public int setLayout() {
        return R.layout.activity_yunsahngji;
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
        return (RefreshCommonView) getViewById(R.id.rcv_yunsahngji_commonlayout);
    }
}

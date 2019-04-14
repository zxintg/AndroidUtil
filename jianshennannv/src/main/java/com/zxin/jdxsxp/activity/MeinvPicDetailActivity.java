package com.zxin.jdxsxp.activity;

import android.view.View;
import com.zxin.jdxsxp.R;
import com.zxin.jdxsxp.base.BaseActivity;
import com.zxin.jdxsxp.mvp.presenter.MeiZiMainPresenter;
import com.zxin.jdxsxp.mvp.view.MeiZiMainContract;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.view.RefreshCommonView;

/**
 * Created by Administrator on 2018/8/29.
 */

public class MeinvPicDetailActivity extends BaseActivity implements MeiZiMainContract.MeinvPicDetailView {
    @InjectPresenter
    MeiZiMainPresenter presenter;

    @Override
    public void initData() {
        setTitleText(R.id.ccb_jdxsxp_title,getIntent().getStringExtra("title"));
        setTitleViewOnclick(R.id.ccb_jdxsxp_title,R.id.common_bar_leftBtn);
        presenter.initMeinvPicDetailDatas(this,getIntent().getStringExtra("album_address"));
    }

    @Override
    public int setLayout() {
        return R.layout.activity_meizuhomedetail;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_leftBtn){
            onBackPressed();
        }
    }

    @Override
    public RefreshCommonView getRefreshCommonView() {
        return getViewById(R.id.rcv_mine_commonlayout);
    }
}

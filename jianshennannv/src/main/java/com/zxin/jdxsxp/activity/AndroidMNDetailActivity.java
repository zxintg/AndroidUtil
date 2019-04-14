package com.zxin.jdxsxp.activity;

import android.view.View;
import android.widget.ImageView;
import com.zxin.jdxsxp.R;
import com.zxin.jdxsxp.base.BaseActivity;
import com.zxin.jdxsxp.mvp.presenter.MeiZiMainPresenter;
import com.zxin.jdxsxp.mvp.view.MeiZiMainContract;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.view.RefreshCommonView;

/**
 * Created by Administrator on 2018/8/29.
 */

public class AndroidMNDetailActivity extends BaseActivity implements MeiZiMainContract.MeiZiDeatilView {
    @InjectPresenter
    MeiZiMainPresenter presenter;

    @Override
    public void initData() {
        setTitleViewOnclick(R.id.ccb_jdxsxp_title,R.id.common_bar_leftBtn);
        setTitleText(R.id.ccb_jdxsxp_title,getIntent().getStringExtra("title"));
        presenter.initMNDetailDatas(this,getIntent().getStringExtra("ID"));
    }

    @Override
    public int setLayout() {
        return R.layout.androidmndetail_activity;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_leftBtn){
            onBackPressed();
        }
    }

    @Override
    public ImageView getImageView() {
        return getViewById(R.id.iv_meinv);
    }

    @Override
    public RefreshCommonView getRefreshCommonView() {
        return getViewById(R.id.rcv_jdxsxp_commonlayout);
    }
}

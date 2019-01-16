package com.zxin.marry.activity;

import android.view.View;

import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.marry.mvp.presenter.HotlePresenter;
import com.zxin.marry.mvp.view.HotleContract;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.zxinlib.view.RefreshCommonView;

/**
 * Created by Administrator on 2018/7/9.
 */

public class DishsListActivity extends BaseActivity implements HotleContract.DishsListView {
    private String hotelid;

    @InjectPresenter
    HotlePresenter presenter;

    @Override
    public void initData() {
        hotelid = getIntent().getStringExtra("hotelid");
        presenter.initHotelMoreDishsDatas(this,hotelid);
        setTitleViewOnclick(R.id.ccb_marray_title, R.id.common_bar_leftBtn);
    }

    @Override
    public int setLayout() {
        return R.layout.ac_dishs_list;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.common_bar_leftBtn) {
            onBackPressed();
        }
    }

    @Override
    public RefreshCommonView getRefreshCommonView() {
        return getViewById(R.id.rcv_comment_commonlayout);
    }
}

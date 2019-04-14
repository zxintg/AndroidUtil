package com.zxin.marry.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.marry.mvp.presenter.HotlePresenter;
import com.zxin.marry.mvp.view.HotleContract;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.view.CommonCrosswiseBar;

/**
 * Created by Administrator on 2018/6/22.
 */

public class BanquetHallDetailsActivity extends BaseActivity implements HotleContract.HallDetailsView {
    private String id;

    @InjectPresenter
    HotlePresenter presenter;

    @Override
    public void initData() {
        id = getIntent().getStringExtra("id");
        presenter.initHallDetailsDatas(this,id);
        setTitleViewOnclick(R.id.ccb_marray_title,R.id.common_bar_leftBtn);
        setViewOnclick(R.id.tv_gift_more,R.id.tv_schedulequery,R.id.tv_appointment);

        presenter.getBanquetHallDetails(id);
    }

    @Override
    public int setLayout() {
        return R.layout.ac_banquet_hall_details;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_leftBtn){
            onBackPressed();
            return;
        }

    }

    @Override
    public CommonCrosswiseBar getCommonCrosswiseBarView() {
        return getViewById(R.id.ccb_marray_title);
    }

    @Override
    public ImageView getIVLogoView() {
        return getViewById(R.id.img_logo);
    }

    @Override
    public TextView getTVOptionfeatureView() {
        return getViewById(R.id.tv_optionfeatureid);
    }

    @Override
    public TextView getTVOptiontableView() {
        return getViewById(R.id.tv_optiontableid);
    }

    @Override
    public TextView getTVBanquetAreaView() {
        return getViewById(R.id.tv_banquet_area);
    }

    @Override
    public TextView getTVBanquetHeightView() {
        return getViewById(R.id.tv_banquet_height);
    }

    @Override
    public TextView getTVColumnSumView() {
        return getViewById(R.id.tv_column_sum);
    }

    @Override
    public TextView getTVStageLongView() {
        return getViewById(R.id.tv_stage_long);
    }

    @Override
    public TextView getTVStageWideView() {
        return getViewById(R.id.tv_stage_wide);
    }

    @Override
    public TextView getTVIntroduceView() {
        return getViewById(R.id.tv_introduce);
    }

    @Override
    public LinearLayout getLLGiftView() {
        return getViewById(R.id.ll_gift);
    }

    @Override
    public RecyclerView getRVGiftView() {
        return getViewById(R.id.rv_gift);
    }

    @Override
    public RecyclerView getRVIconView() {
        return getViewById(R.id.rv_icon);
    }
}

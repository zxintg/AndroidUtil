package com.zxin.marry.activity;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.baidu.location.Poi;
import com.baidu.mapapi.search.poi.PoiAddrInfo;
import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.marry.bean.ShootStategyBean;
import com.zxin.marry.mvp.presenter.ToolsPresenter;
import com.zxin.marry.mvp.view.ToolsContract;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.zxinlib.adapter.SimpleAdapter.SimpleAdapter;
import com.zxin.zxinlib.adapter.SimpleAdapter.TrdViewHolder;
import com.zxin.zxinlib.util.UiUtils;
import com.zxin.zxinlib.view.RefreshCommonView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/15.
 */

public class RegistrationActivity extends BaseActivity implements ToolsContract.ToolsRegistView {
    @InjectPresenter
    ToolsPresenter presenter;

    @Override
    public void initData() {
        presenter.initRegistDatas(this);
        setTitleViewOnclick(R.id.ccb_marray_title,R.id.common_bar_leftBtn,R.id.common_bar_rightBtn);
        setViewOnclick(R.id.ccb_registration_flow);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_registration;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_leftBtn){
            onBackPressed();
        }else if (v.getId()==R.id.ccb_registration_flow){
            //登记流程
            startActivity(new Intent(mContext,MarriedProcessActivity.class));
        }
    }

    @Override
    public RefreshCommonView getRefreshCommonView() {
        return getViewById(R.id.rcv_regist_commonlayout);
    }
}

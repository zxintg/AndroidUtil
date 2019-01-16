package com.zxin.marry.activity;

import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.marry.mvp.presenter.CommonPresenter;
import com.zxin.marry.mvp.view.CommonContract;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.zxinlib.util.IntegerUtil;
import com.zxin.zxinlib.view.CommonCrosswiseBar;
import com.zxin.zxinlib.view.RefreshCommonView;

/**
 * Created by Administrator on 2018/6/25.
 */

public class CityListActivity extends BaseActivity implements CommonContract.CityListView{
    @InjectPresenter
    CommonPresenter presenter;

    @Override
    public void initData() {
        presenter.initCityListDatas(this);
        setTitleViewOnclick(R.id.ccb_marray_title,R.id.common_bar_leftBtn);
        setViewOnclick(R.id.ll_location_city);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_city_list;
    }

    @TargetApi(23)
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == IntegerUtil.PERMISSION_REQUEST_LOCATION){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                presenter.openCitystartLoacl();
            } else {
                showPremissionDialog("使用设备位置信息");
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.common_bar_leftBtn) {
            onBackPressed();
            return;
        }
        presenter.OnClick(v);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.stopLoacl();
    }

    @Override
    public CommonCrosswiseBar getTitleView() {
        return getViewById(R.id.ccb_marray_title);
    }

    @Override
    public RefreshCommonView getRefreshCommonView() {
        return getViewById(R.id.rcv_city_commonlayout);
    }

    @Override
    public TextView getLocationCityView() {
        return getViewById(R.id.tv_location_city);
    }

    @Override
    public TextView getLocationNotifyView() {
        return getViewById(R.id.tv_location_notify);
    }

    @Override
    public RecyclerView getHotCityiew() {
        return getViewById(R.id.hotRecyclerView);
    }
}

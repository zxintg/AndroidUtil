package com.zxin.marry.activity;

import android.support.v4.widget.DrawerLayout;
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
import com.zxin.zxinlib.view.CommonCrosswiseBar;
import com.zxin.zxinlib.view.RefreshCommonView;

/**
 * Created by Administrator on 2018/7/6.
 */

public class HotelListActivity extends BaseActivity implements HotleContract.HotelListView {
    private String hotelId;
    private String type;

    @InjectPresenter
    HotlePresenter presenter;

    @Override
    public void initData() {
        hotelId = getIntent().getStringExtra("id");
        type = getIntent().getStringExtra("type");
        setTitleViewOnclick(R.id.ccb_marray_title,R.id.common_bar_leftBtn);
        presenter.initHotelListDatas(this,hotelId,type);
        presenter.getHoteSearch();
    }

    @Override
    public int setLayout() {
        return R.layout.activity_hotel;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_leftBtn){
            onBackPressed();
        }
    }

    @Override
    public DrawerLayout getDrawerLayoutView() {
        return getViewById(R.id.dl_hotel);
    }

    @Override
    public CommonCrosswiseBar getCommonCrosswiseBarView() {
        return getViewById(R.id.ccb_marray_title);
    }

    @Override
    public LinearLayout getLLOrderDefaultView() {
        return getViewById(R.id.ll_order_default);
    }

    @Override
    public TextView getTVOrderDefaultView() {
        return getViewById(R.id.tv_order_default);
    }

    @Override
    public View getOrderDefaultView() {
        return getViewById(R.id.view_order_default);
    }

    @Override
    public LinearLayout getLLOrderPriceView() {
        return getViewById(R.id.ll_order_price);
    }

    @Override
    public ImageView getIVOrderPriceView() {
        return getViewById(R.id.iv_order_price);
    }

    @Override
    public TextView getTVOrderPriceView() {
        return getViewById(R.id.tv_order_price);
    }

    @Override
    public View getOrderPriceView() {
        return getViewById(R.id.view_order_price);
    }

    @Override
    public LinearLayout getLLOrderDeskView() {
        return getViewById(R.id.ll_order_desk);
    }

    @Override
    public ImageView getIVOrderDeskView() {
        return getViewById(R.id.iv_order_desk);
    }

    @Override
    public TextView getTVOrderDeskView() {
        return getViewById(R.id.tv_order_desk);
    }

    @Override
    public View getOrderDeskView() {
        return getViewById(R.id.view_order_desk);
    }

    @Override
    public LinearLayout getLLOrderChooseView() {
        return getViewById(R.id.ll_order_choose);
    }

    @Override
    public TextView getTVOrderChooseView() {
        return getViewById(R.id.tv_order_choose);
    }

    @Override
    public View getOrderChooseView() {
        return getViewById(R.id.view_order_choose);
    }

    @Override
    public RefreshCommonView getRefreshCommonView() {
        return getViewById(R.id.rcv_hotel_commonlayout);
    }

    @Override
    public LinearLayout getLLRightView() {
        return getViewById(R.id.ll_hotel_right);
    }

    @Override
    public RecyclerView getRVRightView() {
        return getViewById(R.id.rv_right);
    }

    @Override
    public TextView getTVChooseResertView() {
        return getViewById(R.id.tv_choose_resert);
    }

    @Override
    public TextView getTVChooseConfirmView() {
        return getViewById(R.id.tv_choose_confirm);
    }
}

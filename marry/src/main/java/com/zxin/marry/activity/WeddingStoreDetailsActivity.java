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

public class WeddingStoreDetailsActivity extends BaseActivity implements HotleContract.StoreDetailsView {

    private String hotelId;

    @InjectPresenter
    HotlePresenter presenter;

    @Override
    public void initData() {
        hotelId = getIntent().getStringExtra("hotelid");
        presenter.initStoreDetailsDatas(this,hotelId);
        setTitleViewOnclick(R.id.ccb_marray_title, R.id.common_bar_leftBtn);
        presenter.getWeddingDetail(hotelId);
    }

    @Override
    public int setLayout() {
        return R.layout.ac_hotel_details;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.common_bar_leftBtn) {
            onBackPressed();
        }
    }

    @Override
    public CommonCrosswiseBar getCommonCrosswiseBarView() {
        return getViewById(R.id.ccb_marray_title);
    }

    @Override
    public ImageView getIVCoverimageView() {
        return getViewById(R.id.iv_coverimage);
    }

    @Override
    public TextView getTVHotelNameView() {
        return getViewById(R.id.tv_hotel_name);
    }

    @Override
    public TextView getTVOptionPriceidView() {
        return getViewById(R.id.tv_optionpriceid);
    }

    @Override
    public TextView getTVShopAddressView() {
        return getViewById(R.id.tv_shop_address);
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
    public TextView getTVServiceChargeView() {
        return getViewById(R.id.tv_servicecharge);
    }

    @Override
    public TextView getTVParkisFreeView() {
        return getViewById(R.id.tv_parkisfree);
    }

    @Override
    public TextView getTVLawnView() {
        return getViewById(R.id.tv_lawn);
    }

    @Override
    public TextView getTVCorkageFeeView() {
        return getViewById(R.id.tv_corkagefee);
    }

    @Override
    public TextView getTVSlottingFeeView() {
        return getViewById(R.id.tv_slottingfee);

    }

    @Override
    public TextView getTVWeddingRoomView() {
        return getViewById(R.id.tv_weddingroom);
    }

    @Override
    public LinearLayout getLLGoodsView() {
        return getViewById(R.id.ll_goods);
    }

    @Override
    public TextView getTVGoodsCountView() {
        return getViewById(R.id.tv_banquet_count);
    }

    @Override
    public RecyclerView getRVGoodsView() {
        return getViewById(R.id.lv_banquet);
    }

    @Override
    public TextView getTVGoodsMoreView() {
        return getViewById(R.id.tv_more_banquet);
    }

    @Override
    public LinearLayout getLLDishesView() {
        return getViewById(R.id.ll_dishes);
    }

    @Override
    public TextView getTVDishesCountView() {
        return getViewById(R.id.tv_cookbook_count);
    }

    @Override
    public RecyclerView getRVDishesView() {
        return getViewById(R.id.lv_dishes);
    }

    @Override
    public TextView getTVDishesMoreView() {
        return getViewById(R.id.tv_more_dishes);
    }

    @Override
    public LinearLayout getLLCaseView() {
        return getViewById(R.id.ll_case);
    }

    @Override
    public TextView getTVCaseCountView() {
        return getViewById(R.id.tv_casenum);
    }

    @Override
    public RecyclerView getRVCaseView() {
        return getViewById(R.id.lv_cas_list);
    }

    @Override
    public TextView getTVCaseMoreView() {
        return getViewById(R.id.tv_casemore);
    }

    @Override
    public TextView getTVIntroduceView() {
        return getViewById(R.id.tv_introduce);
    }

    @Override
    public RecyclerView getRVIconView() {
        return getViewById(R.id.lv_icon);
    }
}

package com.zxin.marry.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.marry.mvp.presenter.ProductPresenter;
import com.zxin.marry.mvp.view.ProductContract;
import com.zxin.network.mvp.inject.InjectPresenter;

/**
 * Created by Administrator on 2018/6/22.
 */

public class ShopCaseDetailsActivity extends BaseActivity implements ProductContract.ShopCaseView {

    @InjectPresenter
    ProductPresenter presenter;

    private String caseId;

    @Override
    public void initData() {
        caseId = getIntent().getStringExtra("case_id");
        setTitleViewOnclick(R.id.ccb_marray_title,R.id.common_bar_leftBtn);
        setViewOnclick(R.id.ll_hotel);
        presenter.initShopCaseDetailsDatas(this,caseId);
        presenter.getShopCaseDetails(caseId);
    }

    @Override
    public int setLayout() {
        return R.layout.ac_shop_case_details;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_leftBtn){
            onBackPressed();
            return;
        }
        presenter.OnClick(v);
    }

    @Override
    public TextView getTitleView() {
        return getViewById(R.id.tv_case_title);
    }

    @Override
    public SimpleDraweeView getStoreLabelView() {
        return getViewById(R.id.store_label);
    }

    @Override
    public TextView getTVStoreNameView() {
        return getViewById(R.id.tv_store_name);
    }

    @Override
    public ImageView getImgCaseHeaderView() {
        return getViewById(R.id.img_case_header);
    }

    @Override
    public LinearLayout getLLAssociatedView() {
        return getViewById(R.id.ll_associated);
    }

    @Override
    public TextView getTVPriceView() {
        return getViewById(R.id.tv_price);
    }

    @Override
    public LinearLayout getLLHotelView() {
        return getViewById(R.id.ll_hotel);
    }

    @Override
    public TextView getTVHotelNameView() {
        return getViewById(R.id.tv_hotelname);
    }

    @Override
    public TextView getTVDescribeView() {
        return getViewById(R.id.tv_case_descr);
    }

    @Override
    public RecyclerView getRecyclerView() {
        return getViewById(R.id.rv_case_content);
    }

    @Override
    public TextView getTVCollectionView() {
        return getViewById(R.id.tv_collection);
    }

    @Override
    public TextView getTVConsultingView() {
        return getViewById(R.id.tv_consulting);
    }
}

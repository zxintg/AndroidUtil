package com.zxin.marry.activity;

import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.marry.mvp.presenter.ProductPresenter;
import com.zxin.marry.mvp.view.ProductContract;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.view.CommonCrosswiseBar;

/**
 * Created by Administrator on 2018/6/22.
 */

public class GoodsDetailsActivity extends BaseActivity implements ProductContract.GoodsDetailView {
    @InjectPresenter
    ProductPresenter presenter;

    private String goodsId;

    @Override
    public void initData() {
        goodsId = getIntent().getStringExtra("goods_id");
        presenter.initGoodsDetailsDatas(this,goodsId);
        setTitleViewOnclick(R.id.ccb_marray_title,R.id.common_bar_leftBtn);
        setViewOnclick(R.id.tv_buying,R.id.tv_input_cart,R.id.ll_store,R.id.tv_collection);
        presenter.getGoodsDetails(goodsId);
    }

    @Override
    public int setLayout() {
        return R.layout.ac_studio_details;
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
    public AppBarLayout getAppBarLayoutView() {
        return getViewById(R.id.appBarLayout);
    }

    @Override
    public Toolbar getToolbarView() {
        return getViewById(R.id.appbar_layout_toolbar);
    }

    @Override
    public CommonCrosswiseBar getCommonCrosswiseBarView() {
        return getViewById(R.id.ccb_marray_title);
    }

    @Override
    public ConvenientBanner getConvenientBannerView() {
        return getViewById(R.id.convenientBanner);
    }

    @Override
    public TextView getNameView() {
        return getViewById(R.id.tv_name);
    }

    @Override
    public LinearLayout getLLPriceView() {
        return getViewById(R.id.ll_price);
    }

    @Override
    public TextView getTVNowPriceView() {
        return getViewById(R.id.tv_now_price);
    }

    @Override
    public TextView getTVMarketPriceView() {
        return getViewById(R.id.tv_marketprice);
    }

    @Override
    public LinearLayout getLLStoreView() {
        return getViewById(R.id.ll_store);
    }

    @Override
    public ImageView getStoreImgView() {
        return getViewById(R.id.img_store_img);
    }

    @Override
    public TextView getStoreNameView() {
        return getViewById(R.id.tv_store_name);
    }

    @Override
    public LinearLayout getLLVirtualIndateView() {
        return getViewById(R.id.ll_virtual_indatelayout);
    }

    @Override
    public TextView getTVVirtualIndateView() {
        return getViewById(R.id.tv_virtual_indate);
    }

    @Override
    public LinearLayout getLLGoodsDescribeView() {
        return getViewById(R.id.tv_goods_describelayout);
    }

    @Override
    public TextView getTVGoodsDescribeView() {
        return getViewById(R.id.tv_goods_describe);
    }

    @Override
    public TextView getTVGoodsJingleView() {
        return getViewById(R.id.tv_goods_jingle);
    }

    @Override
    public TextView getTVYouKuView() {
        return getViewById(R.id.tv_youku);
    }

    @Override
    public TextView getTVDetailDescribeView() {
        return getViewById(R.id.tv_detail_describe);
    }

    @Override
    public RecyclerView getRecyclerView() {
        return getViewById(R.id.recyclerView);
    }

    @Override
    public LinearLayout getLLBottomView() {
        return getViewById(R.id.ll_bottom);
    }

    @Override
    public TextView getTVCollectionView() {
        return getViewById(R.id.tv_collection);
    }

    @Override
    public TextView getTVConsultingView() {
        return getViewById(R.id.tv_consulting);
    }

    @Override
    public TextView getTVInputCartView() {
        return getViewById(R.id.tv_input_cart);
    }

    @Override
    public TextView getTVBuyingView() {
        return getViewById(R.id.tv_buying);
    }
}

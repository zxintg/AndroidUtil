package com.zxin.marry.activity;

import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.marry.mvp.presenter.ShopPresenter;
import com.zxin.marry.mvp.view.ShopContract;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.zxinlib.view.CommonCrosswiseBar;

/**
 * Created by Administrator on 2018/6/22.
 */

public class ShopDetailsActivity extends BaseActivity implements ShopContract.MainTopicView {
    @InjectPresenter
    ShopPresenter presenter;

    private  String store_id;

    @Override
    public void initData() {
        store_id = getIntent().getStringExtra("store_id");
        presenter.initShopDetailsDatas(this,store_id);
        presenter.getShopDetail(store_id);
        setTitleViewOnclick(R.id.ccb_marray_title,R.id.common_bar_leftBtn,R.id.common_bar_rightBtn);
        setViewOnclick(R.id.tv_gift,R.id.tv_goods_more,R.id.tv_cases_more,R.id.tv_comments_more,R.id.ll_comments,R.id.tv_consulting);
    }

    @Override
    public int setLayout() {
        return R.layout.ac_shop_details;
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
    public CommonCrosswiseBar getCommonCrosswiseBarView() {
        return getViewById(R.id.ccb_marray_title);
    }

    @Override
    public AppBarLayout getAppBarLayoutView() {
        return getViewById(R.id.appBarLayout);
    }

    @Override
    public ImageView getIMGHeaderView() {
        return getViewById(R.id.img_header_bg);
    }

    @Override
    public TextView getTVShopNameView() {
        return getViewById(R.id.tv_shop_name);
    }

    @Override
    public ImageView getIVShopLevelView() {
        return getViewById(R.id.img_shop_level);
    }

    @Override
    public TextView getTVScNameView() {
        return getViewById(R.id.tv_sc_name);
    }

    @Override
    public TextView getTVStoreCollectView() {
        return getViewById(R.id.tv_store_collect);
    }

    @Override
    public ImageView getIMGStoreView() {
        return getViewById(R.id.img_store_img);
    }

    @Override
    public Toolbar getToolbarView() {
        return getViewById(R.id.appbar_layout_toolbar);
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
    public LinearLayout getLLSpecialView() {
        return getViewById(R.id.ll_special);
    }

    @Override
    public LinearLayout getLLEventView() {
        return getViewById(R.id.ll_event);
    }

    @Override
    public RecyclerView getRVEventListView() {
        return getViewById(R.id.rv_event);
    }

    @Override
    public LinearLayout getLLAddressView() {
        return getViewById(R.id.ll_address);
    }

    @Override
    public TextView getTVAddressView() {
        return getViewById(R.id.tv_shop_address);
    }

    @Override
    public LinearLayout getLLGoodsView() {
        return getViewById(R.id.ll_goods);
    }

    @Override
    public TextView getTVGoodsCountView() {
        return getViewById(R.id.tv_goods_count);
    }

    @Override
    public RecyclerView getRVGoodsView() {
        return getViewById(R.id.rv_goods);
    }

    @Override
    public TextView getTVGoodsMoreView() {
        return getViewById(R.id.tv_goods_more);
    }

    @Override
    public LinearLayout getLLCasesView() {
        return getViewById(R.id.ll_case);
    }

    @Override
    public TextView getTVCaseCountView() {
        return getViewById(R.id.tv_cases_count);
    }

    @Override
    public RecyclerView getRVCaseView() {
        return getViewById(R.id.rv_cases);
    }

    @Override
    public TextView getTVCaseMoreView() {
        return getViewById(R.id.tv_cases_more);
    }

    @Override
    public LinearLayout getLLCommentsView() {
        return getViewById(R.id.ll_comments);
    }

    @Override
    public TextView getTVCommentsCountView() {
        return getViewById(R.id.tv_comments_count);
    }

    @Override
    public RecyclerView getRVCommentsView() {
        return getViewById(R.id.rv_comments);
    }

    @Override
    public TextView getTVCommentsMoreView() {
        return getViewById(R.id.tv_comments_more);
    }

    @Override
    public TextView getTVCommentView() {
        return getViewById(R.id.tv_comment);
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

package com.zxin.jiuxian.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zxin.jiuxian.R;
import com.zxin.jiuxian.base.BaseFragment;
import com.zxin.jiuxian.mvp.presenter.ProductPresenter;
import com.zxin.jiuxian.mvp.view.ProductContract;
import com.zxin.jiuxian.util.StringUtils;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.zxinlib.bean.TitleBean;

/**
 * Created by Administrator on 2018/8/17.
 */

public class ProductGoodsFragment extends BaseFragment implements BaseFragment.LazyLoadingListener,ProductContract.ProductGoodsView {
    @InjectPresenter
    ProductPresenter presenter;
    
    private TitleBean titleBean;

    public static ProductGoodsFragment newInstance(TitleBean titleBean) {
        ProductGoodsFragment fragment = new ProductGoodsFragment();
        Bundle args = new Bundle();
        args.putParcelable(StringUtils.FRAGMENT_DATA, titleBean);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        titleBean = getArguments().getParcelable(StringUtils.FRAGMENT_DATA);
        presenter.initProductGoodsDatas(this);
        setLazyLoadingListener(this);
    }

    @Override
    public int setLayout() {
        return R.layout.fragment_product;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void loadLazyDatas(boolean bool) {
        presenter.proDetail(titleBean.id2);
    }

    @Override
    public ViewPager product_ad_vp() {
        return getViewById(R.id.product_ad_vp);
    }

    @Override
    public TextView product_pager_count() {
        return getViewById(R.id.product_pager_count);
    }

    @Override
    public RelativeLayout ijk_product_player_view() {
        return getViewById(R.id.ijk_product_player_view);
    }

    @Override
    public TextView product_detail_name() {
        return getViewById(R.id.product_detail_name);
    }

    @Override
    public TextView product_detail_adcue() {
        return getViewById(R.id.product_detail_adcue);
    }

    @Override
    public TextView product_detail_price() {
        return getViewById(R.id.product_detail_price);
    }

    @Override
    public ImageView product_club_front_img() {
        return getViewById(R.id.product_club_front_img);
    }

    @Override
    public LinearLayout ll_detail_price() {
        return getViewById(R.id.ll_detail_price);
    }

    @Override
    public TextView product_detail_club_price() {
        return getViewById(R.id.product_detail_club_price);
    }

    @Override
    public ImageView product_detail_club_img() {
        return getViewById(R.id.product_detail_club_img);
    }

    @Override
    public TextView product_detail_original_price_info() {
        return getViewById(R.id.product_detail_original_price_info);
    }

    @Override
    public TextView product_detail_original_price() {
        return getViewById(R.id.product_detail_original_price);
    }

    @Override
    public LinearLayout product_detail_club_layout() {
        return getViewById(R.id.product_detail_club_layout);
    }

    @Override
    public Button btn_go_seckill() {
        return getViewById(R.id.btn_go_seckill);
    }

    @Override
    public LinearLayout ll_detail_spclLabel() {
        return getViewById(R.id.ll_detail_spclLabel);
    }

    @Override
    public TextView product_detail_spclLabel() {
        return getViewById(R.id.product_detail_spclLabel);
    }

    @Override
    public TextView phone_only_price_preferential_price() {
        return getViewById(R.id.phone_only_price_preferential_price);
    }

    @Override
    public LinearLayout layout_seckill() {
        return getViewById(R.id.layout_seckill);
    }

    @Override
    public TextView product_seckill_adcue() {
        return getViewById(R.id.product_seckill_adcue);
    }

    @Override
    public TextView product_seckill_price() {
        return getViewById(R.id.product_seckill_price);
    }

    @Override
    public TextView product_seckill_original_price() {
        return getViewById(R.id.product_seckill_original_price);
    }

    @Override
    public Button btn_go_phone_only() {
        return getViewById(R.id.btn_go_phone_only);
    }

    @Override
    public TextView product_seckill_spclLabel() {
        return getViewById(R.id.product_seckill_spclLabel);
    }

    @Override
    public TextView seckill_price_preferential_price() {
        return getViewById(R.id.seckill_price_preferential_price);
    }

    @Override
    public TextView text_seckill_finish() {
        return getViewById(R.id.text_seckill_finish);
    }

    @Override
    public ImageView product_detail_check() {
        return getViewById(R.id.product_detail_check);
    }

    @Override
    public ImageView product_detail_check_tishi() {
        return getViewById(R.id.product_detail_check_tishi);
    }

    @Override
    public LinearLayout ll_coupon_layout() {
        return getViewById(R.id.ll_coupon_layout);
    }

    @Override
    public TextView ll_coupon_text() {
        return getViewById(R.id.ll_coupon_text);
    }

    @Override
    public TextView ll_club_bug_tip() {
        return getViewById(R.id.ll_club_bug_tip);
    }

    @Override
    public LinearLayout ll_privilegelayout() {
        return getViewById(R.id.ll_privilegelayout);
    }

    @Override
    public TextView product_discount_tv() {
        return getViewById(R.id.product_discount_tv);
    }

    @Override
    public LinearLayout product_discount_vell() {
        return getViewById(R.id.product_discount_vell);
    }

    @Override
    public LinearLayout ll_presentlayout() {
        return getViewById(R.id.ll_presentlayout);
    }

    @Override
    public LinearLayout product_present_ll() {
        return getViewById(R.id.product_present_ll);
    }

    @Override
    public LinearLayout gold_coin_layout() {
        return getViewById(R.id.gold_coin_layout);
    }

    @Override
    public TextView tv_gold_coin_count() {
        return getViewById(R.id.tv_gold_coin_count);
    }

    @Override
    public LinearLayout ll_addresslayout() {
        return getViewById(R.id.ll_addresslayout);
    }

    @Override
    public TextView product_detail_address() {
        return getViewById(R.id.product_detail_address);
    }

    @Override
    public TextView product_detail_hasproduct() {
        return getViewById(R.id.product_detail_hasproduct);
    }

    @Override
    public TextView product_detail_arrtime() {
        return getViewById(R.id.product_detail_arrtime);
    }

    @Override
    public LinearLayout product_detail_postage_info() {
        return getViewById(R.id.product_detail_postage_info);
    }

    @Override
    public TextView product_detail_postage() {
        return getViewById(R.id.product_detail_postage);
    }

    @Override
    public LinearLayout product_detail_tips_info() {
        return getViewById(R.id.product_detail_tips_info);
    }

    @Override
    public LinearLayout product_detail_tips() {
        return getViewById(R.id.product_detail_tips);
    }

    @Override
    public LinearLayout product_promise() {
        return getViewById(R.id.product_promise);
    }

    @Override
    public LinearLayout product_comments_parent() {
        return getViewById(R.id.product_comments_parent);
    }

    @Override
    public LinearLayout product_comments_rl() {
        return getViewById(R.id.product_comments_rl);
    }

    @Override
    public TextView onepage_comments_tv() {
        return getViewById(R.id.onepage_comments_tv);
    }

    @Override
    public TextView product_detail_count() {
        return getViewById(R.id.product_detail_count);
    }

    @Override
    public TextView product_detail_percenttip() {
        return getViewById(R.id.product_detail_percenttip);
    }

    @Override
    public TextView product_detail_percent() {
        return getViewById(R.id.product_detail_percent);
    }

    @Override
    public LinearLayout product_comments_ll() {
        return getViewById(R.id.product_comments_ll);
    }

    @Override
    public TextView text_no_comment() {
        return getViewById(R.id.text_no_comment);
    }

    @Override
    public LinearLayout product_brand_rl() {
        return getViewById(R.id.product_brand_rl);
    }

    @Override
    public ImageView product_brand_iv() {
        return getViewById(R.id.product_brand_iv);
    }

    @Override
    public TextView product_brand_name() {
        return getViewById(R.id.product_brand_name);
    }

    @Override
    public TextView product_brand_address() {
        return getViewById(R.id.product_brand_address);
    }

    @Override
    public ImageView product_brand_selfsupport() {
        return getViewById(R.id.product_brand_selfsupport);
    }

    @Override
    public TextView product_brand_info() {
        return getViewById(R.id.product_brand_info);
    }

    @Override
    public ImageView onepage_brand_point() {
        return getViewById(R.id.onepage_brand_point);
    }

    @Override
    public LinearLayout recommend_info() {
        return getViewById(R.id.recommend_info);
    }

    @Override
    public ViewPager product_recommend() {
        return getViewById(R.id.product_recommend);
    }

    @Override
    public RadioGroup recommend_page() {
        return getViewById(R.id.recommend_page);
    }

    @Override
    public ImageButton mGoTopImageButton() {
        return getViewById(R.id.mGoTopImageButton);
    }
}

package com.zxin.jiuxian.mvp.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zxin.jiuxian.R;
import com.zxin.jiuxian.activity.ProductDetailActivity;
import com.zxin.jiuxian.adapter.BannerPagerAdapter;
import com.zxin.jiuxian.bean.ProductDetailResult;
import com.zxin.jiuxian.bean.ProductListInfoResult;
import com.zxin.jiuxian.mvp.presenter.ProductPresenter;
import com.zxin.jiuxian.util.JiuXianUiUtil;
import com.zxin.jiuxian.util.StringUtils;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.network.mvp.view.IBaseView;
import com.zxin.root.adapter.simple.SimpleAdapter;
import com.zxin.root.adapter.simple.TrdViewHolder;
import com.zxin.root.util.ImageUtil;
import com.zxin.root.util.UiUtils;
import com.zxin.root.view.RefreshCommonView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/24.
 */

public class ProductContract implements IBaseView {
    private Context mContext;


    @Override
    public void setParameter(Object... parameter) {
        isTopTopic = (boolean) parameter[0];
        categoryId = (String) parameter[1];
        startPrice = (String) parameter[2];
        endPrice = (String) parameter[3];
        attrsId = (String) parameter[4];
    }

    private List<ProductListInfoResult.ProductInfo> productInfoList = new ArrayList<>();
    private SimpleAdapter productAdapter;
    private String startPrice="0", endPrice, orderBy="", attrsId, keyword="";
    private String categoryId;
    private boolean isTopTopic;

    @Override
    public void initDatas() {
        //iProductListView.getGoToView().setVisibility(View.GONE);
        productInfoList.clear();
        productAdapter = new SimpleAdapter<ProductListInfoResult.ProductInfo>(mContext, productInfoList, R.layout.item_goods_grid) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final ProductListInfoResult.ProductInfo data) {
                holder.setText(R.id.mGoodsNameTV, data.proName)
                        .setText(R.id.mGoodsAdvTv, data.shopName)
                        .setText(R.id.mGoodsPriceTV, StringUtils.formatPriceA(data.proPrice))
                        .setText(R.id.mClubPriceOne, StringUtils.formatPriceA(data.jxPrice))
                        .setText(R.id.mGoodsEvalu, data.commentPercent+ UiUtils.getString(R.string.comments_good))
                        .setText(R.id.mGoodsCountTv, data.evaluationNumber+ UiUtils.getString(R.string.people_comment))
                        .setVisible(R.id.text_whp_1, !data.whetherHasProduct)
                        .setVisible(R.id.mPlayImgLeft, data.supportVideo)
                        .setVisible(R.id.mClubPriceOne, data.jxPrice > 0)
                        .setVisible(R.id.mGoodsAdvTv,data.storeDetail.code == 1)
                        .setVisible(R.id.imageJiuxianOwnOne,"1".equals(data.isOwn)||"3".equals(data.isOwn))
                        .setVisible(R.id.imageAuthenticity,!("1".equals(data.isOwn)||"3".equals(data.isOwn)))
                ;
                holder.<TextView>getView(R.id.mClubPriceOne).getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                RecyclerView recyclerView = holder.getView(R.id.rv_shop_labs);
                recyclerView.setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.HORIZONTAL));
                recyclerView.setAdapter(new SimpleAdapter<ProductListInfoResult.ActList>(mContext,data.activityList,R.layout.item_lab_goods) {
                    @Override
                    protected void onBindViewHolder(TrdViewHolder holder, ProductListInfoResult.ActList data) {
                        holder.setText(R.id.tv_lab_name,data.actName)
                                .setBackgroundDrawable(R.id.tv_lab_name, JiuXianUiUtil.getRadiusColor(data.actColor));
                    }
                });
                ImageUtil.loadImageViewLoding(mContext, data.bigImage, holder.<ImageView>getView(R.id.mGoodsImg), R.mipmap.default_iamge, R.mipmap.default_iamge);
                ImageUtil.loadImageView(mContext,"1".equals(data.isOwn)?R.drawable.icon_jiuxian_own:R.drawable.icon_jiuxian_changzhiying,holder.<ImageView>getView(R.id.imageJiuxianOwnOne));
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext,ProductDetailActivity.class);
                        intent.putExtra("proId",String.valueOf(data.proId));
                        mContext.startActivity(intent);
                    }
                });
            }
        };
        iProductListView.getRefreshCommonView().setRecyclerViewAdapter(productAdapter);
        iProductListView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {


            @Override
            public void startRefresh() {
                pageNum = 1;
                productInfoList.clear();
                presenter.searchProduct(pageNum, startPrice, endPrice, orderBy, categoryId, attrsId, keyword, isTopTopic);
            }

            @Override
            public void startLoadMore() {
                pageNum++;
                presenter.searchProduct(pageNum, startPrice, endPrice, orderBy, categoryId, attrsId, keyword, isTopTopic);
            }
        });
        iProductListView.getGoToView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iProductListView.getRefreshCommonView().scrollToPosition(0);
                //iProductListView.getGoToView().setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void loadDatas() {

    }

    private int pageNum = 1;
    @Override
    public void onResultSuccess(Object bean) {
        iProductListView.getRefreshCommonView().finishRefresh();
        iProductListView.getRefreshCommonView().finishLoadMore();
        if (bean == null)
            return;
        ProductListInfoResult infoResult = (ProductListInfoResult)bean;
        productInfoList.addAll(infoResult.resultList);
        if (productInfoList == null || productInfoList.isEmpty()) {
            productInfoList.clear();
            iProductListView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iProductListView.getRefreshCommonView().setIsEmpty(false);
            iProductListView.getRefreshCommonView().setIsLoadMore(infoResult.pageCount>pageNum);
        }
        productAdapter.notifyDataSetChanged();

    }

    @Override
    public void onAddResult(boolean bool) {

    }

    @Override
    public void onUpdateResult(boolean bool) {

    }

    @Override
    public void onDeleteResult(boolean bool) {

    }

    @Override
    public void onComplete() {

    }

    @Override
    public void setContext(Context context) {
        this.mContext = context;
    }

    private ProductPresenter presenter;

    @Override
    public void setP(BasePresenter... basePresenter) {
        presenter = (ProductPresenter) basePresenter[0];
    }

    @Override
    public void OnClick(View v) {

    }

    private ProductListView iProductListView;

    public void setProductListView(ProductListView iProductListView) {
        this.iProductListView = iProductListView;
    }

    public interface ProductListView {
        RefreshCommonView getRefreshCommonView();
        ImageButton getGoToView();
    }

    private ProductGoodsView iProductGoodsView;

    public void setProductGoodsView(ProductGoodsView iProductGoodsView) {
        this.iProductGoodsView = iProductGoodsView;
    }

    public interface ProductGoodsView {
        ViewPager product_ad_vp();
        TextView product_pager_count();
        RelativeLayout ijk_product_player_view();
        TextView product_detail_name();
        TextView product_detail_adcue();
        TextView product_detail_price();
        ImageView product_club_front_img();
        LinearLayout ll_detail_price();
        TextView product_detail_club_price();
        ImageView product_detail_club_img();
        TextView product_detail_original_price_info();
        TextView product_detail_original_price();
        LinearLayout product_detail_club_layout();
        Button btn_go_seckill();
        LinearLayout ll_detail_spclLabel();
        TextView product_detail_spclLabel();
        TextView phone_only_price_preferential_price();
        LinearLayout layout_seckill();
        TextView product_seckill_adcue();
        TextView product_seckill_price();
        TextView product_seckill_original_price();
        Button btn_go_phone_only();
        TextView product_seckill_spclLabel();
        TextView seckill_price_preferential_price();
        TextView text_seckill_finish();
        ImageView product_detail_check();
        ImageView product_detail_check_tishi();
        LinearLayout ll_coupon_layout();
        TextView ll_coupon_text();
        TextView ll_club_bug_tip();
        LinearLayout ll_privilegelayout();
        TextView product_discount_tv();
        LinearLayout product_discount_vell();
        LinearLayout ll_presentlayout();
        LinearLayout product_present_ll();
        LinearLayout gold_coin_layout();
        TextView tv_gold_coin_count();
        LinearLayout ll_addresslayout();
        TextView product_detail_address();
        TextView product_detail_hasproduct();
        TextView product_detail_arrtime();
        LinearLayout product_detail_postage_info();
        TextView product_detail_postage();
        LinearLayout product_detail_tips_info();
        LinearLayout product_detail_tips();
        LinearLayout product_promise();
        LinearLayout product_comments_parent();
        LinearLayout product_comments_rl();
        TextView onepage_comments_tv();
        TextView product_detail_count();
        TextView product_detail_percenttip();
        TextView product_detail_percent();
        LinearLayout product_comments_ll();
        TextView text_no_comment();
        LinearLayout product_brand_rl();
        ImageView product_brand_iv();
        TextView product_brand_name();
        TextView product_brand_address();
        ImageView product_brand_selfsupport();
        TextView product_brand_info();
        ImageView onepage_brand_point();
        LinearLayout recommend_info();
        ViewPager product_recommend();
        RadioGroup recommend_page();
        ImageButton mGoTopImageButton();
    }

    private BannerPagerAdapter pagerAdapter;
    private List<ProductDetailResult.ImageItem> imageList = new ArrayList<>();
    public void initProductGoodsDatas(){
        pagerAdapter = new BannerPagerAdapter(mContext,imageList);
        iProductGoodsView.product_ad_vp().setAdapter(pagerAdapter);
    }

    public void onResultProductGoodsSuccess(Object bean){
        if (bean==null)
            return;
        ProductDetailResult productDetail = (ProductDetailResult)bean;

        imageList.clear();
        imageList.addAll(productDetail.imageList);
        pagerAdapter.notifyDataSetChanged();
        iProductGoodsView.product_pager_count().setText("1/"+imageList.size());

        iProductGoodsView.product_ad_vp().setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                iProductGoodsView.product_pager_count().setText((position+1)+"/"+imageList.size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        iProductGoodsView.product_detail_name().setText(productDetail.proName);

        //iProductGoodsView.loadImageViewLoding(mContext, data.bigImage, holder.<ImageView>getView(R.id.mGoodsImg), R.mipmap.default_iamge, R.mipmap.default_iamge);
    }


}

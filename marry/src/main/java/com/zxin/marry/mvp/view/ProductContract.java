package com.zxin.marry.mvp.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zxin.marry.R;
import com.zxin.marry.activity.CheckInformationActivity;
import com.zxin.marry.activity.ProductDetailActivity;
import com.zxin.marry.activity.ShopDetailsActivity;
import com.zxin.marry.activity.WeddingStoreDetailsActivity;
import com.zxin.marry.bean.CaseDetailsBean;
import com.zxin.marry.bean.CollectionBean;
import com.zxin.marry.bean.GoodsDetailsBean;
import com.zxin.marry.bean.MarryProductForm;
import com.zxin.marry.bean.RecommendForm;
import com.zxin.marry.bean.ShopClassBean;
import com.zxin.marry.mvp.presenter.ProductPresenter;
import com.zxin.marry.util.StringUtils;
import com.zxin.marry.view.BannerHolderView;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.network.mvp.view.IBaseView;
import com.zxin.root.adapter.simple.SimpleAdapter;
import com.zxin.root.adapter.simple.TrdViewHolder;
import com.zxin.root.bean.TitleBean;
import com.zxin.root.util.ImageUtil;
import com.zxin.root.util.ToastUtil;
import com.zxin.root.util.UiUtils;
import com.zxin.root.view.CommonCrosswiseBar;
import com.zxin.root.view.RefreshCommonView;

import java.util.ArrayList;
import java.util.List;

import static com.zxin.basemodel.R.style.dialog;

/**
 * Created by Administrator on 2018/5/24.
 */

public class ProductContract implements IBaseView {
    private Context mContext;
    private TitleBean titleBean;
    private SimpleAdapter productListAdapter;
    private List<ShopClassBean.TaoBaoProduct> productList = new ArrayList<>();

    @Override
    public void setParameter(Object... parameter) {
        titleBean = (TitleBean) parameter[0];
    }

    private int pageNum = 1;

    @Override
    public void initDatas() {
        productListAdapter = new SimpleAdapter<ShopClassBean.TaoBaoProduct>(mContext, productList, R.layout.item_square_marry) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final ShopClassBean.TaoBaoProduct product) {
                SpannableString localSpannableString = new SpannableString(" " + product.getTitle());
                localSpannableString.setSpan(UiUtils.getDrawable("C".equals(product.getShop_type()) ? R.drawable.tao : R.drawable.mall), 0, 1, 33);
                holder.setText(R.id.tv_title, localSpannableString)
                        .setText(R.id.tv_price, "￥" + product.getPromotion_price())
                        .setText(R.id.tv_primary_price, "￥" + product.getPrice())
                        .setVisible(R.id.free_post, !"buyer".equals(product.getFreight_payer()));
                TextView mTvPrimaryPrice = holder.getView(R.id.tv_primary_price);
                mTvPrimaryPrice.getPaint().setAntiAlias(true);
                mTvPrimaryPrice.getPaint().setFlags(17);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, ProductDetailActivity.class);
                        intent.putExtra("TaoBaoProduct", product);
                        mContext.startActivity(intent);
                    }
                });
                ImageUtil.loadImageViewLoding(mContext, product.getPic_url(), holder.<ImageView>getView(R.id.imageView), R.mipmap.default_iamge);
            }
        };

        iProductListView.getRefreshCommonView().setRecyclerViewAdapter(productListAdapter);
        iProductListView.getRefreshCommonView().setIsAutoLoad(false);
        iProductListView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {
            @Override
            public void startRefresh() {
                pageNum = 1;
                productList.clear();
                presenter.getProductList(titleBean.id2, pageNum, "");
            }

            @Override
            public void startLoadMore() {
                if (productForm != null)
                    presenter.getProductList(titleBean.id2, ++pageNum, productForm.getPageDefault().getPagetime());
            }
        });
    }

    @Override
    public void loadDatas() {

    }

    @Override
    public void onResultSuccess(Object bean) {

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
        if (v.getId() == R.id.tv_buying) {
            showPopupWindow();
        } else if (v.getId() == R.id.tv_input_cart) {
            presenter.inPutCart(goodsId);
        } else if (v.getId() == R.id.ll_store) {
            Intent intent = new Intent(mContext, ShopDetailsActivity.class);
            intent.putExtra("store_id", goodsBean.getGoods().getStore_id());
            mContext.startActivity(intent);
        } else if (v.getId() == R.id.tv_collection) {
            if (iGoodsDetailView.getTVCollectionView().getText().toString().equals("收藏")) {
                //收藏
                presenter.setCollection(goodsId, String.valueOf(1));
            } else {
                //取消收藏
                presenter.setCollection(goodsId, String.valueOf(0));
            }
        }else if(v.getId()==R.id.ll_hotel){
            Intent intent = new Intent(mContext, WeddingStoreDetailsActivity.class);
            intent.putExtra("hotelid", caseDetails.getH_hotel().getId());
            mContext.startActivity(intent);
        }
    }

    private ProductListView iProductListView;

    public void setProductListViewListener(ProductListView iProductListView) {
        this.iProductListView = iProductListView;
    }

    public interface ProductListView {
        RefreshCommonView getRefreshCommonView();
    }

    private MarryProductForm productForm;

    public void onResultProductListSuccess(Object data) {
        iProductListView.getRefreshCommonView().finishRefresh();
        iProductListView.getRefreshCommonView().finishLoadMore();
        if (data == null)
            return;
        productForm = (MarryProductForm) data;
        productList.addAll(productForm.getData().getTaobaoke_goods());
        if (productList == null || productList.isEmpty()) {
            productList.clear();
            iProductListView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iProductListView.getRefreshCommonView().setIsEmpty(false);
            iProductListView.getRefreshCommonView().setIsLoadMore(productForm.getPageDefault().getCount() < productList.size());
        }
        productListAdapter.notifyDataSetChanged();
    }

    private GoodsDetailView iGoodsDetailView;

    public void setGoodsDetailViewListener(GoodsDetailView iGoodsDetailView) {
        this.iGoodsDetailView = iGoodsDetailView;
    }

    public interface GoodsDetailView {
        AppBarLayout getAppBarLayoutView();

        Toolbar getToolbarView();

        CommonCrosswiseBar getCommonCrosswiseBarView();

        ConvenientBanner getConvenientBannerView();

        TextView getNameView();

        LinearLayout getLLPriceView();

        TextView getTVNowPriceView();

        TextView getTVMarketPriceView();

        LinearLayout getLLStoreView();

        ImageView getStoreImgView();

        TextView getStoreNameView();

        LinearLayout getLLVirtualIndateView();

        TextView getTVVirtualIndateView();

        LinearLayout getLLGoodsDescribeView();

        TextView getTVGoodsDescribeView();

        TextView getTVGoodsJingleView();

        TextView getTVYouKuView();

        TextView getTVDetailDescribeView();

        RecyclerView getRecyclerView();

        LinearLayout getLLBottomView();

        TextView getTVCollectionView();

        TextView getTVConsultingView();

        TextView getTVInputCartView();

        TextView getTVBuyingView();
    }

    private String goodsId;

    public void setGoodsDetailViewParameter(Object... parameter) {
        goodsId = (String) parameter[0];
    }

    private List<GoodsDetailsBean.GoodsBean.MobileBodyBean> goodsList = new ArrayList<>();
    private SimpleAdapter goodsListAdapter;
    private List<RecommendForm.RecommendAdv> adShopList = new ArrayList<>();

    public void initGoodsDetailViewDatas() {
        iGoodsDetailView.getConvenientBannerView().startTurning(3000L).setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused}).setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
        iGoodsDetailView.getConvenientBannerView().setPages(new CBViewHolderCreator<BannerHolderView>() {
            @Override
            public BannerHolderView createHolder() {
                return new BannerHolderView();
            }
        }, adShopList);

        goodsListAdapter = new SimpleAdapter<GoodsDetailsBean.GoodsBean.MobileBodyBean>(mContext, goodsList, R.layout.item_home_pic) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final GoodsDetailsBean.GoodsBean.MobileBodyBean product) {
                if (product.getType().equals("text")) {
                    holder.setText(R.id.tv_content, product.getValue())
                            .setVisible(R.id.tv_content, true)
                            .setVisible(R.id.img_show, false);
                } else if (product.getType().equals("image")) {
                    holder.setVisible(R.id.tv_content, false)
                            .setVisible(R.id.img_show, true);
                    ImageUtil.loadImageViewLoding(mContext, product.getValue(), holder.<ImageView>getView(R.id.img_show), R.mipmap.default_iamge);
                }
            }
        };
        iGoodsDetailView.getRecyclerView().setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.VERTICAL));
        iGoodsDetailView.getRecyclerView().setAdapter(goodsListAdapter);
        iGoodsDetailView.getAppBarLayoutView().addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int dy) {
                float alpha = (float) Math.abs(dy) / iGoodsDetailView.getConvenientBannerView().getMeasuredHeight();
                alpha = alpha > 1 ? 1 : alpha;
                if (lastAlpha == alpha)
                    return;
                lastAlpha = alpha;
                setCCBTitleAlpha(lastAlpha);
            }
        });
    }

    private float lastAlpha = 0;

    private void setCCBTitleAlpha(float alpha) {
        if (alpha > 0.6) {
            iGoodsDetailView.getCommonCrosswiseBarView().setLeftButton(R.drawable.icon_back);
            iGoodsDetailView.getCommonCrosswiseBarView().setBGColor(R.color.main_title_background);
        } else {
            iGoodsDetailView.getCommonCrosswiseBarView().setLeftButton(R.drawable.gray_back);
            iGoodsDetailView.getCommonCrosswiseBarView().setBGColor(R.color.color_00000000);
        }
        iGoodsDetailView.getCommonCrosswiseBarView().setViewAlpha(alpha);
    }

    private GoodsDetailsBean goodsBean;

    public void onResultGoodsDetailsSuccess(Object data) {
        if (data == null)
            return;
        goodsBean = (GoodsDetailsBean) data;

        for (GoodsDetailsBean.GoodsBean.GoodsListBean goods : goodsBean.getGoods().getGoods_list()) {
            RecommendForm.RecommendAdv rcomm = new RecommendForm.RecommendAdv();
            rcomm.setPicurl(goods.getGoods_image());
            adShopList.add(rcomm);
        }

        if (adShopList == null || adShopList.isEmpty()) {
            iGoodsDetailView.getConvenientBannerView().setVisibility(View.GONE);
            iGoodsDetailView.getCommonCrosswiseBarView().setLeftButton(R.drawable.icon_back);
            iGoodsDetailView.getCommonCrosswiseBarView().setBGColor(R.color.main_title_background);
            iGoodsDetailView.getCommonCrosswiseBarView().setViewAlpha(1);
        } else {
            iGoodsDetailView.getConvenientBannerView().setVisibility(View.VISIBLE);
            iGoodsDetailView.getConvenientBannerView().notifyDataSetChanged();
        }

        GoodsDetailsBean.GoodsBean localGoodsBean = goodsBean.getGoods();
        iGoodsDetailView.getNameView().setText(localGoodsBean.getGoods_name());
        if (localGoodsBean.getSc_name().equals("婚礼策划")) {
            iGoodsDetailView.getTVConsultingView().setText("免费获取方案");
        } else if ((localGoodsBean.getSc_name().equals("男装定制")) || (localGoodsBean.getSc_name().equals("婚纱礼服"))) {
            iGoodsDetailView.getTVConsultingView().setText("预约免费试妆");
        } else if (localGoodsBean.getSc_name().equals("婚礼跟妆")) {
            iGoodsDetailView.getTVConsultingView().setText("预约试妆");
        }
        Drawable drawable = UiUtils.getDrawable(localGoodsBean.getIscancel() == 1 ? R.drawable.icon_goods_collect_ok : R.drawable.icon_goods_collect);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        iGoodsDetailView.getTVCollectionView().setCompoundDrawables(null, drawable, null, null);
        iGoodsDetailView.getTVCollectionView().setText(localGoodsBean.getIscancel() == 1 ? "已收藏" : "收藏");

        if (goodsBean.getCode().equals("1028")) {
            iGoodsDetailView.getTVBuyingView().setVisibility(View.GONE);
            iGoodsDetailView.getTVInputCartView().setVisibility(View.GONE);
            iGoodsDetailView.getTVConsultingView().setVisibility(View.GONE);
            ToastUtil.showShort(goodsBean.getMessage());
        }

        iGoodsDetailView.getTVNowPriceView().setText("￥" + goodsBean.getGoods().getGoods_price());
        iGoodsDetailView.getStoreNameView().setText(goodsBean.getGoods().getStore_name());
        iGoodsDetailView.getLLGoodsDescribeView().setVisibility(StringUtils.textIsEmpty(goodsBean.getGoods().getGoods_jingle())?View.GONE:View.VISIBLE);
        iGoodsDetailView.getTVGoodsJingleView().setText(goodsBean.getGoods().getGoods_jingle());
        iGoodsDetailView.getTVMarketPriceView().setText("￥" + goodsBean.getGoods().getGoods_marketprice());
        iGoodsDetailView.getTVMarketPriceView().getPaint().setFlags(16);

        switch (localGoodsBean.getIs_virtual()) {

            case "0":
                iGoodsDetailView.getTVConsultingView().setVisibility(View.GONE);
                iGoodsDetailView.getTVBuyingView().setVisibility(View.VISIBLE);
                iGoodsDetailView.getTVInputCartView().setVisibility(View.VISIBLE);
                break;

            case "1":
                iGoodsDetailView.getTVConsultingView().setVisibility(View.VISIBLE);
                iGoodsDetailView.getTVBuyingView().setVisibility(View.VISIBLE);
                iGoodsDetailView.getTVInputCartView().setVisibility(View.GONE);
                break;

            case "2":
                iGoodsDetailView.getTVConsultingView().setVisibility(View.GONE);
                iGoodsDetailView.getTVInputCartView().setVisibility(View.VISIBLE);
                iGoodsDetailView.getTVBuyingView().setVisibility(View.VISIBLE);
                break;
        }
        goodsList.addAll(goodsBean.getGoods().getMobile_body());
        goodsListAdapter.notifyDataSetChanged();

        ImageUtil.loadImageViewLoding(mContext, goodsBean.getGoods().getStore_avatar(), iGoodsDetailView.getStoreImgView(), R.mipmap.default_iamge, R.drawable.icon_default_shop);
        iGoodsDetailView.getLLVirtualIndateView().setVisibility(StringUtils.textIsEmpty(goodsBean.getGoods().getVirtual_indate())?View.GONE:View.VISIBLE);
        iGoodsDetailView.getTVVirtualIndateView().setText(goodsBean.getGoods().getVirtual_indate());
    }

    private long mGoodNum = 0;

    public void showPopupWindow() {
        /*final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(mContext, R.style.AlertDialogTheme);
        View view = LayoutInflater.from(mContext).inflate(R.layout.goods_popup_window, null);
        dialogBuilder.setView(view);
        ImageView localImageView = (ImageView) view.findViewById(R.id.img_icon);
        TextView localTextView5 = (TextView) view.findViewById(R.id.tv_goods_price);
        final TextView localTextView3 = (TextView) view.findViewById(R.id.tv_goods_number);
        localTextView3.setText(String.valueOf(mGoodNum));
        localTextView5.setText(this.goodsBean.getGoods().getGoods_price());
        ImageUtil.loadImageViewLoding(mContext, goodsBean.getGoods().getGoods_image(), localImageView, R.mipmap.default_iamge, R.drawable.icon_default_shop);
        final AlertDialog dialog = (dialogBuilder).create();
        view.findViewById(R.id.tv_now_pay).setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                Intent intent = new Intent(mContext, CheckInformationActivity.class);
                intent.putExtra("type", "goods");
                intent.putExtra("goods_id", goodsId);
                intent.putExtra("goods_num", mGoodNum);
                intent.putExtra("is_virtual", goodsBean.getGoods().getIs_virtual());
                mContext.startActivity(intent);
                dialog.dismiss();
            }
        });
        view.findViewById(R.id.tv_dismiss).setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                dialog.dismiss();
            }
        });
        view.findViewById(R.id.btn_minus).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (mGoodNum > 1) {
                    localTextView3.setText(String.valueOf(--mGoodNum));
                }
            }
        });
        view.findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                if (goodsBean.getGoods().getIs_virtual().equals("0")) {
                    localTextView3.setText(String.valueOf(++mGoodNum));
                    return;
                }
                if (mGoodNum < Integer.valueOf(goodsBean.getGoods().getVirtual_limit()).intValue()) {
                    localTextView3.setText(String.valueOf(++mGoodNum));
                    return;
                }
                ToastUtil.showShort("亲~最多可以购买" + goodsBean.getGoods().getVirtual_limit() + "个哦");
            }
        });
        dialog.show();*/
    }

    public void onResultCollectionSuccess(Object obj) {
        if (obj == null)
            return;
        CollectionBean collect = (CollectionBean) obj;
        ToastUtil.showShort(collect.getMessage());
        Drawable drawable = UiUtils.getDrawable(iGoodsDetailView.getTVCollectionView().getText().toString().equals("收藏") ? R.drawable.icon_goods_collect_ok : R.drawable.icon_goods_collect);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        iGoodsDetailView.getTVCollectionView().setCompoundDrawables(null, drawable, null, null);
        iGoodsDetailView.getTVCollectionView().setText(iGoodsDetailView.getTVCollectionView().getText().toString().equals("收藏") ? "已收藏" : "收藏");
    }

    private ShopCaseView iShopCaseView;

    public void setShopCaseViewListener(ShopCaseView iShopCaseView) {
        this.iShopCaseView = iShopCaseView;
    }

    public interface ShopCaseView {
        TextView getTitleView();

        SimpleDraweeView getStoreLabelView();

        TextView getTVStoreNameView();

        ImageView getImgCaseHeaderView();

        LinearLayout getLLAssociatedView();

        TextView getTVPriceView();

        LinearLayout getLLHotelView();

        TextView getTVHotelNameView();

        TextView getTVDescribeView();

        RecyclerView getRecyclerView();

        TextView getTVCollectionView();

        TextView getTVConsultingView();
    }

    private String caseId;
    public void setShopCaseViewParameter(Object... parameter){
        caseId = (String) parameter[0];
    }

    private SimpleAdapter shopCaseAdapter;
    private List<CaseDetailsBean.CasesBean.CaseListBean> caseList = new ArrayList<>();
    public void initShopCaseViewDatas(){
        iShopCaseView.getRecyclerView().setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.VERTICAL));
        iShopCaseView.getRecyclerView().setNestedScrollingEnabled(false);
        shopCaseAdapter = new SimpleAdapter<CaseDetailsBean.CasesBean.CaseListBean>(mContext, caseList, R.layout.item_home_pic) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final CaseDetailsBean.CasesBean.CaseListBean product) {
                if (!StringUtils.textIsEmpty(product.getContent())) {
                    holder.setText(R.id.tv_content, product.getContent())
                            .setVisible(R.id.tv_content, true)
                            .setVisible(R.id.img_show, false);
                } else {
                    holder.setVisible(R.id.tv_content, false)
                            .setVisible(R.id.img_show, true);
                    ImageUtil.loadImageViewLoding(mContext, product.getCase_image(), holder.<ImageView>getView(R.id.img_show), R.mipmap.default_iamge);
                }
            }
        };
        iShopCaseView.getRecyclerView().setAdapter(shopCaseAdapter);
    }

    private CaseDetailsBean caseDetails;
    public void onResultShopCaseSuccess(Object data) {
        if (data == null)
            return;
        caseDetails = (CaseDetailsBean) data;

        if (caseDetails.getCases().equals("婚礼策划")) {
            iShopCaseView.getTVConsultingView().setText("免费获取方案");
        } else if (caseDetails.getCases().equals("男装定制") || caseDetails.getCases().equals("婚纱礼服")) {
            iShopCaseView.getTVConsultingView().setText("预约免费试妆");
        } else if (caseDetails.getCases().equals("婚礼跟妆")) {
            iShopCaseView.getTVConsultingView().setText("预约试妆");
        }
        Drawable drawable = UiUtils.getDrawable(caseDetails.getCases().getIscancel() == 1 ? R.drawable.icon_goods_collect_ok : R.drawable.icon_goods_collect);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        iShopCaseView.getTVCollectionView().setCompoundDrawables(null, drawable, null, null);
        iShopCaseView.getTVCollectionView().setText(caseDetails.getCases().getIscancel() == 1 ? "已收藏" : "收藏");

        ImageUtil.loadImageViewLoding(mContext, caseDetails.getCases().getCase_images(), iShopCaseView.getImgCaseHeaderView(), R.mipmap.default_iamge, R.drawable.icon_default_shop);
        ImageUtil.loadImageViewLoding(mContext, caseDetails.getCases().getStore_avatar(), iShopCaseView.getStoreLabelView(), R.mipmap.default_iamge, R.drawable.icon_default_shop);
        iShopCaseView.getTitleView().setText(caseDetails.getCases().getCase_title());
        iShopCaseView.getTVStoreNameView().setText(caseDetails.getCases().getStore_name());
        iShopCaseView.getTVDescribeView().setText(caseDetails.getCases().getCase_descr());

        iShopCaseView.getTVPriceView().setText(StringUtils.textIsEmpty(caseDetails.getCases().getPrice())?"暂无报价":caseDetails.getCases().getPrice());
        if (caseDetails.getH_hotel()==null||TextUtils.isEmpty(caseDetails.getH_hotel().getName())){
            iShopCaseView.getLLHotelView().setVisibility(View.GONE);
        }else{
            iShopCaseView.getLLHotelView().setVisibility(View.VISIBLE);
            iShopCaseView.getTVHotelNameView().setText(caseDetails.getH_hotel().getName());
        }
        caseList.clear();
        caseList.addAll(caseDetails.getCases().getCase_list());
        shopCaseAdapter.notifyDataSetChanged();
    }

}

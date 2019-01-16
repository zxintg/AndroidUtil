package com.zxin.marry.mvp.view;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;
import com.zxin.marry.R;
import com.zxin.marry.activity.ConsultingActivity;
import com.zxin.marry.activity.GoodsDetailsActivity;
import com.zxin.marry.activity.GoodsListActivity;
import com.zxin.marry.activity.ShopCaseActivity;
import com.zxin.marry.activity.ShopCaseDetailsActivity;
import com.zxin.marry.activity.ShopCommentActivity;
import com.zxin.marry.activity.ShopCommentListActivity;
import com.zxin.marry.activity.TopicActivity;
import com.zxin.marry.activity.VipPrivlegeActivity;
import com.zxin.marry.bean.CaseBean;
import com.zxin.marry.bean.CircleForm;
import com.zxin.marry.bean.EventBean;
import com.zxin.marry.bean.GiftBean;
import com.zxin.marry.bean.GoodsBean;
import com.zxin.marry.bean.ShopCaseBean;
import com.zxin.marry.bean.ShopDetails;
import com.zxin.marry.bean.ShopGoodsBean;
import com.zxin.marry.bean.StoreCommentList;
import com.zxin.marry.bean.TopicDetailForm;
import com.zxin.marry.bean.TopicForm;
import com.zxin.marry.mvp.presenter.ShopPresenter;
import com.zxin.marry.mvp.presenter.TopicPresenter;
import com.zxin.marry.util.StringUtils;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.network.mvp.view.IBaseView;
import com.zxin.zxinlib.adapter.SimpleAdapter.SimpleAdapter;
import com.zxin.zxinlib.adapter.SimpleAdapter.TrdViewHolder;
import com.zxin.zxinlib.util.ImageUtil;
import com.zxin.zxinlib.util.UiUtils;
import com.zxin.zxinlib.view.CommonCrosswiseBar;
import com.zxin.zxinlib.view.RefreshCommonView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/24.
 */

public class ShopContract implements IBaseView {
    private Context mContext;

    @Override
    public void setParameter(Object... parameter) {

    }

    @Override
    public void initDatas() {


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

    private ShopPresenter presenter;

    @Override
    public void setP(BasePresenter... basePresenter) {
        presenter = (ShopPresenter) basePresenter[0];
    }

    @Override
    public void OnClick(View v) {
        if (v.getId()==R.id.tv_goods_more){
            Intent intent = new Intent(mContext,GoodsListActivity.class);
            intent.putExtra("store_id", store_id);
            mContext.startActivity(intent);
        }else if (v.getId()==R.id.tv_cases_more){
            Intent intent = new Intent(mContext,ShopCaseActivity.class);
            intent.putExtra("store_id", store_id);
            mContext.startActivity(intent);
        }else if (v.getId()==R.id.tv_comments_more){
            Intent intent = new Intent(mContext, ShopCommentListActivity.class);
            intent.putExtra("store_id",store_id);
            mContext.startActivity(intent);
        }else if (v.getId()==R.id.ll_comments){
            if (shopDetails.getIsCommented() == 1) {
                Intent intent = new Intent(mContext, ShopCommentListActivity.class);
                intent.putExtra("store_id", store_id);
                mContext.startActivity(intent);
            }else{
                Intent intent = new Intent(mContext, ShopCommentActivity.class);
                intent.putExtra("store_id", store_id);
                mContext.startActivity(intent);
            }
        }else if (v.getId()==R.id.tv_consulting){
            Intent intent = new Intent(mContext,ConsultingActivity.class);
            intent.putExtra("store_id", store_id);
            intent.putExtra("goods_id", "0");
            intent.putExtra("iscancel", iscancel);
            intent.putExtra("type", "store");
            mContext.startActivity(intent);
        } else if (v.getId()==R.id.tv_gift){
            Intent intent = new Intent(mContext, VipPrivlegeActivity.class);
            intent.putExtra("StoreId", store_id);
            mContext.startActivity(intent);
        }
    }

    private MainTopicView iView;

    public void setMainTopicViewListener(MainTopicView testView) {
        this.iView = testView;
    }

    public interface MainTopicView {

        CommonCrosswiseBar getCommonCrosswiseBarView();

        AppBarLayout getAppBarLayoutView();

        ImageView getIMGHeaderView();

        TextView getTVShopNameView();

        ImageView getIVShopLevelView();

        TextView getTVScNameView();

        TextView getTVStoreCollectView();

        ImageView getIMGStoreView();

        Toolbar getToolbarView();

        TextView getTVIntroduceView();

        LinearLayout getLLGiftView();

        RecyclerView getRVGiftView();

        LinearLayout getLLSpecialView();

        LinearLayout getLLEventView();

        RecyclerView getRVEventListView();

        LinearLayout getLLAddressView();

        TextView getTVAddressView();

        LinearLayout getLLGoodsView();

        TextView getTVGoodsCountView();

        RecyclerView getRVGoodsView();

        TextView getTVGoodsMoreView();

        LinearLayout getLLCasesView();

        TextView getTVCaseCountView();

        RecyclerView getRVCaseView();

        TextView getTVCaseMoreView();

        LinearLayout getLLCommentsView();

        TextView getTVCommentsCountView();

        RecyclerView getRVCommentsView();

        TextView getTVCommentsMoreView();

        TextView getTVCommentView();

        TextView getTVCollectionView();

        TextView getTVConsultingView();
    }

    private String store_id;

    public void setMainTopicViewParameter(Object... parameter) {
        store_id = (String) parameter[0];
    }

    private SimpleAdapter giftAdapter, eventAdapter, goodsAdapter, commentAdapter, caseAdapter;
    private List<GiftBean> giftList = new ArrayList<>();
    private List<GoodsBean> goodsList = new ArrayList<>();
    private List<EventBean> eventList = new ArrayList<>();
    private List<StoreCommentList.Comment> commentsList = new ArrayList<>();
    private List<CaseBean> caseList = new ArrayList<>();

    public void initMainTopicViewDatas() {
        iView.getRVGiftView().setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.VERTICAL));
        iView.getRVGiftView().setNestedScrollingEnabled(false);
        giftAdapter = new SimpleAdapter<GiftBean>(mContext, giftList, R.layout.item_gift) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final GiftBean giftBean) {
                holder.setText(R.id.tv_gift_descr, giftBean.getTitle());
                String str = giftBean.getType();
                if (!str.equals("a")) {
                    holder.setText(R.id.tv_gift_title, "到店礼");
                }
                if (!str.equals("b")) {
                    holder.setText(R.id.tv_gift_title, "订单礼");
                }
                if (!str.equals("c")) {
                    holder.setText(R.id.tv_gift_title, "优惠");
                }
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, VipPrivlegeActivity.class);
                        intent.putExtra("StoreId", store_id);
                        mContext.startActivity(intent);
                    }
                });
            }
        };
        iView.getRVGiftView().setAdapter(giftAdapter);

        iView.getRVEventListView().setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.HORIZONTAL));
        eventAdapter = new SimpleAdapter<EventBean>(mContext, eventList, R.layout.item_event_list) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final EventBean eventBean) {
                String str = eventBean.getType();
                if (str.equals("store_baozh")) {
                    holder.setText(R.id.tv_icon, "保")
                            .setText(R.id.tv_content, "保障")
                            .setBackgroundRes(R.id.tv_icon, R.drawable.btn_shape_bao);
                }
                if (str.equals("store_baozhopen")) {
                    holder.setText(R.id.tv_icon, "￥")
                            .setText(R.id.tv_content, "保证金")
                            .setBackgroundRes(R.id.tv_icon, R.drawable.shop_baojin);
                }
                if (str.equals("store_qtian")) {
                    holder.setText(R.id.tv_icon, "7")
                            .setText(R.id.tv_content, "七天退换")
                            .setBackgroundRes(R.id.tv_icon, R.drawable.shape_7);
                }
                if (str.equals("store_zhping")) {
                    holder.setText(R.id.tv_icon, "正")
                            .setText(R.id.tv_content, "正品保障")
                            .setBackgroundRes(R.id.tv_icon, R.drawable.btn_shape_nuo);
                }
                if (str.equals("store_erxiaoshi")) {
                    holder.setText(R.id.tv_icon, "商")
                            .setText(R.id.tv_content, "工商认证")
                            .setBackgroundRes(R.id.tv_icon, R.drawable.shape_2h);
                }
                if (str.equals("store_tuihuo")) {
                    holder.setText(R.id.tv_icon, "退")
                            .setText(R.id.tv_content, "退换承若")
                            .setBackgroundRes(R.id.tv_icon, R.drawable.btn_shape_tui);
                }
                if (str.equals("store_shiyong")) {
                    holder.setText(R.id.tv_icon, "使")
                            .setText(R.id.tv_content, "使用中心")
                            .setBackgroundRes(R.id.tv_icon, R.drawable.shape_shiyong);
                }
                if (str.equals("store_shiti")) {
                    holder.setText(R.id.tv_icon, "实")
                            .setText(R.id.tv_content, "实体验证")
                            .setBackgroundRes(R.id.tv_icon, R.drawable.shape_shi);
                }
                if (str.equals("store_xiaoxie")) {
                    holder.setText(R.id.tv_icon, "消")
                            .setText(R.id.tv_content, "消费者保障")
                            .setBackgroundRes(R.id.tv_icon, R.drawable.btn_shop_xiao);
                }
                if (str.equals("store_huodaofk")) {
                    holder.setText(R.id.tv_icon, "货")
                            .setText(R.id.tv_content, "货到付款")
                            .setBackgroundRes(R.id.tv_icon, R.drawable.shape_huo);
                }
            }
        };
        iView.getRVEventListView().setAdapter(eventAdapter);

        iView.getRVGoodsView().setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.VERTICAL));
        iView.getRVGoodsView().setNestedScrollingEnabled(false);
        goodsAdapter = new SimpleAdapter<GoodsBean>(mContext, goodsList, R.layout.item_shop_goods) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final GoodsBean goodsBean) {
                holder.setText(R.id.tv_goods_price, goodsBean.getGoods_price())
                        .setText(R.id.tv_goods_name, goodsBean.getGoods_name())
                        .setText(R.id.tv_goods_collect, goodsBean.getGoods_collect())
                        .setText(R.id.tv_marketprice, "￥" + goodsBean.getGoods_marketprice());
                holder.<TextView>getView(R.id.tv_marketprice).getPaint().setFlags(16);
                ImageUtil.loadImageViewLoding(mContext, goodsBean.getGoods_image(), holder.<ImageView>getView(R.id.img_icon), R.mipmap.default_iamge, R.mipmap.default_iamge);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, GoodsDetailsActivity.class);
                        intent.putExtra("goods_id", goodsBean.getGoods_id());
                        mContext.startActivity(intent);
                    }
                });
            }
        };
        iView.getRVGoodsView().setAdapter(goodsAdapter);

        iView.getRVCommentsView().setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.VERTICAL));
        iView.getRVCommentsView().setNestedScrollingEnabled(false);
        commentAdapter = new SimpleAdapter<StoreCommentList.Comment>(mContext, commentsList, R.layout.item_shop_comment_list) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final StoreCommentList.Comment goodsBean) {
                holder.setText(R.id.tv_name, goodsBean.getMember_truename())
                        .setText(R.id.tv_date, goodsBean.getCreatetime())
                        .setText(R.id.tv_content, goodsBean.getContent());
                RatingBar ratingBar = holder.getView(R.id.rb_complex);
                ratingBar.setRating(goodsBean.getScore());
                ratingBar.setIsIndicator(true);
                if (!StringUtils.textIsEmpty(goodsBean.getPrice())) {
                    holder.setText(R.id.tv_price, "￥" + goodsBean.getPrice());
                }
                ImageUtil.loadCircleImageView(mContext, goodsBean.getMember_avatar(), holder.<ImageView>getView(R.id.iv_head), R.mipmap.default_iamge);
                RecyclerView recyclerView = holder.getView(R.id.gv_image);
                recyclerView.setLayoutManager(UiUtils.getGridLayoutManager(3));
                recyclerView.setNestedScrollingEnabled(false);
                recyclerView.setAdapter(new SimpleAdapter<String>(mContext, goodsBean.getImgs(), R.layout.item_comment_img) {
                    @Override
                    protected void onBindViewHolder(TrdViewHolder holder, final String image) {
                        ImageUtil.loadImageViewLoding(mContext, image, holder.<ImageView>getView(R.id.iv_comment), R.mipmap.default_iamge, R.mipmap.default_iamge);
                    }
                });
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext,ShopCommentListActivity.class);
                        intent.putExtra("store_id", store_id);
                        mContext.startActivity(intent);
                    }
                });
            }
        };
        iView.getRVCommentsView().setAdapter(commentAdapter);

        iView.getRVCaseView().setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.VERTICAL));
        iView.getRVCaseView().setNestedScrollingEnabled(false);
        caseAdapter = new SimpleAdapter<CaseBean>(mContext, caseList, R.layout.item_studio_details) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final CaseBean caseBean) {
                holder.setText(R.id.tv_content, caseBean.getCase_title())
                        .setVisible(R.id.v_line1,caseList.indexOf(caseBean)==caseList.size()-1)
                        .setVisible(R.id.v_line2,caseList.indexOf(caseBean)!=caseList.size()-1);
                ImageUtil.loadImageViewLoding(mContext, caseBean.getCase_images(), holder.<ImageView>getView(R.id.img_show), R.mipmap.default_iamge, R.mipmap.default_iamge);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, ShopCaseDetailsActivity.class);
                        intent.putExtra("case_id", caseBean.getCase_id());
                        mContext.startActivity(intent);
                    }
                });
            }
        };
        iView.getRVCaseView().setAdapter(caseAdapter);

        iView.getAppBarLayoutView().addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int dy) {
                float alpha = (float) Math.abs(dy) / iView.getIMGHeaderView().getMeasuredHeight();
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
            iView.getCommonCrosswiseBarView().setLeftButton(R.drawable.icon_back);
            iView.getCommonCrosswiseBarView().setBGColor(R.color.main_title_background);
        } else {
            iView.getCommonCrosswiseBarView().setLeftButton(R.drawable.gray_back);
            iView.getCommonCrosswiseBarView().setBGColor(R.color.color_00000000);
        }
        iView.getCommonCrosswiseBarView().setViewAlpha(alpha);
    }
    private int iscancel = 0;
    private ShopDetails shopDetails;
    public void onResultShopDetailSuccess(Object object) {
        if (object == null)
            return;

        shopDetails = (ShopDetails) object;

        ImageUtil.loadImageViewLoding(mContext, shopDetails.getEcshop().getStore_banner(), iView.getIMGHeaderView(), R.mipmap.default_iamge, R.mipmap.default_iamge);
        ImageUtil.loadCircleImageView(mContext, shopDetails.getEcshop().getStore_avatar(), iView.getIMGStoreView(), R.mipmap.default_iamge);

        if (shopDetails.getEcshop().getSc_name().equals("婚礼策划")) {
            iView.getTVConsultingView().setText("免费获取方案");
        }
        if ((shopDetails.getEcshop().getSc_name().equals("男装定制")) || (shopDetails.getEcshop().getSc_name().equals("婚纱礼服"))) {
            iView.getTVConsultingView().setText("预约免费试穿");
        }
        if (shopDetails.getEcshop().getSc_name().equals("婚礼跟妆")) {
            iView.getTVConsultingView().setText("预约试妆");
        }
        iscancel = shopDetails.getEcshop().getIscancel();
        if (iscancel == 1) {
            iView.getTVCollectionView().setText("已收藏");
            ImageUtil.setCompoundDrawable(iView.getTVCollectionView(), 20, R.drawable.icon_goods_collect_ok, Gravity.TOP, 0);
        }else{
            iView.getTVCollectionView().setText("收藏");
            ImageUtil.setCompoundDrawable(iView.getTVCollectionView(), 20, R.drawable.icon_goods_collect, Gravity.TOP, 0);
        }
        iView.getLLSpecialView().setVisibility("1".equals(shopDetails.getEcshop().getStore_recommend())?View.VISIBLE:View.GONE);

        iView.getTVStoreCollectView().setTag(shopDetails.getEcshop().getStore_collect());
        iView.getTVStoreCollectView().setText("粉丝 "+shopDetails.getEcshop().getStore_collect());
        iView.getTVShopNameView().setText(shopDetails.getEcshop().getStore_name());
        iView.getTVAddressView().setText(shopDetails.getEcshop().getLive_store_address());
        iView.getTVIntroduceView().setText(shopDetails.getEcshop().getStore_zy());
        iView.getTVGoodsCountView().setText("(" + shopDetails.getEcshop().getGoods_count() + ")");
        iView.getTVScNameView().setText(shopDetails.getEcshop().getSc_name());
        iView.getTVCommentsCountView().setText("(" + shopDetails.getCommentsCount() + ")");
        iView.getTVCaseCountView().setText("(" + shopDetails.getEcshop().getCases_count() + ")");
        iView.getTVCommentView().setText(shopDetails.getIsCommented() == 1?"已点评":"点评");

        switch (shopDetails.getEcshop().getGrade_id()){
            case "1":
                iView.getIVShopLevelView().setImageDrawable(UiUtils.getDrawable(R.drawable.icon_ordinary_buiness));
                break;

            case "2":
                iView.getIVShopLevelView().setImageDrawable(UiUtils.getDrawable(R.drawable.icon_bronze_buiness));
                break;

            case "3":
                iView.getIVShopLevelView().setImageDrawable(UiUtils.getDrawable(R.drawable.icon_silver_buiness));
                break;

            case "4":
                iView.getIVShopLevelView().setImageDrawable(UiUtils.getDrawable(R.drawable.icon_gold_buiness));
                break;

            case "5":
                iView.getIVShopLevelView().setImageDrawable(UiUtils.getDrawable(R.drawable.icon_masonry_buiness));
                break;

        }

        giftList.clear();
        giftList.addAll(shopDetails.getGift());
        if (giftList == null || giftList.isEmpty())
            iView.getLLGiftView().setVisibility(View.GONE);
        else
            giftAdapter.notifyDataSetChanged();

        eventList.clear();
        EventBean eventMap;
        if (shopDetails.getEcshop().getStore_baozh().equals("1")) {
            eventMap = new EventBean();
            eventMap.setType("store_baozh");
            eventMap.setValue(shopDetails.getEcshop().getStore_baozh());
            eventList.add(eventMap);
        }
        if (shopDetails.getEcshop().getStore_baozhopen().equals("1")) {
            eventMap = new EventBean();
            eventMap.setType("store_baozhopen");
            eventMap.setValue(shopDetails.getEcshop().getStore_baozhopen());
            eventList.add(eventMap);
        }
        if (shopDetails.getEcshop().getStore_qtian().equals("1")) {
            eventMap = new EventBean();
            eventMap.setType("store_qtian");
            eventMap.setValue(shopDetails.getEcshop().getStore_qtian());
            eventList.add(eventMap);
        }
        if (shopDetails.getEcshop().getStore_zhping().equals("1")) {
            eventMap = new EventBean();
            eventMap.setType("store_zhping");
            eventMap.setValue(shopDetails.getEcshop().getStore_zhping());
            eventList.add(eventMap);
        }
        if (shopDetails.getEcshop().getStore_erxiaoshi().equals("1")) {
            eventMap = new EventBean();
            eventMap.setType("store_erxiaoshi");
            eventMap.setValue(shopDetails.getEcshop().getStore_erxiaoshi());
            eventList.add(eventMap);
        }
        if (shopDetails.getEcshop().getStore_tuihuo().equals("1")) {
            eventMap = new EventBean();
            eventMap.setType("store_tuihuo");
            eventMap.setValue(shopDetails.getEcshop().getStore_tuihuo());
            eventList.add(eventMap);
        }
        if (shopDetails.getEcshop().getStore_shiyong().equals("1")) {
            eventMap = new EventBean();
            eventMap.setType("store_shiyong");
            eventMap.setValue(shopDetails.getEcshop().getStore_shiyong());
            eventList.add(eventMap);
        }
        if (shopDetails.getEcshop().getStore_shiti().equals("1")) {
            eventMap = new EventBean();
            eventMap.setType("store_shiti");
            eventMap.setValue(shopDetails.getEcshop().getStore_shiti());
            eventList.add(eventMap);
        }
        if (shopDetails.getEcshop().getStore_xiaoxie().equals("1")) {
            eventMap = new EventBean();
            eventMap.setType("store_xiaoxie");
            eventMap.setValue(shopDetails.getEcshop().getStore_xiaoxie());
            eventList.add(eventMap);
        }
        if (shopDetails.getEcshop().getStore_huodaofk().equals("1")) {
            eventMap = new EventBean();
            eventMap.setType("store_huodaofk");
            eventMap.setValue(shopDetails.getEcshop().getStore_huodaofk());
            eventList.add(eventMap);
        }
        if (eventList == null || eventList.isEmpty())
            iView.getLLEventView().setVisibility(View.GONE);
        else
            eventAdapter.notifyDataSetChanged();

        commentsList.clear();
        commentsList.addAll(shopDetails.getCommentsRes());
        if (commentsList == null || commentsList.isEmpty())
            iView.getLLCommentsView().setVisibility(View.GONE);
        else
            commentAdapter.notifyDataSetChanged();

        goodsList.clear();
        goodsList.addAll(shopDetails.getEcshop().getGoods_list());
        if (goodsList == null || goodsList.isEmpty())
            iView.getLLGoodsView().setVisibility(View.GONE);
        else
            goodsAdapter.notifyDataSetChanged();

        caseList.clear();
        caseList.addAll(shopDetails.getEcshop().getCase_list());
        if (caseList == null || caseList.isEmpty())
            iView.getLLCasesView().setVisibility(View.GONE);
        else
            caseAdapter.notifyDataSetChanged();
    }

    private GoodsListView iGoodsListView;

    public void setGoodsListViewListener(GoodsListView iGoodsListView) {
        this.iGoodsListView = iGoodsListView;
    }

    public interface GoodsListView{
        RefreshCommonView getRefreshCommonView();
    }

    public void setGoodsListViewParameter(Object... parameter){
        store_id = (String) parameter[0];
    }

    private List<GoodsBean> storeGoodsList = new ArrayList<>();
    private SimpleAdapter storeGoodsAdapter;
    public void initGoodsListViewDatas(){
        storeGoodsAdapter = new SimpleAdapter<GoodsBean>(mContext, storeGoodsList, R.layout.item_set_meal) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final GoodsBean goodsBean) {
                holder.setText(R.id.tv_goods_price, goodsBean.getGoods_price())
                        .setText(R.id.tv_goods_name, goodsBean.getGoods_name())
                        .setText(R.id.tv_goods_collect, goodsBean.getGoods_collect())
                        .setText(R.id.tv_marketprice, "￥" + goodsBean.getGoods_marketprice());
                holder.<TextView>getView(R.id.tv_marketprice).getPaint().setFlags(16);
                ImageUtil.loadImageViewLoding(mContext, goodsBean.getGoods_image(), holder.<ImageView>getView(R.id.img_icon), R.mipmap.default_iamge, R.mipmap.default_iamge);

                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, GoodsDetailsActivity.class);
                        intent.putExtra("goods_id", goodsBean.getGoods_id());
                        mContext.startActivity(intent);
                    }
                });
            }
        };
        iGoodsListView.getRefreshCommonView().setRecyclerViewAdapter(storeGoodsAdapter);
        iGoodsListView.getRefreshCommonView().setIsRefresh(false);
        iGoodsListView.getRefreshCommonView().setIsLoadMore(false);
    }

    public void onResultStoreGoodsListSuccess(Object obj){
        if (obj==null)
            return;
        ShopGoodsBean shopGoods = (ShopGoodsBean)obj;
        storeGoodsList.clear();
        storeGoodsList.addAll(shopGoods.getGoods());
        storeGoodsAdapter.notifyDataSetChanged();
    }


    private ShopCaseView iShopCaseView;

    public void setShopCaseViewListener(ShopCaseView iShopCaseView) {
        this.iShopCaseView = iShopCaseView;
    }

    public interface ShopCaseView{
        RefreshCommonView getRefreshCommonView();
    }

    public void setShopCaseViewParameter(Object... parameter){
        store_id = (String) parameter[0];
    }
    private List<CaseBean> storeCaseList = new ArrayList<>();
    private SimpleAdapter storeCaseAdapter;
    public void initShopCaseViewDatas(){
        storeCaseAdapter = new SimpleAdapter<CaseBean>(mContext, storeCaseList, R.layout.item_studio_details) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final CaseBean caseBean) {
                holder.setText(R.id.tv_content, caseBean.getCase_title());
                ImageUtil.loadImageViewLoding(mContext, caseBean.getCase_images(), holder.<ImageView>getView(R.id.img_show), R.mipmap.default_iamge, R.mipmap.default_iamge);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, ShopCaseDetailsActivity.class);
                        intent.putExtra("case_id", caseBean.getCase_id());
                        mContext.startActivity(intent);
                    }
                });
            }
        };
        iShopCaseView.getRefreshCommonView().setRecyclerViewAdapter(storeCaseAdapter);
        iShopCaseView.getRefreshCommonView().setIsRefresh(false);
        iShopCaseView.getRefreshCommonView().setIsLoadMore(false);
    }


    public void onResultShopCaseListSuccess(Object obj){
        if (obj==null)
            return;
        ShopCaseBean shopCase = (ShopCaseBean)obj;
        storeCaseList.clear();
        storeCaseList.addAll(shopCase.getCaselist());
        storeCaseAdapter.notifyDataSetChanged();
    }


    private ShopCommentView iShopCommentView;

    public void setShopCommentViewListener(ShopCommentView iShopCommentView) {
        this.iShopCommentView = iShopCommentView;
    }

    public interface ShopCommentView{
        RefreshCommonView getRefreshCommonView();
    }

    public void setShopCommentViewParameter(Object... parameter){
        store_id = (String) parameter[0];
    }
    private List<StoreCommentList.Comment> storeCommentList = new ArrayList<>();
    private SimpleAdapter storeCommentAdapter;
    public void initShopCommentViewDatas(){
        storeCommentAdapter = new SimpleAdapter<StoreCommentList.Comment>(mContext, storeCommentList, R.layout.item_shop_comment_list) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final StoreCommentList.Comment goodsBean) {
                holder.setText(R.id.tv_name, goodsBean.getMember_truename())
                        .setText(R.id.tv_date, goodsBean.getCreatetime())
                        .setText(R.id.tv_content, goodsBean.getContent());
                RatingBar ratingBar = holder.getView(R.id.rb_complex);
                ratingBar.setRating(goodsBean.getScore());
                ratingBar.setIsIndicator(true);
                if (!StringUtils.textIsEmpty(goodsBean.getPrice())) {
                    holder.setText(R.id.tv_price, "￥" + goodsBean.getPrice());
                }
                ImageUtil.loadCircleImageView(mContext, goodsBean.getMember_avatar(), holder.<ImageView>getView(R.id.iv_head), R.mipmap.default_iamge);
                RecyclerView recyclerView = holder.getView(R.id.gv_image);
                recyclerView.setLayoutManager(UiUtils.getGridLayoutManager(3));
                recyclerView.setNestedScrollingEnabled(false);
                recyclerView.setAdapter(new SimpleAdapter<String>(mContext, goodsBean.getImgs(), R.layout.item_comment_img) {
                    @Override
                    protected void onBindViewHolder(TrdViewHolder holder, final String image) {
                        ImageUtil.loadImageViewLoding(mContext, image, holder.<ImageView>getView(R.id.iv_comment), R.mipmap.default_iamge, R.mipmap.default_iamge);
                    }
                });
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext,ShopCommentListActivity.class);
                        intent.putExtra("store_id", store_id);
                        mContext.startActivity(intent);
                    }
                });
            }
        };
        iShopCommentView.getRefreshCommonView().setRecyclerViewAdapter(storeCommentAdapter);
        iShopCommentView.getRefreshCommonView().setIsRefresh(false);
        iShopCommentView.getRefreshCommonView().setIsLoadMore(false);
    }


    public void onResultShopCommentListSuccess(Object obj){
        if (obj==null)
            return;
        StoreCommentList shopCase = (StoreCommentList)obj;
        storeCommentList.clear();
        storeCommentList.addAll(shopCase.getComments());
        storeCommentAdapter.notifyDataSetChanged();
    }

}

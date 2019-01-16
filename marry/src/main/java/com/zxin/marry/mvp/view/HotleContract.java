package com.zxin.marry.mvp.view;

import android.content.Context;
import android.content.Intent;
import android.media.tv.TvContentRating;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.zxin.marry.R;
import com.zxin.marry.activity.AddShippingAddressActivity;
import com.zxin.marry.activity.BanquetHallActivity;
import com.zxin.marry.activity.BanquetHallDetailsActivity;
import com.zxin.marry.activity.DishesGoodsActivity;
import com.zxin.marry.activity.DishsListActivity;
import com.zxin.marry.activity.HotelCaseListActivity;
import com.zxin.marry.activity.HotelListActivity;
import com.zxin.marry.activity.ShopCaseDetailsActivity;
import com.zxin.marry.activity.ShopDetailsActivity;
import com.zxin.marry.activity.WeddingStoreDetailsActivity;
import com.zxin.marry.bean.AddressBean;
import com.zxin.marry.bean.BanquetBean;
import com.zxin.marry.bean.BanquetHallBean;
import com.zxin.marry.bean.BanquetListBean;
import com.zxin.marry.bean.CookbookBean;
import com.zxin.marry.bean.DishsListBean;
import com.zxin.marry.bean.GiftBean;
import com.zxin.marry.bean.GoodsDetailsBean;
import com.zxin.marry.bean.HotelBean;
import com.zxin.marry.bean.HotelCaseBean;
import com.zxin.marry.bean.HotelDetails;
import com.zxin.marry.bean.HotelListBean;
import com.zxin.marry.bean.HotelSearchBean;
import com.zxin.marry.bean.RecommendForm;
import com.zxin.marry.bean.RecommendHotelBean;
import com.zxin.marry.bean.ThreeHotelBean;
import com.zxin.marry.bean.WeddingMainBean;
import com.zxin.marry.mvp.presenter.HotlePresenter;
import com.zxin.marry.util.AdvItemClickListener;
import com.zxin.marry.util.StringUtils;
import com.zxin.marry.view.BannerHolderView;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.network.mvp.view.IBaseView;
import com.zxin.zxinlib.adapter.SimpleAdapter.SimpleAdapter;
import com.zxin.zxinlib.adapter.SimpleAdapter.TrdViewHolder;
import com.zxin.zxinlib.util.ImageUtil;
import com.zxin.zxinlib.util.SystemInfoUtil;
import com.zxin.zxinlib.util.UiUtils;
import com.zxin.zxinlib.view.CommonCrosswiseBar;
import com.zxin.zxinlib.view.RefreshCommonView;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/24.
 */

public class HotleContract implements IBaseView {
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

    private HotlePresenter presenter;

    @Override
    public void setP(BasePresenter... basePresenter) {
        presenter = (HotlePresenter) basePresenter[0];
    }

    @Override
    public void OnClick(View v) {

    }

    private FindHotleView iFindHotleView;

    public void setFindHotleViewListener(FindHotleView iFindHotleView) {
        this.iFindHotleView = iFindHotleView;
    }

    public interface FindHotleView {
        CommonCrosswiseBar getCommonCrosswiseBarView();

        ConvenientBanner getConvenientBannerView();

        RecyclerView getRecyclerView();

        EditText getEDTNameView();

        EditText getEDTPhoneView();

        TextView getTVSuccessView();

        TextView getTVAppdescView();

        LinearLayout getLLButtomView();

        LinearLayout getLLMoreView();

        RecyclerView getRecyclerHotleView();
    }

    private SimpleAdapter optionAdapter,hotelAdapter;
    private List<ThreeHotelBean.HotelBean> optionList = new ArrayList<>();
    private List<RecommendForm.RecommendAdv> adList = new ArrayList<>();
    private List<RecommendHotelBean.HotelRes> hotelList = new ArrayList<>();
    public void initFindHotleViewDatas() {
        iFindHotleView.getConvenientBannerView().startTurning(5000L).setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused}).setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
        iFindHotleView.getConvenientBannerView().setPages(new CBViewHolderCreator<BannerHolderView>() {
            @Override
            public BannerHolderView createHolder() {
                return new BannerHolderView();
            }
        }, adList);
        iFindHotleView.getConvenientBannerView().setOnItemClickListener(new AdvItemClickListener(mContext, adList));

        iFindHotleView.getRecyclerView().setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.VERTICAL));
        iFindHotleView.getRecyclerView().setNestedScrollingEnabled(false);
        optionAdapter = new SimpleAdapter<ThreeHotelBean.HotelBean>(mContext, optionList, R.layout.item_hotel_title) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final ThreeHotelBean.HotelBean localCircle) {
                holder.setText(R.id.tv_hotle_title, localCircle.getType());
                RecyclerView recyclerView = holder.getView(R.id.rv_hotle);
                recyclerView.setLayoutManager(UiUtils.getGridLayoutManager(4));
                recyclerView.setNestedScrollingEnabled(false);
                recyclerView.setAdapter(new SimpleAdapter<ThreeHotelBean.OptionBean>(mContext, localCircle.getOption(), R.layout.item_hotel_body) {
                    @Override
                    protected void onBindViewHolder(TrdViewHolder holder, final ThreeHotelBean.OptionBean optionBean) {
                        final Button hotel = holder.getView(R.id.item_hotel);
                        hotel.setText(optionBean.getName());
                        hotel.setSelected(optionBean.isChecked());

                        hotel.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View paramAnonymousView) {
                                if (hotel.isSelected()) {
                                    hotel.setSelected(false);
                                    optionBean.setChecked(false);
                                }else{
                                    hotel.setSelected(true);
                                    optionBean.setChecked(true);
                                }
                                notifyDataSetChanged();
                            }
                        });
                    }
                });
            }
        };
        iFindHotleView.getRecyclerView().setAdapter(optionAdapter);

        iFindHotleView.getRecyclerHotleView().setLayoutManager(UiUtils.getGridLayoutManager(3));
        iFindHotleView.getRecyclerHotleView().setNestedScrollingEnabled(false);
        hotelAdapter = new SimpleAdapter<RecommendHotelBean.HotelRes>(mContext, hotelList, R.layout.item_more_hotel) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final RecommendHotelBean.HotelRes localCircle) {
                holder.setText(R.id.tv_name, localCircle.getName());
                ImageUtil.loadImageViewLoding(mContext, localCircle.getCoverimage(), holder.<ImageView>getView(R.id.iv_logo), R.mipmap.default_iamge, R.mipmap.default_iamge);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, WeddingStoreDetailsActivity.class);
                        intent.putExtra("hotelid", localCircle.getId());
                        mContext.startActivity(intent);
                    }
                });
            }
        };
        iFindHotleView.getRecyclerHotleView().setAdapter(hotelAdapter);
    }

    public void onResultFindHotleDetailSuccess(Object obj) {
        if (obj == null)
            return;
        adList.clear();
        optionList.clear();
        ThreeHotelBean hotelBean = (ThreeHotelBean) obj;
        adList.addAll(hotelBean.getRecommend_adv());
        if (adList == null || adList.isEmpty()) {
            iFindHotleView.getConvenientBannerView().setVisibility(View.GONE);
        } else {
            iFindHotleView.getConvenientBannerView().setVisibility(View.VISIBLE);
            iFindHotleView.getConvenientBannerView().notifyDataSetChanged();
        }
        if (StringUtils.textIsEmpty(hotelBean.getAppdesc())) {
            iFindHotleView.getTVAppdescView().setVisibility(View.GONE);
        } else {
            iFindHotleView.getTVAppdescView().setText(hotelBean.getAppdesc());
            iFindHotleView.getTVAppdescView().setVisibility(View.VISIBLE);
        }
        optionList.addAll(hotelBean.getOptionList());
        if (optionList==null||optionList.isEmpty()) {
            iFindHotleView.getRecyclerView().setVisibility(View.GONE);
        } else {
            iFindHotleView.getRecyclerView().setVisibility(View.VISIBLE);
            optionAdapter.notifyDataSetChanged();
        }
    }

    public void onResultRecommendHotelListSuccess(Object obj) {
        if (obj == null)
            return;
        hotelList.clear();
        RecommendHotelBean hotelBean = (RecommendHotelBean) obj;
        hotelList.addAll(hotelBean.getHotelRes());
        if (hotelList==null||hotelList.isEmpty()) {
            iFindHotleView.getLLMoreView().setVisibility(View.GONE);
        } else {
            iFindHotleView.getLLMoreView().setVisibility(View.VISIBLE);
            hotelAdapter.notifyDataSetChanged();
        }
    }


    private StoreDetailsView iStoreDetailsView;

    public void setStoreDetailsViewListener(StoreDetailsView iStoreDetailsView) {
        this.iStoreDetailsView = iStoreDetailsView;
    }

    public interface StoreDetailsView {
        CommonCrosswiseBar getCommonCrosswiseBarView();
        ImageView getIVCoverimageView();
        TextView getTVHotelNameView();
        TextView getTVOptionPriceidView();
        TextView getTVShopAddressView();
        LinearLayout getLLGiftView();
        RecyclerView getRVGiftView();
        TextView getTVServiceChargeView();
        TextView getTVParkisFreeView();
        TextView getTVLawnView();
        TextView getTVCorkageFeeView();
        TextView getTVSlottingFeeView();
        TextView getTVWeddingRoomView();

        LinearLayout getLLGoodsView();
        TextView getTVGoodsCountView();
        RecyclerView getRVGoodsView();
        TextView getTVGoodsMoreView();

        LinearLayout getLLDishesView();
        TextView getTVDishesCountView();
        RecyclerView getRVDishesView();
        TextView getTVDishesMoreView();

        LinearLayout getLLCaseView();
        TextView getTVCaseCountView();
        RecyclerView getRVCaseView();
        TextView getTVCaseMoreView();

        TextView getTVIntroduceView();

        RecyclerView getRVIconView();

    }

    private String hotelId;
    public void setStoreDetailsViewParameter(Object... parameter){
        hotelId = (String) parameter[0];
    }

    private List<GiftBean> giftList = new ArrayList<>();
    private List<BanquetBean> banquetList = new ArrayList<>();
    private List<CookbookBean> dishesList = new ArrayList<>();
    private List<HotelDetails.JhxmsCase> caseList = new ArrayList<>();
    private List<HotelDetails.HotelBean.HotelImageBean> iconList = new ArrayList<>();
    private SimpleAdapter giftAdapter,banquetAdapter,dishesAdapter,caseAdapter,iconAdapter;
    public void initStoreDetailsViewDatas(){
        iStoreDetailsView.getRVGiftView().setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.VERTICAL));
        iStoreDetailsView.getRVGiftView().setNestedScrollingEnabled(false);
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
            }
        };
        iStoreDetailsView.getRVGiftView().setAdapter(giftAdapter);


        iStoreDetailsView.getRVGoodsView().setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.VERTICAL));
        iStoreDetailsView.getRVGoodsView().setNestedScrollingEnabled(false);
        banquetAdapter = new SimpleAdapter<BanquetBean>(mContext, banquetList, R.layout.item_banquet_hall) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final BanquetBean giftBean) {
                holder.setText(R.id.tv_goods_name, giftBean.getName())
                        .setText(R.id.tv_goods_price, giftBean.getOptiontableid())
                        .setText(R.id.tv_optiontableid, "厅高：" + giftBean.getBanquet_height() + "米  面积：" + giftBean.getBanquet_area() + "平米 柱子：" + giftBean.getColumn_sum());
                ImageUtil.loadImageViewLoding(mContext, giftBean.getBanquet_logo(), holder.<ImageView>getView(R.id.img_icon), R.mipmap.default_iamge);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent  intent = new Intent(mContext,BanquetHallDetailsActivity.class);
                        intent.putExtra("id", giftBean.getId());
                        mContext.startActivity(intent);
                    }
                });
            }
        };
        iStoreDetailsView.getRVGoodsView().setAdapter(banquetAdapter);


        iStoreDetailsView.getRVDishesView().setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.VERTICAL));
        iStoreDetailsView.getRVDishesView().setNestedScrollingEnabled(false);
        dishesAdapter = new SimpleAdapter<CookbookBean>(mContext, dishesList, R.layout.item_dishs) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final CookbookBean giftBean) {
                holder.setText(R.id.tv_name, giftBean.getName())
                        .setText(R.id.tv_price, "￥"+giftBean.getPrice()+ "元/桌");
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent  intent = new Intent(mContext, DishesGoodsActivity.class);
                        intent.putExtra("id", giftBean.getId());
                        mContext.startActivity(intent);
                    }
                });
            }
        };
        iStoreDetailsView.getRVDishesView().setAdapter(dishesAdapter);


        iStoreDetailsView.getRVCaseView().setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.VERTICAL));
        iStoreDetailsView.getRVCaseView().setNestedScrollingEnabled(false);
        caseAdapter = new SimpleAdapter<HotelDetails.JhxmsCase>(mContext, caseList, R.layout.item_hotel_case) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final HotelDetails.JhxmsCase giftBean) {
                holder.setText(R.id.tv_title, giftBean.getCase_title())
                        .setText(R.id.tv_hotelname, giftBean.getStore_name())
                        .setText(R.id.tv_count, giftBean.getCase_collect())
                        .setText(R.id.tv_price, StringUtils.textIsEmpty(giftBean.getPrice())?"暂无报价":"￥"+giftBean.getPrice());
                ImageUtil.loadImageViewLoding(mContext, giftBean.getCase_images(), holder.<ImageView>getView(R.id.iv_image), R.mipmap.default_iamge);

                holder.setOnClickListener(R.id.ll_hotel, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, ShopDetailsActivity.class);
                        intent.putExtra("store_id", giftBean.getStore_id());
                        mContext.startActivity(intent);
                    }
                });
                holder.setOnClickListener(R.id.rl_img, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, ShopCaseDetailsActivity.class);
                        intent.putExtra("case_id", giftBean.getCase_id());
                        mContext.startActivity(intent);
                    }
                });
            }
        };
        iStoreDetailsView.getRVCaseView().setAdapter(caseAdapter);


        iStoreDetailsView.getRVIconView().setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.VERTICAL));
        iStoreDetailsView.getRVIconView().setNestedScrollingEnabled(false);
        iconAdapter = new SimpleAdapter<HotelDetails.HotelBean.HotelImageBean>(mContext, iconList, R.layout.item_home_pic) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final HotelDetails.HotelBean.HotelImageBean product) {
                holder.setVisible(R.id.tv_content, false);
                ImageUtil.loadImageViewLoding(mContext, product.getImgsrc(), holder.<ImageView>getView(R.id.img_show), R.mipmap.default_iamge);
            }
        };
        iStoreDetailsView.getRVIconView().setAdapter(iconAdapter);

        iStoreDetailsView.getTVGoodsMoreView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //宴会厅 更多
                Intent intent = new Intent(mContext,BanquetHallActivity.class);
                intent.putExtra("hotelid",hotelId);
                mContext.startActivity(intent);
            }
        });

        iStoreDetailsView.getTVDishesMoreView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //菜单 更多
                Intent intent = new Intent(mContext,DishsListActivity.class);
                intent.putExtra("hotelid",hotelId);
                mContext.startActivity(intent);
            }
        });

        iStoreDetailsView.getTVCaseMoreView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //婚礼案例 更多
                Intent intent = new Intent(mContext,HotelCaseListActivity.class);
                intent.putExtra("hotelid",hotelId);
                mContext.startActivity(intent);
            }
        });
    }

    public void onResultWeddingDetailSuccess(Object obj) {
        if (obj == null)
            return;
        HotelDetails hotelDetails = (HotelDetails) obj;

        iStoreDetailsView.getCommonCrosswiseBarView().setTitleText(hotelDetails.getHotel().getName());
        if (hotelDetails.getHotel().getPrice_max().equals("0")) {
            iStoreDetailsView.getTVOptionPriceidView().setText("最低预订价格￥:" + hotelDetails.getHotel().getPrice_min() + "元");
        }else{
            iStoreDetailsView.getTVOptionPriceidView().setText("预订价格￥:" + hotelDetails.getHotel().getPrice_min() + "元~" + hotelDetails.getHotel().getPrice_max() + "元");
        }

        iStoreDetailsView.getTVServiceChargeView().setText(hotelDetails.getHotel().getServicecharge());
        iStoreDetailsView.getTVParkisFreeView().setText(hotelDetails.getHotel().getParkisfree());
        iStoreDetailsView.getTVLawnView().setText(hotelDetails.getHotel().getLawn());
        iStoreDetailsView.getTVCorkageFeeView().setText(hotelDetails.getHotel().getCorkagefee());
        iStoreDetailsView.getTVSlottingFeeView().setText(hotelDetails.getHotel().getSlottingfee());
        iStoreDetailsView.getTVWeddingRoomView().setText(hotelDetails.getHotel().getWeddingroom());
        iStoreDetailsView.getTVIntroduceView().setText(hotelDetails.getHotel().getIntroduce());
        iStoreDetailsView.getTVHotelNameView().setText(hotelDetails.getHotel().getName());
        iStoreDetailsView.getTVGoodsCountView().setText("(共" + hotelDetails.getHotel().getBanquet_count() + "个)");
        iStoreDetailsView.getTVDishesCountView().setText("(共" + hotelDetails.getHotel().getCookbook_count() + "种)");
        iStoreDetailsView.getTVCaseCountView().setText("("+hotelDetails.getJhxms_case_count()+")");
        iStoreDetailsView.getTVShopAddressView().setText(hotelDetails.getHotel().getAreaid()+ hotelDetails.getHotel().getAddress());
        ImageUtil.loadImageViewLoding(mContext, hotelDetails.getHotel().getCoverimage(), iStoreDetailsView.getIVCoverimageView(), R.mipmap.default_iamge, R.mipmap.default_iamge);
        iStoreDetailsView.getLLCaseView().setVisibility(hotelDetails.getJhxms_case_count().equals("0")?View.GONE:View.VISIBLE);

        iStoreDetailsView.getTVGoodsMoreView().setVisibility(Long.parseLong(hotelDetails.getHotel().getBanquet_count())<3?View.GONE:View.VISIBLE);
        iStoreDetailsView.getTVDishesCountView().setVisibility(Long.parseLong(hotelDetails.getHotel().getCookbook_count())<3?View.GONE:View.VISIBLE);
        iStoreDetailsView.getTVCaseCountView().setVisibility(Long.parseLong(hotelDetails.getJhxms_case_count())<3?View.GONE:View.VISIBLE);

        giftList.clear();
        giftList.addAll(hotelDetails.getGift());
        if (giftList==null||giftList.isEmpty()){
            iStoreDetailsView.getLLGiftView().setVisibility(View.GONE);
        }else{
            giftAdapter.notifyDataSetChanged();
            iStoreDetailsView.getLLGiftView().setVisibility(View.VISIBLE);
        }

        banquetList.clear();
        banquetList.addAll(hotelDetails.getBanquet());
        if (banquetList==null||banquetList.isEmpty()){
            iStoreDetailsView.getLLGoodsView().setVisibility(View.GONE);
        }else{
            banquetAdapter.notifyDataSetChanged();
            iStoreDetailsView.getLLGoodsView().setVisibility(View.VISIBLE);
        }

        dishesList.clear();
        dishesList.addAll(hotelDetails.getCookbook());
        if (dishesList==null||dishesList.isEmpty()){
            iStoreDetailsView.getLLDishesView().setVisibility(View.GONE);
        }else{
            dishesAdapter.notifyDataSetChanged();
            iStoreDetailsView.getLLDishesView().setVisibility(View.VISIBLE);
        }


        caseList.clear();
        caseList.addAll(hotelDetails.getJhxms_case());
        if (caseList==null||caseList.isEmpty()){
            iStoreDetailsView.getLLCaseView().setVisibility(View.GONE);
        }else{
            caseAdapter.notifyDataSetChanged();
            iStoreDetailsView.getLLCaseView().setVisibility(View.VISIBLE);
        }

        iconList.clear();
        iconList.addAll(hotelDetails.getHotel().getHotel_image());
        if (iconList==null||iconList.isEmpty()){
            iStoreDetailsView.getRVIconView().setVisibility(View.GONE);
        }else{
            iconAdapter.notifyDataSetChanged();
            iStoreDetailsView.getRVIconView().setVisibility(View.VISIBLE);
        }
    }


    private WeddingPartyView iWeddingPartyView;

    public void setWeddingPartyViewListener(WeddingPartyView iWeddingPartyView) {
        this.iWeddingPartyView = iWeddingPartyView;
    }

    public interface WeddingPartyView {
        RefreshCommonView getRefreshCommonView();
        ConvenientBanner getConvenientBannerView();
        RecyclerView getGVOptionsiteView();
        RecyclerView getRVAreaView();
    }
    private SimpleAdapter optionsiteAdapter,areaAdapter,weddingAdapter;
    private List<RecommendForm.RecommendAdv> adPartyList = new ArrayList<>();
    private List<WeddingMainBean.AreaBean> areaList = new ArrayList<>();
    private List<HotelBean> weddingList = new ArrayList<>();
    private List<WeddingMainBean.OptionsiteBean> optionsiteList = new ArrayList<>();
    public void initWeddingPartyViewDatas(){
        iWeddingPartyView.getConvenientBannerView().startTurning(5000L).setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused}).setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
        iWeddingPartyView.getConvenientBannerView().setPages(new CBViewHolderCreator<BannerHolderView>() {
            @Override
            public BannerHolderView createHolder() {
                return new BannerHolderView();
            }
        }, adPartyList);
        iWeddingPartyView.getConvenientBannerView().setOnItemClickListener(new AdvItemClickListener(mContext, adPartyList));

        weddingAdapter = new SimpleAdapter<HotelBean>(mContext, weddingList, R.layout.item_wedding_hotal) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final HotelBean hotelBean) {
                holder.setText(R.id.tv_goods_name, hotelBean.getName())
                        .setText(R.id.tv_goods_price, "￥"+hotelBean.getPrice_min()+"元起")
                        .setText(R.id.tv_areaid, hotelBean.getAreaid())
                        .setText(R.id.tv_table_max, "最大容纳桌数"+hotelBean.getTable_max()+"桌")
                        .setVisible(R.id.img_typea,hotelBean.getTypea() != 0)
                        .setVisible(R.id.img_typeb,hotelBean.getTypeb() != 0)
                        .setVisible(R.id.img_typec,hotelBean.getTypec() != 0);
                ImageUtil.loadImageViewLoding(mContext, hotelBean.getCoverimage(), holder.<ImageView>getView(R.id.img_icon), R.mipmap.default_iamge, R.mipmap.default_iamge);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, WeddingStoreDetailsActivity.class);
                        intent.putExtra("hotelid", hotelBean.getId());
                        mContext.startActivity(intent);
                    }
                });
            }
        };
        iWeddingPartyView.getRefreshCommonView().setRecyclerViewAdapter(weddingAdapter);
        iWeddingPartyView.getRefreshCommonView().setIsLoadMore(false);


        iWeddingPartyView.getGVOptionsiteView().setLayoutManager(UiUtils.getGridLayoutManager(4));
        iWeddingPartyView.getGVOptionsiteView().setNestedScrollingEnabled(false);
        optionsiteAdapter = new SimpleAdapter<WeddingMainBean.OptionsiteBean>(mContext, optionsiteList, R.layout.item_optionsite) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final WeddingMainBean.OptionsiteBean hotelBean) {
                holder.setText(R.id.tv_name, hotelBean.getName());
                ImageUtil.loadImageViewLoding(mContext, hotelBean.getLogo(), holder.<ImageView>getView(R.id.img_icon), R.mipmap.default_iamge, R.mipmap.default_iamge);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, HotelListActivity.class);
                        intent.putExtra("id", hotelBean.getId());
                        intent.putExtra("type", "1");
                        mContext.startActivity(intent);
                    }
                });
            }
        };
        iWeddingPartyView.getGVOptionsiteView().setAdapter(optionsiteAdapter);


        iWeddingPartyView.getRVAreaView().setLayoutManager(UiUtils.getGridLayoutManager(4));
        iWeddingPartyView.getRVAreaView().setNestedScrollingEnabled(false);
        areaAdapter = new SimpleAdapter<WeddingMainBean.AreaBean>(mContext, areaList, R.layout.item_area) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final WeddingMainBean.AreaBean hotelBean) {
                holder.setText(R.id.tv_area_name, hotelBean.getName());
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, HotelListActivity.class);
                        intent.putExtra("id", hotelBean.getId());
                        intent.putExtra("type", "0");
                        mContext.startActivity(intent);
                    }
                });
            }
        };
        iWeddingPartyView.getRVAreaView().setAdapter(areaAdapter);



        iWeddingPartyView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {
            @Override
            public void startRefresh() {
                presenter.getWeddingParty();
            }

            @Override
            public void startLoadMore() {

            }
        });
    }

    public void onResultWeddingPartySuccess(Object obj) {
        iWeddingPartyView.getRefreshCommonView().finishRefresh();
        iWeddingPartyView.getRefreshCommonView().finishLoadMore();
        if (obj == null)
            return;
        WeddingMainBean weddingMain = (WeddingMainBean)obj;
        adPartyList.clear();
        adPartyList.addAll(weddingMain.getRecommend_adv());
        if (adPartyList==null||adPartyList.isEmpty()){
            iWeddingPartyView.getConvenientBannerView().setVisibility(View.GONE);
        }else{
            iWeddingPartyView.getConvenientBannerView().setVisibility(View.VISIBLE);
            iWeddingPartyView.getConvenientBannerView().notifyDataSetChanged();
        }

        areaList.clear();
        areaList.addAll(weddingMain.getArea());
        areaAdapter.notifyDataSetChanged();

        optionsiteList.clear();
        optionsiteList.addAll(weddingMain.getOptionsite());
        optionsiteAdapter.notifyDataSetChanged();

        weddingList.clear();
        weddingList.addAll(weddingMain.getHotel());
        if (this.weddingList == null || this.weddingList.isEmpty()) {
            this.weddingList.clear();
            iWeddingPartyView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iWeddingPartyView.getRefreshCommonView().setIsEmpty(false);
            iWeddingPartyView.getRefreshCommonView().setIsLoadMore(false);
        }
        weddingAdapter.notifyDataSetChanged();
    }


    private HotelListView iHotelListView;

    public void setHotelListViewListener(HotelListView iHotelListView) {
        this.iHotelListView = iHotelListView;
    }

    public interface HotelListView{
        DrawerLayout getDrawerLayoutView();
        CommonCrosswiseBar getCommonCrosswiseBarView();

        LinearLayout getLLOrderDefaultView();
        TextView getTVOrderDefaultView();
        View getOrderDefaultView();

        LinearLayout getLLOrderPriceView();
        ImageView getIVOrderPriceView();
        TextView getTVOrderPriceView();
        View getOrderPriceView();

        LinearLayout getLLOrderDeskView();
        ImageView getIVOrderDeskView();
        TextView getTVOrderDeskView();
        View getOrderDeskView();

        LinearLayout getLLOrderChooseView();
        TextView getTVOrderChooseView();
        View getOrderChooseView();

        RefreshCommonView getRefreshCommonView();

        LinearLayout getLLRightView();
        RecyclerView getRVRightView();
        TextView getTVChooseResertView();
        TextView getTVChooseConfirmView();
    }

    private String areaid,optionsiteid;
    public void setHotelListViewParameter(Object... parameter) {
        String id = (String) parameter[0];
        String type = (String) parameter[1];
        if (type.equals("0")) {
            areaid = id;
            optionsiteid=null;
        } else if (type.equals("1")) {
            areaid = null;
            optionsiteid=id;
        }
    }

    private String operator = "default";
    private List<HotelBean> hotelsList = new ArrayList<>();
    private List<HotelSearchBean.Searcher> searcherList = new ArrayList<>();
    private SimpleAdapter hotelsAdapter,searcherAdapter;
    private String areaId = "";
    private String optionsiteId = "";
    private String optiontableId = "";
    private String optionPriceId = "";
    public void initHotelListViewDatas(){
        iHotelListView.getDrawerLayoutView().setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

        hotelsAdapter = new SimpleAdapter<HotelBean>(mContext, hotelsList, R.layout.item_wedding_hotal) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final HotelBean hotelBean) {
                holder.setText(R.id.tv_goods_name, hotelBean.getName())
                        .setText(R.id.tv_goods_price, "￥"+hotelBean.getPrice_min()+"元起")
                        .setText(R.id.tv_areaid, hotelBean.getAreaid())
                        .setText(R.id.tv_table_max, "最大容纳桌数"+hotelBean.getTable_max()+"桌")
                        .setVisible(R.id.img_typea,hotelBean.getTypea() != 0)
                        .setVisible(R.id.img_typeb,hotelBean.getTypeb() != 0)
                        .setVisible(R.id.img_typec,hotelBean.getTypec() != 0);
                ImageUtil.loadImageViewLoding(mContext, hotelBean.getCoverimage(), holder.<ImageView>getView(R.id.img_icon), R.mipmap.default_iamge, R.mipmap.default_iamge);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, WeddingStoreDetailsActivity.class);
                        intent.putExtra("hotelid", hotelBean.getId());
                        mContext.startActivity(intent);
                    }
                });
            }
        };
        iHotelListView.getRefreshCommonView().setRecyclerViewAdapter(hotelsAdapter);
        iHotelListView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {
            private int pageNum=1;
            @Override
            public void startRefresh() {
                pageNum = 1;
                hotelsList.clear();
                areaId = StringUtils.textIsEmpty(areaId)?null:areaId;
                optionsiteId = StringUtils.textIsEmpty(optionsiteId)?null:optionsiteId;
                optiontableId = StringUtils.textIsEmpty(optiontableId)?null:optiontableId;
                optionPriceId = StringUtils.textIsEmpty(areaId)?null:optionPriceId;
                presenter.getHotelList(areaid,optionsiteid,priceSort,optionsiteId,optiontableId,optionPriceId,areaId,tableMax,pageNum,"up",null);
            }

            @Override
            public void startLoadMore() {
                areaId = StringUtils.textIsEmpty(areaId)?null:areaId;
                optionsiteId = StringUtils.textIsEmpty(optionsiteId)?null:optionsiteId;
                optiontableId = StringUtils.textIsEmpty(optiontableId)?null:optiontableId;
                optionPriceId = StringUtils.textIsEmpty(areaId)?null:optionPriceId;
                presenter.getHotelList(areaid,optionsiteid,priceSort,optionsiteId,optiontableId,optionPriceId,areaId,tableMax,++pageNum,"down",searchBean.getPage().getPagetime());
            }
        });


        iHotelListView.getRVRightView().setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.VERTICAL));
        searcherAdapter = new SimpleAdapter<HotelSearchBean.Searcher>(mContext, searcherList, R.layout.item_hotel_title) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final HotelSearchBean.Searcher localCircle) {
                holder.setText(R.id.tv_hotle_title, localCircle.getTitle());
                RecyclerView recyclerView = holder.getView(R.id.rv_hotle);
                recyclerView.setLayoutManager(UiUtils.getGridLayoutManager(4));
                recyclerView.setNestedScrollingEnabled(false);
                recyclerView.setAdapter(new SimpleAdapter<HotelSearchBean.Option>(mContext, localCircle.getList(), R.layout.item_hotel_body) {
                    @Override
                    protected void onBindViewHolder(TrdViewHolder holder, final HotelSearchBean.Option optionBean) {
                        final Button hotel = holder.getView(R.id.item_hotel);
                        hotel.setText(optionBean.getName());
                        hotel.setSelected(optionBean.isChecked());

                        hotel.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View paramAnonymousView) {
                                boolean bool = hotel.isSelected();
                                hotel.setSelected(!bool);
                                optionBean.setChecked(!bool);
                            }
                        });
                    }
                });
            }
        };
        iHotelListView.getRVRightView().setAdapter(searcherAdapter);


        iHotelListView.getLLOrderDefaultView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifyTitle("default");
                iHotelListView.getRefreshCommonView().notifyData();
            }
        });

        iHotelListView.getLLOrderPriceView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifyTitle("price");
                iHotelListView.getRefreshCommonView().notifyData();
            }
        });

        iHotelListView.getLLOrderDeskView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifyTitle("desk");
                iHotelListView.getRefreshCommonView().notifyData();
            }
        });

        iHotelListView.getLLOrderChooseView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifyTitle("choose");
            }
        });

        iHotelListView.getTVChooseResertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                areaId  ="";
                optionsiteId  ="";
                optiontableId  ="";
                optionPriceId  ="";
                for (HotelSearchBean.Searcher searcher :searcherList){
                    for (HotelSearchBean.Option option: searcher.getList()){
                        option.setChecked(false);
                    }
                }
                searcherAdapter.notifyDataSetChanged();
            }
        });

        iHotelListView.getTVChooseConfirmView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iHotelListView.getDrawerLayoutView().closeDrawer(GravityCompat.END);
                for (HotelSearchBean.Searcher searcher :searcherList){
                    if (searcher.getTitle().equals("位置区域")){
                        JSONArray jsonArray = new JSONArray();
                        for (HotelSearchBean.Option option: searcher.getList()){
                            if (option.isChecked()){
                                jsonArray.put(option.getId());
                            }
                        }
                        if (jsonArray==null)
                            areaId = "";
                        else
                            areaId = jsonArray.toString();
                    }
                    if (searcher.getTitle().equals("场地类型")){
                        JSONArray jsonArray = new JSONArray();
                        for (HotelSearchBean.Option option: searcher.getList()){
                            if (option.isChecked()){
                                jsonArray.put(option.getId());
                            }
                        }
                        if (jsonArray==null)
                            optionsiteId = "";
                        else
                            optionsiteId = jsonArray.toString();
                    }
                    if (searcher.getTitle().equals("容纳桌数")){
                        JSONArray jsonArray = new JSONArray();
                        for (HotelSearchBean.Option option: searcher.getList()){
                            if (option.isChecked()){
                                jsonArray.put(option.getId());
                            }
                        }
                        if (jsonArray==null)
                            optiontableId = "";
                        else
                            optiontableId = jsonArray.toString();
                    }
                    if (searcher.getTitle().equals("每桌价格")){
                        JSONArray jsonArray = new JSONArray();
                        for (HotelSearchBean.Option option: searcher.getList()){
                            if (option.isChecked()){
                                jsonArray.put(option.getId());
                            }
                        }
                        if (jsonArray==null)
                            optionPriceId = "";
                        else
                            optionPriceId = jsonArray.toString();
                    }
                }
                iHotelListView.getRefreshCommonView().notifyData();
            }
        });
    }

    private String priceSort = "1";
    private String tableMax = "1";
    private void notifyTitle(String flag){
        switch (flag){

            case "default":
                if (operator.equals(flag))
                    return;
                iHotelListView.getTVOrderDefaultView().setTextColor(UiUtils.getColor(R.color.red_light));
                iHotelListView.getTVOrderPriceView().setTextColor(UiUtils.getColor(R.color.color_666666));
                iHotelListView.getTVOrderDeskView().setTextColor(UiUtils.getColor(R.color.color_666666));
                iHotelListView.getTVOrderChooseView().setTextColor(UiUtils.getColor(R.color.color_666666));

                iHotelListView.getOrderDefaultView().setBackgroundColor(UiUtils.getColor(R.color.red_light));
                iHotelListView.getOrderPriceView().setBackgroundColor(UiUtils.getColor(R.color.line_color));
                iHotelListView.getOrderDeskView().setBackgroundColor(UiUtils.getColor(R.color.line_color));
                iHotelListView.getOrderChooseView().setBackgroundColor(UiUtils.getColor(R.color.line_color));

                iHotelListView.getIVOrderPriceView().setImageDrawable(UiUtils.getDrawable(R.drawable.icon_choose_deout));
                iHotelListView.getIVOrderDeskView().setImageDrawable(UiUtils.getDrawable(R.drawable.icon_choose_deout));
                operator = "default";
                priceSort="1";
                tableMax="1";
                areaId  ="";
                optionsiteId  ="";
                optiontableId  ="";
                optionPriceId  ="";
                break;

            case "price":
                if (priceSort.equals("1")){
                    iHotelListView.getIVOrderPriceView().setImageDrawable(UiUtils.getDrawable(R.drawable.icon_choose_down));
                    priceSort = "2";
                }else{
                    iHotelListView.getIVOrderPriceView().setImageDrawable(UiUtils.getDrawable(R.drawable.icon_choose_up));
                    priceSort = "1";
                }
                if (operator.equals("price"))
                    return;
                iHotelListView.getTVOrderDefaultView().setTextColor(UiUtils.getColor(R.color.color_666666));
                iHotelListView.getTVOrderPriceView().setTextColor(UiUtils.getColor(R.color.red_light));
                iHotelListView.getTVOrderDeskView().setTextColor(UiUtils.getColor(R.color.color_666666));
                iHotelListView.getTVOrderChooseView().setTextColor(UiUtils.getColor(R.color.color_666666));

                iHotelListView.getOrderDefaultView().setBackgroundColor(UiUtils.getColor(R.color.line_color));
                iHotelListView.getOrderPriceView().setBackgroundColor(UiUtils.getColor(R.color.red_light));
                iHotelListView.getOrderDeskView().setBackgroundColor(UiUtils.getColor(R.color.line_color));
                iHotelListView.getOrderChooseView().setBackgroundColor(UiUtils.getColor(R.color.line_color));

                iHotelListView.getIVOrderDeskView().setImageDrawable(UiUtils.getDrawable(R.drawable.icon_choose_deout));

                operator = "price";
                tableMax="1";
                break;

            case "desk":
                if (tableMax.equals("1")){
                    iHotelListView.getIVOrderDeskView().setImageDrawable(UiUtils.getDrawable(R.drawable.icon_choose_down));
                    tableMax="2";
                }else{
                    iHotelListView.getIVOrderDeskView().setImageDrawable(UiUtils.getDrawable(R.drawable.icon_choose_up));
                    tableMax="1";
                }
                if (operator.equals("desk"))
                    return;
                iHotelListView.getTVOrderDefaultView().setTextColor(UiUtils.getColor(R.color.color_666666));
                iHotelListView.getTVOrderPriceView().setTextColor(UiUtils.getColor(R.color.color_666666));
                iHotelListView.getTVOrderDeskView().setTextColor(UiUtils.getColor(R.color.red_light));
                iHotelListView.getTVOrderChooseView().setTextColor(UiUtils.getColor(R.color.color_666666));

                iHotelListView.getOrderDefaultView().setBackgroundColor(UiUtils.getColor(R.color.line_color));
                iHotelListView.getOrderPriceView().setBackgroundColor(UiUtils.getColor(R.color.line_color));
                iHotelListView.getOrderDeskView().setBackgroundColor(UiUtils.getColor(R.color.red_light));
                iHotelListView.getOrderChooseView().setBackgroundColor(UiUtils.getColor(R.color.line_color));

                iHotelListView.getIVOrderPriceView().setImageDrawable(UiUtils.getDrawable(R.drawable.icon_choose_deout));
                operator = "desk";
                priceSort="1";
                break;

            case "choose":
                if (!iHotelListView.getDrawerLayoutView().isDrawerOpen(GravityCompat.END)) {
                    iHotelListView.getDrawerLayoutView().openDrawer(GravityCompat.END);
                }
                if (operator.equals(flag))
                    return;
                iHotelListView.getTVOrderChooseView().setTextColor(UiUtils.getColor(R.color.red_light));
                iHotelListView.getTVOrderPriceView().setTextColor(UiUtils.getColor(R.color.color_666666));
                iHotelListView.getTVOrderDeskView().setTextColor(UiUtils.getColor(R.color.color_666666));
                iHotelListView.getTVOrderDefaultView().setTextColor(UiUtils.getColor(R.color.color_666666));

                iHotelListView.getOrderDefaultView().setBackgroundColor(UiUtils.getColor(R.color.line_color));
                iHotelListView.getOrderPriceView().setBackgroundColor(UiUtils.getColor(R.color.line_color));
                iHotelListView.getOrderDeskView().setBackgroundColor(UiUtils.getColor(R.color.line_color));
                iHotelListView.getOrderChooseView().setBackgroundColor(UiUtils.getColor(R.color.red_light));

                operator = "choose";
                break;

        }
    }

    private HotelListBean searchBean;
    public void onResultHotelListSuccess(Object obj){
        iHotelListView.getRefreshCommonView().finishRefresh();
        iHotelListView.getRefreshCommonView().finishLoadMore();
        if (obj==null)
            return;
        searchBean = (HotelListBean)obj;
        hotelsList.addAll(searchBean.getHotel());

        if (this.hotelsList == null || this.hotelsList.isEmpty()) {
            this.hotelsList.clear();
            iHotelListView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iHotelListView.getRefreshCommonView().setIsEmpty(false);
            iHotelListView.getRefreshCommonView().setIsLoadMore(searchBean.getHotel().size()==searchBean.getPage().getPagenumber());
        }
        hotelsAdapter.notifyDataSetChanged();
    }

    public void onResultHoteSearchSuccess(Object obj){
        if (obj==null)
            return;
        HotelSearchBean searchBean = (HotelSearchBean)obj;
        searcherList.clear();
        searcherList.addAll(searchBean.getSearcherList());
        searcherAdapter.notifyDataSetChanged();
    }


    private HallDetailsView iHallDetailsView;

    public void setHallDetailsViewListener(HallDetailsView iHallDetailsView) {
        this.iHallDetailsView = iHallDetailsView;
    }

    public interface HallDetailsView{
        CommonCrosswiseBar getCommonCrosswiseBarView();
        ImageView getIVLogoView();
        TextView getTVOptionfeatureView();
        TextView getTVOptiontableView();
        TextView getTVBanquetAreaView();
        TextView getTVBanquetHeightView();
        TextView getTVColumnSumView();
        TextView getTVStageLongView();
        TextView getTVStageWideView();
        TextView getTVIntroduceView();
        LinearLayout getLLGiftView();
        RecyclerView getRVGiftView();
        RecyclerView getRVIconView();
    }

    private String id;
    public void setHallDetailsViewParameter(Object... parameter) {
        id = (String) parameter[0];
    }

    private List<GiftBean> giftHalList = new ArrayList<>();
    private List<BanquetHallBean.BanquetBean.BanquetImageBean> iconHallList = new ArrayList<>();
    private SimpleAdapter giftHallAdapter,iconHallAdapter;
    public void initHallDetailsViewDatas() {
        iHallDetailsView.getRVGiftView().setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.VERTICAL));
        iHallDetailsView.getRVGiftView().setNestedScrollingEnabled(false);
        giftHallAdapter = new SimpleAdapter<GiftBean>(mContext, giftHalList, R.layout.item_gift) {
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
            }
        };
        iHallDetailsView.getRVGiftView().setAdapter(giftHallAdapter);

        iHallDetailsView.getRVIconView().setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.VERTICAL));
        iHallDetailsView.getRVIconView().setNestedScrollingEnabled(false);
        iconHallAdapter = new SimpleAdapter<BanquetHallBean.BanquetBean.BanquetImageBean>(mContext, iconHallList, R.layout.item_home_pic) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final BanquetHallBean.BanquetBean.BanquetImageBean product) {
                holder.setVisible(R.id.tv_content, false);
                ImageUtil.loadImageViewLoding(mContext, product.getImgsrc(), holder.<ImageView>getView(R.id.img_show), R.mipmap.default_iamge);
            }
        };
        iHallDetailsView.getRVIconView().setAdapter(iconHallAdapter);
    }

    public void onResultBanquetHallDetailsSuccess(Object obj){
        if (obj==null)
            return;
        BanquetHallBean hallBean = (BanquetHallBean)obj;
        iHallDetailsView.getCommonCrosswiseBarView().setTitleText(hallBean.getBanquet().getName());
        iHallDetailsView.getTVIntroduceView().setText(hallBean.getBanquet().getHotel_desc());
        iHallDetailsView.getTVOptionfeatureView().setText(hallBean.getBanquet().getName());
        iHallDetailsView.getTVOptiontableView().setText("桌数："+hallBean.getBanquet().getOptiontableid());
        iHallDetailsView.getTVBanquetAreaView().setText("面积："+hallBean.getBanquet().getBanquet_area() + " ㎡");
        iHallDetailsView.getTVBanquetHeightView().setText("层高："+hallBean.getBanquet().getBanquet_height() + " m");
        iHallDetailsView.getTVColumnSumView().setText("立柱："+hallBean.getBanquet().getColumn_sum());
        iHallDetailsView.getTVStageLongView().setText("形状："+hallBean.getBanquet().getBanquet_shape());
        iHallDetailsView.getTVStageWideView().setText("舞台："+hallBean.getBanquet().getStage_long() + " X "+hallBean.getBanquet().getStage_wide());
        ImageUtil.loadImageViewLoding(mContext, hallBean.getBanquet().getBanquet_logo(), iHallDetailsView.getIVLogoView(), R.mipmap.default_iamge);

        if (hallBean.getGift()==null||hallBean.getGift().isEmpty()){
            iHallDetailsView.getLLGiftView().setVisibility(View.GONE);
        }else {
            giftHalList.clear();
            giftHalList.addAll(hallBean.getGift());
            iHallDetailsView.getLLGiftView().setVisibility(View.VISIBLE);
            giftHallAdapter.notifyDataSetChanged();
        }
        iconHallList.clear();
        iconHallList.addAll(hallBean.getBanquet().getBanquet_image());
        if (iconHallList==null||iconHallList.isEmpty()){
            iHallDetailsView.getRVIconView().setVisibility(View.GONE);
        }else{
            iHallDetailsView.getRVIconView().setVisibility(View.VISIBLE);
            iconHallAdapter.notifyDataSetChanged();
        }
    }


    private BanquetHallView iBanquetHallView;
    public void setBanquetHallViewListener(BanquetHallView iBanquetHallView) {
        this.iBanquetHallView = iBanquetHallView;
    }
    public interface BanquetHallView{
        RefreshCommonView getRefreshCommonView();
    }
    public void setBanquetHallViewParameter(Object... parameter) {
        hotelId = (String) parameter[0];
    }
    private  List<BanquetBean> banquetHallList = new ArrayList();
    private SimpleAdapter banquetHallAdapter;
    public void initBanquetHallViewDatas() {
        banquetHallAdapter = new SimpleAdapter<BanquetBean>(mContext, banquetHallList, R.layout.item_banquet_hall) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final BanquetBean banquetBean) {
                holder.setText(R.id.tv_goods_name, banquetBean.getName())
                        .setText(R.id.tv_goods_price, banquetBean.getOptiontableid())
                        .setText(R.id.tv_optiontableid, "厅高：" + banquetBean.getBanquet_height() + "米  面积：" + banquetBean.getBanquet_area() + "平米 柱子：" + banquetBean.getColumn_sum());
                ImageUtil.loadImageViewLoding(mContext, banquetBean.getBanquet_logo(), holder.<ImageView>getView(R.id.img_icon), R.mipmap.default_iamge);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent  intent = new Intent(mContext,BanquetHallDetailsActivity.class);
                        intent.putExtra("id", banquetBean.getId());
                        mContext.startActivity(intent);
                    }
                });
            }
        };
        iBanquetHallView.getRefreshCommonView().setRecyclerViewAdapter(banquetHallAdapter);
        iBanquetHallView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {
            private int pageNum=1;
            @Override
            public void startRefresh() {
                pageNum=1;
                banquetHallList.clear();
                presenter.getBanquetMoreList(hotelId,pageNum,"up",null);
            }

            @Override
            public void startLoadMore() {
                presenter.getBanquetMoreList(hotelId,++pageNum,"down",banquetListBean.getPage().getPagetime());
            }
        });
    }
    private  BanquetListBean banquetListBean;
    public void onResultBanquetHallMoreSuccess(Object obj) {
        iBanquetHallView.getRefreshCommonView().finishRefresh();
        iBanquetHallView.getRefreshCommonView().finishLoadMore();
        if (obj == null)
            return;
        banquetHallList.clear();
        banquetListBean = (BanquetListBean)obj;
        banquetHallList.addAll(banquetListBean.getBanquet());
        if (this.banquetHallList == null || this.banquetHallList.isEmpty()) {
            this.banquetHallList.clear();
            iBanquetHallView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iBanquetHallView.getRefreshCommonView().setIsEmpty(false);
            iBanquetHallView.getRefreshCommonView().setIsLoadMore(banquetListBean.getBanquet().size()==banquetListBean.getPage().getPagenumber());
        }
        banquetHallAdapter.notifyDataSetChanged();
    }


    private CaseListView iCaseListView;
    public void setCaseListViewListener(CaseListView iCaseListView) {
        this.iCaseListView = iCaseListView;
    }
    public interface CaseListView{
        RefreshCommonView getRefreshCommonView();
    }

    public void setCaseListViewParameter(Object... parameter) {
        hotelId = (String) parameter[0];
    }
    private ArrayList<HotelDetails.JhxmsCase> caseMoreList = new ArrayList<>();
    private SimpleAdapter caseListAdapter;
    public void initCaseListViewDatas() {
        caseListAdapter = new SimpleAdapter<HotelDetails.JhxmsCase>(mContext, caseMoreList, R.layout.item_hotel_case) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final HotelDetails.JhxmsCase jhxmsCase) {
                holder.setText(R.id.tv_title, jhxmsCase.getCase_title())
                        .setText(R.id.tv_hotelname, jhxmsCase.getStore_name())
                        .setText(R.id.tv_count, jhxmsCase.getCase_collect())
                        .setText(R.id.tv_price, StringUtils.textIsEmpty(jhxmsCase.getPrice())?"暂无报价":"￥"+jhxmsCase.getPrice());
                ImageUtil.loadImageViewLoding(mContext, jhxmsCase.getCase_images(), holder.<ImageView>getView(R.id.iv_image), R.mipmap.default_iamge);

                holder.setOnClickListener(R.id.ll_hotel, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, ShopDetailsActivity.class);
                        intent.putExtra("store_id", jhxmsCase.getStore_id());
                        mContext.startActivity(intent);
                    }
                });
                holder.setOnClickListener(R.id.rl_img, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, ShopCaseDetailsActivity.class);
                        intent.putExtra("case_id", jhxmsCase.getCase_id());
                        mContext.startActivity(intent);
                    }
                });
            }
        };
        iCaseListView.getRefreshCommonView().setRecyclerViewAdapter(caseListAdapter);
        iCaseListView.getRefreshCommonView().setIsLoadMore(false);
        iCaseListView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {
            @Override
            public void startRefresh() {
                presenter.getCaseMoreList(hotelId);
            }

            @Override
            public void startLoadMore() {

            }
        });
    }

    public void onResultCaseListMoreSuccess(Object obj) {
        iCaseListView.getRefreshCommonView().finishRefresh();
        iCaseListView.getRefreshCommonView().finishLoadMore();
        if (obj == null)
            return;
        caseMoreList.clear();
        HotelCaseBean listBean = (HotelCaseBean)obj;
        caseMoreList.addAll(listBean.getCaselist());
        if (this.caseMoreList == null || this.caseMoreList.isEmpty()) {
            this.caseMoreList.clear();
            iCaseListView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iCaseListView.getRefreshCommonView().setIsEmpty(false);
            iCaseListView.getRefreshCommonView().setIsLoadMore(false);
        }
        caseListAdapter.notifyDataSetChanged();
    }


    private DishsListView iDishsListView;
    public void setDishsListViewListener(DishsListView iDishsListView) {
        this.iDishsListView = iDishsListView;
    }
    public interface DishsListView{
        RefreshCommonView getRefreshCommonView();
    }
    public void setDishsListViewParameter(Object... parameter) {
        hotelId = (String) parameter[0];
    }
    private  List<CookbookBean> dishsList = new ArrayList();
    private SimpleAdapter dishsListAdapter;
    public void initDishsListViewDatas() {
        dishsListAdapter = new SimpleAdapter<CookbookBean>(mContext, dishsList, R.layout.item_dishs) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final CookbookBean cookBean) {
                holder.setText(R.id.tv_name, cookBean.getName())
                        .setText(R.id.tv_price, "￥"+cookBean.getPrice()+ "元/桌");
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent  intent = new Intent(mContext, DishesGoodsActivity.class);
                        intent.putExtra("id", cookBean.getId());
                        mContext.startActivity(intent);
                    }
                });
            }
        };
        iDishsListView.getRefreshCommonView().setRecyclerViewAdapter(dishsListAdapter);
        iDishsListView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {
            private int pageNum=1;
            @Override
            public void startRefresh() {
                pageNum=1;
                dishsList.clear();
                presenter.getDishsMoreList(hotelId,pageNum,"up",null);
            }

            @Override
            public void startLoadMore() {
                presenter.getDishsMoreList(hotelId,++pageNum,"down",dishsListBean.getPage().getPagetime());
            }
        });
    }

    private DishsListBean dishsListBean;
    public void onResultDishsListMoreSuccess(Object obj) {
        iDishsListView.getRefreshCommonView().finishRefresh();
        iDishsListView.getRefreshCommonView().finishLoadMore();
        if (obj == null)
            return;
        dishsList.clear();
        dishsListBean = (DishsListBean)obj;
        dishsList.addAll(dishsListBean.getBanquet());
        if (this.dishsList == null || this.dishsList.isEmpty()) {
            this.dishsList.clear();
            iDishsListView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iDishsListView.getRefreshCommonView().setIsEmpty(false);
            iHotelListView.getRefreshCommonView().setIsLoadMore(dishsListBean.getBanquet().size()==dishsListBean.getPage().getPagenumber());
        }
        dishsListAdapter.notifyDataSetChanged();
    }


}

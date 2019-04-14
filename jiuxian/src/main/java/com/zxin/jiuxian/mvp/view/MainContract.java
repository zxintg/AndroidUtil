package com.zxin.jiuxian.mvp.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.zxin.basemodel.util.HtmlJumpUtil;
import com.zxin.jiuxian.R;
import com.zxin.jiuxian.activity.ProductDetailActivity;
import com.zxin.jiuxian.adapter.BannerHolderView;
import com.zxin.jiuxian.bean.CatePageResult;
import com.zxin.jiuxian.bean.CircleActInfoResult;
import com.zxin.jiuxian.bean.HomeHeaderResult;
import com.zxin.jiuxian.bean.HomeTabIconResult;
import com.zxin.jiuxian.bean.HomeWineListResult;
import com.zxin.jiuxian.bean.LaunchPageInfoResult;
import com.zxin.jiuxian.bean.MainBarBean;
import com.zxin.jiuxian.bean.SeckillInfoHomeResult;
import com.zxin.jiuxian.mvp.presenter.MainPresenter;
import com.zxin.jiuxian.util.AdvItemClickListener;
import com.zxin.jiuxian.util.HtmlJiuXianJumpUtil;
import com.zxin.jiuxian.util.StringUtils;
import com.zxin.jiuxian.util.TitleBarUtil;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.network.mvp.view.IBaseView;
import com.zxin.root.adapter.simple.SimpleAdapter;
import com.zxin.root.adapter.simple.TrdViewHolder;
import com.zxin.root.adapter.VerBannerAdapter;
import com.zxin.root.adapter.ViewPageFragmentAdapter;
import com.zxin.root.bean.VerticalBanner;
import com.zxin.root.util.ImageUtil;
import com.zxin.root.util.SelectorUtil;
import com.zxin.root.util.SystemInfoUtil;
import com.zxin.root.util.UiUtils;
import com.zxin.root.view.MyViewPager;
import com.zxin.root.view.RefreshCommonView;
import com.zxin.root.view.banner.BaseBannerAdapter;
import com.zxin.root.view.banner.VerticalBannerView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/5/24.
 */

public class MainContract implements IBaseView {
    private Context mContext;
    private FragmentManager manager;

    @Override
    public void setParameter(Object... parameter) {
        manager = (FragmentManager) parameter[0];
    }

    private List<CatePageResult.CateBannerItem> bannerList1 = new ArrayList<>();
    private List<CatePageResult.CateBannerItem> bannerList2 = new ArrayList<>();
    private List<CatePageResult.CateBannerItem> bannerList3 = new ArrayList<>();
    private List<CatePageResult.CateBannerItem> bannerList4 = new ArrayList<>();
    private List<CatePageResult.CateBannerItem> bannerList5 = new ArrayList<>();
    private List<CatePageResult.CateBannerItem> bannerList6 = new ArrayList<>();

    private SimpleAdapter mainAdapter1, mainAdapter2, mainAdapter3, mainAdapter4, mainAdapter5, mainAdapter6;
    private List<HomeHeaderResult.HeaderAd> adteList1 = new ArrayList<>();
    private List<HomeHeaderResult.HeaderAd> adteList3 = new ArrayList<>();
    private List<HomeHeaderResult.HomeProduct> productList = new ArrayList<>();
    private List<HomeHeaderResult.Advertising> adteList4 = new ArrayList<>();
    private List<HomeHeaderResult.HeaderAd> adteList5 = new ArrayList<>();
    private List<HomeWineListResult.HomeWineListItem> adteList6 = new ArrayList<>();

    @Override
    public void initDatas() {
        iJiuXianMainView.getMainhomeTitleView().setPadding(iJiuXianMainView.getMainhomeTitleView().getPaddingLeft(), iJiuXianMainView.getMainhomeTitleView().getPaddingTop() + SystemInfoUtil.getStatusBarHeight(), iJiuXianMainView.getMainhomeTitleView().getPaddingRight(), iJiuXianMainView.getMainhomeTitleView().getPaddingBottom());

        iJiuXianMainView.mian_child_1().startTurning(3000L).setPageIndicator(new int[]{R.drawable.community_experence_point_unreached, R.drawable.community_experence_point_reached}).setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
        iJiuXianMainView.mian_child_1().setPages(new CBViewHolderCreator<BannerHolderView>() {
            @Override
            public BannerHolderView createHolder() {
                return new BannerHolderView();
            }
        }, bannerList1);
        iJiuXianMainView.mian_child_1().setOnItemClickListener(new AdvItemClickListener(mContext, bannerList1));


        mainAdapter1 = new SimpleAdapter<HomeHeaderResult.HeaderAd>(mContext, adteList1, R.layout.item_chassify_child) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final HomeHeaderResult.HeaderAd cate) {
                ImageUtil.loadImageViewLoding(mContext, cate.adImg, holder.<ImageView>getView(R.id.item_image), R.mipmap.default_iamge, R.drawable.icon_nullcate);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        HtmlJumpUtil.toWebForUrlActivity(cate.adTitle, cate.adLink);
                    }
                });
            }
        };
        iJiuXianMainView.mian_child_2().setLayoutManager(UiUtils.getGridLayoutManager(5));
        iJiuXianMainView.mian_child_2().setNestedScrollingEnabled(false);
        iJiuXianMainView.mian_child_2().setAdapter(mainAdapter1);


        mainAdapter2 = new SimpleAdapter<HomeHeaderResult.HomeProduct>(mContext, productList, R.layout.item_phone_only) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final HomeHeaderResult.HomeProduct cate) {
                holder.setText(R.id.promTitle, cate.promTitle)
                        .setText(R.id.item_phone_only_name, cate.proName)
                        .setText(R.id.item_phone_only_price, StringUtils.formatPriceA(cate.proPrice))
                        .setText(R.id.item_jiuxian_price, StringUtils.formatPriceA(cate.jxPrice))
                        .setVisible(R.id.promTitle, StringUtils.textIsEmpty(cate.promTitle));
                holder.<TextView>getView(R.id.item_jiuxian_price).getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                ImageUtil.loadImageViewLoding(mContext, cate.proImg, holder.<ImageView>getView(R.id.item_phone_only_img), R.mipmap.default_iamge, R.drawable.icon_nullcate);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
            }
        };
        iJiuXianMainView.mian_child_6().setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.HORIZONTAL));
        iJiuXianMainView.mian_child_6().setAdapter(mainAdapter2);

        iJiuXianMainView.mian_child_7().startTurning(3000L).setPageIndicator(new int[]{R.drawable.community_experence_point_unreached, R.drawable.community_experence_point_reached}).setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
        iJiuXianMainView.mian_child_7().setPages(new CBViewHolderCreator<BannerHolderView>() {
            @Override
            public BannerHolderView createHolder() {
                return new BannerHolderView();
            }
        }, bannerList2);
        iJiuXianMainView.mian_child_7().setOnItemClickListener(new AdvItemClickListener(mContext, bannerList2));

        iJiuXianMainView.mian_child_8().startTurning(3000L).setPageIndicator(new int[]{R.drawable.community_experence_point_unreached, R.drawable.community_experence_point_reached}).setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
        iJiuXianMainView.mian_child_8().setPages(new CBViewHolderCreator<BannerHolderView>() {
            @Override
            public BannerHolderView createHolder() {
                return new BannerHolderView();
            }
        }, bannerList3);
        iJiuXianMainView.mian_child_8().setOnItemClickListener(new AdvItemClickListener(mContext, bannerList3));

        mainAdapter3 = new SimpleAdapter<HomeHeaderResult.HeaderAd>(mContext, adteList3, R.layout.part_item_ad_jingxuan_channel_title) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final HomeHeaderResult.HeaderAd cate) {
                ImageUtil.loadImageViewLoding(mContext, cate.adImg, holder.<ImageView>getView(R.id.iv_image), R.mipmap.default_iamge, R.drawable.icon_nullcate);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, ProductDetailActivity.class);
                        intent.putExtra("proId", String.valueOf(cate.advertisingId));
                        mContext.startActivity(intent);
                    }
                });
            }
        };
        iJiuXianMainView.mian_child_10().setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.HORIZONTAL));
        iJiuXianMainView.mian_child_10().setAdapter(mainAdapter3);

        iJiuXianMainView.mian_child_11().startTurning(3000L).setPageIndicator(new int[]{R.drawable.community_experence_point_unreached, R.drawable.community_experence_point_reached}).setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
        iJiuXianMainView.mian_child_11().setPages(new CBViewHolderCreator<BannerHolderView>() {
            @Override
            public BannerHolderView createHolder() {
                return new BannerHolderView();
            }
        }, bannerList4);
        iJiuXianMainView.mian_child_11().setOnItemClickListener(new AdvItemClickListener(mContext, bannerList4));

        mainAdapter4 = new SimpleAdapter<HomeHeaderResult.Advertising>(mContext, adteList4, R.layout.item_home_ads) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final HomeHeaderResult.Advertising cate) {
                ImageUtil.loadImageViewLoding(mContext, cate.mTitle.adImg, holder.<ImageView>getView(R.id.item_ads_title), R.mipmap.default_iamge, R.drawable.icon_nullcate);
                final List<HomeHeaderResult.HeaderAd> list = cate.mDataList;
                ImageUtil.loadImageViewLoding(mContext, list.get(0).adImg, holder.<ImageView>getView(R.id.item_ads_image1), R.mipmap.default_iamge, R.drawable.icon_nullcate);
                if (list.size() > 1) {
                    ImageUtil.loadImageViewLoding(mContext, list.get(1).adImg, holder.<ImageView>getView(R.id.item_ads_image2_1), R.mipmap.default_iamge, R.drawable.icon_nullcate);
                    holder.setVisible(R.id.item_ads_image2, true);
                    if (list.size() > 2) {
                        ImageUtil.loadImageViewLoding(mContext, list.get(2).adImg, holder.<ImageView>getView(R.id.item_ads_image2_3), R.mipmap.default_iamge, R.drawable.icon_nullcate);
                        holder.setVisible(R.id.item_ads_image2_2, true);
                        if (list.size() > 3) {
                            ImageUtil.loadImageViewLoding(mContext, list.get(3).adImg, holder.<ImageView>getView(R.id.item_ads_image2_4), R.mipmap.default_iamge, R.drawable.icon_nullcate);
                            holder.setVisible(R.id.item_ads_image2_4, true);
                        } else {
                            holder.setVisible(R.id.item_ads_image2_4, false);
                        }
                    } else {
                        holder.setVisible(R.id.item_ads_image2_2, false);
                    }
                } else {
                    holder.setVisible(R.id.item_ads_image2, false);
                }

                RecyclerView recyclerView = holder.getView(R.id.item_ads_logos);
                recyclerView.setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.HORIZONTAL));
                recyclerView.setAdapter(new SimpleAdapter<HomeHeaderResult.HeaderAd>(mContext, cate.mLogoList, R.layout.item_home_logo) {
                    @Override
                    protected void onBindViewHolder(TrdViewHolder holder, final HomeHeaderResult.HeaderAd cate) {
                        ImageUtil.loadImageViewLoding(mContext, cate.adImg, holder.<ImageView>getView(R.id.iv_image), R.mipmap.default_iamge, R.drawable.icon_nullcate);
                        holder.setOnItemListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });
                    }
                });

                holder.setOnClickListener(R.id.item_ads_image1, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        HtmlJumpUtil.toWebForUrlActivity(list.get(0).adTitle, list.get(0).adLink);
                    }
                });

                holder.setOnClickListener(R.id.item_ads_image2_1, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        HtmlJumpUtil.toWebForUrlActivity(list.get(1).adTitle, list.get(1).adLink);
                    }
                });

                holder.setOnClickListener(R.id.item_ads_image2_3, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        HtmlJumpUtil.toWebForUrlActivity(list.get(2).adTitle, list.get(2).adLink);
                    }
                });

                holder.setOnClickListener(R.id.item_ads_image2_4, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        HtmlJumpUtil.toWebForUrlActivity(list.get(3).adTitle, list.get(3).adLink);
                    }
                });

                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
            }
        };
        iJiuXianMainView.mian_child_14().setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.VERTICAL));
        iJiuXianMainView.mian_child_14().setNestedScrollingEnabled(false);
        iJiuXianMainView.mian_child_14().setAdapter(mainAdapter4);

        iJiuXianMainView.mian_child_13().startTurning(3000L).setPageIndicator(new int[]{R.drawable.community_experence_point_unreached, R.drawable.community_experence_point_reached}).setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
        iJiuXianMainView.mian_child_13().setPages(new CBViewHolderCreator<BannerHolderView>() {
            @Override
            public BannerHolderView createHolder() {
                return new BannerHolderView();
            }
        }, bannerList5);
        iJiuXianMainView.mian_child_13().setOnItemClickListener(new AdvItemClickListener(mContext, bannerList5));

        iJiuXianMainView.mian_child_15().startTurning(3000L).setPageIndicator(new int[]{R.drawable.community_experence_point_unreached, R.drawable.community_experence_point_reached}).setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
        iJiuXianMainView.mian_child_15().setPages(new CBViewHolderCreator<BannerHolderView>() {
            @Override
            public BannerHolderView createHolder() {
                return new BannerHolderView();
            }
        }, bannerList6);
        iJiuXianMainView.mian_child_15().setOnItemClickListener(new AdvItemClickListener(mContext, bannerList6));

        mainAdapter5 = new SimpleAdapter<HomeHeaderResult.HeaderAd>(mContext, adteList5, R.layout.item_home_street) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final HomeHeaderResult.HeaderAd cate) {
                ImageUtil.loadImageViewLoding(mContext, cate.adImg, holder.<ImageView>getView(R.id.item_street), R.mipmap.default_iamge, R.drawable.icon_nullcate);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        HtmlJumpUtil.toWebForUrlActivity(cate.adTitle, cate.adLink);
                    }
                });
            }
        };
        iJiuXianMainView.mian_child_16_1().setLayoutManager(UiUtils.getGridLayoutManager(2));
        iJiuXianMainView.mian_child_16_1().setNestedScrollingEnabled(false);
        iJiuXianMainView.mian_child_16_1().setAdapter(mainAdapter5);


        mainAdapter6 = new SimpleAdapter<HomeWineListResult.HomeWineListItem>(mContext, adteList6, R.layout.item_homelist_with_head) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final HomeWineListResult.HomeWineListItem cate) {
                holder.setText(R.id.tv_proName, cate.proName);
                ImageUtil.loadImageViewLoding(mContext, cate.proImg, holder.<ImageView>getView(R.id.iv_proImg), R.mipmap.default_iamge, R.drawable.icon_nullcate);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, ProductDetailActivity.class);
                        intent.putExtra("proId", String.valueOf(cate.proId));
                        mContext.startActivity(intent);
                    }
                });
            }
        };
        iJiuXianMainView.getRefreshCommonView().setRecyclerViewAdapter(mainAdapter6);
        iJiuXianMainView.getRefreshCommonView().setIsAutoLoad(false);
        iJiuXianMainView.getRefreshCommonView().setIsLoadMore(false);
        iJiuXianMainView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {

            @Override
            public void startRefresh() {
                pageNum = 1;
                bannerList1.clear();
                bannerList2.clear();
                bannerList3.clear();
                bannerList4.clear();
                bannerList5.clear();
                bannerList6.clear();
                adteList1.clear();
                adteList3.clear();
                productList.clear();
                adteList4.clear();
                adteList5.clear();
                adteList6.clear();
           /*   iJiuXianMainView.mian_child_1().removeAllViews();
                iJiuXianMainView.mian_child_7().removeAllViews();
                iJiuXianMainView.mian_child_8().removeAllViews();
                iJiuXianMainView.mian_child_11().removeAllViews();
                iJiuXianMainView.mian_child_13().removeAllViews();
                iJiuXianMainView.mian_child_15().removeAllViews();*/
                presenter.getHomePageInfoAmend();
                presenter.getMiaoPaiProForIndex();
                presenter.getCircleActInfo();
            }

            @Override
            public void startLoadMore() {
                presenter.recommend(proIds, String.valueOf(++pageNum));
            }
        });
    }

    @Override
    public void loadDatas() {

    }

    private String proIds = "";
    private int pageNum = 1;

    @Override
    public void onResultSuccess(Object bean) {
        iJiuXianMainView.getRefreshCommonView().finishRefresh();
        iJiuXianMainView.getRefreshCommonView().finishLoadMore();
        if (bean == null)
            return;
        if (bean instanceof HomeHeaderResult) {
            HomeHeaderResult headerResult = (HomeHeaderResult) bean;
            final Map<Integer, HomeHeaderResult.HeaderData> headMap = headerResult.getHomeDatasMap();
            if (headMap.containsKey(1)) {
                bannerList1.clear();
                bannerList1.addAll(headMap.get(1).getBannerList());
                iJiuXianMainView.mian_child_1().setVisibility(View.VISIBLE);
                iJiuXianMainView.mian_child_1().notifyDataSetChanged();
            } else {
                iJiuXianMainView.mian_child_1().setVisibility(View.GONE);
            }
            if (headMap.containsKey(2)) {
                adteList1.clear();
                adteList1.addAll(headMap.get(2).itemList);
                mainAdapter1.notifyDataSetChanged();
                iJiuXianMainView.mian_child_2().setVisibility(View.VISIBLE);
            } else {
                iJiuXianMainView.mian_child_2().setVisibility(View.GONE);
            }
            if (headMap.containsKey(3)) {
                ImageUtil.loadImageViewLoding(mContext, headMap.get(3).itemList.get(0).adImg, iJiuXianMainView.mian_child_3_1(), R.mipmap.default_iamge, R.drawable.icon_nullcate);
                iJiuXianMainView.mian_child_3_1().setVisibility(View.VISIBLE);
            } else {
                iJiuXianMainView.mian_child_3_1().setVisibility(View.GONE);
            }
            if (headMap.containsKey(4)) {
                List<HomeHeaderResult.HeaderAd> imageList = headMap.get(4).itemList;
                ImageUtil.loadImageViewLoding(mContext, imageList.get(0).adImg, iJiuXianMainView.mian_child_3_2(), R.mipmap.default_iamge, R.drawable.icon_nullcate);
                iJiuXianMainView.mian_child_3_2().setVisibility(View.VISIBLE);

                if (imageList.size() > 1) {
                    ImageUtil.loadImageViewLoding(mContext, imageList.get(1).adImg, iJiuXianMainView.mian_child_3_3(), R.mipmap.default_iamge, R.drawable.icon_nullcate);
                    iJiuXianMainView.mian_child_3_3().setVisibility(View.VISIBLE);
                } else {
                    iJiuXianMainView.mian_child_3_3().setVisibility(View.GONE);
                }

            } else {
                iJiuXianMainView.mian_child_3_2().setVisibility(View.GONE);
                iJiuXianMainView.mian_child_3_3().setVisibility(View.GONE);
            }
            if (headMap.containsKey(5)) {
                List<HomeHeaderResult.HeaderAd> imageList = headMap.get(5).itemList;
                ImageUtil.loadImageViewLoding(mContext, imageList.get(0).adImg, iJiuXianMainView.mian_child_3_4(), R.mipmap.default_iamge, R.drawable.icon_nullcate);
                iJiuXianMainView.mian_child_3_4().setVisibility(View.VISIBLE);

                if (imageList.size() > 1) {
                    ImageUtil.loadImageViewLoding(mContext, imageList.get(1).adImg, iJiuXianMainView.mian_child_3_5(), R.mipmap.default_iamge, R.drawable.icon_nullcate);
                    iJiuXianMainView.mian_child_3_5().setVisibility(View.VISIBLE);
                } else {
                    iJiuXianMainView.mian_child_3_5().setVisibility(View.GONE);
                }

                if (imageList.size() > 2) {
                    ImageUtil.loadImageViewLoding(mContext, imageList.get(2).adImg, iJiuXianMainView.mian_child_3_6(), R.mipmap.default_iamge, R.drawable.icon_nullcate);
                    iJiuXianMainView.mian_child_3_6().setVisibility(View.VISIBLE);
                } else {
                    iJiuXianMainView.mian_child_3_6().setVisibility(View.GONE);
                }
            } else {
                iJiuXianMainView.mian_child_3_4().setVisibility(View.GONE);
                iJiuXianMainView.mian_child_3_5().setVisibility(View.GONE);
                iJiuXianMainView.mian_child_3_6().setVisibility(View.GONE);
            }

            if (headMap.containsKey(7)) {
                ImageUtil.loadImageViewLoding(mContext, headMap.get(7).itemList.get(0).headImgUrl, iJiuXianMainView.mian_child_4_1(), R.mipmap.default_iamge, R.drawable.icon_nullcate);
                final List<VerticalBanner> bannerList = headMap.get(7).getVerBannerList();
                BaseBannerAdapter adapter = new VerBannerAdapter(mContext, bannerList);
                adapter.setOnBannerClickListener(new BaseBannerAdapter.OnBannerClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        VerticalBanner banner = bannerList.get(position);
                        HtmlJiuXianJumpUtil.toJiuXianWebForUrlActivity(banner.getTitle(), banner.getLineUrl());
                    }
                });
                iJiuXianMainView.mian_child_4_2().setAdapter(adapter);
                iJiuXianMainView.mian_child_4_2().start();

                iJiuXianMainView.mian_child_4().setVisibility(View.VISIBLE);
            } else {
                iJiuXianMainView.mian_child_4().setVisibility(View.GONE);
            }

            if (headMap.containsKey(10)) {
                bannerList2.clear();
                bannerList2.addAll(headMap.get(10).getBannerList());
                iJiuXianMainView.mian_child_7().notifyDataSetChanged();
                iJiuXianMainView.mian_child_7().setVisibility(View.VISIBLE);
            } else {
                iJiuXianMainView.mian_child_7().setVisibility(View.GONE);
            }

            if (headMap.containsKey(11)) {
                bannerList3.clear();
                bannerList3.addAll(headMap.get(11).getBannerList());
                iJiuXianMainView.mian_child_8().notifyDataSetChanged();
                iJiuXianMainView.mian_child_8().setVisibility(View.VISIBLE);
            } else {
                iJiuXianMainView.mian_child_8().setVisibility(View.GONE);
            }

            if (headMap.containsKey(13)) {
                final List<HomeHeaderResult.HeaderAd> data = headMap.get(13).itemList;
                ImageUtil.loadImageViewLoding(mContext, data.get(0).adImg, iJiuXianMainView.mian_child_9_1(), R.mipmap.default_iamge, R.drawable.icon_nullcate);
                iJiuXianMainView.mian_child_9_1().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        HtmlJumpUtil.toWebForUrlActivity(data.get(0).adTitle, data.get(0).adLink);
                    }
                });

                ImageUtil.loadImageViewLoding(mContext, data.get(1).adImg, iJiuXianMainView.mian_child_9_2(), R.mipmap.default_iamge, R.drawable.icon_nullcate);
                iJiuXianMainView.mian_child_9_2().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        HtmlJumpUtil.toWebForUrlActivity(data.get(1).adTitle, data.get(1).adLink);
                    }
                });
                ImageUtil.loadImageViewLoding(mContext, data.get(2).adImg, iJiuXianMainView.mian_child_9_3(), R.mipmap.default_iamge, R.drawable.icon_nullcate);
                iJiuXianMainView.mian_child_9_3().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        HtmlJumpUtil.toWebForUrlActivity(data.get(2).adTitle, data.get(2).adLink);
                    }
                });
                iJiuXianMainView.mian_child_9_1().setVisibility(View.VISIBLE);
            } else {
                iJiuXianMainView.mian_child_9_1().setVisibility(View.GONE);
            }

            if (headMap.containsKey(14)) {
                adteList3.clear();
                adteList3.addAll(headMap.get(14).itemList);
                mainAdapter3.notifyDataSetChanged();
                iJiuXianMainView.mian_child_10().setVisibility(View.VISIBLE);
            } else {
                iJiuXianMainView.mian_child_10().setVisibility(View.GONE);
            }

            if (headMap.containsKey(16)) {
                bannerList4.clear();
                bannerList4.addAll(headMap.get(16).getBannerList());
                iJiuXianMainView.mian_child_11().notifyDataSetChanged();
                iJiuXianMainView.mian_child_11().setVisibility(View.VISIBLE);
            } else {
                iJiuXianMainView.mian_child_11().setVisibility(View.GONE);
            }

            if (headMap.containsKey(18)) {
                ImageUtil.loadImageViewLoding(mContext, headMap.get(18).itemList.get(0).adImg, iJiuXianMainView.mian_child_12_1(), R.mipmap.default_iamge, R.drawable.icon_nullcate);
                iJiuXianMainView.mian_child_12_1().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        HtmlJumpUtil.toWebForUrlActivity(headMap.get(18).itemList.get(0).adTitle, headMap.get(18).itemList.get(0).adLink);
                    }
                });
            } else {
                iJiuXianMainView.mian_child_11().setVisibility(View.GONE);
            }

            if (headMap.containsKey(20)) {
                ImageUtil.loadImageViewLoding(mContext, headMap.get(20).itemList.get(0).adImg, iJiuXianMainView.mian_child_12_2(), R.mipmap.default_iamge, R.drawable.icon_nullcate);
                iJiuXianMainView.mian_child_12_2().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        HtmlJumpUtil.toWebForUrlActivity(headMap.get(20).itemList.get(0).adTitle, headMap.get(20).itemList.get(0).adLink);
                    }
                });
                ImageUtil.loadImageViewLoding(mContext, headMap.get(20).itemList.get(1).adImg, iJiuXianMainView.mian_child_12_3(), R.mipmap.default_iamge, R.drawable.icon_nullcate);
                iJiuXianMainView.mian_child_12_3().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        HtmlJumpUtil.toWebForUrlActivity(headMap.get(20).itemList.get(1).adTitle, headMap.get(20).itemList.get(1).adLink);
                    }
                });
            }

            if (headMap.containsKey(22)) {
                ImageUtil.loadImageViewLoding(mContext, headMap.get(22).itemList.get(0).adImg, iJiuXianMainView.mian_child_12_4(), R.mipmap.default_iamge, R.drawable.icon_nullcate);
                iJiuXianMainView.mian_child_12_4().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        HtmlJumpUtil.toWebForUrlActivity(headMap.get(22).itemList.get(0).adTitle, headMap.get(22).itemList.get(0).adLink);
                    }
                });
                ImageUtil.loadImageViewLoding(mContext, headMap.get(22).itemList.get(1).adImg, iJiuXianMainView.mian_child_12_5(), R.mipmap.default_iamge, R.drawable.icon_nullcate);
                iJiuXianMainView.mian_child_12_5().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        HtmlJumpUtil.toWebForUrlActivity(headMap.get(22).itemList.get(1).adTitle, headMap.get(22).itemList.get(1).adLink);
                    }
                });
                ImageUtil.loadImageViewLoding(mContext, headMap.get(22).itemList.get(2).adImg, iJiuXianMainView.mian_child_12_6(), R.mipmap.default_iamge, R.drawable.icon_nullcate);
                iJiuXianMainView.mian_child_12_6().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        HtmlJumpUtil.toWebForUrlActivity(headMap.get(22).itemList.get(2).adTitle, headMap.get(22).itemList.get(2).adLink);
                    }
                });
            }

            if (headMap.containsKey(23)) {
                bannerList5.clear();
                bannerList5.addAll(headMap.get(23).getBannerList());
                iJiuXianMainView.mian_child_13().notifyDataSetChanged();
                iJiuXianMainView.mian_child_13().setVisibility(View.VISIBLE);
            } else {
                iJiuXianMainView.mian_child_13().setVisibility(View.GONE);
            }

            adteList4.clear();
            adteList4.addAll(headerResult.getAdvertisingList());
            if (adteList4 == null || adteList4.isEmpty()) {
                iJiuXianMainView.mian_child_14().setVisibility(View.GONE);
            } else {
                iJiuXianMainView.mian_child_14().setVisibility(View.VISIBLE);
                mainAdapter4.notifyDataSetChanged();
            }

            if (headMap.containsKey(54)) {
                bannerList6.clear();
                bannerList6.addAll(headMap.get(54).getBannerList());
                iJiuXianMainView.mian_child_15().notifyDataSetChanged();
                iJiuXianMainView.mian_child_15().setVisibility(View.VISIBLE);
            } else {
                iJiuXianMainView.mian_child_15().setVisibility(View.GONE);
            }

            if (headMap.containsKey(56)) {
                ImageUtil.loadImageViewLoding(mContext, headMap.get(56).itemList.get(0).adImg, iJiuXianMainView.mian_child_16(), R.mipmap.default_iamge, R.drawable.icon_nullcate);
                iJiuXianMainView.mian_child_16().setVisibility(View.VISIBLE);
            } else {
                iJiuXianMainView.mian_child_16().setVisibility(View.GONE);
            }

            if (headMap.containsKey(58)) {
                adteList5.clear();
                adteList5.addAll(headMap.get(58).itemList);
                mainAdapter5.notifyDataSetChanged();
                iJiuXianMainView.mian_child_16_1().setVisibility(View.VISIBLE);
            } else {
                iJiuXianMainView.mian_child_16_1().setVisibility(View.GONE);
            }

            if (headMap.containsKey(61)) {
                iJiuXianMainView.ll_title_layout().removeAllViews();
                iJiuXianMainView.ll_title_layout().setVisibility(View.VISIBLE);
                iJiuXianMainView.user_home_content().setVisibility(View.VISIBLE);
                iJiuXianMainView.ll_title_layout().setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                        HomeHeaderResult.HeaderAd ad = (HomeHeaderResult.HeaderAd) group.findViewById(checkedId).getTag();
                        proIds = String.valueOf(ad.dealType);
                        adteList6.clear();
                        pageNum = 1;
                        presenter.recommend(proIds, String.valueOf(pageNum));
                    }
                });
                List<HomeHeaderResult.HeaderAd> adList = headMap.get(61).itemList;
                for (HomeHeaderResult.HeaderAd title : adList) {
                    RadioButton radioButton = new RadioButton(mContext);
                    RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.MATCH_PARENT, 100);
                    layoutParams.weight = 1;
                    radioButton.setGravity(Gravity.CENTER);
                    radioButton.setLayoutParams(layoutParams);
                    //radioButton.setPadding(20, 30, 20, 30);
                    radioButton.setText(title.adTitle);
                    radioButton.setBackground(UiUtils.getDrawable(R.drawable.selector_product_tab));
                    radioButton.setTextColor(UiUtils.getColorStateList(R.color.order_tab_item_selector));
                    radioButton.setTextSize(15);
                    radioButton.setButtonDrawable(null);
                    radioButton.setTag(title);
                    iJiuXianMainView.ll_title_layout().addView(radioButton);
                    radioButton.setChecked(adList.indexOf(title) == 0);
                }
            } else {
                iJiuXianMainView.ll_title_layout().setVisibility(View.GONE);
                iJiuXianMainView.user_home_content().setVisibility(View.GONE);
            }

        }

        if (bean instanceof SeckillInfoHomeResult) {
            HomeHeaderResult.Seckill seckill = ((SeckillInfoHomeResult) bean).seckillInfoForIndex;
            if (seckill != null) {
                iJiuXianMainView.mian_child_5().setVisibility(View.VISIBLE);
                iJiuXianMainView.mian_child_5_1().setText(seckill.adTitle);
                productList.clear();
                productList.addAll(seckill.proList);
                mainAdapter2.notifyDataSetChanged();
            } else
                iJiuXianMainView.mian_child_5().setVisibility(View.GONE);
        }

        if (bean instanceof CircleActInfoResult) {
            final CircleActInfoResult actInfoResult = (CircleActInfoResult) bean;
            if (actInfoResult.circlePo != null && !StringUtils.textIsEmpty(actInfoResult.circlePo.adImg)) {
                iJiuXianMainView.iv_circleactinfo().setVisibility(View.VISIBLE);
                ImageUtil.loadImageViewLoding(mContext, actInfoResult.circlePo.adImg, iJiuXianMainView.iv_circleactinfo(), R.mipmap.default_iamge, R.drawable.icon_nullcate);
                iJiuXianMainView.iv_circleactinfo().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        HtmlJiuXianJumpUtil.toWebForUrlActivity(actInfoResult.circlePo.adTitle, actInfoResult.circlePo.adLink);
                    }
                });
            } else {
                iJiuXianMainView.iv_circleactinfo().setVisibility(View.GONE);
            }
        }

        if (bean instanceof HomeWineListResult) {
            HomeWineListResult actInfoResult = (HomeWineListResult) bean;
            if (actInfoResult.list != null && !actInfoResult.list.isEmpty()) {
                iJiuXianMainView.ll_title_layout().setVisibility(View.VISIBLE);
                iJiuXianMainView.user_home_content().setVisibility(View.VISIBLE);
                adteList6.addAll(actInfoResult.list);
                if (adteList6 == null || adteList6.isEmpty()) {
                    adteList6.clear();
                    iJiuXianMainView.getRefreshCommonView().setIsEmpty(true);
                } else {
                    iJiuXianMainView.getRefreshCommonView().setIsEmpty(false);
                    iJiuXianMainView.getRefreshCommonView().setIsLoadMore(pageNum < actInfoResult.pageCount);
                }
                mainAdapter6.notifyDataSetChanged();
            } else {
                iJiuXianMainView.ll_title_layout().setVisibility(View.GONE);
                iJiuXianMainView.user_home_content().setVisibility(View.GONE);
            }
        }
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

    private MainPresenter presenter;

    @Override
    public void setP(BasePresenter... basePresenter) {
        presenter = (MainPresenter) basePresenter[0];
    }

    @Override
    public void OnClick(View v) {

    }

    private JiuXianMainView iJiuXianMainView;

    public void setJiuXianMainViewListener(JiuXianMainView iJiuXianMainView) {
        this.iJiuXianMainView = iJiuXianMainView;
    }

    public interface JiuXianMainView {
        RefreshCommonView getRefreshCommonView();

        RelativeLayout getMainhomeTitleView();

        RelativeLayout getCaptureWineBubbleView();

        ImageView iv_back_top();

        ImageView iv_circleactinfo();

        ConvenientBanner mian_child_1();

        RecyclerView mian_child_2();

        LinearLayout mian_child_3();

        ImageView mian_child_3_1();

        ImageView mian_child_3_2();

        ImageView mian_child_3_3();

        ImageView mian_child_3_4();

        ImageView mian_child_3_5();

        ImageView mian_child_3_6();

        LinearLayout mian_child_4();

        ImageView mian_child_4_1();

        VerticalBannerView mian_child_4_2();

        LinearLayout mian_child_5();

        TextView mian_child_5_1();

        LinearLayout mian_child_5_2();

        TextView mian_child_5_3();

        RecyclerView mian_child_6();

        ConvenientBanner mian_child_7();

        ConvenientBanner mian_child_8();

        LinearLayout mian_child_9();

        ImageView mian_child_9_1();

        ImageView mian_child_9_2();

        ImageView mian_child_9_3();

        RecyclerView mian_child_10();

        ConvenientBanner mian_child_11();

        ImageView mian_child_12_1();

        ImageView mian_child_12_2();

        ImageView mian_child_12_3();

        ImageView mian_child_12_4();

        ImageView mian_child_12_5();

        ImageView mian_child_12_6();

        ConvenientBanner mian_child_13();

        RecyclerView mian_child_14();

        ConvenientBanner mian_child_15();

        ImageView mian_child_16();

        RecyclerView mian_child_16_1();

        RadioGroup ll_title_layout();

        RecyclerView user_home_content();
    }


    private MainBannerView iMainBannerView;

    public void setMainBannerViewListener(MainBannerView iMainBannerView) {
        this.iMainBannerView = iMainBannerView;
    }

    public interface MainBannerView {
        MyViewPager getViewPagerView();

        RadioGroup getRadioGroupView();
    }

    public void initMainDatas() {

    }

    private ArrayList<MainBarBean> titleList = new ArrayList<>();
    private List<Fragment> mFragmentList = new ArrayList<>();//页卡视图集合
    private ViewPageFragmentAdapter pageAdapter;
    public void onResultTabMainIconSuccess(Object bean) {
        if (bean == null)
            return;
        HomeTabIconResult tabIconResult = (HomeTabIconResult)bean;
        mFragmentList.clear();
        iMainBannerView.getRadioGroupView().removeAllViews();
        iMainBannerView.getViewPagerView().removeAllViews();
        titleList.addAll(TitleBarUtil.newInstance().getBarTitleList(tabIconResult.navList));
        int width = 2*(SystemInfoUtil.getScreenWidth()/titleList.size())/3;
        for (MainBarBean title : titleList) {
            RadioButton radioButton = new RadioButton(mContext);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.MATCH_PARENT, width);
            layoutParams.weight = 1;
            radioButton.setGravity(Gravity.CENTER_HORIZONTAL);
            radioButton.setLayoutParams(layoutParams);
            radioButton.setBackground(null);
            radioButton.setTag(title.index);
            if (StringUtils.textIsEmpty(title.labSourceUrl_press)||StringUtils.textIsEmpty(title.labSourceUrl_normal)) {
                Drawable drawable = UiUtils.getDrawable(title.labSource);
                radioButton.setButtonDrawable(drawable);
            }else{
                SelectorUtil.addSeletorFromNet(title.labSourceUrl_normal,title.labSourceUrl_press,SystemInfoUtil.dip2px(width*3/2),SystemInfoUtil.dip2px(width),radioButton);
            }
            iMainBannerView.getRadioGroupView().addView(radioButton);
            radioButton.setChecked(title.index == 0);
            mFragmentList.add(title.fragment);
        }

        pageAdapter = new ViewPageFragmentAdapter(mFragmentList, titleList);
        iMainBannerView.getViewPagerView().setAdapter(pageAdapter);
        iMainBannerView.getViewPagerView().setOffscreenPageLimit(titleList.size());

        iMainBannerView.getViewPagerView().setCurrentItem(0);

        iMainBannerView.getRadioGroupView().setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                iMainBannerView.getViewPagerView().setCurrentItem((int) group.findViewById(checkedId).getTag());
            }
        });

        iMainBannerView.getViewPagerView().addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                iMainBannerView.getRadioGroupView().check(iMainBannerView.getRadioGroupView().getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void setWelcomeImageListener(WelcomeImageServiceListener listener) {
        this.welcomeImageListener = listener;
    }

    private WelcomeImageServiceListener welcomeImageListener;

    public interface WelcomeImageServiceListener {
        void loadBannerResult(LaunchPageInfoResult launchInfo);
    }

    public void onResultMainBannerSuccess(Object bean) {
        if (bean == null)
            welcomeImageListener.loadBannerResult(null);
        else
            welcomeImageListener.loadBannerResult((LaunchPageInfoResult) bean);
    }

}

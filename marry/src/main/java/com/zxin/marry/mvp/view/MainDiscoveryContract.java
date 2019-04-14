package com.zxin.marry.mvp.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zxin.marry.R;
import com.zxin.marry.activity.GoodsDetailsActivity;
import com.zxin.marry.activity.GoodsMoreActivity;
import com.zxin.marry.activity.HotNewsActivity;
import com.zxin.marry.activity.MarryProductActivity;
import com.zxin.marry.activity.ProductDetailActivity;
import com.zxin.marry.activity.ProductListActivity;
import com.zxin.marry.activity.ShopCaseDetailsActivity;
import com.zxin.marry.activity.ShopDetailsActivity;
import com.zxin.marry.activity.ShopListActivity;
import com.zxin.marry.activity.WeddingPartyActivity;
import com.zxin.marry.bean.CityForm;
import com.zxin.marry.bean.EcshopBean;
import com.zxin.marry.bean.Entity;
import com.zxin.marry.bean.GiftBean;
import com.zxin.marry.bean.MarryProductForm;
import com.zxin.marry.bean.RecommendForm;
import com.zxin.marry.bean.ShopClassBean;
import com.zxin.marry.bean.ShopInformation;
import com.zxin.marry.fragment.discovery.DiscoveryCityFragment;
import com.zxin.marry.fragment.discovery.NationwideFragment;
import com.zxin.marry.fragment.shop.ShopBusinessFragment;
import com.zxin.marry.fragment.shop.ShopCaseFragment;
import com.zxin.marry.fragment.shop.ShopComboFragment;
import com.zxin.marry.mvp.presenter.DiscoveryPresenter;
import com.zxin.marry.util.AdvItemClickListener;
import com.zxin.marry.util.StringUtils;
import com.zxin.marry.util.TitleBarUtil;
import com.zxin.marry.view.BannerHolderView;
import com.zxin.marry.view.ViewPageCommonAdapter;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.network.mvp.view.IBaseView;
import com.zxin.root.adapter.simple.SimpleAdapter;
import com.zxin.root.adapter.simple.TrdViewHolder;
import com.zxin.root.adapter.VerBannerAdapter;
import com.zxin.root.adapter.ViewPageFragmentAdapter;
import com.zxin.root.bean.TitleBean;
import com.zxin.root.bean.VerticalBanner;
import com.zxin.root.util.AppManager;
import com.zxin.root.util.ImageUtil;
import com.zxin.root.util.SharedPreferencesManager;
import com.zxin.root.util.SystemInfoUtil;
import com.zxin.root.util.UiUtils;
import com.zxin.root.view.CommonCrosswiseBar;
import com.zxin.root.view.PagerSlidingTabStrip;
import com.zxin.root.view.RefreshCommonView;
import com.zxin.root.view.banner.BaseBannerAdapter;
import com.zxin.root.view.banner.VerticalBannerView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/24.
 */

public class MainDiscoveryContract implements IBaseView {
    private FragmentManager fragmentManager;
    private String currentFragmentTag;

    private Context mContext;

    @Override
    public void setParameter(Object... parameter) {
        fragmentManager = (FragmentManager) parameter[0];
    }

    @Override
    public void initDatas() {
        iView.getTopLayoutView().setPadding(iView.getTopLayoutView().getPaddingLeft(), iView.getTopLayoutView().getPaddingTop() + SystemInfoUtil.getStatusBarHeight(), iView.getTopLayoutView().getPaddingRight(), iView.getTopLayoutView().getPaddingBottom());
    }

    public void switchFragment(CityForm.City city) {
        String cityName = city.getCity().equals("全国") ? "全国" : "其他";
        if (!StringUtils.textIsEmpty(currentFragmentTag) && currentFragmentTag.equals(cityName))
            return;
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        Fragment currentFragment = fragmentManager.findFragmentByTag(currentFragmentTag);
        if (currentFragment != null) {
            ft.hide(currentFragment);//影藏之前的
        }
        Fragment foundFragment = fragmentManager.findFragmentByTag(cityName);
        if (foundFragment == null) {
            if (cityName.equals("全国"))
                foundFragment = new NationwideFragment();
            else
                foundFragment = new DiscoveryCityFragment();
            Bundle args = new Bundle();
            args.putParcelable(StringUtils.FRAGMENT_DATA, city);
            foundFragment.setArguments(args);
        }
        if (foundFragment.isAdded()) {
            ft.show(foundFragment);
        } else {
            ft.add(R.id.fl_monster_content, foundFragment, cityName);
        }
        ft.commitAllowingStateLoss();
        //ft.commit();
        currentFragmentTag = cityName;
    }


    @Override
    public void loadDatas() {

    }

    @Override
    public void onResultSuccess(Object bean) {
        if (bean == null)
            return;
        Entity entity = (Entity) bean;
        CityForm.City localCity = new CityForm.City(entity.getCity(), entity.getFeastid(), entity.getCityid());
        if (SharedPreferencesManager.getMarryCity(CityForm.City.class)==null||!SharedPreferencesManager.getMarryCity(CityForm.City.class).getCity().equals(localCity.getCity())) {
            SharedPreferencesManager.setMarryCity(localCity);
        }
        switchFragment(localCity);
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

    private DiscoveryPresenter presenter;

    @Override
    public void setP(BasePresenter... basePresenter) {
        presenter = (DiscoveryPresenter) basePresenter[0];
    }

    @Override
    public void OnClick(View v) {

    }

    private DiscoveryView iView;

    public void setDiscoveryViewListener(DiscoveryView testView) {
        this.iView = testView;
    }

    public interface DiscoveryView {
        LinearLayout getTopLayoutView();

        TextView getCityNameView();

        FrameLayout getFrameLayoutView();
    }

    private NationwideView iNationwideView;

    public void setNationwideViewListener(NationwideView iNationwideView) {
        this.iNationwideView = iNationwideView;
    }

    public interface NationwideView {
        RefreshCommonView getRefreshCommonView();

        ConvenientBanner getConvenientBannerView();

        RecyclerView getRecyclerView();

        SimpleDraweeView getSDVSubjectView();

        LinearLayout getLLMarryHotView();

        VerticalBannerView getVerticalBannerView();
    }

    private CityForm.City mNationwideCity;
    private String fromType;

    public void setNationwideViewParameter(Object... parameter) {
        mNationwideCity = (CityForm.City) parameter[0];
        fromType = (String) parameter[1];
    }

    private SimpleAdapter goodsNationwideClassAdapter,goodsNationwideAdapter;
    private List<ShopClassBean.TaoBaoProduct> goodsNationwideList = new ArrayList<>();
    private List<RecommendForm.RecommendAdv> adNationwideList = new ArrayList<>();
    private List<MarryProductForm.MarryProductType> nationwideDatasList = new ArrayList<>();
    private ArrayList<TitleBean> titleList = new ArrayList<>();
    public void initNationwideViewDatas() {
        iNationwideView.getConvenientBannerView().startTurning(3000L).setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused}).setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
        iNationwideView.getConvenientBannerView().setPages(new CBViewHolderCreator<BannerHolderView>() {
            @Override
            public BannerHolderView createHolder() {
                return new BannerHolderView();
            }
        }, adNationwideList);
        iNationwideView.getConvenientBannerView().setOnItemClickListener(new AdvItemClickListener(mContext, adNationwideList));

        iNationwideView.getRecyclerView().setNestedScrollingEnabled(false);
        iNationwideView.getRecyclerView().setLayoutManager(UiUtils.getGridLayoutManager(5));
        goodsNationwideClassAdapter = new SimpleAdapter<MarryProductForm.MarryProductType>(mContext, nationwideDatasList, R.layout.item_gv_type) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final MarryProductForm.MarryProductType data) {
                holder.setText(R.id.tv_type, data.getName());
                ImageUtil.loadCircleImageView(mContext, data.getLogo(), holder.<ImageView>getView(R.id.img_pic), R.mipmap.default_iamge);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, ProductListActivity.class);
                        intent.putExtra("position", nationwideDatasList.indexOf(data));
                        intent.putParcelableArrayListExtra("ProductTypes", titleList);
                        mContext.startActivity(intent);
                    }
                });
            }
        };
        iNationwideView.getRecyclerView().setAdapter(goodsNationwideClassAdapter);


        goodsNationwideAdapter = new SimpleAdapter<ShopClassBean.TaoBaoProduct>(mContext, goodsNationwideList, R.layout.item_marry_product) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final ShopClassBean.TaoBaoProduct data) {
                holder.setText(R.id.title, data.getTitle())
                        .setText(R.id.tv_price, "￥" + data.getPromotion_price())
                        .setText(R.id.tv_primary_price, "￥" + data.getPrice());
                TextView mTvPrimaryPrice = holder.getView(R.id.tv_primary_price);
                mTvPrimaryPrice.getPaint().setAntiAlias(true);
                mTvPrimaryPrice.getPaint().setFlags(17);
                if ("buyer".equals(data.getFreight_payer())) {
                    holder.<TextView>getView(R.id.tv_price).setCompoundDrawables(null, null, null, null);
                } else {
                    Drawable localDrawable = UiUtils.getDrawable(R.drawable.free_post);
                    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
                    holder.<TextView>getView(R.id.tv_price).setCompoundDrawables(null, null, localDrawable, null);
                }
                ImageUtil.loadImageViewLoding(mContext, data.getPic_url(), holder.<ImageView>getView(R.id.imageView), R.drawable.icon_default, R.drawable.icon_default);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, ProductDetailActivity.class);
                        intent.putExtra("TaoBaoProduct", data);
                        mContext.startActivity(intent);
                    }
                });
            }
        };
        iNationwideView.getRefreshCommonView().setRecyclerViewAdapter(goodsNationwideAdapter);
        iNationwideView.getRefreshCommonView().setIsLoadMore(false);
        iNationwideView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {
            @Override
            public void startRefresh() {
                presenter.getNationwideDatas(mNationwideCity.getCityid());
            }

            @Override
            public void startLoadMore() {

            }
        });
    }

    public void onResultNationwideDatasSuccess(Object obj) {
        iNationwideView.getRefreshCommonView().finishRefresh();
        iNationwideView.getRefreshCommonView().finishLoadMore();
        if (obj == null)
            return;
        MarryProductForm productForm = (MarryProductForm) obj;
        List<VerticalBanner> mBannerNationwideList = new ArrayList<>();
        mBannerNationwideList.clear();
        for (ShopClassBean.Posts posts: productForm.getData().getPosts()){
            VerticalBanner banner = new VerticalBanner();
            banner.setId(Integer.parseInt(posts.getId()));
            banner.setTitle(posts.getPost_title());
            mBannerNationwideList.add(banner);
        }
        if (fromType.equals(GoodsMoreActivity.class.getName())||mBannerNationwideList.isEmpty()){
            iNationwideView.getLLMarryHotView().setVisibility(View.GONE);
        }else{
            iNationwideView.getLLMarryHotView().setVisibility(View.VISIBLE);
            BaseBannerAdapter adapter = new VerBannerAdapter(mContext,mBannerNationwideList);
            adapter.setOnBannerClickListener(new BaseBannerAdapter.OnBannerClickListener() {
                @Override
                public void onItemClick(int position) {
                    mContext.startActivity(new Intent(mContext, HotNewsActivity.class));
                }
            });
            iNationwideView.getVerticalBannerView().setAdapter(adapter);
            iNationwideView.getVerticalBannerView().start();
        }

        adNationwideList.addAll(productForm.getData().getRecommend_adv());
        if (adNationwideList == null || adNationwideList.isEmpty()) {
            iNationwideView.getConvenientBannerView().setVisibility(View.GONE);
        } else {
            iNationwideView.getConvenientBannerView().setVisibility(View.VISIBLE);
            iNationwideView.getConvenientBannerView().notifyDataSetChanged();
        }
        ImageUtil.loadImageViewLoding(mContext, productForm.getData().getPic().getPicurl(), iNationwideView.getSDVSubjectView(), R.drawable.icon_default, R.drawable.icon_default);

        nationwideDatasList.clear();
        nationwideDatasList.addAll(productForm.getData().getTaobaoke_goodtypes());
        if (nationwideDatasList==null||nationwideDatasList.isEmpty()){
            iNationwideView.getRecyclerView().setVisibility(View.GONE);
        }else {
            titleList.clear();
            titleList.addAll( TitleBarUtil.newInstance().getProductList(nationwideDatasList));
            iNationwideView.getRecyclerView().setVisibility(View.VISIBLE);
            goodsNationwideClassAdapter.notifyDataSetChanged();
        }

        goodsNationwideList.clear();
        goodsNationwideList.addAll(productForm.getData().getTaobaoke_goods());
        goodsNationwideAdapter.notifyDataSetChanged();
    }

    private SparseArray<View> getNationwideSparseArray(final List<List<MarryProductForm.MarryProductType>> paramList, final ArrayList<TitleBean> titleList) {
        SparseArray localSparseArray = new SparseArray();
        for (final List<MarryProductForm.MarryProductType> localList : paramList) {
            RecyclerView recyclerView = new RecyclerView(mContext);

            localSparseArray.append(paramList.indexOf(localList), recyclerView);
        }
        return localSparseArray;
    }


    public void modifyDiscovery(CityForm.City city) {
        switchFragment(city);
        iView.getCityNameView().setText(city.getCity());
    }

    private DiscoveryCityView iDiscoveryCityView;

    public void setDiscoveryCityViewListener(DiscoveryCityView iDiscoveryCityView) {
        this.iDiscoveryCityView = iDiscoveryCityView;
    }

    public interface DiscoveryCityView {
        RefreshCommonView getRefreshCommonView();

        ConvenientBanner getConvenientBannerView();

        RecyclerView getRecyclerView();

        LinearLayout getLLMarryHotView();

        VerticalBannerView getVerticalBannerView();

        ImageView getSDVWeddingPartyView();

        LinearLayout getLLMarryProductView();

        LinearLayout getLLMonsterWeddingBudgetView();

        LinearLayout getLLMarryPlanView();

        LinearLayout getLLWeddingPlannerView();

        TextView getTVCountView();

        RecyclerView getRVGoodsView();

        void setDatasResult(String sc_id,String name);
    }

    private CityForm.City mDiscoveryCity;

    public void setDiscoveryCityParameter(Object... parameter) {
        mDiscoveryCity = (CityForm.City) parameter[0];
    }

    private List<RecommendForm.RecommendAdv> adDiscoveryCityList = new ArrayList<>();
    private List<String> mBottomsList = new ArrayList();
    private List<String> mTopsList = new ArrayList();
    private List<ShopClassBean.TaoBaoProduct> goodsList = new ArrayList();
    private List<EcshopBean> listDatasList = new ArrayList<>();
    private SimpleAdapter goodsClassAdapter,goodsAdapter,weddingAdapter;
    public void initDiscoveryCityDatas() {
        iDiscoveryCityView.getConvenientBannerView().startTurning(3000L).setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused}).setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
        iDiscoveryCityView.getConvenientBannerView().setPages(new CBViewHolderCreator<BannerHolderView>() {
            @Override
            public BannerHolderView createHolder() {
                return new BannerHolderView();
            }
        }, adDiscoveryCityList);
        iDiscoveryCityView.getConvenientBannerView().setOnItemClickListener(new AdvItemClickListener(mContext, adDiscoveryCityList));

        iDiscoveryCityView.getRecyclerView().setNestedScrollingEnabled(false);
        iDiscoveryCityView.getRecyclerView().setLayoutManager(UiUtils.getGridLayoutManager(5));
        goodsClassAdapter = new SimpleAdapter<EcshopBean>(mContext, listDatasList, R.layout.item_gv_type) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final EcshopBean data) {
                holder.setText(R.id.tv_type, data.getSc_name());
                ImageUtil.loadCircleImageView(mContext, data.getLogo(), holder.<ImageView>getView(R.id.img_pic), R.mipmap.default_iamge);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (data.getSc_id().equals("10")) {
                            Intent intent = new Intent(mContext, WeddingPartyActivity.class);
                            mContext.startActivity(intent);
                            return;
                        }
                        Intent intent = new Intent(mContext, ShopListActivity.class);
                        intent.putExtra("sc_id", data.getSc_id());
                        intent.putExtra("name", data.getSc_name());
                        intent.putExtra("CityId", mDiscoveryCity.getCityid());
                        mContext.startActivity(intent);
                    }
                });
            }
        };
        iDiscoveryCityView.getRecyclerView().setAdapter(goodsClassAdapter);

        iDiscoveryCityView.getRVGoodsView().setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.HORIZONTAL));
        goodsAdapter = new SimpleAdapter<ShopClassBean.TaoBaoProduct>(mContext, goodsList, R.layout.item_marry_horizontal) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final ShopClassBean.TaoBaoProduct shenMeiGui) {
                holder.setText(R.id.tv_price, "￥" + shenMeiGui.getPromotion_price())
                        .setText(R.id.tv_primary_price, "￥" + shenMeiGui.getPrice());
                TextView mTvPrimaryPrice = holder.getView(R.id.tv_primary_price);
                mTvPrimaryPrice.getPaint().setAntiAlias(true);
                mTvPrimaryPrice.getPaint().setFlags(17);
                ImageUtil.loadImageViewLoding(mContext, shenMeiGui.getPic_url(), holder.<ImageView>getView(R.id.imageView), R.drawable.icon_default, R.drawable.icon_default);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, ProductDetailActivity.class);
                        intent.putExtra("TaoBaoProduct", shenMeiGui);
                        mContext.startActivity(intent);
                    }
                });
            }
        };
        iDiscoveryCityView.getRVGoodsView().setAdapter(goodsAdapter);
        final List<Integer> colorList = UiUtils.getColorList();
        weddingAdapter = new SimpleAdapter<EcshopBean>(mContext, listDatasList, R.layout.item_monster_top) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final EcshopBean ecshopBean) {
                int color = colorList.get(listDatasList.indexOf(ecshopBean)%colorList.size());
                holder.setText(R.id.tv_monster_title, ecshopBean.getSc_name())
                        .setBackgroundColor(R.id.v_monster_line,color)
                        .setTextColor(R.id.tv_monster_title,color)
                        .setTextColor(R.id.tv_monster_more,color);
                RecyclerView recyclerView = holder.getView(R.id.rv_monster_content);
                recyclerView.setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.HORIZONTAL));
                recyclerView.setAdapter(new SimpleAdapter<EcshopBean.ShenMeGui>(mContext, ecshopBean.getGoods_commend(), R.layout.item_view_pager_card) {
                    @Override
                    protected void onBindViewHolder(TrdViewHolder holder, final EcshopBean.ShenMeGui shenMeiGui) {
                        holder.setText(R.id.tv_goods, shenMeiGui.getGoodsname())
                                .setText(R.id.tv_shop, shenMeiGui.getStorename())
                                .setText(R.id.tv_price, "￥" + shenMeiGui.getGoodsprice())
                                .setText(R.id.tv_primary_price, "￥" + shenMeiGui.getGoodsmarketprice());
                        TextView mTvPrimaryPrice = holder.getView(R.id.tv_primary_price);
                        mTvPrimaryPrice.getPaint().setAntiAlias(true);
                        mTvPrimaryPrice.getPaint().setFlags(17);
                        ImageUtil.loadImageViewLoding(mContext, shenMeiGui.getPicurl(), holder.<ImageView>getView(R.id.imageView), R.drawable.icon_default, R.drawable.icon_default);
                        ImageUtil.loadCircleImageView(mContext, shenMeiGui.getStorepicurl(), holder.<ImageView>getView(R.id.circleImageView), R.drawable.icon_default);
                        holder.setOnItemListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(mContext, GoodsDetailsActivity.class);
                                intent.putExtra("goods_id", shenMeiGui.getGoodid());
                                mContext.startActivity(intent);
                            }
                        });
                    }
                });
                holder.setOnClickListener(R.id.ll_monster_title,new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, ShopListActivity.class);
                        intent.putExtra("sc_id", ecshopBean.getSc_id());
                        intent.putExtra("name", ecshopBean.getSc_name());
                        intent.putExtra("CityId", mDiscoveryCity.getCityid());
                        mContext.startActivity(intent);
                    }
                });
            }
        };
        iDiscoveryCityView.getRefreshCommonView().setRecyclerViewAdapter(weddingAdapter);

        iDiscoveryCityView.getRefreshCommonView().setIsAutoLoad(false);
        iDiscoveryCityView.getRefreshCommonView().setIsLoadMore(false);
        iDiscoveryCityView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {
            @Override
            public void startRefresh() {
                presenter.getDiscoveryCityDatas(mDiscoveryCity.getCityid());
            }

            @Override
            public void startLoadMore() {

            }
        });
    }

    public void onResultDiscoveryCitySuccess(Object obj) {
        iDiscoveryCityView.getRefreshCommonView().finishRefresh();
        iDiscoveryCityView.getRefreshCommonView().finishLoadMore();
        if (obj == null)
            return;
        adDiscoveryCityList.clear();
        mBottomsList.clear();
        mTopsList.clear();
        ShopClassBean shopClass = (ShopClassBean) obj;
        adDiscoveryCityList.addAll(shopClass.getRecommend_adv());
        if (adDiscoveryCityList == null || adDiscoveryCityList.isEmpty()) {
            iDiscoveryCityView.getConvenientBannerView().setVisibility(View.GONE);
        } else {
            iDiscoveryCityView.getConvenientBannerView().setVisibility(View.VISIBLE);
            iDiscoveryCityView.getConvenientBannerView().notifyDataSetChanged();
        }
        List<VerticalBanner> mBannerList = new ArrayList<>();
        mBannerList.clear();
        for (ShopClassBean.Posts posts:shopClass.getPosts()){
            VerticalBanner banner = new VerticalBanner();
            banner.setId(Integer.parseInt(posts.getId()));
            banner.setTitle(posts.getPost_title());
            mBannerList.add(banner);
        }
        if (mBannerList.isEmpty()){
            iDiscoveryCityView.getLLMarryHotView().setVisibility(View.GONE);
        }else{
            iDiscoveryCityView.getLLMarryHotView().setVisibility(View.VISIBLE);
            BaseBannerAdapter adapter = new VerBannerAdapter(mContext,mBannerList);
            adapter.setOnBannerClickListener(new BaseBannerAdapter.OnBannerClickListener() {
                @Override
                public void onItemClick(int position) {
                    mContext.startActivity(new Intent(mContext, HotNewsActivity.class));
                }
            });
            iDiscoveryCityView.getVerticalBannerView().setAdapter(adapter);
            iDiscoveryCityView.getVerticalBannerView().start();
        }

        goodsList.clear();
        goodsList.addAll(shopClass.getTaobaoke_goods());
        goodsAdapter.notifyDataSetChanged();

        listDatasList.clear();
        listDatasList.addAll(shopClass.getValidEcshopList());
        if (listDatasList==null||listDatasList.isEmpty()){
            iDiscoveryCityView.getRecyclerView().setVisibility(View.GONE);
        }else {
            iDiscoveryCityView.setDatasResult(listDatasList.get(0).getSc_id(),listDatasList.get(0).getSc_name());
            iDiscoveryCityView.getRecyclerView().setVisibility(View.VISIBLE);
            goodsClassAdapter.notifyDataSetChanged();
        }

        weddingAdapter.notifyDataSetChanged();

        ArrayList<ShopClassBean.Posts> postList = shopClass.getPosts();
        for (int i = 0; i < postList.size(); i++) {
            ShopClassBean.Posts post = postList.get(i);
            if (i % 2 == 0)
                mTopsList.add(post.getPost_title());
            else
                mBottomsList.add(post.getPost_title());
        }
        iDiscoveryCityView.getLLMarryHotView().setVisibility(shopClass.getPosts().isEmpty() ? View.GONE : View.VISIBLE);
        if ("0".equals(shopClass.getFeastid())) {
            iDiscoveryCityView.getSDVWeddingPartyView().setVisibility(View.GONE);
        }
    }

    public void onResultDiscoveryCityCheckedCitySuccess(Object obj) {
        if (obj == null)
            return;
        Entity entity = (Entity) obj;
        mDiscoveryCity = new CityForm.City(entity.getCity(), entity.getFeastid(), entity.getCityid());
        CityForm.City localCity = new CityForm.City(mDiscoveryCity.getCity(), mDiscoveryCity.getFeastid(), mDiscoveryCity.getCityid());
        SharedPreferencesManager.setMarryCity(localCity);
        iDiscoveryCityView.getRefreshCommonView().notifyData();
    }

    private ShopListView iShopListView;

    public void setShopListViewListener(ShopListView iShopListView) {
        this.iShopListView = iShopListView;
    }

    public interface ShopListView {
        AppBarLayout getAppBarLayoutView();
        ConvenientBanner getConvenientBannerView();
        Toolbar getToolbarView();
        CommonCrosswiseBar getCommonCrosswiseBarView();
        PagerSlidingTabStrip getPagerSlidingTabStripView();
        ViewPager getViewPagerView();
    }

    private String scId;
    private String name;
    private String cityId;
    public void setShopListViewParameter(Object... objects){
        scId = (String) objects[0];
        name = (String) objects[1];
        cityId = (String) objects[2];
        fragmentManager = AppManager.getAppManager().getFragmentManager();
    }

    private List<Fragment> mFragmentList = new ArrayList<>();//页卡视图集合
    private List<RecommendForm.RecommendAdv> adShopList = new ArrayList<>();
    public void initShopListViewDatas(){
        mFragmentList.add(0, ShopComboFragment.newInstance(scId,name,cityId));
        mFragmentList.add(1, ShopCaseFragment.newInstance(scId,name,cityId));
        mFragmentList.add(2, ShopBusinessFragment.newInstance(scId,name,cityId));
        iShopListView.getViewPagerView().setCurrentItem(0);
        iShopListView.getViewPagerView().setOffscreenPageLimit(3);
        iShopListView.getViewPagerView().setAdapter(new ViewPageFragmentAdapter(mFragmentList,TitleBarUtil.newInstance().getShopTitle()));
        iShopListView.getPagerSlidingTabStripView().setViewPager(iShopListView.getViewPagerView());
        iShopListView.getCommonCrosswiseBarView().setTitleText(name);

        iShopListView.getConvenientBannerView().startTurning(3000L).setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused}).setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
        iShopListView.getConvenientBannerView().setPages(new CBViewHolderCreator<BannerHolderView>() {
            @Override
            public BannerHolderView createHolder() {
                return new BannerHolderView();
            }
        }, adShopList);
        iShopListView.getConvenientBannerView().setOnItemClickListener(new AdvItemClickListener(mContext, adShopList));
    }

    private float lastAlpha = 0;
    public void onResultShopListBannerSuccess(Object obj){
        if (obj==null)
            return;
        adShopList.clear();
        RecommendForm recommendForm = (RecommendForm)obj;
        adShopList.addAll(recommendForm.getRecommend_adv());
        if (adShopList == null || adShopList.isEmpty()) {
            iShopListView.getConvenientBannerView().setVisibility(View.GONE);
            iShopListView.getCommonCrosswiseBarView().setLeftButton(R.drawable.icon_back);
            iShopListView.getCommonCrosswiseBarView().setBGColor(R.color.main_title_background);
            iShopListView.getCommonCrosswiseBarView().setViewAlpha(1);
        } else {
            iShopListView.getConvenientBannerView().setVisibility(View.VISIBLE);
            iShopListView.getConvenientBannerView().notifyDataSetChanged();
            iShopListView.getAppBarLayoutView().addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
                @Override
                public void onOffsetChanged(AppBarLayout appBarLayout, int dy) {
                    float alpha = (float) Math.abs(dy)/ iShopListView.getConvenientBannerView().getMeasuredHeight();
                    alpha = alpha>1?1:alpha;
                    if (lastAlpha==alpha)
                        return;
                    lastAlpha = alpha;
                    setCCBTitleAlpha(lastAlpha);
                }
            });
        }
    }

    private void setCCBTitleAlpha(float alpha) {
        if (alpha > 0.6) {
            iShopListView.getCommonCrosswiseBarView().setLeftButton(R.drawable.icon_back);
            iShopListView.getCommonCrosswiseBarView().setBGColor(R.color.main_title_background);
        } else {
            iShopListView.getCommonCrosswiseBarView().setLeftButton(R.drawable.gray_back);
            iShopListView.getCommonCrosswiseBarView().setBGColor(R.color.color_00000000);
        }
        iShopListView.getCommonCrosswiseBarView().setViewAlpha(alpha);
    }

    private ShopComboView iShopComboView;

    public void setShopComboViewListener(ShopComboView iShopComboView) {
        this.iShopComboView = iShopComboView;
    }

    public interface ShopComboView {
        RefreshCommonView getRefreshCommonView();
    }

    private String scComboId;
    private String nameCombo;
    private String cityComboId;
    public void setShopComboViewParameter(Object... objects){
        scComboId = (String) objects[0];
        nameCombo = (String) objects[1];
        cityComboId = (String) objects[2];
    }

    private List<ShopInformation.EcshopBean> comboList = new ArrayList<>();
    private SimpleAdapter comboAdapter;
    private int comboPageNum = 0;
    public void initShopComboViewDatas(){
        comboAdapter = new SimpleAdapter<ShopInformation.EcshopBean>(mContext, comboList, R.layout.item_shop_combo) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final ShopInformation.EcshopBean ecshopBean) {
                holder.setText(R.id.tv_name, ecshopBean.getStore_name())
                        .setText(R.id.tv_describe, ecshopBean.getGoods_name())
                        .setText(R.id.tv_price, "￥" + ecshopBean.getGoods_price())
                        .setText(R.id.tv_primary_price, "￥" + ecshopBean.getGoods_marketprice());
                TextView mTvPrimaryPrice = holder.getView(R.id.tv_primary_price);
                mTvPrimaryPrice.getPaint().setAntiAlias(true);
                mTvPrimaryPrice.getPaint().setFlags(17);
                ImageUtil.loadImageViewLoding(mContext, ecshopBean.getGoods_image(), holder.<ImageView>getView(R.id.iv_image), R.drawable.icon_default, R.drawable.icon_default);
                ImageUtil.loadCircleImageView(mContext, ecshopBean.getStore_avatar(), holder.<ImageView>getView(R.id.iv_icon), R.drawable.icon_default);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, GoodsDetailsActivity.class);
                        intent.putExtra("goods_id", ecshopBean.getGoods_id());
                        mContext.startActivity(intent);
                    }
                });
            }
        };

        iShopComboView.getRefreshCommonView().setRecyclerViewAdapter(comboAdapter);
        iShopComboView.getRefreshCommonView().setIsAutoLoad(false);
        iShopComboView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {
            @Override
            public void startRefresh() {
                comboPageNum = 1;
                comboList.clear();
                presenter.getShopComboList(comboPageNum,"",scComboId,cityComboId);
            }

            @Override
            public void startLoadMore() {
                presenter.getShopComboList(++comboPageNum,comboForm.getPage().getPagetime(),scComboId,cityComboId);
            }
        });
    }

    private ShopInformation comboForm;
    public void onResultShopComboListSuccess(Object obj){
        iShopComboView.getRefreshCommonView().finishRefresh();
        iShopComboView.getRefreshCommonView().finishLoadMore();
        if (obj==null)
            return;
        comboForm = (ShopInformation)obj;
        comboList.addAll(comboForm.getGoodsRes());
        if (comboList == null || comboList.isEmpty()) {
            comboList.clear();
            iShopComboView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iShopComboView.getRefreshCommonView().setIsEmpty(false);
            iShopComboView.getRefreshCommonView().setIsLoadMore(comboForm.getGoodsRes().size()==Integer.parseInt(comboForm.getPage().getPagenumber()));
        }
        comboAdapter.notifyDataSetChanged();
    }


    private ShopCaseView iShopCaseView;

    public void setShopCaseViewListener(ShopCaseView iShopCaseView) {
        this.iShopCaseView = iShopCaseView;
    }

    public interface ShopCaseView {
        RefreshCommonView getRefreshCommonView();
    }
    private String scCaseId;
    private String nameCase;
    private String cityCaseId;
    public void setShopCaseViewParameter(Object... objects){
        scCaseId = (String) objects[0];
        nameCase = (String) objects[1];
        cityCaseId = (String) objects[2];
    }

    private List<ShopInformation.EcshopBean> caseList = new ArrayList<>();
    private SimpleAdapter caseAdapter;
    private int casePageNum=0;
    public void initShopCaseViewDatas(){
        caseAdapter = new SimpleAdapter<ShopInformation.EcshopBean>(mContext, caseList, R.layout.item_shop_case) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final ShopInformation.EcshopBean ecshopBean) {
                holder.setText(R.id.tv_name, ecshopBean.getStore_name())
                        .setText(R.id.tv_describe, ecshopBean.getCase_title())
                        .setText(R.id.tv_laud, ecshopBean.getCase_collect());
                ImageUtil.loadImageViewLoding(mContext, ecshopBean.getCase_images(), holder.<ImageView>getView(R.id.iv_image), R.drawable.icon_default, R.drawable.icon_default);
                ImageUtil.loadCircleImageView(mContext, ecshopBean.getStore_avatar(), holder.<ImageView>getView(R.id.iv_icon), R.drawable.icon_default);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext,ShopCaseDetailsActivity.class);
                        intent.putExtra("case_id", ecshopBean.getCase_id());
                        mContext.startActivity(intent);
                    }
                });
            }
        };

        iShopCaseView.getRefreshCommonView().setRecyclerViewAdapter(caseAdapter);
        iShopCaseView.getRefreshCommonView().setIsAutoLoad(false);
        iShopCaseView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {
            @Override
            public void startRefresh() {
                casePageNum=1;
                caseList.clear();
                presenter.getShopCaseList(casePageNum,"",scCaseId,cityCaseId);
            }

            @Override
            public void startLoadMore() {
                presenter.getShopCaseList(++casePageNum,caseForm.getPage().getPagetime(),scCaseId,cityCaseId);
            }
        });
    }

    private ShopInformation caseForm;
    public void onResultShopCaseListSuccess(Object obj){
        iShopCaseView.getRefreshCommonView().finishRefresh();
        iShopCaseView.getRefreshCommonView().finishLoadMore();
        if (obj==null)
            return;
        caseForm = (ShopInformation)obj;
        caseList.addAll(caseForm.getCaseRes());
        if (caseList == null || caseList.isEmpty()) {
            caseList.clear();
            iShopCaseView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iShopCaseView.getRefreshCommonView().setIsEmpty(false);
            iShopCaseView.getRefreshCommonView().setIsLoadMore(caseForm.getCaseRes().size()==Integer.parseInt(caseForm.getPage().getPagenumber()));
        }
        caseAdapter.notifyDataSetChanged();
    }



    private ShopBusinessView iShopBusinessView;

    public void setShopBusinessViewListener(ShopBusinessView iShopBusinessView) {
        this.iShopBusinessView = iShopBusinessView;
    }

    public interface ShopBusinessView {
        RefreshCommonView getRefreshCommonView();
    }
    private String scBusinessId;
    private String nameBusiness;
    private String cityBusinessId;
    private String areaBusinessId="";
    public void setShopBusinessViewParameter(Object... objects){
        scBusinessId = (String) objects[0];
        nameBusiness = (String) objects[1];
        cityBusinessId = (String) objects[2];
    }

    private List<ShopInformation.EcshopBean> businessList = new ArrayList<>();
    private SimpleAdapter businessAdapter;
    private int businessPageNum=0;
    public void initShopBusinessViewDatas(){
        businessAdapter = new SimpleAdapter<ShopInformation.EcshopBean>(mContext, businessList, R.layout.item_shop_list) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final ShopInformation.EcshopBean ecshopBean) {
                holder.setText(R.id.tv_store_name, ecshopBean.getStore_name())
                        .setText(R.id.tv_goods_count, "套餐 "+ecshopBean.getGoods_count())
                        .setText(R.id.tv_store_case,"案例 "+ ecshopBean.getCases_count())
                        .setText(R.id.tv_store_collect,"粉丝 "+ ecshopBean.getStore_collect())
                        .setVisible(R.id.tv_store_baozh,"1".equals(ecshopBean.getStore_baozh()))
                        .setVisible(R.id.tv_store_baozhopen,"1".equals(ecshopBean.getStore_baozhopen()))
                        .setVisible(R.id.tv_store_zhping,"1".equals(ecshopBean.getStore_zhping()))
                        .setVisible(R.id.tv_store_shiti,"1".equals(ecshopBean.getStore_shiti()))
                        .setVisible(R.id.tv_store_qtian,"1".equals(ecshopBean.getStore_qtian()))
                        .setVisible(R.id.tv_store_tuihuo,"1".equals(ecshopBean.getStore_tuihuo()))
                        .setVisible(R.id.tv_store_shiyong,"1".equals(ecshopBean.getStore_shiyong()))
                        .setVisible(R.id.tv_store_erxiaoshi,"1".equals(ecshopBean.getStore_erxiaoshi()))
                        .setVisible(R.id.tv_store_huodaofk,"1".equals(ecshopBean.getStore_huodaofk()))
                        .setVisible(R.id.tv_store_xiaoxie,"1".equals(ecshopBean.getStore_xiaoxie()))
                        .setVisible(R.id.lv_gift,ecshopBean.getGift()!=null&&!ecshopBean.getGift().isEmpty());
                if (ecshopBean.getGift()!=null&&!ecshopBean.getGift().isEmpty()) {
                    RecyclerView recyclerView = holder.getView(R.id.lv_gift);
                    recyclerView.setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.VERTICAL));
                    recyclerView.setNestedScrollingEnabled(false);
                    recyclerView.setAdapter(new SimpleAdapter<GiftBean>(mContext, ecshopBean.getGift(), R.layout.item_gift) {
                        @Override
                        protected void onBindViewHolder(TrdViewHolder holder, final GiftBean data) {
                            holder.setText(R.id.tv_gift_descr, data.getTitle());
                            switch (data.getType()) {
                                case "a":
                                    holder.setText(R.id.tv_gift_title, "到店礼");
                                    break;

                                case "b":
                                    holder.setText(R.id.tv_gift_title, "订单礼");
                                    break;

                                case "c":
                                    holder.setText(R.id.tv_gift_title, "优惠礼");
                                    break;
                            }
                        }
                    });
                }
                int recRes = 0;
                switch (ecshopBean.getGrade_id()){

                    case "1":
                        recRes = R.drawable.icon_ordinary_buiness;
                        break;

                    case "2":
                        recRes = R.drawable.icon_bronze_buiness;
                        break;

                    case "3":
                        recRes = R.drawable.icon_silver_buiness;
                        break;

                    case "4":
                        recRes = R.drawable.icon_gold_buiness;
                        break;

                    case "5":
                        recRes = R.drawable.icon_masonry_buiness;
                        break;
                }
                ImageUtil.loadImageViewLoding(mContext, ecshopBean.getStore_avatar(), holder.<ImageView>getView(R.id.store_avatar), R.drawable.icon_default, R.drawable.icon_default);
                holder.<ImageView>getView(R.id.img_shop_level).setImageResource(recRes);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext,ShopDetailsActivity.class);
                        intent.putExtra("store_id", ecshopBean.getStore_id());
                        mContext.startActivity(intent);
                    }
                });
            }
        };

        iShopBusinessView.getRefreshCommonView().setRecyclerViewAdapter(businessAdapter);
        iShopBusinessView.getRefreshCommonView().setIsAutoLoad(false);
        iShopBusinessView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {
            @Override
            public void startRefresh() {
                businessPageNum=1;
                caseList.clear();
                presenter.getShopBusinessList(businessPageNum,"",areaBusinessId,scBusinessId,cityBusinessId);
            }

            @Override
            public void startLoadMore() {
                presenter.getShopBusinessList(++businessPageNum,businessForm.getPage().getPagetime(),areaBusinessId,scBusinessId,cityBusinessId);
            }
        });
    }

    private ShopInformation businessForm;
    public void onResultShopBusinessListSuccess(Object obj){
        iShopBusinessView.getRefreshCommonView().finishRefresh();
        iShopBusinessView.getRefreshCommonView().finishLoadMore();
        if (obj==null)
            return;
        businessForm = (ShopInformation)obj;
        businessList.addAll(businessForm.getEcshop());

        if (businessList == null || businessList.isEmpty()) {
            businessList.clear();
            iShopBusinessView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iShopBusinessView.getRefreshCommonView().setIsEmpty(false);
            iShopBusinessView.getRefreshCommonView().setIsLoadMore(businessForm.getCaseRes().size()==Integer.parseInt(businessForm.getPage().getPagenumber()));
        }
        businessAdapter.notifyDataSetChanged();
    }

}

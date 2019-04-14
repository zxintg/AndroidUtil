package com.zxin.jiuxian.mvp.view;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.zxin.basemodel.util.HtmlJumpUtil;
import com.zxin.jiuxian.R;
import com.zxin.jiuxian.adapter.BannerHolderView;
import com.zxin.jiuxian.bean.CateLeftPageResult;
import com.zxin.jiuxian.bean.CatePageResult;
import com.zxin.jiuxian.bean.MainBarBean;
import com.zxin.jiuxian.mvp.presenter.ClassiftyPresenter;
import com.zxin.jiuxian.util.ActivityManageUtil;
import com.zxin.jiuxian.util.AdvItemClickListener;
import com.zxin.jiuxian.util.StringUtils;
import com.zxin.jiuxian.util.TitleBarUtil;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.network.mvp.view.IBaseView;
import com.zxin.root.adapter.simple.SimpleAdapter;
import com.zxin.root.adapter.simple.TrdViewHolder;
import com.zxin.root.adapter.ViewPageFragmentAdapter;
import com.zxin.root.util.ImageUtil;
import com.zxin.root.util.SystemInfoUtil;
import com.zxin.root.util.UiUtils;
import com.zxin.root.view.PagerSlidingVerTabStrip;
import com.zxin.root.view.RefreshCommonView;
import com.zxin.root.view.MyViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/24.
 */

public class ClassiftyContract implements IBaseView {
    private Context mContext;

    @Override
    public void setParameter(Object... parameter) {

    }

    @Override
    public void initDatas() {
        iClassifyView.getCateHeadView().setPadding(iClassifyView.getCateHeadView().getPaddingLeft(), iClassifyView.getCateHeadView().getPaddingTop() + SystemInfoUtil.getStatusBarHeight(), iClassifyView.getCateHeadView().getPaddingRight(), iClassifyView.getCateHeadView().getPaddingBottom());
    }

    @Override
    public void loadDatas() {

    }

    private ArrayList<MainBarBean> titleList = new ArrayList<>();
    private List<Fragment> mFragmentList = new ArrayList<>();//页卡视图集合
    private ViewPageFragmentAdapter pageAdapter;

    @Override
    public void onResultSuccess(Object bean) {
        if (bean == null)
            return;
        titleList.clear();
        mFragmentList.clear();

        CateLeftPageResult cateLeft = (CateLeftPageResult) bean;
        titleList.addAll(TitleBarUtil.newInstance().getClassifyTitleList(cateLeft.cateList));
        for (MainBarBean titleBean : titleList) {
            mFragmentList.add(titleBean.fragment);
        }
        iClassifyView.getVerticalViewPagerView().removeAllViews();
        pageAdapter = new ViewPageFragmentAdapter(mFragmentList, titleList);
        iClassifyView.getVerticalViewPagerView().setCurrentItem(0);
        iClassifyView.getVerticalViewPagerView().setAdapter(pageAdapter);
        iClassifyView.getVerticalViewPagerView().setOffscreenPageLimit(titleList.size());
        iClassifyView.getPagerSlidingVerView().setViewPager(iClassifyView.getVerticalViewPagerView());
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

    private ClassiftyPresenter presenter;

    @Override
    public void setP(BasePresenter... basePresenter) {
        presenter = (ClassiftyPresenter) basePresenter[0];
    }

    @Override
    public void OnClick(View v) {

    }

    private ClassifyView iClassifyView;

    public void setClassifyView(ClassifyView iClassifyView) {
        this.iClassifyView = iClassifyView;
    }

    public interface ClassifyView {
        LinearLayout getCateHeadView();

        PagerSlidingVerTabStrip getPagerSlidingVerView();

        MyViewPager getVerticalViewPagerView();
    }

    private ClassifyItemView iClassifyItemView;

    public void setClassifyItemView(ClassifyItemView iClassifyItemView) {
        this.iClassifyItemView = iClassifyItemView;
    }

    public interface ClassifyItemView {
        RefreshCommonView getRefreshCommonView();

        ConvenientBanner getConvenientBannerView();
    }

    private String categoryId;

    public void setClassifyItemParameter(Object... parameter) {
        categoryId = (String) parameter[0];
    }

    private List<CatePageResult.CateBannerItem> bannerList = new ArrayList<>();
    private List<CatePageResult.CateAttrListItem> mAttrList = new ArrayList<>();
    private SimpleAdapter cateChildAdapter;

    public void initClassifyItemDatas() {
        iClassifyItemView.getConvenientBannerView().startTurning(3000L).setPageIndicator(new int[]{R.drawable.community_experence_point_unreached, R.drawable.community_experence_point_reached}).setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
        iClassifyItemView.getConvenientBannerView().setPages(new CBViewHolderCreator<BannerHolderView>() {
            @Override
            public BannerHolderView createHolder() {
                return new BannerHolderView();
            }
        }, bannerList);
        iClassifyItemView.getConvenientBannerView().setOnItemClickListener(new AdvItemClickListener(mContext, bannerList));

        cateChildAdapter = new SimpleAdapter<CatePageResult.CateAttrListItem>(mContext, mAttrList, R.layout.item_wine_cate) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final CatePageResult.CateAttrListItem cateAttr) {
                holder.setText(R.id.tv_cate_title, cateAttr.name)
                        .setVisible(R.id.tv_cate_allgoods, cateAttr.isAll == 1);
                RecyclerView recyclerView = holder.getView(R.id.rv_item_cate);
                recyclerView.setLayoutManager(UiUtils.getGridLayoutManager(3));
                recyclerView.setPadding(5, 5, 5, 5);
                recyclerView.setNestedScrollingEnabled(false);
                recyclerView.setAdapter(new SimpleAdapter<CatePageResult.CateListItem>(mContext, cateAttr.list, R.layout.item_cate_textview) {
                    @Override
                    protected void onBindViewHolder(TrdViewHolder holder, final CatePageResult.CateListItem cate) {
                        holder.setVisible(R.id.iv_cate_item, !StringUtils.textIsEmpty(cate.image));
                        if (4 == cate.mParentId) {
                            if (cate.name.contains("-")) {
                                StringBuilder builder = new StringBuilder();
                                builder.append(cate.name);
                                builder.append(UiUtils.getString(R.string.yuan));
                                holder.setText(R.id.tv_cate_name, builder.toString());
                            } else {
                                StringBuilder builder = new StringBuilder();
                                builder.append(cate.name);
                                builder.append(UiUtils.getString(R.string.yuan_above));
                                holder.setText(R.id.tv_cate_name, builder.toString());
                            }
                        } else {
                            holder.setText(R.id.tv_cate_name, cate.name);
                        }
                        holder.setTextColor(R.id.tv_cate_name, UiUtils.getColor(cate.isRed == 1 ? R.color.red_fc : R.color.color_666666));
                        ImageUtil.loadImageViewLoding(mContext, cate.image, holder.<ImageView>getView(R.id.iv_cate_item), R.drawable.default_img_big, R.drawable.icon_nullcate);
                        holder.setOnItemListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ActivityManageUtil.goToProductList(String.valueOf(cate.id), cate);
                            }
                        });
                    }
                });
            }
        };
        iClassifyItemView.getRefreshCommonView().setIsRefresh(false);
        iClassifyItemView.getRefreshCommonView().setIsLoadMore(false);
        iClassifyItemView.getRefreshCommonView().setRecyclerViewAdapter(cateChildAdapter);
    }

    public void onResultClassifyItemSuccess(Object bean) {
        if (bean == null)
            return;
        CatePageResult cate = (CatePageResult) bean;
        bannerList.clear();
        mAttrList.clear();
        if (cate.moduleList == null || cate.moduleList.isEmpty())
            iClassifyItemView.getConvenientBannerView().setVisibility(View.GONE);
        else {
            bannerList.addAll(cate.moduleList);
            iClassifyItemView.getConvenientBannerView().setVisibility(View.VISIBLE);
        }
        mAttrList.addAll(cate.attrList);
        iClassifyItemView.getConvenientBannerView().notifyDataSetChanged();
        cateChildAdapter.notifyDataSetChanged();
    }


    private ClassifyAllView iClassifyAllView;

    public void setClassifyAllView(ClassifyAllView iClassifyAllView) {
        this.iClassifyAllView = iClassifyAllView;
    }

    public interface ClassifyAllView {
        RecyclerView getRecyclerView();
    }

    private List<CatePageResult.CateBannerItem> moduleList = new ArrayList<>();
    private SimpleAdapter cateChildAllAdapter;

    public void initClassifyAllDatas() {
        cateChildAllAdapter = new SimpleAdapter<CatePageResult.CateBannerItem>(mContext, moduleList, R.layout.item_cate_all) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final CatePageResult.CateBannerItem cate) {
                holder.setText(R.id.tv_cate_name, cate.adTitle);
                ImageUtil.loadImageViewLoding(mContext, cate.adImg, holder.<ImageView>getView(R.id.iv_cate_item), R.mipmap.default_iamge, R.drawable.icon_nullcate);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        HtmlJumpUtil.toWebForUrlActivity(cate.adTitle, cate.adLink);
                    }
                });
            }
        };
        iClassifyAllView.getRecyclerView().setLayoutManager(UiUtils.getGridLayoutManager(3));
        iClassifyAllView.getRecyclerView().setPadding(5, 5, 5, 5);
        iClassifyAllView.getRecyclerView().setNestedScrollingEnabled(false);
        iClassifyAllView.getRecyclerView().setAdapter(cateChildAllAdapter);
    }

    public void onResultClassifyAllSuccess(Object bean) {
        if (bean == null)
            return;
        CatePageResult cate = (CatePageResult) bean;
        moduleList.clear();
        moduleList.addAll(cate.moduleList);
        cateChildAllAdapter.notifyDataSetChanged();
    }


}

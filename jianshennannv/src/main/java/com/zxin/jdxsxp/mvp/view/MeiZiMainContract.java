package com.zxin.jdxsxp.mvp.view;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.zxin.camera.model.PhotoPreviewBean;
import com.zxin.camera.utils.CameraAlbumUtils;
import com.zxin.jdxsxp.R;
import com.zxin.jdxsxp.activity.AndroidMNDetailActivity;
import com.zxin.jdxsxp.activity.MeinvPicDetailActivity;
import com.zxin.jdxsxp.activity.SearchActivity;
import com.zxin.jdxsxp.bean.MZPicModle;
import com.zxin.jdxsxp.bean.MeiNvLocal;
import com.zxin.jdxsxp.bean.MeiZuHome;
import com.zxin.jdxsxp.bean.MeiZuHot;
import com.zxin.jdxsxp.bean.MeiZuMeiZiDetail;
import com.zxin.jdxsxp.bean.ArticleListBean;
import com.zxin.jdxsxp.bean.MeinvBaogaoBean;
import com.zxin.jdxsxp.bean.MinvBaoGaodetail;
import com.zxin.jdxsxp.bean.SearchBaiduPic;
import com.zxin.jdxsxp.bean.SearchSouGou;
import com.zxin.jdxsxp.mvp.presenter.MeiZiMainPresenter;
import com.zxin.jdxsxp.util.AdvItemClickListener;
import com.zxin.jdxsxp.util.StringUtils;
import com.zxin.jdxsxp.view.BannerHolderView;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.network.mvp.view.IBaseView;
import com.zxin.root.adapter.simple.SimpleAdapter;
import com.zxin.root.adapter.simple.TrdViewHolder;
import com.zxin.root.bean.TitleBean;
import com.zxin.root.util.ImageUtil;
import com.zxin.root.util.SystemInfoUtil;
import com.zxin.root.util.ToastUtil;
import com.zxin.root.util.UiUtils;
import com.zxin.root.view.CommonCrosswiseBar;
import com.zxin.root.view.PagerSlidingTabStrip;
import com.zxin.root.view.RefreshCommonView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/24.
 */

public class MeiZiMainContract implements IBaseView {
    private Context mContext;
    private List<MeiZuHome.ValueBean.BlocksBean.DataBean> adList = new ArrayList<>();
    private List<MeiZuHome.ValueBean.BlocksBean> arcList = new ArrayList<>();
    private List<MeiZuHot.ResBean.VerticalBean> hotList = new ArrayList<>();
    private SimpleAdapter arcAdapter, hotAdapter;

    @Override
    public void setParameter(Object... parameter) {

    }

    private int pageMainNum = 1;

    @Override
    public void initDatas() {
        iMeiZiMainView.getHeadView().setPadding(iMeiZiMainView.getHeadView().getPaddingLeft(), iMeiZiMainView.getHeadView().getPaddingTop() + SystemInfoUtil.getStatusBarHeight(), iMeiZiMainView.getHeadView().getPaddingRight(), iMeiZiMainView.getHeadView().getPaddingBottom());

        iMeiZiMainView.getConvenientBannerView().startTurning(5000L).setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused}).setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
        iMeiZiMainView.getConvenientBannerView().setPages(new CBViewHolderCreator<BannerHolderView>() {
            @Override
            public BannerHolderView createHolder() {
                return new BannerHolderView();
            }
        }, adList);
        iMeiZiMainView.getConvenientBannerView().setOnItemClickListener(new AdvItemClickListener(mContext, adList));

        iMeiZiMainView.getArcRecyclerView().setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.VERTICAL));
        arcAdapter = new SimpleAdapter<MeiZuHome.ValueBean.BlocksBean>(mContext, arcList, R.layout.item_home) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final MeiZuHome.ValueBean.BlocksBean localTheme) {
                holder.setText(R.id.tv_home_name, localTheme.getName())
                        .setVisible(R.id.tv_home_more, localTheme.isMore());
                holder.setOnClickListener(R.id.tv_home_more, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                RecyclerView recyclerView = holder.getView(R.id.rv_home);
                recyclerView.setLayoutManager(UiUtils.getGridLayoutManager(3));
                recyclerView.setNestedScrollingEnabled(false);
                recyclerView.setAdapter(new SimpleAdapter<MeiZuHome.ValueBean.BlocksBean.DataBean>(mContext, localTheme.getData(), R.layout.item_common_pic) {
                    @Override
                    protected void onBindViewHolder(TrdViewHolder holder, final MeiZuHome.ValueBean.BlocksBean.DataBean product) {
                        ImageUtil.loadImageViewLoding(mContext, product.getSmall_pap_address(), holder.<ImageView>getView(R.id.iv_common_img), R.mipmap.default_iamge, R.mipmap.error);
                        holder.setOnItemListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });
                    }
                });
            }
        };
        iMeiZiMainView.getArcRecyclerView().setNestedScrollingEnabled(false);
        iMeiZiMainView.getArcRecyclerView().setAdapter(arcAdapter);

        hotAdapter = new SimpleAdapter<MeiZuHot.ResBean.VerticalBean>(mContext, hotList, R.layout.item_common_pic) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final MeiZuHot.ResBean.VerticalBean localTheme) {
                ImageUtil.loadImageViewLoding(mContext, localTheme.getThumb(), holder.<ImageView>getView(R.id.iv_common_img), R.mipmap.default_iamge, R.mipmap.error);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
            }
        };
        iMeiZiMainView.getRefreshCommonView().setIsAutoLoad(false);
        iMeiZiMainView.getRefreshCommonView().setRecyclerViewAdapter(hotAdapter);
        iMeiZiMainView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {

            @Override
            public void startRefresh() {
                pageMainNum = 1;
                adList.clear();
                arcList.clear();
                hotList.clear();
                presenter.getMainMeiZiApi();
                presenter.getMainHotApi(pageMainNum);
            }

            @Override
            public void startLoadMore() {
                presenter.getMainHotApi(++pageMainNum);
            }
        });

    }

    @Override
    public void loadDatas() {

    }

    private MeiZiMainView iMeiZiMainView;

    public void setBeikeSearchView(MeiZiMainView iMeiZiMainView) {
        this.iMeiZiMainView = iMeiZiMainView;
    }

    public interface MeiZiMainView {
        RefreshCommonView getRefreshCommonView();

        LinearLayout getHeadView();

        ConvenientBanner getConvenientBannerView();

        RecyclerView getArcRecyclerView();
    }

    @Override
    public void onResultSuccess(Object bean) {
        if (bean == null)
            return;
        MeiZuHome.ValueBean meiZuHome = (MeiZuHome.ValueBean) bean;
        List<MeiZuHome.ValueBean.BlocksBean> list = meiZuHome.getBlocks();

        if (list == null || list.isEmpty())
            return;

        for (MeiZuHome.ValueBean.BlocksBean block : list) {
            switch (block.getId()) {
                case 549:
                    adList.addAll(block.getData());
                    break;

                case 550:
                    break;

                default:
                    arcList.add(block);
                    break;
            }
        }

        if (adList == null || adList.isEmpty()) {
            iMeiZiMainView.getConvenientBannerView().setVisibility(View.GONE);
        } else {
            iMeiZiMainView.getConvenientBannerView().setVisibility(View.VISIBLE);
            iMeiZiMainView.getConvenientBannerView().notifyDataSetChanged();
        }

        if (arcList == null || arcList.isEmpty()) {
            iMeiZiMainView.getArcRecyclerView().setVisibility(View.GONE);
        } else {
            iMeiZiMainView.getArcRecyclerView().setVisibility(View.VISIBLE);
            arcAdapter.notifyDataSetChanged();
        }

    }

    public void onResultHotSuccess(Object bean) {
        iMeiZiMainView.getRefreshCommonView().finishRefresh();
        iMeiZiMainView.getRefreshCommonView().finishLoadMore();
        if (bean == null)
            return;
        MeiZuHot.ResBean meiZuHot = (MeiZuHot.ResBean) bean;
        hotList.addAll(meiZuHot.getVertical());
        if (hotList == null || hotList.isEmpty()) {
            hotList.clear();
            iMeiZiMainView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iMeiZiMainView.getRefreshCommonView().setIsEmpty(false);
            iMeiZiMainView.getRefreshCommonView().setIsLoadMore(pageMainNum < 10);
        }
        hotAdapter.notifyDataSetChanged();
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

    private MeiZiMainPresenter presenter;

    @Override
    public void setP(BasePresenter... basePresenter) {
        presenter = (MeiZiMainPresenter) basePresenter[0];
    }

    @Override
    public void OnClick(View v) {

    }


    private SpecialView iSpecialView;

    public void setSpecialView(SpecialView iSpecialView) {
        this.iSpecialView = iSpecialView;
    }

    public interface SpecialView {
        RefreshCommonView getRefreshCommonView();
    }

    private SimpleAdapter meinvAdapter;
    private List<MeiZuHot.ResBean.AlbumBean> albumList = new ArrayList<>();
    private int pageMeiNvNum = 1;

    public void initSpecialDatas() {
        meinvAdapter = new SimpleAdapter<MeiZuHot.ResBean.AlbumBean>(mContext, albumList, R.layout.layout_androidmn) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final MeiZuHot.ResBean.AlbumBean localTheme) {
                holder.setText(R.id.tv_meinv_name, localTheme.getName())
                        .setText(R.id.tv_meinv_desc, localTheme.getDesc());
                ImageUtil.loadImageViewLoding(mContext, localTheme.getCover(), holder.<ImageView>getView(R.id.iv_meinv_image), R.mipmap.default_iamge, R.mipmap.error);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mContext.startActivity(new Intent(mContext, AndroidMNDetailActivity.class).putExtra("ID", localTheme.getId()).putExtra("title", localTheme.getName()));
                    }
                });
            }
        };
        iSpecialView.getRefreshCommonView().setIsAutoLoad(false);
        iSpecialView.getRefreshCommonView().setRecyclerViewAdapter(meinvAdapter);
        iSpecialView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {

            @Override
            public void startRefresh() {
                pageMeiNvNum = 1;
                albumList.clear();
                presenter.getMeiNvListApi(pageMeiNvNum);
            }

            @Override
            public void startLoadMore() {
                presenter.getMeiNvListApi(++pageMeiNvNum);
            }
        });
    }

    public void onResultMeiNvListSuccess(Object bean) {
        iSpecialView.getRefreshCommonView().finishRefresh();
        iSpecialView.getRefreshCommonView().finishLoadMore();
        if (bean == null)
            return;
        MeiZuHot.ResBean meiZuHot = (MeiZuHot.ResBean) bean;
        albumList.addAll(meiZuHot.getAlbum());
        if (albumList == null || albumList.isEmpty()) {
            albumList.clear();
            iSpecialView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iSpecialView.getRefreshCommonView().setIsEmpty(false);
            iSpecialView.getRefreshCommonView().setIsLoadMore(pageMeiNvNum < 10);
        }
        meinvAdapter.notifyDataSetChanged();
    }


    private MeiZiDeatilView iMeiZiDeatilView;

    public void setMeiZiDeatilView(MeiZiDeatilView iMeiZiDeatilView) {
        this.iMeiZiDeatilView = iMeiZiDeatilView;
    }

    public interface MeiZiDeatilView {
        ImageView getImageView();

        RefreshCommonView getRefreshCommonView();
    }

    private String meiId;

    public void setMNDetailParameter(Object... parameter) {
        meiId = String.valueOf(parameter[0]);
    }

    private SimpleAdapter meinvAlbumAdapter;
    private List<MeiZuMeiZiDetail.ResBean.WallpaperBean> meinvalbumList = new ArrayList<>();
    private int pageMeiNvAlbumNum = 1;

    public void initMeiZiDeatilDatas() {
        meinvAlbumAdapter = new SimpleAdapter<MeiZuMeiZiDetail.ResBean.WallpaperBean>(mContext, meinvalbumList, R.layout.item_image) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final MeiZuMeiZiDetail.ResBean.WallpaperBean localTheme) {
                ImageUtil.loadImageViewLoding(mContext, localTheme.getThumb(), holder.<ImageView>getView(R.id.iv_item_meinv), R.mipmap.default_iamge, R.mipmap.error);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        PhotoPreviewBean previewBean = new PhotoPreviewBean();
                        previewBean.count = meinvalbumList.size();
                        previewBean.index = meinvalbumList.indexOf(localTheme);
                        previewBean.content = "我们都知道ListView通过adapter.notifyDataSetChanged()实现ListView的更新，这种更新方法的缺点是全局更新，即对每个Item View都进行重绘。但事实上很多时候，我们只是更新了其中一个Item的数据，其他Item其实可以不需要重绘。";
                        previewBean.explain = "评论看看好不好呀！！！！";
                        previewBean.explainNum = 70;
                        previewBean.zanNum = 36;
                        List<PhotoPreviewBean.PhotoPreview> list = new ArrayList<>();
                        for (MeiZuMeiZiDetail.ResBean.WallpaperBean picTotalBean : meinvalbumList) {
                            PhotoPreviewBean.PhotoPreview photoPreview = new PhotoPreviewBean.PhotoPreview();
                            photoPreview.imageUrl = picTotalBean.getImg();
                            list.add(photoPreview);
                        }
                        previewBean.photoList = list;
                        CameraAlbumUtils.getInstance(mContext).startAlbumPreviewActivity(previewBean);
                    }
                });
            }
        };
        iMeiZiDeatilView.getRefreshCommonView().setRecyclerViewAdapter(meinvAlbumAdapter);
        iMeiZiDeatilView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {

            @Override
            public void startRefresh() {
                pageMeiNvAlbumNum = 1;
                meinvalbumList.clear();
                presenter.getMeiNvDetailApi(meiId, pageMeiNvAlbumNum);
            }

            @Override
            public void startLoadMore() {
                presenter.getMeiNvDetailApi(meiId, ++pageMeiNvAlbumNum);
            }
        });
    }

    public void onResultMeiNvDetailSuccess(Object bean) {
        iMeiZiDeatilView.getRefreshCommonView().finishRefresh();
        iMeiZiDeatilView.getRefreshCommonView().finishLoadMore();
        if (bean == null)
            return;
        MeiZuMeiZiDetail.ResBean detail = (MeiZuMeiZiDetail.ResBean) bean;
        meinvalbumList.addAll(detail.getWallpaper());
        if (detail.getAlbum() == null || StringUtils.textIsEmpty(detail.getAlbum().getLcover())) {
            iMeiZiDeatilView.getImageView().setVisibility(View.GONE);
        } else {
            iMeiZiDeatilView.getImageView().setVisibility(View.VISIBLE);
            ImageUtil.loadImageViewLoding(mContext, detail.getAlbum().getLcover(), iMeiZiDeatilView.getImageView(), R.mipmap.default_iamge, R.mipmap.error);
        }
        if (meinvalbumList == null || meinvalbumList.isEmpty()) {
            meinvalbumList.clear();
            iMeiZiDeatilView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iMeiZiDeatilView.getRefreshCommonView().setIsEmpty(false);
            iMeiZiDeatilView.getRefreshCommonView().setIsLoadMore(detail.getWallpaper().size()>=20&&pageMeiNvAlbumNum < 10);
        }
        meinvAlbumAdapter.notifyDataSetChanged();
    }


    private AnalysisView iAnalysisView;

    public void setAnalysisView(AnalysisView iAnalysisView) {
        this.iAnalysisView = iAnalysisView;
    }

    public interface AnalysisView {
        RecyclerView getRecyclerView();
    }

    private SimpleAdapter analysisAdapter;
    private List<ArticleListBean.DataBean> wZliat = new ArrayList<>();

    public void initAnalysisDatas() {
        iAnalysisView.getRecyclerView().setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.VERTICAL));
        analysisAdapter = new SimpleAdapter<ArticleListBean.DataBean>(mContext, wZliat, R.layout.item_articsl) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final ArticleListBean.DataBean localTheme) {
                holder.setText(R.id.tv_article_title, localTheme.getContent())
                        .setText(R.id.tv_article_time, localTheme.getCreateTime())
                        .setText(R.id.tv_article_name, StringUtils.textIsEmpty(localTheme.getNickname()) ? "游客" : localTheme.getNickname());
                ImageUtil.loadCircleImageView(mContext, localTheme.getPicSrc(), holder.<ImageView>getView(R.id.iv_article_pic), R.mipmap.error);
                ImageUtil.loadImageViewLoding(mContext, localTheme.getPicSrc(), holder.<ImageView>getView(R.id.iv_article_imgView), R.mipmap.default_iamge, R.mipmap.error);
            }
        };
        iAnalysisView.getRecyclerView().setAdapter(analysisAdapter);
    }

    public void onResultArticleListSuccess(Object bean) {
        if (bean == null)
            return;
        wZliat.clear();
        wZliat.addAll((List<ArticleListBean.DataBean>) bean);
        analysisAdapter.notifyDataSetChanged();
    }


    private WallPaperItemView iWallPaperItemView;

    public void setWallPaperItemView(WallPaperItemView iWallPaperItemView) {
        this.iWallPaperItemView = iWallPaperItemView;
    }


    private TitleBean titleBean;

    public void setWallPaperItemParameter(Object... parameter) {
        titleBean = (TitleBean) parameter[0];
    }

    public interface WallPaperItemView {
        RefreshCommonView getRefreshCommonView();
    }

    private SimpleAdapter wallPaperItemAdapter;
    private List<MeinvBaogaoBean> wallPaperItemList = new ArrayList<>();
    private int wallPaperItemNum = 1;

    public void initWallPaperItemDatas() {
        wallPaperItemAdapter = new SimpleAdapter<MeinvBaogaoBean>(mContext, wallPaperItemList, R.layout.layout_meinvbaog) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final MeinvBaogaoBean localTheme) {
                holder.setText(R.id.iv_bz_text, localTheme.getAlbum_pics());
                ImageUtil.loadImageViewLoding(mContext, localTheme.getAlbum_thumb(), holder.<ImageView>getView(R.id.iv_bz_img), R.mipmap.default_iamge, R.mipmap.error);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent localIntent = new Intent(mContext, MeinvPicDetailActivity.class);
                        localIntent.putExtra("album_address", localTheme.getAlbum_address());
                        localIntent.putExtra("title", localTheme.getAlbum_name());
                        mContext.startActivity(localIntent);
                    }
                });
            }
        };
        iWallPaperItemView.getRefreshCommonView().setRowNum(2);
        iWallPaperItemView.getRefreshCommonView().setIsAutoLoad(false);
        iWallPaperItemView.getRefreshCommonView().setRecyclerViewAdapter(wallPaperItemAdapter);
        iWallPaperItemView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {

            @Override
            public void startRefresh() {
                wallPaperItemNum = 1;
                wallPaperItemList.clear();
                presenter.getWallPaperItemList(titleBean.id2, wallPaperItemNum);
            }

            @Override
            public void startLoadMore() {
                presenter.getWallPaperItemList(titleBean.id2, ++wallPaperItemNum);
            }
        });
    }

    public void onResulWallPaperItemSuccess(Object bean) {
        iWallPaperItemView.getRefreshCommonView().finishRefresh();
        iWallPaperItemView.getRefreshCommonView().finishLoadMore();
        if (bean == null)
            return;
        wallPaperItemList.addAll((List<MeinvBaogaoBean>) bean);
        if (wallPaperItemList == null || wallPaperItemList.isEmpty()) {
            wallPaperItemList.clear();
            iWallPaperItemView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iWallPaperItemView.getRefreshCommonView().setIsEmpty(false);
            iWallPaperItemView.getRefreshCommonView().setIsLoadMore(wallPaperItemNum < 10);
        }
        wallPaperItemAdapter.notifyDataSetChanged();
    }


    private FindView iFindView;

    public void setFindView(FindView iFindView) {
        this.iFindView = iFindView;
    }

    public interface FindView {
        LinearLayout getHeadView();

        SearchView getSearchView();

        RecyclerView getRecyclerView();
    }

    private SimpleAdapter localAdapter;
    private List<MeiNvLocal> localList = new ArrayList<>();

    public void initFindDatas() {
        iFindView.getHeadView().setPadding(iFindView.getHeadView().getPaddingLeft(), iFindView.getHeadView().getPaddingTop() + SystemInfoUtil.getStatusBarHeight(), iFindView.getHeadView().getPaddingRight(), iFindView.getHeadView().getPaddingBottom());
        iFindView.getRecyclerView().setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        iFindView.getRecyclerView().setItemAnimator(new DefaultItemAnimator());
        iFindView.getRecyclerView().setHasFixedSize(true);

        localAdapter = new SimpleAdapter<MeiNvLocal>(mContext, localList, R.layout.layout_fx) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final MeiNvLocal localTheme) {
                holder.setText(R.id.iv_fx_text, localTheme.title);
                ImageUtil.loadImageViewLoding(mContext, localTheme.pictureUrl, holder.<ImageView>getView(R.id.iv_fx_img), R.mipmap.default_iamge, R.mipmap.error);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mContext.startActivity(new Intent(mContext, SearchActivity.class).putExtra("keyword", localTheme.title));
                    }
                });
            }
        };
        iFindView.getRecyclerView().setAdapter(localAdapter);
        // 设置搜索文本监听
        iFindView.getSearchView().setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //当点击搜索按钮时触发该方法
                mContext.startActivity(new Intent(mContext, SearchActivity.class).putExtra("keyword", query));
                return false;
            }


            @Override
            public boolean onQueryTextChange(String newText) {
                //当搜索内容改变时触发该方法
                return false;
            }
        });
    }

    public void onResulFindSuccess(List<MeiNvLocal> meiNvLocalList) {
        localList.clear();
        localList.addAll(meiNvLocalList);
        localAdapter.notifyDataSetChanged();
    }


    private String searchBaiDu;

    public void setFindBaiDuParameter(Object... parameter) {
        searchBaiDu = (String) parameter[0];
    }

    private FindBaiDuView iFindBaiDuView;

    public void setFindBaiDuView(FindBaiDuView iFindBaiDuView) {
        this.iFindBaiDuView = iFindBaiDuView;
    }

    public interface FindBaiDuView {
        RefreshCommonView getRefreshCommonView();
    }

    private SimpleAdapter findBaiDuAdapter;
    private List<SearchBaiduPic.DataBean> findBaiDuList = new ArrayList<>();
    private int findBaiDuNum = 1;

    public void initFindBaiDuDatas() {
        findBaiDuAdapter = new SimpleAdapter<SearchBaiduPic.DataBean>(mContext, findBaiDuList, R.layout.item_search_image) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final SearchBaiduPic.DataBean localTheme) {
                ImageUtil.loadImageViewLoding(mContext, localTheme.getObjURL(), holder.<ImageView>getView(R.id.iv_search_meinv), R.mipmap.default_iamge, R.mipmap.error);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        PhotoPreviewBean previewBean = new PhotoPreviewBean();
                        previewBean.count = findBaiDuList.size();
                        previewBean.index = findBaiDuList.indexOf(localTheme);
                        previewBean.content = "我们都知道ListView通过adapter.notifyDataSetChanged()实现ListView的更新，这种更新方法的缺点是全局更新，即对每个Item View都进行重绘。但事实上很多时候，我们只是更新了其中一个Item的数据，其他Item其实可以不需要重绘。";
                        previewBean.explain = "评论看看好不好呀！！！！";
                        previewBean.explainNum = 70;
                        previewBean.zanNum = 36;
                        List<PhotoPreviewBean.PhotoPreview> list = new ArrayList<>();
                        for (SearchBaiduPic.DataBean picTotalBean : findBaiDuList) {
                            PhotoPreviewBean.PhotoPreview photoPreview = new PhotoPreviewBean.PhotoPreview();
                            photoPreview.imageUrl = picTotalBean.getObjURL();
                            list.add(photoPreview);
                        }
                        previewBean.photoList = list;
                        CameraAlbumUtils.getInstance(mContext).startAlbumPreviewActivity(previewBean);
                    }
                });
            }
        };
        iFindBaiDuView.getRefreshCommonView().setRowNum(2);
        iFindBaiDuView.getRefreshCommonView().setIsAutoLoad(false);
        iFindBaiDuView.getRefreshCommonView().setRecyclerViewAdapter(findBaiDuAdapter);
        iFindBaiDuView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {

            @Override
            public void startRefresh() {
                findBaiDuNum = 1;
                findBaiDuList.clear();
                presenter.getFindBaiDuList(searchBaiDu, findBaiDuNum);
            }

            @Override
            public void startLoadMore() {
                presenter.getFindBaiDuList(searchBaiDu, ++findBaiDuNum);
            }
        });
    }

    public void onResultFindBaiDuSuccess(Object bean) {
        iFindBaiDuView.getRefreshCommonView().finishRefresh();
        iFindBaiDuView.getRefreshCommonView().finishLoadMore();
        if (bean == null)
            return;
        List<SearchBaiduPic.DataBean> list = (List<SearchBaiduPic.DataBean>) bean;
        findBaiDuList.addAll(list);
        if (findBaiDuList == null || findBaiDuList.isEmpty()) {
            findBaiDuList.clear();
            iFindBaiDuView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iFindBaiDuView.getRefreshCommonView().setIsEmpty(false);
            iFindBaiDuView.getRefreshCommonView().setIsLoadMore(list.size() >= 20 && findBaiDuNum < 10);
        }
        findBaiDuAdapter.notifyDataSetChanged();
    }


    private String search360;

    public void setFind360Parameter(Object... parameter) {
        search360 = (String) parameter[0];
    }

    private Find360View iFind360View;

    public void setFind360View(Find360View iFind360View) {
        this.iFind360View = iFind360View;
    }

    public interface Find360View {
        RefreshCommonView getRefreshCommonView();
    }

    private SimpleAdapter find360Adapter;
    private List<MZPicModle.ValueBean.DataBean> find360List = new ArrayList<>();
    private int find360Num = 1;

    public void initFind360Datas() {
        find360Adapter = new SimpleAdapter<MZPicModle.ValueBean.DataBean>(mContext, find360List, R.layout.item_search_image) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final MZPicModle.ValueBean.DataBean localTheme) {
                ImageUtil.loadImageViewLoding(mContext, localTheme.getSmall(), holder.<ImageView>getView(R.id.iv_search_meinv), R.mipmap.default_iamge, R.mipmap.error);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        PhotoPreviewBean previewBean = new PhotoPreviewBean();
                        previewBean.count = find360List.size();
                        previewBean.index = find360List.indexOf(localTheme);
                        previewBean.content = "我们都知道ListView通过adapter.notifyDataSetChanged()实现ListView的更新，这种更新方法的缺点是全局更新，即对每个Item View都进行重绘。但事实上很多时候，我们只是更新了其中一个Item的数据，其他Item其实可以不需要重绘。";
                        previewBean.explain = "评论看看好不好呀！！！！";
                        previewBean.explainNum = 70;
                        previewBean.zanNum = 36;
                        List<PhotoPreviewBean.PhotoPreview> list = new ArrayList<>();
                        for (MZPicModle.ValueBean.DataBean picTotalBean : find360List) {
                            PhotoPreviewBean.PhotoPreview photoPreview = new PhotoPreviewBean.PhotoPreview();
                            photoPreview.imageUrl = picTotalBean.getBig();
                            list.add(photoPreview);
                        }
                        previewBean.photoList = list;
                        CameraAlbumUtils.getInstance(mContext).startAlbumPreviewActivity(previewBean);
                    }
                });
            }
        };
        iFind360View.getRefreshCommonView().setRowNum(2);
        iFind360View.getRefreshCommonView().setIsAutoLoad(false);
        iFind360View.getRefreshCommonView().setRecyclerViewAdapter(find360Adapter);
        iFind360View.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {

            @Override
            public void startRefresh() {
                find360Num = 1;
                find360List.clear();
                presenter.getFind360List(search360, find360Num);
            }

            @Override
            public void startLoadMore() {
                presenter.getFind360List(search360, ++find360Num);
            }
        });
    }

    public void onResultFind360Success(Object bean) {
        iFind360View.getRefreshCommonView().finishRefresh();
        iFind360View.getRefreshCommonView().finishLoadMore();
        if (bean == null)
            return;
        MZPicModle.ValueBean valueBean = (MZPicModle.ValueBean) bean;
        find360List.addAll(valueBean.getData());
        if (find360List == null || find360List.isEmpty()) {
            find360List.clear();
            iFind360View.getRefreshCommonView().setIsEmpty(true);
        } else {
            iFind360View.getRefreshCommonView().setIsEmpty(false);
            iFind360View.getRefreshCommonView().setIsLoadMore(valueBean.getData().size() >= 20 && find360Num < 10);
        }
        find360Adapter.notifyDataSetChanged();
    }


    private String searchSouGou;

    public void setFindSouGouParameter(Object... parameter) {
        searchSouGou = (String) parameter[0];
    }

    private FindSouGouView iFindSouGouView;

    public void setFindSouGouView(FindSouGouView iFindSouGouView) {
        this.iFindSouGouView = iFindSouGouView;
    }

    public interface FindSouGouView {
        RefreshCommonView getRefreshCommonView();
    }

    private SimpleAdapter findSouGouAdapter;
    private List<SearchSouGou.ItemsBean> findSouGouList = new ArrayList<>();
    private int findSouGouNum = 1;

    public void initFindSouGouDatas() {
        findSouGouAdapter = new SimpleAdapter<SearchSouGou.ItemsBean>(mContext, findSouGouList, R.layout.item_search_image) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final SearchSouGou.ItemsBean localTheme) {
                ImageUtil.loadImageViewLoding(mContext, localTheme.getThumbUrl(), holder.<ImageView>getView(R.id.iv_search_meinv), R.mipmap.default_iamge, R.mipmap.error);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        PhotoPreviewBean previewBean = new PhotoPreviewBean();
                        previewBean.count = findSouGouList.size();
                        previewBean.index = findSouGouList.indexOf(localTheme);
                        previewBean.content = "我们都知道ListView通过adapter.notifyDataSetChanged()实现ListView的更新，这种更新方法的缺点是全局更新，即对每个Item View都进行重绘。但事实上很多时候，我们只是更新了其中一个Item的数据，其他Item其实可以不需要重绘。";
                        previewBean.explain = "评论看看好不好呀！！！！";
                        previewBean.explainNum = 70;
                        previewBean.zanNum = 36;
                        List<PhotoPreviewBean.PhotoPreview> list = new ArrayList<>();
                        for (SearchSouGou.ItemsBean picTotalBean : findSouGouList) {
                            PhotoPreviewBean.PhotoPreview photoPreview = new PhotoPreviewBean.PhotoPreview();
                            photoPreview.imageUrl = picTotalBean.getPic_url();
                            list.add(photoPreview);
                        }
                        previewBean.photoList = list;
                        CameraAlbumUtils.getInstance(mContext).startAlbumPreviewActivity(previewBean);
                    }
                });
            }
        };
        iFindSouGouView.getRefreshCommonView().setRowNum(2);
        iFindSouGouView.getRefreshCommonView().setIsAutoLoad(false);
        iFindSouGouView.getRefreshCommonView().setRecyclerViewAdapter(findSouGouAdapter);
        iFindSouGouView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {

            @Override
            public void startRefresh() {
                findSouGouNum = 1;
                findSouGouList.clear();
                presenter.getFindSouGouList(searchSouGou, findSouGouNum);
            }

            @Override
            public void startLoadMore() {
                presenter.getFindSouGouList(searchSouGou, ++findSouGouNum);
            }
        });
    }

    public void onResultFindSouGouSuccess(Object bean) {
        iFindSouGouView.getRefreshCommonView().finishRefresh();
        iFindSouGouView.getRefreshCommonView().finishLoadMore();
        if (bean == null)
            return;
        SearchSouGou valueBean = (SearchSouGou) bean;
        findSouGouList.addAll(valueBean.getItems());
        if (findSouGouList == null || findSouGouList.isEmpty()) {
            findSouGouList.clear();
            iFindSouGouView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iFindSouGouView.getRefreshCommonView().setIsEmpty(false);
            iFindSouGouView.getRefreshCommonView().setIsLoadMore(valueBean.getItems().size() >= 20 && findSouGouNum < 10);
        }
        findSouGouAdapter.notifyDataSetChanged();
    }

    private String albumaddress;

    public void setMeinvPicDetailParameter(Object... parameter) {
        albumaddress = (String) parameter[0];
    }

    private MeinvPicDetailView iMeinvPicDetailView;

    public void setMeinvPicDetailView(MeinvPicDetailView iMeinvPicDetailView) {
        this.iMeinvPicDetailView = iMeinvPicDetailView;
    }

    public interface MeinvPicDetailView {
        RefreshCommonView getRefreshCommonView();
    }

    private SimpleAdapter picDetailAdapter;
    private List<MinvBaoGaodetail.PicTotalBean> picDetailList = new ArrayList<>();
    public void initMeinvPicDetailDatas() {
        picDetailAdapter = new SimpleAdapter<MinvBaoGaodetail.PicTotalBean>(mContext, picDetailList, R.layout.layout_meinvbaogdetail) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final MinvBaoGaodetail.PicTotalBean localTheme) {
                holder.setText(R.id.iv_album_text, localTheme.getPic_name())
                        .setVisible(R.id.iv_album_text, !StringUtils.textIsEmpty(localTheme.getPic_name()));
                ImageUtil.loadImageViewLoding(mContext, localTheme.getPic_url(), holder.<ImageView>getView(R.id.iv_album_img), R.mipmap.default_iamge, R.mipmap.error);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        PhotoPreviewBean previewBean = new PhotoPreviewBean();
                        previewBean.count = picDetailList.size();
                        previewBean.index = picDetailList.indexOf(localTheme);
                        previewBean.content = "我们都知道ListView通过adapter.notifyDataSetChanged()实现ListView的更新，这种更新方法的缺点是全局更新，即对每个Item View都进行重绘。但事实上很多时候，我们只是更新了其中一个Item的数据，其他Item其实可以不需要重绘。";
                        previewBean.explain = "评论看看好不好呀！！！！";
                        previewBean.explainNum = 100;
                        previewBean.zanNum = 36;
                        List<PhotoPreviewBean.PhotoPreview> list = new ArrayList<>();
                        for (MinvBaoGaodetail.PicTotalBean picTotalBean : picDetailList) {
                            PhotoPreviewBean.PhotoPreview photoPreview = new PhotoPreviewBean.PhotoPreview();
                            photoPreview.imageUrl = picTotalBean.getPic_url();
                            list.add(photoPreview);
                        }
                        previewBean.photoList = list;
                        CameraAlbumUtils.getInstance(mContext).startAlbumPreviewActivity(previewBean);
                    }
                });
            }
        };
        iMeinvPicDetailView.getRefreshCommonView().setRowNum(2);
        iMeinvPicDetailView.getRefreshCommonView().setIsLoadMore(false);
        iMeinvPicDetailView.getRefreshCommonView().setRecyclerViewAdapter(picDetailAdapter);
        iMeinvPicDetailView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {

            @Override
            public void startRefresh() {
                picDetailList.clear();
                presenter.getPicDetailList(albumaddress);
            }

            @Override
            public void startLoadMore() {

            }
        });
    }

    public void onResultMeinvPicDetailSuccess(Object bean) {
        iMeinvPicDetailView.getRefreshCommonView().finishRefresh();
        iMeinvPicDetailView.getRefreshCommonView().finishLoadMore();
        if (bean == null)
            return;
        MinvBaoGaodetail valueBean = (MinvBaoGaodetail) bean;
        picDetailList.addAll(valueBean.getPic_total());
        if (picDetailList == null || picDetailList.isEmpty()) {
            picDetailList.clear();
            iMeinvPicDetailView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iMeinvPicDetailView.getRefreshCommonView().setIsEmpty(false);
            iMeinvPicDetailView.getRefreshCommonView().setIsLoadMore(false);
        }
        picDetailAdapter.notifyDataSetChanged();
    }

}

package com.zxin.meziyowu.mvp.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zxin.meziyowu.R;
import com.zxin.meziyowu.activity.YoMeiUserDetailActivity;
import com.zxin.meziyowu.bean.MainBarBean;
import com.zxin.meziyowu.bean.YoMeiBean;
import com.zxin.meziyowu.bean.YoMeiDeatilBean;
import com.zxin.meziyowu.bean.YoMeiTagModel;
import com.zxin.meziyowu.bean.YoWuResult;
import com.zxin.meziyowu.bean.YouMeiVideoBean;
import com.zxin.meziyowu.mvp.presenter.YoMeiMainPresenter;
import com.zxin.meziyowu.util.StringUtils;
import com.zxin.meziyowu.util.TitleBarUtil;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.network.mvp.view.IBaseView;
import com.zxin.root.adapter.simple.SimpleAdapter;
import com.zxin.root.adapter.simple.TrdViewHolder;
import com.zxin.root.adapter.ViewPageFragmentAdapter;
import com.zxin.basemodel.dao.MeiZiVideoDaoUtil;
import com.zxin.root.util.ImageUtil;
import com.zxin.root.util.UiUtils;
import com.zxin.root.view.CommonCrosswiseBar;
import com.zxin.root.view.PagerSlidingTabStrip;
import com.zxin.root.view.RefreshCommonView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/24.
 */

public class YoMeiMainContract implements IBaseView {
    private Context mContext;

    @Override
    public void loadDatas() {

    }

    private YoMeiMainView iYoMeiMainView;

    public void setYoMeiMainView(YoMeiMainView iYoMeiMainView) {
        this.iYoMeiMainView = iYoMeiMainView;
    }

    public interface YoMeiMainView {
        PagerSlidingTabStrip getPagerSlidingTabStrip();

        ViewPager getViewPager();
    }

    private ArrayList<MainBarBean> titleList = new ArrayList<>();
    private List<Fragment> mFragmentList = new ArrayList<>();//页卡视图集合
    private ViewPageFragmentAdapter pageAdapter;

    @Override
    public void onResultSuccess(Object bean) {
        if (bean == null)
            return;
        titleList.addAll(TitleBarUtil.newInstance().getHomeTagList((List<YoMeiTagModel>) bean));
        for (MainBarBean titleBean : titleList) {
            mFragmentList.add(titleBean.fragment);
        }
        iYoMeiMainView.getViewPager().removeAllViews();
        pageAdapter = new ViewPageFragmentAdapter(mFragmentList, titleList);
        iYoMeiMainView.getViewPager().setCurrentItem(0);
        iYoMeiMainView.getViewPager().setAdapter(pageAdapter);
        iYoMeiMainView.getViewPager().setOffscreenPageLimit(titleList.size());
        iYoMeiMainView.getPagerSlidingTabStrip().setViewPager(iYoMeiMainView.getViewPager());
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

    private YoMeiMainPresenter presenter;

    @Override
    public void setP(BasePresenter... basePresenter) {
        presenter = (YoMeiMainPresenter) basePresenter[0];
    }

    private int typeId;

    @Override
    public void setParameter(Object... parameter) {
        typeId = (int) parameter[0];
    }

    @Override
    public void OnClick(View v) {

    }

    private YoMeiItemView iYoMeiItemView;

    public void setYoMeiItemView(YoMeiItemView iYoMeiItemView) {
        this.iYoMeiItemView = iYoMeiItemView;
    }

    public interface YoMeiItemView {
        RefreshCommonView getRefreshCommonView();
    }

    private SimpleAdapter meinvAdapter;
    private List<YoMeiBean> albumList = new ArrayList<>();
    private int pageMeiNvNum = 1;

    @Override
    public void initDatas() {
        meinvAdapter = new SimpleAdapter<YoMeiBean>(mContext, albumList, R.layout.item_small_video_list) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final YoMeiBean localTheme) {
                ImageUtil.loadImageViewLoding(mContext, localTheme.getCover(), holder.<ImageView>getView(R.id.iv_cover), R.mipmap.default_iamge, R.mipmap.default_iamge);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, YoMeiUserDetailActivity.class);
                        intent.putExtra(StringUtils.ACTIVITY_DATA, localTheme);
                        mContext.startActivity(intent);
                    }
                });
            }
        };
        iYoMeiItemView.getRefreshCommonView().setIsAutoLoad(false);
        iYoMeiItemView.getRefreshCommonView().setRecyclerViewAdapter(meinvAdapter);
        iYoMeiItemView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {

            @Override
            public void startRefresh() {
                pageMeiNvNum = 1;
                albumList.clear();
                presenter.getYoMeiListByTag(typeId, pageMeiNvNum);
            }

            @Override
            public void startLoadMore() {
                presenter.getYoMeiListByTag(typeId, ++pageMeiNvNum);
            }
        });
    }

    public void onResultYoMeiListSuccess(Object bean) {
        iYoMeiItemView.getRefreshCommonView().finishRefresh();
        iYoMeiItemView.getRefreshCommonView().finishLoadMore();
        if (bean == null)
            return;
        YoWuResult<List<YoMeiBean>> yoWuResult = (YoWuResult) bean;
        albumList.addAll(yoWuResult.getData());
        if (albumList == null || albumList.isEmpty()) {
            albumList.clear();
            iYoMeiItemView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iYoMeiItemView.getRefreshCommonView().setIsEmpty(false);
            iYoMeiItemView.getRefreshCommonView().setIsLoadMore(yoWuResult.getMaxPage() > pageMeiNvNum);
        }
        meinvAdapter.notifyDataSetChanged();
    }

    private YoMeiInfoView iYoMeiInfoView;

    public void setYoMeiInfoView(YoMeiInfoView iYoMeiInfoView) {
        this.iYoMeiInfoView = iYoMeiInfoView;
    }

    public interface YoMeiInfoView {
        AppBarLayout getAppBarLayoutView();

        Toolbar getToolbarView();

        CommonCrosswiseBar getCommonCrosswiseBarView();

        ImageView iv_youmei_headbg();

        ImageView iv_youmei_head();

        TextView tv_youmei_username();

        TextView tv_youmei_userdesc();

        TextView tv_youmei_videonum();

        RecyclerView rv_youmei_tags();

        RefreshCommonView getRefreshCommonView();

        void setResultName(String userName);

        void selectOnclick(YoMeiDeatilBean yoMeiDeatil,List<YoMeiBean> meinvDeatilList,int index,boolean isVideo);

        void itemOnLongClick(YoMeiBean localTheme);
    }

    private int videoId;

    private float lastAlpha = 0;
    private SimpleAdapter meinvTagsAdapter,meinvDeatilAdapter;
    private List<YoMeiBean> meinvDeatilList = new ArrayList<>();
    public List<YoMeiDeatilBean.YoMeiTag> tagList = new ArrayList<>();
    private int pageMeinvDeatilNum = 1;
    private boolean isMoreVideo = false;
    private YoMeiBean checkedYoMei=null;
    public void initYoMeiInfoDatas() {
        tagList.clear();
        daoUtil = null;
        iYoMeiInfoView.getAppBarLayoutView().addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int dy) {
                float alpha = (float) Math.abs(dy) / iYoMeiInfoView.iv_youmei_headbg().getMeasuredHeight();
                alpha = alpha > 1 ? 1 : alpha;
                if (lastAlpha == alpha)
                    return;
                lastAlpha = alpha;
                setCCBTitleAlpha(lastAlpha);
            }
        });
        iYoMeiInfoView.rv_youmei_tags().setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.HORIZONTAL));
        meinvTagsAdapter = new SimpleAdapter<YoMeiDeatilBean.YoMeiTag>(mContext, tagList, R.layout.item_texttag) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final YoMeiDeatilBean.YoMeiTag localTheme) {
                GradientDrawable gradientDrawable1 = new GradientDrawable();
                // 形状-圆角矩形
                gradientDrawable1.setShape(GradientDrawable.RECTANGLE);
                // 圆角
                gradientDrawable1.setCornerRadius(8);
                // 随机颜色
                gradientDrawable1.setColor(Color.parseColor(localTheme.getColor()));
                /*GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setShape(GradientDrawable.RECTANGLE);
                gradientDrawable2.setCornerRadius(8);gradientDrawable2.setColor(Color.GRAY);
                // 状态选择器
                StateListDrawable stateListDrawable = new StateListDrawable();
                // 按下状态的背景
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, gradientDrawable2);*/
                // 常规状态的背景
                //stateListDrawable.addState(new int[]{}, gradientDrawable1);
                // 应用到控件 -- API level 16
                holder.getView(R.id.item_texttag).setBackground(gradientDrawable1);
                holder.setText(R.id.item_texttag,localTheme.name);
            }
        };
        iYoMeiInfoView.rv_youmei_tags().setAdapter(meinvTagsAdapter);

        meinvDeatilAdapter = new SimpleAdapter<YoMeiBean>(mContext, meinvDeatilList, R.layout.item_small_video_list) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final YoMeiBean localTheme) {
                ImageUtil.loadImageViewLoding(mContext, localTheme.getCover(), holder.<ImageView>getView(R.id.iv_cover), R.mipmap.default_iamge, R.mipmap.default_iamge);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        isMoreVideo = true;
                        checkedYoMei = localTheme;
                        presenter.getYoMeiVideoDetail(checkedYoMei.getId());
                    }
                });
                holder.setOnItemLongClickListener(new View.OnLongClickListener(){

                    @Override
                    public boolean onLongClick(View v) {
                        iYoMeiInfoView.itemOnLongClick(localTheme);
                        return false;
                    }
                });
            }
        };
        iYoMeiInfoView.getRefreshCommonView().setIsAutoLoad(false);
        iYoMeiInfoView.getRefreshCommonView().setRecyclerViewAdapter(meinvDeatilAdapter);
        iYoMeiInfoView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {

            @Override
            public void startRefresh() {
                pageMeinvDeatilNum = 1;
                meinvDeatilList.clear();
                presenter.getYoMeiDetailList(videoId, pageMeinvDeatilNum);
            }

            @Override
            public void startLoadMore() {
                presenter.getYoMeiDetailList(videoId, ++pageMeinvDeatilNum);
            }
        });
    }

    private void setCCBTitleAlpha(float alpha) {
        if (alpha > 0.6) {
            iYoMeiInfoView.getCommonCrosswiseBarView().setLeftButton(R.mipmap.ic_black_left_arrow);
            iYoMeiInfoView.getCommonCrosswiseBarView().setBGColor(R.color.color_ffffff);
            iYoMeiInfoView.getCommonCrosswiseBarView().setTitleTextColor(R.color.color_333333);
            iYoMeiInfoView.getCommonCrosswiseBarView().setRightTextColor(R.color.color_666666);
        } else {
            iYoMeiInfoView.getCommonCrosswiseBarView().setLeftButton(R.mipmap.ic_white_left_arrow);
            iYoMeiInfoView.getCommonCrosswiseBarView().setBGColor(R.color.color_00000000);
            iYoMeiInfoView.getCommonCrosswiseBarView().setTitleTextColor(R.color.color_ffffff);
            iYoMeiInfoView.getCommonCrosswiseBarView().setRightTextColor(R.color.color_ffffff);
        }
        iYoMeiInfoView.getCommonCrosswiseBarView().setViewAlpha(alpha);
    }

    private MeiZiVideoDaoUtil daoUtil;
    public void onResultYoMeiVideoSuccess(Object bean) {
        if (bean == null)
            return;
        if (daoUtil==null){
            daoUtil = MeiZiVideoDaoUtil.getInstance();
        }
        YoMeiDeatilBean yoMeiDeatil = (YoMeiDeatilBean)bean;
        videoId = yoMeiDeatil.vid;
        boolean hasVideo = daoUtil.hasMeiZiVideo(yoMeiDeatil.id);
        if (!StringUtils.textIsEmpty(yoMeiDeatil.url)&&!hasVideo){
            daoUtil.addMeiZiVideo(checkedYoMei==null?yoMeiDeatil.avatar.url:checkedYoMei.getCover(),yoMeiDeatil.url,yoMeiDeatil.nickname,String.valueOf(yoMeiDeatil.id),yoMeiDeatil.topic,yoMeiDeatil.vid);
        }
        if (isMoreVideo&&checkedYoMei!=null){
            iYoMeiInfoView.selectOnclick(yoMeiDeatil,meinvDeatilList,meinvDeatilList.indexOf(checkedYoMei),hasVideo);
            isMoreVideo = false;
            checkedYoMei = null;
            return;
        }
        presenter.getYoMeiDetail(videoId);
        iYoMeiInfoView.getRefreshCommonView().notifyData();
    }

    public void onResultYoMeiDetailSuccess(Object bean) {
        if (bean == null)
            return;
        YoMeiDeatilBean yoMeiDeatil = (YoMeiDeatilBean)bean;
        iYoMeiInfoView.tv_youmei_username().setText(yoMeiDeatil.nickname);
        iYoMeiInfoView.setResultName(yoMeiDeatil.nickname);
        iYoMeiInfoView.tv_youmei_userdesc().setText(yoMeiDeatil.topic);
        if (yoMeiDeatil.avatar==null)
            return;
        ImageUtil.loadRSBlurImage(mContext, yoMeiDeatil.avatar.url, iYoMeiInfoView.iv_youmei_headbg(),20);
        ImageUtil.loadCircleImageView(mContext,yoMeiDeatil.avatar.url, iYoMeiInfoView.iv_youmei_head(), R.mipmap.default_iamge);

        if (yoMeiDeatil.tags==null||yoMeiDeatil.tags.isEmpty())
            return;
        tagList.clear();
        tagList.addAll(yoMeiDeatil.tags);
        meinvTagsAdapter.notifyDataSetChanged();
    }

    public void onResultYoMeiDetailListSuccess(Object bean) {
        iYoMeiInfoView.getRefreshCommonView().finishRefresh();
        iYoMeiInfoView.getRefreshCommonView().finishLoadMore();
        if (bean == null)
            return;
        YoWuResult<List<YoMeiBean>> yoWuResult = (YoWuResult) bean;
        iYoMeiInfoView.tv_youmei_videonum().setText(yoWuResult.getMaxCount()+"个视频");
        meinvDeatilList.addAll(yoWuResult.getData());
        if (meinvDeatilList == null || meinvDeatilList.isEmpty()) {
            meinvDeatilList.clear();
            iYoMeiInfoView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iYoMeiInfoView.getRefreshCommonView().setIsEmpty(false);
            iYoMeiInfoView.getRefreshCommonView().setIsLoadMore(yoWuResult.getMaxPage() > pageMeinvDeatilNum);
        }
        meinvDeatilAdapter.notifyDataSetChanged();
    }


    private MiniVideoItemView iMiniVideoItemView;

    public void setMiniVideoItemView(MiniVideoItemView iMiniVideoItemView) {
        this.iMiniVideoItemView = iMiniVideoItemView;
    }

    public interface MiniVideoItemView {
        RefreshCommonView getRefreshCommonView();
    }

    private int tagId;

    public void setVideoItemParameter(Object... parameter) {
        tagId = (int) parameter[0];
    }

    private SimpleAdapter videoItemAdapter;
    private List<YouMeiVideoBean> videoItemList = new ArrayList<>();
    private int videoItemNum = 1;

    public void initMiniVideoItemDatas() {
        videoItemAdapter = new SimpleAdapter<YouMeiVideoBean>(mContext, videoItemList, R.layout.item_yomeivideo) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final YouMeiVideoBean localTheme) {
                /*holder.setText(R.id.tv_video_name, localTheme.getNick() + " (" + localTheme.getTitle() + ")")
                        .setText(R.id.tv_video_timer, "片长：" + localTheme.getSize())
                        .setText(R.id.tv_video_thumnum, localTheme.getBrowseCount() + "人查看")
                        .setText(R.id.tv_video_reward, localTheme.getIsVr() == 1 ? "已关注" : "关注");*/
                //ImageUtil.loadImageViewLoding(mContext, localTheme.getUrl(), holder.<ImageView>getView(R.id.iv_video_image), R.mipmap.default_iamge);
                /*holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mContext.startActivity(new Intent(mContext,HPlayerActivity.class).putExtra("ALBUM_INFO",localTheme));
                    }
                });*/
            }
        };
        iMiniVideoItemView.getRefreshCommonView().setIsAutoLoad(false);
        iMiniVideoItemView.getRefreshCommonView().setRecyclerViewAdapter(videoItemAdapter);
        iMiniVideoItemView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {

            @Override
            public void startRefresh() {
                videoItemNum = 1;
                videoItemList.clear();
                //presenter.getVideoItemList(tagId, videoItemNum);
            }

            @Override
            public void startLoadMore() {
                //presenter.getVideoItemList(tagId, ++videoItemNum);
            }
        });
    }

    public void onResultVideoItemSuccess(Object bean) {
        iMiniVideoItemView.getRefreshCommonView().finishRefresh();
        iMiniVideoItemView.getRefreshCommonView().finishLoadMore();
        if (bean == null)
            return;
        List<YouMeiVideoBean> list = (List<YouMeiVideoBean>) bean;
        videoItemList.addAll(list);
        if (videoItemList == null || videoItemList.isEmpty()) {
            videoItemList.clear();
            iMiniVideoItemView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iMiniVideoItemView.getRefreshCommonView().setIsEmpty(false);
            iMiniVideoItemView.getRefreshCommonView().setIsLoadMore(list.size() >= 20);
        }
        videoItemAdapter.notifyDataSetChanged();
    }

}

package com.zxin.marry.mvp.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zxin.marry.R;
import com.zxin.marry.activity.AllCircleActivity;
import com.zxin.marry.activity.HomeCircleActivity;
import com.zxin.marry.activity.MessageActivity;
import com.zxin.marry.activity.TopicActivity;
import com.zxin.marry.bean.CircleForm;
import com.zxin.marry.bean.MarriageCircleForm;
import com.zxin.marry.bean.RecommendForm;
import com.zxin.marry.bean.TopicForm;
import com.zxin.marry.mvp.presenter.MainCriclePresenter;
import com.zxin.marry.util.AdvItemClickListener;
import com.zxin.marry.view.BannerHolderView;
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

public class MainCricleContract implements IBaseView, RefreshCommonView.RefreshLoadMoreListener {
    private SimpleAdapter horAdapter,topicAdapter;
    private List<CircleForm.Circle> circleList = new ArrayList<>();
    private List<TopicForm.Theme> topicList = new ArrayList<>();
    private List<RecommendForm.RecommendAdv> adList = new ArrayList<>();
    private Context mContext;

    @Override
    public void setParameter(Object... parameter) {

    }

    @Override
    public void initDatas() {
        iView.getConvenientBannerView().startTurning(5000L).setPageIndicator(new int[] { R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused }).setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
        iView.getConvenientBannerView().setPages(new CBViewHolderCreator<BannerHolderView>() {
            @Override
            public BannerHolderView createHolder() {
                return new BannerHolderView();
            }
        }, adList);
        iView.getConvenientBannerView().setOnItemClickListener(new AdvItemClickListener(mContext,adList));

        iView.getDragView().setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.HORIZONTAL));
        horAdapter = new SimpleAdapter<CircleForm.Circle>(mContext, circleList, R.layout.item_circle_horizontal) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final CircleForm.Circle localCircle) {
                holder.setText(R.id.tv_title, localCircle.getCircle_name())
                        .setText(R.id.tv_describe,String.format("%s话题", new Object[] { localCircle.getCircle_thcount() }));
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, HomeCircleActivity.class);
                        intent.putExtra("Circle", localCircle);
                        mContext.startActivity(intent);
                    }
                });
                ImageUtil.loadImageViewLoding(mContext, localCircle.getCircle_smallimg(), holder.<SimpleDraweeView>getView(R.id.imageView), R.mipmap.default_iamge);
            }
        };
        iView.getDragView().setAdapter(horAdapter);

        topicAdapter = new SimpleAdapter<TopicForm.Theme>(mContext, topicList, R.layout.item_marriage_circle) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final TopicForm.Theme localTheme) {
                holder.setText(R.id.tv_type, localTheme.getCircle_name())
                        .setText(R.id.tv_title,localTheme.getTheme_name())
                        .setText(R.id.tv_content,localTheme.getTheme_content())
                        .setText(R.id.tv_author,localTheme.getMember_name())
                        .setText(R.id.tv_laud,localTheme.getTheme_likecount())
                        .setText(R.id.tv_reply,localTheme.getTheme_commentcount());
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, TopicActivity.class);
                        intent.putExtra("Theme", localTheme);
                        intent.putExtra("CircleId", localTheme.getCircle_id());
                        mContext.startActivity(intent);
                    }
                });
                ImageUtil.loadImageViewLoding(mContext, localTheme.getHas_affix_url(), holder.<SimpleDraweeView>getView(R.id.imageView), R.mipmap.default_iamge);
                ImageUtil.loadCircleImageView(mContext, localTheme.getMember_avatar(), holder.<ImageView>getView(R.id.civ), R.mipmap.default_iamge);
            }
        };
        iView.getRefreshCommonView().setRecyclerViewAdapter(topicAdapter);
        iView.getRefreshCommonView().setRefreshLoadMoreListener(this);
    }

    @Override
    public void startRefresh() {
        presenter.getHomeList();
    }

    @Override
    public void startLoadMore() {

    }

    @Override
    public void loadDatas() {

    }

    @Override
    public void onResultSuccess(Object bean) {
        finishLoad();
        if (bean == null)
            return;
        topicList.clear();
        adList.clear();
        circleList.clear();

        MarriageCircleForm datas = (MarriageCircleForm) bean;
        adList.addAll(datas.getData().getAdv());
        iView.getConvenientBannerView().notifyDataSetChanged();

        circleList.addAll(datas.getData().getCirclesindex());
        if (circleList==null||circleList.isEmpty()){
            iView.getMoreView().setVisibility(View.GONE);
            iView.getDragView().setVisibility(View.GONE);
        }else{
            iView.getMoreView().setVisibility(View.VISIBLE);
            iView.getDragView().setVisibility(View.VISIBLE);
            horAdapter.notifyDataSetChanged();
        }

        topicList.addAll(datas.getData().getThemesindex());
        if (topicList==null||topicList.isEmpty()) {
            topicList.clear();
            iView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iView.getRefreshCommonView().setIsEmpty(false);
            iView.getRefreshCommonView().setIsLoadMore(false);
        }
        topicAdapter.notifyDataSetChanged();
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

    private MainCriclePresenter presenter;

    @Override
    public void setP(BasePresenter... basePresenter) {
        presenter = (MainCriclePresenter) basePresenter[0];
    }

    @Override
    public void OnClick(View v) {
        if (v.getId()==R.id.common_bar_rightBtn){
            mContext.startActivity(new Intent(mContext, MessageActivity.class));
        }else if (v.getId()==R.id.ll_more){
            Intent intent = new Intent(mContext, AllCircleActivity.class);
            mContext.startActivity(intent);
        }
    }

    private MainCricleView iView;

    public void setMainCricleViewListener(MainCricleView testView) {
        this.iView = testView;
    }

    public interface MainCricleView {
        ConvenientBanner<RecommendForm.RecommendAdv> getConvenientBannerView();
        RefreshCommonView getRefreshCommonView();
        CommonCrosswiseBar getMoreView();
        RecyclerView getDragView();
    }

    public void finishLoad() {
        iView.getRefreshCommonView().finishRefresh();
        iView.getRefreshCommonView().finishLoadMore();
    }
}

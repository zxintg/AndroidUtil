package com.zxin.marry.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zhy.view.flowlayout.TagFlowLayout;
import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.marry.bean.TopicForm;
import com.zxin.marry.mvp.presenter.TopicPresenter;
import com.zxin.marry.mvp.view.MainTopicContract;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.view.RefreshCommonView;

/**
 * Created by Administrator on 2018/6/14.
 */

public class TopicActivity extends BaseActivity implements MainTopicContract.MainTopicView {

    @InjectPresenter
    TopicPresenter presenter;

    private TopicForm.Theme theme;

    @Override
    public void initData() {
        theme = getIntent().getParcelableExtra("Theme");
        setTitleViewOnclick(R.id.ccb_marray_title,R.id.common_bar_leftBtn);
        presenter.initDatas(this,theme);
        presenter.getTopicDetail(theme.getTheme_id());
    }

    @Override
    public int setLayout() {
        return R.layout.activity_topic;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_leftBtn){
            onBackPressed();
        }
    }


    @Override
    public SimpleDraweeView getCivView() {
        return getViewById(R.id.civ);
    }

    @Override
    public TextView getNickView() {
        return getViewById(R.id.tv_nick);
    }

    @Override
    public SimpleDraweeView getEssenceView() {
        return getViewById(R.id.iv_essence);
    }

    @Override
    public SimpleDraweeView getRecommendView() {
        return getViewById(R.id.iv_recommend);
    }

    @Override
    public TextView getTitleView() {
        return getViewById(R.id.tv_title);
    }

    @Override
    public TagFlowLayout getTagFlowLayoutView() {
        return getViewById(R.id.tagFlowLayout);
    }

    @Override
    public TextView getContentView() {
        return getViewById(R.id.tv_content);
    }

    @Override
    public RecyclerView getHeadRecyclerView() {
        return getViewById(R.id.rcv_headtopic_recyclerView);
    }

    @Override
    public TextView getDayView() {
        return getViewById(R.id.tv_day);
    }

    @Override
    public TextView getLaudView() {
        return getViewById(R.id.tv_laud);
    }

    @Override
    public TextView getReplyView() {
        return getViewById(R.id.tv_reply);
    }

    @Override
    public RefreshCommonView getRefreshCommonView() {
        return getViewById(R.id.rcv_topic_commonlayout);
    }
}

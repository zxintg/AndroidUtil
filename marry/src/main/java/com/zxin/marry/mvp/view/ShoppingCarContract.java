package com.zxin.marry.mvp.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zhy.view.flowlayout.TagFlowLayout;
import com.zxin.marry.R;
import com.zxin.marry.bean.CircleForm;
import com.zxin.marry.mvp.presenter.TopicPresenter;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.network.mvp.view.IBaseView;
import com.zxin.root.adapter.simple.SimpleAdapter;
import com.zxin.root.adapter.simple.TrdViewHolder;
import com.zxin.root.util.ImageUtil;
import com.zxin.root.util.UiUtils;
import com.zxin.root.view.RefreshCommonView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/24.
 */

public class ShoppingCarContract implements IBaseView{
    private SimpleAdapter topicHeadAdapter;
    private List<CircleForm.Affix> replyHeadList = new ArrayList<>();
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
        if (bean == null)
            return;

    }

    public void onResultCartListSuccess(Object bean) {
        if (bean == null)
            return;
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

    private TopicPresenter presenter;

    @Override
    public void setP(BasePresenter... basePresenter) {
        presenter = (TopicPresenter) basePresenter[0];
    }

    @Override
    public void OnClick(View v) {

    }

    private MainTopicView iView;

    public void setMainTopicViewListener(MainTopicView testView) {
        this.iView = testView;
    }


    public interface MainTopicView {
        SimpleDraweeView getCivView();
        TextView getNickView();
        SimpleDraweeView getEssenceView();
        SimpleDraweeView getRecommendView();
        TextView getTitleView();
        TagFlowLayout getTagFlowLayoutView();
        TextView getContentView();
        RecyclerView getHeadRecyclerView();
        TextView getDayView();
        TextView getLaudView();
        TextView getReplyView();
        RefreshCommonView getRefreshCommonView();
    }
}

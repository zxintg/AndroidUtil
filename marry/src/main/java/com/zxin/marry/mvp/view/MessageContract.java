package com.zxin.marry.mvp.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zxin.marry.R;
import com.zxin.marry.activity.HomeCircleActivity;
import com.zxin.marry.bean.CircleForm;
import com.zxin.marry.bean.HybridMessageBean;
import com.zxin.marry.mvp.presenter.CirclePresenter;
import com.zxin.marry.mvp.presenter.MessagePresenter;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.network.mvp.view.IBaseView;
import com.zxin.root.adapter.simple.SimpleAdapter;
import com.zxin.root.adapter.simple.TrdViewHolder;
import com.zxin.root.util.ImageUtil;
import com.zxin.root.view.RefreshCommonView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/24.
 */

public class MessageContract implements IBaseView,RefreshCommonView.RefreshLoadMoreListener{
    private SimpleAdapter adapter;
    private List<HybridMessageBean.Info> messageList = new ArrayList<>();
    private Context mContext;

    @Override
    public void setParameter(Object... parameter) {

    }

    @Override
    public void initDatas() {
        messageList.clear();
        adapter = new SimpleAdapter<HybridMessageBean.Info>(mContext, messageList, R.layout.item_hybridmessage) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final HybridMessageBean.Info data) {
                holder.setText(R.id.tv_name,data.getTitle())
                        .setText(R.id.tv_detail,data.getContent())
                        .setText(R.id.tv_date,data.getFormatTime());
                if (data.getIsread().equals("0")) {
                    if (data.getIstype().equals("0")) {
                        holder.setText(R.id.tv_tag,messageBean.getIsread0())
                        .setVisible(R.id.tv_tag,false);
                    }
                }
                if (data.getIstype().equals("1")){
                    holder.setText(R.id.tv_tag,messageBean.getIsread1());
                }
                ImageUtil.loadImageViewLoding(mContext, data.getImgsrc(), holder.<SimpleDraweeView>getView(R.id.iv_message), R.mipmap.default_iamge, R.mipmap.default_iamge);
            }
        };
        iMesssageView.getRefreshCommonView().setRecyclerViewAdapter(adapter);
        iMesssageView.getRefreshCommonView().setRefreshLoadMoreListener(this);
    }

    @Override
    public void loadDatas() {

    }

    private HybridMessageBean messageBean;
    @Override
    public void onResultSuccess(Object bean) {
        finishLoad();
        messageBean = (HybridMessageBean)bean;
        messageList.addAll(messageBean.getInfo());
        if (messageList.isEmpty()) {
            messageList.clear();
            iMesssageView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iMesssageView.getRefreshCommonView().setIsEmpty(false);
            iMesssageView.getRefreshCommonView().setIsLoadMore(false);
        }
        adapter.notifyDataSetChanged();
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

    private MessagePresenter presenter;

    @Override
    public void setP(BasePresenter... basePresenter) {
        presenter = (MessagePresenter) basePresenter[0];
    }

    @Override
    public void OnClick(View v) {

    }

    private MainMesssageView iMesssageView;

    public void setMesssageViewListener(MainMesssageView iMesssageView) {
        this.iMesssageView = iMesssageView;
    }

    @Override
    public void startRefresh() {
        messageList.clear();
        presenter.getMessageList();
    }

    @Override
    public void startLoadMore() {

    }

    public interface MainMesssageView {
        RefreshCommonView getRefreshCommonView();
    }

    public void finishLoad() {
        iMesssageView.getRefreshCommonView().finishRefresh();
        iMesssageView.getRefreshCommonView().finishLoadMore();
    }
}

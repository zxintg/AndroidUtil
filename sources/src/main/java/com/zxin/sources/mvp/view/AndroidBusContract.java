package com.zxin.sources.mvp.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.zxin.basemodel.util.HtmlJumpUtil;
import com.zxin.network.bean.AndroidBusResultBean;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.network.mvp.view.IBaseView;
import com.zxin.sources.R;
import com.zxin.sources.mvp.presenter.AndroidBusPresenter;
import com.zxin.root.adapter.simple.SimpleAdapter;
import com.zxin.root.adapter.simple.TrdViewHolder;
import com.zxin.root.bean.AndroidBusBean;
import com.zxin.root.util.ImageUtil;
import com.zxin.root.util.ToastUtil;
import com.zxin.root.view.CommonCrosswiseBar;
import com.zxin.root.view.RefreshCommonView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/24.
 */

public class AndroidBusContract implements IBaseView,RefreshCommonView.RefreshLoadMoreListener{
    private SimpleAdapter adapter;
    private List<AndroidBusBean> codeKKList = new ArrayList<>();
    private Context mContext;

    @Override
    public void setParameter(Object... parameter) {

    }

    @Override
    public void initDatas() {
        adapter = new SimpleAdapter<AndroidBusBean>(mContext, codeKKList, R.layout.item_androidbus) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final AndroidBusBean data) {
                holder.setText(R.id.item_androidbus_title, data.title)
                        .setText(R.id.item_androidbus_content,data.desc)
                        .setText(R.id.item_androidbus_time,data.time)
                        .setText(R.id.item_androidbus_name,data.userNmae);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        HtmlJumpUtil.toWebForUrlActivity( data.title,data.linkUrl);
                    }
                });
                ImageUtil.loadImageViewLoding(mContext, data.imageUrl, holder.<ImageView>getView(R.id.item_androidbus_iamge), R.mipmap.default_iamge);
                ImageUtil.loadCircleImageView(mContext, data.headImgUrl, holder.<ImageView>getView(R.id.item_androidbus_head), R.mipmap.default_iamge);
            }
        };
        iView.getRecyclerView().setRecyclerViewAdapter(adapter);
        iView.getRecyclerView().setRefreshLoadMoreListener(this);
    }

    @Override
    public void loadDatas() {
        iView.getRecyclerView().notifyData();
    }

    @Override
    public void onResultSuccess(Object bean) {
        finishLoad();
        if (bean==null)
            return;
        AndroidBusResultBean androidBus = (AndroidBusResultBean) bean;
        codeKKList.addAll(androidBus.androidBusList);
        if (codeKKList.isEmpty()) {
            codeKKList.clear();
            iView.getRecyclerView().setIsEmpty(true);
        } else {
            iView.getRecyclerView().setIsEmpty(false);
            iView.getRecyclerView().setIsLoadMore(androidBus.pageNum<androidBus.totalPage);
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

    private AndroidBusPresenter presenter;
    @Override
    public void setP(BasePresenter... basePresenter) {
        presenter = (AndroidBusPresenter) basePresenter[0];
    }

    @Override
    public void OnClick(View v) {

    }

    private int pageNum = 1;
    @Override
    public void startRefresh() {
        pageNum = 1;
        codeKKList.clear();
        presenter.getAndroidBusList(pageNum);
    }

    @Override
    public void startLoadMore() {
        pageNum++;
        presenter.getAndroidBusList(pageNum);
    }


    private AndroidBusView iView;

    public void setAndroidBusViewListener(AndroidBusView testView){
        this.iView = testView;
    }
    public interface AndroidBusView{
        RefreshCommonView getRecyclerView();
    }

    public void finishLoad(){
        iView.getRecyclerView().finishRefresh();
        iView.getRecyclerView().finishLoadMore();
    }
}

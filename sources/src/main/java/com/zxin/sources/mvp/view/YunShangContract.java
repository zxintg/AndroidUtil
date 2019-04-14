package com.zxin.sources.mvp.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.zxin.basemodel.util.HtmlJumpUtil;
import com.zxin.network.bean.CodeKKResultBean;
import com.zxin.network.bean.YunShangResultBean;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.network.mvp.view.IBaseView;
import com.zxin.sources.R;
import com.zxin.sources.mvp.presenter.CodeKKPresenter;
import com.zxin.sources.mvp.presenter.YunShangPresenter;
import com.zxin.root.adapter.simple.SimpleAdapter;
import com.zxin.root.adapter.simple.TrdViewHolder;
import com.zxin.root.bean.CodeKKBean;
import com.zxin.root.bean.TitleBean;
import com.zxin.root.bean.YunShangBean;
import com.zxin.root.util.ImageUtil;
import com.zxin.root.util.ToastUtil;
import com.zxin.root.view.CommonCrosswiseBar;
import com.zxin.root.view.RefreshCommonView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/24.
 */

public class YunShangContract implements IBaseView,RefreshCommonView.RefreshLoadMoreListener{
    private SimpleAdapter adapter;
    private List<YunShangBean> codeKKList = new ArrayList<>();
    private Context mContext;

    @Override
    public void setParameter(Object... parameter) {

    }

    @Override
    public void initDatas() {
        adapter = new SimpleAdapter<YunShangBean>(mContext, codeKKList, R.layout.item_yunshangji) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final YunShangBean data) {
                holder.setText(R.id.item_yunshangji_title, data.name)
                        .setText(R.id.item_yunshangji_content,data.content)
                        .<CommonCrosswiseBar>getView(R.id.item_yunshangji_time).setRightText(data.time);
                holder.<CommonCrosswiseBar>getView(R.id.item_yunshangji_product).setRightText(data.product);
                holder.<CommonCrosswiseBar>getView(R.id.item_yunshangji_address).setRightText(data.address);
                holder.<CommonCrosswiseBar>getView(R.id.item_yunshangji_call).setRightText(data.call);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtil.showShort(data.linkUrl);
                    }
                });
                ImageUtil.loadImageViewLoding(mContext, data.imageUrl, holder.<ImageView>getView(R.id.item_yunshangji_iamge), R.mipmap.default_iamge, R.mipmap.default_iamge);
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
        YunShangResultBean codeKK = (YunShangResultBean) bean;
        codeKKList.addAll(codeKK.yunShangList);
        if (codeKKList.isEmpty()) {
            codeKKList.clear();
            iView.getRecyclerView().setIsEmpty(true);
        } else {
            iView.getRecyclerView().setIsEmpty(false);
            iView.getRecyclerView().setIsLoadMore(true);
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

    private YunShangPresenter presenter;
    @Override
    public void setP(BasePresenter... basePresenter) {
        presenter = (YunShangPresenter) basePresenter[0];
    }

    @Override
    public void OnClick(View v) {

    }

    private int pageNum = 1;
    @Override
    public void startRefresh() {
        pageNum = 1;
        codeKKList.clear();
        presenter.getYunShangList(pageNum);
    }

    @Override
    public void startLoadMore() {
        pageNum++;
        presenter.getYunShangList(pageNum);
    }


    private YunShangView iView;

    public void setYunShangViewListener(YunShangView testView){
        this.iView = testView;
    }
    public interface YunShangView{
        RefreshCommonView getRecyclerView();
    }

    public void finishLoad(){
        iView.getRecyclerView().finishRefresh();
        iView.getRecyclerView().finishLoadMore();
    }
}

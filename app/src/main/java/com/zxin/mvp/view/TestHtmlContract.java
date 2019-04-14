package com.zxin.mvp.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.zxin.R;
import com.zxin.mvp.presenter.MeiZiHtmlPresenter;
import com.zxin.network.bean.DoubanMeizi;
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

public class TestHtmlContract implements IBaseView,RefreshCommonView.RefreshLoadMoreListener{
    private SimpleAdapter adapter;
    private List<DoubanMeizi> meiziTuList = new ArrayList<>();
    private Context context;

    @Override
    public void setParameter(Object... parameter) {

    }

    @Override
    public void initDatas() {
        meiziTuList.clear();
        adapter = new SimpleAdapter<DoubanMeizi>(context, meiziTuList, R.layout.item_test) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final DoubanMeizi data) {
                holder.setText(R.id.tv_item_title,data.getTitle());
                ImageUtil.loadImageViewLoding(mContext, data.getUrl(), holder.<ImageView>getView(R.id.im_item_photo), R.mipmap.default_iamge, R.mipmap.default_iamge);
            }
        };
        iView.getRecyclerView().setRecyclerViewAdapter(adapter);
        iView.getRecyclerView().setRefreshLoadMoreListener(this);
    }

    @Override
    public void loadDatas() {

    }

    @Override
    public void onResultSuccess(Object bean) {
        finishLoad();
        meiziTuList.addAll((List<DoubanMeizi>)bean);
        if (meiziTuList.isEmpty()) {
            meiziTuList.clear();
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
        this.context = context;
    }

    @Override
    public void setP(BasePresenter... basePresenter) {
        presenter = (MeiZiHtmlPresenter) basePresenter[0];
    }

    @Override
    public void OnClick(View v) {

    }

    private int pageNum = 1;
    @Override
    public void startRefresh() {
        pageNum = 1;
        meiziTuList.clear();
        presenter.getTestMeiZi(pageNum);
    }

    @Override
    public void startLoadMore() {
        pageNum++;
        presenter.getTestMeiZi(pageNum);
    }

    private MeiZiHtmlPresenter presenter;

    private TestView iView;

    public void setTestViewListener(TestView testView){
        this.iView = testView;
    }
    public interface TestView{
        RefreshCommonView getRecyclerView();
    }

    public void finishLoad(){
        iView.getRecyclerView().finishRefresh();
        iView.getRecyclerView().finishLoadMore();
    }
}

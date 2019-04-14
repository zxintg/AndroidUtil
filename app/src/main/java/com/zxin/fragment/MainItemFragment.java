package com.zxin.fragment;

import android.os.Bundle;
import android.view.View;

import com.zxin.R;
import com.zxin.base.BaseFragment;
import com.zxin.util.StringUtils;
import com.zxin.root.adapter.simple.SimpleAdapter;
import com.zxin.root.adapter.simple.TrdViewHolder;
import com.zxin.root.bean.BasePageBean;
import com.zxin.root.bean.HttpUrlBean;
import com.zxin.root.bean.TitleBean;
import com.zxin.root.view.RefreshCommonView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/5/16.
 */

public class MainItemFragment extends BaseFragment implements BaseFragment.LazyLoadingListener,RefreshCommonView.RefreshLoadMoreListener{
    @BindView(R.id.rcv_mine_commonlayout)
    RefreshCommonView refreshCommonView;

    private SimpleAdapter adapter;
    private TitleBean titleBean;
    private List<HttpUrlBean> httpUrlList = new ArrayList<>();

    public static MainItemFragment newInstance(TitleBean titleBean) {
        MainItemFragment fragment = new MainItemFragment();
        Bundle args = new Bundle();
        args.putParcelable(StringUtils.FRAGMENT_DATA, titleBean);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        httpUrlList.clear();
        titleBean = getArguments().getParcelable(StringUtils.FRAGMENT_DATA);

        adapter = new SimpleAdapter<HttpUrlBean>(mContext, httpUrlList, R.layout.item_urlview) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final HttpUrlBean data) {
                holder.setText(R.id.item_url_title, data.name);
            }
        };
        refreshCommonView.setRecyclerViewAdapter(adapter);
        refreshCommonView.setIsAutoLoad(false);
        refreshCommonView.setRefreshLoadMoreListener(this);
        setLazyLoadingListener(this);
    }

    @Override
    public int setLayout() {
        return R.layout.common_refresh_notitle;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void loadLazyDatas(boolean bool) {
        refreshCommonView.notifyData();
    }

    private int pageNum = 0;
    @Override
    public void startRefresh() {
        pageNum = 0;
        httpUrlList.clear();
        loadDatas();
    }

    @Override
    public void startLoadMore() {
        pageNum++;
        loadDatas();
    }

    private void loadDatas() {

    }

    private void finishLoad(){
        refreshCommonView.finishRefresh();
        refreshCommonView.finishLoadMore();
    }

    private BasePageBean getLoadDatas(){
        BasePageBean basePageBean = new BasePageBean<>();
        basePageBean.setPageNum(pageNum);
        basePageBean.setHasNextPage(pageNum<10);
        if (pageNum==0){
            for (int i=0;i<15;i++){
                HttpUrlBean httpUrlBean = new HttpUrlBean();
                httpUrlBean.id = i;
                httpUrlBean.name = "名称："+titleBean.title+(i<10?"0"+i:i);
                httpUrlList.add(httpUrlBean);
            }
        }else{
            long id = httpUrlList.get(httpUrlList.size()-1).id;
            for (int i=1;i<=15;i++){
                HttpUrlBean httpUrlBean = new HttpUrlBean();
                httpUrlBean.id = id+i;
                httpUrlBean.name = "名称："+titleBean.title+(httpUrlBean.id<10?"0"+httpUrlBean.id:httpUrlBean.id);
                httpUrlList.add(httpUrlBean);
            }
        }

        basePageBean.setList(httpUrlList);
        return basePageBean;
    }

}

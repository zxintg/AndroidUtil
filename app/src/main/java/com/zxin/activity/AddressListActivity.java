package com.zxin.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zxin.R;
import com.zxin.base.BaseActivity;
import com.zxin.util.StringUtils;
import com.zxin.root.adapter.simple.SimpleAdapter;
import com.zxin.root.adapter.simple.TrdViewHolder;
import com.zxin.root.bean.BasePageBean;
import com.zxin.root.bean.HttpUrlBean;
import com.zxin.basemodel.dao.HttpUrlDaoUtil;
import com.zxin.root.util.IntegerUtil;
import com.zxin.root.view.RefreshCommonView;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 地址列表 on 2018/5/11.
 */
public class AddressListActivity extends BaseActivity implements RefreshCommonView.RefreshLoadMoreListener {
    @BindView(R.id.rcv_address_commonlayout)
    RefreshCommonView mRefreshCommonView;

    private SimpleAdapter adapter;
    private List<HttpUrlBean> urlList = new ArrayList<>();

    @Override
    public void initData() {
        urlList.clear();
        adapter = new SimpleAdapter<HttpUrlBean>(mContext, urlList, R.layout.item_address_httpurl) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final HttpUrlBean data) {
                holder.setText(R.id.item_address_num,"第"+String.valueOf(urlList.indexOf(data)+1)+"条")
                        .setText(R.id.item_address_name,"地址名称："+data.name)
                        .setText(R.id.item_address_url, "网络路径："+data.url)
                        .setText(R.id.item_address_times, "浏览次数：共"+data.times+"次")
                        .setText(R.id.item_address_isused, data.isEffective==1?"有效":"无效")
                        .setOnItemListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(mContext,HttpUrlDetailActivity.class);
                                intent.putExtra(StringUtils.ACTIVITY_DATA,data.id);
                                startActivity(intent);
                            }
                        });

            }
        };
        mRefreshCommonView.setRecyclerViewAdapter(adapter);
        mRefreshCommonView.setRefreshLoadMoreListener(this);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_addresslist;
    }

    @OnClick({R.id.common_bar_leftBtn,R.id.common_bar_rightBtn})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.common_bar_leftBtn:
                onBackPressed();
                break;

            case R.id.common_bar_rightBtn:
                //添加
                startActivity(new Intent(mContext, EditHttpUrlActivity.class));
                break;
        }
    }

    private int pageNum = 1;
    @Override
    public void startRefresh() {
        pageNum = 1;
        urlList.clear();
        getDatas();
    }

    @Override
    public void startLoadMore() {
        pageNum++;
        getDatas();
    }

    private void getDatas(){
        mRefreshCommonView.postDelayed(new Runnable() {
            @Override
            public void run() {
                BasePageBean httpUrl = HttpUrlDaoUtil.getInstance().getHttpUrlList(pageNum, 10);
                mRefreshCommonView.finishLoadMore();
                mRefreshCommonView.finishRefresh();
                List<HttpUrlBean> httpUrlList = httpUrl.getList();
                if (urlList.isEmpty()&&httpUrlList.isEmpty()){
                    //无数据
                    mRefreshCommonView.setIsEmpty(true);
                    return;
                }else{
                    mRefreshCommonView.setIsLoadMore(httpUrl.isHasNextPage());
                }
                urlList.addAll(httpUrlList);
                adapter.notifyDataSetChanged();
            }
        },1000);
    }
    //接受event事件
    @Override
    public boolean onEventMainThread(Bundle bundle) {
        switch (bundle.getInt(StringUtils.EVENT_ID)) {
            case IntegerUtil.EVENT_ID_11001:
                //添加标签后刷新界面
                mRefreshCommonView.notifyData();
                break;

        }
        return false;
    }
}

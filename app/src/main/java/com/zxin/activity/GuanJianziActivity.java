package com.zxin.activity;

import android.view.View;

import com.zxin.R;
import com.zxin.base.BaseActivity;
import com.zxin.root.adapter.simple.SimpleAdapter;
import com.zxin.root.adapter.simple.TrdViewHolder;
import com.zxin.root.bean.GuanJianZiBean;
import com.zxin.root.view.RefreshCommonView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/5/11.
 */

public class GuanJianziActivity extends BaseActivity implements RefreshCommonView.RefreshLoadMoreListener {
    @BindView(R.id.rcv_guanjianzi_commonlayout)
    RefreshCommonView mRefreshCommonView;

    private SimpleAdapter adapter;
    private List<GuanJianZiBean> urlList = new ArrayList<>();

    @Override
    public void initData() {
        urlList.clear();
        adapter = new SimpleAdapter<GuanJianZiBean>(mContext, urlList, R.layout.item_guanjianzi_lable) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final GuanJianZiBean data) {
                holder.setText(R.id.item_guanjianzi_lable, data.lable)

                        .setOnItemListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });

            }
        };
        mRefreshCommonView.setRecyclerViewAdapter(adapter);
        mRefreshCommonView.setIsAutoLoad(false);
        mRefreshCommonView.setRefreshLoadMoreListener(this);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_guanjianzi;
    }


    @OnClick({R.id.common_bar_leftBtn})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.common_bar_leftBtn:
                onBackPressed();
                break;
        }
    }


    @Override
    public void startRefresh() {

    }

    @Override
    public void startLoadMore() {

    }
}

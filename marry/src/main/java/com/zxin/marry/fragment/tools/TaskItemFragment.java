package com.zxin.marry.fragment.tools;

import android.os.Bundle;
import android.view.View;
import com.zxin.marry.R;
import com.zxin.marry.base.BaseFragment;
import com.zxin.marry.mvp.presenter.ToolsPresenter;
import com.zxin.marry.mvp.view.ToolsContract;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.view.RefreshCommonView;

/**
 * Created by Administrator on 2018/7/12.
 */

public class TaskItemFragment extends BaseFragment implements BaseFragment.LazyLoadingListener ,ToolsContract.TaskItemView {
    private String taskType;

    @InjectPresenter
    ToolsPresenter presenter;

    public static TaskItemFragment newInstance(String taskType) {
        TaskItemFragment fragment = new TaskItemFragment();
        Bundle args = new Bundle();
        args.putString("taskType", taskType);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        taskType = getArguments().getString("taskType");
        presenter.initTaskItemDatas(this,taskType);
        setLazyLoadingListener(this);
    }

    @Override
    public int setLayout() {
        return R.layout.common_refresh_exnotitle;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void loadLazyDatas(boolean bool) {
        getRefreshCommonView().notifyData();
    }

    @Override
    public RefreshCommonView getRefreshCommonView() {
        return getViewById(R.id.rcv_mine_commonlayout);
    }
}

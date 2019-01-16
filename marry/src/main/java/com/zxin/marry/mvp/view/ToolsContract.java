package com.zxin.marry.mvp.view;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.baidu.mapapi.search.poi.PoiAddrInfo;
import com.zxin.marry.R;
import com.zxin.marry.adapter.MyExpandableTaskAdapter;
import com.zxin.marry.bean.MainBarBean;
import com.zxin.marry.bean.MarryRegistList;
import com.zxin.marry.bean.TaskListCommon;
import com.zxin.marry.bean.UserCommon;
import com.zxin.marry.mvp.presenter.ToolsPresenter;
import com.zxin.marry.util.TitleBarUtil;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.network.mvp.view.IBaseView;
import com.zxin.zxinlib.adapter.SimpleAdapter.SimpleAdapter;
import com.zxin.zxinlib.adapter.SimpleAdapter.TrdViewHolder;
import com.zxin.zxinlib.adapter.ViewPageFragmentAdapter;
import com.zxin.zxinlib.util.UiUtils;
import com.zxin.zxinlib.view.RefreshCommonView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/24.
 */

public class ToolsContract implements IBaseView {
    private Context mContext;

    @Override
    public void setParameter(Object... parameter) {
    }

    private ArrayList<MainBarBean> titleList = new ArrayList<>();
    private List<Fragment> mFragmentList = new ArrayList<>();//页卡视图集合

    @Override
    public void initDatas() {
        titleList.clear();
        mFragmentList.clear();
        iToolsTaskView.getViewPagerView().removeAllViews();

        titleList.addAll(TitleBarUtil.newInstance().getTaskList());
        for (MainBarBean mainBar : titleList) {
            mFragmentList.add(mainBar.fragment);
        }
        iToolsTaskView.getViewPagerView().setAdapter(new ViewPageFragmentAdapter(mFragmentList, titleList));
        iToolsTaskView.getViewPagerView().setCurrentItem(0);
        iToolsTaskView.getViewPagerView().setOffscreenPageLimit(titleList.size());
        iToolsTaskView.getRGTaskView().setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                iToolsTaskView.getViewPagerView().setCurrentItem(Integer.parseInt(group.findViewById(checkedId).getTag() + ""));
            }
        });
        iToolsTaskView.getViewPagerView().addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                iToolsTaskView.getRGTaskView().check(position == 0 ? R.id.task_rb1 : position == 1 ? R.id.task_rb2 : R.id.task_rb3);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        iToolsTaskView.getViewPagerView().setCurrentItem(0);

    }

    @Override
    public void loadDatas() {

    }

    @Override
    public void onResultSuccess(Object bean) {
        if (bean == null) {
            iToolsTaskView.getTVDayTimeView().setText(UiUtils.getString(R.string.task_setting_marrydate));
            iToolsTaskView.getIMTaskDayView().setVisibility(View.GONE);
            return;
        }
        UserCommon user = (UserCommon) bean;
        if (user.getData().getMarrydate().equals("1970-01-01")) {
            iToolsTaskView.getTVDayTimeView().setText(UiUtils.getString(R.string.task_setting_marrydate));
            iToolsTaskView.getIMTaskDayView().setVisibility(View.GONE);
            return;
        } else {
            iToolsTaskView.getTVDayTimeView().setText(String.valueOf(user.getData().getMarrydate()));
            iToolsTaskView.getIMTaskDayView().setVisibility(View.VISIBLE);
        }
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

    private ToolsPresenter presenter;

    @Override
    public void setP(BasePresenter... basePresenter) {
        presenter = (ToolsPresenter) basePresenter[0];
    }

    @Override
    public void OnClick(View v) {

    }

    private ToolsTaskView iToolsTaskView;

    public void setToolsTaskViewListener(ToolsTaskView iToolsTaskView) {
        this.iToolsTaskView = iToolsTaskView;
    }

    public interface ToolsTaskView {
        ImageView getIMTaskBlurView();

        TextView getTVTaskTv1View();

        TextView getTVDayTimeView();

        ImageView getIMTaskDayView();

        RadioGroup getRGTaskView();

        ViewPager getViewPagerView();
    }

    private TaskItemView iTaskItemView;

    public void setTaskItemViewListener(TaskItemView iTaskItemView) {
        this.iTaskItemView = iTaskItemView;
    }

    public interface TaskItemView {
        RefreshCommonView getRefreshCommonView();
    }

    private String taskType;

    public void setTaskItemViewParameter(Object... parameter) {
        taskType = (String) parameter[0];
    }

    private MyExpandableTaskAdapter taskAdapter;
    private List<TaskListCommon.TaskCommon> taskCommonsList = new ArrayList<>();

    public void initTaskItemViewDatas() {
        taskAdapter = new MyExpandableTaskAdapter(mContext, taskCommonsList);
        iTaskItemView.getRefreshCommonView().setIsAutoLoad(false);
        iTaskItemView.getRefreshCommonView().setIsLoadMore(false);
        iTaskItemView.getRefreshCommonView().setExpandableListViewAdapter(taskAdapter);
        iTaskItemView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {
            @Override
            public void startRefresh() {
                presenter.getTaskList(taskType);
            }

            @Override
            public void startLoadMore() {

            }
        });
    }

    public void onResultTaskListSuccess(Object obj) {
        iTaskItemView.getRefreshCommonView().finishRefresh();
        if (obj == null)
            return;
        taskCommonsList.clear();
        TaskListCommon taskList = (TaskListCommon) obj;
        taskCommonsList.addAll(taskList.getList());
        if (taskCommonsList == null || taskCommonsList.isEmpty()) {
            taskCommonsList.clear();
            iTaskItemView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iTaskItemView.getRefreshCommonView().setIsEmpty(false);
            iTaskItemView.getRefreshCommonView().setIsLoadMore(false);
        }

        taskAdapter.notifyDataSetChanged();
        ExpandableListView listView = (ExpandableListView) iTaskItemView.getRefreshCommonView().getCurrentView();
        //遍历所有group,将所有项设置成默认展开
        for (int i = 0; i < taskCommonsList.size(); i++) {
            listView.expandGroup(i);
        }
    }


    private ToolsRegistView iToolsRegistView;

    public void setToolsRegistViewListener(ToolsRegistView iToolsRegistView) {
        this.iToolsRegistView = iToolsRegistView;
    }

    public interface ToolsRegistView {
        RefreshCommonView getRefreshCommonView();
    }

    private SimpleAdapter registAdapter;
    private List<MarryRegistList.MarryRegist> pointList = new ArrayList<>();
    public void initToolsRegistViewDatas(){
        pointList.clear();
        registAdapter = new SimpleAdapter<MarryRegistList.MarryRegist>(mContext,pointList,R.layout.ietm_registration) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, MarryRegistList.MarryRegist data) {
                holder.setText(R.id.tv_registration,data.getTitle())
                        .setText(R.id.tv_address,data.getAddress());
            }
        };
        iToolsRegistView.getRefreshCommonView().setRecyclerViewAdapter(registAdapter);
        iToolsRegistView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {
            private int pageNum = 1;
            @Override
            public void startRefresh() {
                pageNum = 1;
                pointList.clear();
                presenter.getMarryRegistList(pageNum);
            }

            @Override
            public void startLoadMore() {
                presenter.getMarryRegistList(++pageNum);
            }
        });
    }

    public void onResultRegistViewSuccess(Object obj) {
        iToolsRegistView.getRefreshCommonView().finishRefresh();
        iToolsRegistView.getRefreshCommonView().finishLoadMore();
        if (obj == null)
            return;
        MarryRegistList registList = (MarryRegistList) obj;
        pointList.addAll(registList.getContents());
        if (pointList == null || pointList.isEmpty()) {
            pointList.clear();
            iToolsRegistView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iToolsRegistView.getRefreshCommonView().setIsEmpty(false);
            iToolsRegistView.getRefreshCommonView().setIsLoadMore(registList.getTotal()>pointList.size());
        }
        registAdapter.notifyDataSetChanged();
    }

}

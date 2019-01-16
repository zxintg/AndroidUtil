package com.zxin.marry.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.marry.mvp.presenter.ToolsPresenter;
import com.zxin.marry.mvp.view.ToolsContract;
import com.zxin.network.mvp.inject.InjectPresenter;

/**
 * Created by Administrator on 2018/6/15.
 */

public class TaskActivity extends BaseActivity implements ToolsContract.ToolsTaskView{
    @InjectPresenter
    ToolsPresenter presenter;

    @Override
    public void initData() {
        presenter.initDatas(this);
        setTitleViewOnclick(R.id.ccb_marray_title,R.id.common_bar_leftBtn,R.id.common_bar_rightBtn);
        presenter.getUserMessage();
    }

    @Override
    public int setLayout() {
        return R.layout.activity_task;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_leftBtn){
            onBackPressed();
        }else if(v.getId()==R.id.common_bar_rightBtn){
            startActivity(new Intent(mContext, InformationTaskActivity.class));
        }
    }

    @Override
    public ImageView getIMTaskBlurView() {
        return getViewById(R.id.task_blur);
    }

    @Override
    public TextView getTVTaskTv1View() {
        return getViewById(R.id.task_tv1);
    }

    @Override
    public TextView getTVDayTimeView() {
        return getViewById(R.id.tv_day_time);
    }

    @Override
    public ImageView getIMTaskDayView() {
        return getViewById(R.id.task_day);
    }

    @Override
    public RadioGroup getRGTaskView() {
        return getViewById(R.id.rg_task);
    }

    @Override
    public ViewPager getViewPagerView() {
        return getViewById(R.id.vp_task);
    }
}

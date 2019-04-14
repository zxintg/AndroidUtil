package com.zxin.marry.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.zxin.marry.R;
import com.zxin.marry.activity.AuspiciousCalendarActivity;
import com.zxin.marry.activity.InvitationActivity;
import com.zxin.marry.activity.RegistrationActivity;
import com.zxin.marry.activity.SmallPhotosActivity;
import com.zxin.marry.activity.TaskActivity;
import com.zxin.marry.activity.WeddingBudgetActivity;
import com.zxin.marry.base.BaseFragment;
import com.zxin.marry.util.StringUtils;
import com.zxin.marry.util.TitleBarUtil;
import com.zxin.root.adapter.simple.SimpleAdapter;
import com.zxin.root.adapter.simple.TrdViewHolder;
import com.zxin.root.bean.TitleBean;
import com.zxin.root.bean.ToolsBean;
import com.zxin.root.util.ImageUtil;
import com.zxin.root.util.UiUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/13.
 */

public class ToolsFragment extends BaseFragment implements BaseFragment.LazyLoadingListener{
    private TitleBean titleBean;
    private RecyclerView recyclerView;
    private SimpleAdapter adapter;
    private List<ToolsBean> toolsList = new ArrayList<>();

    public static ToolsFragment newInstance(TitleBean titleBean) {
        ToolsFragment fragment = new ToolsFragment();
        Bundle args = new Bundle();
        args.putParcelable(StringUtils.FRAGMENT_DATA, titleBean);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        toolsList.clear();
        titleBean = getArguments().getParcelable(StringUtils.FRAGMENT_DATA);
        recyclerView = getViewById(R.id.rv_gv_tools);
        recyclerView.setLayoutManager(UiUtils.getGridLayoutManager(3));
        adapter = new SimpleAdapter<ToolsBean>(mContext,toolsList, R.layout.item_tools) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final ToolsBean toolsBean) {

                holder.setText(R.id.tv_toolsName, toolsBean.getName());
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switch (toolsBean.getId()) {

                            case 0:
                                startActivity(new Intent(mContext,TaskActivity.class));
                                break;

                            case 1:
                                startActivity(new Intent(mContext,InvitationActivity.class));
                                return;

                            case 2:
                                startActivity(new Intent(mContext,RegistrationActivity.class));
                                return;

                            case 3:
                                startActivity(new Intent(mContext,SmallPhotosActivity.class));
                                return;

                            case 4:
                                startActivity(new Intent(mContext,AuspiciousCalendarActivity.class));
                                return;

                            case 5:
                                startActivity(new Intent(mContext,WeddingBudgetActivity.class));
                                return;
                        }
                    }
                });
                ImageUtil.loadImageView(mContext, toolsBean.getImgRes(), holder.<ImageView>getView(R.id.iv_toolsImage));
            }
        };
        recyclerView.setAdapter(adapter);
        setLazyLoadingListener(this);
    }

    @Override
    public int setLayout() {
        return R.layout.fragment_tools;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void loadLazyDatas(boolean bool) {
        toolsList.addAll(TitleBarUtil.newInstance().getToolsList());
        adapter.notifyDataSetChanged();
    }
}

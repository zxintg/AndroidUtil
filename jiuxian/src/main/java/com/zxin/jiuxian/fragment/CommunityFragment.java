package com.zxin.jiuxian.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import com.zxin.jiuxian.R;
import com.zxin.jiuxian.base.BaseFragment;
import com.zxin.jiuxian.util.StringUtils;
import com.zxin.root.bean.TitleBean;
import com.zxin.root.util.SystemInfoUtil;

/**
 * Created by Administrator on 2018/8/6.
 */

public class CommunityFragment extends BaseFragment implements BaseFragment.LazyLoadingListener{
    private TitleBean titleBean;
    private RelativeLayout mHeadView;

    public static CommunityFragment newInstance(TitleBean titleBean) {
        CommunityFragment fragment = new CommunityFragment();
        Bundle args = new Bundle();
        args.putParcelable(StringUtils.FRAGMENT_DATA, titleBean);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        titleBean = getArguments().getParcelable(StringUtils.FRAGMENT_DATA);
        mHeadView = getViewById(R.id.rl_community_top);
        mHeadView.setPadding(mHeadView.getPaddingLeft(), mHeadView.getPaddingTop() + SystemInfoUtil.getStatusBarHeight(), mHeadView.getPaddingRight(),mHeadView.getPaddingBottom());
        setLazyLoadingListener(this);
    }

    @Override
    public int setLayout() {
        return R.layout.fragment_community;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void loadLazyDatas(boolean bool) {

    }
}

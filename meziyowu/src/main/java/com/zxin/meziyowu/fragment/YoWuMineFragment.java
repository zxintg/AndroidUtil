package com.zxin.meziyowu.fragment;

import android.os.Bundle;
import android.view.View;

import com.zxin.meziyowu.R;
import com.zxin.meziyowu.base.BaseFragment;
import com.zxin.meziyowu.util.StringUtils;
import com.zxin.root.bean.TitleBean;

/**
 * Created by Administrator on 2018/9/28.
 */

public class YoWuMineFragment extends BaseFragment implements BaseFragment.LazyLoadingListener{
    private TitleBean titleBean;

    public static YoWuMineFragment newInstance(TitleBean titleBean) {
        YoWuMineFragment fragment = new YoWuMineFragment();
        Bundle args = new Bundle();
        args.putParcelable(StringUtils.FRAGMENT_DATA, titleBean);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        titleBean = getArguments().getParcelable(StringUtils.FRAGMENT_DATA);

        setLazyLoadingListener(this);
    }

    @Override
    public int setLayout() {
        return R.layout.fragment_yowumine;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void loadLazyDatas(boolean bool) {

    }
}

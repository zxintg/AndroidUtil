package com.zxin.jiuxian.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import com.zxin.jiuxian.R;
import com.zxin.jiuxian.base.BaseFragment;
import com.zxin.jiuxian.mvp.presenter.ClassiftyPresenter;
import com.zxin.jiuxian.mvp.view.ClassiftyContract;
import com.zxin.jiuxian.util.StringUtils;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.zxinlib.bean.TitleBean;
import com.zxin.zxinlib.view.PagerSlidingVerTabStrip;
import com.zxin.zxinlib.view.MyViewPager;

/**
 * Created by Administrator on 2018/8/6.
 */

public class ClassifyFragment extends BaseFragment implements BaseFragment.LazyLoadingListener,ClassiftyContract.ClassifyView {
    @InjectPresenter
    ClassiftyPresenter presenter;

    private TitleBean titleBean;

    public static ClassifyFragment newInstance(TitleBean titleBean) {
        ClassifyFragment fragment = new ClassifyFragment();
        Bundle args = new Bundle();
        args.putParcelable(StringUtils.FRAGMENT_DATA, titleBean);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        titleBean = getArguments().getParcelable(StringUtils.FRAGMENT_DATA);
        setViewOnclick(R.id.tv_cate_search,R.id.iv_cate_scanning);
        presenter.initDatas(this);
        setLazyLoadingListener(this);
    }

    @Override
    public int setLayout() {
        return R.layout.fragment_cate;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void loadLazyDatas(boolean bool) {
        presenter.getCategoryList();
    }

    @Override
    public LinearLayout getCateHeadView() {
        return getViewById(R.id.ll_cate_head);
    }

    @Override
    public PagerSlidingVerTabStrip getPagerSlidingVerView() {
        return getViewById(R.id.pst_cate_title);
    }

    @Override
    public MyViewPager getVerticalViewPagerView() {
        return getViewById(R.id.vvp_cate_fragment);
    }
}

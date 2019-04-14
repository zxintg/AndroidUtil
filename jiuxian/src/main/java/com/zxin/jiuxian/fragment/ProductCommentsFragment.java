package com.zxin.jiuxian.fragment;

import android.os.Bundle;
import android.view.View;
import com.zxin.jiuxian.R;
import com.zxin.jiuxian.base.BaseFragment;
import com.zxin.jiuxian.util.StringUtils;
import com.zxin.root.bean.TitleBean;

/**
 * Created by Administrator on 2018/8/17.
 */

public class ProductCommentsFragment extends BaseFragment implements BaseFragment.LazyLoadingListener{
    private TitleBean titleBean;

    public static ProductCommentsFragment newInstance(TitleBean titleBean) {
        ProductCommentsFragment fragment = new ProductCommentsFragment();
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
        return R.layout.fragment_product_comments;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void loadLazyDatas(boolean bool) {

    }
}

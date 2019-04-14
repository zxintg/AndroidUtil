package com.zxin.marry.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.zxin.marry.R;
import com.zxin.marry.base.BaseFragment;
import com.zxin.marry.util.StringUtils;
import com.zxin.root.util.UiUtils;

/**
 * Created by xmuSistone on 2016/9/18.
 */
public class IndicatorPagerFragment extends BaseFragment implements BaseFragment.LazyLoadingListener{
    private ImageView imageView;
    private int imageUrl;

    public static IndicatorPagerFragment newInstance(int imageUrl) {
        IndicatorPagerFragment fragment = new IndicatorPagerFragment();
        Bundle args = new Bundle();
        args.putInt(StringUtils.FRAGMENT_DATA, imageUrl);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        imageUrl = getArguments().getInt(StringUtils.FRAGMENT_DATA);
        imageView = getViewById(R.id.image);
        setLazyLoadingListener(this);
    }

    @Override
    public int setLayout() {
        return R.layout.fragment_indicatorpager;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void loadLazyDatas(boolean bool) {
        imageView.setImageDrawable(UiUtils.getDrawable(imageUrl));
    }
}

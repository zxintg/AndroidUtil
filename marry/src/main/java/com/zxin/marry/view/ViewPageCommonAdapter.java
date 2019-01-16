package com.zxin.marry.view;

import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2018/6/26.
 */

public class ViewPageCommonAdapter extends PagerAdapter {
    SparseArray<View> mViewSparseArray;

    public ViewPageCommonAdapter(SparseArray<View> localSparseArray) {
        this.mViewSparseArray = localSparseArray;
    }

    @Override
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject) {
        paramViewGroup.removeView(mViewSparseArray.get(paramInt));
    }

    @Override
    public int getCount() {
        return this.mViewSparseArray.size();
    }

    @Override
    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt) {
        paramViewGroup.addView((View) this.mViewSparseArray.get(paramInt));
        return this.mViewSparseArray.get(paramInt);
    }

    @Override
    public boolean isViewFromObject(View paramView, Object paramObject) {
        return paramView == paramObject;
    }
}

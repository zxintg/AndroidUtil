package com.zxin.jiuxian.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zxin.jiuxian.R;
import com.zxin.jiuxian.bean.ProductDetailResult;
import com.zxin.zxinlib.util.ImageUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/8/17.
 */

public class BannerPagerAdapter extends PagerAdapter {
    private LayoutInflater mInflater;
    private List<ProductDetailResult.ImageItem> imageList = new ArrayList<>();
    private Context context;

    public BannerPagerAdapter(Context context,List<ProductDetailResult.ImageItem> imageList) {
        this.imageList.clear();
        this.imageList = imageList;
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = mInflater.inflate(R.layout.item_banner_pager, null, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.item_image);
        ImageUtil.loadImageViewLoding(context, imageList.get(position).bigImage, imageView, R.mipmap.default_iamge, R.mipmap.default_iamge);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }
}

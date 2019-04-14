package com.zxin.jdxsxp.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.bigkoo.convenientbanner.holder.Holder;
import com.zxin.jdxsxp.R;
import com.zxin.jdxsxp.bean.MeiZuHome;
import com.zxin.root.util.ImageUtil;

/**
 * Created by Administrator on 2018/6/26.
 */

public class BannerHolderView implements Holder<MeiZuHome.ValueBean.BlocksBean.DataBean> {
    private ImageView imageView;

    @Override
    public View createView(Context context) {
        //你可以通过layout文件来创建，也可以像我一样用代码创建，不一定是Image，任何控件都可以进行翻页
        imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }

    @Override
    public void UpdateUI(Context context, int position, MeiZuHome.ValueBean.BlocksBean.DataBean data) {
        ImageUtil.loadImageViewLoding(context, data.getImg_url(),imageView, R.mipmap.empty, R.mipmap.error);
    }
}

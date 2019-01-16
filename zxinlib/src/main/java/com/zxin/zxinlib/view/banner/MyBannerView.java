package com.zxin.zxinlib.view.banner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.zxin.zxinlib.R;
import com.zxin.zxinlib.util.ImageUtil;


/**
 * Banner每页显示的view 该类和Model类属于业务类
 * Created by liqg
 * on 2015/12/29.
 */
public class MyBannerView {
    LayoutInflater layoutInflater;
    Context context;
    private MyBanner.BannerItemOnClickListener listener;

    public MyBannerView(Context _context, LayoutInflater layoutInflater) {
        this.layoutInflater = layoutInflater;
        context=_context;
    }

    public void addBannerItemOnClickListener(MyBanner.BannerItemOnClickListener listener){
        this.listener = listener;
    }

    public View newView(final BannerBean myBannerModel) {
        View view = layoutInflater.inflate(R.layout.view_banner_item, null, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.view_banner_item_iv_AdImg);
        ImageUtil.loadImageViewLoding(context,myBannerModel.getPicUrl(),imageView,R.mipmap.default_iamge,R.mipmap.default_iamge);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null)
                    listener.bannerOnItemClick(v,myBannerModel);
            }
        });
        return view;
    }
}

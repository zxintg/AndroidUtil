package com.zxin.jdxsxp.util;

import android.content.Context;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.zxin.jdxsxp.bean.MeiZuHome;
import java.util.List;

/**
 * Created by Administrator on 2018/6/22.
 */

public class AdvItemClickListener implements OnItemClickListener {
    private Context mContext;
    List<MeiZuHome.ValueBean.BlocksBean.DataBean> mRecommendAdvs;

    public AdvItemClickListener(Context paramContext, List<MeiZuHome.ValueBean.BlocksBean.DataBean> paramList) {
        this.mContext = paramContext;
        this.mRecommendAdvs = paramList;
    }

    @Override
    public void onItemClick(int position) {
        /*CatePageResult.CateBannerItem bannerItem = mRecommendAdvs.get(position);
        HtmlJumpUtil.toWebForUrlActivity(bannerItem.adTitle, bannerItem.adLink);*/
    }
}

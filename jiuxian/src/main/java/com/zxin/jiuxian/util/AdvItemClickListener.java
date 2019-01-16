package com.zxin.jiuxian.util;

import android.content.Context;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.zxin.basemodel.util.HtmlJumpUtil;
import com.zxin.jiuxian.bean.CatePageResult;
import java.util.List;

/**
 * Created by Administrator on 2018/6/22.
 */

public class AdvItemClickListener implements OnItemClickListener {
    private Context mContext;
    List<CatePageResult.CateBannerItem> mRecommendAdvs;

    public AdvItemClickListener(Context paramContext, List<CatePageResult.CateBannerItem> paramList) {
        this.mContext = paramContext;
        this.mRecommendAdvs = paramList;
    }

    @Override
    public void onItemClick(int position) {
        CatePageResult.CateBannerItem bannerItem = mRecommendAdvs.get(position);
        HtmlJiuXianJumpUtil.toWebForUrlActivity(bannerItem.adTitle, bannerItem.adLink);
    }
}

package com.zxin.marry.util;

import android.content.Context;
import android.content.Intent;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.zxin.marry.activity.BanquetHallDetailsActivity;
import com.zxin.marry.activity.GoodsDetailsActivity;
import com.zxin.marry.activity.HotNewsDetailActivity;
import com.zxin.marry.activity.RecommendADVActivity;
import com.zxin.marry.activity.ShopCaseDetailsActivity;
import com.zxin.marry.activity.ShopDetailsActivity;
import com.zxin.marry.activity.SubjectDetailActivity;
import com.zxin.marry.activity.TopicActivity;
import com.zxin.marry.activity.WeddingStoreDetailsActivity;
import com.zxin.marry.bean.RecommendForm;
import com.zxin.marry.bean.SubjectForm;
import com.zxin.marry.bean.TopicForm;
import java.util.List;

/**
 * Created by Administrator on 2018/6/22.
 */

public class AdvItemClickListener implements OnItemClickListener {
    private Context mContext;
    List<RecommendForm.RecommendAdv> mRecommendAdvs;

    public AdvItemClickListener(Context paramContext, List<RecommendForm.RecommendAdv> paramList) {
        this.mContext = paramContext;
        this.mRecommendAdvs = paramList;
    }

    @Override
    public void onItemClick(int position) {
        RecommendForm.RecommendAdv localRecommendAdv = mRecommendAdvs.get(position);
        Intent localIntent = new Intent();
        switch (localRecommendAdv.getTypeid()) {

            case 1:
                localIntent = new Intent();
                localIntent.setClass(this.mContext, ShopCaseDetailsActivity.class);
                localIntent.putExtra("case_id", localRecommendAdv.getObid());
                mContext.startActivity(localIntent);
                break;

            case 2:
                localIntent = new Intent();
                localIntent.setClass(this.mContext, ShopDetailsActivity.class);
                localIntent.putExtra("store_id", localRecommendAdv.getObid());
                mContext.startActivity(localIntent);
                break;

            case 3:
                localIntent = new Intent();
                localIntent.setClass(this.mContext, GoodsDetailsActivity.class);
                localIntent.putExtra("goods_id", localRecommendAdv.getObid());
                mContext.startActivity(localIntent);
                break;


            case 4:
                localIntent = new Intent(this.mContext, HotNewsDetailActivity.class);
                if (this.mContext.getApplicationInfo().flags == 2) {
                    localIntent.putExtra("url", "http://test.yl.cgsoft.net/portal/xmsArticle/index/id/" + localRecommendAdv.getObid());
                }else{
                    localIntent.putExtra("url", "http://wx.cgsoft.net/portal/xmsArticle/index/id/" + localRecommendAdv.getObid());
                }
                localIntent.putExtra("name", localRecommendAdv.getTitle());
                localIntent.putExtra("id", localRecommendAdv.getObid());
                this.mContext.startActivity(localIntent);

                break;

            case 5:
                localIntent.setClass(this.mContext, RecommendADVActivity.class);
                localIntent.putExtra("url", localRecommendAdv.getUrl());
                localIntent.putExtra("title", localRecommendAdv.getTitle());
                mContext.startActivity(localIntent);
                break;

            case 6:
                localIntent = new Intent(this.mContext, WeddingStoreDetailsActivity.class);
                localIntent.putExtra("hotelid", localRecommendAdv.getObid());
                mContext.startActivity(localIntent);
                break;

            case 7:
                localIntent = new Intent(this.mContext, BanquetHallDetailsActivity.class);
                localIntent.putExtra("id", localRecommendAdv.getObid());
                mContext.startActivity(localIntent);
                break;

            case 8:
                localIntent = new Intent(this.mContext, TopicActivity.class);
                TopicForm.Theme localObject = new TopicForm.Theme();
                localObject.setTheme_id(localRecommendAdv.getObid());
                localIntent.putExtra("Theme",localObject);
                mContext.startActivity(localIntent);
                break;

            default:
                localIntent = new Intent(this.mContext, SubjectDetailActivity.class);
                SubjectForm.Subject subject = new SubjectForm.Subject();
                subject.setId(localRecommendAdv.getObid());
                localIntent.putExtra(SubjectForm.Subject.class.getSimpleName(), subject);
                this.mContext.startActivity(localIntent);
                break;
        }
    }
}

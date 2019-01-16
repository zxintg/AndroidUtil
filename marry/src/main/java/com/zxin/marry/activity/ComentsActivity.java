package com.zxin.marry.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.marry.mvp.presenter.OrderPresenter;
import com.zxin.marry.mvp.view.OrderContract;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.zxinlib.view.CommonCrosswiseBar;

/**
 * Created by Administrator on 2018/7/11.
 */

public class ComentsActivity extends BaseActivity implements OrderContract.ReserveRemarkView {
    private String orderId,shopId,typeId,type;
    private int remarkType,status;

    @InjectPresenter
    OrderPresenter presenter;

    @Override
    public void initData() {
        orderId = getIntent().getStringExtra("orderid");
        shopId = getIntent().getStringExtra("shopid");
        typeId = getIntent().getStringExtra("typeid");
        type = getIntent().getStringExtra("type");
        remarkType = getIntent().getIntExtra("remarktype",0);
        status = getIntent().getIntExtra("status",0);

        presenter.initReserveComentsDatas(this,orderId,shopId,typeId,type,remarkType,status);
        setTitleViewOnclick(R.id.ccb_marray_title,R.id.common_bar_leftBtn);
        presenter.getReserveRemarkList(orderId,shopId,typeId,status);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_comments;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.common_bar_leftBtn) {
            onBackPressed();
            return;
        }
    }

    @Override
    public CommonCrosswiseBar getCommonCrosswiseBarView() {
        return getViewById(R.id.ccb_marray_title);
    }

    @Override
    public ImageView getImageView() {
        return getViewById(R.id.imageView);
    }

    @Override
    public RecyclerView getRCCommentView() {
        return getViewById(R.id.rv_comment);
    }

    @Override
    public LinearLayout getLLNoCommentView() {
        return getViewById(R.id.ll_nocomment);
    }

    @Override
    public EditText getEDCommentView() {
        return getViewById(R.id.ed_comment);
    }

    @Override
    public TextView getTVCommentCountView() {
        return getViewById(R.id.tv_comment_count);
    }

    @Override
    public LinearLayout getLLBeenCommentedView() {
        return getViewById(R.id.ll_beenCommented);
    }

    @Override
    public TextView getTVCommentuserView() {
        return getViewById(R.id.tv_commentuser);
    }

    @Override
    public TextView getTVCommentdateView() {
        return getViewById(R.id.tv_commentdate);
    }

    @Override
    public TextView getTVCommentcontentView() {
        return getViewById(R.id.tv_commentcontent);
    }

    @Override
    public RecyclerView getRVBeenCommentedView() {
        return getViewById(R.id.clv_beenCommented);
    }

    @Override
    public LinearLayout getLLUserCallbackView() {
        return getViewById(R.id.ll_usercallback);
    }

    @Override
    public TextView getTVAddCommentdateView() {
        return getViewById(R.id.tv_add_commentdate);
    }

    @Override
    public TextView getTVSecondCommentcontentView() {
        return getViewById(R.id.tv_second_commentcontent);
    }

    @Override
    public LinearLayout getLLQuestionnaireView() {
        return getViewById(R.id.ll_questionnaire);
    }

    @Override
    public TextView getTVQuestionnaireDesView() {
        return getViewById(R.id.tv_questionnaire_des);
    }

    @Override
    public RecyclerView getRVQuestionView() {
        return getViewById(R.id.recycler_question);
    }

    @Override
    public LinearLayout getLLObstacleView() {
        return getViewById(R.id.ll_obstacle);
    }

    @Override
    public TextView getTVSubmitView() {
        return getViewById(R.id.tv_submit);
    }

    @Override
    public TextView getTVAdditionalSubmitView() {
        return getViewById(R.id.tv_additional_submit);
    }
}

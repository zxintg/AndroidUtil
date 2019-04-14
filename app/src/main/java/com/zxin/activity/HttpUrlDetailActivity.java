package com.zxin.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.zxin.R;
import com.zxin.base.BaseActivity;
import com.zxin.util.StringUtils;
import com.zxin.root.bean.HttpUrlBean;
import com.zxin.basemodel.dao.HttpUrlDaoUtil;
import com.zxin.root.util.IntegerUtil;
import com.zxin.root.view.CommonCrosswiseBar;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/5/17.
 */

public class HttpUrlDetailActivity extends BaseActivity {
    @BindView(R.id.ccb_detail_name)
    CommonCrosswiseBar mName;
    @BindView(R.id.ccb_detail_lable)
    CommonCrosswiseBar mLale;
    @BindView(R.id.ccb_detail_times)
    CommonCrosswiseBar mTimes;
    @BindView(R.id.ccb_detail_order)
    CommonCrosswiseBar mOrder;
    @BindView(R.id.ccb_detail_createtime)
    CommonCrosswiseBar mCreateTime;
    @BindView(R.id.ccb_detail_modifytime)
    CommonCrosswiseBar mModifyTime;
    @BindView(R.id.ccb_detail_lasetime)
    CommonCrosswiseBar mLaseTime;
    @BindView(R.id.ccb_detail_istrue)
    CommonCrosswiseBar mTrue;
    @BindView(R.id.ccb_detail_url)
    TextView mUrl;

    private long id;
    private HttpUrlBean httpUrlBean;

    @Override
    public void initData() {
        id = getIntent().getLongExtra(StringUtils.ACTIVITY_DATA, -1);
        getHttpUrlBean();
    }

    @Override
    public int setLayout() {
        return R.layout.activity_httpdetail;
    }

    @OnClick({R.id.common_bar_leftBtn, R.id.common_bar_rightBtn})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.common_bar_leftBtn:
                onBackPressed();
                break;

            case R.id.common_bar_rightBtn:
                //编辑
                Intent intent = new Intent(mContext, EditHttpUrlActivity.class);
                intent.putExtra(StringUtils.ACTIVITY_DATA, id);
                startActivity(intent);
                break;
        }
    }
    //接受event事件
    @Override
    public boolean onEventMainThread(Bundle bundle) {
        switch (bundle.getInt(StringUtils.EVENT_ID)) {
            case IntegerUtil.EVENT_ID_11001:
                //添加标签后刷新界面
                getHttpUrlBean();
                break;

        }
        return false;
    }

    public void getHttpUrlBean() {
        httpUrlBean = HttpUrlDaoUtil.getInstance().getHttpUrl(id);
        mName.setRightText(httpUrlBean.name);
        mLale.setRightText(httpUrlBean.lable);
        mTimes.setRightText("已使用“"+httpUrlBean.times+"”次");
        mOrder.setRightText(String.valueOf(httpUrlBean.orderNum));
        mCreateTime.setRightText(httpUrlBean.createTimer);
        mLaseTime.setRightText(httpUrlBean.lastTime);
        mTrue.setRightText(httpUrlBean.isEffective==1?"有效":"无效");
        mModifyTime.setRightText(httpUrlBean.modifyTime);
        mUrl.setText(httpUrlBean.url);
    }
}

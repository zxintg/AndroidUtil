package com.zxin.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.zxin.R;
import com.zxin.base.BaseActivity;
import com.zxin.util.StringUtils;
import com.zxin.root.bean.HttpUrlBean;
import com.zxin.basemodel.dao.HttpUrlDaoUtil;
import com.zxin.meziyowu.util.IntegerUtil;
import com.zxin.root.util.ToastUtil;
import com.zxin.root.view.switchbutton.SwitchButton;

import org.greenrobot.eventbus.EventBus;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 编辑 on 2018/5/11.
 */

public class EditHttpUrlActivity extends BaseActivity {
    @BindView(R.id.et_editurl_name)
    EditText mName;
    @BindView(R.id.et_editurl_lable)
    EditText mLable;
    @BindView(R.id.et_editurl_content)
    EditText mContent;
    @BindView(R.id.rl_editurl_isused)
    View mView;
    @BindView(R.id.sw_editurl_isused)
    SwitchButton mUsed;

    private long id;
    private HttpUrlBean httpUrlBean;

    @Override
    public void initData() {
        id = getIntent().getLongExtra(StringUtils.ACTIVITY_DATA,-1);
        if (id!=-1){
            httpUrlBean = HttpUrlDaoUtil.getInstance().getHttpUrl(id);
            mName.setText( httpUrlBean.name);
            mLable.setText( httpUrlBean.lable);
            mContent.setText( httpUrlBean.url);
            mUsed.setChecked(httpUrlBean.isEffective==1);
            mView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int setLayout() {
        return R.layout.activity_edithttpurl;
    }

    @OnClick({R.id.common_bar_leftBtn,R.id.common_bar_rightBtn,R.id.rl_editurl_isused})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.common_bar_leftBtn:
                onBackPressed();
                break;

            case R.id.rl_editurl_isused:
                mUsed.setChecked(!mUsed.isChecked());
                break;

            case R.id.common_bar_rightBtn:
                //提交
                if (StringUtils.textIsEmpty(mName.getText().toString())){
                    ToastUtil.showShort("输入名称");
                    return;
                }
                if (StringUtils.textIsEmpty(mLable.getText().toString())){
                    ToastUtil.showShort("输入标签信息");
                    return;
                }
                if (StringUtils.textIsEmpty(mContent.getText().toString())){
                    ToastUtil.showShort("输入网址信息");
                    return;
                }
                if (id!=-1){
                    //更新
                    HttpUrlDaoUtil.getInstance().updateHttpUrl(id,mName.getText().toString(),mLable.getText().toString(),mContent.getText().toString(),mUsed.isChecked());
                    sendEvenBusMesg();
                    return;
                }else if(HttpUrlDaoUtil.getInstance().addHttpUrl(mName.getText().toString(),mLable.getText().toString(),mContent.getText().toString())){
                    ToastUtil.showShort("保存成功！！！！");
                    sendEvenBusMesg();
                }
                break;
        }
    }

    private void sendEvenBusMesg(){
        Bundle bundle = new Bundle();
        bundle.putInt(StringUtils.EVENT_ID, IntegerUtil.EVENT_ID_11001);
        EventBus.getDefault().post(bundle);
        onBackPressed();
    }

}

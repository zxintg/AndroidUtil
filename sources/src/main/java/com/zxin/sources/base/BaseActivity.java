package com.zxin.sources.base;

import android.view.View;
import com.zxin.sources.util.StringUtils;
import org.greenrobot.eventbus.EventBus;

/**
 * Activity 基类
 * Created by hy
 * 2017/10/24 18:48
 * Note :
 */
public abstract class BaseActivity extends com.zxin.basemodel.activity.BaseActivity {

    @Override
    public void initBaseDatas(View view) {
        //  注册时会自动从当前类里面拿取注释为@Produce 和 @Subscribe，解析处理，会发送出来消息
        if (StringUtils.RxBusActivityNames.contains(this.getClass().getName()) && !EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    public void setViewOnclick(int... viewIdArr){
        for (int viewId:viewIdArr){
            getViewById(viewId).setOnClickListener(this);
        }
    }

    public View getViewById(int viewId){
        return findViewById(viewId);
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (StringUtils.RxBusActivityNames.contains(this.getClass().getName())) {
            //销毁
            EventBus.getDefault().unregister(this);
        }
    }

}

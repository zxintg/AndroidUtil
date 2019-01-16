package com.zxin.sources.base;

import android.view.View;
import com.zxin.sources.util.StringUtils;
import org.greenrobot.eventbus.EventBus;


/*****
 * 基础
 */
public abstract class BaseFragment extends com.zxin.basemodel.fragment.BaseFragment{

    private View view;

    @Override
    public void initBaseDatas(View view) {
        this.view = view;
        if (StringUtils.EventBusFragmentNames.contains(this.getClass().getName())&&!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (StringUtils.EventBusFragmentNames.contains(this.getClass().getName())) {
            EventBus.getDefault().unregister(this);
        }
    }

    public void setViewOnclick(int viewId){
        getViewById(viewId).setOnClickListener(this);
    }

    public View getViewById(int viewId){
        return this.view.findViewById(viewId);
    };

}

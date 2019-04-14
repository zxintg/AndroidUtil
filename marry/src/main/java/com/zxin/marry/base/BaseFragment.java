package com.zxin.marry.base;

import android.view.View;

import com.zxin.marry.util.StringUtils;
import com.zxin.root.view.CommonCrosswiseBar;

import org.greenrobot.eventbus.EventBus;


/*****
 * 基础
 */
public abstract class BaseFragment extends com.zxin.basemodel.fragment.BaseFragment {

    private View view;

    @Override
    public void initBaseDatas(View view) {
        this.view = view;
        if (StringUtils.EventBusFragmentNames.contains(this.getClass().getName()) && !EventBus.getDefault().isRegistered(this)) {
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

    public void setViewOnclick(int... viewId) {
        for (int id : viewId) {
            this.view.findViewById(id).setOnClickListener(this);
        }
    }

    public void setTitleViewOnclick(int fatherId,int... childId){
        CommonCrosswiseBar father = getViewById(fatherId);
        for (int id:childId){
            father.setOnClickListener(id,this);
        }
    }

    public <T> T getViewById(int viewId) {
        return (T)this.view.findViewById(viewId);
    }

}

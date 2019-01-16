package com.zxin.base;

import android.view.View;
import com.zxin.util.StringUtils;
import org.greenrobot.eventbus.EventBus;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/*****
 * 基础
 */
public abstract class BaseFragment extends com.zxin.basemodel.fragment.BaseFragment{
    public Unbinder unbinder;

    @Override
    public void initBaseDatas(View view) {
        unbinder = ButterKnife.bind(this, view);
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

}

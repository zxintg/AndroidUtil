package com.zxin.marry.fragment.order;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zxin.marry.R;
import com.zxin.marry.base.BaseFragment;
import com.zxin.marry.mvp.presenter.OrderPresenter;
import com.zxin.marry.mvp.view.OrderContract;
import com.zxin.network.mvp.inject.InjectPresenter;

/**
 * Created by Administrator on 2018/6/19.
 */

public class ComentFragment extends BaseFragment  implements BaseFragment.LazyLoadingListener,OrderContract.ReserveComentView {
    private String orderId,shopId,typeId,type;
    @InjectPresenter
    OrderPresenter presenter;

    public static Fragment newInstance(String orderid,String shopid, String mesg, String typeId) {
        ComentFragment fragment = new ComentFragment();
        Bundle args = new Bundle();
        args.putString("orderId",orderid);
        args.putString("shopId",shopid);
        args.putString("typeId",typeId);
        args.putString("type",mesg);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        orderId = getArguments().getString("orderId");
        shopId = getArguments().getString("shopId");
        typeId = getArguments().getString("typeId");
        type = getArguments().getString("type");
        presenter.initReserveComentDatas(this,orderId,shopId,typeId,type);
        setLazyLoadingListener(this);
    }

    @Override
    public int setLayout() {
        return R.layout.frg_coment;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void loadLazyDatas(boolean bool) {
        presenter.getReserveComentDatas(orderId,shopId,typeId);
    }

    @Override
    public TextView getTVTypeView() {
        return getViewById(R.id.tv_type);
    }

    @Override
    public TextView getTVStatusView() {
        return getViewById(R.id.content_status);
    }

    @Override
    public RelativeLayout getRLOnlinebookingView() {
        return getViewById(R.id.rl_onlinebooking);
    }

    @Override
    public TextView getTVOnlinebookingView() {
        return getViewById(R.id.tv_onlinebooking);
    }

    @Override
    public TextView getTVToWebView() {
        return getViewById(R.id.tv_to_web);
    }

    @Override
    public TextView getTVToastView() {
        return getViewById(R.id.text_toast);
    }
}

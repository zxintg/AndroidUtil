package com.zxin.marry.fragment.order;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zxin.marry.R;
import com.zxin.marry.base.BaseFragment;
import com.zxin.marry.bean.ShootStategyBean;
import com.zxin.marry.mvp.presenter.OrderPresenter;
import com.zxin.marry.mvp.view.OrderContract;
import com.zxin.marry.util.StringUtils;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.util.IntegerUtil;
import com.zxin.root.view.RefreshCommonView;

/**
 * Created by Administrator on 2018/6/22.
 */

public class NewCircuitViewFragment extends BaseFragment implements BaseFragment.LazyLoadingListener,OrderContract.NewCircuitView {
    private String orderid;
    private String shopid;
    private ShootStategyBean.Line lineBean;
    @InjectPresenter
    OrderPresenter presenter;

    public static NewCircuitViewFragment newInstance(String orderid, String shopId, ShootStategyBean.Line line) {
        NewCircuitViewFragment fragment = new NewCircuitViewFragment();
        Bundle args = new Bundle();
        args.putString("orderid", orderid);
        args.putString("shopid", shopId);
        args.putParcelable(StringUtils.FRAGMENT_DATA, line);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        orderid = getArguments().getString("orderid");
        shopid = getArguments().getString("shopid");
        lineBean = getArguments().getParcelable(StringUtils.FRAGMENT_DATA);
        presenter.initNewCircuitDatas(this,orderid,shopid,lineBean.getId());
        setLazyLoadingListener(this);
    }

    @Override
    public int setLayout() {
        return R.layout.circuit_view_pager;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void loadLazyDatas(boolean bool) {
        presenter.NewCircuitViewList(orderid,shopid,lineBean.getId());
    }

    @Override
    public RefreshCommonView getRefreshCommonView() {
        return getViewById(R.id.rcv_circuit_commonlayout);
    }

    @Override
    public SimpleDraweeView getIVPhotoView() {
        return getViewById(R.id.iv_photo);
    }

    @Override
    public ImageView getIVSignView() {
        return getViewById(R.id.iv_sign);
    }

    @Override
    public TextView getTVCircuitTitleView() {
        return getViewById(R.id.tv_circuit_title);
    }

    @Override
    public TextView getTVCircuitDesView() {
        return getViewById(R.id.tv_circuit_des);
    }

    //接受event事件
    @Override
    public void onEventMainThread(Bundle bundle) {
        switch (bundle.getInt(StringUtils.EVENT_ID)) {
            case IntegerUtil.EVENT_ID_11005://收藏刷新
                presenter.NewCircuitViewList(orderid,shopid,lineBean.getId());
                break;
        }
    }
}

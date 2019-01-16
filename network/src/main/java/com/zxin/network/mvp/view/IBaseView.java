package com.zxin.network.mvp.view;

import android.content.Context;
import android.view.View;

import com.zxin.network.mvp.presenter.BasePresenter;

/**
 * Created by Administrator on 2018/5/21.
 */

public interface IBaseView<B,P extends BasePresenter> {
    void setParameter(Object... parameter);
    void initDatas();
    void loadDatas();
    void onResultSuccess(B bean);
    void onAddResult(boolean bool);
    void onUpdateResult(boolean bool);
    void onDeleteResult(boolean bool);
    void onComplete();
    void setContext(Context context);
    void setP(P... p);
    void OnClick(View v);
}

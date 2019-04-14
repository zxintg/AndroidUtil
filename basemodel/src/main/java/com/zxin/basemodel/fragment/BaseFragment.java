package com.zxin.basemodel.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.squareup.leakcanary.RefWatcher;
import com.trello.rxlifecycle.components.support.RxFragment;
import com.zxin.basemodel.app.BaseApplication;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.root.util.LogUtils;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/*****
 * 基础
 */
public abstract class BaseFragment extends RxFragment implements View.OnClickListener{
    protected FragmentTransaction transaction = null;
    protected Context mContext;
    //一个View 里面肯定有多个Presenter情况，怎么处理，Dagger处理
    private List<BasePresenter> mPresenterList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this.getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(setLayout(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isViewCreated = true;
        initBaseDatas(view);
        injectPresener();
        initData();
        lazyLoad();
    }


    /**
     * 数据初始化
     * 默认在onStart中调用
     * 建议增加数据恢复判断，配合onSaveInstanceState使用
     */
    public abstract void initData();

    /*****
     * 绑定布局
     * @return
     */
    public abstract int setLayout();

    public abstract void initBaseDatas(View view);

    /**
     * 显示生命周期日志
     *
     * @param showLog
     */
    public void setShowLog(boolean showLog) {
        this.showLog = showLog;
    }

    private boolean showLog;

    public String getClassName() {
        return getClass().getSimpleName();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (showLog) {
            Log.e(getClassName(), "--onResume");
            Log.e(getClassName(), "--getActivity：" + getActivity() == null ? "null" : getActivity().toString());
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (showLog) {
            Log.e(getClassName(), "--onPause");
            Log.e(getClassName(), "--getActivity：" + getActivity() == null ? "null" : getActivity().toString());
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //检测内存泄漏使用
        RefWatcher refWatcher = BaseApplication.getRefWatcher(getActivity());
        refWatcher.watch(this);
        //解绑Presenter
        for (BasePresenter presenter : mPresenterList) {
            presenter.detachView();
        }
    }

    //EventBus的回调方法。
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(Bundle bundle) {
        LogUtils.d("");
    }

    //Fragment的View加载完毕的标记
    private boolean isViewCreated = false;
    //Fragment对用户可见的标记
    private boolean isUIVisible = false;
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //isVisibleToUser这个boolean值表示:该Fragment的UI 用户是否可见
        if (isVisibleToUser) {
            isUIVisible = true;
            lazyLoad();
        } else {
            isUIVisible = false;
        }
    }

    private void lazyLoad() {
        if (this.lazyLoadingListener==null)
            return;
        //这里进行双重标记判断,是因为setUserVisibleHint会多次回调,并且会在onCreateView执行前回调,必须确保onCreateView加载完毕且页面可见,才加载数据
        if (isViewCreated && isUIVisible) {
            //加载数据
            this.lazyLoadingListener.loadLazyDatas(isViewCreated && isUIVisible);
            //数据加载完毕,恢复标记,防止重复加载
            isViewCreated = false;
            isUIVisible = false;
        }
    }

    /*****
     * 注入Presenter 通过反射(或者Dagger)
     */
    private void injectPresener(){
        mPresenterList = new ArrayList<>();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            InjectPresenter injectPresenter = field.getAnnotation(InjectPresenter.class);
            if (injectPresenter != null) {
                //创建注入
                Class<? extends BasePresenter> presenterClazz = null;
                try {
                    //获取这个类
                    presenterClazz = ( Class<? extends BasePresenter> ) field.getType();
                } catch (Exception e) {
                    // 乱七八糟一些注入
                    throw new RuntimeException("Presenter 注入错误 ====》not support inject presenter" + field.getType());
                }
                try {
                    //创建BasePresenter对象
                    BasePresenter basePresenter = presenterClazz.newInstance();
                    //attach
                    basePresenter.attachView(mContext);
                    mPresenterList.add(basePresenter);
                    field.setAccessible(true);
                    field.set(this, basePresenter);
                } catch (java.lang.InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /****
     * 设置懒加载数据
     * @param lazyLoadingListener
     */
    protected void setLazyLoadingListener(LazyLoadingListener lazyLoadingListener){
        this.lazyLoadingListener = lazyLoadingListener;
    }

    private LazyLoadingListener lazyLoadingListener;

    /*****
     * 懒加载接口
     */
    public interface LazyLoadingListener{
        void loadLazyDatas(boolean bool);
    }

}

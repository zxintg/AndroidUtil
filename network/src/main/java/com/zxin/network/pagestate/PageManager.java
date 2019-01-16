package com.zxin.network.pagestate;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zxin.network.R;
import com.zxin.zxinlib.util.AppManager;
import com.zxin.zxinlib.util.SystemInfoUtil;
import com.zxin.zxinlib.view.dialog.ConfirmDialog;

/**
 * Created by zhy on 15/8/27.
 */
public class PageManager {
    public static final int NO_LAYOUT_ID = 0;
    public static int BASE_LOADING_LAYOUT_ID;//= R.layout.pager_loading
    public static int BASE_RETRY_LAYOUT_ID;//= R.layout.pager_error
    public static int BASE_EMPTY_LAYOUT_ID;//= R.layout.pager_empty
    public PageLayout mLoadingAndRetryLayout;

    /**
     * @param layoutIdOfEmpty
     * @param layoutIdOfLoading
     * @param layoutIdOfError
     */
    public static void initInApp(int layoutIdOfEmpty, int layoutIdOfLoading, int layoutIdOfError) {
        if (layoutIdOfEmpty > 0) {
            BASE_EMPTY_LAYOUT_ID = layoutIdOfEmpty;
        }

        if (layoutIdOfLoading > 0) {
            BASE_LOADING_LAYOUT_ID = layoutIdOfLoading;
        }

        if (layoutIdOfError > 0) {
            BASE_RETRY_LAYOUT_ID = layoutIdOfError;
        }
    }

    /**
     *
     * @param container  必须为activity或者view.如果是view,则该view对象必须有parent
     * @param retryAction 点击重试的动作,
     * @param isShowLoadingOrContent 第一次是显示loading(true)还是content(false)
     * @return 当前页面的状态管理器
     */
    public static PageManager init(final Object container, boolean isShowLoadingOrContent ,final Runnable retryAction) {
        PageManager manager = generate(container, isShowLoadingOrContent,new PageListener() {
            @Override
            public void onRetry(View retryView) {
                if (!SystemInfoUtil.isNetworkAvailable()) {
                    ConfirmDialog dialog =  ConfirmDialog.newInstance("提示","当前网络不可用", "去设置", "知道了");
                    dialog.setMessageGravity(Gravity.CENTER);
                    dialog.setMargin(60)
                            .setWidth(SystemInfoUtil.getScreenWidth()*2/3)
                            .setOutCancel(false)
                            .show();
                    dialog.setConfirmDialogListener(new ConfirmDialog.ConfirmDialogListener(){


                        @Override
                        public void dialogStatusYes() {
                            //设置界面
                            // 跳转到系统的网络设置界面
                            Intent intent = null;
                            // 先判断当前系统版本
                            if(android.os.Build.VERSION.SDK_INT > 10){  // 3.0以上
                                //intent = new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS);
                                intent = new Intent(android.provider.Settings.ACTION_SETTINGS);
                            }else{
                                intent = new Intent();
                                intent.setClassName("com.android.settings", "com.android.settings.WirelessSettings");
                            }
                            AppManager.getAppManager().currentActivity().startActivity(intent);
                        }

                        @Override
                        public void dialogStatusNo() {

                        }
                    });
                } else {
                    retryAction.run();
                }
            }
        });

        return manager;
    }

    public void showLoading() {
        mLoadingAndRetryLayout.showLoading();
    }


    public void showError() {
        mLoadingAndRetryLayout.showRetry();
    }

    public void showContent() {
        mLoadingAndRetryLayout.showContent();
    }

    public void showEmpty() {
        mLoadingAndRetryLayout.showEmpty();
    }

    public PageListener DEFAULT_LISTENER = new PageListener() {
        @Override
        public void onRetry(View retryView) {

        }
    };

    private PageManager(Object activityOrView, boolean showLoadingFirstIn, PageListener listener) {
        if (listener == null) listener = DEFAULT_LISTENER;

        ViewGroup contentParent = null;
        Context context;
        if (activityOrView instanceof Activity) {
            Activity activity = (Activity) activityOrView;
            context = activity;
            contentParent = (ViewGroup) activity.findViewById(android.R.id.content);
        } else if (activityOrView instanceof Fragment) {

            Fragment fragment = (Fragment) activityOrView;
            context = fragment.getActivity();
            contentParent = (ViewGroup) (fragment.getView().getParent());
            if (contentParent == null) {
                throw new IllegalArgumentException("the fragment must already has a parent ,please do not invoke this in oncreateView,you should use this method in onActivityCreated() or onstart");
            }
        } else if (activityOrView instanceof View) {
            View view = (View) activityOrView;
            contentParent = (ViewGroup) (view.getParent());
            if (contentParent == null) {
                throw new IllegalArgumentException("the view must already has a parent ");
            }
            context = view.getContext();
        } else {
            throw new IllegalArgumentException("the container's type must be Fragment or Activity or a view ");
        }

        int childCount = contentParent.getChildCount();
        int index = 0;
        View oldContent;
        if (activityOrView instanceof View) {
            oldContent = (View) activityOrView;
            for (int i = 0; i < childCount; i++) {
                if (contentParent.getChildAt(i) == oldContent) {
                    index = i;
                    break;
                }
            }
        } else {
            oldContent = contentParent.getChildAt(0);
        }
        contentParent.removeView(oldContent);
        PageLayout pageLayout = new PageLayout(context);
        ViewGroup.LayoutParams lp = oldContent.getLayoutParams();
        contentParent.addView(pageLayout, index, lp);
        pageLayout.setContentView(oldContent);
        setupLoadingLayout(listener, pageLayout);
        setupRetryLayout(listener, pageLayout);
        setupEmptyLayout(listener, pageLayout);
        final PageListener finalListener = listener;
        pageLayout.getRetryView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (finalListener != null) {
                    finalListener.onRetry(v);
                }

            }
        });
        pageLayout.getEmptyView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (finalListener != null) {
                    finalListener.onEmtptyViewClicked(v);
                }
            }
        });
        mLoadingAndRetryLayout = pageLayout;
        //初始状态:loading进去
        if (showLoadingFirstIn) {
            mLoadingAndRetryLayout.showLoading();
        } else {
            mLoadingAndRetryLayout.showContent();
        }

    }

    private void setupEmptyLayout(PageListener listener, PageLayout loadingAndRetryLayout) {
        if (listener.isSetEmptyLayout()) {
            int layoutId = listener.generateEmptyLayoutId();
            if (layoutId != NO_LAYOUT_ID) {
                loadingAndRetryLayout.setEmptyView(layoutId);
            } else {
                loadingAndRetryLayout.setEmptyView(listener.generateEmptyLayout());
            }
        } else {
            if (BASE_EMPTY_LAYOUT_ID != NO_LAYOUT_ID)
                loadingAndRetryLayout.setEmptyView(BASE_EMPTY_LAYOUT_ID);
        }
    }

    private void setupLoadingLayout(PageListener listener, PageLayout loadingAndRetryLayout) {
        if (listener.isSetLoadingLayout()) {
            int layoutId = listener.generateLoadingLayoutId();
            if (layoutId != NO_LAYOUT_ID) {
                loadingAndRetryLayout.setLoadingView(layoutId);
            } else {
                loadingAndRetryLayout.setLoadingView(listener.generateLoadingLayout());
            }
        } else {
            if (BASE_LOADING_LAYOUT_ID != NO_LAYOUT_ID)
                loadingAndRetryLayout.setLoadingView(BASE_LOADING_LAYOUT_ID);
        }
    }

    private void setupRetryLayout(PageListener listener, PageLayout loadingAndRetryLayout) {
        if (listener.isSetRetryLayout()) {
            int layoutId = listener.generateRetryLayoutId();
            if (layoutId != NO_LAYOUT_ID) {
                loadingAndRetryLayout.setRetryView(layoutId);
            } else {
                loadingAndRetryLayout.setRetryView(listener.generateRetryLayout());
            }
        } else {
            if (BASE_RETRY_LAYOUT_ID != NO_LAYOUT_ID)
                loadingAndRetryLayout.setRetryView(BASE_RETRY_LAYOUT_ID);
        }
    }

    public static PageManager generate(Object activityOrView, boolean showLoadingFirstIn, PageListener listener) {
        return new PageManager(activityOrView, showLoadingFirstIn, listener);
    }

}

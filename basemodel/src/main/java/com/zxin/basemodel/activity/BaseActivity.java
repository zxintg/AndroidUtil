package com.zxin.basemodel.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import com.bumptech.glide.Glide;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.zxin.basemodel.R;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.root.util.AppManager;
import com.zxin.root.util.SystemBarTintManager;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


/**
 * Activity 基类
 * Created by zxin
 * 2017/10/24 18:48
 * Note :
 */
public abstract class BaseActivity extends RxAppCompatActivity implements View.OnClickListener {
    public static String tag;
    protected Context mContext;
    //一个View 里面肯定有多个Presenter情况，怎么处理，Dagger处理
    private List<BasePresenter> mPresenterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//强制竖屏
        mContext = this;
        AppManager.getAppManager().addActivity(this);
        initWindow();
        if (setLayout() != 0) {
            if (setLayout() == 0) {
                initData();
                return;
            }
            View view = getLayoutInflater().inflate(setLayout(), null);
            initBaseDatas(view);
            setContentView(view);
        }
        injectPresener();
        initData();
    }

    @TargetApi(19)
    private void initWindow() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setTintResource(R.drawable.top_bar_ffff);
            tintManager.setTintAlpha(0f);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager().finishActivity(this);
        Glide.get(this).clearMemory();
        //解绑Presenter
        for (BasePresenter presenter : mPresenterList) {
            presenter.detachView();
        }
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

    //返回键返回事件
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode) {
            if (AppManager.getAppManager().getFragmentManager().getBackStackEntryCount() == 1) {
                finish();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    //EventBus的回调方法。
    @Subscribe(threadMode = ThreadMode.MAIN)
    public boolean onEventMainThread(Bundle bundle) {
        return false;
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
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

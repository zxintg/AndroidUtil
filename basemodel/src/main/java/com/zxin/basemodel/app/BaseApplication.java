package com.zxin.basemodel.app;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Process;
import android.preference.PreferenceManager;
import android.support.multidex.MultiDex;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.zxin.basemodel.gen.DaoMaster;
import com.zxin.basemodel.gen.DaoSession;

/**
 * Created by hy on 2017/9/22.
 */

public abstract class BaseApplication extends Application {
    private static BaseApplication mApplication;
    public static Context contextApp;
    //保存一些状态数据的SharedPreferences
    protected SharedPreferences mSettings;
    //Application为整个应用保存全局的RefWatcher
    private RefWatcher refWatcher;

    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    public static BaseApplication getInstance() {
        return mApplication;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }


    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        contextApp = getApplicationContext();
        //内存泄漏检测
        refWatcher = setupLeakCanary();
        // 初始化mSettings
        getDefaultSharedPreference();


        new Thread(new Runnable() {
            @Override
            public void run() {
                //设置线程优先级，不与主线程抢资源
                Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
                setDatabase();
            }
        }).start();
    }

    //获取应用包名
    String MyPackageName;

    public String getMyPackageName() {
        if (MyPackageName == null) {
            MyPackageName = getPackageName();
        }
        return MyPackageName;
    }

    /**
     * 获取DefaultSharedPreference实例
     *
     * @return
     */
    public SharedPreferences getDefaultSharedPreference() {
        if (mSettings == null) {
            mSettings = PreferenceManager.getDefaultSharedPreferences(this);
        }
        return mSettings;
    }

    @Override
    public void onLowMemory() {
        //ToastUtil.showDefaultGravityToast("低内存警告");
//		//如果内存不够用，就清空Activities，释放掉Activity的引用
        //AppManager.getAppManager().finishOtherButCurrentActivity();
        super.onLowMemory();

    }

    //内存泄漏检测
    protected RefWatcher setupLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return RefWatcher.DISABLED;
        }
        return LeakCanary.install(this);
    }

    public static RefWatcher getRefWatcher(Context context) {
        BaseApplication application = (BaseApplication) context.getApplicationContext();
        return application.refWatcher;
    }

    public Context getContext() {
        return contextApp;
    }

    /**
     * 设置greenDao
     */
    private void setDatabase() {
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        mHelper = new DaoMaster.DevOpenHelper(this, "zxin-db", null);
        db = mHelper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public SQLiteDatabase getDb() {
        return db;
    }


}

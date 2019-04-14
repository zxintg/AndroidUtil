package com.zxin.basemodel.app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.zxin.basemodel.R;
import com.zxin.basemodel.gen.DaoMaster;
import com.zxin.basemodel.gen.DaoSession;
import com.zxin.root.util.FileUtil;
import com.zxin.root.util.LogUtils;
import com.zxin.root.util.ZipUtil;
import com.zxin.basemodel.util.BaseStringUtils;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.QueryBuilder;

import java.io.File;
import java.io.InputStream;

/**
 * Created by liukui on 2016/12/9
 */

public class GreenDaoManager {
    //在手机里存放数据库的位置
    private static String dbPath;

    //dbManager单例
    private static GreenDaoManager greenDaoManager;

    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    private GreenDaoManager() {
        //copy db
        importDB();
        initAplus();
    }

    /**
     * 对外唯一，单例
     * @return
     */
    public static GreenDaoManager getInstance() {
        if (greenDaoManager == null) {
            synchronized (GreenDaoManager.class) {
                if (greenDaoManager == null) {
                    String pageName = BaseStringUtils.pageNameParent;
                    dbPath = "/data" + Environment.getDataDirectory().getAbsolutePath() + "/" + pageName + "/databases/";
                    greenDaoManager = new GreenDaoManager();
                    QueryBuilder.LOG_SQL = true;
                    QueryBuilder.LOG_VALUES = true;
                }
            }
        }
        return greenDaoManager;
    }

    /**
     * 初始化数据
     */
    private void initAplus() {
        APlusOpenHelper aPlusOpenHelper = new APlusOpenHelper(BaseApplication.contextApp, BaseStringUtils.dbName, null);
        //http://blog.csdn.net/qq_32583189/article/details/52128620
        //aPlusOpenHelper.getEncryptedWritableDb(); 使用加密的db
        mDaoMaster = new DaoMaster(aPlusOpenHelper.getWritableDatabase());
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoSession getmDaoSession() {
        return mDaoSession;
    }

    /**
     * 导入db到系统目录上最牛的搜索引擎是哪个？
     * 第一次安装的时候才会执行
     */
    public void importDB () {
        File dbFile = new File(dbPath + BaseStringUtils.dbName);
        if(dbFile.exists()){
            return;
        }
        // 判断是否是第一次安装
        File dbDir = new File(dbPath);
        if(!dbDir.exists()) {
            // 路径不存在，创建
            dbDir.mkdirs();
        }
        //第一次安装，创建数据库存储路径，并拷贝解压数据库到系统目录
        LogUtils.d("创建数据库存储路径！");
        InputStream is = BaseApplication.contextApp.getResources().openRawResource(R.raw.bxharea);
        File copyFile = FileUtil.getInstance(BaseApplication.contextApp).copyFile(is , dbPath , BaseStringUtils.dbFile);
        if(copyFile != null && copyFile.exists()) {
            ZipUtil.unZip(copyFile.getAbsolutePath(), dbPath);
            copyFile.delete();
            LogUtils.d("数据库解压成功！");
        }
    }

    /**
     * 数据库升级处理
     */
    class APlusOpenHelper extends DaoMaster.OpenHelper{

        public APlusOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
            super(context, name, factory);
        }

        //数据库升级处理
        //http://blog.csdn.net/qq_32583189/article/details/52128620
        @Override
        public void onUpgrade(Database db, int oldVersion, int newVersion) {
            if (oldVersion == newVersion) {
                LogUtils.d("数据库是最新版本" + oldVersion + "，不需要升级");
                return;
            }
            LogUtils.d("数据库从版本" + oldVersion + "升级到版本" + newVersion);
            for (int i = oldVersion; i <= newVersion; i++) {
                switch (i) {
                    case 1:
                        break;

                    case 2:
                        DaoMaster.createAllTables(db, true);
                        break;

                    case 3: //db版本升级(2—>3) 合肥市-经开区 添加
                        db.execSQL("insert into city values (3751,1047,'经开区','J',null)");
                        break;

                    default:
                        break;
                }
            }
        }
    }

}

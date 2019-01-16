package com.zxin.zxinlib.exception;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Looper;

import com.zxin.zxinlib.util.AppManager;
import com.zxin.zxinlib.util.LogUtils;

import java.io.File;
import java.io.PrintWriter;
import java.lang.Thread.UncaughtExceptionHandler;

public class CrashHandler implements UncaughtExceptionHandler {
    /**
     * 系统默认的UncaughtException处理类（默认情况下，系统会终止当前的异常程序）
     */
    private UncaughtExceptionHandler mDefaultHandler;
    private static CrashHandler INSTANCE;
    private Context mContext;
    private boolean isDebug = true;
    private static final String CRASH_PAHT = "crash" + File.separator;

    private CrashHandler() {
    }

    public static CrashHandler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CrashHandler();
        }
        return INSTANCE;
    }

    public void init(Context ctx) {
        mContext = ctx.getApplicationContext();
        //获取系统默认的异常处理器
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        //将当前实例设为系统默认的异常处理器
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    /**
     * 这个是最关键的函数，当程序中有未被捕获的异常，系统将会自动调用#uncaughtException方法
     * thread为出现未捕获异常的线程，ex为未捕获的异常，有了这个ex，我们就可以得到异常信息。
     */
    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        if (!handleException(ex) && mDefaultHandler != null) {
            // 如果用户没有处理则让系统默认的异常处理器来处理
            mDefaultHandler.uncaughtException(thread, ex);
        } else {
            // Sleep一会后结束程序
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(10);
        }
    }

    /**
     * 自定义错误处理,收集错误信息 发送错误报告等操作均在此完成. 开发者可以根据自己的情况来自定义异常处理逻辑
     *
     * @param ex
     * @return true:如果处理了该异常信息;否则返回false
     */
    private boolean handleException(Throwable ex) {
        if (ex == null) {
            return true;
        }
        final String msg = ex.getLocalizedMessage();
        // 使用Toast来显示异常信息
        if (isDebug) {
            new Thread() {
                @Override
                public void run() {
                    Looper.prepare();
                    LogUtils.d("程序出错啦:" + msg);
                    //AppManager.getAppManager().goToActivityForName(MainActivity.class.getName());
                    Looper.loop();
                }
            }.start();
        }
        ex.printStackTrace();

        // 保存异常信息到SD卡
        saveCrashInfoToFile(ex);
        // 发送错误报告到服务器
        sendCrashReportsToServer(mContext);
        return true;
    }

    /**
     * @param mContext
     */
    private void sendCrashReportsToServer(Context mContext) {
    }

  /*  *//**
     * 获取错误报告文件名
     *
     * @return
     *//*
    public File getCrashFileDir() {
       /* try {
            File fileDir = BJFileManager.getInstance(mContext).getFile(CRASH_PAHT);
            return fileDir;
        } catch (IOException e) {
            e.printStackTrace();
        }
          return null;
        */


  /*  *//**
     * 删除crash文件
     *//*
    public void deleteAllCrashFile() {
        File crashFileDir = getCrashFileDir();
        if (crashFileDir != null) {
            File[] files = crashFileDir.listFiles();
            if (files == null)
                return;
            for (File file : files) {
                file.delete();
            }
        }
    }
*/

    /**
     * 保存错误信息到文件中
     *
     * @param ex
     * @return
     */
    private void saveCrashInfoToFile(Throwable ex) {
        //如果SD卡不存在或无法使用，则无法把异常信息写入SD卡
        /*if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return;
        }

        String time = TimeUtils.formatTime(new Date());
        String fileName = "crash_" + time;

        try {
            File file = BJFileManager.getInstance(mContext).getFile(CRASH_PAHT + fileName, true);
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

            // debug
            if (isDebug) {
            }

            //导出发生异常的时间
            pw.println(time);
            //导出手机信息
            collectDeviceInfo(pw);
            //导出异常的调用栈信息
            ex.printStackTrace(pw);
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }

    /**
     * 收集程序崩溃的设备信息
     */
    public void collectDeviceInfo(PrintWriter pw) {
        StringBuilder sb = new StringBuilder();
        try {
            PackageManager pm = mContext.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(mContext.getPackageName(), PackageManager.GET_ACTIVITIES);
            if (pi != null) {
                sb.append("DeviceInfo").append("\n");
                sb.append("App Version : ").append(pi.versionName).append("_").append(pi.versionCode).append("\n");
                sb.append("OS  Android : ").append(Build.VERSION.RELEASE).append("_").append(Build.VERSION.SDK_INT).append("\n");
                sb.append("MANUFACTURER: ").append(Build.MANUFACTURER).append("\n");//手机制造商
                sb.append("MODEL       : ").append(Build.MODEL).append("\n");//手机型号
                sb.append("CPU         : ").append(Build.CPU_ABI).append("\n");//cpu架构
            }
            pw.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
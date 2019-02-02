package com.zxin.zxinlib.util;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import java.util.Stack;

/**
 * Activity管理
 * <p/>
 * Created by liukui
 * 2017/11/26 18:38
 * Note :
 */
public class AppManager {
    private Stack<AppCompatActivity> activityStack;
    private static volatile AppManager appManager = null;

    /*****
     * 私有化，防止外部调用实例化
     */
    private AppManager() {

    }

    /**
     * 单一实例
     */
    public static AppManager getAppManager() {
        if (appManager==null){
            synchronized (AppManager.class){
                if (appManager==null)
                    appManager = new AppManager();
            }
        }
        return appManager;
    }

    /**
     * 添加Activity到堆栈
     */
    public void addActivity(AppCompatActivity activity) {
        if (activityStack == null)
            activityStack = new Stack<>();
        activityStack.add(activity);
    }

    public Stack<AppCompatActivity> getActivityStack() {
        return activityStack;
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public AppCompatActivity currentActivity() {
        if (activityStack==null||activityStack.isEmpty())
            return null;
        return activityStack.lastElement();
    }

    public FragmentManager getFragmentManager(){
       return currentActivity().getSupportFragmentManager();
    }

    /****
     * 结束当前activity
     */
    public void finishCurrentActivity() {
        if (activityStack==null||activityStack.isEmpty())
            return;
        activityStack.lastElement().onBackPressed();
    }

    /****
     * 启动activity
     * @param intent
     */
    public void goToActivity(Intent intent){
        activityStack.lastElement().startActivity(intent);
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    public void finishActivity() {
        if (activityStack==null||activityStack.isEmpty())
            return;
        finishActivity(activityStack.lastElement());
    }

    /**
     * 结束指定类名的Activity
     */
    public void finishActivity(Class<?> cls) {
        if (activityStack==null||activityStack.isEmpty())
            return;
        for (AppCompatActivity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
            }
        }
    }

    /**
     * 结束指定的Activity
     */
    public void finishActivity(AppCompatActivity activity) {
        if (activityStack==null||activityStack.isEmpty())
            return;
        if (activityStack!=null&&!activityStack.isEmpty()&&activity != null) {
            activity.finish();
            activityStack.remove(activity);
        }
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        if (activityStack == null||activityStack.isEmpty())
            return;
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                finishActivity(activityStack.get(i));
            }
        }
    }

    /**
     * 栈里面只保留当前Activity
     */
    public void keepActivityForClass(Class<?> cls) {
        if (activityStack==null||activityStack.isEmpty())
            return;
        for (AppCompatActivity activity : activityStack) {
            if (null != activity) {
                if (activity.getClass().equals(cls))
                    continue;
                finishActivity(activity);
            }
        }
    }

    /*****
     * 退出到指定的Activity
     */
    public void goToActivityForName(String cName) {
        if (activityStack==null||activityStack.isEmpty())
            return;
        for (int i = activityStack.size() - 1; i > 0; i--) {
            AppCompatActivity activity = activityStack.get(i);
            if (activity == null)
                continue;
            if (activity.getClass().getName().equals(cName))
                break;
            finishActivity(activity);
        }
    }

    /*****
     *
     * @param cName
     */
    public void goToActivityExcludeName(String cName) {
        if (activityStack==null||activityStack.isEmpty())
            return;
        for (int i =  0; i < activityStack.size(); i++) {
            AppCompatActivity activity = activityStack.get(i);
            if (activity == null||activity.getClass().getName().equals(cName))
                continue;
            finishActivity(activity);
        }
    }

    /*****
     * 是否存在栈里面
     * @param cName
     * @return
     */
    public boolean isInnerStackForName(String cName){
        if (activityStack==null||activityStack.isEmpty())
            return false;

        for (int i =  0; i < activityStack.size(); i++) {
            AppCompatActivity activity = activityStack.get(i);
            if (activity != null&&activity.getClass().getName().equals(cName)){
                return true;
            }
        }
        return false;
    }

    /**
     * 退出应用程序
     */
    public void AppExit() {
        try {
            finishAllActivity();
            //杀死该应用进程
            android.os.Process.killProcess(android.os.Process.myPid());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /****
     * 是否包含指定Activity
     * @param cls
     * @return
     */
    public boolean isInnerStack(Class<?> cls){
        if (activityStack==null||activityStack.isEmpty())
            return false;
        for (int i =  0; i < activityStack.size(); i++) {
            if (activityStack.get(i).getClass() == cls){
                return true;
            }
        }
        return false;
    }

}

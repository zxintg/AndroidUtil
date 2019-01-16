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
    public Stack<AppCompatActivity> getActivityStack() {
        return activityStack;
    }
    private Stack<AppCompatActivity> activityStack;
    private static AppManager appManager;
    String tag = AppManager.class.getSimpleName();

    private AppManager() {

    }

    /**
     * 单一实例
     */
    public static AppManager getAppManager() {
        if (appManager == null) {
            appManager = new AppManager();
        }
        return appManager;
    }

    /**
     * 添加Activity到堆栈
     */
    public void addActivity(AppCompatActivity activity) {
        if (activityStack == null) {
            activityStack = new Stack<>();
        }
        activityStack.add(activity);
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public AppCompatActivity currentActivity() {
        if (activityStack==null||activityStack.isEmpty())
            return null;

        AppCompatActivity activity = activityStack.lastElement();
        return activity;
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

    public void goToActivity(Intent intent){
        activityStack.lastElement().startActivity(intent);
    }



    /*****
     * 获取前一个activity
     * @return
     */
    public AppCompatActivity lastActivity() {
        if (activityStack==null||activityStack.isEmpty())
            return null;
        AppCompatActivity activity = activityStack.elementAt(activityStack.size()-2<0?0:activityStack.size()-2);
        return activity;
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    public void finishActivity() {
        if (activityStack==null||activityStack.isEmpty())
            return;
        AppCompatActivity activity = activityStack.lastElement();
        finishActivity(activity);
    }

    /**
     * 结束指定的Activity
     */
    public void finishActivity(AppCompatActivity activity) {
        if (activityStack==null||activityStack.isEmpty())
            return;
        if (activityStack!=null&&!activityStack.isEmpty()&&activity != null) {
            activityStack.remove(activity);
        }
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
     * 结束所有Activity
     */
    public void finishAllActivity() {
        if (activityStack == null||activityStack.isEmpty())
            return;
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivityExceptByName(String cName) {
        if (activityStack==null||activityStack.isEmpty())
            return;
        AppCompatActivity mainActivity = null;
        for (AppCompatActivity activity : activityStack) {
            if (null != activity) {
                if (!activity.getClass().getSimpleName().equals(cName)) {
                    activity.finish();
                } else {
                    mainActivity = activity;
                }
                Log.d(tag, "finishAllActivityExceptByName:" + cName);
            }
        }
        activityStack.clear();
        activityStack.add(mainActivity);
        Log.d(tag, "activityStack.size(): " + activityStack.size());
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
                return;
            activity.finish();
            activityStack.remove(activity);
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
            activity.finish();
            activityStack.remove(activity);
        }
    }

    public boolean isHasActivityForName(String activityName){
        if (activityStack==null||activityStack.isEmpty())
            return false;

        for (int i =  0; i < activityStack.size(); i++) {
            AppCompatActivity activity = activityStack.get(i);
            if (activity != null&&activity.getClass().getName().equals(activityName)){
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
    public boolean isHasActivity(Class<?> cls){
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

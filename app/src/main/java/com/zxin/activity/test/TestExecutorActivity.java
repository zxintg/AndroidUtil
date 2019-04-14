package com.zxin.activity.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.zxin.R;
import com.zxin.app.MyApplication;
import com.zxin.base.BaseActivity;
import com.zxin.network.PoolThread;
import com.zxin.network.callback.AsyncCallback;
import com.zxin.network.deliver.AndroidDeliver;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import butterknife.OnClick;

/*****
 *  @author zxin
 * time  : 2019/02/02
 *
 * 测试线程池
 *
 */
public class TestExecutorActivity extends BaseActivity implements View.OnClickListener {

    @Override
    public void initData() {

    }

    @Override
    public int setLayout() {
        return R.layout.activity_testexecutor;
    }

    @OnClick({R.id.common_bar_leftBtn,R.id.ccb_setting_tv0,R.id.ccb_setting_tv1,R.id.ccb_setting_tv2,R.id.ccb_setting_tv3})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.common_bar_leftBtn:
                onBackPressed();
                break;

            case R.id.ccb_setting_tv0:
                startActivity(new Intent(this, TestActivity.class));
                break;

            case R.id.ccb_setting_tv1:
                startThread1();
                break;

            case R.id.ccb_setting_tv2:
                startThread2();
                break;

            case R.id.ccb_setting_tv3:
                startThread3();
                break;
        }
    }

    private void startThread1() {
        PoolThread executor = MyApplication.getInstance().getExecutor();
        executor.setName("最简单的线程调用方式");
        executor.setDeliver(new AndroidDeliver());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                Log.e("MainActivity", "最简单的线程调用方式");
            }
        });
    }


    private void startThread2() {
        PoolThread executor = MyApplication.getInstance().getExecutor();
        executor.setName("异步回调");
        executor.setDelay(2, TimeUnit.MILLISECONDS);
        // 启动异步任务
        executor.async(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                // 做一些操作
                return null;
            }
        }, new AsyncCallback<Object>() {
            @Override
            public void onSuccess(Object user) {
                Log.e("AsyncCallback", "成功");
            }

            @Override
            public void onFailed(Throwable t) {
                Log.e("AsyncCallback", "失败");
            }

            @Override
            public void onStart(String threadName) {
                Log.e("AsyncCallback", "开始");
            }
        });
    }


    private void startThread3() {
        PoolThread executor = MyApplication.getInstance().getExecutor();
        executor.setName("延迟时间执行任务");
        executor.setDelay(2, TimeUnit.SECONDS);
        executor.setDeliver(new AndroidDeliver());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                Log.e("MainActivity", "最简单的线程调用方式");
            }
        });
    }

}

package com.zxin.activity.test;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

import com.zxin.R;
import com.zxin.base.BaseActivity;
import com.zxin.basemodel.util.HtmlJumpUtil;
import com.zxin.router.Router;

import butterknife.OnClick;

/**
 * Created by Administrator on 2018/5/24.
 */

public class TestActivity extends BaseActivity {
    @Override
    public void initData() {

    }

    @Override
    public int setLayout() {
        return R.layout.activity_demo;
    }

    @OnClick({R.id.common_bar_leftBtn,R.id.ccb_test_pullzoom,R.id.ccb_test_webapijson,R.id.ccb_test_webapihtml,R.id.ccb_test_router_sources,R.id.ccb_test_router_uri,R.id.ccb_test_router_toweb,
            R.id.ccb_test_calendar,R.id.ccb_test_sortview,R.id.ccb_test_myraiogroup,R.id.ccb_test_blog,R.id.ccb_test_executor})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.common_bar_leftBtn:
                onBackPressed();
                break;

            case R.id.ccb_test_pullzoom:
                startActivity(new Intent(mContext, PullRecyclerViewActivity.class));
                break;

            case R.id.ccb_test_executor:
                //自定线程池
                startActivity(new Intent(mContext, TestExecutorActivity.class));
                break;

            case R.id.ccb_test_webapijson:
                startActivity(new Intent(mContext, TestJsonActivity.class));
                break;

            case R.id.ccb_test_webapihtml:
                startActivity(new Intent(mContext, TestHtmlActivity.class));
                break;

            case R.id.ccb_test_router_sources:
                //路由（去资源）
                Router.build("sources").go(this);
                break;

            case R.id.ccb_test_router_uri:
                //路由（隐式跳转）
                Router.build(Uri.parse("router://implicit?id=9527&status=Router是一个十分小巧灵活的路由框架，代码设计也很优雅简洁，且完美支持组件化开发，目前仍在不断地迭代中，源码地址为https://github.com/chenenyu/Router，欢迎各位试用点评。")).go(this);
                break;

            case R.id.ccb_test_router_toweb:
                //路由（跳转网页）
                Router.build("https://m.baidu.com").go(this);
                break;

            case R.id.ccb_test_calendar:
                //日历
                startActivity(new Intent(this, NCalendarActivity.class));
                break;

            case R.id.ccb_test_sortview:
                //排序
                startActivity(new Intent(this, MenuManageActivity.class));
                break;

            case R.id.ccb_test_myraiogroup:
                //自定义ViewGroup
                startActivity(new Intent(this, MyRaioGroupActivity.class));
                break;

            case R.id.ccb_test_blog:
                //排序
                HtmlJumpUtil.toWebForUrlActivity("红鸟网络Android团队Blog","https://hndeveloper.github.io/2017/github-android-ui.html");
                break;
        }

    }
}

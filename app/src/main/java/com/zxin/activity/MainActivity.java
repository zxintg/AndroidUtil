package com.zxin.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.widget.TextView;
import com.zxin.R;
import com.zxin.activity.test.TestActivity;
import com.zxin.base.BaseActivity;
import com.zxin.basemodel.util.HtmlJumpUtil;
import com.zxin.floats.FloatingActionMenu;
import com.zxin.fragment.MainItemFragment;
import com.zxin.router.Router;
import com.zxin.router.annotation.Route;
import com.zxin.util.StringUtils;
import com.zxin.zxinlib.adapter.ViewPageFragmentAdapter;
import com.zxin.zxinlib.bean.TitleBean;
import com.zxin.zxinlib.dao.HttpUrlDaoUtil;
import com.zxin.zxinlib.util.AppManager;
import com.zxin.zxinlib.util.IntegerUtil;
import com.zxin.zxinlib.util.ShareUtil;
import com.zxin.zxinlib.view.PagerSlidingTabStrip;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

/*****
 * 主页
 */
public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.app_bar_main)
    View main;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.pst_main_title)
    PagerSlidingTabStrip mTitleTab;
    @BindView(R.id.vp_main_pager)
    ViewPager mViewPager;
    @BindView(R.id.fam_menu_yellow)
    FloatingActionMenu mFloatingMenu;

    private TextView mName;

    private ArrayList<TitleBean> titleList = new ArrayList<>();
    private List<Fragment> mFragmentList = new ArrayList<>();//页卡视图集合
    private ViewPageFragmentAdapter pageAdapter;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void initData() {
        View headerLayout =  navigationView.getHeaderView(0);
        mName = (TextView) headerLayout.findViewById(R.id.main_head_name);
        headerLayout.findViewById(R.id.main_head_imageView).setOnClickListener(this);
        navigationView.setNavigationItemSelectedListener(this);
        postDatas();
    }

    private void postDatas() {
        titleList.clear();
        mFragmentList.clear();
        mViewPager.removeAllViews();
        titleList.addAll(HttpUrlDaoUtil.getInstance().getTitleMainList());
        for (TitleBean titleBean : titleList){
            mFragmentList.add(MainItemFragment.newInstance(titleBean));
        }
        pageAdapter = new ViewPageFragmentAdapter(mFragmentList, titleList);
        mViewPager.setCurrentItem(0);
        mViewPager.setAdapter(pageAdapter);
        mViewPager.setOffscreenPageLimit(titleList.size());
        mTitleTab.setViewPager(mViewPager);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_main;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.nav_test:
                startActivity(new Intent(mContext, TestActivity.class));
                break;

            case R.id.nav_setting:
                startActivity(new Intent(mContext, SettingActivity.class));
                break;

            case R.id.nav_share:
                ShareUtil.shareLink("侧漏海量", "霸气侧漏海量数据抓取", mContext);
                break;

            case R.id.nav_about:
                HtmlJumpUtil.gywmActivity();
                break;

            case R.id.nav_marry:
                //路由（去商城）
                Router.build("marry/MarryWeComeActivity").go(this);
                break;

            case R.id.nav_jiuxian:
                //路由（酒仙网）
                Router.build("jiuxian/LogoActivity").go(this);
                break;

            case R.id.nav_jdxsxp:
                //美女图片精选
                Router.build("jdxsxp/JdxsxpSplashActivity").go(this);
                break;

            case R.id.nav_yowu:
                //美女尤物
                Router.build("meziyowu/YoWuSplashActivity").go(this);
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    @OnClick({R.id.common_bar_leftBtn, R.id.fab12, R.id.fab22,R.id.tv_main_edittitle})
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.main_head_imageView:
                //登录
                startActivity(new Intent(mContext, MineMessageActivity.class));
                break;

            case R.id.common_bar_leftBtn:
                if (!drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.openDrawer(GravityCompat.START);
                }
                if (mFloatingMenu.isOpened()){
                    mFloatingMenu.close(true);
                }
                break;

            case R.id.fab12:
                mFloatingMenu.close(true);
                startActivity(new Intent(mContext, EditHttpUrlActivity.class));
                break;

            case R.id.fab22:
                mFloatingMenu.close(true);
                startActivity(new Intent(mContext, EditGuanJianziActivity.class));
                break;

            case R.id.tv_main_edittitle:
                //编辑标题
                startActivity(new Intent(mContext, EditTitleActivity.class));
                break;
        }
    }

    private long startTime;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
            return false;
        }
        if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - startTime < 2000) {
                //onExit();
                AppManager.getAppManager().AppExit();

            } else {
                startTime = System.currentTimeMillis();
                Snackbar.make(main, "再次点击退出应用程序", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        }
        return false;
    }
    //接受event事件
    @Override
    public boolean onEventMainThread(Bundle bundle) {
        switch (bundle.getInt(StringUtils.EVENT_ID)) {
            case IntegerUtil.EVENT_ID_11001:
            case IntegerUtil.EVENT_ID_11002:
                //添加标签后刷新界面
                postDatas();
                break;

        }
        return false;
    }

}
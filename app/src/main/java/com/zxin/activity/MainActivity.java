package com.zxin.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
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

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BaiduMapOptions;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.zxin.R;
import com.zxin.activity.test.TestActivity;
import com.zxin.base.BaseActivity;
import com.zxin.basemodel.util.HtmlJumpUtil;
import com.zxin.floats.FloatingActionMenu;
import com.zxin.fragment.MainItemFragment;
import com.zxin.router.Router;
import com.zxin.util.StringUtils;
import com.zxin.zxinlib.adapter.ViewPageFragmentAdapter;
import com.zxin.zxinlib.app.SystemPersimManage;
import com.zxin.zxinlib.bean.TitleBean;
import com.zxin.zxinlib.dao.HttpUrlDaoUtil;
import com.zxin.zxinlib.util.AppManager;
import com.zxin.zxinlib.util.ContentUtil;
import com.zxin.zxinlib.util.IntegerUtil;
import com.zxin.zxinlib.util.ShareUtil;
import com.zxin.zxinlib.view.CommonCrosswiseBar;
import com.zxin.zxinlib.view.PagerSlidingTabStrip;
import com.zxin.zxinlib.view.dialog.NiceDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/*****
 * 主页
 */
public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.ccb_title)
    CommonCrosswiseBar mTitle;
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
    @BindView(R.id.mv_baidumap)
    MapView mMapView;

    private BaiduMap mBaiduMap;
    private LocationClient mLocationClient;
    private BaiduMapOptions options;
    private int mapType;


    private TextView mName;

    private ArrayList<TitleBean> titleList = new ArrayList<>();
    private List<Fragment> mFragmentList = new ArrayList<>();//页卡视图集合
    private ViewPageFragmentAdapter pageAdapter;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void initData() {
        View headerLayout = navigationView.getHeaderView(0);
        mName = (TextView) headerLayout.findViewById(R.id.main_head_name);
        headerLayout.findViewById(R.id.main_head_imageView).setOnClickListener(this);
        navigationView.setNavigationItemSelectedListener(this);
        //postDatas();
        initMapView();
        setMapView();
    }

    private void initMapView() {
        if (mBaiduMap == null)
            mBaiduMap = mMapView.getMap();
        //定位初始化
        if (mLocationClient == null)
            mLocationClient = new LocationClient(this);
        if (options == null)
            options = new BaiduMapOptions();
        mapType = BaiduMap.MAP_TYPE_NORMAL;
    }

    private void setMapView() {
        //开启地图的定位图层
        mBaiduMap.setMyLocationEnabled(true);
        //普通地图 ,mBaiduMap是地图控制器对象
        mBaiduMap.setMapType(mapType);
        //关闭热力图
        mBaiduMap.setBaiduHeatMapEnabled(false);

        //定位服务的客户端。宿主程序在客户端声明此类，并调用，目前只支持在主线程中启动
        //声明LocationClient类实例并配置定位参数
        LocationClientOption locationOption = new LocationClientOption();
        //可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        locationOption.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        //可选，默认gcj02，设置返回的定位结果坐标系，如果配合百度地图使用，建议设置为bd09ll;
        locationOption.setCoorType("gcj02");
        //可选，默认0，即仅定位一次，设置发起连续定位请求的间隔需要大于等于1000ms才是有效的
        locationOption.setScanSpan(1000);
        //可选，设置是否需要地址信息，默认不需要
        locationOption.setIsNeedAddress(true);
        //可选，设置是否需要地址描述
        locationOption.setIsNeedLocationDescribe(true);
        //可选，设置是否需要设备方向结果
        locationOption.setNeedDeviceDirect(false);
        //可选，默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
        locationOption.setLocationNotify(true);
        //可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        locationOption.setIgnoreKillProcess(true);
        //可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        locationOption.setIsNeedLocationDescribe(true);
        //可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        locationOption.setIsNeedLocationPoiList(true);
        //可选，默认false，设置是否收集CRASH信息，默认收集
        locationOption.SetIgnoreCacheException(false);
        //可选，默认false，设置是否开启Gps定位
        locationOption.setOpenGps(true);
        //可选，默认false，设置定位时是否需要海拔信息，默认不需要，除基础定位版本都可用
        locationOption.setIsNeedAltitude(false);
        //设置打开自动回调位置模式，该开关打开后，期间只要定位SDK检测到位置变化就会主动回调给开发者，该模式下开发者无需再关心定位间隔是多少，定位SDK本身发现位置变化就会及时回调给开发者
        locationOption.setOpenAutoNotifyMode();
        //设置打开自动回调位置模式，该开关打开后，期间只要定位SDK检测到位置变化就会主动回调给开发者
        locationOption.setOpenAutoNotifyMode(3000, 1, LocationClientOption.LOC_SENSITIVITY_HIGHT);
        mLocationClient.setLocOption(locationOption);
        //注册监听函数
        mLocationClient.registerLocationListener(new MyLocationListener());
        //图片点击事件，回到定位点
        mLocationClient.requestLocation();
        new SystemPersimManage(mContext){
            @Override
            public void resultPerm(boolean isCan, int requestCode) {
                if (isCan){
                    mLocationClient.start();
                }
            }
        }.CheckedLoaction();
    }

    private void postDatas() {
        titleList.clear();
        mFragmentList.clear();
        mViewPager.removeAllViews();
        titleList.addAll(HttpUrlDaoUtil.getInstance().getTitleMainList());
        for (TitleBean titleBean : titleList) {
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
        switch (item.getItemId()) {

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

    private NiceDialog niceDialog;
    @Override
    @OnClick({R.id.common_bar_leftBtn, R.id.common_bar_rightBtn, R.id.fab12, R.id.fab22, R.id.tv_main_edittitle})
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.main_head_imageView:
                //登录
                startActivity(new Intent(mContext, MineMessageActivity.class));
                break;

            case R.id.common_bar_rightBtn:
                //地图显示设置
                if (niceDialog==null)
                    if (niceDialog == null) {
                        niceDialog = NiceDialog.init();
                    }
                niceDialog.setShowCancelBtn(false);
                niceDialog.setOnNiceDialogListener(new NiceDialog.NiceDialogListener() {
                    @Override
                    public void onItemListener(int index, String item) {
                        mTitle.setRightText(item);
                        switch (index){
                            case 0:
                                //普通地图
                                if(mapType != BaiduMap.MAP_TYPE_NORMAL) {
                                    //mBaiduMap是地图控制器对象
                                    mapType = BaiduMap.MAP_TYPE_NORMAL;
                                    mBaiduMap.setMapType(mapType);
                                    mBaiduMap.setBaiduHeatMapEnabled(false);
                                }
                                break;

                            case 1:
                                //卫星地图
                                if(mapType != BaiduMap.MAP_TYPE_SATELLITE) {
                                    //mBaiduMap是地图控制器对象
                                    mapType = BaiduMap.MAP_TYPE_SATELLITE;
                                    mBaiduMap.setMapType(mapType);
                                    mBaiduMap.setBaiduHeatMapEnabled(false);
                                }
                                break;

                            case 2:
                                //路况图
                                mBaiduMap.setTrafficEnabled(true);
                                mBaiduMap.setBaiduHeatMapEnabled(false);
                                break;

                            case 3:
                                //城市热力图
                                mBaiduMap.setBaiduHeatMapEnabled(true);
                                break;

                        }
                    }
                });
                niceDialog.setCommonLayout(ContentUtil.selectBaiDuMapType(), false);
                break;

            case R.id.common_bar_leftBtn:
                if (!drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.openDrawer(GravityCompat.START);
                }
                if (mFloatingMenu.isOpened()) {
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

    @Override
    protected void onResume() {
        //在activity执行onResume时必须调用mMapView. onResume ()
        if (mMapView == null)
            return;
        mMapView.onResume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        //在activity执行onPause时必须调用mMapView. onPause ()
        if (mMapView == null)
            return;
        mMapView.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        //在activity执行onDestroy时必须调用mMapView.onDestroy()
        if (mMapView == null)
            return;
        mLocationClient.stop();
        mBaiduMap.setMyLocationEnabled(false);
        mMapView.onDestroy();
        super.onDestroy();
    }

    public class MyLocationListener extends BDAbstractLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            //mapView 销毁后不在处理新接收的位置
            if (location == null || mMapView == null) {
                return;
            }
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(location.getDirection()).latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();
            mBaiduMap.setMyLocationData(locData);
        }
    }

    @TargetApi(23)
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == IntegerUtil.PERMISSION_REQUEST_LOCATION){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //开启地图定位图层
                mLocationClient.start();
            } else {
                showPremissionDialog("使用设备位置信息");
            }
        }
    }

}
package com.zxin.zxinlib.view.banner;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.zxin.zxinlib.R;

import java.util.ArrayList;
import java.util.List;

public class MyBanner extends RelativeLayout {
    Context context;
    //下一页间隔（毫秒）
    private final static int TIME_INTERVAL = 5000;
    ViewPager pager;
    RadioGroup radio_button;
    List<BannerBean> list;
    MyBannerAdapter adapter;

    public MyBanner(Context context) {
        super(context);
        this.context = context;
        list = new ArrayList<>();
        initView();
    }

    public MyBanner(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        list = new ArrayList<>();
        initView();
    }

    /**
     * 初始化界面
     */
    private void initView() {
        View rootView = LayoutInflater.from(context).inflate(R.layout.view_banner, this, true);
        pager = (ViewPager) rootView.findViewById(R.id.view_banner_vp_ViewPager);
        radio_button = (RadioGroup) rootView.findViewById(R.id.view_banner_rb_Index);
        adapter = new MyBannerAdapter(context);
        pager.addOnPageChangeListener(onPageChangeListener);
        pager.setCurrentItem(1);
    }

    /**
     * 初始化数据
     *
     * @param list
     */
    public void initPageIndex(List<BannerBean> list) {
        if(list==null||list.isEmpty()){
            return;
        }
        this.list = list;
        radio_button.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            RadioButton radioButton = new RadioButton(context);
            radioButton.setButtonDrawable(android.R.color.transparent);
            RadioGroup.LayoutParams radioParams = new RadioGroup.LayoutParams(20, 20);
            radioButton.setBackgroundResource(R.drawable.radio_bg);
            radioButton.setEnabled(false);
            radio_button.addView(radioButton, radioParams);
        }
        if (list.size() != 0) {
            ((RadioButton) radio_button.getChildAt(0)).setChecked(true);
        }
        adapter.setData(list,listener);
        pager.setAdapter(adapter);
        pager.setCurrentItem(1);
        handler.sendEmptyMessageDelayed(TIME_INTERVAL, TIME_INTERVAL);

    }

    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            int pageIndex = position;
            if (position == 0) {
                // 当视图在第一个时，将页面号设置为图片的最后一张。
                pageIndex = list.size();  //3
                ((RadioButton) radio_button.getChildAt(pageIndex - 1)).setChecked(true);
            } else if (position == list.size() + 1) {
                // 当视图在最后一个是,将页面号设置为图片的第一张。
                pageIndex = 1;
                ((RadioButton) radio_button.getChildAt(0)).setChecked(true);
            } else {
                ((RadioButton) radio_button.getChildAt(position - 1)).setChecked(true);
            }
            if (position != pageIndex) {
                pager.setCurrentItem(pageIndex, false);
                return;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };
    /**
     * 自动滑动的Handler
     * 利用 Handler.sendEmptyMessageDelayed方法，实现定时滚动
     */
    private boolean isrunning = true;  //控制开关，当== true 时，会一直循环下去， 可以在ondestry中将值设为关闭
    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            //让ViewPager滑到下一页
            pager.setCurrentItem(pager.getCurrentItem() + 1);
            //延时，循环调用handler
            if (isrunning) {
                handler.sendEmptyMessageDelayed(TIME_INTERVAL, TIME_INTERVAL);
            }
        }

    };

    public void setBannerItemOnClickListener(BannerItemOnClickListener listener){
        this.listener = listener;
    }

    private BannerItemOnClickListener listener;

    public interface BannerItemOnClickListener{
        void bannerOnItemClick(View view, BannerBean banner);
    }

}

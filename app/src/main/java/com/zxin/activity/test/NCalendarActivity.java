package com.zxin.activity.test;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.zxin.R;
import com.zxin.ncalendar.NCalendar;
import com.zxin.ncalendar.listener.OnCalendarChangedListener;
import com.zxin.base.BaseActivity;
import com.zxin.util.ColorUtil;
import com.zxin.root.adapter.simple.SimpleAdapter;
import com.zxin.root.adapter.simple.TrdViewHolder;
import com.zxin.root.util.LogUtils;
import com.zxin.root.util.UiUtils;
import org.joda.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by zxin on 2017/9/27.
 */

public class NCalendarActivity extends BaseActivity implements OnCalendarChangedListener {

    @BindView(R.id.ncalendarrrr)
    NCalendar ncalendar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.tv_month)
    TextView tv_month;
    @BindView(R.id.tv_date)
    TextView tv_date;

    private SimpleAdapter adapter;
    private List<String> dataList = new ArrayList<>();
    @Override
    public void initData() {
        dataList.clear();
        for (int i = 0; i < 30; i++) {
            dataList.add("条目：" + i);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
        recyclerView.setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.VERTICAL));
        adapter = new SimpleAdapter<String>(mContext, dataList, android.R.layout.simple_list_item_1) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, String data) {
                TextView textView = holder.getView(android.R.id.text1);
                textView.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300));
                textView.setText(data);
                textView.setTextColor(Color.WHITE);
                textView.setBackgroundColor(ColorUtil.generateBeautifulColor());
            }
        };
        recyclerView.setAdapter(adapter);
        ncalendar.setOnCalendarChangedListener(this);

        ncalendar.post(new Runnable() {
            @Override
            public void run() {
                List<String> list = new ArrayList<>();
                list.add("2018-06-2");
                list.add("2018-06-5");
                list.add("2018-06-9");
                list.add("2018-06-11");
                list.add("2018-06-12");
                list.add("2018-06-22");
                list.add("2018-06-23");
                list.add("2018-06-24");
                list.add("2018-06-25");
                list.add("2018-09-21");
                list.add("2018-10-21");
                list.add("2018-10-1");
                list.add("2018-10-15");
                list.add("2018-10-18");
                list.add("2018-10-26");
                list.add("2018-11-21");
                ncalendar.setPoint(list);
            }
        });
    }

    @Override
    public int setLayout() {
        return R.layout.activity_ncalendar;
    }


    @Override
    public void onCalendarChanged(LocalDate date) {
        tv_month.setText(date.getMonthOfYear() + "月");
        tv_date.setText(date.getYear() + "年" + date.getMonthOfYear() + "月" + date.getDayOfMonth() + "日");
        LogUtils.d("dateTime::" + date);
    }


    public void setDate(View view) {
        ncalendar.setDate("2017-12-31");
    }

    public void toMonth(View view) {
        ncalendar.toMonth();
    }

    public void toWeek(View view) {
        ncalendar.toWeek();
    }

    public void toToday(View view) {
        ncalendar.toToday();
    }

    public void toNextPager(View view) {
        ncalendar.toNextPager();
    }

    public void toLastPager(View view) {
        ncalendar.toLastPager();
    }

    @OnClick({R.id.common_bar_leftBtn})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.common_bar_leftBtn:
                onBackPressed();
                break;
        }
    }
}

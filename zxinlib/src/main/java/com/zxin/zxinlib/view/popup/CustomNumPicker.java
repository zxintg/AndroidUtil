package com.zxin.zxinlib.view.popup;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by liukui on 2016/9/28.
 */
public class CustomNumPicker {
    private boolean canAccess = false;
    private PickerToolsView num_pv;
    private ArrayList<String> numberList;
    private int startNum, endNum;
    private boolean spanNum;
    public String selectedNum;

    public CustomNumPicker(PickerToolsView oneView,int startNum, int endNum) {
        canAccess = true;
        this.startNum = startNum;
        this.endNum = endNum;
        num_pv = oneView;
        num_pv.setVisibility(View.VISIBLE);
    }

    private void initTimer(String unit) {
        spanNum = startNum != endNum;
        selectedNum = String.valueOf(startNum);

        if (numberList == null)
            numberList = new ArrayList<>();
        numberList.clear();

        if (spanNum) {
            for (int i = startNum; i <= endNum; i++) {
                numberList.add(String.valueOf(i)+" "+unit);
            }
        }
        num_pv.setData(numberList);
        num_pv.setSelected(0);
        executeScroll();
    }

    private void addListener() {
        num_pv.setOnSelectListener(new PickerToolsView.onSelectListener() {
            @Override
            public void onSelect(String text) {
                selectedNum = text.split(" ")[0];
            }
        });
    }

    private void executeAnimator(View view) {
        PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("alpha", 1f, 0f, 1f);
        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("scaleX", 1f, 1.3f, 1f);
        PropertyValuesHolder pvhZ = PropertyValuesHolder.ofFloat("scaleY", 1f, 1.3f, 1f);
        ObjectAnimator.ofPropertyValuesHolder(view, pvhX, pvhY, pvhZ).setDuration(200).start();
    }

    private void executeScroll() {
        num_pv.setCanScroll(numberList!=null&&!numberList.isEmpty()&&numberList.size() > 1);
    }

    public void show(String time, String unit) {
        if (canAccess) {
            if (startNum < endNum) {
                canAccess = true;
                initTimer(unit);
                addListener();
                setSelectedTime(time,unit);
            }else{
                canAccess = false;
            }
        }
    }

    /**
     * 设置日期控件是否可以循环滚动
     */
    public void setIsLoop(boolean isLoop) {
        if (canAccess) {
            this.num_pv.setIsLoop(isLoop);
        }
    }

    /**
     * 设置日期控件默认选中的时间
     */
    public void setSelectedTime(String num, String unit) {
        if (canAccess) {
            num_pv.setSelected(num+" "+unit);
            selectedNum = num;
            executeAnimator(num_pv);
            executeScroll();
        }
    }
}

package com.zxin.zxinlib.view.popup;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;

import com.zxin.zxinlib.util.BaseStringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by li on 2016/9/28.
 */
public class CustomStringPicker {
    private PickerToolsView csp_one,csp_two;
    private ArrayList<String> oneSelectList,twoSelectList;
    public String selectedOne="",selectedTwo="";
    private int select_strForMat = 1;
    private Map<String ,List<String>> datesMap = new HashMap<>();

    public CustomStringPicker(PickerToolsView viewOne, PickerToolsView viewTwo, int select_strForMat) {
        csp_one = viewOne;
        csp_two = viewTwo;
        this.select_strForMat = select_strForMat;
        if (this.select_strForMat==1) {
            csp_one.setVisibility(View.VISIBLE);
            return;
        }
        if (this.select_strForMat==2) {
            csp_one.setVisibility(View.VISIBLE);
            csp_two.setVisibility(View.VISIBLE);
            return;
        }
    }

    private void addListener() {
        csp_one.setOnSelectListener(new PickerToolsView.onSelectListener() {
            @Override
            public void onSelect(String text) {
                selectedOne = text;
                if (select_strForMat>1){
                    //联动滚动第二个
                    loadDates();
                    twoChange();
                }
            }
        });
        if (this.select_strForMat==1)
            return;
        csp_two.setOnSelectListener(new PickerToolsView.onSelectListener() {
            @Override
            public void onSelect(String text) {
                selectedTwo = text;
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
        csp_one.setCanScroll(oneSelectList!=null&&!oneSelectList.isEmpty()&&oneSelectList.size() > 1);
        if (this.select_strForMat==1)
            return;
        csp_two.setCanScroll(twoSelectList!=null&&!twoSelectList.isEmpty()&&twoSelectList.size() > 1);
    }

    public void initDatas(List<String> strList,Map<String , List<String>> datesMap){
        if (oneSelectList == null)
            oneSelectList = new ArrayList<>();
        oneSelectList.clear();
        oneSelectList.addAll(strList);
        csp_one.setData(oneSelectList);
        if (datesMap!=null) {
            this.datesMap.clear();
            this.datesMap.putAll(datesMap);
        }

        if (twoSelectList == null)
            twoSelectList = new ArrayList<>();
        twoSelectList.clear();

    }

    public void show(String selectedOne,String selectedTwo) {
        this.selectedOne = BaseStringUtils.textIsEmpty(selectedOne)? oneSelectList.get(0):selectedOne;
        this.selectedTwo = selectedTwo;
        addListener();
        csp_one.setSelected(oneSelectList.indexOf(this.selectedOne));
        executeAnimator(csp_one);
        executeScroll();
        if (select_strForMat>1){
            //联动滚动第二个
            loadDates();
            twoChange();
        }
    }

    /**
     * 设置日期控件是否可以循环滚动
     */
    public void setIsLoop(boolean isLoop) {
        this.csp_one.setIsLoop(isLoop);
        if (this.select_strForMat==1)
            return;
        this.csp_two.setIsLoop(isLoop);
    }

    private void loadDates(){
        if (this.select_strForMat==1)
            return;
        this.twoSelectList.clear();
        this.twoSelectList.addAll(this.datesMap.get(this.selectedOne));
    }

    private void twoChange() {
        if(this.twoSelectList.isEmpty())
            return;
        this.selectedTwo = BaseStringUtils.textIsEmpty(selectedTwo)||!twoSelectList.contains(selectedTwo)? twoSelectList.get(0):selectedTwo;
        csp_two.setData(twoSelectList);
        csp_two.setSelected(twoSelectList.indexOf(selectedTwo));
        executeAnimator(csp_two);
        executeScroll();
    }

}

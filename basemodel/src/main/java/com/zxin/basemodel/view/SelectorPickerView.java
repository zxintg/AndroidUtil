package com.zxin.basemodel.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zxin.basemodel.entity.City;
import com.zxin.root.bean.Address;
import com.zxin.root.view.popup.CustomDatePicker;
import com.zxin.root.view.popup.CustomNumPicker;
import com.zxin.root.view.popup.CustomStringPicker;
import com.zxin.root.view.popup.PickerToolsView;
import com.zxin.basemodel.R;
import com.zxin.basemodel.util.BaseStringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by liukui on 2017/11/30.
 */

public class SelectorPickerView extends LinearLayout {
    /*****
     * 标题栏
     */
    private LinearLayout headView;
    /**
     * 标题栏的左边按返回按钮
     */
    private TextView left_button;
    /**
     * 标题栏的右边按保存按钮
     */
    private TextView right_button;
    /**
     * 标题栏的中间的文字
     */
    private TextView title;

    /**
     * 标题栏的背景颜色
     */
    private int title_background_color;
    /*****
     * 布局背景颜色
     */
    private int background_color;
    /**
     * 标题栏的显示的标题文字
     */
    private String title_text;
    /**
     * 标题栏的显示的标题文字颜色
     */
    private int title_textColor;
    /**
     * 标题栏的显示的标题文字大小
     */
    private float title_textSize;

    /**
     * 左边按钮上显示的文字
     */
    private String left_button_text;
    /**
     * 左边按钮上显示的文字颜色
     */
    private int left_button_textColor;
    /**
     * 左边按钮上显示的文字大小
     */
    private float left_button_textSize;
    /**
     * 是否显示左边按钮
     */
    private boolean show_left_button = false;

    /**
     * 右边按钮上显示的文字
     */
    private String right_button_text;

    /**
     * 右边按钮的文字颜色
     */
    private int right_button_textColor;

    /**
     * 右边保存按钮的文字大小
     */
    private float right_button_textSize;
    /**
     * 是否显示右边按钮
     */
    private boolean show_right_button = false;

    /*****
     * 选中区的字体颜色
     */
    private int select_textColor;

    /*****
     * 选中字体大小
     */
    private float select_mintextSize;
    private float select_maxtextSize;

    /****
     * 选中单位
     */
    private String select_textUnit;

    /*****
     * 布局
     */
    private LinearLayout contentLayout;

    /*****
     * 高度
     */
    private float picker_height;

    /****
     * 选中器
     */
    private PickerToolsView pickerViewOne, pickerViewTwo, pickerViewThree, pickerViewFour, pickerViewFive, pickerViewSix;

    /*****
     * 类型
     */
    private int select_showType;

    /***日期格式****/
    private String select_dateForMat;

    /***字符串级连数****/
    private int select_strForMat = 1;
    //地址选择器
    private int select_address = 1;

    /*****
     * 开始范围
     */
    private String range_start;

    /*****
     * 结束范围
     */
    private String range_end;
    /****
     * 数组
     */
    private CharSequence[] range_array;

    /****
     * 是否设置初始值
     */
    private boolean pickerRange = true;

    private CustomNumPicker numPicker;

    private CustomDatePicker datePicker;
    private CustomAddressPicker addressPicker;
    private CustomStringPicker stringPicker;

    public SelectorPickerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        /**加载布局文件*/
        LayoutInflater.from(context).inflate(R.layout.customer_picker_view, this, true);
        headView = (LinearLayout) findViewById(R.id.customer_picker_head);
        left_button = (TextView) findViewById(R.id.customer_picker_leftbtn);
        right_button = (TextView) findViewById(R.id.customer_picker_rightbtn);
        title = (TextView) findViewById(R.id.customer_picker_title);
        contentLayout = (LinearLayout) findViewById(R.id.customer_picker_content);

        pickerViewOne = (PickerToolsView) findViewById(R.id.customer_picker_ptviewone);
        pickerViewTwo = (PickerToolsView) findViewById(R.id.customer_picker_ptviewtwo);
        pickerViewThree = (PickerToolsView) findViewById(R.id.customer_picker_ptviewthree);
        pickerViewFour = (PickerToolsView) findViewById(R.id.customer_picker_ptviewfour);
        pickerViewFive = (PickerToolsView) findViewById(R.id.customer_picker_ptviewfive);
        pickerViewSix = (PickerToolsView) findViewById(R.id.customer_picker_ptviewsix);

        /**
         * 获取属性值
         */
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SelectorPickerView);

        /**标题相关*/
        background_color = typedArray.getColor(R.styleable.SelectorPickerView_background_color, Color.WHITE);
        title_background_color = typedArray.getColor(R.styleable.SelectorPickerView_title_background_color, Color.WHITE);

        title_text = typedArray.getString(R.styleable.SelectorPickerView_picker_title_text);
        title_textColor = typedArray.getColor(R.styleable.SelectorPickerView_picker_title_textColor, Color.BLACK);
        title_textSize = typedArray.getDimension(R.styleable.SelectorPickerView_picker_title_textSize, 22);


        /**左边按钮相关*/
        left_button_text = typedArray.getString(R.styleable.SelectorPickerView_picker_left_text);
        left_button_textColor = typedArray.getColor(R.styleable.SelectorPickerView_picker_left_textColor, Color.WHITE);
        left_button_textSize = typedArray.getDimension(R.styleable.SelectorPickerView_picker_left_textSize, 20);
        show_left_button = typedArray.getBoolean(R.styleable.SelectorPickerView_show_picker_left, false);

        /**右边按钮相关*/
        right_button_text = typedArray.getString(R.styleable.SelectorPickerView_picker_right_text);
        right_button_textColor = typedArray.getColor(R.styleable.SelectorPickerView_picker_right_textColor, Color.WHITE);
        right_button_textSize = typedArray.getDimension(R.styleable.SelectorPickerView_picker_right_textSize, 20);
        show_right_button = typedArray.getBoolean(R.styleable.SelectorPickerView_show_picker_right, false);

        select_textColor = typedArray.getColor(R.styleable.SelectorPickerView_select_picker_textColor, Color.WHITE);
        select_mintextSize = typedArray.getDimension(R.styleable.SelectorPickerView_select_picker_mintextSize, 20);
        select_maxtextSize = typedArray.getDimension(R.styleable.SelectorPickerView_select_picker_maxtextSize, 20);
        select_textUnit = typedArray.getString(R.styleable.SelectorPickerView_select_picker_textUnit);

        /***选中器***/
        picker_height = typedArray.getDimension(R.styleable.SelectorPickerView_picker_height, 100);
        select_showType = typedArray.getInt(R.styleable.SelectorPickerView_picker_select_showType, 0);
        int dateType = typedArray.getInt(R.styleable.SelectorPickerView_picker_select_dateForMat, 0);
        boolean islocalDatas = typedArray.getBoolean(R.styleable.SelectorPickerView_picker_islocal_datas, true);
        pickerRange = typedArray.getBoolean(R.styleable.SelectorPickerView_picker_range, true);
        switch (dateType) {

            case 0:
                select_dateForMat = "yyyy-MM-dd HH:mm:ss";
                break;

            case 1:
                select_dateForMat = "yyyy-MM-dd HH:mm";
                break;

            case 2:
                select_dateForMat = "yyyy-MM-dd";
                break;

            case 3:
                select_dateForMat = "yyyy-MM";
                break;

            case 4:
                select_dateForMat = "HH:mm";
                break;

            case 5:
                select_dateForMat = "MM-dd";
                break;

            case 6:
                select_dateForMat = "HH:mm:ss";
                break;
        }

        select_strForMat = typedArray.getInt(R.styleable.SelectorPickerView_picker_select_strForMat, 1);

        select_address = typedArray.getInt(R.styleable.SelectorPickerView_picker_select_address, 1);

        switch (select_address){

            case 1:
                type = CustomAddressPicker.AddressType.All;
                break;

            case 2:
                type = CustomAddressPicker.AddressType.Province;
                break;

            case 3:
                type = CustomAddressPicker.AddressType.City;
                break;

            case 4:
                type = CustomAddressPicker.AddressType.District;
                break;

            case 5:
                type = CustomAddressPicker.AddressType.Province_City;
                break;

            case 6:
                type = CustomAddressPicker.AddressType.City_District;
                break;

        }

        /****
         * 范围
         */
        range_start = typedArray.getString(R.styleable.SelectorPickerView_picker_range_start);
        range_end = typedArray.getString(R.styleable.SelectorPickerView_picker_range_end);
        range_array = typedArray.getTextArray(R.styleable.SelectorPickerView_picker_range_array);

        typedArray.recycle();

        //左边布局
        setBackground();
        setLeftButton();
        setTitle(title_text);
        setRightButton();
        if (islocalDatas)
            setPickerView();
    }

    /**
     * 设置背景颜色
     */
    public void setBackground() {
        setBackgroundColor(background_color);
        headView.setBackgroundColor(title_background_color);
    }

    /**
     * 设置左边按钮
     */
    public void setLeftButton() {
        if (!TextUtils.isEmpty(left_button_text)) {//返回按钮显示为文字
            left_button.setText(left_button_text);
            left_button.setTextColor(left_button_textColor);
            left_button.setTextSize(left_button_textSize);
        } else {
            left_button.setText("");
        }
        //是否显示
        left_button.setVisibility(!TextUtils.isEmpty(left_button_text) || show_left_button ? View.VISIBLE : View.INVISIBLE);
    }

    /**
     * 设置标题
     */
    public void setTitle(String mesg) {
        title_text = mesg;
        title.setText(title_text);
        title.setTextColor(title_textColor);
        title.setTextSize(title_textSize);
        //是否显示
        title.setVisibility(TextUtils.isEmpty(title_text) ? View.INVISIBLE : View.VISIBLE);
    }

    /*****
     * 设置右边按钮
     */
    public void setRightButton() {
        if (!TextUtils.isEmpty(right_button_text)) {//返回按钮显示为文字
            right_button.setText(right_button_text);
            right_button.setTextColor(right_button_textColor);
            right_button.setTextSize(right_button_textSize);
        } else {
            right_button.setText("");
        }
        //是否显示
        right_button.setVisibility(!TextUtils.isEmpty(right_button_text) || show_right_button ? View.VISIBLE : View.INVISIBLE);
    }

    /*****
     * 初始化选器空间
     */
    private void setPickerView() {
        switch (select_showType) {
            case 0:
                //数字选择
                if (!pickerRange)
                    return;
                setNumberPickerView();
                break;

            case 1:
                //日期选择
                setDatePickerView();
                break;

            case 2:
                //地址
                setAddressPickerView();
                break;

            case 3:
                //字符串
                setStringPickerView();
                break;
        }
    }

    /******
     * 数字选中器
     */
    private void setNumberPickerView() {
        pickerViewOne.setTextSizeRange(select_mintextSize, select_maxtextSize);
        numPicker = new CustomNumPicker(pickerViewOne, Integer.parseInt(range_start), Integer.parseInt(range_end));
        numPicker.setIsLoop(false);
        right_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onResultPicker(Integer.parseInt(numPicker.selectedNum));
            }
        });
    }

    /****
     * 设置字符串数据范围
     * @param start
     * @param end
     */
    public void setNumberPickerView(int start,int end) {
        pickerViewOne.setTextSizeRange(select_mintextSize, select_maxtextSize);
        numPicker = new CustomNumPicker(pickerViewOne,start, end);
        numPicker.setIsLoop(false);
        right_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onResultPicker(Integer.parseInt(numPicker.selectedNum));
            }
        });
    }

    /****
     * 日期选择器
     */
    private void setDatePickerView() {
        pickerViewOne.setTextSizeRange(select_mintextSize, select_maxtextSize);
        pickerViewTwo.setTextSizeRange(select_mintextSize, select_maxtextSize);
        pickerViewThree.setTextSizeRange(select_mintextSize, select_maxtextSize);
        pickerViewFour.setTextSizeRange(select_mintextSize, select_maxtextSize);
        pickerViewFive.setTextSizeRange(select_mintextSize, select_maxtextSize);
        pickerViewSix.setTextSizeRange(select_mintextSize, select_maxtextSize);
        datePicker = new CustomDatePicker(range_start, range_end, select_dateForMat);
        datePicker.initView(pickerViewOne, pickerViewTwo, pickerViewThree, pickerViewFour, pickerViewFive, pickerViewSix);
        datePicker.setIsLoop(false);
        right_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onResultPicker(new SimpleDateFormat(select_dateForMat, Locale.CHINA).format(datePicker.selectedCalender.getTime()));
            }
        });
    }

    /*****
     * 地址选择器
     */
    private CustomAddressPicker.AddressType type;
    private void setAddressPickerView() {
        pickerViewOne.setTextSizeRange(select_mintextSize, select_maxtextSize);
        pickerViewTwo.setTextSizeRange(select_mintextSize, select_maxtextSize);
        pickerViewThree.setTextSizeRange(select_mintextSize, select_maxtextSize);
        addressPicker = new CustomAddressPicker(pickerViewOne, pickerViewTwo,pickerViewThree);
        addressPicker.setAddressType(type);
        addressPicker.setIsLoop(false);
        right_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onResultPicker(addressPicker.selected);
            }
        });
    }

    /****
     * 地址选择器，网络数据
     * @param cityList
     */
    public void setShowCityDatas(List<City> cityList) {
        setAddressPickerView();
        addressPicker.initTimer(cityList);
    }

    /*****
     * 字符串选择器
     */
    private void setStringPickerView() {
        pickerViewOne.setTextSizeRange(select_mintextSize, select_maxtextSize);
        pickerViewTwo.setTextSizeRange(select_mintextSize, select_maxtextSize);
        stringPicker = new CustomStringPicker(pickerViewOne,pickerViewTwo,select_strForMat);
        stringPicker.setIsLoop(false);
        if (range_array != null) {
            List<String> list = new ArrayList<>();
            for (CharSequence item : range_array) {
                list.add(item.toString());
            }
            setStringList(list,null);
        }
        right_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onResultPicker(stringPicker.selectedOne+(BaseStringUtils.textIsEmpty(stringPicker.selectedTwo)?"":"&str&"+stringPicker.selectedTwo));
            }
        });
    }

    public void setShowNumPicker(String str) {
        numPicker.show(str, select_textUnit);
    }

    /****
     * 设置日期区间
     * @param startDate
     * @param endDate
     * @return
     */
    public SelectorPickerView setDateRange(String startDate, String endDate){
        if (!TextUtils.isEmpty(startDate))
            this.range_start = startDate;
        if (!TextUtils.isEmpty(endDate))
            this.range_end = endDate;
        datePicker.setDateRange(range_start,range_end);
        return this;
    }

    public void setShowDatePicker(String str) {
        datePicker.show(str);
    }

    public void setShowAddressPicker(Address address) {
        Address newAddress = new Address();
        if (address!=null) {
            newAddress.province = address.province;
            newAddress.provinceId = address.provinceId;
            newAddress.cityId = address.cityId;
            newAddress.city = address.city;
            newAddress.district = address.district;
            newAddress.districtId = address.districtId;
            newAddress.address = address.address;
        }
        addressPicker.show(newAddress);
    }

    public void setShowStringPicker(String selectOne,String selectTwo) {
        stringPicker.show(selectOne,selectTwo);
    }

    /****
     * 设置数据信息(可以不设置)
     */
    public void setStringList(List<String> list,Map<String , List<String>> datesMap) {
        stringPicker.initDatas(list,datesMap);
    }

    public void setSelectPicker(SelectPickerListener listener) {
        this.listener = listener;
    }

    private SelectPickerListener listener;


    public interface SelectPickerListener {
        void onResultPicker(Object obj);
    }

}

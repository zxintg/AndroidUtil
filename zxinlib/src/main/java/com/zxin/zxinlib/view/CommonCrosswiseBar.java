package com.zxin.zxinlib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zxin.zxinlib.R;
import com.zxin.zxinlib.util.BaseStringUtils;
import com.zxin.zxinlib.util.ImageUtil;
import com.zxin.zxinlib.util.SystemInfoUtil;
import com.zxin.zxinlib.util.UiUtils;

/**
 * 自定义公共横向布局
 * <p>
 * liukui 2017/11/22 10:21
 */

public class CommonCrosswiseBar extends RelativeLayout {
    /**
     * 标题栏
     */
    private View common_bar;
    /**
     * 标题栏的左边按返回按钮
     */
    private TextView left_button;

    private ImageView leftImage;
    /**
     * 标题栏的右边按保存按钮
     */
    private TextView right_button;
    /**
     * 标题栏的中间的文字
     */
    private TextView title;

    /*****
     * 搜索输入框
     */
    private EditText etSearch;
    /*****
     * 右边图片
     */
    private ImageView rightImage;
    /****
     * 分割线
     */
    private View line;
    /**
     * 标题栏的背景颜色
     */
    private int background_color;
    /**
     * 标题栏的背景资源
     */
    private int background_color_res;
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

    /******
     * 搜索框文字
     */
    private String title_edit;

    /****
     * 搜索框隐藏文字
     */
    private String title_editHint;
    /****
     * 搜索框文字颜色
     */
    private int title_editColor;
    /****
     * 搜索框隐藏文字颜色
     */
    private int title_editHintColor;
    /****
     * 搜索框文字大小
     */
    private float title_editSize;

    /**
     * 返回按钮的资源图片
     */
    private int left_button_imageId;
    /**
     * 返回按钮上显示的文字
     */
    private String left_button_text;
    /**
     * 返回按钮上显示的文字颜色
     */
    private int left_button_textColor;
    /**
     * 返回按钮上显示的文字大小
     */
    private float left_button_textSize;
    /***
     * 左边图片大小
     */
    private float left_button_size;
    /**
     * 是否显示返回按钮
     */
    private boolean show_left_button = false;

    /***
     * 右边图片
     */
    private int left_image_imageId;

    /*****
     * 是否显示右边图片
     */
    private boolean show_left_image = false;

    /*****
     * 右边图片大小
     */
    private float left_image_width = -1;

    /*****
     * 右边图片大小
     */
    private float left_image_height = -1;
    /***
     * 右边图片
     */
    private int right_image_imageId;

    /*****
     * 是否显示右边图片
     */
    private boolean show_right_image = false;

    /*****
     * 右边图片大小
     */
    private float right_image_width = -1;

    /*****
     * 右边图片大小
     */
    private float right_image_height = -1;

    /**
     * 右边保存按钮的资源图片
     */
    private int right_button_imageId;
    /**
     * 右边保存按钮的文字
     */
    private String right_button_text;
    /*****
     * 影藏右边标签默认提示语
     */
    private String right_button_hintText;
    /**
     * 右边保存按钮的文字颜色
     */
    private int right_button_textColor;
    /*****
     * 隐藏便签默认字体颜色
     */
    private int right_button_textHintColor;
    /**
     * 右边保存按钮的文字大小
     */
    private float right_button_textSize;
    /*****
     * 右边图片大小
     */
    private float right_button_size;
    /**
     * 是否显示右边保存按钮
     */
    private boolean show_right_button = false;

    /*****
     * 背景透明度
     */
    private float background_alpha;

    /*****
     * 布局透明度
     */
    private float view_alpha;

    /*****
     * 布局透明度 类型
     */
    private int view_alpha_showType;

    /***
     * 是否头部导航
     */
    private boolean isTopBar = false;

    /****
     * 是否显示横线
     */
    private boolean showLine = true;

    /****
     * 线条颜色
     */
    private int line_color = -1;

    public CommonCrosswiseBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        /**加载布局文件*/
        LayoutInflater.from(context).inflate(R.layout.common_crosswise_bar, this, true);
        common_bar = findViewById(R.id.common_bar);
        left_button = (TextView) findViewById(R.id.common_bar_leftBtn);
        leftImage = (ImageView) findViewById(R.id.common_bar_leftImage);
        right_button = (TextView) findViewById(R.id.common_bar_rightBtn);
        title = (TextView) findViewById(R.id.common_bar_title);
        etSearch = (EditText) findViewById(R.id.common_bar_et_search);
        rightImage = (ImageView) findViewById(R.id.common_bar_rightImage);
        line = findViewById(R.id.common_bar_line);

        /**获取属性值*/
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CommonCrosswiseBar);

        /**标题相关*/
        background_color = typedArray.getColor(R.styleable.CommonCrosswiseBar_bar_background, Color.WHITE);
        background_color_res = typedArray.getResourceId(R.styleable.CommonCrosswiseBar_bar_background_res, -1);

        title_text = typedArray.getString(R.styleable.CommonCrosswiseBar_title_text);
        title_textColor = typedArray.getColor(R.styleable.CommonCrosswiseBar_title_textColor, Color.BLACK);
        title_textSize = typedArray.getDimension(R.styleable.CommonCrosswiseBar_title_textSize, 22);

        /***搜索****/
        title_edit = typedArray.getString(R.styleable.CommonCrosswiseBar_title_edittext);
        title_editHint = typedArray.getString(R.styleable.CommonCrosswiseBar_title_edithinttext);
        title_editColor = typedArray.getColor(R.styleable.CommonCrosswiseBar_title_editColor, Color.BLACK);
        title_editHintColor = typedArray.getColor(R.styleable.CommonCrosswiseBar_title_edithintColor, Color.BLACK);
        title_editSize = typedArray.getDimension(R.styleable.CommonCrosswiseBar_title_editSize, 22);

        /**左边按钮相关*/
        left_button_imageId = typedArray.getResourceId(R.styleable.CommonCrosswiseBar_left_button_image, R.mipmap.ic_black_left_arrow);
        left_button_text = typedArray.getString(R.styleable.CommonCrosswiseBar_left_button_text);
        left_button_textColor = typedArray.getColor(R.styleable.CommonCrosswiseBar_left_button_textColor, Color.WHITE);
        left_button_textSize = typedArray.getDimension(R.styleable.CommonCrosswiseBar_left_button_textSize, 20);
        left_button_size = typedArray.getDimension(R.styleable.CommonCrosswiseBar_left_button_size, 15);
        show_left_button = typedArray.getBoolean(R.styleable.CommonCrosswiseBar_show_left_button, false);

        /***左边图片***/
        left_image_imageId = typedArray.getResourceId(R.styleable.CommonCrosswiseBar_left_image, R.mipmap.icon_left_close);
        show_left_image = typedArray.getBoolean(R.styleable.CommonCrosswiseBar_show_left_image, false);
        left_image_width = typedArray.getDimension(R.styleable.CommonCrosswiseBar_left_image_width, -1);
        left_image_height = typedArray.getDimension(R.styleable.CommonCrosswiseBar_left_image_height, -1);

        /***右边图片***/
        right_image_imageId = typedArray.getResourceId(R.styleable.CommonCrosswiseBar_right_image, R.mipmap.ic_black_right_arrow);
        show_right_image = typedArray.getBoolean(R.styleable.CommonCrosswiseBar_show_right_image, false);
        right_image_width = typedArray.getDimension(R.styleable.CommonCrosswiseBar_right_image_width, -1);
        right_image_height = typedArray.getDimension(R.styleable.CommonCrosswiseBar_right_image_height, -1);

        /**右边按钮相关*/
        right_button_imageId = typedArray.getResourceId(R.styleable.CommonCrosswiseBar_right_button_image, R.mipmap.ic_black_right_arrow);
        right_button_text = typedArray.getString(R.styleable.CommonCrosswiseBar_right_button_text);
        right_button_hintText = typedArray.getString(R.styleable.CommonCrosswiseBar_right_button_hintText);
        right_button_textColor = typedArray.getColor(R.styleable.CommonCrosswiseBar_right_button_textColor, Color.WHITE);
        right_button_textHintColor = typedArray.getColor(R.styleable.CommonCrosswiseBar_right_button_textHintColor, Color.WHITE);
        right_button_textSize = typedArray.getDimension(R.styleable.CommonCrosswiseBar_right_button_textSize, 20);
        right_button_size = typedArray.getDimension(R.styleable.CommonCrosswiseBar_right_button_size, 15);
        show_right_button = typedArray.getBoolean(R.styleable.CommonCrosswiseBar_show_right_button, false);
        isTopBar = typedArray.getBoolean(R.styleable.CommonCrosswiseBar_isTopBar, false);
        line_color = typedArray.getColor(R.styleable.CommonCrosswiseBar_line_color, -1);
        showLine = typedArray.getBoolean(R.styleable.CommonCrosswiseBar_show_bar_line, true);

        background_alpha = typedArray.getFloat(R.styleable.CommonCrosswiseBar_background_alpha, 1);
        view_alpha = typedArray.getFloat(R.styleable.CommonCrosswiseBar_view_alpha, 1);
        view_alpha_showType = typedArray.getInt(R.styleable.CommonCrosswiseBar_view_alpha_showType, -1);

        typedArray.recycle();

        setParameter();
        setBackground();
        setLeftButton();
        setLeftImage();
        setTitle();
        setSearch();
        setRightImage();
        setRightButton();
        setLineView();
    }

    /*****
     * 设置偏移量
     */
    private void setParameter() {
        if (!isTopBar)
            return;
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, SystemInfoUtil.dip2px(45) + SystemInfoUtil.getStatusBarHeight());
        //params.setMargins(0, SystemInfoUtil.getStatusBarHeight(), 0, 0);
        common_bar.setPadding(0, common_bar.getPaddingTop() + SystemInfoUtil.getStatusBarHeight(), 0, 0);
        common_bar.setLayoutParams(params);
        setBackgrudAlpha(background_alpha);
        setViewAlpha(view_alpha);
    }

    public int getTitleHeight() {
        return SystemInfoUtil.dip2px(45) + SystemInfoUtil.getStatusBarHeight();
    }

    /**
     * 设置背景颜色
     */
    public void setBackground() {
        if (background_color_res == -1)
            common_bar.setBackgroundColor(background_color);
        else
            common_bar.setBackgroundResource(background_color_res);
    }

    public void setBGColor(int color) {
        background_color = color;
        if (background_color_res == -1)
            common_bar.setBackgroundColor(UiUtils.getColor(color));
    }

    /****
     * 设置布局背景资源
     * @param res
     */
    public void setBackgroundRes(int res) {
        common_bar.setBackgroundResource(res);
    }

    /**
     * 设置左边按钮
     */
    public void setLeftButton() {
        if (!BaseStringUtils.textIsEmpty(title_text)) {
            left_button.setMaxEms(10);
        }
        if (!TextUtils.isEmpty(left_button_text)) {//返回按钮显示为文字
            left_button.setText(left_button_text);
            left_button.setTextColor(left_button_textColor);
            left_button.setTextSize(left_button_textSize);
        } else {
            left_button.setText("");
        }
        if (show_left_button) {
            //left_button.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(left_button_imageId),null,null,null);
            ImageUtil.setCompoundDrawable(left_button, (int) left_button_size, left_button_imageId, Gravity.LEFT, 0);
        }
        //是否显示
        left_button.setVisibility(!TextUtils.isEmpty(left_button_text) || show_left_button ? View.VISIBLE : View.INVISIBLE);
    }

    /**
     * 设置标题
     */
    public void setTitle() {
        title.setText(title_text);
        title.setTextColor(title_textColor);
        title.setTextSize(title_textSize);
        //是否显示
        title.setVisibility(TextUtils.isEmpty(title_text) ? View.GONE : View.VISIBLE);
    }

    /**
     * 设置输入框
     */
    public void setSearch() {
        etSearch.setText(title_edit);
        etSearch.setText(title_editHint);
        etSearch.setTextColor(title_editColor);
        etSearch.setTextColor(title_editHintColor);
        etSearch.setTextSize(title_editSize);
        //是否显示
        etSearch.setVisibility(TextUtils.isEmpty(title_edit) && TextUtils.isEmpty(title_editHint) ? View.INVISIBLE : View.VISIBLE);
    }

    /******
     * 设置右边图片
     */
    public void setLeftImage() {
        if (show_left_image) {
            leftImage.setImageResource(left_image_imageId);
            leftImage.setVisibility(View.VISIBLE);
        } else {
            leftImage.setVisibility(View.GONE);
        }
        if (left_image_width != -1 && left_image_height != -1) {
            int left = leftImage.getLeft();
            int top = leftImage.getTop();
            int bottom = leftImage.getBottom();
            int right = leftImage.getRight();
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(SystemInfoUtil.dip2px(left_image_width), SystemInfoUtil.dip2px(left_image_height));
            params.setMargins(left, top, right, bottom);
            leftImage.setLayoutParams(params);
        }
    }

    /******
     * 设置右边图片
     */
    public void setRightImage() {
        if (show_right_image) {
            rightImage.setImageResource(right_image_imageId);
            rightImage.setVisibility(View.VISIBLE);
        } else {
            rightImage.setVisibility(View.GONE);
        }
        if (right_image_width != -1 && right_image_height != -1) {
            int left = rightImage.getLeft();
            int top = rightImage.getTop();
            int bottom = rightImage.getBottom();
            int right = rightImage.getRight();
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(SystemInfoUtil.dip2px(right_image_width), SystemInfoUtil.dip2px(right_image_height));
            params.setMargins(left, top, right, bottom);
            rightImage.setLayoutParams(params);
        }
    }

    public void setRightButton(int right_button_imageId) {
        this.right_button_imageId = right_button_imageId;
        ImageUtil.setCompoundDrawable(right_button, (int) left_button_size, right_button_imageId, Gravity.RIGHT, 0);
        right_button.setVisibility(VISIBLE);
    }

    public void setRightImageVisibility() {
        rightImage.setVisibility(INVISIBLE);
    }

    public void setLeftImageVisibility() {
        leftImage.setVisibility(INVISIBLE);
    }


    public void setLeftButton(int left_button_imageId) {
        this.left_button_imageId = left_button_imageId;
        ImageUtil.setCompoundDrawable(left_button, (int) left_button_size, left_button_imageId, Gravity.LEFT, 0);
    }

    public void setOnClickListener(int resId, OnClickListener listener) {
        findViewById(resId).setOnClickListener(listener);
    }

    /******
     * 设置是否显示标题
     */
    public void setRightButton() {
        if (!BaseStringUtils.textIsEmpty(title_text)) {
            right_button.setMaxEms(10);
        } else {
            right_button.setMaxEms(15);
        }
        if (!TextUtils.isEmpty(right_button_text)) {//返回按钮显示为文字
            right_button.setText(right_button_text);
            right_button.setTextColor(right_button_textColor);
            right_button.setTextSize(right_button_textSize);
        } else {
            right_button.setText("");
        }
        right_button.setHint(right_button_hintText);
        right_button.setHintTextColor(right_button_textHintColor);
        if (show_right_button) {
            //right_button.setCompoundDrawablesWithIntrinsicBounds(null,null,getResources().getDrawable(right_button_imageId),null);
            ImageUtil.setCompoundDrawable(right_button, (int) right_button_size, right_button_imageId, Gravity.RIGHT, 0);
        }
        //是否显示
        right_button.setVisibility(!TextUtils.isEmpty(right_button_text) || show_right_button ? View.VISIBLE : View.INVISIBLE);
    }

    /****
     * 设置线条参数
     */
    private void setLineView() {
        if (background_color_res != -1)
            return;
        showLineView(showLine);
        if (showLine && line_color == -1)
            return;
        line.setBackgroundColor(line_color);
    }

    public void setRightText(String text) {
        right_button.setText(text);
        right_button.setTextColor(right_button_textColor);
        right_button.setTextSize(right_button_textSize);
    }

    public void setRightTextColor(int textColor) {
        right_button_textColor = UiUtils.getColor(textColor);
        right_button.setTextColor(right_button_textColor);
    }

    public void setRightHintText(String text) {
        if (!TextUtils.isEmpty(text)) {
            right_button.setHint(text);
            right_button.setTextColor(right_button_textColor);
            right_button.setTextSize(right_button_textSize);
        }
    }

    public void setLeftIsShow(boolean isShow) {
        left_button.setVisibility(isShow? View.VISIBLE : View.INVISIBLE);
    }

    public void setRightIsShow(boolean isShow) {
        right_button.setVisibility(isShow? View.VISIBLE : View.INVISIBLE);
    }

    public void setLeftText(String text) {
        if (!TextUtils.isEmpty(text)) {
            left_button.setText(text);
            left_button.setTextColor(left_button_textColor);
            left_button.setTextSize(left_button_textSize);
        }
    }

    public void setTitleText(String text) {
        if (!TextUtils.isEmpty(text)) {
            title.setText(text);
        }
    }

    public void setTitleTextColor(int color) {
        title_textColor = UiUtils.getColor(color);
        title.setTextColor(title_textColor);
    }

    public void setBackgrudAlpha(float alpha) {
        background_alpha = alpha;
        common_bar.setAlpha(alpha);
    }

    public void setViewAlpha(float alpha) {
        if (view_alpha_showType == -1)
            return;
        view_alpha = alpha;
        switch (view_alpha_showType) {
            case 0:
                left_button.setAlpha(alpha);
                break;
            case 1:
                title.setAlpha(alpha);
                break;
            case 2:
                right_button.setAlpha(alpha);
                break;
        }
    }

    public ImageView getRightImage() {
        return rightImage;
    }

    public ImageView getLeftImage() {
        return leftImage;
    }

    public void setVisibility(int id, boolean show) {
        findViewById(id).setVisibility(show ? View.VISIBLE : View.INVISIBLE);
        findViewById(id).setEnabled(show);
    }

    public void setViewGone(int id, boolean show) {
        findViewById(id).setVisibility(show ? View.VISIBLE : View.GONE);
        findViewById(id).setEnabled(show);
    }

    public void showLineView(boolean isShow) {
        showLine = isShow;
        line.setVisibility(isShow ? VISIBLE : GONE);
    }

    public void setLineColor(int color) {
        if (color == -1)
            return;
        if (!showLine)
            showLineView(true);
        line_color = color;
        line.setBackgroundColor(line_color);
    }


    public String getRightText() {
        return right_button.getText().toString().trim();
    }

    public String getTitleText() {
        return title.getText().toString().trim();
    }

}

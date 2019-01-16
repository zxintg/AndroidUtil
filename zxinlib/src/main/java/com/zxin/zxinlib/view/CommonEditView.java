package com.zxin.zxinlib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zxin.zxinlib.R;
import com.zxin.zxinlib.util.BaseStringUtils;
import com.zxin.zxinlib.util.ImageUtil;
import com.zxin.zxinlib.util.SystemInfoUtil;

/**
 * 自定义公共横向布局
 * <p>
 * liukui 2018/04/09 14:20
 */

public class CommonEditView extends LinearLayout {
    //标题栏
    private View editview;
    //内容
    private View ll_content;
    //左边文本
    private TextView leftText;
    //左边线条
    private View leftLine;

    //文本输入框
    private EditText contentEdit;
    //右边线条
    private View rightLine;
    //右边文本
    private TextView rightText;
    //线条
    private View line;

    //布局背景资源
    private int bgColor;
    private int bgRes;
    //文本输入背景
    private int content_BgRes;
    private float padding_left;
    private float padding_right;
    private float padding_top;
    private float padding_bottom;
    //左边图片资源
    private int left_image;
    //左边文本
    private String left_text;
    //左边文本颜色
    private int left_textColor;
    //左边文本默认颜色
    private int left_hintColor;
    //左边文本字体大小
    private float left_textSize;
    //左边文本默认文字
    private String left_hintText;
    //左边文本背景资源
    private int left_textRes;
    //是否展示左边线条
    private boolean show_leftLine = false;
    //输入文本
    private String content_text;
    //默认文本输入
    private String content_hintText;
    //输入文本字体颜色
    private int content_textColor;
    //输入文本默认颜色
    private int content_hintColor;
    //输入文本字体大小
    private float content_textSize;
    //右边文本
    private String right_text;
    //右边文本颜色
    private int right_textColor;
    //右边文本字体大小
    private float right_textSize;
    //右边文本默认颜色
    private int right_hintColor;
    //右边文本默认文字
    private String right_hintText;
    //右边文本背景资源
    private int right_textRes;
    //是否显示右边线条
    private boolean show_rightLine = false;
    //右边图片资源
    private int right_image;
    //是否显示横线
    private boolean show_line = false;
    //条高度
    private float line_height;
    //是否监控文本输入
    private boolean is_listener_input = false;
    //默认显示右边按钮
    private boolean showRight = false;
    //是否监控删除按钮
    private boolean is_listener_clear = false;

    public CommonEditView(Context context, AttributeSet attrs) {
        super(context, attrs);
        /**加载布局文件*/
        LayoutInflater.from(context).inflate(R.layout.common_editview, this, true);
        editview = findViewById(R.id.ll_editview);
        ll_content = findViewById(R.id.ll_content);
        leftText = (TextView) findViewById(R.id.tv_edittext_leftText);
        leftLine = findViewById(R.id.tv_edittext_leftLine);
        contentEdit = (EditText) findViewById(R.id.et_edittext_contentEdit);
        rightLine = findViewById(R.id.tv_edittext_rightLine);
        rightText = (TextView) findViewById(R.id.tv_edittext_rightText);
        line = findViewById(R.id.view_line);

        /**获取属性值*/
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CommonEditView);

        isTopEdit = typedArray.getBoolean(R.styleable.CommonEditView_isTopEdit, false);
        padding_left = typedArray.getDimension(R.styleable.CommonEditView_padding_left, 0);
        padding_right = typedArray.getDimension(R.styleable.CommonEditView_padding_right, 0);
        padding_top = typedArray.getDimension(R.styleable.CommonEditView_padding_top, 0);
        padding_bottom = typedArray.getDimension(R.styleable.CommonEditView_padding_bottom, 0);

        /**标题相关*/
        bgColor = typedArray.getResourceId(R.styleable.CommonEditView_editview_bgColor, Color.WHITE);
        bgRes = typedArray.getResourceId(R.styleable.CommonEditView_editview_bgRes, -1);

        /**左边*/
        left_text = typedArray.getString(R.styleable.CommonEditView_left_text);
        left_textColor = typedArray.getColor(R.styleable.CommonEditView_left_textColor, -1);
        left_hintText = typedArray.getString(R.styleable.CommonEditView_left_hintText);
        left_hintColor = typedArray.getColor(R.styleable.CommonEditView_left_hintColor, -1);
        left_textSize = typedArray.getDimension(R.styleable.CommonEditView_left_textSize, 20);
        left_image = typedArray.getResourceId(R.styleable.CommonEditView_left_imageRes, -1);
        left_textRes = typedArray.getResourceId(R.styleable.CommonEditView_left_textRes, -1);

        //左边线条
        show_leftLine = typedArray.getBoolean(R.styleable.CommonEditView_show_leftLine, false);

        //内容
        content_text = typedArray.getString(R.styleable.CommonEditView_content_text);
        content_textColor = typedArray.getColor(R.styleable.CommonEditView_content_textColor, -1);
        content_textSize = typedArray.getDimension(R.styleable.CommonEditView_content_textSize, 22);
        content_hintText = typedArray.getString(R.styleable.CommonEditView_content_hintText);
        content_hintColor = typedArray.getColor(R.styleable.CommonEditView_content_hintColor, -1);
        content_BgRes = typedArray.getResourceId(R.styleable.CommonEditView_content_BgRes, -1);

        //右边线条
        show_rightLine = typedArray.getBoolean(R.styleable.CommonEditView_show_rightLine, false);

        /****
         *右边组件
         */
        right_text = typedArray.getString(R.styleable.CommonEditView_right_text);
        right_textColor = typedArray.getColor(R.styleable.CommonEditView_right_textColor, -1);
        right_hintColor = typedArray.getColor(R.styleable.CommonEditView_right_hintColor, -1);
        right_textSize = typedArray.getDimension(R.styleable.CommonEditView_right_textSize, 15);
        right_hintText = typedArray.getString(R.styleable.CommonEditView_right_hintText);
        right_image = typedArray.getResourceId(R.styleable.CommonEditView_right_imageRes, -1);
        right_textRes = typedArray.getResourceId(R.styleable.CommonEditView_right_textRes, -1);

        //线条
        show_line = typedArray.getBoolean(R.styleable.CommonEditView_show_line, false);
        line_height = typedArray.getDimension(R.styleable.CommonEditView_line_height, -1);

        //是否监控文本输入
        is_listener_input = typedArray.getBoolean(R.styleable.CommonEditView_is_listener_input, false);
        showRight = typedArray.getBoolean(R.styleable.CommonEditView_is_showRight, false);
        is_listener_clear = typedArray.getBoolean(R.styleable.CommonEditView_is_listener_clear, false);

        setParameter();
        setContentParameter();
        setBackground();
        setLeftText();
        setContentText();
        setRightText();
        setLineParameter();
        setOnInputListener();
        setOnClearListener();
    }

    private void setOnClearListener() {
        if (!is_listener_clear)
            return;
        rightText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                contentEdit.setText("");
            }
        });
    }

    private void setContentParameter() {
        if (padding_left == 0 && padding_top == 0 && padding_right == 0 && padding_bottom == 0)
            return;
        ll_content.setPadding((int) padding_left, (int) padding_top, (int) padding_right, (int) padding_bottom);
    }

    //是否头部导航
    private boolean isTopEdit = false;

    /*****
     * 设置偏移量
     */
    private void setParameter() {
        if (!isTopEdit)
            return;
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, SystemInfoUtil.dip2px(45) + SystemInfoUtil.getStatusBarHeight());
        editview.setPadding(0, editview.getPaddingTop() + SystemInfoUtil.getStatusBarHeight(), 0, 0);
        editview.setLayoutParams(params);
    }

    /**
     * 设置背景颜色
     */
    public void setBackground() {
        if (bgRes == -1)
            editview.setBackgroundColor(bgColor);
        else
            editview.setBackgroundResource(bgRes);
        if (left_textRes != -1)
            leftText.setBackgroundResource(left_textRes);
        if (right_textRes != -1)
            rightText.setBackgroundResource(right_textRes);
    }

    /**
     * 设置左边按钮
     */
    public void setLeftText() {
        if (BaseStringUtils.textIsEmpty(left_text) && BaseStringUtils.textIsEmpty(left_hintText) && left_image == -1)
            return;
        leftText.setVisibility(VISIBLE);
        if (!BaseStringUtils.textIsEmpty(left_text))
            leftText.setText(left_text);
        if (left_textColor != -1)
            leftText.setTextColor(left_textColor);

        if (!BaseStringUtils.textIsEmpty(left_hintText))
            leftText.setHint(left_hintText);
        if (left_hintColor != -1)
            leftText.setHintTextColor(left_hintColor);

        if (left_image != -1)
            ImageUtil.setCompoundDrawable(leftText, 15, left_image, Gravity.LEFT, 0);

        leftText.setTextSize(left_textSize);
    }

    /**
     * 内容
     */
    public void setContentText() {
        if (!BaseStringUtils.textIsEmpty(content_text))
            contentEdit.setText(content_text);
        if (content_textColor != -1)
            contentEdit.setTextColor(content_textColor);
        if (!BaseStringUtils.textIsEmpty(content_hintText))
            contentEdit.setHint(content_hintText);
        if (content_hintColor != -1)
            contentEdit.setHighlightColor(content_hintColor);
        if (content_BgRes != -1)
            contentEdit.setBackgroundResource(content_BgRes);
        contentEdit.setTextSize(content_textSize);
    }

    /******
     * 设置右边文本
     */
    public void setRightText() {
        if (BaseStringUtils.textIsEmpty(right_text) && BaseStringUtils.textIsEmpty(right_hintText) && right_image == -1)
            return;
        rightText.setVisibility(showRight?VISIBLE:GONE);
        if (!BaseStringUtils.textIsEmpty(right_text))
            rightText.setText(right_text);
        if (right_textColor != -1)
            rightText.setTextColor(right_textColor);
        if (!BaseStringUtils.textIsEmpty(right_hintText))
            rightText.setHint(right_hintText);
        if (right_hintColor != -1)
            rightText.setHintTextColor(right_hintColor);
        if (right_image != -1)
            ImageUtil.setCompoundDrawable(rightText, 15, right_image, Gravity.RIGHT, 0);
        rightText.setTextSize(right_textSize);
    }

    private void setLineParameter() {
        leftLine.setVisibility(show_leftLine ? VISIBLE : GONE);
        rightLine.setVisibility(show_rightLine ? VISIBLE : GONE);
        line.setVisibility(show_line ? VISIBLE : GONE);
        if (line_height != -1) {
            LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, (int) line_height);
            line.setLayoutParams(params);
        }
    }

    private void setOnInputListener() {
        if (!is_listener_input)
            return;
        contentEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (right_image != -1) {
                    if (BaseStringUtils.textIsEmpty(getContentText().trim())) {
                        rightText.setVisibility(GONE);
                    } else {
                        rightText.setVisibility(VISIBLE);
                    }
                }
                if (listener != null)
                    listener.inputChange(getId(),contentEdit.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        contentEdit.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (listener != null)
                    listener.cursorVanish(hasFocus);
            }
        });
    }

    public View getLeftView() {
        return leftText;
    }

    public View getContentView() {
        return contentEdit;
    }

    public View getRightView() {
        return rightText;
    }

    public String getLeftText() {
        return leftText.getText().toString();
    }

    public String getRightText() {
        return rightText.getText().toString();
    }

    public void setLeftText(String mesg) {
        this.left_text = mesg;
        leftText.setText(mesg);
    }

    public void setRightText(String mesg) {
        this.right_text = mesg;
        rightText.setText(mesg);
    }

    public String getContentText() {
        return contentEdit.getText().toString();
    }

    public void setInputType(int inputType) {
        contentEdit.setInputType(inputType);
    }

    public void setOnInputListener(CommonEditInPutListener listener) {
        this.listener = listener;
    }

    private CommonEditInPutListener listener;

    public interface CommonEditInPutListener {
        void inputChange(int viewId, String imput);

        void cursorVanish(boolean islose);
    }

    public void setRightOnClick(OnClickListener listener){
        if (listener==null)
            return;
        rightText.setOnClickListener(listener);
    }

    public void setRightClickable(boolean bool){
        rightText.setClickable(bool);
    }

    public void setRightEnabled(boolean bool){
        rightText.setEnabled(bool);
    }

}

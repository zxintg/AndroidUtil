package com.zxin.zxinlib.view.group;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zxin.zxinlib.R;
import com.zxin.zxinlib.util.SystemInfoUtil;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/1/28.
 * <p>
 * 自定义RadioGroup
 * <p>
 * 实现横向纵向多个子控件 单选，多选
 * <p>
 * 实现多样式选择
 * <p>
 * 实现自定义动态数据加载、静态String ，Array数据加载
 * <p>
 * 刘奎 2018/05/07
 */

public class MyRadioGroupView extends NestedScrollView implements View.OnClickListener{
    /****
     * 父控件
     */
    private View fatherView;

    /*****
     * 高度
     */
    private float groupPivotHeight;
    /*****
     * 横向间距
     */
    private float groupSpaceHor;
    /*****
     * 纵向间距
     */
    private float groupSpaceVer;
    /*****
     * 子元素样式
     */
    private int groupItemStyle;

    /****
     * 子元素选中样式
     */
    private int groupItemCheckedStyle;
    /*****
     * 子元素字体样式
     */
    private int groupItemTextColor;

    /*****
     * 子元素选中字体样式
     */
    private int groupItemTextCheckedColor;

    /*****
     * 子元素宽度
     */
    private float groupItemWidth;
    /*****
     * 子元素高度
     */
    private float groupItemHeight;
    /*****
     * 是否可选
     */
    private boolean groupIsChecked;
    /*****
     * 是否单选
     */
    private boolean groupSingleChecked;
    /*****
     * 横向个数
     */
    private int groupHorNum;
    /*****
     * 字体大小
     */
    private float groupTextSize;
    /*****
     * 子布局左偏移量
     */
    private float groupItemPaddingLeft;
    /*****
     * 子布局右偏移量
     */
    private float groupItemPaddingRight;
    /*****
     * 子布局上偏移量
     */
    private float groupItemPaddingTop;
    /*****
     * 子布局下偏移量
     */
    private float groupItemPaddingBottom;
    /*****
     * 子元素数据数组
     */
    //private String[] groupDatas;
    private CharSequence[] groupDatas;

    /****
     * group类型
     */
    private int groupType = 0;

    public MyRadioGroupView(Context context) {
        super(context);
    }

    public MyRadioGroupView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews();
        //获取属性值
        initDatas(context.obtainStyledAttributes(attrs, R.styleable.MyRadioGroupView));
        initFatherView();
        setDatas();
    }

    /****
     * 初始化数据
     */
    private void initViews() {
        removeAllViews();
        if (groupDatas!=null)
            groupDatas=null;
        if (lastCheckedView==null)
            lastCheckedView = new ArrayList<>();
    }

    /****
     * 初始化数据
     */
    private void initDatas(TypedArray typedArray) {
        groupPivotHeight = typedArray.getDimension(R.styleable.MyRadioGroupView_groupPivotHeight, 0);
        groupSpaceHor = typedArray.getDimension(R.styleable.MyRadioGroupView_groupSpaceHor, 0);
        groupSpaceVer = typedArray.getDimension(R.styleable.MyRadioGroupView_groupSpaceVer, 0);
        groupItemStyle = typedArray.getResourceId(R.styleable.MyRadioGroupView_groupItemStyle, -1);
        groupItemCheckedStyle = typedArray.getResourceId(R.styleable.MyRadioGroupView_groupItemCheckedStyle, -1);
        groupItemTextColor = typedArray.getColor(R.styleable.MyRadioGroupView_groupItemTextColor, -1);
        groupItemTextCheckedColor = typedArray.getColor(R.styleable.MyRadioGroupView_groupItemTextCheckedColor, -1);
        groupItemWidth = typedArray.getDimension(R.styleable.MyRadioGroupView_groupItemWidth, 0);
        groupItemHeight = typedArray.getDimension(R.styleable.MyRadioGroupView_groupItemHeight, 0);
        groupHorNum = typedArray.getInteger(R.styleable.MyRadioGroupView_groupHorNum, 0);
        groupIsChecked = typedArray.getBoolean(R.styleable.MyRadioGroupView_groupIsChecked,true);
        groupSingleChecked = typedArray.getBoolean(R.styleable.MyRadioGroupView_groupSingleChecked,true);
        groupTextSize = typedArray.getDimension(R.styleable.MyRadioGroupView_groupTextSize, 22);
        groupItemPaddingLeft = typedArray.getDimension(R.styleable.MyRadioGroupView_groupItemPaddingLeft, 0);
        groupItemPaddingRight = typedArray.getDimension(R.styleable.MyRadioGroupView_groupItemPaddingRight, 0);
        groupItemPaddingTop = typedArray.getDimension(R.styleable.MyRadioGroupView_groupItemPaddingTop, 0);
        groupItemPaddingBottom = typedArray.getDimension(R.styleable.MyRadioGroupView_groupItemPaddingBottom, 0);

        groupType = typedArray.getInt(R.styleable.MyRadioGroupView_groupType, 0);
        //groupDatas = UiUtils.getStringArray(typedArray.getInt(R.styleable.MyRadioGroupView_groupDatas, 0));
        groupDatas = typedArray.getTextArray(R.styleable.MyRadioGroupView_groupDatas);

        typedArray.recycle();
    }

    /*****
     * 初始化父元素
     */
    private void initFatherView() {
        /*ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,groupPivotHeight==0?ViewGroup.LayoutParams.MATCH_PARENT: SystemInfoUtil.dip2px(groupPivotHeight));
        setLayoutParams(params);*/

        switch (groupType){
            case 0://无
            case 2://水平的
                LinearLayout linHor = new LinearLayout(getContext());
                NestedScrollView.LayoutParams paramsHor = new NestedScrollView.LayoutParams(NestedScrollView.LayoutParams.MATCH_PARENT,NestedScrollView.LayoutParams.WRAP_CONTENT);
                linHor.setLayoutParams(paramsHor);
                linHor.setOrientation(LinearLayout.HORIZONTAL);
                linHor.setPadding(SystemInfoUtil.dip2px(groupSpaceVer/2),SystemInfoUtil.dip2px(groupSpaceHor/2),SystemInfoUtil.dip2px(groupSpaceVer/2),SystemInfoUtil.dip2px(groupSpaceHor/2));
                fatherView = linHor;
                break;

            case 1://竖直的
                LinearLayout linVer = new LinearLayout(getContext());
                LayoutParams paramsVer = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
                linVer.setLayoutParams(paramsVer);
                linVer.setOrientation(LinearLayout.VERTICAL);
                linVer.setPadding(SystemInfoUtil.dip2px(groupSpaceVer/2),SystemInfoUtil.dip2px(groupSpaceHor/2),SystemInfoUtil.dip2px(groupSpaceVer/2),SystemInfoUtil.dip2px(groupSpaceHor/2));
                fatherView = linVer;
                break;

            case 3://网格的
                RelativeLayout grid = new RelativeLayout(getContext());
                NestedScrollView.LayoutParams paramsGrid = new NestedScrollView.LayoutParams(NestedScrollView.LayoutParams.MATCH_PARENT,NestedScrollView.LayoutParams.WRAP_CONTENT);
                grid.setLayoutParams(paramsGrid);
                grid.setPadding(SystemInfoUtil.dip2px(groupSpaceVer/2),SystemInfoUtil.dip2px(groupSpaceHor/2),SystemInfoUtil.dip2px(groupSpaceVer/2),SystemInfoUtil.dip2px(groupSpaceHor/2));
                fatherView = grid;
                break;
        }
        addView(fatherView);
    }

    /****
     * 绑定数据
     */
    private void setDatas(){
        if(fatherView==null)
            return;
        if (groupDatas==null||groupDatas.length==0)
            return;
        int len = groupDatas.length;
        if(fatherView instanceof RelativeLayout){
            RelativeLayout rePat = (RelativeLayout)fatherView;
            rePat.removeAllViews();
            int width = groupItemWidth==0?(SystemInfoUtil.getScreenWidth()- SystemInfoUtil.dip2px(groupSpaceHor*(groupHorNum)))/groupHorNum:SystemInfoUtil.dip2px(groupItemWidth);
            for(int i=0;i<(len%groupHorNum==0?len/groupHorNum:(len/groupHorNum)+1);i++){
                for(int j=0;j<groupHorNum;j++){
                    if(i*groupHorNum+j>=groupDatas.length)
                        break;
                    TextView childView = new TextView(getContext());
                    childView.setTextSize(groupTextSize);
                    RelativeLayout.LayoutParams reParams = new RelativeLayout.LayoutParams(width,groupItemHeight==0? RelativeLayout.LayoutParams.WRAP_CONTENT:SystemInfoUtil.dip2px(groupItemHeight));
                    reParams.setMargins(SystemInfoUtil.dip2px(groupSpaceHor/2*(j+1))+width*j,SystemInfoUtil.dip2px(groupSpaceVer/2*(i+1)+groupItemHeight*i),SystemInfoUtil.dip2px(groupSpaceHor/2),SystemInfoUtil.dip2px(groupSpaceVer/2));
                    Log.d("MyRadioGroupView","宽度："+width+"第"+(i*groupHorNum+j)+"个："+SystemInfoUtil.dip2px(groupSpaceHor/2*(j+1)+width*j));
                    childView.setGravity(Gravity.CENTER);
                    childView.setText(groupDatas[i*groupHorNum+j]);
                    childView.setSingleLine();
                    childView.setPadding(SystemInfoUtil.dip2px(groupItemPaddingLeft),SystemInfoUtil.dip2px(groupItemPaddingTop),SystemInfoUtil.dip2px(groupItemPaddingRight),SystemInfoUtil.dip2px(groupItemPaddingBottom));
                    childView.setTextColor(groupItemTextColor);
                    childView.setBackgroundResource(groupItemStyle);
                    rePat.addView(childView,i*groupHorNum+j,reParams);
                    childView.setTag(i*groupHorNum+j);
                    if(!groupIsChecked)
                        continue;
                    childView.setOnClickListener(this);
                }
            }
        }
    }

    private List<TextView> lastCheckedView;
    @Override
    public void onClick(View v) {
        if (listener==null||!groupIsChecked)
            return;
        TextView textView = (TextView) v;

        if(groupSingleChecked){
            //单选
            if (lastCheckedView!=null&&!lastCheckedView.isEmpty()){
                lastCheckedView.get(0).setBackgroundResource(groupItemStyle);
                lastCheckedView.get(0).setTextColor(groupItemTextColor);
                lastCheckedView.clear();
            }
            textView.setBackgroundResource(groupItemCheckedStyle);
            textView.setTextColor(groupItemTextCheckedColor);
            if (!lastCheckedView.contains(textView)) {
                lastCheckedView.add(textView);
            }
            listener.onCheckedChanged(v, true, groupDatas[(int) v.getTag()].toString());
        }else{
            //多选
            if (lastCheckedView!=null&&!lastCheckedView.isEmpty()&&lastCheckedView.contains(textView)){
                textView.setBackgroundResource(groupItemStyle);
                textView.setTextColor(groupItemTextColor);
                lastCheckedView.remove(textView);
                listener.onCheckedChanged(v,false,groupDatas[(int)v.getTag()].toString());
            }else{
                textView.setBackgroundResource(groupItemCheckedStyle);
                textView.setTextColor(groupItemTextCheckedColor);
                lastCheckedView.add(textView);
                listener.onCheckedChanged(v,true,groupDatas[(int)v.getTag()].toString());
            }
        }
    }

    private OnCheckedChangeListener listener;
    public void setOnCheckedChangeListener(OnCheckedChangeListener listener){
        this.listener = listener;
    }

    public interface OnCheckedChangeListener{
        void onCheckedChanged(View v,boolean isChecked,String mesg);

    }

    public String[] getCheckedDatas(){
        if (lastCheckedView==null||lastCheckedView.isEmpty())
            return null;
        String[] strs = new String[lastCheckedView.size()];
        for (int i=0;i<lastCheckedView.size();i++){
            strs[i] = lastCheckedView.get(i).getText().toString();
        }
        return strs;
    }

}

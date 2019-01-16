package com.zxin.zxinlib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zxin.zxinlib.R;
import com.zxin.zxinlib.util.AppManager;
import com.zxin.zxinlib.util.IntegerUtil;
import com.zxin.zxinlib.util.BaseStringUtils;
import com.zxin.zxinlib.util.SystemInfoUtil;

import org.greenrobot.eventbus.EventBus;
import java.util.List;

/**
 * Created by liukui on 2015/6/17.
 */
public class DropDownMenu extends RelativeLayout implements View.OnClickListener{
    //顶部菜单布局
    private LinearLayout tabLayout;
    //区域外
    private View outlay;
    //弹出菜单父布局
    private FrameLayout popupFrame;
    //tab选中颜色
    private int textSelectedColor = 0xff890c85;
    //tab未选中颜色
    private int textUnselectedColor = 0xff111111;
    //标题背景颜色
    private int menuTableColor;
    //遮罩颜色
    private int maskColor = 0x88888888;
    //tab选中图标
    private int menuSelectedIcon;
    //tab未选中图标
    private int menuUnselectedIcon;
    //标题高度
    private int menuTitleHeight;

    public DropDownMenu(Context context) {
        super(context, null);
    }

    public DropDownMenu(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DropDownMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.fragmnet_container_layout, this, true);
        tabLayout = (LinearLayout) findViewById(R.id.popup_container_table);
        popupFrame = (FrameLayout) findViewById(R.id.popup_container_content);
        outlay = findViewById(R.id.popup_container_outlay);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.DropDownMenu);
        textSelectedColor = a.getColor(R.styleable.DropDownMenu_ddtextSelectedColor, textSelectedColor);
        textUnselectedColor = a.getColor(R.styleable.DropDownMenu_ddtextUnselectedColor, textUnselectedColor);
        menuTableColor = a.getColor(R.styleable.DropDownMenu_ddmenuTableColor,  Color.WHITE);
        maskColor = a.getColor(R.styleable.DropDownMenu_ddmaskColor, maskColor);
        menuSelectedIcon = a.getResourceId(R.styleable.DropDownMenu_ddmenuSelectedIcon, menuSelectedIcon);
        menuUnselectedIcon = a.getResourceId(R.styleable.DropDownMenu_ddmenuUnselectedIcon, menuUnselectedIcon);
        menuTitleHeight = a.getDimensionPixelSize(R.styleable.DropDownMenu_ddmenuTitleHeight, 30);

        a.recycle();

        outlay.setBackgroundColor(maskColor);
        //初始化tabMenuView并添加到tabMenuView
        tabLayout.setBackgroundColor(menuTableColor);
        tabLayout.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,SystemInfoUtil.dpTpPx(menuTitleHeight)));
        outlay.setOnClickListener(this);
    }

    public void setItwmWeight(float[] weight){
        this.weightArr = new float[weight.length];
        int countWeight = 0;
        for(int i=0;i<weight.length;i++){
            countWeight += weight[i];
        }

        for(int i=0;i<weight.length;i++){
            this.weightArr[i] = weight[i]/countWeight;
        }
    }
    //布局权重数组
    private float[] weightArr;
    //private List<Fragment> popupFragment;
    public void setDropDownFragment(@NonNull List<String> tabTexts,@NonNull List<Fragment> popupFragment) {
        if (tabTexts.size() != popupFragment.size()) {
            throw new IllegalArgumentException("params not match, tabTexts.size() should be equal popupViews.size()");
        }
        outlay.setVisibility(GONE);
        popupFrame.setVisibility(GONE);
        for (int i = 0; i < tabTexts.size(); i++) {
            float weight = 1.0f / tabTexts.size();
            if(weightArr!=null&&weightArr.length>0){
                weight = weightArr[i];
            }
            int mWeight = (int)(SystemInfoUtil.getScreenWidth()*weight);
            addFragmentTab(tabTexts, popupFragment.get(i),i,i<tabTexts.size()-1,mWeight);
        }
    }

    private View selectView = null;
    private void addFragmentTab(@NonNull List<String> tabTexts, final Fragment fragment, final int index, boolean isShowLine, int weight) {
        LinearLayout ll = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.item_container_layout, null, false);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(weight,SystemInfoUtil.dpTpPx(menuTitleHeight));
        ll.setLayoutParams(params);
        TextView title = (TextView) ll.findViewById(R.id.item_cantainer_title);
        ImageView arrow = (ImageView) ll.findViewById(R.id.item_cantainer_arrow);
        View line = ll.findViewById(R.id.item_cantainer_line);
        title.setText(tabTexts.get(index));
        arrow.setImageResource(menuUnselectedIcon);
        //添加点击事件
        ll.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                selectView = v;
                selectFragment(fragment);
                setShowFragment();
            }
        });
        tabLayout.addView(ll);
        if(isShowLine){
            line.setVisibility(View.VISIBLE);
        }else{
            line.setVisibility(View.GONE);
        }
    }

    private void selectFragment(Fragment fragment){
        //ft.replace(R.id.content, fragment).commit();
        FragmentTransaction ft = manage.requestFragmentManage();
        ft.replace(R.id.popup_container_content, fragment);
        ft.addToBackStack(null);
        ft.commitAllowingStateLoss();
    }
    private View lastView = null;
    private void setShowFragment() {
        if(lastView!=null){
            //关闭上次打开的
            TextView title = (TextView) lastView.findViewById(R.id.item_cantainer_title);
            ImageView arrow = (ImageView) lastView.findViewById(R.id.item_cantainer_arrow);
            title.setTextColor(textUnselectedColor);
            arrow.setImageResource(menuUnselectedIcon);
        }

        if (selectView !=null&&lastView!=selectView) {
            popupFrame.setVisibility(View.VISIBLE);
            outlay.setVisibility(View.VISIBLE);
            mainOvlayStatus(true);
            //outlay.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.dd_mask_in));
            //popupFrame.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.dd_menu_in));
        } else {
            outlay.setVisibility(View.GONE);
            popupFrame.setVisibility(View.GONE);
            selectView = null;
            lastView = null;
            mainOvlayStatus(false);
            return;
        }
        TextView title = (TextView) selectView.findViewById(R.id.item_cantainer_title);
        ImageView arrow = (ImageView) selectView.findViewById(R.id.item_cantainer_arrow);
        title.setTextColor(textSelectedColor);
        arrow.setImageResource(menuSelectedIcon);
        lastView = selectView;
    }

    /**
     * 改变当前tab文字
     * @param text
     */
    public void setTabText(String text) {
        if(selectView==null){
            return;
        }
        TextView title = (TextView) selectView.findViewById(R.id.item_cantainer_title);
        title.setText(text);
    }

    /**
     * 关闭菜单
     */
    public void closeMenu() {
        if(selectView==null){
            return;
        }
        TextView title = (TextView) selectView.findViewById(R.id.item_cantainer_title);
        ImageView arrow = (ImageView) selectView.findViewById(R.id.item_cantainer_arrow);
        title.setTextColor(textUnselectedColor);
        arrow.setImageResource(menuUnselectedIcon);
        outlay.setVisibility(View.GONE);
        popupFrame.setVisibility(View.GONE);
        //outlay.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.dd_mask_out));
        //popupFrame.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.dd_menu_out));
        selectView = null;
        lastView = null;
        mainOvlayStatus(false);
    }

    /**
     * DropDownMenu是否处于可见状态
     *
     * @return
     */
    public boolean isShowing() {
        return selectView != null;
    }

    public void setRequestFragmentManage(DropMenuFragmentManage manage){
        this.manage = manage;
    }
    private DropMenuFragmentManage manage;

    @Override
    public void onClick(View v) {
        closeMenu();
    }

    public interface DropMenuFragmentManage{
        FragmentTransaction requestFragmentManage();
    }

    /****
     * 通知首页关闭、显示遮罩层
     * @param isOpen
     */
    private void mainOvlayStatus(boolean isOpen){
        if(AppManager.getAppManager().currentActivity().getClass().getName().equals("com.zxin.activity.MainActivity")){
            Bundle bundle = new Bundle();
            bundle.putInt(BaseStringUtils.EVENT_ID, isOpen ? IntegerUtil.CONDITION_POPUP_OPEN : IntegerUtil.CONDITION_POPUP_ClOSE);
            EventBus.getDefault().post(bundle);
        }
    }

}

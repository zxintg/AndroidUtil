package com.zxin.zxinlib.view.dialog;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zxin.zxinlib.R;
import com.zxin.zxinlib.util.SystemInfoUtil;
import com.zxin.zxinlib.util.UiUtils;

public class NiceDialog extends BaseNiceDialog {
    private ViewConvertListener convertListener;

    public static NiceDialog init() {
        return new NiceDialog();
    }

    @Override
    public int intLayoutId() {
        return layoutId;
    }

    @Override
    public void convertView(NiceDialogViewHolder holder, BaseNiceDialog dialog) {
        if (convertListener != null) {
            convertListener.convertView(holder, dialog);
        }
        if(itemList==null||this.layoutId != R.layout.select_common)
            return;
        LinearLayout childView = holder.getView(R.id.select_common_layout);
        childView.removeAllViews();
        int padding = SystemInfoUtil.dip2px(15);
        int line = SystemInfoUtil.dip2px(150);
        for (int i=0;i<itemList.length;i++){
            TextView textView = new TextView(childView.getContext());
            textView.setPadding(padding,padding,padding,padding);
            textView.setLayoutParams(new LinearLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT));
            textView.setGravity(Gravity.CENTER);
            textView.setTextColor(UiUtils.getColor(R.color.color_333333));
            textView.setTextSize(16);
            textView.setText(itemList[i]);
            textView.setHint(String.valueOf(i));
            childView.addView(textView);
            if(i!=itemList.length-1){
                View view = new View(childView.getContext());
                view.setLayoutParams(new LinearLayout.LayoutParams(line,2));
                view.setBackgroundColor(UiUtils.getColor(R.color.line_color));
                childView.addView(view);
            }
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                    if(listener==null)
                        return;
                    TextView itemText =  (TextView)v;
                    listener.onItemListener(Integer.parseInt(itemText.getHint().toString()),itemText.getText().toString());
                }
            });
        }
        holder.setOnClickListener(R.id.tv_select_cancel, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        holder.setVisibility(R.id.tv_select_cancel,isShowShowCancelBtn);
    }

    public NiceDialog setLayoutId(@LayoutRes int layoutId) {
        this.layoutId = layoutId;
        return this;
    }

    private boolean isShowShowCancelBtn = true;
    public void setShowCancelBtn(boolean isShowShowCancelBtn){
        this.isShowShowCancelBtn = isShowShowCancelBtn;
        setWidth(SystemInfoUtil.getScreenWidth()*2/3);
    }

    private String[] itemList;
    public void setCommonLayout(String[] itemList,boolean isBottom){
        this.itemList = itemList;
        this.layoutId = R.layout.select_common;
        setDimAmount(0.3f);
        setShowBottom(isBottom);
        show();
    }

    public NiceDialog setConvertListener(ViewConvertListener convertListener) {
        this.convertListener = convertListener;
        return this;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            convertListener = savedInstanceState.getParcelable("listener");
        }
    }

    /**
     * 保存接口
     *
     * @param outState
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("listener", convertListener);
    }

    public NiceDialog setHeight(int height){
        super.setHeight(height);
        return this;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        convertListener = null;
    }

    private NiceDialogListener listener;

    public void setOnNiceDialogListener(NiceDialogListener listener){
        this.listener = listener;
    }

    public interface NiceDialogListener{
        void onItemListener(int index, String item);
    }
}

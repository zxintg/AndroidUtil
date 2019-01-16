package com.zxin.zxinlib.view.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.zxin.zxinlib.R;
import com.zxin.zxinlib.app.BaseApplication;
import com.zxin.zxinlib.util.BaseStringUtils;
import com.zxin.zxinlib.util.UiUtils;

/**
 * 提示对话框
 *
 * liukui 2017/11/23 10:05
 *
 */

public class ConfirmDialog extends BaseNiceDialog {

    private  String title,message,leftBtn,rightBtn;
    private int gravity = Gravity.CENTER;

    /****
     * 初始化
     * @param title 标题
     * @param message 信息
     * @param leftBtn 左边按钮
     * @param rightBtn 右边按钮
     * @return 实体
     */
    public static ConfirmDialog newInstance(String title,String message,String leftBtn,String rightBtn) {
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putString("message", message);
        bundle.putString("leftBtn", leftBtn);
        bundle.putString("rightBtn", rightBtn);
        ConfirmDialog dialog = new ConfirmDialog();
        dialog.setArguments(bundle);
        return dialog;
    }

    public void setMessageGravity(int gravity){
        this.gravity = gravity;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle == null) {
            return;
        }
        title = bundle.getString("title");
        message = bundle.getString("message");
        leftBtn = bundle.getString("leftBtn");
        rightBtn = bundle.getString("rightBtn");
    }

    @Override
    public int intLayoutId() {
        return R.layout.confirm_layout;
    }

    @Override
    public void convertView(NiceDialogViewHolder holder, final BaseNiceDialog dialog) {
        holder.setText(R.id.title, title);
        TextView message = holder.getView(R.id.message);
        //message.setText(BaseStringUtils.textFormatHtml(this.message.replace("\\r","")));
        message.setText(BaseStringUtils.textFormatHtml(this.message));
        message.setGravity(gravity);
        holder.setText(R.id.cancel, leftBtn);
        holder.setText(R.id.ok, rightBtn);
        message.setMovementMethod(ScrollingMovementMethod.getInstance());
        holder.setTextColor(R.id.ok, UiUtils.getColor(R.color.color_ffae12));
        holder.setVisibility(R.id.title,!TextUtils.isEmpty(title));
        holder.setVisibility(R.id.message,!TextUtils.isEmpty(this.message));
        holder.setVisibility(R.id.cancel,!TextUtils.isEmpty(leftBtn));
        holder.setVisibility(R.id.ok,!TextUtils.isEmpty(rightBtn));
        holder.setVisibility(R.id.line,!TextUtils.isEmpty(leftBtn)&&!TextUtils.isEmpty(rightBtn));
        holder.setOnClickListener(R.id.cancel, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                if(listener!=null)
                    listener.dialogStatusNo();
            }
        });

        holder.setOnClickListener(R.id.ok, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                if(listener!=null)
                    listener.dialogStatusYes();
            }
        });
    }

    private  ConfirmDialogListener listener;

    public void  setConfirmDialogListener(ConfirmDialogListener listener){
        this.listener = listener;
    }

    public interface ConfirmDialogListener{
        public void dialogStatusYes();
        public void dialogStatusNo();
    }

}

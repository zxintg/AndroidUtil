package com.zxin.zxinlib.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zxin.zxinlib.R;

/**
 * Created by 进度条 on 2017/12/29.
 */
public class ProgressBarDialog extends Dialog implements View.OnClickListener{
    private LinearLayout mDialogLay,mBottomLayout;
    private ImageView mArovane;
    private TextView mTitle,mContent,mCancel,mSubmit;
    private View mLine;
    private AnimationDrawable animator;
    private String title = "",content = "",leftBtn = "",rightBtn = "";

    public ProgressBarDialog(@NonNull Context context) {
        this(context,"","","","");
    }

    public ProgressBarDialog(@NonNull Context context,String title,String content,String leftBtn,String rightBtn) {
        super(context, R.style.dialog);
        this.title = title;
        this.content = content;
        this.leftBtn = leftBtn;
        this.rightBtn = rightBtn;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_watting);
        setCanceledOnTouchOutside(false);
        initView();
        setTitle(title);
        setContent(content);
        setmBottomLayout(leftBtn,rightBtn);
    }

    /****
     * 初始化数据
     */
    private void initView(){
        mArovane = (ImageView) findViewById(R.id.iv_refresh_arovane);
        mDialogLay = (LinearLayout) findViewById(R.id.show_operator_dialoglay);
        mBottomLayout = (LinearLayout) findViewById(R.id.loading_bottom);
        mTitle = (TextView) findViewById(R.id.dialog_title);
        mContent = (TextView) findViewById(R.id.dialog_content);
        mCancel = (TextView) findViewById(R.id.loading_cancel);
        mLine = findViewById(R.id.loading_line);
        mSubmit = (TextView) findViewById(R.id.loading_submit);

        /*if(null == animator){
            animator = ObjectAnimator.ofFloat(mArovane,"rotation",360);
            animator.setDuration(500);
            animator.setRepeatCount(ValueAnimator.INFINITE);
            animator.setRepeatMode(ValueAnimator.RESTART);
            animator.setInterpolator(new LinearInterpolator());
        }*/
        mArovane.setImageResource(R.drawable.loading_anim);
        animator = (AnimationDrawable) mArovane.getDrawable();
        mCancel.setOnClickListener(this);
        mSubmit.setOnClickListener(this);
        if(!animator.isRunning()){
            animator.start();
        }
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.loading_cancel) {
            if (listener != null) {
                listener.onCancel();
            }
            this.dismiss();
        } else if (i == R.id.loading_submit) {
            if (listener != null) {
                listener.onSubmit();
            }
            this.dismiss();
        }
    }

    /*****
     * 设置标题
     * @param title
     */
    private void setTitle(String title){
        if(!TextUtils.isEmpty(title)&&!title.equals("null"))
            return;
        mTitle.setText(title);
    }

    /****
     * 设置内容
     * @param content
     */
    private void setContent(String content){
        if(!TextUtils.isEmpty(content)&&!content.equals("null"))
            return;
        mContent.setText(content);
    }

    /****
     * 设置底部布局
     * @param leftButton
     * @param rightButton
     */
    private void setmBottomLayout(String leftButton,String rightButton){
        boolean leftBool = TextUtils.isEmpty(leftButton)|| leftButton.equals("null");
        boolean rightBool = TextUtils.isEmpty(rightButton)|| rightButton.equals("null");
        if (leftBool && rightBool) {
            this.mArovane.setVisibility(View.VISIBLE);
            this.mDialogLay.setVisibility(View.GONE);
        }else{
            this.mArovane.setVisibility(View.GONE);
            this.mDialogLay.setVisibility(View.VISIBLE);
        }

        if(!leftBool && !rightBool){
            mLine.setVisibility(View.VISIBLE);
        }else{
            mLine.setVisibility(View.GONE);
        }

        if(!leftBool){
            this.mCancel.setVisibility(View.VISIBLE);
            this.mBottomLayout.setVisibility(View.VISIBLE);
        }
        if(!rightBool){
            this.mSubmit.setVisibility(View.VISIBLE);
            this.mBottomLayout.setVisibility(View.VISIBLE);
        }
    }

    /****
     * 展示
     */
    public void showProgress(){
        if(animator!=null&&!animator.isRunning()){
            animator.start();
        }
        if(isShowing())
            return;
        this.show();
    }

    /****
     * 取消
     */
   public void closeProgress(){
       if(null != animator && animator.isRunning()){
           this.dismiss();
       }
   }

   private OnCloseListener listener;

    public void setOnCloseListener(OnCloseListener listener){
        this.listener = listener;
    }

    public interface OnCloseListener{
        void onCancel();
        void onSubmit();
    }

}

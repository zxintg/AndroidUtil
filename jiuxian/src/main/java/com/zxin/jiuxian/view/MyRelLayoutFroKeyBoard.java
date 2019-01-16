package com.zxin.jiuxian.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by Administrator on 2018/8/6.
 */

public class MyRelLayoutFroKeyBoard extends RelativeLayout {
    private SizeChangedListener listener;

    public MyRelLayoutFroKeyBoard(Context paramContext) {
        super(paramContext);
    }

    public MyRelLayoutFroKeyBoard(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public MyRelLayoutFroKeyBoard(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
        paramInt1 = paramInt4 - paramInt2;
        if (paramInt1 > 0) {
            if (this.listener != null) {
                this.listener.sizeChanged(true, paramInt1);
            }
        } else if ((paramInt1 < 0) && (this.listener != null)) {
            this.listener.sizeChanged(false, paramInt1);
        }
    }

    public void setKeyBoardShowHideListener(SizeChangedListener parama) {
        this.listener = parama;
    }

    public static abstract interface SizeChangedListener {
        public abstract void sizeChanged(boolean paramBoolean, int paramInt);
    }
}


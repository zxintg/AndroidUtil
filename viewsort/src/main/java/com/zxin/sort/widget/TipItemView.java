/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zxin.sort.widget;

import android.content.ClipData;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zxin.sort.R;
import com.zxin.sort.Tip;
import com.zxin.sort.adapter.AbsTipAdapter;
import com.zxin.sort.SimpleTitleTip;


/**
 * A TileView displays a picture and name
 */
public class TipItemView extends RelativeLayout{
    private Tip mIDragEntity;
    private TextView title;
    private ImageView delete;

    public TipItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        title =(TextView)findViewById(R.id.tagview_title);
        delete =(ImageView)findViewById(R.id.tagview_delete);
        delete.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //编辑模式下回调点击item事件
                listener.onTileSelected(mIDragEntity,TipItemView.this);
            }
        });
        setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (listener!=null)
                    //开启编辑模式
                    listener.onLongClick(mIDragEntity,TipItemView.this);
                return true;
            }
        });
    }

    public Tip getDragEntity() {
        return mIDragEntity;
    }

    public void renderData(Tip entity) {
        mIDragEntity = entity;
        if (entity != null && entity != AbsTipAdapter.BLANK_ENTRY) {
            if(entity instanceof SimpleTitleTip) {
                title.setText(((SimpleTitleTip) mIDragEntity).getTip());
            }
            setVisibility(VISIBLE);
        } else {
            setVisibility(GONE);
        }
    }

    public void setItemListener(OnTipOnListener listener) {
        this.listener = listener;
    }

    private OnTipOnListener listener;

    public interface OnTipOnListener {
        void onTileSelected(Tip entity, View view);
        void onLongClick(Tip entity, View view);
    }

    public void showDeleteImg(boolean isShow){
        delete.setVisibility(isShow?VISIBLE:GONE);
    }
}

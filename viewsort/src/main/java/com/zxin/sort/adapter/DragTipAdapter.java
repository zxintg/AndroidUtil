package com.zxin.sort.adapter;

import android.content.ClipData;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.zxin.sort.R;
import com.zxin.sort.Tip;
import com.zxin.sort.widget.DragDropGirdView;
import com.zxin.sort.widget.TipItemView;

import java.util.ArrayList;

/**
 * Created by Wenhuaijun on 2016/5/26 0026.
 */
public class DragTipAdapter extends AbsTipAdapter{
    private boolean isEditing =false;
    private static final ClipData EMPTY_CLIP_DATA = ClipData.newPlainText("", "");
    private TipItemView.OnTipOnListener mListener;
    public DragTipAdapter(Context context, DragDropListener dragDropListener, TipItemView.OnTipOnListener deleteClickListener) {
        super(context, dragDropListener);
        this.mListener =deleteClickListener;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TipItemView view;
        if(convertView!=null&&convertView instanceof TipItemView){
            view =(TipItemView)convertView;
        }else{
            view = (TipItemView)View.inflate(mContext, R.layout.view_tag_item, null);
        }
        view.showDeleteImg(isEditing);
        //设置点击监听
        view.setItemListener(mListener);
        //绑定数据
        view.renderData(getItem(position));
        return view;
    }

    @Override
    protected Tip getDragEntity(View view) {
        return ((TipItemView)view).getDragEntity();
    }

    public void refreshData(){
        notifyDataSetChanged();
        mDragDropListener.onDataSetChangedForResult(tips);
    }
    public ArrayList<Tip> getData(){
        return tips;
    }

    public boolean isEditing() {
        return isEditing;
    }

    public void cancelEditingStatus(){
        isEditing =false;
        notifyDataSetChanged();
    }

    public  void startEdittingStatus(View v){
        if(!isEditing){
            isEditing =true;
            notifyDataSetChanged();
        }
        v.startDrag(EMPTY_CLIP_DATA, new View.DragShadowBuilder(),DragDropGirdView.DRAG_FAVORITE_TILE, 0);
    }
}

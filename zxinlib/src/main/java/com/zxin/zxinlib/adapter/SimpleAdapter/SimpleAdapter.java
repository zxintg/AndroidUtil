package com.zxin.zxinlib.adapter.SimpleAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2016/9/27.
 */
public abstract class SimpleAdapter<T> extends MultiTypeAdapter {
    protected int mLayoutId;
    protected Context mContext;

    public SimpleAdapter(Context context,List<T> datas, int layoutId) {
        super(context,datas);
        this.mLayoutId = layoutId;
        this.mContext=context;
    }

    @Override
    public TrdViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //  return super.onCreateViewHolder(parent,viewType);
        View   mView = LayoutInflater.from(mContext).inflate(mLayoutId, parent, false);
        TrdViewHolder mViewHolder=new TrdViewHolder(mContext,mView,parent);
        return mViewHolder;
    }


    @Override
    protected int getLayoutIdByType(int viewType) {
       // View inflate =layoutInflater.inflate(mLayoutId, parent, false)
        return mLayoutId;
    }

    @Override
    public int getItemViewType(int position) {
      //  Log.e("e","getItemViewType = " +position);
        return position;
    }

    @Override
    protected void onBindViewHolder(TrdViewHolder holder, int type, Object data) {
        onBindViewHolder(holder, (T)data);
    }

    /**子类需实现以下方法*/

    protected abstract void onBindViewHolder(TrdViewHolder holder, T data);


}

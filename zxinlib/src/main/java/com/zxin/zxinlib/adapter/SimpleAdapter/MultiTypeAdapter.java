package com.zxin.zxinlib.adapter.SimpleAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2016/9/27.
 */
public abstract class MultiTypeAdapter extends RecyclerView.Adapter<TrdViewHolder> {

    protected String TAG;
    protected Context mContext;
    protected List mDatas;

    public MultiTypeAdapter(Context mContext, List mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        this.TAG = getClass().getSimpleName();
    }

    @Override
    public TrdViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutId = getLayoutIdByType(viewType);
        return TrdViewHolder.get(mContext,parent,layoutId);
    }

    @Override
    public void onBindViewHolder(TrdViewHolder holder, int position) {
        onBindViewHolder(holder,getItemViewType(position),mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        if (mDatas==null)
            return 0;
        return mDatas.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    /**子类需实现以下三个方法*/

    protected abstract int getLayoutIdByType(int viewType);

    @Override
    public abstract int getItemViewType(int position);

    protected abstract void onBindViewHolder(TrdViewHolder holder, int type, Object data);

}

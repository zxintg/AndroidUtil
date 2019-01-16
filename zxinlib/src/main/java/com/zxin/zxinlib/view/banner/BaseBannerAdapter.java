package com.zxin.zxinlib.view.banner;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 * <p/>
 * Created by rowandjj(chuyi)<br/>
 * Date: 16/1/6<br/>
 * Time: 下午4:59<br/>
 */
@SuppressWarnings("unused")
public abstract class BaseBannerAdapter<T> {
    private List<T> mDatas;
    private OnDataChangedListener mOnDataChangedListener;
    public Context mContext;

    public BaseBannerAdapter(Context mContext,List<T> datas) {
        this.mContext = mContext;
        mDatas = datas;
        if (datas == null || datas.isEmpty()) {
            throw new RuntimeException("nothing to show");
        }
    }

    public BaseBannerAdapter(T[] datas) {
        mDatas = new ArrayList<>(Arrays.asList(datas));
    }

    void setOnDataChangedListener(OnDataChangedListener listener) {
        mOnDataChangedListener = listener;
    }

    public List<T> getDatas() {
        return mDatas;
    }

    public int getCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    public void notifyDataChanged() {
        mOnDataChangedListener.onChanged();
    }

    public T getItem(int position) {
        return mDatas.get(position);
    }

    public List<T> getItemList(int itemNum, int position){
        int star = position*itemNum;
        List<T> list = new ArrayList<>();
        if (star+itemNum>getCount()) {
            list.addAll(mDatas.subList(star,getCount()));
            int sub = star+itemNum-getCount();
            list.addAll(mDatas.subList(0,sub));
            mOnDataChangedListener.restartPosition();
        }else
            list.addAll(mDatas.subList(star,star+itemNum));
        return list;
    }

    /**
     * 设置banner的样式
     */
    public abstract View getView(VerticalBannerView parent);

    /**
     * 设置banner的数据
     */
    public abstract void setItem(View view, T data);

    public abstract void setItem(View view,List<T> itemList);


    interface OnDataChangedListener {
        void onChanged();
        void restartPosition();
    }

    public OnBannerClickListener listener;

    public void setOnBannerClickListener(OnBannerClickListener listener){
        this.listener = listener;
    }

    public interface OnBannerClickListener{
        void onItemClick(int position);
    }

}

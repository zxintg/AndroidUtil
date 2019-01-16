package com.common.camera.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.common.camera.R;
import com.common.camera.model.ImageFloder;
import com.zxin.zxinlib.adapter.SimpleAdapter.SimpleAdapter;
import com.zxin.zxinlib.adapter.SimpleAdapter.TrdViewHolder;
import com.zxin.zxinlib.util.ImageUtil;
import com.zxin.zxinlib.util.SystemInfoUtil;

import java.util.List;

/**
 * Created by Administrator on 2018/1/30.
 */

public class ListImageDirPopupWindow extends PopupWindow {
    RecyclerView mRecyclerView;
    private int margHeight = 0;

    public ListImageDirPopupWindow(Context context, List<ImageFloder> mImageFloders,int measuredHeight) {
        margHeight = measuredHeight;
        View conentView = LayoutInflater.from(context).inflate(R.layout.popup_recycle_notitle, null);
        mRecyclerView = (RecyclerView) conentView.findViewById(R.id.rv_recycle_review);
        setContentView(conentView);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));//设置垂直
        mRecyclerView.setAdapter(new SimpleAdapter<ImageFloder>(context, mImageFloders, R.layout.item_alnum_file) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final ImageFloder data) {
                holder.setText(R.id.iv_album_title, data.getName())
                        .setText(R.id.iv_album_num,"共 "+data.getCount()+" 张")
                        .setOnItemListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (data instanceof ImageFloder) {
                                    ImageFloder imageFloder = data;
                                    onImageDirSelected.albumSelected(imageFloder);
                                }
                            }
                });
                ImageUtil.loadImageViewLoding(mContext , data.getFirstImagePath(), holder.<ImageView>getView(R.id.iv_album_image),R.mipmap.default_iamge,R.mipmap.default_iamge);
            }
        });
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);//点击外面消失
        setWidth(SystemInfoUtil.getScreenWidth()/2);
        setHeight(SystemInfoUtil.getScreenHeight()- margHeight);
    }

    public void showAtDropDownCenter(View parent) {
        if (!isShowing()) {
            setAnimationStyle(R.style.AnimationRightFade);
            int[] location = new int[2];
            parent.getLocationOnScreen(location);//获取以屏幕为原点的位置
            showAsDropDown(parent,0,margHeight);
        } else {
            dismiss();
        }
    }
    //点击之后的接口回调
    private OnImageDirSelected onImageDirSelected;
    public void setOnImageDirSelected(OnImageDirSelected onImageDirSelected) {
        this.onImageDirSelected = onImageDirSelected;
    }

    public interface OnImageDirSelected {
        void albumSelected(ImageFloder floder);
    }
}
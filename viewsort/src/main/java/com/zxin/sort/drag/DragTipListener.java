package com.zxin.sort.drag;

import com.zxin.zxinlib.bean.MenuEntity;

/**
 * Created by Administrator on 2018/6/4.
 */

public interface DragTipListener {
    void initUrl(MenuEntity indexData);
    void deleteMeun(MenuEntity indexData,int position);
    void addMenu(MenuEntity indexData);
}

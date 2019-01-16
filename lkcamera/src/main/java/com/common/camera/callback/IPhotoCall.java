package com.common.camera.callback;

/**
 * Created by liukui on 2017/6/8.
 *
 * 图片获取返回接口
 *
 */
public interface IPhotoCall {
    // 照片返回
    void onPhotoResult(String photoUrl);
}

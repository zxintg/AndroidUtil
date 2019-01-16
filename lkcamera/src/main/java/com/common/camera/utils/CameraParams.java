package com.common.camera.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.hardware.Camera.Size;
import android.util.Log;
import android.view.Surface;

import com.zxin.zxinlib.util.SystemInfoUtil;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 设置相机参数
 * Created by Lrxc on 2017/11/24.
 */

public class CameraParams {
    private final String TAG = "params";
    private volatile static CameraParams cameraParams;
    private final int minSize = 640;//最小尺寸
    private static double screenRatio = 1.33;//长宽比
    public int oritation;//旋转角度

    private CameraParams() {
    }

    public static CameraParams getInstance() {
        if (cameraParams == null) {
            synchronized (CameraParams.class) {
                if (cameraParams == null) {
                    cameraParams = new CameraParams();
                }
            }
        }
        screenRatio = (double) SystemInfoUtil.getScreenHeight() / SystemInfoUtil.getScreenWidth();
        return cameraParams;
    }

    /**
     * @param context
     * @param camera
     * @param cameraId 前置 后置摄像头
     */

    public void setCameraParams(Context context, Camera camera, int cameraId) {
        Camera.Parameters parameters = camera.getParameters();
        // 获取摄像头支持的PictureSize列表
        List<Size> pictureSizeList = parameters.getSupportedPictureSizes();
        //从列表中选取合适的分辨率
        Size picSize = getProperSize(pictureSizeList);
        if (null != picSize) {
            Log.i(TAG, "picSize.width==================" + picSize.width + "  picSize.height=" + picSize.height);
            //parameters.setPictureSize(picSize.width, picSize.height);
        }

        // 获取摄像头支持的PreviewSize列表
        List<Size> previewSizeList = parameters.getSupportedPreviewSizes();
        Size preSize = getProperSize(previewSizeList);
        if (null != preSize) {
            Log.i(TAG, "preSize.width==================" + preSize.width + "  preSize.height=" + preSize.height);
            //parameters.setPreviewSize(preSize.width, preSize.height);
        }
        // 连续对焦模式
        if (parameters.getSupportedFocusModes().contains(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE)) {
            parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE);
        }
        parameters.setPictureFormat(PixelFormat.JPEG); // 设置图片格式
        parameters.setJpegQuality(100); // 设置照片质量
        parameters.set("orientation", "portrait");
        //parameters.set("rotation", 180);//保存图片旋转180度解决方法
        setOrientation(context, camera, cameraId);
        camera.setParameters(parameters);
    }

    /*** 设置照片格式*/
    public void setParameter(Context context, Camera camera, int cameraId, boolean isFace) {
        Camera.Parameters parameters = camera.getParameters(); // 获取各项参数
        parameters.setPictureFormat(PixelFormat.JPEG); // 设置图片格式
        parameters.setJpegQuality(100); // 设置照片质量//获得相机支持的照片尺寸,选择合适的尺寸
        // 获取摄像头支持的PictureSize列表
        List<Size> sizes = parameters.getSupportedPictureSizes();
        int maxSize = Math.max(SystemInfoUtil.getScreenWidth(), SystemInfoUtil.getScreenHeight());
        int length = sizes.size();
        if (maxSize > 0) {
            for (int i = 0; i < length; i++) {
                if (maxSize <= Math.max(sizes.get(i).width, sizes.get(i).height)) {
                    parameters.setPictureSize(sizes.get(i).width, sizes.get(i).height);
                    break;
                }
            }
        }
        // 获取摄像头支持的PreviewSize列表
        List<Size> ShowSizes = parameters.getSupportedPreviewSizes();
        int showLength = ShowSizes.size();
        if (maxSize > 0) {
            for (int i = 0; i < showLength; i++) {
                if (maxSize <= Math.max(ShowSizes.get(i).width, ShowSizes.get(i).height)) {
                    parameters.setPreviewSize(ShowSizes.get(i).width, ShowSizes.get(i).height);
                    break;
                }
            }
        }
        if (isFace)
            parameters.set("rotation", 180);//保存图片旋转180度解决方法
        setOrientation(context, camera, cameraId);
        camera.setParameters(parameters);
    }

    //保证预览方向正确
    private void setOrientation(Context context, Camera camera, int cameraId) {
        Camera.CameraInfo info = new Camera.CameraInfo();
        Camera.getCameraInfo(cameraId, info);
        int rotation = ((Activity) context).getWindowManager().getDefaultDisplay().getRotation();

        int degrees = 0;
        switch (rotation) {
            case Surface.ROTATION_0:
                degrees = 0;
                break;
            case Surface.ROTATION_90:
                degrees = 90;
                break;
            case Surface.ROTATION_180:
                degrees = 180;
                break;
            case Surface.ROTATION_270:
                degrees = 270;
                break;
        }
        int result;
        if (info.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
            result = (info.orientation + degrees) % 360;
            result = (360 - result) % 360;  // compensate the mirror
        } else {  // back-facing
            result = (info.orientation - degrees + 360) % 360;
        }
        oritation = result;
        camera.setDisplayOrientation(result);
    }

    //从列表中选取合适的分辨率
    private Size getProperSize(List<Size> pictureSizeList) {
        //降序排序
        Collections.sort(pictureSizeList, new CameraSizeComparator());
        for (Size size : pictureSizeList) {
            float currentRatio = ((float) size.width) / size.height;
            //大于最小尺寸且比例相等
            if (size.width > minSize && Math.abs(currentRatio - screenRatio) <= 0.03) {
                return size;
            }
        }
        return null;
    }

    private class CameraSizeComparator implements Comparator<Size> {
        //降序排列
        public int compare(Size lhs, Size rhs) {
            return ((Integer) rhs.width).compareTo(lhs.width);
        }
    }
}

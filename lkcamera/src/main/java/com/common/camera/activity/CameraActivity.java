package com.common.camera.activity;

import android.annotation.TargetApi;
import android.content.pm.ActivityInfo;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.common.camera.R;
import com.common.camera.callback.ICameraCall;
import com.common.camera.crop.UCrop;
import com.common.camera.utils.CameraAlbumUtils;
import com.common.camera.view.CameraPreviewView;
import com.common.camera.utils.FileImageUtils;
import com.common.camera.utils.ScaleGestureListener;
import com.zxin.zxinlib.app.BaseApplication;
import com.zxin.zxinlib.util.SystemBarTintManager;
import com.zxin.zxinlib.util.SystemInfoUtil;
import com.zxin.zxinlib.view.dialog.ProgressBarDialog;

import java.io.File;

/**
 * Created by liukui on 2017/11/13.
 * <p>
 * 相机界面
 */
public class CameraActivity extends AppCompatActivity implements View.OnClickListener, ICameraCall {
    //自定义预览筐
    private CameraPreviewView camePreview;
    private Button mRadioButton, mTakePhoto;
    private ScaleGestureDetector gestureDetector;//缩放手势
    private RelativeLayout mHeadLay;
    private ProgressBarDialog dialog = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//强制竖屏
        initWindow();
        setContentView(R.layout.activity_camerapreview);
        initView();
        setDatas();
    }

    private void initView() {
        open = 0;
        mHeadLay = (RelativeLayout) findViewById(R.id.camera_headlay);
        camePreview = (CameraPreviewView) findViewById(R.id.cpv_camera_camepreview);
        mRadioButton = (Button) findViewById(R.id.camera_radioButton);
        mTakePhoto = (Button) findViewById(R.id.camera_takephoto);
        //缩放手势
        gestureDetector = new ScaleGestureDetector(this, new ScaleGestureListener(camePreview));

        if (dialog == null) {
            dialog = new ProgressBarDialog(this);
        }
    }

    private void setDatas() {
        mTakePhoto.setBackgroundResource(R.drawable.btn_cyclo_yellow);
        mRadioButton.setEnabled(false);
        camePreview.setOnCameraListener(this);
        camePreview.setOnClickListener(this);
        findViewById(R.id.camera_close).setOnClickListener(this);
        findViewById(R.id.camera_face).setOnClickListener(this);
        findViewById(R.id.camera_album).setOnClickListener(this);
        mRadioButton.setOnClickListener(this);
        mTakePhoto.setOnClickListener(this);

        mHeadLay.setPadding(mHeadLay.getPaddingLeft(), mHeadLay.getPaddingTop() + SystemInfoUtil.getStatusBarHeight(), mHeadLay.getPaddingRight(), mHeadLay.getPaddingBottom());
    }

    private int open = 0;

    @Override
    public void onClick(View v) {
        //返回
        if (v.getId() == R.id.camera_close) {
            onBackPressed();
            return;
        }
        if (v.getId() == R.id.cpv_camera_camepreview) {
            //手动对焦
            camePreview.autoFocus();
            return;
        }
        if (v.getId() == R.id.camera_takephoto) {
            //拍照
            if (dialog != null) {
                dialog.showProgress();
            }
            camePreview.takePicture();
            return;
        }
        if (v.getId() == R.id.camera_face) {
            //切换摄像头
            camePreview.switchFrontCamera();
            return;
        }
        if (v.getId() == R.id.camera_radioButton) {
            //闪光灯模式
            if (open % 2 == 0) {
                camePreview.openLight();
                mRadioButton.setBackgroundResource(R.drawable.btn_light_press);
            } else {
                camePreview.closeLight();
                mRadioButton.setBackgroundResource(R.drawable.btn_light_normal);
            }
            open++;
            return;
        }
        if (v.getId() == R.id.camera_album) {
            CameraAlbumUtils.getInstance(this).checkAlbumPermission();
            onBackPressed();
            return;
        }
    }

    @Override
    public void onCameraData(byte[] data) {
        //保存到本地
        File file = new FileImageUtils(this).saveToSDCard(data);
        //跳转到预览界面
        UCrop.of(file.getAbsolutePath())
                .cropEnable(CameraAlbumUtils.getInstance(CameraActivity.this).getTailorType())//第一个参数为FALSE时，第二个参数无效
                .withAspectRatio(1, 1)
                .withMaxResultSize(CameraAlbumUtils.getInstance(CameraActivity.this).getWith(), CameraAlbumUtils.getInstance(CameraActivity.this).getHeight())
                .withTargetActivity(ImageTailorActivity.class)
                .start(this);
        if (dialog != null) {
            dialog.closeProgress();
        }
        onBackPressed();
    }

    @Override
    public void onCheckedLight(boolean isHas) {
        mRadioButton.setEnabled(isHas);
        //闪光灯模式
        //camePreview.setIsOpenFlashMode(Camera.Parameters.FLASH_MODE_ON);//总是开启
        //camePreview.setIsOpenFlashMode(Camera.Parameters.FLASH_MODE_OFF);//总是关闭
        camePreview.setIsOpenFlashMode(Camera.Parameters.FLASH_MODE_AUTO);//自动模式
    }

    @Override
    public void onCameraFace(boolean isFace) {
        open = 0;
        mRadioButton.setVisibility(isFace ? View.GONE : View.VISIBLE);
        mRadioButton.setBackgroundResource(isFace ? R.drawable.btn_light_press:R.drawable.btn_light_normal);
        mRadioButton.setClickable(!isFace);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //手势缩放识别手势
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        camePreview.releaseCamera();
    }

    @TargetApi(19)
    private void initWindow() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setTintResource(R.drawable.top_bar_ffff);
            tintManager.setTintAlpha(0f);
        }
    }

}

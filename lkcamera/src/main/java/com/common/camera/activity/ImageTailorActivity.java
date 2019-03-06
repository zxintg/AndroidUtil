package com.common.camera.activity;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.common.camera.R;
import com.common.camera.crop.UCrop;
import com.common.camera.crop.util.BitmapLoadUtils;
import com.common.camera.crop.view.CropImageView;
import com.common.camera.crop.view.GestureCropImageView;
import com.common.camera.crop.view.OverlayView;
import com.common.camera.crop.view.TransformImageView;
import com.common.camera.crop.view.UCropView;
import com.common.camera.utils.CameraAlbumUtils;
import com.common.camera.utils.VanCropType;
import com.zxin.zxinlib.app.BaseApplication;
import com.zxin.zxinlib.util.FileUtil;
import com.zxin.zxinlib.util.LogUtils;
import com.zxin.zxinlib.util.SystemBarTintManager;
import com.zxin.zxinlib.util.ToastUtil;
import com.zxin.zxinlib.view.CommonCrosswiseBar;

import java.io.File;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 图片裁剪
 * Created by liukui on 2018/01/30
 */

public class ImageTailorActivity extends AppCompatActivity{
    private CommonCrosswiseBar mTitle;
    private UCropView mUCropView;
    private OverlayView mOverlayView;
    private GestureCropImageView mGestureCropImageView;
    private View superrotate;
    private TextView btnReduction;
    private TextView btnRotate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWindow();
        setContentView(R.layout.activity_signinshow);
        initView();
        setDatas();
        setCropView();
        setImageData();
    }

    private void initView() {
        mTitle = (CommonCrosswiseBar) findViewById(R.id.ccb_tailor_title);
        mUCropView = (UCropView) findViewById(R.id.UCropView_crop);
        superrotate = findViewById(R.id.tv_signinshow_superrotate);
        btnReduction = (TextView) findViewById(R.id.tv_signinshow_reduction);
        btnRotate = (TextView) findViewById(R.id.tv_signinshow_rotate);
        mGestureCropImageView = mUCropView.getCropImageView();
        mOverlayView = mUCropView.getOverlayView();
    }

    private float angle = 0;
    private void setDatas() {
        //家长端
        mTitle.setLeftButton(R.mipmap.ic_black_left_arrow);
        mTitle.setBackgroundRes(R.color.color_ffffff);
        mTitle.setTitleTextColor(R.color.color_333333);
        mTitle.setRightTextColor(R.color.color_666666);

        mTitle.setOnClickListener(R.id.common_bar_leftBtn, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mTitle.setOnClickListener(R.id.common_bar_rightBtn, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //完成
                cropAndSaveImage();
                CameraAlbumUtils.getInstance(ImageTailorActivity.this).setSuperRotate(false);
                onBackPressed();
            }
        });
        mGestureCropImageView.setTransformImageListener(mImageListener);
        mOverlayView.setParam(CameraAlbumUtils.getInstance(this).getWith(), CameraAlbumUtils.getInstance(this).getHeight());

        if (!CameraAlbumUtils.getInstance(this).isSuperRotate()) {
            superrotate.setVisibility(View.GONE);
            return;
        }
        superrotate.setVisibility(View.VISIBLE);

        btnReduction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                angle = 0;
                btnReduction.setEnabled(false);
                mUCropView.setImageRotate(angle);
            }
        });

        btnRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                angle += 90;
                mUCropView.setImageRotate(angle);
                btnReduction.setEnabled(true);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        angle = 0;
    }

    @TargetApi(19)
    private void initWindow(){
        //家长端
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setTintResource(R.drawable.top_bar_ffff);
            tintManager.setTintAlpha(0f);
        }
    }

    /**
     * 初始化裁剪View
     */
    private void setCropView() {
        switch (getIntent().getIntExtra(UCrop.CROP_TYPE_RECTANGLE_TYPE,VanCropType.CROP_TYPE_RECTANGLE)) {
            case VanCropType.CROP_TYPE_RECTANGLE:
                setCropRectangle(VanCropType.CROP_TYPE_RECTANGLE);
                break;

            case VanCropType.CROP_TYPE_RECTANGLE_GRID:
                setCropRectangle(VanCropType.CROP_TYPE_RECTANGLE_GRID);
                break;

            case VanCropType.CROP_TYPE_CIRCLE:
                setCropCircle(VanCropType.CROP_TYPE_CIRCLE);
                break;

            case VanCropType.CROP_TYPE_CIRCLE_STROKE:
                setCropCircle(VanCropType.CROP_TYPE_CIRCLE_STROKE);
                break;
        }
    }

    /****
     * 剪裁矩形
     * @param cropType
     */
    private void setCropRectangle(int cropType) {
        // 设置允许缩放
        mGestureCropImageView.setScaleEnabled(true);
        // 设置禁止旋转
        mGestureCropImageView.setRotateEnabled(false);
        // 设置外部阴影颜色
        mOverlayView.setDimmedColor(Color.parseColor("#A0000000"));
        // 设置周围阴影是否为椭圆(如果false则为矩形)
        mOverlayView.setOvalDimmedLayer(false);
        // 设置显示裁剪边框
        mOverlayView.setShowCropFrame(true);

        if (cropType == VanCropType.CROP_TYPE_RECTANGLE_GRID) {
            // 设置显示裁剪网格
            mOverlayView.setShowCropGrid(true);
            // 设置裁剪网格的行数
            mOverlayView.setCropGridRowCount(2);
            // 设置裁剪网格的列数
            mOverlayView.setCropGridColumnCount(2);
        } else {
            // 设置不显示裁剪网格
            mOverlayView.setShowCropGrid(false);
        }
    }

    /***
     * 剪裁圆形
     * @param cropType
     */
    private void setCropCircle(int cropType) {
        // 设置允许缩放
        mGestureCropImageView.setScaleEnabled(true);
        // 设置禁止旋转
        mGestureCropImageView.setRotateEnabled(false);
        // 设置外部阴影颜色
        mOverlayView.setDimmedColor(Color.parseColor("#A0000000"));
        // 设置周围阴影是否为椭圆(如果false则为矩形)
        mOverlayView.setOvalDimmedLayer(true);
        // 设置不显示裁剪网格
        mOverlayView.setShowCropGrid(false);

        if (cropType == VanCropType.CROP_TYPE_CIRCLE) {
            // 设置显示裁剪边框
            mOverlayView.setShowCropFrame(true);
        } else {
            // 设置显示裁剪边框
            mOverlayView.setShowCropFrame(false);
        }
    }

    private void setImageData() {
        mGestureCropImageView.setImageUri(getIntent().getStringExtra(UCrop.EXTRA_INPUT_URI));

        // 设置裁剪宽高比
        if (getIntent().getBooleanExtra(UCrop.EXTRA_ASPECT_RATIO_SET, false)) {
            float aspectRatioX = getIntent().getFloatExtra(UCrop.EXTRA_ASPECT_RATIO_X, 0);
            float aspectRatioY = getIntent().getFloatExtra(UCrop.EXTRA_ASPECT_RATIO_Y, 0);

            if (aspectRatioX > 0 && aspectRatioY > 0) {
                mGestureCropImageView.setTargetAspectRatio(aspectRatioX / aspectRatioY);
            } else {
                mGestureCropImageView.setTargetAspectRatio(CropImageView.SOURCE_IMAGE_ASPECT_RATIO);
            }
        }

        // 设置裁剪的最大宽高
        if (getIntent().getBooleanExtra(UCrop.EXTRA_MAX_SIZE_SET, false)) {
            int maxSizeX = getIntent().getIntExtra(UCrop.EXTRA_MAX_SIZE_X, 0);
            int maxSizeY = getIntent().getIntExtra(UCrop.EXTRA_MAX_SIZE_Y, 0);

            if (maxSizeX > 0 && maxSizeY > 0) {
                mGestureCropImageView.setMaxResultImageSizeX(maxSizeX);
                mGestureCropImageView.setMaxResultImageSizeY(maxSizeY);
            } else {
                LogUtils.d("EXTRA_MAX_SIZE_X and EXTRA_MAX_SIZE_Y must be greater than 0");
            }
        }
    }

    private TransformImageView.TransformImageListener mImageListener = new TransformImageView.TransformImageListener() {
        @Override
        public void onRotate(float currentAngle) {

        }

        @Override
        public void onScale(float currentScale) {

        }

        @Override
        public void onLoadComplete() {
            Animation fadeInAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.crop_fade_in);
            fadeInAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    mUCropView.setVisibility(View.VISIBLE);
                    mGestureCropImageView.setImageToWrapCropBounds();
                }

                @Override
                public void onAnimationEnd(Animation animation) {

                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }
            });
            mUCropView.startAnimation(fadeInAnimation);
        }

        @Override
        public void onLoadFailure(Exception e) {
            setResultException();
            finish();
        }
    };

    /**
     * 裁剪图片失败
     *
     */
    private void setResultException() {
        ToastUtil.showShort("裁剪图片失败");
        onBackPressed();
    }

    /**
     * 裁剪图片，并保存
     */
    private void cropAndSaveImage() {
        OutputStream outputStream = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CHINA);
            String imageFileName = "IMG_3rdedu_" + dateFormat.format(new Date());
            Uri mOutputUri = Uri.fromFile(new File(getCacheDir(), imageFileName.concat(".jpeg")));
            mGestureCropImageView.setCropViewRect(mOverlayView.getCropViewRect());
            mGestureCropImageView.postRotate(angle);
            final Bitmap croppedBitmap = mGestureCropImageView.cropImage();
            if (croppedBitmap != null) {
                outputStream = getContentResolver().openOutputStream(mOutputUri);
                croppedBitmap.compress(Bitmap.CompressFormat.JPEG, 85, outputStream);
                croppedBitmap.recycle();
                CameraAlbumUtils.getInstance(this).getIPhotoCall().onPhotoResult(FileUtil.getInstance().getRealPathFromURI(mOutputUri));
                finish();
            } else {
                setResultException();
            }
        } catch (Exception e) {
            setResultException();
            onBackPressed();
        } finally {
            BitmapLoadUtils.close(outputStream);
        }
    }
}

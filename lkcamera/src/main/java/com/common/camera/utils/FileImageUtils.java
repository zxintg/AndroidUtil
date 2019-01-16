package com.common.camera.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.util.Log;
import com.common.camera.R;
import com.common.camera.model.ImageFloder;
import com.common.camera.model.LocalAlbum;
import com.zxin.zxinlib.app.BaseApplication;
import com.zxin.zxinlib.util.BaseStringUtils;
import com.zxin.zxinlib.util.SystemInfoUtil;
import com.zxin.zxinlib.util.ToastUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 文件工具类
 * Created by Lrxc on 2017/11/15.
 */

public class FileImageUtils {
    private Context context;
    public FileImageUtils(Context context) {
        this.context = context;
    }

    // 保存图片到sd卡中
    public File saveToSDCard(byte[] data) {
        Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
        //Bitmap waterMarkBitmap = createWaterMarkBitmap(bitmap, rect);
        //设置bitmap旋转
        Matrix matrix = new Matrix();
        matrix.setRotate(CameraParams.getInstance().oritation);
        bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);

        File fileFolder = new File(Environment.getExternalStorageDirectory() + "/Pictures/");

        if (!fileFolder.exists()) // 如果目录不存在，则创建一个名为"finger"的目录
            fileFolder.mkdirs();
        String format = "3rdedu_" + DateFormat.getDateTimeInstance().format(new Date()) + ".jpg";
        File jpgFile = new File(fileFolder, format);
        if (jpgFile.exists()) jpgFile.delete();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(jpgFile);
            //waterMarkBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
        } catch (Exception e) {
            e.printStackTrace();
            Log.i("lrxc", "saveToSDCard: " + e.getMessage());
        } finally {
            try {
                if (fos != null) fos.close(); // 关闭输出流
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return jpgFile;
    }

    //添加水印
    private Bitmap createWaterMarkBitmap(Bitmap bitmap, Rect rect) {
        //设置bitmap旋转
        Matrix matrix = new Matrix();
        matrix.setRotate(CameraParams.getInstance().oritation);
        bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);

        //宽高为矩形的宽高
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (rect != null) {
            //获取遮罩内的图片
            bitmap = getRectBmp(bitmap, rect);
            width = rect.right - rect.left;
            height = rect.bottom - rect.top;
        }
        //创建透明贴图--保证水印的大小
        Bitmap chartletBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        chartletBitmap.eraseColor(Color.TRANSPARENT);//设置透明
        Canvas canvas = new Canvas(chartletBitmap);

        //画笔
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(50);

        String format = DateFormat.getDateTimeInstance().format(new Date());
        canvas.drawText(format, 20, 50, paint);
        canvas.drawText("username", 20, 100, paint);

        Bitmap logoBitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher);
        canvas.drawBitmap(logoBitmap, chartletBitmap.getWidth() - logoBitmap.getWidth() - 20, 0, null);
        //贴图进行缩放
        Bitmap scaleBitmap = scaleBitmap(chartletBitmap, bitmap.getWidth(), bitmap.getHeight());

        //原图作为底图
        Canvas canvasBase = new Canvas(bitmap);
        canvasBase.drawBitmap(scaleBitmap, 0, 0, null);
        return bitmap;
    }

    /**
     * 获取遮罩内的图像
     *
     * @param rect 遮罩矩形
     * @param bm   原图
     * @return 矩形内图像
     */
    private Bitmap getRectBmp(Bitmap bm, Rect rect) {
        int width = rect.right - rect.left;
        int hight = rect.bottom - rect.top;
        Log.i("ddms", "getRectBmp: " + rect.left + " " + rect.top + " " + width + " " + hight + " " + bm.getWidth() + " " + bm.getHeight());

        Bitmap rectbitmap = null;
        //横竖屏--按比例割取图片
        if (CameraParams.getInstance().oritation == 90) {
            rectbitmap = Bitmap.createBitmap(bm, 0, bm.getHeight() * rect.top / SystemInfoUtil.getScreenHeight(), bm.getWidth(), bm.getHeight() * hight / SystemInfoUtil.getScreenHeight());
        } else if (CameraParams.getInstance().oritation == 0) {
            rectbitmap = Bitmap.createBitmap(bm, bm.getWidth() * rect.left / SystemInfoUtil.getScreenHeight(), 0, bm.getWidth() * width / SystemInfoUtil.getScreenHeight(), bm.getHeight());
        }
        if (!bm.isRecycled()) {
            bm.recycle();
        }
        return rectbitmap;
    }

    /**
     * 根据给定的宽和高进行拉伸
     *
     * @param origin    原图
     * @param newWidth  新图的宽
     * @param newHeight 新图的高
     * @return 缩放后图片
     */
    private Bitmap scaleBitmap(Bitmap origin, int newWidth, int newHeight) {
        int height = origin.getHeight();
        int width = origin.getWidth();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap newBM = Bitmap.createBitmap(origin, 0, 0, width, height, matrix, false);
        if (!origin.isRecycled()) {
            origin.recycle();
        }
        return newBM;
    }

    /*****
     * 获取本地图片
     */
    public void getLocalImage(final Handler mHandler,final String selectPath) {
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            ToastUtil.showShort("检测到没有内存卡");
            return;
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<String> mDirPathsList = new ArrayList<>();
                List<ImageFloder> mAlbumList = new ArrayList<>();

                Uri mImageUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                ContentResolver mContentResolver = BaseApplication.getInstance().getContext().getContentResolver();
                Cursor mCursor = mContentResolver.query(mImageUri, null,
                        MediaStore.Images.Media.MIME_TYPE + "=? or " +
                                MediaStore.Images.Media.MIME_TYPE + "=? or " +
                                MediaStore.Images.Media.MIME_TYPE + "=?",
                        new String[]{"image/jpeg", "image/png", "image/jpg"},
                        MediaStore.Images.Media.DATE_TAKEN + " DESC");//获取图片的cursor，按照时间倒序（发现没卵用)

                File mImgDir = null;
                while (mCursor.moveToNext()) {
                    String path = mCursor.getString(mCursor.getColumnIndex(MediaStore.Images.Media.DATA));// 1.获取图片的路径
                    File parentFile = new File(path).getParentFile();
                    if (parentFile == null)
                        continue;//不获取sd卡根目录下的图片
                    String parentPath = parentFile.getAbsolutePath();//2.获取图片的文件夹信息
                    String parentName = parentFile.getName();

                    //如果存在，就直接查询下一个，避免重复进行查询操作
                    if (mDirPathsList.contains(parentPath)) {
                        continue;
                    }
                    List<String> urlList = Arrays.asList(parentFile.list(getFileterImage()));
                    if (urlList == null || urlList.isEmpty())
                        continue;
                    mDirPathsList.add(parentPath);//将父路径添加到集合中
                    //自定义一个model，来保存图片的信息
                    ImageFloder imageFloder = new ImageFloder();
                    imageFloder.setFirstImagePath(path);
                    imageFloder.setDir(parentPath);
                    imageFloder.setName(parentName);

                    imageFloder.setCount(urlList.size());//传入每个相册的图片个数
                    mAlbumList.add(imageFloder);//添加每一个相册
                    //获取 Camera 文件夹信息（显示的是 Camera 图片的相册
                    if (BaseStringUtils.textIsEmpty(selectPath)) {
                        if (parentName.equals("Camera"))
                            mImgDir = parentFile;
                    }else{
                        if (parentName.equals(selectPath))
                            mImgDir = parentFile;
                    }
                }
                mCursor.close();
                Message message = new Message();
                message.what = 1;
                message.obj = mImgDir==null?mAlbumList==null||mAlbumList.isEmpty()?null:new File(mAlbumList.get(0).getDir()):mImgDir;
                Bundle build = new Bundle();
                LocalAlbum album = new LocalAlbum();
                album.imageList = mAlbumList;
                album.mDirPaths = mDirPathsList;
                build.putParcelable("data", album);
                message.setData(build);
                mHandler.sendMessage(message);
            }
        }).start();
    }

    //图片筛选器，过滤无效图片
    public FilenameFilter getFileterImage() {
        FilenameFilter filenameFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String filename) {
                if (filename.endsWith(".jpg")
                        || filename.endsWith(".png")
                        || filename.endsWith(".jpeg"))
                    return true;
                return false;
            }
        };
        return filenameFilter;
    }

    /*****
     * 获取相片的Uri
     * @param url 相片绝对路径
     * @return
     */
    public Uri getUriFromPath(String url) {
        Cursor mCursor = BaseApplication.getInstance().getContext().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null,
                MediaStore.Images.Media.MIME_TYPE + "=? or " + MediaStore.Images.Media.MIME_TYPE + "=? or " + MediaStore.Images.Media.MIME_TYPE + "=?",
                new String[]{"image/jpeg", "image/png", "image/jpg"},
                MediaStore.Images.Media.DATE_TAKEN + " DESC");//获取图片的cursor，按照时间倒序（发现没卵用)
        return null;
    }

}

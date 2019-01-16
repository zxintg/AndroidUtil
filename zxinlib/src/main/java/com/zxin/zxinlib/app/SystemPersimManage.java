package com.zxin.zxinlib.app;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;

import com.zxin.zxinlib.util.IntegerUtil;

import java.util.ArrayList;

/**
 * Created by liukui on 2018/2/2.
 *
 * 系统动态权限管理
 *
 */

public abstract class SystemPersimManage {

    private Context context;

    public SystemPersimManage (Context mContext) {
        context = mContext;
    }

    /****
     * 检测文件读写权限
     * @return
     */
    public void CheckedFile(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ArrayList<String> permissions = new ArrayList<>();
            if (ActivityCompat.checkSelfPermission(context,Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                permissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            }
            if (ActivityCompat.checkSelfPermission(context,Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                permissions.add(Manifest.permission.READ_EXTERNAL_STORAGE);
            }
            if (permissions.size() > 0) {
                requestPermissions(permissions, IntegerUtil.PERMISSION_REQUEST_FILE);
                resultPerm(false, IntegerUtil.PERMISSION_REQUEST_FILE);
                return;
            }
            resultPerm(true, IntegerUtil.PERMISSION_REQUEST_FILE);
            return;
        }
        resultPerm(true, IntegerUtil.PERMISSION_REQUEST_FILE);
    }

    /****
     * 检测定位权限
     * @return
     */
    public void CheckedLoaction(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ArrayList<String> permissions = new ArrayList<>();
            // 定位精确位置
            if(ActivityCompat.checkSelfPermission(context,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
                permissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
            }
            if(ActivityCompat.checkSelfPermission(context,Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
                permissions.add(Manifest.permission.ACCESS_COARSE_LOCATION);
            }
            if (permissions.size() > 0) {
                requestPermissions(permissions, IntegerUtil.PERMISSION_REQUEST_LOCATION);
                resultPerm(false, IntegerUtil.PERMISSION_REQUEST_LOCATION);
                return;
            }
            resultPerm(true, IntegerUtil.PERMISSION_REQUEST_LOCATION);
            return;
        }
        resultPerm(true, IntegerUtil.PERMISSION_REQUEST_LOCATION);
    }

    /*****
     * 检测相机权限
     * @return
     */
    public void CheckedCamera(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ArrayList<String> permissions = new ArrayList<>();
            if (ActivityCompat.checkSelfPermission(BaseApplication.getInstance(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                permissions.add(Manifest.permission.CAMERA);
            }
            if (ActivityCompat.checkSelfPermission(context,Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                permissions.add(Manifest.permission.READ_EXTERNAL_STORAGE);
            }
            if (permissions.size() > 0) {
                requestPermissions(permissions, IntegerUtil.PERMISSION_REQUEST_CAMERA);
                resultPerm(false, IntegerUtil.PERMISSION_REQUEST_CAMERA);
                return;
            }
            resultPerm(true, IntegerUtil.PERMISSION_REQUEST_CAMERA);
            return;
        }
        resultPerm(true, IntegerUtil.PERMISSION_REQUEST_CAMERA);
    }

    /****
     * 检测相册权限
     * @return
     */
    public void CheckedAlbum(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ArrayList<String> permissions = new ArrayList<>();
            if (ActivityCompat.checkSelfPermission(BaseApplication.getInstance(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                permissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            }
            if (permissions.size() > 0) {
                requestPermissions(permissions, IntegerUtil.PERMISSION_REQUEST_ALBUM);
                resultPerm(false, IntegerUtil.PERMISSION_REQUEST_ALBUM);
                return;
            }
            resultPerm(true, IntegerUtil.PERMISSION_REQUEST_ALBUM);
            return;
        }
        resultPerm(true, IntegerUtil.PERMISSION_REQUEST_ALBUM);
    }

    public abstract void resultPerm(boolean isCan,int requestCode);

    /****
     * 权限组请求
     * @param permissions
     * @param requestCode
     */
    private void requestPermissions(ArrayList<String> permissions,int requestCode){
        ActivityCompat.requestPermissions((Activity) context,permissions.toArray(new String[permissions.size()]), requestCode);
    }

}

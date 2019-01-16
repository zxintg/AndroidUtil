package com.zxin.zxinlib.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.orhanobut.logger.Logger;
import com.zxin.zxinlib.app.BaseApplication;
import com.zxin.zxinlib.bean.MenuEntity;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by 傅令杰
 */
public final class FileUtil {

    //格式化的模板
    private static final String TIME_FORMAT = "_yyyyMMdd_HHmmss";

    private static final String SDCARD_DIR = Environment.getExternalStorageDirectory().getPath();

    private static String getTimeFormatName(String timeFormatHeader) {
        final Date date = new Date(System.currentTimeMillis());
        //必须要加上单引号
        final SimpleDateFormat dateFormat = new SimpleDateFormat("'" + timeFormatHeader + "'" + TIME_FORMAT, Locale.getDefault());
        return dateFormat.format(date);
    }

    /**
     * 创建新的图片文件
     *
     * @param imageUrl
     * @return
     */
    public static File getNewFile(String imageUrl) {
        File file;
        if (TextUtils.isEmpty(imageUrl)) {
            file = new File(Environment.getExternalStorageDirectory(), System.currentTimeMillis() + ".jpg");//filePath 图片地址
        } else {
            file = new File(imageUrl);//filePath 图片地址
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return file;
    }

    /**
     * @param timeFormatHeader 格式化的头(除去时间部分)
     * @param extension        后缀名
     * @return 返回时间格式化后的文件名
     */
    public static String getFileNameByTime(String timeFormatHeader, String extension) {
        return getTimeFormatName(timeFormatHeader) + "." + extension;
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private static File createDir(String sdcardDirName) {
        //拼接成SD卡中完整的dir
        final String dir = SDCARD_DIR + "/" + sdcardDirName + "/";
        final File fileDir = new File(dir);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        return fileDir;
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static File createFile(String sdcardDirName, String fileName) {
        return new File(createDir(sdcardDirName), fileName);
    }

    private static File createFileByTime(String sdcardDirName, String timeFormatHeader, String extension) {
        final String fileName = getFileNameByTime(timeFormatHeader, extension);
        return createFile(sdcardDirName, fileName);
    }

    //获取文件的MIME
    public static String getMimeType(String filePath) {
        final String extension = getExtension(filePath);
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
    }

    //获取文件的后缀名
    public static String getExtension(String filePath) {
        String suffix = "";
        final File file = new File(filePath);
        final String name = file.getName();
        final int idx = name.lastIndexOf('.');
        if (idx > 0) {
            suffix = name.substring(idx + 1);
        }
        return suffix;
    }

    /**
     * 保存Bitmap到SD卡中
     *
     * @param dir      目录名,只需要写自己的相对目录名即可
     * @param compress 压缩比例 100是不压缩,值约小压缩率越高
     * @return 返回该文件
     */
    public static File saveBitmap(Bitmap mBitmap, String dir, int compress) {
        final String sdStatus = Environment.getExternalStorageState();
        // 检测sd是否可用
        if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) {
            return null;
        }
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        File fileName = createFileByTime(dir, "3rde", "jpg");
        try {
            fos = new FileOutputStream(fileName);
            bos = new BufferedOutputStream(fos);
            mBitmap.compress(Bitmap.CompressFormat.JPEG, compress, bos);// 把数据写入文件
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {

                if (bos != null) {
                    bos.flush();
                }
                if (bos != null) {
                    bos.close();
                }
                //关闭流
                if (fos != null) {
                    fos.flush();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        refreshDCIM();

        return fileName;
    }

    public static File writeToDisk(InputStream is, String dir, String name) {
        final File file = FileUtil.createFile(dir, name);
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;

        try {
            bis = new BufferedInputStream(is);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);

            byte data[] = new byte[1024 * 4];

            int count;
            while ((count = bis.read(data)) != -1) {
                bos.write(data, 0, count);
            }

            bos.flush();
            fos.flush();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bos != null) {
                    bos.close();
                }
                if (fos != null) {
                    fos.close();
                }
                if (bis != null) {
                    bis.close();
                }
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return file;
    }

    public static File writeToDisk(InputStream is, String dir, String prefix, String extension) {
        final File file = FileUtil.createFileByTime(dir, prefix, extension);
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;

        try {
            bis = new BufferedInputStream(is);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);

            byte data[] = new byte[1024 * 4];

            int count;
            while ((count = bis.read(data)) != -1) {
                bos.write(data, 0, count);
            }

            bos.flush();
            fos.flush();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bos != null) {
                    bos.close();
                }
                if (fos != null) {
                    fos.close();
                }
                if (bis != null) {
                    bis.close();
                }
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return file;
    }

    /**
     * 通知系统刷新系统相册，使照片展现出来
     */
    private static void refreshDCIM() {
        if (Build.VERSION.SDK_INT >= 19) {
            //兼容android4.4版本，只扫描存放照片的目录
            MediaScannerConnection.scanFile(BaseApplication.getInstance().getContext(),
                    new String[]{Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getPath()},
                    null, null);
        } else {
            //扫描整个SD卡来更新系统图库，当文件很多时用户体验不佳，且不适合4.4以上版本
            BaseApplication.getInstance().getContext().sendBroadcast(new Intent(Intent.ACTION_MEDIA_MOUNTED, Uri.parse("file://" +
                    Environment.getExternalStorageDirectory())));
        }
    }

    /**
     * 读取raw目录中的文件,并返回为字符串
     */
    public static String getRawFile(int id) {
        final InputStream is = BaseApplication.getInstance().getContext().getResources().openRawResource(id);
        final BufferedInputStream bis = new BufferedInputStream(is);
        final InputStreamReader isr = new InputStreamReader(bis);
        final BufferedReader br = new BufferedReader(isr);
        final StringBuilder stringBuilder = new StringBuilder();
        String str;
        try {
            while ((str = br.readLine()) != null) {
                stringBuilder.append(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                isr.close();
                bis.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }


    public static void setIconFont(String path, TextView textView) {
        final Typeface typeface = Typeface.createFromAsset(BaseApplication.getInstance().getContext().getAssets(), path);
        textView.setTypeface(typeface);
    }

    /**
     * 读取assets目录下的文件,并返回字符串
     */
    public static String getAssetsFile(String name) {
        InputStream is = null;
        BufferedInputStream bis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        StringBuilder stringBuilder = null;
        try {
            is = BaseApplication.getInstance().getContext().getAssets().open(name);
            bis = new BufferedInputStream(is);
            isr = new InputStreamReader(bis);
            br = new BufferedReader(isr);
            stringBuilder = new StringBuilder();
            String str;
            while ((str = br.readLine()) != null) {
                stringBuilder.append(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (isr != null) {
                    isr.close();
                }
                if (bis != null) {
                    bis.close();
                }
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (stringBuilder != null) {
            return stringBuilder.toString();
        } else {
            return null;
        }
    }

    /**
     * 判断SD卡是否可用
     *
     * @return SD卡可用返回true
     */
    public static boolean hasSdcard() {
        String status = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(status);
    }


    public static String getRealFilePath(final Context context, final Uri uri) {
        if (null == uri) return null;
        final String scheme = uri.getScheme();
        String data = null;
        if (scheme == null)
            data = uri.getPath();
        else if (ContentResolver.SCHEME_FILE.equals(scheme)) {
            data = uri.getPath();
        } else if (ContentResolver.SCHEME_CONTENT.equals(scheme)) {
            final Cursor cursor = context.getContentResolver().query(uri, new String[]{MediaStore.Images.ImageColumns.DATA}, null, null, null);
            if (null != cursor) {
                if (cursor.moveToFirst()) {
                    final int index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
                    if (index > -1) {
                        data = cursor.getString(index);
                    }
                }
                cursor.close();
            }
        }
        return data;
    }

    /**
     * 相机拍照保存的文件全路径
     */
    public static File getTakePhotoFile() {
        File file = null;
        try {
            file = new File(Environment.getExternalStorageDirectory(), "takephoto.jpg");
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    /**
     * 相机拍照保存的文件全路径(裁剪后的临时路径)
     */
    public static File getTempPhotoFile() {
        File file = null;
        try {
            file = new File(Environment.getExternalStorageDirectory(), System.currentTimeMillis() + ".jpg");
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    /**
     * 相机拍照保存的文件全路径
     */
    public static String getTakePhotoFileDirectory() {
        String dirs = Environment.getExternalStorageDirectory().getAbsolutePath();
        File fileDirectory = new File(dirs);
        if (!fileDirectory.exists()) {
            fileDirectory.mkdirs();
        }
        return dirs;
    }

    /**
     * 创建文件
     *
     * @param path
     * @return
     */
    public static File createDirFile(String path) {
        int pos = path.lastIndexOf("/");
        String dirpath = path.substring(0, pos + 1);
        if (!dirpath.startsWith("/"))
            dirpath = "/" + dirpath;
        File f = new File(dirpath);
        if (!f.exists())
            f.mkdirs();
        return new File(path);
    }

    /**
     * 通过文件名，判断指定目录下是否有改文件
     *
     * @param filename
     */
    public static File isExitByFileName(String path, String filename) {
        File isExitFile = null;
        File dir = new File(path);
        File[] listFiles = dir.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.getName().equals(filename)) {
                    isExitFile = file;
                    break;
                }
            }
        }
        return isExitFile;
    }

    /**
     * 输入流转文件并保存到本地
     *
     * @param is       文件输入流
     * @param savePath 保存的路径
     * @param fileName 文件名
     * @return
     */
    public static File InputStreamToFile(InputStream is, String savePath, String fileName) {
        try {
            File dir = new File(savePath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File outFile = new File(dir + "/" + fileName);
            if (outFile != null) {
                FileOutputStream fos = new FileOutputStream(outFile);
                byte[] buffer = new byte[1024 * 10];
                int count = 0;
                while ((count = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, count);
                }
                is.close();
                fos.flush();
                fos.close();
                return outFile;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * create the targer file's dir
     *
     * @param path the file's absolute path
     */
    public static void createDirs(String path) {
        path = path.substring(0, path.lastIndexOf("/") + 1);
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    /***
     * 删除指定目录下得所有文件
     * @param dirPath
     */
    public static boolean clearAllFile(String dirPath) {
        File file = new File(dirPath);
        if (file != null && file.exists()) {
            if (file.isFile()) {
                return file.delete();
            } else if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (int i = 0; listFiles != null && i < listFiles.length; i++) {
                    if (listFiles[i].isFile()) {
                        if (!listFiles[i].delete()) {
                            LogUtils.d("Delete file failed!" + dirPath);
                            return false;
                        }
                    } else {
                        if (!clearAllFile(listFiles[i].getPath())) {
                            return false;
                        }
                    }
                }
            }
        }
        LogUtils.d("Delete file----file is not exists----" + dirPath);
        return true;
    }

    /*****
     * 删除指定路径APK文件
     * @param path
     */
    public static void rmoveAPKFile(String path) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), path.substring(path.lastIndexOf("/")));
        if (file.exists()) {
            file.delete();
        }
        if (!file.exists())
            LogUtils.d("安装文件删除成功");
    }


    /**
     * 创建目录
     *
     * @param path
     * @return
     */
    public static File createDirByPath(String path) {
        File file = new File(path);
        if (file != null && !file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /**
     * 复制文件到指定目录
     *
     * @param is
     * @param dirPath
     * @param fileName
     */
    public static File copyFile(InputStream is, String dirPath, String fileName) {
        try {
            if (is != null) {
                File file = new File(createDirByPath(dirPath), fileName);
                FileOutputStream fos = new FileOutputStream(file);
                byte[] buffer = new byte[1024 * 100];
                int len = 0;
                while ((len = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                }
                is.close();
                fos.flush();
                fos.close();
                return file;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is ExternalStorageProvider.
     */
    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is DownloadsProvider.
     */
    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is MediaProvider.
     */
    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    /*******
     * 相册选取图片得到的Uri是Content Uri而拍照后使用的是文件路径生成的File Uri，
     * 看来问题就是出在这里，并不是说我们app的targetSDKVersion不是24就可以使用File Uri，
     * 但是photos app的targetSdkVersion可能是24导致了它接受了File Uri而崩溃，
     * 那么我们需要做的就是把File Uri换成Content Uri。这里需要提的是，
     * 直接按照这里的做法去更换Content Uri并不能生效，会提示“Can not edit image under 50*50 pixels”的错误toast提示，
     * 其实是photos app找不到Content Uri传进去的图片文件。那么我们需要换一种方式去更换Content Uri，
     * 我们在stackoverflow上面找到更换Content Uri的方法，需要注意的是不是所有的File Uri都可以转换成Content Uri，应该是多媒体相关的文件才可以。
     * @return
     * 参考 http://www.jianshu.com/p/c73b959b6bcf
     */
    public static Uri getImageContentUri(String filePath) {
        Cursor cursor = BaseApplication.getInstance().getContext().getContentResolver().query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                new String[]{MediaStore.Images.Media._ID},
                MediaStore.Images.Media.DATA + "=? ",
                new String[]{filePath}, null);

        if (cursor != null && cursor.moveToFirst()) {
            int id = cursor.getInt(cursor
                    .getColumnIndex(MediaStore.MediaColumns._ID));
            Uri baseUri = Uri.parse("content://media/external/images/media");
            return Uri.withAppendedPath(baseUri, "" + id);
        } else {
            if (new File(filePath).exists()) {
                ContentValues values = new ContentValues();
                values.put(MediaStore.Images.Media.DATA, filePath);
                return BaseApplication.getInstance().getContext().getContentResolver().insert(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
            } else {
                return null;
            }
        }
    }

    /****
     * 读取Asset中的文件
     * @param assetManager
     * @param path
     * @return
     */
    public static String getAssetFileToStr(AssetManager assetManager, String path) {
        BufferedReader bufferedReader = null;
        StringBuilder result = new StringBuilder();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(assetManager.open(path), "UTF-8"));
            for (String ignored = null; (ignored = bufferedReader.readLine()) != null; ) {
                result.append(ignored);
            }
        } catch (IOException var13) {
            return "";
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException var12) {
                    ;
                }
            }
        }
        return result.toString().trim();
    }

    /******
     * 根据URI获取文件绝对路径
     * @param contentUri
     * @return
     * liukui 2017/05/19
     */
    public static String getRealPathFromURI(Uri contentUri) {
        if (contentUri == null) return null;
        int sdkVersion = Build.VERSION.SDK_INT;
        if (sdkVersion < 11) {
            // SDK < Api11
            return getRealPathFromUri_BelowApi11(contentUri);
        }
        if (sdkVersion < 19) {
            // SDK > 11 && SDK < 19
            return getRealPathFromUri_Api11To18(contentUri);
        }
        // SDK > 19
        return getRealPathFromUri_AboveApi19(contentUri);
    }

    /**
     * 适配api19以上,根据uri获取图片的绝对路径
     * liukui 2017/05/19
     */
    @SuppressLint("NewApi")
    private static String getRealPathFromUri_AboveApi19(Uri uri) {
        if (DocumentsContract.isDocumentUri(BaseApplication.getInstance(), uri)) { // 【DocumentProvider】
            if (isExternalStorageDocument(uri)) { // 【ExternalStorageProvider】
                String docId = DocumentsContract.getDocumentId(uri);
                String[] split = docId.split(":");
                String type = split[0];
                if ("primary".equalsIgnoreCase(type))
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
            } else if (isDownloadsDocument(uri)) { // 【DownloadsProvider】
                String id = DocumentsContract.getDocumentId(uri);
                Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(id));
                return getDataColumn(contentUri, null, null);
            } else if (isMediaDocument(uri)) { // 【MediaProvider】
                String docId = DocumentsContract.getDocumentId(uri);
                String[] split = docId.split(":");
                String type = split[0];
                Uri contentUri = null;
                if ("image".equals(type)) contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                else if ("video".equals(type))
                    contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                else if ("audio".equals(type))
                    contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                String selection = "_id=?";
                String[] selectionArgs = new String[]{split[1]};
                return getDataColumn(contentUri, selection, selectionArgs);
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) { // 【MediaStore (and general)】
            return getDataColumn(uri, null, null);
        } else if ("file".equalsIgnoreCase(uri.getScheme())) { // 【File】
            return uri.getPath();
        }
        return "";

    }

    /**
     * Get the value of the data column for this Uri. This is useful for MediaStore Uris, and other file-based ContentProviders.
     *
     * @param uri           The Uri to query.
     * @param selection     (Optional) Filter used in the query.
     * @param selectionArgs (Optional) Selection arguments used in the query.
     * @return The value of the _data column, which is typically a file path.
     */
    public static String getDataColumn(Uri uri, String selection, String[] selectionArgs) {
        Cursor cursor = null;
        String column = "_data";
        String[] projection = {column};
        String result = "";
        cursor = BaseApplication.getInstance().getContext().getContentResolver().query(uri, new String[]{MediaStore.Images.ImageColumns.DATA}, null, null, null);
        if (null != cursor) {
            if (cursor.moveToFirst()) {
                int index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
                if (index > -1) {
                    result = cursor.getString(index);
                }
            }
            cursor.close();
        }
        return result;


    }

    /**
     * 适配api11-api18,根据uri获取图片的绝对路径
     * liukui 2017/05/19
     */
    private static String getRealPathFromUri_Api11To18(Uri uri) {
        String filePath = null;
        String[] projection = {MediaStore.Images.Media.DATA};

        CursorLoader loader = new CursorLoader(BaseApplication.getInstance(), uri, projection, null,
                null, null);
        Cursor cursor = loader.loadInBackground();
        if (cursor == null)
            return "";
        cursor.moveToFirst();
        filePath = cursor.getString(cursor.getColumnIndex(projection[0]));
        cursor.close();
        return filePath;
    }

    /**
     * 适配api11以下(不包括api11),根据uri获取图片的绝对路径
     * liukui 2017/05/19
     */
    private static String getRealPathFromUri_BelowApi11(Uri uri) {
        String filePath = null;
        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor cursor = BaseApplication.getInstance().getContentResolver().query(uri, projection,
                null, null, null);
        if (cursor == null)
            return "";
        cursor.moveToFirst();
        filePath = cursor.getString(cursor.getColumnIndex(projection[0]));
        cursor.close();
        return filePath;
    }


    public static void DeleteFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            if (file.getAbsoluteFile().delete()) {
                LogUtils.d(file.getName() + " 删除成功!");
            }
        }
    }


    /**
     * 打开文件
     * 兼容7.0
     *
     * @param context     activity
     * @param file        File
     * @param contentType 文件类型如：文本（text/html）
     *                    当手机中没有一个app可以打开file时会抛ActivityNotFoundException
     */
    public static void startActionFile(Context context, File file, String contentType) throws ActivityNotFoundException {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);//增加读写权限
        intent.setDataAndType(getUriFromFile(), contentType);
        if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
    }

    public static Uri getUriFromFile() {
        File file = getTakePhotoFile();
        if (file == null) {
            throw new NullPointerException();
        }
        Uri uri;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //uri = FileProvider.getUriForFile(BaseApplication.getInstance(), BuildConfig.APPLICATION_ID + ".fileprovider", file);
            String pageName = BaseStringUtils.fileprovider;
            uri = FileProvider.getUriForFile(BaseApplication.getInstance(), pageName, file);
        } else {
            uri = Uri.fromFile(file);
        }
        return uri;
    }


    /**
     * 保存长图
     *
     * @return
     */
    public static String cutoutActivity(Bitmap bitmap) {
        return saveBitmap(bitmap,"3rdedu",100).getAbsolutePath();
    }

    public static List<MenuEntity> getAllMenuList() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            AssetManager assetManager = BaseApplication.getInstance().getAssets();
            BufferedReader bf = new BufferedReader(new InputStreamReader(assetManager.open("menulist")));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            Logger.e(e.toString());
        }
        return TextUtils.isEmpty(stringBuilder.toString()) ? null : (List<MenuEntity>) new Gson().fromJson(stringBuilder.toString(), new TypeToken<List<MenuEntity>>() {
        }.getType());
    }

}

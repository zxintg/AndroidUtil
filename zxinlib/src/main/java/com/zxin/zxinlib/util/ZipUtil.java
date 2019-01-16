package com.zxin.zxinlib.util;

import android.content.Context;
import android.text.TextUtils;

import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipUtil {

    /**
     * 解压文件，不设置密码
     * @param zipFilePath 被解压的文件路径（完整路径）
     * @param unzipFilePath 解压后文件保存的路径 （文件的输出路径）
     */
    public static void unZip (String zipFilePath , String unzipFilePath) {
        unZip(zipFilePath , unzipFilePath , "");
    }

    /**
     * 解压文件，支持中文路径已经文件名
     * @param zipFilePath 压缩文件路径（完整路径）
     * @param unzipFilePath 解压后输出的路径（文件的输出路径）
     * @param password 解压密码
     */
    public static void unZip (String zipFilePath , String unzipFilePath , String password) {
        try {
            File zipFile = new File(zipFilePath);
            if(zipFile.exists()) {
                net.lingala.zip4j.core.ZipFile zip4j = new net.lingala.zip4j.core.ZipFile(zipFile);
                if(zip4j.isEncrypted() && !TextUtils.isEmpty(password)) {
                    zip4j.setPassword(password);
                }
                zip4j.extractAll(unzipFilePath);
            }
        } catch (ZipException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param context
     * @param assertName
     * @return
     */
    public static boolean unzipAssetsZip(Context context, String assertName, String fromPath) {
        File file = new File(fromPath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            InputStream in = context.getAssets().open(assertName + ".zip");
            boolean success = unpackZip(in, file);
            return success;
        } catch (Exception e) {
            LogUtils.e("读取AssetsZip解压======"+e.getMessage());
        }
        return false;
    }

    private static boolean unpackZip(InputStream in, File outputDir) {
        if (outputDir.exists()) {
            deleteFileAndDir(outputDir);
        }
        outputDir.mkdirs();
        ZipInputStream zis;
        try {
            String filename;
            zis = new ZipInputStream(new BufferedInputStream(in));
            ZipEntry ze;
            byte[] buffer = new byte[1024];
            int count;

            while ((ze = zis.getNextEntry()) != null) {
                // zapis do souboru
                filename = ze.getName();
                if (ze.isDirectory()) {
                    //zipEntry是目录,则创建目录
                    filename = filename.substring(0, filename.length() - 1);
                    File folder = new File(outputDir, filename);
                    folder.mkdirs();
                    continue;
                }
                //否则创建文件,并输出文件的内容
                if (!TextUtils.isEmpty(filename) && filename.contains("/")) {
                    String tepFileName = filename.substring(0, filename.lastIndexOf('/'));
                    File folder = new File(outputDir, tepFileName);
                    folder.mkdirs();
                }
                File file = new File(outputDir + File.separator + filename);
                file.createNewFile();
                FileOutputStream fout = new FileOutputStream(file);
                while ((count = zis.read(buffer)) != -1) {
                    fout.write(buffer, 0, count);
                }

                fout.close();
                zis.closeEntry();
            }

            zis.close();
        } catch (IOException e) {
            LogUtils.d("解压文件失败====="+e.getMessage());
            return false;
        }
        LogUtils.d("解压文件成功:" + outputDir.getAbsolutePath());
        return true;
    }

    private static void deleteFileAndDir(File file) {
        if (file.isDirectory()) {
            File[] subFiles = file.listFiles();
            for (File subFile : subFiles) {
                deleteFileAndDir(subFile);
            }
        }
        file.delete();
    }

    /**
     * 压缩文件，无密码压缩
     * @param zipFilePath 压缩后zip包的存储路径  （完整路径）
     * @param rawfilePatn 被压缩的文件  （文件的输出路径）
     */
    public static void Zip (String zipFilePath , String rawfilePatn ) {
        Zip(zipFilePath , rawfilePatn , "");
    }

    /**
     * 压缩一个文件
     * @param zipFilePath 压缩存储的路径 （完整路径）
     * @param rawfilePatn 被压缩的文件 （文件的输出路径）
     * @param password 压缩密码
     */
    public static void Zip (String zipFilePath , String rawfilePatn , String password) {
        try {
            // 创建一个zip包
            net.lingala.zip4j.core.ZipFile zipFile = new net.lingala.zip4j.core.ZipFile(zipFilePath);
            ArrayList<File> fileAddZip = new ArrayList<File>();   // 向zip包中添加文件集合
            fileAddZip.add(new File(rawfilePatn));                // 向zip包中添加一个pdf文件
            ZipParameters parameters = new ZipParameters(); 	  // 设置zip包的一些参数集合

            if(!TextUtils.isEmpty(password)) {
                parameters.setEncryptFiles(true); // 是否设置密码（此处设置为：是）
                parameters.setPassword(password); // 压缩包密码
            }
            parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);        // 压缩方式(默认值)
            parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL); // 普通级别（参数很多）
            parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);  // 加密级别

            zipFile.createZipFile(fileAddZip , parameters);       // 创建压缩包完成
        } catch (ZipException e) {
            e.printStackTrace();
        }
    }

}

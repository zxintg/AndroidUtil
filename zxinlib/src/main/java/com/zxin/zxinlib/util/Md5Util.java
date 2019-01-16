package com.zxin.zxinlib.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2018/9/5.
 */

public class Md5Util {

    public static String md5Password(String mesg) {
        try {
            byte[] paramString = MessageDigest.getInstance("md5").digest(mesg.getBytes());
            StringBuffer localStringBuffer = new StringBuffer();
            for (byte by : paramString){
                String str = Integer.toHexString(by & 0xFF);
                if (str.length() == 1) {
                    localStringBuffer.append("0");
                }
                localStringBuffer.append(str);
            }
            return localStringBuffer.toString().toUpperCase();
        } catch (NoSuchAlgorithmException paramString) {
            paramString.printStackTrace();
        }
        return "";
    }
}

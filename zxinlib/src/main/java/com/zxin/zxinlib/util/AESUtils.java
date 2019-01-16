package com.zxin.zxinlib.util;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by hy on 2017/9/25.
 */

public class AESUtils {

    private static final String AES = "AES";
    public final static String SECRET_KEY ="MrQz9Nq8mNOpcFNI";
    public final static String IV_STRING ="dMitHORyqbeYVE0o";


    /**
     * 加密
     *
     * @param content
     *            加密内容
     * @return 密文
     * @throws Exception
     *             e
     */
    public static String encrypt(String content) {
        byte[] encryptedBytes = new byte[0];
        try {
            byte[] byteContent = content.getBytes("UTF-8");
            byte[] enCodeFormat = SECRET_KEY.getBytes();
            SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat, AES);
            byte[] initParam = IV_STRING.getBytes();
            IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
            // 指定加密的算法、工作模式和填充方式
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
            encryptedBytes = cipher.doFinal(byteContent);
            // 同样对加密后数据进行 base64 编码
        } catch (IOException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException
                | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
            e.getStackTrace();
        }
        return  Base64Encoder.encode(encryptedBytes);
    }

    /**
     * 解密
     *
     * @param content
     *            密文
     * @return 明文
     * @throws Exception
     *             e
     */
    public static String decrypt(String content) {
        // base64 解码
        try {
            byte[] encryptedBytes = Base64Decoder.decodeToBytes(content);
            byte[] enCodeFormat =SECRET_KEY.getBytes();
            SecretKeySpec secretKey = new SecretKeySpec(enCodeFormat, AES);

            byte[] initParam = IV_STRING.getBytes();
            IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
            byte[] result = cipher.doFinal(encryptedBytes);

            return new String(result, "UTF-8");
        } catch (IOException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException
                | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
            e.getStackTrace();


        }
        return null;
    }
    public static void main(String[] args) {
/*
        String jsonData ="LaluN4S0myav2oa2LEH1Hw==";
        System.out.println("需要加密的内容：" + encrypt("李明"));
        System.out.println("经过解密的内容：" + decrypt("OfKijydSmcf6gVb0jLht8FvhrW3hTuc2Du2DvYiyIpF7jxAKUzTyWy0oOAJRYE0c00prB+lMfPxh\n" +
                "       IHtrCv/ArGLau0YpdqTJnMF7n90dBUyL5b22KwtLdlvigR9BKY6aQFarZDPAb79N7wLbXJh8ug=="));
        System.out.println("AESUtils jsonData ---->" + jsonData);*/


    }


}



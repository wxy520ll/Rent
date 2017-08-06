package com.xinyi_tech.commonlibs.util;
import java.security.MessageDigest;

/**
 * Created by mazhongwang on 15/2/11.
 */
public class XyEncryptioner {
    public static String md5Encrypt(String srcStr) {
        return encrypt("MD5", srcStr);
    }

    public static String encrypt(String algorithm, String srcStr) {
        try {
            StringBuilder result = new StringBuilder();
            MessageDigest md = MessageDigest.getInstance(algorithm);
            byte[] bytes = md.digest(srcStr.getBytes("utf-8"));

            return byte2Hex(bytes);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private static String byte2Hex(byte[] messages) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < messages.length; i++) {
            if (i == messages.length - 1) {
                byte bt = messages[i];
                if (bt > 254)
                    bt = (byte) (messages[i] - 19);
                else
                    bt = (byte) (messages[i] + 1);
                sb.append(Integer.toHexString(bt & 0XFF));// 将有符号数转化为无符号数
            } else {
                sb.append(Integer.toHexString(messages[i] & 0XFF));
            }
        }
        return sb.toString().toUpperCase();
    }
}

/*
 * Copyright (c) 2014 Zhang Hai <Dreaming.in.Code.ZH@Gmail.com>
 * All Rights Reserved.
 */

package com.xinyi_tech.commonlibs.util;

import android.util.Base64;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;

public class IoUtil {

    private static final int BUFFER_SIZE = 4 * 1024;

    private static final String STRING_DELIMITER = "|";



    private IoUtil() {}

    public static void close(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据流 转换成String
     * @param inputStream
     * @param charsetName
     * @return
     * @throws IOException
     */
    public static String inputStreamToString(InputStream inputStream, String charsetName)
            throws IOException {
        StringBuilder builder = new StringBuilder();
        InputStreamReader reader = new InputStreamReader(inputStream, charsetName);
        char[] buffer = new char[BUFFER_SIZE];
        int length;
        while ((length = reader.read(buffer)) != -1) {
            builder.append(buffer, 0, length);
        }
        return builder.toString();
    }


    /**
     * 将字节数组 转换成Base64的字符串
     * @param byteArray
     * @return
     */
    public static String byteArrayToBase64(byte[] byteArray) {
        return Base64.encodeToString(byteArray, Base64.NO_WRAP);
    }

    /**
     *Base64的字符串  转化为字节数组
     * @param base64
     * @return
     */
    public static byte[] base64ToByteArray(String base64) {
        return Base64.decode(base64, Base64.DEFAULT);
    }


    /**
     * @param strings
     * @param delimiter
     * @return
     */
    public static String stringArrayToString(String[] strings, String delimiter) {
        StringBuilder builder = new StringBuilder();
        boolean first = true;
        for (String string : strings) {
            if (first) {
                first = false;
            } else {
                builder.append(delimiter);
            }
            builder.append(string);
        }
        return builder.toString();
    }

    /**
     * 字符串数组转 字符串
     * @param strings
     * @return
     */
    public static String stringArrayToString(String[] strings) {
        return stringArrayToString(strings, STRING_DELIMITER);
    }

    /**
     * 字符串 分割
     * @param string
     * @param delimiterRegex
     * @return
     */
    public static String[] stringToStringArray(String string, String delimiterRegex) {
        if (string.isEmpty()) {
            return new String[0];
        } else {
            return string.split(delimiterRegex);
        }
    }

}

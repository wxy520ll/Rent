package com.xinyi_tech.commonlibs.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;

/**
 * Created by studyjun on 2016/5/28.
 * 获取android  版本号+版本名字的工具类
 *
 */
public class AndroidUtil {

    /**
     * 获取android版本
     * @param context
     * @return
     */
    public static int getVersionCode(Context context) {
        PackageInfo info = null;
        PackageManager manager = context.getPackageManager();
        try {
            info = manager.getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null==info?0:info.versionCode;
    }

    /**
     * 获取android版本名字
     * @param context
     * @return
     */
    public static String getVersionName(Context context) {

        PackageInfo info = null;
        PackageManager manager = context.getPackageManager();
        try {
            info = manager.getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null==info?"v1.0":info.versionName;

    }

    /**
     * 获取App安装包信息
     *
     * @return
     */
    public static PackageInfo getPackageInfo(Context context) {
        PackageInfo info = null;
        try {
            info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace(System.err);
        }
        if (info == null) info = new PackageInfo();
        return info;
    }

    /**
     * 获取设备imei码
     * @return
     */
    public static String getDeviceId(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String imei = telephonyManager.getDeviceId();
        return imei;
    }
}

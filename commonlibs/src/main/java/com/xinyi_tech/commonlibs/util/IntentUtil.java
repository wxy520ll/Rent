package com.xinyi_tech.commonlibs.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.io.Serializable;


/**
 * Created by studyjun on 15/10/28.
 */
public class IntentUtil {

    /**
     * 启动activity
     * @param context
     * @param clazz
     */
    public static void startActivity(Context context,Class clazz){
        Intent intent = new Intent(context,clazz);
        context.startActivity(intent);
    }

    public static void startActivity(Context context, Class clazz, String key,Serializable serializable){
        Intent intent = new Intent(context,clazz);
        Bundle bundle=new Bundle();
        bundle.putSerializable(key,serializable);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /**
     * 启动activity
     * @param context
     * @param clazz
     */
    public static void startActivity(int flag,Context context,Class clazz){
        Intent intent = new Intent(context,clazz);
        intent.setFlags(flag);
        context.startActivity(intent);
    }

    /**
     * 启动activity
     * @param context
     * @param clazz
     */
    public static void startActivity(Context context,Class clazz,Intent intent){
        context.startActivity(intent);
    }

    /**
     * 启动activity
     * @param context
     * @param clazz
     */
    public static void startActivity(Activity context,Class clazz,int requestCode){
        Intent intent = new Intent(context,clazz);
        context.startActivityForResult(intent, requestCode);
    }
  /**
     * 启动activity
     * @param context
     * @param clazz
     */
    public static void startActivity(Activity context,Class clazz,int requestCode,String key,String vale){
        Intent intent = new Intent(context,clazz);
        Bundle bundle=new Bundle();
        bundle.putString(key,vale);
        intent.putExtras(bundle);
        context.startActivityForResult(intent, requestCode);
    }


    /**
     * 启动activity   传递一个String值
     * @param context
     * @param claszz
     * @param key
     * @param vale
     */
    public static void startActivity(Context context,Class claszz,String key,String vale){
        Intent intent=new Intent(context,claszz);
        Bundle bundle=new Bundle();
        bundle.putString(key,vale);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

}

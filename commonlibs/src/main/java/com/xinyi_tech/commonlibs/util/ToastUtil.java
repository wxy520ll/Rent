package com.xinyi_tech.commonlibs.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by $ wxy on 2017/4/12.
 */

public class ToastUtil {
    private final static boolean isShow = true;

    private ToastUtil(){
        throw new UnsupportedOperationException("T cannot be instantiated");
    }

    public static void showShort(Context context, CharSequence text) {
        if(isShow) Toast.makeText(context,text,Toast.LENGTH_SHORT).show();
    }

    public static void showLong(Context context,CharSequence text) {
        if(isShow)Toast.makeText(context,text,Toast.LENGTH_LONG).show();
    }
}

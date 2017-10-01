package xinyi.com.architecture.utils;

import android.widget.Toast;

import xinyi.com.architecture.application.XinYiApplication;

/**
 * Created by $ wxy on 2017/4/12.
 */

public class ToastUtil {
    private final static boolean isShow = true;

    private ToastUtil(){
        throw new UnsupportedOperationException("T cannot be instantiated");
    }

    public static void showShort(CharSequence text) {
        Toast.makeText(XinYiApplication.xinYiApplication, text, Toast.LENGTH_SHORT).show();
    }

    public static void showLong(CharSequence text) {
        Toast.makeText(XinYiApplication.xinYiApplication, text, Toast.LENGTH_SHORT).show();
    }
}

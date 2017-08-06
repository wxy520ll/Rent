package com.xinyi_tech.commonlibs.util;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.xinyi_tech.commonlibs.R;


/**
 * Created by hao.zhou on 2016/8/6.
 */
public class DialogHelper {

    private static Dialog mCameraDialog;

    /**
     * 操作点击
     */
    public interface OnOptionClickListener<T> {
        void onClick(DialogInterface dialog, int which, T o);
    }

    /**
     * 强制更新对话框
     * 没有取消  只能点击确定
     *
     * @param context
     * @return
     */
    public static final void showSureDialog(Context context, String msg, final OnOptionClickListener listener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.tips)
                .setMessage(msg)
                .setPositiveButton(R.string.sure, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (listener != null)
                            listener.onClick(dialog, which, null);
                    }
                }).setCancelable(false).show();
    }



    public static final void showSingleDialog(String[] dataArr, Context context, final OnOptionClickListener listener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("请选择派出所");
        builder.setSingleChoiceItems(dataArr, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (listener != null)
                    listener.onClick(dialog, which, null);
                dialog.dismiss();

            }
        });
      /*  builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });*/
        builder.show();
    }



    /**
     * 对话框
     *
     * @param context
     * @return
     */
    public static final void showSureAndCancleDialog(Context context,String msg, final OnOptionClickListener listener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.tips)
                .setMessage(msg)
                .setPositiveButton(R.string.sure, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (listener != null)
                            listener.onClick(dialog, which, null);
                    }
                })
                .setNegativeButton(R.string.cancle, null)
                .setCancelable(false).show();
    }



    //点击从底部弹出
    public static Dialog alertViewBootm(Context context, LinearLayout root) {
        Dialog mCameraDialog = new Dialog(context, R.style.my_dialog);
        mCameraDialog.setContentView(root);
        Window dialogWindow = mCameraDialog.getWindow();
        dialogWindow.setGravity(Gravity.BOTTOM);
        dialogWindow.setWindowAnimations(R.style.dialogstyle); // 添加动画
        WindowManager.LayoutParams lp = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        lp.x = 0; // 新位置X坐标
        lp.y = -20; // 新位置Y坐标
        lp.width = (int) context.getResources().getDisplayMetrics().widthPixels; // 宽度
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT; // 高度
        root.measure(0, 0);
        // lp.height = root.getMeasuredHeight();
        lp.alpha = 9f; // 透明度
        dialogWindow.setAttributes(lp);
        mCameraDialog.show();
        return mCameraDialog;
    }

    //点击从右边弹出
    public static Dialog alertViewRight(Context context, View root) {
        mCameraDialog = new Dialog(context, R.style.my_dialog);
        mCameraDialog.setContentView(root);
        Window dialogWindow = mCameraDialog.getWindow();
        dialogWindow.setGravity(Gravity.RIGHT);
        dialogWindow.setWindowAnimations(R.style.rightStyle); // 添加动画
        WindowManager.LayoutParams lp = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        lp.x = 0; // 新位置X坐标
        lp.y = -20; // 新位置Y坐标
        lp.width = (int) ((int) context.getResources().getDisplayMetrics().widthPixels*0.8); // 宽度
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT; // 高度
        root.measure(0, 0);
        // lp.height = root.getMeasuredHeight();
        lp.alpha = 9f; // 透明度
        dialogWindow.setAttributes(lp);
        mCameraDialog.show();
        return mCameraDialog;
    }

    public static void hidePopwindow(){
        if (mCameraDialog!=null){
            mCameraDialog.dismiss();
        }
    }

//    public static void showPopMenu(Activity aty, View iv, String path) {
//        View view = View.inflate(aty.getApplicationContext(),
//                R.layout.plate_full_image, null);
//        ImageView fullImage = (ImageView) view
//                .findViewById(R.id.full_plate_image);
//
//        if (!path.isEmpty()) {
//            ImageLoader.getInstance().displayImage(path, fullImage);
//            fullImage.setOnClickListener(new View.OnClickListener() {
//
//                @Override
//                public void onClick(View v) {
//                    mpopupWindow.dismiss();
//                }
//            });
//
//            if (mpopupWindow == null) {
//                mpopupWindow = new PopupWindow(aty);
//                mpopupWindow.setWidth(ActionBar.LayoutParams.MATCH_PARENT);
//                mpopupWindow.setHeight(ActionBar.LayoutParams.MATCH_PARENT);
//                mpopupWindow.setBackgroundDrawable(new BitmapDrawable());
//                mpopupWindow.setFocusable(true);
//                mpopupWindow.setOutsideTouchable(true);
//            }
//
//            mpopupWindow.setContentView(view);
//            mpopupWindow.showAtLocation(iv, Gravity.TOP, 0, 0);
//            mpopupWindow.update();
//
//            AlphaAnimation aa = new AlphaAnimation(0.3f, 1.0f);
//            aa.setDuration(1000);
//            view.setAnimation(aa);
//        }
//
//    }

}

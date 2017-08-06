package com.xinyi_tech.commonlibs.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;

/**
 * 图片裁切操作类
 * @author mengbo
 *
 */
public class CutPhoto {
	int cavas_width = 1024;//画布默认大小   
    int cavas_height = 768;
      
    int cut_width;  
    int cut_height;  
      
    Matrix cut_matrix = new Matrix();
      
    int startx = 0;//剪切的起始點   
    int starty = 0;  
  
    Canvas cutCanvas = null;
    Bitmap cacheBitmap = null;
    Bitmap resultBitmap = null;//要保存的指定大小的Bitmap
    
	public CutPhoto(Context context, int cut_width, int cut_height){
		cavas_width = cut_width;
		cavas_height = cut_height;
		cacheBitmap = Bitmap.createBitmap(cavas_width, cavas_height, Config.RGB_565);
        cutCanvas = new Canvas();
        cutCanvas.setBitmap(cacheBitmap);  
	}
	
	/**
	 * 保存图片
	 * @param file_name
	 */
	private String cutPhoto(String file_name, String foldPath){
        cutCanvas.drawBitmap(resultBitmap, 0,0,null);  
        //String foldPath = "/mnt/sdcard/DCIM/Camera/";  
        File foldFile = new File(foldPath);
        if(!foldFile.exists()){  
            foldFile.mkdirs();  
        }  
        String fileName = foldPath + file_name + ".jpg";
        FileOutputStream out;
        try {  
            File saveFile = new File(fileName);
            if(saveFile.exists()){  
                saveFile.delete();  
            }  
            out = new FileOutputStream(new File(fileName));
            cacheBitmap.compress(CompressFormat.JPEG, 100, out);//保存文件
            out.close();  
            return fileName;
        } catch (Exception e) {
            e.printStackTrace();  
            return "";
        }  
          
    }  
      
      
    /**
     * 获取裁切后图片路径  
     * @param bitmap 原图片
     * @param file_name 保存图片的名字
     * @return String 裁切后路径
     */
    public String getCutPhotoPath(Bitmap bitmap, String file_name, String foldPath){
//        if(bitmap.getWidth() > bitmap.getHeight()){//当width>height的时候，设置缩放比例   
            cut_width = bitmap.getWidth(); //原图高宽
            cut_height = bitmap.getHeight();  
            cut_matrix.postScale(1,1);  //图片不按比例缩放
            startx = (bitmap.getWidth() - cavas_width)/2;//设置起始裁切坐标
            starty = (bitmap.getHeight() - cavas_height)/2;  
            Log.e("", "cut_width="+cut_width+";cut_height="+cut_height+";cavas_width="+cavas_width+";cavas_height="+cavas_height);
            resultBitmap = Bitmap.createBitmap(bitmap,startx,starty,cavas_width,cavas_height,cut_matrix,true);
//        }else if(bitmap.getWidth() < bitmap.getHeight()){//当width < height的时候，设置缩放比例   
//            cut_width = bitmap.getWidth();  
//            cut_height =  (bitmap.getWidth()*3)/4;  
//            float xb = ((float) cavas_width) / cut_width;  
//            float yb = ((float) cavas_height) / cut_height;  
//            cut_matrix.postScale(xb,yb);  
//            starty = (bitmap.getHeight() - cut_height)/2;  
//            resultBitmap = Bitmap.createBitmap(bitmap,0,starty,cut_width,cut_height,cut_matrix,true);  
//        }  
        return cutPhoto(file_name,foldPath);  
    }  
}

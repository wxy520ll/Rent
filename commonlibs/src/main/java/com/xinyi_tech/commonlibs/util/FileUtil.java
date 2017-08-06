/*
 *	Copyright (c) 2012, Yulong Information Technologies
 *	All rights reserved.
 *  
 *  @Project: CarBaoshijie
 *  @author: Robot	
 */
package com.xinyi_tech.commonlibs.util;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * 文件操作工具类
 * 
 * @author Robot
 * @weibo http://weibo.com/feng88724
 * @date Oct 24, 2012
 */
public class FileUtil {
	private static final String TAG = "FileUtils";


	/**
	 * 获取可以使用的缓存文件
	 * @param context
	 * @param uniqueName 目录名称
	 * @return
	 */
	public static File getDiskCacheDir(Context context, String uniqueName) {
		final String cachePath = checkSDCard() ? getExternalCacheDir(context).getPath() : getAppCacheDir(context);
		File cacheDirFile = new File(cachePath,uniqueName);
		if (!cacheDirFile.exists()) {
			cacheDirFile.mkdirs();
		}
		return cacheDirFile;
	}

	/**
	 * 获取程序外部的缓存目录
	 * @param context
	 * @return
	 */
	public static File getExternalCacheDir(Context context) {
		// 这个sd卡中文件路径下的内容会随着，程序卸载或者设置中清除缓存后一起清空
		final String cacheDir = "/Android/data/" + context.getPackageName() + "/cache/";
		return new File(Environment.getExternalStorageDirectory().getPath() + cacheDir);
	}

	/**
	 * 获取安装在用户手机上的com.itlanbao.yyapp下的cache目录
	 * @return cache path
	 */
	public static String getAppCacheDir(Context context) {
		return context.getCacheDir().getPath();
	}





	/**
	 * 保存数据  String类型的数据 到文件中
	 * @param context
	 * @param data
	 * @param filename
	 * @return
	 */
	public static boolean save(Context context, String data, String filename) {
		if (TextUtils.isEmpty(data)) {
			return false;
		}
		return save(context, data.getBytes(), filename);
	}

	/**
	 * 保存数据
	 * @param context
	 * @param data
	 * @param filename
	 * @return
	 */
	public static boolean save(Context context, byte[] data, String filename) {
		boolean result = false;
		FileOutputStream fos = null;
		try {
			fos = context.openFileOutput(filename, Context.MODE_PRIVATE);
			fos.write(data);
			fos.flush();
		} catch (Exception e) {
			Log.e(TAG, e.toString());
		} finally {
			try {
				fos.close();
			} catch (Exception e) {
			}
		}
		return result;
	}



	/**
	 * 保存数据对象
	 * @param context
	 * @param object
	 * @param filename
	 * @return
	 */
	public static boolean save(Context context, Object object, String filename) {
		boolean result = false;
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = context.openFileOutput(filename, Context.MODE_PRIVATE);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(object);
			result = true;
		} catch (Exception e) {
			Log.e(TAG, e.getMessage() + "");
		} finally {
			try {
				if (oos != null) {
					oos.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (Exception e) {
				Log.e(TAG, e.getMessage() + "");
			}
		}
		return result;
	}

	/**
	 * 读取数据对象
	 * @param context
	 * @param filename
	 * @return
	 */
	public static Object getObject(Context context, String filename) {
		Object object = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			if (exists(context, filename)) {
				fis = context.openFileInput(filename);
				ois = new ObjectInputStream(fis);
				object = ois.readObject();
			}
		} catch (Exception e) {
			Log.e(TAG, e.getMessage() + "");
		} finally {
			try {
				if (ois != null) {
					ois.close();
				}
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e) {
				Log.e(TAG, e.getMessage() + "");
			}
		}
		return object;
	}

	/**
	 * 删除数据对象
	 * 
	 * @param context
	 * @param filename
	 */
	public static boolean remove(Context context, String filename) {
		boolean flag = false;
		if (context == null || filename == null) {
			return flag;
		}
		File file = context.getFileStreamPath(filename);
		if (file != null && file.exists() && file.isFile()) {
			flag = file.delete();
		}
		return flag;
	}

	/**
	 * 判断文件是否存在（应用内部目录）
	 * 
	 * @param context
	 * @param filename
	 * @return
	 */
	public static boolean exists(Context context, String filename) {
		File file = context.getFileStreamPath(filename);
		return file != null && file.exists();

	}

	/**
	 * 检查SD卡是否存在
	 *
	 * @return
	 */
	public static boolean checkSDCard() {
		final String status = Environment.getExternalStorageState();
		return Environment.MEDIA_MOUNTED.equals(status);
	}

	/**
	 * 清除临时文件；
	 */
	public static void cleanTmpFile(List<String> path) {
		for (int i=0;i<path.size();i++)
		{
			String s=path.get(i);
			if (StringUtil.isEmpty(s))return;
			File f=new File(s);
			if (f.exists())
				f.delete();
		}
	}
	public static void cleanFile(String path){
		if (!StringUtil.isEmpty(path)){
			File file=new File(path);
			if (file.exists()){
				file.delete();
			}
		}
	}

	/**
	 * Java文件操作 根据文件全路径获取文件名
	 * <p/>
	 * Created on: 2011-8-2 Author: nodeny
	 */
	public static String getFileName(String filePath) {

		if ((filePath != null) && (filePath.length() > 0)) {
			int dot = filePath.lastIndexOf('/');
			if ((dot > -1) && (dot < (filePath.length() - 1))) {
				return filePath.substring(dot + 1);
			}
		}
		return filePath;
	}
}

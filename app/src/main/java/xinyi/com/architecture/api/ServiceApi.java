package xinyi.com.architecture.api;

import android.content.Context;

import io.reactivex.Observable;
import xinyi.com.architecture.utils.RxUtil;

/**
 * Created by wxy on 2017/8/8.
 * 网络请求
 */

public class ServiceApi{

	public static final String IP = "";
	public static final String IMAGEIP = "";

	/**
	 * 默认post请求
	 * @param jsonParams 参数json
	 * @param url
	 * @param tClass    待转换类型
	 * @param context
	 * @param <T>
	 * @return
	 */
	public static <T> Observable<T> getData(String jsonParams, String url, Class<T>tClass, Context context) {
		return RxUtil.request(jsonParams,url,tClass,context);
	}
}

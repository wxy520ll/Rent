package xinyi.com.architecture.api;

import android.content.Context;

import javax.inject.Inject;

import io.reactivex.Observable;
import xinyi.com.architecture.utils.RxUtil;

/**
 * Created by wxy on 2017/8/8.
 * 网络请求
 */

public class ServiceManager {

	public static final String IP = "";
	public static final String IMAGEIP = "";

	Context context;

	@Inject
	public ServiceManager(Context context){
		this.context=context;
	}
	/**
	 * 默认post请求
	 * @param jsonParams 参数json
	 * @param url
	 * @param tClass    待转换类型
	 * @param <T>
	 * @return
	 */
	public  <T> Observable<T> getData(String jsonParams, String url, Class<T>tClass) {
		return RxUtil.request(jsonParams,url,tClass,context);
	}
}

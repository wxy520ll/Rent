package xinyi.com.architecture.utils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import xinyi.com.architecture.application.XinYiApplication;

/**
 * Created by wxy on 2017/10/1.
 */

public class OkHttp3Util {

	private static OkHttpClient mOkHttpClient;

	//设置缓存目录

	private static File cacheDirectory = new File(XinYiApplication.path, "MyCache");
	private static Cache cache = new Cache(cacheDirectory, 10 * 1024 * 1024);


	/**
	 * 获取OkHttpClient对象
	 *
	 * @return
	 */
	public static OkHttpClient getOkHttpClient() {

		if (null == mOkHttpClient) {
			mOkHttpClient = new OkHttpClient.Builder()
					//.addInterceptor(new MyIntercepter())
					//.addNetworkInterceptor(new CookiesInterceptor(MyApplication.getInstance().getApplicationContext()))
					//设置请求读写的超时时间
					.connectTimeout(10, TimeUnit.SECONDS)
					.writeTimeout(30, TimeUnit.SECONDS)
					.readTimeout(30, TimeUnit.SECONDS)
					.cache(cache)
					.build();
		}
		return mOkHttpClient;
	}
}

package xinyi.com.architecture.utils;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wxy on 2017/10/1.
 */

public class RetrofitUtil {

	//服务器路径
	private static final String API_SERVER = "http://192.168.1.102:8980";

	private static Retrofit mRetrofit;
	private static OkHttpClient mOkHttpClient;

	/**
	 * 获取Retrofit对象
	 *
	 * @return
	 */
	public static Retrofit getRetrofit() {

		if (null == mRetrofit) {
			if (null == mOkHttpClient) {
				mOkHttpClient = OkHttp3Util.getOkHttpClient();
			}
			mRetrofit = new Retrofit.Builder()
					.baseUrl(API_SERVER + "/")
					.addConverterFactory(GsonConverterFactory.create())
					.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
					.client(mOkHttpClient)
					.build();

		}

		return mRetrofit;
	}
}

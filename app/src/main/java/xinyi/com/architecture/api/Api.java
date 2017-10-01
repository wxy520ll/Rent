package xinyi.com.architecture.api;

import io.reactivex.Observable;
import retrofit2.http.POST;
import xinyi.com.architecture.application.ApiResult;
import xinyi.com.architecture.model.main.BannerData;

/**
 * Created by wxy on 2017/9/30.
 */

public interface Api {

	/**
	 * 获取banner 和item的样式+头条
	 * @return
	 */
	@POST("api/banner/")
	Observable<ApiResult<BannerData>> getBannerData();
}

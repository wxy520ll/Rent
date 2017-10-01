package xinyi.com.architecture.presenter.main;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import xinyi.com.architecture.api.Api;
import xinyi.com.architecture.application.ApiResult;
import xinyi.com.architecture.base.RxPresenter;
import xinyi.com.architecture.model.main.BannerData;
import xinyi.com.architecture.presenter.main.contract.HomeContract;
import xinyi.com.architecture.utils.RetrofitUtil;
import xinyi.com.architecture.utils.RxUtil;

/**
 * Created by wxy on 2017/9/11.
 */

public class HomeFraPresenter extends RxPresenter<HomeContract.HomeFragmentView> implements HomeContract.Presenter {


	@Inject
	public HomeFraPresenter() {

	}

	@Override
	public void requestData() {
		RetrofitUtil.getRetrofit().create(Api.class)
				.getBannerData()
			    .compose(RxUtil.<ApiResult<BannerData>>rxSchedulerHelper(mView))
				.compose(RxUtil.<BannerData>handResult())
				.subscribe(new Consumer<BannerData>() {
					@Override
					public void accept(@NonNull BannerData bannerData) throws Exception {
						String s="123";
					}
				}, new Consumer<Throwable>() {
					@Override
					public void accept(@NonNull Throwable throwable) throws Exception {
						String s="123";
					}
				});




	}
}

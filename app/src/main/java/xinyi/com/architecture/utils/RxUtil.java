package xinyi.com.architecture.utils;

import com.xinyi_tech.commonlibs.util.NetUtil;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import xinyi.com.architecture.application.ApiResult;
import xinyi.com.architecture.application.XinYiApplication;
import xinyi.com.architecture.base.IBaseView;

/**
 * Created by wxy on 2017/10/1.
 */

public class RxUtil {


	public static <T> ObservableTransformer<T, T> rxSchedulerHelper(final IBaseView iBaseView) {
		return upstream -> upstream.filter(t -> {
			if (!NetUtil.isNetworkAvailable(XinYiApplication.xinYiApplication)) {
				ToastUtil.showShort("网络异常");
				return false;
			}
			return true;
		}).doOnSubscribe(disposable -> ToastUtil.showShort("开始请求")).subscribeOn(AndroidSchedulers.mainThread())
				.subscribeOn(AndroidSchedulers.mainThread())
				.unsubscribeOn(AndroidSchedulers.mainThread())
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.doFinally(new Action() {
					@Override
					public void run() throws Exception {
						ToastUtil.showShort("加载完毕");
					}
				});
	}


	public static <T> ObservableTransformer<ApiResult<T>, T>handResult(){
		 return new ObservableTransformer<ApiResult<T>, T>() {
			 @Override
			 public Observable<T> apply(Observable<ApiResult<T>> upstream) {
				 return upstream.flatMap(new Function<ApiResult<T>, Observable<T>>() {
					 @Override
					 public Observable<T> apply(@NonNull ApiResult<T> apiResult) throws Exception {
						 if (apiResult.getCode()==200){
							 Observable.just(apiResult.getData());
						 }else {
							 Observable.error(new Throwable(apiResult.getMessage()));
						 }
						 return Observable.empty();
					 }
				 });
			 }
		 };
	}
}

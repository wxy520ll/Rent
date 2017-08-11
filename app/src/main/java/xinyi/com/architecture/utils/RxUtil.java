package xinyi.com.architecture.utils;

import android.content.Context;
import android.widget.Toast;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.request.base.Request;
import com.lzy.okrx2.adapter.ObservableBody;
import com.xinyi_tech.commonlibs.util.NetUtil;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import xinyi.com.architecture.api.JsonConvert;

/**
 * Created by wxy on 2017/8/8.
 */

public class RxUtil {

	public static  <T>Observable<T> request(String jsonParams, String url,Class<T>tClass,Context context){
		Request<T, ? extends Request> request;
		request= (Request<T, ? extends Request>) OkGo.get(url)
				.params("json",jsonParams);
		request.converter(new JsonConvert<T>());
		return request.adapt(new ObservableBody<T>())
				.compose(rxSchedulerHelper(context));
	}


	public static  <T>ObservableTransformer rxSchedulerHelper(final Context activity){
		return new ObservableTransformer<T, T>() {
			@Override
			public Observable<T> apply(Observable<T>upstream) {
				return upstream
						.filter(new Predicate<Object>() {
							@Override
							public boolean test(@NonNull Object obj) throws Exception {
								if (!NetUtil.isNetworkAvailable(activity)){
									return false;
								}
								return true;
							}
						})
						.doOnSubscribe(new Consumer<Disposable>() {
							@Override
							public void accept(@NonNull Disposable disposable) throws Exception {
								Toast.makeText(activity, "正在加载...", Toast.LENGTH_SHORT).show();
							}
						})
						.subscribeOn(AndroidSchedulers.mainThread())
						.unsubscribeOn(AndroidSchedulers.mainThread())
						.subscribeOn(Schedulers.io())
						.observeOn(AndroidSchedulers.mainThread())
						.doFinally(new Action() {
							@Override
							public void run() throws Exception {
								Toast.makeText(activity, "加载完毕...", Toast.LENGTH_SHORT).show();
							}
						});
			}
		};
	}
}

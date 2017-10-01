package xinyi.com.architecture.presenter;

import android.app.Activity;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import xinyi.com.architecture.activity.main.MainAty;
import xinyi.com.architecture.base.IBaseView;
import xinyi.com.architecture.base.RxPresenter;
import xinyi.com.architecture.utils.IntentUtil;

/**
 * Created by wxy on 2017/9/5.
 */

public class SplashPresenter extends RxPresenter<IBaseView>{

	@Inject
	SplashPresenter() {

	}

	public void after2sToNextAty(final Activity activity) {
		Disposable disposable = Observable.timer(2, TimeUnit.SECONDS)
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Consumer<Long>() {
					@Override
					public void accept(@NonNull Long aLong) throws Exception {
						IntentUtil.startActivity(activity, MainAty.class);
						activity.finish();
					}
				});
		addSubscribe(disposable);
	}

}

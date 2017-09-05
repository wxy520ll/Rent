package xinyi.com.architecture.di.presenter;

import android.app.Activity;

import com.xinyi_tech.commonlibs.util.IntentUtil;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import xinyi.com.architecture.activity.WelComeAty;
import xinyi.com.architecture.base.IBaseView;
import xinyi.com.architecture.base.RxPresenter;

/**
 * Created by wxy on 2017/9/5.
 */

public class SplashPresenter extends RxPresenter<IBaseView>{

	@Inject
	SplashPresenter() {}

	public void after2sToNextAty(final Activity activity) {
		Disposable disposable = Observable.timer(2, TimeUnit.SECONDS)
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Consumer<Long>() {
					@Override
					public void accept(@NonNull Long aLong) throws Exception {
						IntentUtil.startActivity(activity, WelComeAty.class);
						activity.finish();
					}
				});
		addSubscribe(disposable);
	}

}

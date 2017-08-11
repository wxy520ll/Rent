package xinyi.com.architecture.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by codeest on 2016/8/2.
 * 基于Rx的Presenter封装,控制订阅的生命周期
 */
public class RxPresenter<T extends IBaseView> implements BasePresenter<T> {

	protected T mView;
	protected CompositeDisposable mCompositeDisposable;


	protected void addSubscribe(Disposable subscription) {
		if (mCompositeDisposable == null) {
			mCompositeDisposable = new CompositeDisposable();
		}
		mCompositeDisposable.add(subscription);
	}


	@Override
	public void attachView(T view) {
		this.mView = view;
	}

	@Override
	public void detachView() {
		this.mView = null;
		unSubscribe();
	}

	protected void unSubscribe() {
		if (mCompositeDisposable != null) {
			mCompositeDisposable.clear();
		}
	}
}

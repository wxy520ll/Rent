package xinyi.com.architecture.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import xinyi.com.architecture.di.component.ActivityComponent;
import xinyi.com.architecture.di.component.DaggerActivityComponent;
import xinyi.com.architecture.di.module.ActivityModule;

import static xinyi.com.architecture.application.XinYiApplication.xinYiApplication;

/**
 * Created by wxy on 2017/8/11.
 * MVP基类
 */

public abstract  class BaseMvpActivity<T extends BasePresenter>extends BaseActivity  {
	@Inject
	public T presenter;

	private ActivityComponent activityComponent;


	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		inject();
	}

	public abstract void inject();
	public ActivityComponent getActivityComponent(){
		if (activityComponent==null) {
			activityComponent= DaggerActivityComponent.builder()
					.appComponent(xinYiApplication.getAppComponent())
					.activityModule(new ActivityModule(this))
					.build();

		}
		return activityComponent;
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		presenter.detachView();
	}
}

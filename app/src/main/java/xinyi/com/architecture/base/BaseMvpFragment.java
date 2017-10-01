package xinyi.com.architecture.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import javax.inject.Inject;

import butterknife.ButterKnife;
import xinyi.com.architecture.application.XinYiApplication;
import xinyi.com.architecture.di.component.DaggerFragmentComponent;
import xinyi.com.architecture.di.component.FragmentComponent;
import xinyi.com.architecture.di.module.FragmentModule;

/**
 * Created by wxy on 2017/9/11.
 * mvp fragment
 */

public abstract class BaseMvpFragment <T extends RxPresenter> extends BaseFragment implements IBaseView {

	@Inject
	public T presenter;

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		initInject();
		presenter.attachView(this);
	}

	protected FragmentComponent getFragmentComponent(){
		return DaggerFragmentComponent.builder()
				.appComponent(XinYiApplication.xinYiApplication.getAppComponent())
				.fragmentModule(getFragmentModule())
				.build();
	}

	protected FragmentModule getFragmentModule(){
		return new FragmentModule(this);
	}

	public abstract void initInject();

	@Override
	public void onDestroyView() {
		if (presenter != null) presenter.detachView();
		ButterKnife.unbind(this);
		super.onDestroyView();
	}
	@Override
	public void showLoadingDialog() {

	}

	@Override
	public void showNoNetWork() {

	}

	@Override
	public void showLoading() {

	}

	@Override
	public void showLoadFail() {

	}

	@Override
	public void showContentView() {

	}

	@Override
	public void showEmptyView() {

	}
}

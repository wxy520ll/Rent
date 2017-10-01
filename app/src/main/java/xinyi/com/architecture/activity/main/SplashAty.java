package xinyi.com.architecture.activity.main;

import xinyi.com.architecture.R;
import xinyi.com.architecture.base.BaseMvpActivity;
import xinyi.com.architecture.presenter.SplashPresenter;

/**
 * Created by wxy on 2017/9/4.
 */

public class SplashAty extends BaseMvpActivity<SplashPresenter>{

	@Override
	public void inject() {
		getActivityComponent().inject(this);
		presenter.after2sToNextAty(this);
	}

	@Override
	public int getLayoutResource() {
		return R.layout.activity_splash;
	}

	@Override
	public void initView() {

	}

}

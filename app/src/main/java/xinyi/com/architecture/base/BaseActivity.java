package xinyi.com.architecture.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.WindowManager;

/**
 * Created by wxy on 2017/8/11.
 */

public abstract class BaseActivity extends BaseViewActivityImp{

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//进入activity,不自动弹出键盘
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		setContentView(getLayoutResource());
		inject();
		initView();
	}

	/**
	 * 获取布局
	 * @return
	 */
	@LayoutRes
	public abstract int getLayoutResource();

	public abstract void initView();

	public abstract void inject();
}

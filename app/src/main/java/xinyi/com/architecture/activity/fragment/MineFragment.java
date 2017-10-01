package xinyi.com.architecture.activity.fragment;

import xinyi.com.architecture.R;
import xinyi.com.architecture.base.BaseMvpFragment;
import xinyi.com.architecture.presenter.main.MinePresenter;

/**
 * Created by wxy on 2017/9/11.
 */

public class MineFragment extends BaseMvpFragment<MinePresenter>{
	@Override
	public void initInject() {
		getFragmentComponent().inject(this);
	}

	@Override
	public void initView() {

	}

	@Override
	public int getLayoutResource() {
		return R.layout.fragment_me;
	}

}

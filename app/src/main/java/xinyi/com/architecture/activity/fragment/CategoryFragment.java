package xinyi.com.architecture.activity.fragment;

import xinyi.com.architecture.R;
import xinyi.com.architecture.base.BaseMvpFragment;
import xinyi.com.architecture.presenter.main.CategoryFraPresenter;

/**
 * Created by wxy on 2017/9/11.
 */

public class CategoryFragment extends BaseMvpFragment<CategoryFraPresenter> {
	@Override
	public void initInject() {
		getFragmentComponent().inject(this);
	}

	@Override
	public void initView() {

	}

	@Override
	public int getLayoutResource() {
		return R.layout.fragment_category;
	}

}

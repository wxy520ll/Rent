package xinyi.com.architecture.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;

import com.fingdo.statelayout.StateLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import xinyi.com.architecture.R;

/**
 * Created by wxy on 2017/9/5.
 * mvp基类 和非mvp基类的  父类
 */

public abstract class BaseActivity extends AppCompatActivity implements IBaseView,View.OnClickListener{

	@Nullable
	@Bind(R.id.tool_bar)
	public Toolbar toolbar;


	@Nullable
	@Bind(R.id.state_layout)
	public StateLayout stateLayout;


	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
		setContentView(getLayoutResource());
		ButterKnife.bind(this);
		initView();
	}

	@LayoutRes
	public abstract int getLayoutResource();
	public abstract void initView();

	@Override
	public void showLoadingDialog() {

	}

	@Override
	public void showNoNetWork() {
		if (stateLayout!=null)
			stateLayout.showNoNetworkView();
	}

	@Override
	public void showLoading() {
		if (stateLayout!=null)
			stateLayout.showLoadingView();
	}

	@Override
	public void showLoadFail() {
		if (stateLayout!=null)
			stateLayout.showErrorView();
	}

	@Override
	public void showContentView() {
		if (stateLayout!=null)
			stateLayout.showContentView();
	}

	@Override
	public void showEmptyView() {
		if (stateLayout!=null)
			stateLayout.showEmptyView();
	}

	@Override
	public void onClick(View v) {

	}

}
